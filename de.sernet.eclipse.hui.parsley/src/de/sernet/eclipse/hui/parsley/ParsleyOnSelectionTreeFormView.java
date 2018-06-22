package de.sernet.eclipse.hui.parsley;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry;
import org.eclipse.emf.edit.provider.FeatureMapEntryWrapperItemProvider;
import org.eclipse.emf.edit.provider.WrapperItemProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;

public class ParsleyOnSelectionTreeFormView extends org.eclipse.emf.parsley.views.OnSelectionTreeFormView {
	
	
	
	
	@Override
	protected EObject getFirstSelectedEObject(ISelection selection) {
		return super.getFirstSelectedEObject(selection);
	}
	
	@Override
	protected void updateOnSelection(IWorkbenchPart sourcepart, ISelection selection) {
		selection = getTransformSelection(selection);
		super.updateOnSelection(sourcepart, selection);
	}

	protected Object getFirstSelectedElement(ISelection selection) {
		return selectionHelper.getFirstSelectedElement(selection);
	}

	
	private ISelection getTransformSelection(ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection sel = (StructuredSelection) selection;
			Object firstElement = sel.getFirstElement();
			if (firstElement instanceof FeatureMapEntryWrapperItemProvider) {
				FeatureMapEntryWrapperItemProvider p = (FeatureMapEntryWrapperItemProvider) firstElement;
				Object value = p.getValue();
				if (value instanceof ContainmentUpdatingFeatureMapEntry) {
					ContainmentUpdatingFeatureMapEntry e = (ContainmentUpdatingFeatureMapEntry) value;
						Object value2 = e.getValue();
						StructuredSelection structuredSelection = new StructuredSelection(value2);
						return structuredSelection;
				}else if (value instanceof EObject) {
					return new StructuredSelection(value);
				}
				
			}else if (firstElement instanceof WrapperItemProvider) {
				WrapperItemProvider ip = (WrapperItemProvider) firstElement;
				return new StructuredSelection(ip.getValue());
			}
		}
		return selection;
	}

	
}
