package de.sernet.eclipse.hui.ui.exportWizards;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

import de.sernet.eclipse.hui.service.localization.lang.HitropPropertiesUtil;

public class ExportSNCAWizardPage extends WizardPage {

    private Text sourceFileText;
    private Text targetFileText;
    private IStructuredSelection selection;
    private IFile sourceFile;
    private File targetFile;

    /**
     * Create the wizard.
     * 
     * @wbp.parser.constructor
     */
    public ExportSNCAWizardPage() {
        super("wizardPage");
        setTitle("Wizard Page title");
        setDescription("Wizard Page description");
    }

    public ExportSNCAWizardPage(IStructuredSelection selection) {
        this();
        this.selection = selection;
    }

    /**
     * Create contents of the wizard.
     * 
     * @param parent
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);

        setControl(container);
        container.setLayout(new GridLayout(1, false));

        Group grpSource = new Group(container, SWT.NONE);
        grpSource.setText("export");
        grpSource.setLayout(new GridLayout(3, false));
        grpSource.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label lblNewLabel = new Label(grpSource, SWT.NONE);
        lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel.setText("source file");

        sourceFileText = new Text(grpSource, SWT.BORDER);
        sourceFileText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                pageComplete();
            }
        });
        sourceFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Button btnNewButton = new Button(grpSource, SWT.NONE);
        btnNewButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ResourceSelectionDialog dialog = new ResourceSelectionDialog(getShell(),
                        ResourcesPlugin.getWorkspace().getRoot(), "Select hitro file.");
                IResource member = ResourcesPlugin.getWorkspace().getRoot()
                        .findMember(sourceFileText.getText());
                List<?> selectedElements = Collections.singletonList(member);
                dialog.setInitialElementSelections(selectedElements);
                int open = dialog.open();
                if (open == SWT.OK) {
                    Object[] result = dialog.getResult();
                    if (result.length > 0) {
                        Object object = result[0];
                        sourceFileText.setText((String) object);
                    }
                    pageComplete();
                }
            }
        });
        btnNewButton.setText("select");

        IDialogSettings section = getDialogSettings().getSection(ExportSNCAWizard.EXPORT_WIZARD);
        String targetfile = section.get(ExportSNCAWizard.TARGET_FILE);

        Label lblNewLabel1 = new Label(grpSource, SWT.NONE);
        lblNewLabel1.setText("target file");

        targetFileText = new Text(grpSource, SWT.BORDER);
        targetFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        targetFileText.setText(targetfile);

        Button btnNewButton1 = new Button(grpSource, SWT.NONE);
        btnNewButton1.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog fileDialog = new FileDialog(getShell(), SWT.SAVE);
                fileDialog.setFileName("SNCA.xml");
                String open = fileDialog.open();
                if (open != null) {
                    targetFileText.setText(open);
                    targetFile = new File(open);
                    pageComplete();
                }
            }
        });
        btnNewButton1.setText("select");

        if (selection != null) {
            Object element = selection.getFirstElement();
            if (element instanceof IFile) {
                IFile f = (IFile) element;
                sourceFileText.setText(f.getFullPath().toString());
                sourceFile = f;
            }
        }
    }

    protected void pageComplete() {
        String source = sourceFileText.getText();
        String target = targetFileText.getText();

        File file = new File(target);
        if (file.exists()) {
            setMessage("File exist and will be overridden.");
        }
        IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(source);
        if (member == null || !member.exists()) {
            setMessage("Source fle don't exist.");
        }
    }

    protected void saveFile() throws CoreException, IOException {
        targetFile = new File(targetFileText.getText());
        sourceFile = ResourcesPlugin.getWorkspace().getRoot()
                .getFile(new Path(sourceFileText.getText()));

        IDialogSettings section = getDialogSettings().getSection(ExportSNCAWizard.EXPORT_WIZARD);
        section.put(ExportSNCAWizard.TARGET_FILE, targetFile.getAbsolutePath());

        HitropPropertiesUtil.exportSncaFlies(sourceFile, targetFile);
    }
}
