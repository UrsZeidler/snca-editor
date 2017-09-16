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
public interface HuientitiesPropertiesEditionPart {



	/**
	 * Init the huientity
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initHuientity(ReferencesTableSettings settings);

	/**
	 * Update the huientity
	 * @param newValue the huientity to update
	 * 
	 */
	public void updateHuientity();

	/**
	 * Adds the given filter to the huientity edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToHuientity(ViewerFilter filter);

	/**
	 * Adds the given filter to the huientity edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToHuientity(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the huientity table
	 * 
	 */
	public boolean isContainedInHuientityTable(EObject element);





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
