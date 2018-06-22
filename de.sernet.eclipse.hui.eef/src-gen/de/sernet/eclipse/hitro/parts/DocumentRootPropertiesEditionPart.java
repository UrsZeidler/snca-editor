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
package de.sernet.eclipse.hitro.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public interface DocumentRootPropertiesEditionPart {

    /**
     * @return the mixed
     * 
     */
    public EList getMixed();

    /**
     * Defines a new mixed
     * 
     * @param newValue
     *            the new mixed to set
     * 
     */
    public void setMixed(EList newValue);

    /**
     * Add a value to the mixed multivalued attribute.
     * 
     * @param newValue
     *            the value to add
     */
    public void addToMixed(Object newValue);

    /**
     * Remove a value to the mixed multivalued attribute.
     * 
     * @param newValue
     *            the value to remove
     */
    public void removeToMixed(Object newValue);

    /**
     * Returns the internationalized title text.
     * 
     * @return the internationalized title text.
     * 
     */
    public String getTitle();

    // Start of user code for additional methods

    // End of user code

}
