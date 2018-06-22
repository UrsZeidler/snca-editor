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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public interface HuirelationPropertiesEditionPart {

    /**
     * @return the id
     * 
     */
    public String getId();

    /**
     * Defines a new id
     * 
     * @param newValue
     *            the new id to set
     * 
     */
    public void setId(String newValue);

    /**
     * @return the name
     * 
     */
    public String getName();

    /**
     * Defines a new name
     * 
     * @param newValue
     *            the new name to set
     * 
     */
    public void setName(String newValue);

    /**
     * @return the reversename
     * 
     */
    public String getReversename();

    /**
     * Defines a new reversename
     * 
     * @param newValue
     *            the new reversename to set
     * 
     */
    public void setReversename(String newValue);

    /**
     * @return the to
     * 
     */
    public EObject getTo();

    /**
     * Init the to
     * 
     * @param settings
     *            the combo setting
     */
    public void initTo(EObjectFlatComboSettings settings);

    /**
     * Defines a new to
     * 
     * @param newValue
     *            the new to to set
     * 
     */
    public void setTo(EObject newValue);

    /**
     * Defines the button mode
     * 
     * @param newValue
     *            the new mode to set
     * 
     */
    public void setToButtonMode(ButtonsModeEnum newValue);

    /**
     * Adds the given filter to the to edition editor.
     * 
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     * 
     */
    public void addFilterToTo(ViewerFilter filter);

    /**
     * Adds the given filter to the to edition editor.
     * 
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     * 
     */
    public void addBusinessFilterToTo(ViewerFilter filter);

    /**
     * @return the tooltip
     * 
     */
    public String getTooltip();

    /**
     * Defines a new tooltip
     * 
     * @param newValue
     *            the new tooltip to set
     * 
     */
    public void setTooltip(String newValue);

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
