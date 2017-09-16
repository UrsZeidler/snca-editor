/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface ReferencePropertiesEditionPart {

	/**
	 * @return the entitytype
	 * 
	 */
	public EObject getEntitytype();

	/**
	 * Init the entitytype
	 * @param settings the combo setting
	 */
	public void initEntitytype(EObjectFlatComboSettings settings);

	/**
	 * Defines a new entitytype
	 * @param newValue the new entitytype to set
	 * 
	 */
	public void setEntitytype(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setEntitytypeButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the entitytype edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEntitytype(ViewerFilter filter);

	/**
	 * Adds the given filter to the entitytype edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEntitytype(ViewerFilter filter);


	/**
	 * @return the linkType
	 * 
	 */
	public String getLinkType();

	/**
	 * Defines a new linkType
	 * @param newValue the new linkType to set
	 * 
	 */
	public void setLinkType(String newValue);





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
