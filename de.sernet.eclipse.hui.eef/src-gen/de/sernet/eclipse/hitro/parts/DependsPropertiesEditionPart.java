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
public interface DependsPropertiesEditionPart {

	/**
	 * @return the inverse
	 * 
	 */
	public Boolean getInverse();

	/**
	 * Defines a new inverse
	 * @param newValue the new inverse to set
	 * 
	 */
	public void setInverse(Boolean newValue);


	/**
	 * @return the option
	 * 
	 */
	public EObject getOption();

	/**
	 * Init the option
	 * @param settings the combo setting
	 */
	public void initOption(EObjectFlatComboSettings settings);

	/**
	 * Defines a new option
	 * @param newValue the new option to set
	 * 
	 */
	public void setOption(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setOptionButtonMode(ButtonsModeEnum newValue);

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
	 * @return the value
	 * 
	 */
	public String getValue();

	/**
	 * Defines a new value
	 * @param newValue the new value to set
	 * 
	 */
	public void setValue(String newValue);





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
