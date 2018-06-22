package de.sernet.eclipse.hui.ui.importWizards;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IDE;

import de.sernet.eclipse.hui.service.localization.lang.HitropPropertiesUtil;
import de.sernet.eclipse.hui.ui.Activator;

public class ImportSNCAWizard extends Wizard implements IImportWizard {
	
	ImportSNCAWizardPage mainPage;

	public ImportSNCAWizard() {
		super();
	       IDialogSettings workbenchSettings = Activator.getDefault()
	                .getDialogSettings();
	        IDialogSettings wizardSettings = workbenchSettings
	                .getSection("ImportSNCAWizard"); //$NON-NLS-1$
	        if (wizardSettings == null) {
	            wizardSettings = workbenchSettings.addNewSection("ImportSNCAWizard"); //$NON-NLS-1$
	        }
	        setDialogSettings(wizardSettings);
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		final IFile file = mainPage.createNewFile();
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			
			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException, InterruptedException {
				File source = new File(mainPage.getOrgFilename());
				String fileBasePath = HitropPropertiesUtil.fileBasePath(source);
				String platformBasePath = HitropPropertiesUtil.platformBasePath(file);
				for (String lang : HitropPropertiesUtil.LANGS) {
					File targetFile = HitropPropertiesUtil.TO_WORKSPACE_FILE.toFile(platformBasePath + lang);
					File sourceFile = HitropPropertiesUtil.TO_FILE.toFile(fileBasePath + lang);
					try {
						Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						throw new CoreException(Status.CANCEL_STATUS);
					}
				}
			}
		};
		
		try {
			new ProgressMonitorDialog(getShell()).run(false, false, operation);
			
		} catch (InvocationTargetException | InterruptedException e) {
			Activator.logError("Error copy properties.", e);
		}
		
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			IDE.openEditor(activePage, file, "de.sernet.eclipse.hitro.presentation.HitroEditorID");
			file.getParent().isSynchronized(2);
			file.getParent().refreshLocal(2, null);
		} catch (CoreException e) {
			Activator.logError("Error open editor.", e);
		}
		
        if (file == null)
            return false;
        return true;
	}
	 
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("File Import Wizard"); //NON-NLS-1
		setNeedsProgressMonitor(true);
		mainPage = new ImportSNCAWizardPage("Import SNCA XML File",selection); //NON-NLS-1
	}

	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages(); 
        addPage(mainPage);        
    }

}
