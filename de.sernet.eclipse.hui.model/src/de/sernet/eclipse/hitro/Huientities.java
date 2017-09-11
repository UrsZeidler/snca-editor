/**
 */
package de.sernet.eclipse.hitro;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Huientities</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.sernet.eclipse.hitro.Huientities#getHuientity <em>Huientity</em>}</li>
 * </ul>
 *
 * @see de.sernet.eclipse.hitro.HitroPackage#getHuientities()
 * @model extendedMetaData="name='huientities_._type' kind='elementOnly'"
 * @generated
 */
public interface Huientities extends EObject {
	/**
	 * Returns the value of the '<em><b>Huientity</b></em>' containment reference list.
	 * The list contents are of type {@link de.sernet.eclipse.hitro.Huientity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Huientity</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Huientity</em>' containment reference list.
	 * @see de.sernet.eclipse.hitro.HitroPackage#getHuientities_Huientity()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='huientity'"
	 * @generated
	 */
	EList<Huientity> getHuientity();

} // Huientities
