/**
 * 
 * Copyright (c) 2017 Urs Zeidler.
 * 
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Urs Zeidler uz[at]sernet.de - initial API and implementation
 */
package de.sernet.eclipse.hitro.tests;

import org.junit.Ignore;

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
@Ignore
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
