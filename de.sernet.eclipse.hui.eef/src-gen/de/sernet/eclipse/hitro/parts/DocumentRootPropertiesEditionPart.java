/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
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
	 * @param newValue the new mixed to set
	 * 
	 */
	public void setMixed(EList newValue);

	/**
	 * Add a value to the mixed multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToMixed(Object newValue);

	/**
	 * Remove a value to the mixed multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToMixed(Object newValue);




	/**
	 * Init the xMLNSPrefixMap
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initXMLNSPrefixMap(ReferencesTableSettings settings);

	/**
	 * Update the xMLNSPrefixMap
	 * @param newValue the xMLNSPrefixMap to update
	 * 
	 */
	public void updateXMLNSPrefixMap();

	/**
	 * Adds the given filter to the xMLNSPrefixMap edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToXMLNSPrefixMap(ViewerFilter filter);

	/**
	 * Adds the given filter to the xMLNSPrefixMap edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToXMLNSPrefixMap(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the xMLNSPrefixMap table
	 * 
	 */
	public boolean isContainedInXMLNSPrefixMapTable(EObject element);




	/**
	 * Init the xSISchemaLocation
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initXSISchemaLocation(ReferencesTableSettings settings);

	/**
	 * Update the xSISchemaLocation
	 * @param newValue the xSISchemaLocation to update
	 * 
	 */
	public void updateXSISchemaLocation();

	/**
	 * Adds the given filter to the xSISchemaLocation edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToXSISchemaLocation(ViewerFilter filter);

	/**
	 * Adds the given filter to the xSISchemaLocation edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToXSISchemaLocation(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the xSISchemaLocation table
	 * 
	 */
	public boolean isContainedInXSISchemaLocationTable(EObject element);





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
