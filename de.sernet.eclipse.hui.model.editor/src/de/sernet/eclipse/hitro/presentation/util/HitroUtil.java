/**
 * 
 * Copyright (c) 2017 Urs Zeidler.
 * 
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Urs Zeidler uz[at]sernet.de - initial API and implementation
 */
package de.sernet.eclipse.hitro.presentation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.ContainmentUpdatingFeatureMapEntry;
import org.eclipse.emf.edit.provider.FeatureMapEntryWrapperItemProvider;
import org.eclipse.emf.edit.provider.WrapperItemProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

public class HitroUtil {

    public static IDoubleClickListener unwrapedDoubleClickListener(
            final IDoubleClickListener listener) {

        return new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                ISelection selection = unwrapSelection(event.getSelection());
                DoubleClickEvent doubleClickEvent = new DoubleClickEvent(event.getViewer(),
                        selection);
                listener.doubleClick(doubleClickEvent);
            }
        };

    }

    public static ISelection unwrapSelection(ISelection selection) {
        EObject eobject = getEobject(selection);
        return eobject == null ? new StructuredSelection() : new StructuredSelection(eobject);

    }

    private static EObject getEobject(ISelection selection) {
        if (selection instanceof StructuredSelection) {
            StructuredSelection sel = (StructuredSelection) selection;
            Object firstElement = sel.getFirstElement();
            if (firstElement instanceof EObject) {
                return (EObject) firstElement;
            }
            if (firstElement instanceof FeatureMapEntryWrapperItemProvider) {
                FeatureMapEntryWrapperItemProvider p = (FeatureMapEntryWrapperItemProvider) firstElement;
                Object value = p.getValue();
                if (value instanceof ContainmentUpdatingFeatureMapEntry) {
                    ContainmentUpdatingFeatureMapEntry e = (ContainmentUpdatingFeatureMapEntry) value;
                    Object value2 = e.getValue();
                    if (value2 instanceof EObject) {
                        return (EObject) value2;
                    }
                } else if (value instanceof EObject) {
                    return (EObject) value;
                }

            } else if (firstElement instanceof WrapperItemProvider) {
                WrapperItemProvider ip = (WrapperItemProvider) firstElement;
                Object value = ip.getValue();
                if (value instanceof EObject) {
                    return (EObject) value;
                }
            }
        }
        System.out.println("unhandled selection:" + selection);

        return null;
    }

}
