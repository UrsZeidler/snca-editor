/**
 */
package de.sernet.eclipse.hitro;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.sernet.eclipse.hitro.HitroPackage
 * @generated
 */
public interface HitroFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HitroFactory eINSTANCE = de.sernet.eclipse.hitro.impl.HitroFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Default Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Rule</em>'.
	 * @generated
	 */
	DefaultRule createDefaultRule();

	/**
	 * Returns a new object of class '<em>Depends</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Depends</em>'.
	 * @generated
	 */
	Depends createDepends();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Huientities</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Huientities</em>'.
	 * @generated
	 */
	Huientities createHuientities();

	/**
	 * Returns a new object of class '<em>Huientity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Huientity</em>'.
	 * @generated
	 */
	Huientity createHuientity();

	/**
	 * Returns a new object of class '<em>Huiproperty</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Huiproperty</em>'.
	 * @generated
	 */
	Huiproperty createHuiproperty();

	/**
	 * Returns a new object of class '<em>Huipropertygroup</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Huipropertygroup</em>'.
	 * @generated
	 */
	Huipropertygroup createHuipropertygroup();

	/**
	 * Returns a new object of class '<em>Huirelation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Huirelation</em>'.
	 * @generated
	 */
	Huirelation createHuirelation();

	/**
	 * Returns a new object of class '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Option</em>'.
	 * @generated
	 */
	Option createOption();

	/**
	 * Returns a new object of class '<em>Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Param</em>'.
	 * @generated
	 */
	Param createParam();

	/**
	 * Returns a new object of class '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference</em>'.
	 * @generated
	 */
	Reference createReference();

	/**
	 * Returns a new object of class '<em>Validation Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validation Rule</em>'.
	 * @generated
	 */
	ValidationRule createValidationRule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HitroPackage getHitroPackage();

} //HitroFactory
