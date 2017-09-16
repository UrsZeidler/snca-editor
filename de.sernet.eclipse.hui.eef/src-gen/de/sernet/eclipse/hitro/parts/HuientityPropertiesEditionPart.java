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
public interface HuientityPropertiesEditionPart {

	/**
	 * @return the group
	 * 
	 */
	public EList getGroup();

	/**
	 * Defines a new group
	 * @param newValue the new group to set
	 * 
	 */
	public void setGroup(EList newValue);

	/**
	 * Add a value to the group multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToGroup(Object newValue);

	/**
	 * Remove a value to the group multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToGroup(Object newValue);


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
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
