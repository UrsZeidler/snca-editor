/**
 * 
 */
package de.sernet.eclipse.hui.ui.exportWizards;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

import de.sernet.eclipse.hui.ui.Activator;

/**
 * @author urszeidler
 *
 */
public class ExportSNCAWizard extends Wizard implements IExportWizard {
    public static final String EXPORT_WIZARD = "EXPORT_WIZARD";
    public static final String TARGET_FILE = "TARGET_FILE";
    private ExportSNCAWizardPage mainPage;

    /**
     * 
     */
    public ExportSNCAWizard() {
        setDialogSettings(Activator.getDefault().getDialogSettings());
        initalizeDialogSettings();
    }

    private void initalizeDialogSettings() {
        IDialogSettings section = getDialogSettings().getSection(EXPORT_WIZARD);
        if (section == null) {
            IDialogSettings newSection = getDialogSettings().addNewSection(EXPORT_WIZARD);
            newSection.put(ExportSNCAWizard.TARGET_FILE, "");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
     * org.eclipse.jface.viewers.IStructuredSelection)
     */
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle("SNCA Export Wizard");
        setNeedsProgressMonitor(true);
        mainPage = new ExportSNCAWizardPage(selection);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    @Override
    public boolean performFinish() {
        try {
            mainPage.saveFile();
        } catch (CoreException | IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages();
        addPage(mainPage);
    }

}
