/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;


// End of user code

/**
 * 
 * 
 */
public interface ParamPropertiesEditionPart {

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
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
