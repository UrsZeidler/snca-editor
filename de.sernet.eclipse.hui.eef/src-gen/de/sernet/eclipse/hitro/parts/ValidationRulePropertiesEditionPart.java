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
public interface ValidationRulePropertiesEditionPart {



	/**
	 * Init the param
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initParam(ReferencesTableSettings settings);

	/**
	 * Update the param
	 * @param newValue the param to update
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
	 * @param newValue the new class to set
	 * 
	 */
	public void setClass_(String newValue);


	/**
	 * @return the hint
	 * 
	 */
	public String getHint();

	/**
	 * Defines a new hint
	 * @param newValue the new hint to set
	 * 
	 */
	public void setHint(String newValue);





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
