package de.sernet.eclipse.hui.ui.exportWizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class ExportSNCAWizardPage extends WizardNewFileCreationPage{

	public ExportSNCAWizardPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
		setTitle(pageName); //NON-NLS-1
		setDescription("Import a SNCA from the local file system into the workspace"); //NON-NLS-1
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#createAdvancedControls(org.eclipse.swt.widgets.Composite)
	 */	
	protected void createAdvancedControls(Composite parent) {
		Composite fileSelectionArea = new Composite(parent, SWT.NONE);
		GridData fileSelectionData = new GridData(GridData.GRAB_HORIZONTAL
				| GridData.FILL_HORIZONTAL);
		fileSelectionArea.setLayoutData(fileSelectionData);

		GridLayout fileSelectionLayout = new GridLayout();
		fileSelectionLayout.numColumns = 3;
		fileSelectionLayout.makeColumnsEqualWidth = false;
		fileSelectionLayout.marginWidth = 0;
		fileSelectionLayout.marginHeight = 0;
		fileSelectionArea.setLayout(fileSelectionLayout);
		
//		editor = new FileFieldEditor("fileSelect","Select File: ",fileSelectionArea); //NON-NLS-1 //NON-NLS-2
//		editor.getTextControl(fileSelectionArea).addModifyListener(new ModifyListener(){
//			public void modifyText(ModifyEvent e) {
//				IPath path = new Path(ImportSNCAWizardPage.this.editor.getStringValue());
//				String lastSegment = path.removeFileExtension().lastSegment();
//				setFileName(lastSegment+".hitro");
//			}
//		});
//		String[] extensions = new String[] { "*.xml","*.*" }; //NON-NLS-1
//		editor.setFileExtensions(extensions);
//		fileSelectionArea.moveAbove(null);

	}

}
