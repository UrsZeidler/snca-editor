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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public interface DefaultRulePropertiesEditionPart {

    /**
     * Init the param
     * 
     * @param current
     *            the current value
     * @param containgFeature
     *            the feature where to navigate if necessary
     * @param feature
     *            the feature to manage
     */
    public void initParam(ReferencesTableSettings settings);

    /**
     * Update the param
     * 
     * @param newValue
     *            the param to update
     * 
     */
    public void updateParam();

    /**
     * Adds the given filter to the param edition editor.
     * 
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     * 
     */
    public void addFilterToParam(ViewerFilter filter);

    /**
     * Adds the given filter to the param edition editor.
     * 
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     * 
     */
    public void addBusinessFilterToParam(ViewerFilter filter);

    /**
     * @return true if the given element is contained inside the param table
     * 
     */
    public boolean isContainedInParamTable(EObject element);

    /**
     * @return the class
     * 
     */
    public String getClass_();

    /**
     * Defines a new class
     * 
     * @param newValue
     *            the new class to set
     * 
     */
    public void setClass_(String newValue);

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
