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

import de.sernet.eclipse.hitro.DocumentRoot;
import de.sernet.eclipse.hitro.HitroFactory;
import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Document
 * Root</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.DocumentRoot#getHuientities()
 * <em>Huientities</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DocumentRootTest extends TestCase {

    /**
     * The fixture for this Document Root test case. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DocumentRoot fixture = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(DocumentRootTest.class);
    }

    /**
     * Constructs a new Document Root test case with the given name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DocumentRootTest(String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Document Root test case. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void setFixture(DocumentRoot fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Document Root test case. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DocumentRoot getFixture() {
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
        setFixture(HitroFactory.eINSTANCE.createDocumentRoot());
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
     * Tests the '{@link de.sernet.eclipse.hitro.DocumentRoot#getHuientities()
     * <em>Huientities</em>}' feature getter. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.sernet.eclipse.hitro.DocumentRoot#getHuientities()
     * @generated not
     */
    public void testGetHuientities() {
        assertNull(getFixture().getHuientities());
    }

    /**
     * Tests the
     * '{@link de.sernet.eclipse.hitro.DocumentRoot#setHuientities(de.sernet.eclipse.hitro.Huientities)
     * <em>Huientities</em>}' feature setter. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see de.sernet.eclipse.hitro.DocumentRoot#setHuientities(de.sernet.eclipse.hitro.Huientities)
     * @generated not
     */
    public void testSetHuientities() {
        getFixture().setHuientities(HitroFactory.eINSTANCE.createHuientities());
        assertNotNull(getFixture().getHuientities());
    }

} // DocumentRootTest
