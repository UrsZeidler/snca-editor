/**
 * 
 */
package de.sernet.eclipse.hui.ui.exportWizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

import de.sernet.eclipse.hui.ui.importWizards.ImportSNCAWizardPage;

/**
 * @author urszeidler
 *
 */
public class ExportSNCAWizard extends Wizard implements IExportWizard {

	private ExportSNCAWizardPage mainPage;

	/**
	 * 
	 */
	public ExportSNCAWizard() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("File Import Wizard"); //NON-NLS-1
		setNeedsProgressMonitor(true);
		mainPage = new ExportSNCAWizardPage("Import SNCA XML File",selection); //NON-NLS-1
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		IFile file = mainPage.createNewFile();
        if (file == null)
            return false;
        return true;
	}

	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.IWizard#addPages()
     */
    public void addPages() {
        super.addPages(); 
        addPage(mainPage);        
    }

}
