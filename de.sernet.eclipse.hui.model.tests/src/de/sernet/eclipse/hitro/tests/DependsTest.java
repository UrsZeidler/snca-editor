/**
 */
package de.sernet.eclipse.hitro.tests;

import de.sernet.eclipse.hitro.Depends;
import de.sernet.eclipse.hitro.HitroFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Depends</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DependsTest extends TestCase {

	/**
	 * The fixture for this Depends test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Depends fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DependsTest.class);
	}

	/**
	 * Constructs a new Depends test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependsTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Depends test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Depends fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Depends test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Depends getFixture() {
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
		setFixture(HitroFactory.eINSTANCE.createDepends());
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

} //DependsTest
