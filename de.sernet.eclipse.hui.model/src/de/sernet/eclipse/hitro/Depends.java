/**
 */
package de.sernet.eclipse.hitro;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Depends</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 *  Complex type to define dependency to other properties of an entity.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.sernet.eclipse.hitro.Depends#isInverse <em>Inverse</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.Depends#getOption <em>Option</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.Depends#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see de.sernet.eclipse.hitro.HitroPackage#getDepends()
 * @model extendedMetaData="name='dependstype' kind='empty'"
 * @generated
 */
public interface Depends extends EObject {
	/**
	 * Returns the value of the '<em><b>Inverse</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inverse</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inverse</em>' attribute.
	 * @see #isSetInverse()
	 * @see #unsetInverse()
	 * @see #setInverse(boolean)
	 * @see de.sernet.eclipse.hitro.HitroPackage#getDepends_Inverse()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='inverse'"
	 * @generated
	 */
	boolean isInverse();

	/**
	 * Sets the value of the '{@link de.sernet.eclipse.hitro.Depends#isInverse <em>Inverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inverse</em>' attribute.
	 * @see #isSetInverse()
	 * @see #unsetInverse()
	 * @see #isInverse()
	 * @generated
	 */
	void setInverse(boolean value);

	/**
	 * Unsets the value of the '{@link de.sernet.eclipse.hitro.Depends#isInverse <em>Inverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInverse()
	 * @see #isInverse()
	 * @see #setInverse(boolean)
	 * @generated
	 */
	void unsetInverse();

	/**
	 * Returns whether the value of the '{@link de.sernet.eclipse.hitro.Depends#isInverse <em>Inverse</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inverse</em>' attribute is set.
	 * @see #unsetInverse()
	 * @see #isInverse()
	 * @see #setInverse(boolean)
	 * @generated
	 */
	boolean isSetInverse();

	/**
	 * Returns the value of the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option</em>' reference.
	 * @see #setOption(Huiproperty)
	 * @see de.sernet.eclipse.hitro.HitroPackage#getDepends_Option()
	 * @model resolveProxies="false" required="true"
	 *        extendedMetaData="kind='attribute' name='option'"
	 * @generated
	 */
	Huiproperty getOption();

	/**
	 * Sets the value of the '{@link de.sernet.eclipse.hitro.Depends#getOption <em>Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option</em>' reference.
	 * @see #getOption()
	 * @generated
	 */
	void setOption(Huiproperty value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see de.sernet.eclipse.hitro.HitroPackage#getDepends_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='value'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link de.sernet.eclipse.hitro.Depends#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // Depends
