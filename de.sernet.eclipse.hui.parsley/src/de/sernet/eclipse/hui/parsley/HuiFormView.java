package de.sernet.eclipse.hui.parsley;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry;
import org.eclipse.emf.edit.provider.FeatureMapEntryWrapperItemProvider;
import org.eclipse.emf.edit.provider.WrapperItemProvider;
import org.eclipse.emf.parsley.composite.FormFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;

import com.google.inject.Inject;

public class HuiFormView extends org.eclipse.emf.parsley.views.OnSelectionTreeFormView {
    @Inject
    FormFactory formFactory;

    protected Object getFirstSelectedElement(ISelection selection) {
        return selectionHelper.getFirstSelectedElement(selection);
    }

    @Override
    protected void updateOnSelection(IWorkbenchPart sourcepart, ISelection selection) {
        super.updateOnSelection(sourcepart, selection);
    }

    @Override
    protected EObject getFirstSelectedEObject(ISelection selection) {

        EObject eo = super.getFirstSelectedEObject(selection);
        if (eo == null) {
            eo = getEobject(selection);
        }
        return eo;
    }

    private EObject getEobject(ISelection selection) {
        if (selection instanceof StructuredSelection) {
            StructuredSelection sel = (StructuredSelection) selection;
            Object firstElement = sel.getFirstElement();
            if (firstElement instanceof FeatureMapEntryWrapperItemProvider) {
                FeatureMapEntryWrapperItemProvider p = (FeatureMapEntryWrapperItemProvider) firstElement;
                Object value = p.getValue();
                if (value instanceof ContainmentUpdatingFeatureMapEntry) {
                    ContainmentUpdatingFeatureMapEntry e = (ContainmentUpdatingFeatureMapEntry) value;
                    Object value2 = e.getValue();
                    return (EObject) value2;
                } else if (value instanceof EObject) {
                    return (EObject) value;
                }

            } else if (firstElement instanceof WrapperItemProvider) {
                WrapperItemProvider ip = (WrapperItemProvider) firstElement;
                return (EObject) ip.getValue();
            }
        }
        System.out.println("unhandled selection:" + selection);

        return null;
    }

}
