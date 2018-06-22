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
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public interface HuipropertyPropertiesEditionPart {

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
     * @return the inputtype
     * 
     */
    public Enumerator getInputtype();

    /**
     * Init the inputtype
     * 
     * @param input
     *            the viewer input
     * @param current
     *            the current value
     */
    public void initInputtype(Object input, Enumerator current);

    /**
     * Defines a new inputtype
     * 
     * @param newValue
     *            the new inputtype to set
     * 
     */
    public void setInputtype(Enumerator newValue);

    /**
     * @return the isURL
     * 
     */
    public Boolean getIsURL();

    /**
     * Defines a new isURL
     * 
     * @param newValue
     *            the new isURL to set
     * 
     */
    public void setIsURL(Boolean newValue);

    /**
     * @return the min
     * 
     */
    public String getMin();

    /**
     * Defines a new min
     * 
     * @param newValue
     *            the new min to set
     * 
     */
    public void setMin(String newValue);

    /**
     * @return the max
     * 
     */
    public String getMax();

    /**
     * Defines a new max
     * 
     * @param newValue
     *            the new max to set
     * 
     */
    public void setMax(String newValue);

    /**
     * @return the crudButtons
     * 
     */
    public Boolean getCrudButtons();

    /**
     * Defines a new crudButtons
     * 
     * @param newValue
     *            the new crudButtons to set
     * 
     */
    public void setCrudButtons(Boolean newValue);

    /**
     * @return the defaultValue
     * 
     */
    public String getDefaultValue();

    /**
     * Defines a new defaultValue
     * 
     * @param newValue
     *            the new defaultValue to set
     * 
     */
    public void setDefaultValue(String newValue);

    /**
     * @return the editable
     * 
     */
    public Boolean getEditable();

    /**
     * Defines a new editable
     * 
     * @param newValue
     *            the new editable to set
     * 
     */
    public void setEditable(Boolean newValue);

    /**
     * @return the focus
     * 
     */
    public Boolean getFocus();

    /**
     * Defines a new focus
     * 
     * @param newValue
     *            the new focus to set
     * 
     */
    public void setFocus(Boolean newValue);

    /**
     * @return the report
     * 
     */
    public Boolean getReport();

    /**
     * Defines a new report
     * 
     * @param newValue
     *            the new report to set
     * 
     */
    public void setReport(Boolean newValue);

    /**
     * @return the required
     * 
     */
    public Boolean getRequired();

    /**
     * Defines a new required
     * 
     * @param newValue
     *            the new required to set
     * 
     */
    public void setRequired(Boolean newValue);

    /**
     * @return the showInObjectBrowser
     * 
     */
    public Boolean getShowInObjectBrowser();

    /**
     * Defines a new showInObjectBrowser
     * 
     * @param newValue
     *            the new showInObjectBrowser to set
     * 
     */
    public void setShowInObjectBrowser(Boolean newValue);

    /**
     * @return the tags
     * 
     */
    public String getTags();

    /**
     * Defines a new tags
     * 
     * @param newValue
     *            the new tags to set
     * 
     */
    public void setTags(String newValue);

    /**
     * @return the textrows
     * 
     */
    public String getTextrows();

    /**
     * Defines a new textrows
     * 
     * @param newValue
     *            the new textrows to set
     * 
     */
    public void setTextrows(String newValue);

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
     * @return the visible
     * 
     */
    public Boolean getVisible();

    /**
     * Defines a new visible
     * 
     * @param newValue
     *            the new visible to set
     * 
     */
    public void setVisible(Boolean newValue);

    /**
     * Init the depends
     * 
     * @param current
     *            the current value
     * @param containgFeature
     *            the feature where to navigate if necessary
     * @param feature
     *            the feature to manage
     */
    public void initDepends(ReferencesTableSettings settings);

    /**
     * Update the depends
     * 
     * @param newValue
     *            the depends to update
     * 
     */
    public void updateDepends();

    /**
     * Adds the given filter to the depends edition editor.
     * 
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     * 
     */
    public void addFilterToDepends(ViewerFilter filter);

    /**
     * Adds the given filter to the depends edition editor.
     * 
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     * 
     */
    public void addBusinessFilterToDepends(ViewerFilter filter);

    /**
     * @return true if the given element is contained inside the depends table
     * 
     */
    public boolean isContainedInDependsTable(EObject element);

    /**
     * Init the validationRule
     * 
     * @param current
     *            the current value
     * @param containgFeature
     *            the feature where to navigate if necessary
     * @param feature
     *            the feature to manage
     */
    public void initValidationRule(ReferencesTableSettings settings);

    /**
     * Update the validationRule
     * 
     * @param newValue
     *            the validationRule to update
     * 
     */
    public void updateValidationRule();

    /**
     * Adds the given filter to the validationRule edition editor.
     * 
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     * 
     */
    public void addFilterToValidationRule(ViewerFilter filter);

    /**
     * Adds the given filter to the validationRule edition editor.
     * 
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     * 
     */
    public void addBusinessFilterToValidationRule(ViewerFilter filter);

    /**
     * @return true if the given element is contained inside the validationRule
     *         table
     * 
     */
    public boolean isContainedInValidationRuleTable(EObject element);

    /**
     * Init the option
     * 
     * @param current
     *            the current value
     * @param containgFeature
     *            the feature where to navigate if necessary
     * @param feature
     *            the feature to manage
     */
    public void initOption(ReferencesTableSettings settings);

    /**
     * Update the option
     * 
     * @param newValue
     *            the option to update
     * 
     */
    public void updateOption();

    /**
     * Adds the given filter to the option edition editor.
     * 
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     * 
     */
    public void addFilterToOption(ViewerFilter filter);

    /**
     * Adds the given filter to the option edition editor.
     * 
     * @param filter
     *            a viewer filter
     * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
     * 
     */
    public void addBusinessFilterToOption(ViewerFilter filter);

    /**
     * @return true if the given element is contained inside the option table
     * 
     */
    public boolean isContainedInOptionTable(EObject element);

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
