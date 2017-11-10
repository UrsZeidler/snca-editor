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
public interface HuipropertygroupPropertiesEditionPart {

	/**
	 * @return the id
	 * 
	 */
	public String getId();

	/**
	 * Defines a new id
	 * @param newValue the new id to set
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
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


	/**
	 * @return the columns
	 * 
	 */
	public String getColumns();

	/**
	 * Defines a new columns
	 * @param newValue the new columns to set
	 * 
	 */
	public void setColumns(String newValue);


	/**
	 * @return the tags
	 * 
	 */
	public String getTags();

	/**
	 * Defines a new tags
	 * @param newValue the new tags to set
	 * 
	 */
	public void setTags(String newValue);




	/**
	 * Init the huiproperty
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initHuiproperty(ReferencesTableSettings settings);

	/**
	 * Update the huiproperty
	 * @param newValue the huiproperty to update
	 * 
	 */
	public void updateHuiproperty();

	/**
	 * Adds the given filter to the huiproperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToHuiproperty(ViewerFilter filter);

	/**
	 * Adds the given filter to the huiproperty edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToHuiproperty(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the huiproperty table
	 * 
	 */
	public boolean isContainedInHuipropertyTable(EObject element);




	/**
	 * Init the depends
	 * @param settings settings for the depends ReferencesTable 
	 */
	public void initDepends(ReferencesTableSettings settings);

	/**
	 * Update the depends
	 * @param newValue the depends to update
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
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
