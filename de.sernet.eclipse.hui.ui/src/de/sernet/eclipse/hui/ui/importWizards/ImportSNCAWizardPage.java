package de.sernet.eclipse.hui.ui.importWizards;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class ImportSNCAWizardPage extends WizardNewFileCreationPage {

    protected FileFieldEditor editor;
    protected String orgFilename;

    public ImportSNCAWizardPage(String pageName, IStructuredSelection selection) {
        super(pageName, selection);
        setTitle(pageName); // NON-NLS-1
        setDescription("Import a SNCA from the local file system into the workspace"); // NON-NLS-1
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.dialogs.WizardNewFileCreationPage#createAdvancedControls(
     * org. eclipse.swt.widgets.Composite)
     */
    protected void createAdvancedControls(Composite parent) {
        Composite fileSelectionArea = new Composite(parent, SWT.NONE);
        GridData fileSelectionData = new GridData(
                GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
        fileSelectionArea.setLayoutData(fileSelectionData);

        GridLayout fileSelectionLayout = new GridLayout();
        fileSelectionLayout.numColumns = 3;
        fileSelectionLayout.makeColumnsEqualWidth = false;
        fileSelectionLayout.marginWidth = 0;
        fileSelectionLayout.marginHeight = 0;
        fileSelectionArea.setLayout(fileSelectionLayout);

        editor = new FileFieldEditor("fileSelect", "Select File: ", fileSelectionArea); // NON-NLS-1
                                                                                        // //NON-NLS-2
        String inputFileName = getDialogSettings().get("input.file.name");
        String outfile = getDialogSettings().get("output.file.name");
        if (outfile != null) {
            setFileName(outfile);
        }
        editor.setStringValue(inputFileName);
        editor.getTextControl(fileSelectionArea).addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                String fullPath = ImportSNCAWizardPage.this.editor.getStringValue();
                IPath path = new Path(fullPath);
                String lastSegment = path.removeFileExtension().lastSegment();
                String filename = lastSegment + ".hitro";
                setFileName(filename);
                orgFilename = path.toString();
                getDialogSettings().put("input.file.name", fullPath);
                getDialogSettings().put("output.file.name", filename);
            }
        });
        String[] extensions = new String[] { "*.xml", "*.*" }; // NON-NLS-1
        editor.setFileExtensions(extensions);
        fileSelectionArea.moveAbove(null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createLinkTarget()
     */
    protected void createLinkTarget() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.dialogs.WizardNewFileCreationPage#getInitialContents()
     */
    protected InputStream getInitialContents() {
        IPath containerFullPath = getContainerFullPath();
        IResource findContainersForLocation = ResourcesPlugin.getWorkspace().getRoot()
                .findMember(containerFullPath);
        IProject project = findContainersForLocation.getProject();
        try {
            String defaultCharset = "UTF-8";//project.getDefaultCharset();
            FileInputStream fileInputStream = new FileInputStream(
                    new File(editor.getStringValue()));
            BufferedReader d = new BufferedReader(
                    new InputStreamReader(fileInputStream, defaultCharset));
            try {
                String collect = d.lines().collect(Collectors.joining("\n"));
                collect = collect.replaceAll("huientities", "hitro:huientities");
                collect = collect.replaceFirst("xmlns=", "xmlns:hitro=");

                return new ByteArrayInputStream(collect.getBytes(defaultCharset));
            } finally {
                d.close();
            }
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#getNewFileLabel()
     */
    protected String getNewFileLabel() {
        return "New File Name:"; // NON-NLS-1
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.dialogs.WizardNewFileCreationPage#validateLinkedResource()
     */
    protected IStatus validateLinkedResource() {
        return new Status(IStatus.OK, "de.sernet.eclipse.hui.ui", IStatus.OK, "", null); // NON-NLS-1
    }

    public String getOrgFilename() {
        return orgFilename;
    }
}
