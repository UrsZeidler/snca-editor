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

import de.sernet.eclipse.hitro.HitroFactory;
import de.sernet.eclipse.hitro.Huientity;
import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object
 * '<em><b>Huientity</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.Huientity#getHuiproperty()
 * <em>Huiproperty</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huientity#getHuipropertygroup()
 * <em>Huipropertygroup</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huientity#getHuirelation()
 * <em>Huirelation</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class HuientityTest extends TestCase {

    /**
     * The fixture for this Huientity test case. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected Huientity fixture = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(HuientityTest.class);
    }

    /**
     * Constructs a new Huientity test case with the given name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public HuientityTest(String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Huientity test case. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void setFixture(Huientity fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Huientity test case. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Huientity getFixture() {
        return fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(HitroFactory.eINSTANCE.createHuientity());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown() throws Exception {
        setFixture(null);
    }

    /**
     * Tests the '{@link de.sernet.eclipse.hitro.Huientity#getHuiproperty()
     * <em>Huiproperty</em>}' feature getter. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.sernet.eclipse.hitro.Huientity#getHuiproperty()
     * @generated not
     */
    public void testGetHuiproperty() {
        assertEquals(0, getFixture().getHuiproperty().size());
    }

    /**
     * Tests the '{@link de.sernet.eclipse.hitro.Huientity#getHuipropertygroup()
     * <em>Huipropertygroup</em>}' feature getter. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.sernet.eclipse.hitro.Huientity#getHuipropertygroup()
     * @generated not
     */
    public void testGetHuipropertygroup() {
        assertEquals(0, getFixture().getHuipropertygroup().size());
    }

    /**
     * Tests the '{@link de.sernet.eclipse.hitro.Huientity#getHuirelation()
     * <em>Huirelation</em>}' feature getter. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.sernet.eclipse.hitro.Huientity#getHuirelation()
     * @generated not
     */
    public void testGetHuirelation() {
        assertEquals(0, getFixture().getHuirelation().size());
    }

} // HuientityTest
