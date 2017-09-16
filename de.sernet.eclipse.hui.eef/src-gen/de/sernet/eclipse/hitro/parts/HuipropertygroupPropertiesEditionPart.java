/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface HuipropertygroupPropertiesEditionPart {



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
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
