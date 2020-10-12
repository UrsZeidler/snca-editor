/**
 * 
 */
package de.sernet.eclipse.hui.commandline;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicEAnnotationValidator.ValidationContext;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.ui.PlatformUI;

import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hui.model.codegen.main.GenerateHuiModelReport;
import de.sernet.eclipse.hui.model.codegen.main.GenerateJavaCode;
import de.sernet.eclipse.hui.model.codegen.main.GenerateMarkdown;
import de.sernet.eclipse.hui.model.validation.EValidatorAdapter;
import de.sernet.eclipse.hui.model.validation.contrains.TestNameLocalized;
import de.sernet.eclipse.hui.model.validation.contrains.TestRestLocalized;
import de.sernet.eclipse.hui.service.localization.LocalizationService;
import de.sernet.eclipse.hui.service.localization.LocalizationServiceImpl;
import de.sernet.eclipse.hui.service.localization.lang.HitropPropertiesUtil;
import de.sernet.eclipse.hui.service.localization.lang.LanguagesEntry;

/**
 * @author urszeidler
 *
 */
public class CommandlineRunner implements IApplication {
    private boolean doValidation = true;
    private int validationLevel = Diagnostic.INFO;
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	@Override
	public Object start(IApplicationContext context) throws Exception {
		String[] args = (String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
		Options options = buildCommandline();
		CommandLineParser parser = new BasicParser();

		CommandLine commandLine = parser.parse(options, args);
		if(commandLine.hasOption("validate")) {
		    doValidation = true;
		    String[] values = commandLine.getOptionValues("validate");
		    String level = values[0];
		    switch (level) {
            case "WARNING":
                validationLevel = Diagnostic.WARNING;
                break;
            case "ERROR":
                validationLevel = Diagnostic.ERROR;
                break;
            default:
                validationLevel = Diagnostic.INFO;
                break;
            }
		}
		if(commandLine.hasOption('h')){
			printHelp(options);
			
		}else if (commandLine.hasOption('i')) {
			IProgressMonitor monitor = new NullProgressMonitor();
			String[] values = commandLine.getOptionValues('i');
			
			String orgFilename = values[0];
			IProject project = getProject(monitor);
			IFile file = project.getFile("snca.hitro");
			URI importSncaXML = importSncaXML(monitor, file, orgFilename);
			
			doGenerationOptions(commandLine,project,importSncaXML,monitor,file);
			System.out.println("Refresh workspace");
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(2, monitor);
		}else if (commandLine.hasOption('l')) {
			//load a hitro model
		}
		
		Integer returnValue = 0;
		return returnValue;
	}

	private void doGenerationOptions(CommandLine commandLine, IProject project, URI importSncaXML, IProgressMonitor monitor, IFile sncaHitroFile) throws IOException, CoreException {
		if(commandLine.hasOption("generateJava")) {
			System.out.println("Generating java");
			generateJavaCode(monitor, project, importSncaXML);
		}
		if(commandLine.hasOption("generateMarkdown")) {
			System.out.println("generate markdown");
			generateMarkdown(monitor, project, importSncaXML);
		}
		if(commandLine.hasOption("generateWiki")) {
			System.out.println("generate wiki");
			generateWiki(monitor, project, importSncaXML);
		}
		if(commandLine.hasOption("export")) {
			System.out.println("export snca");
			doExport(monitor, project, sncaHitroFile);
		}
		
	}

    protected void printDiagnostic(Diagnostic diagnostic, String indent) {
        if (diagnostic.getSeverity() >= validationLevel) {
            System.out.print(indent);
            System.out.println(diagnostic.getSeverity()+" " + diagnostic.getMessage());

        }
        for (Diagnostic child : diagnostic.getChildren()) {
            printDiagnostic(child, indent + "  ");
        }
    }
	
	private void doExport(IProgressMonitor monitor, IProject project, IFile sncaHitroFile) throws CoreException, IOException {
		IContainer target = project.getFolder("export");
		IContainer targetFolder = target;
		
		if (!targetFolder.getLocation().toFile().exists()) {
			targetFolder.getLocation().toFile().mkdirs();
		}
		File file = targetFolder.getLocation().toFile();
		File targetFile = new File(file, "SNCA.xml");
		
		HitropPropertiesUtil.exportSncaFlies(sncaHitroFile, targetFile);
		
	}

	@SuppressWarnings("static-access")
	private Options buildCommandline() {
		Options options = new Options();
		OptionGroup optionGroup = new OptionGroup();
		optionGroup.setRequired(true);
		Option option = OptionBuilder
				.withDescription("import a snca to hitro and performs the operations")//
				.withValueSeparator()//
				.withArgName("inputfile")//
				.hasArgs(1)//
				.create('i');
		optionGroup.addOption(option);
		
		option = OptionBuilder
				.withDescription("load a hitrofile and performs the operations")//
				.withValueSeparator()//
				.withArgName("inputfile")//
				.hasArgs(1)//
				.create('l');
		optionGroup.addOption(option);
		
//		BasicParser basicParser = new BasicParser();
		
		optionGroup.addOption(OptionBuilder//
				.withDescription("display help")//
				.create('h'));
		
		options.addOption(OptionBuilder//
				.withDescription("generate java")//
				.create("generateJava"));
		
		options.addOption(OptionBuilder//
				.withDescription("generate markdown")//
				.create("generateMarkdown"));
		
		options.addOption(OptionBuilder//
				.withDescription("generate wiki")//
				.create("generateWiki"));
		
        options.addOption(OptionBuilder//
                .withDescription("export to snca")//
                .create("export"));
        
        options.addOption(OptionBuilder//
                .withDescription("validate and report <level> one of INFO|WARNING|ERROR")//
                .withValueSeparator()//
                .withArgName("level")//
                .hasArgs(1)//
                .create("validate"));
        
		options.addOptionGroup(optionGroup);
		return options;
	}

	/**
	 * @param options
	 */
	private static void printHelp(Options options) {

		StringBuffer buffer = new StringBuffer();
		buffer.append("some basic example\n")//
				.append("\n");

		HelpFormatter formatter = new HelpFormatter();
		String header = "\nImport export and generation for the snca. (c) Urs Zeidler 2017/n";
		String footer = "\nexample: \n\n" + buffer.toString();
		formatter.printHelp(150, "snca editor command line", header, options, footer, true);
}
	
	private void generateJavaCode(IProgressMonitor monitor, IProject project, URI importSncaXML) throws IOException {
		IContainer target = project.getFolder("src-gen");
		IContainer targetFolder = target;
		
		if (!targetFolder.getLocation().toFile().exists()) {
			targetFolder.getLocation().toFile().mkdirs();
		}
		GenerateJavaCode generateJavaCode = new GenerateJavaCode(importSncaXML, targetFolder.getLocation().toFile(), Collections.emptyList());
		generateJavaCode.doGenerate(BasicMonitor.toMonitor(monitor));
	}

	private void generateWiki(IProgressMonitor monitor, IProject project, URI importSncaXML) throws IOException {
		IContainer target = project.getFolder("src-gen");
		IContainer targetFolder = target;
		
		if (!targetFolder.getLocation().toFile().exists()) {
			targetFolder.getLocation().toFile().mkdirs();
		}
		GenerateHuiModelReport generateJavaCode = new GenerateHuiModelReport(importSncaXML, targetFolder.getLocation().toFile(), Collections.emptyList());
		generateJavaCode.doGenerate(BasicMonitor.toMonitor(monitor));
	}

	private void generateMarkdown(IProgressMonitor monitor, IProject project, URI importSncaXML) throws IOException {
		IContainer target = project.getFolder("src-gen");
		IContainer targetFolder = target;
		
		if (!targetFolder.getLocation().toFile().exists()) {
			targetFolder.getLocation().toFile().mkdirs();
		}
		GenerateMarkdown generateJavaCode = new GenerateMarkdown(importSncaXML, targetFolder.getLocation().toFile(), Collections.emptyList());
		generateJavaCode.doGenerate(BasicMonitor.toMonitor(monitor));
	}

	private URI importSncaXML(IProgressMonitor monitor, IFile file, String orgFilename)
			throws CoreException, IOException {
		ByteArrayInputStream transformSnca = HitropPropertiesUtil.transformSnca(orgFilename);
		if (!file.exists()) {
			file.create(transformSnca, true, monitor);
		} else
			file.setContents(transformSnca, true, false, monitor);

		EValidator.Registry.INSTANCE.put(HitroPackage.eINSTANCE, new EValidatorAdapter());
		HitropPropertiesUtil.importSncaInWorkspace(file, orgFilename);

		ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
		URI resourceURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Resource resource = resourceSetImpl.getResource(resourceURI, true);
		Map<?, ?> options = new HashMap<>();
		resource.load(options);

		//TODO need another kind of service
		LocalizationService localizationService = new LocalizationServiceImpl();//PlatformUI.getWorkbench().getService(LocalizationService.class);
        if (doValidation) {
            TestNameLocalized.localizationServiceRuntime = localizationService;
            TestRestLocalized.localizationServiceRuntime = localizationService;
            for (EObject eObject : resource.getContents()) {
                Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
                if (diagnostic.getSeverity() != Diagnostic.OK) {
                    printDiagnostic(diagnostic, "");
                }
            }
        }
		
	//	ServiceLocator serviceLocator = new ServiceLocator();
		Map<EObject, LanguagesEntry> entryMap = localizationService.getLanguageEntries(resource);
        String basePath = HitropPropertiesUtil.platformBasePath(file);

        HitropPropertiesUtil.syncPropertyFile(resource, basePath, entryMap,
                HitropPropertiesUtil.TO_WORKSPACE_FILE);

		resource.save(options);
		return resourceURI;
	}

	private IProject getProject(IProgressMonitor monitor) throws CoreException {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		if(!PlatformUI.isWorkbenchRunning()){
		    //PlatformUI.createAndRunWorkbench(display, advisor);
		}
		
		
		IWorkspaceRoot root = workspace.getRoot();
		root.refreshLocal(10, monitor);
		IProjectDescription projectDescription = workspace.newProjectDescription("importProject");
		IProject project = root.getProject("importProject");
		if (!project.exists())
			project.create(projectDescription, monitor);
		if (!project.isOpen())
			project.open(monitor);
		return project;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
