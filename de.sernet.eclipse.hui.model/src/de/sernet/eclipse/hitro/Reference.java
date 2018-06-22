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
package de.sernet.eclipse.hitro;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> Complex type to define references to other entities
 * which can be selected by the user to create links. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.Reference#getEntitytype
 * <em>Entitytype</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Reference#getLinkType <em>Link
 * Type</em>}</li>
 * </ul>
 *
 * @see de.sernet.eclipse.hitro.HitroPackage#getReference()
 * @model extendedMetaData="name='referencestype' kind='empty'"
 * @generated
 */
public interface Reference extends EObject {
    /**
     * Returns the value of the '<em><b>Entitytype</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entitytype</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Entitytype</em>' reference.
     * @see #setEntitytype(Huientity)
     * @see de.sernet.eclipse.hitro.HitroPackage#getReference_Entitytype()
     * @model resolveProxies="false" extendedMetaData="kind='attribute'
     *        name='entitytype'"
     * @generated
     */
    Huientity getEntitytype();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Reference#getEntitytype
     * <em>Entitytype</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Entitytype</em>' reference.
     * @see #getEntitytype()
     * @generated
     */
    void setEntitytype(Huientity value);

    /**
     * Returns the value of the '<em><b>Link Type</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Link Type</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Link Type</em>' attribute.
     * @see #setLinkType(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getReference_LinkType()
     * @model dataType="org.eclipse.emf.ecore.xml.type.IDREF"
     *        extendedMetaData="kind='attribute' name='linkType'"
     * @generated
     */
    String getLinkType();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Reference#getLinkType <em>Link
     * Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Link Type</em>' attribute.
     * @see #getLinkType()
     * @generated
     */
    void setLinkType(String value);

} // Reference
