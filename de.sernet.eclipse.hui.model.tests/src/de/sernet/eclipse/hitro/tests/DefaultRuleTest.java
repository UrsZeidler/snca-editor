/**
 */
package de.sernet.eclipse.hitro.tests;

import de.sernet.eclipse.hitro.DefaultRule;
import de.sernet.eclipse.hitro.HitroFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Default Rule</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DefaultRuleTest extends TestCase {

	/**
     * The fixture for this Default Rule test case.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DefaultRule fixture = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static void main(String[] args) {
        TestRunner.run(DefaultRuleTest.class);
    }

	/**
     * Constructs a new Default Rule test case with the given name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DefaultRuleTest(String name) {
        super(name);
    }

	/**
     * Sets the fixture for this Default Rule test case.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void setFixture(DefaultRule fixture) {
        this.fixture = fixture;
    }

	/**
     * Returns the fixture for this Default Rule test case.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DefaultRule getFixture() {
        return fixture;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
	@Override
	protected void setUp() throws Exception {
        setFixture(HitroFactory.eINSTANCE.createDefaultRule());
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
	@Override
	protected void tearDown() throws Exception {
        setFixture(null);
    }

} //DefaultRuleTest
