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

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Document
 * Root</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.DocumentRoot#getMixed <em>Mixed</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.DocumentRoot#getXMLNSPrefixMap <em>XMLNS
 * Prefix Map</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.DocumentRoot#getXSISchemaLocation <em>XSI
 * Schema Location</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.DocumentRoot#getHuientities
 * <em>Huientities</em>}</li>
 * </ul>
 *
 * @see de.sernet.eclipse.hitro.HitroPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
    /**
     * Returns the value of the '<em><b>Mixed</b></em>' attribute list. The list
     * contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Mixed</em>' attribute list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getDocumentRoot_Mixed()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry"
     *        many="true" extendedMetaData="kind='elementWildcard'
     *        name=':mixed'"
     * @generated
     */
    FeatureMap getMixed();

    /**
     * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map. The key
     * is of type {@link java.lang.String}, and the value is of type
     * {@link java.lang.String}, <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>XMLNS Prefix Map</em>' map.
     * @see de.sernet.eclipse.hitro.HitroPackage#getDocumentRoot_XMLNSPrefixMap()
     * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry&lt;org.eclipse.emf.ecore.EString,
     *        org.eclipse.emf.ecore.EString&gt;" transient="true"
     *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
     * @generated
     */
    EMap<String, String> getXMLNSPrefixMap();

    /**
     * Returns the value of the '<em><b>XSI Schema Location</b></em>' map. The
     * key is of type {@link java.lang.String}, and the value is of type
     * {@link java.lang.String}, <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>XSI Schema Location</em>' map.
     * @see de.sernet.eclipse.hitro.HitroPackage#getDocumentRoot_XSISchemaLocation()
     * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry&lt;org.eclipse.emf.ecore.EString,
     *        org.eclipse.emf.ecore.EString&gt;" transient="true"
     *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
     * @generated
     */
    EMap<String, String> getXSISchemaLocation();

    /**
     * Returns the value of the '<em><b>Huientities</b></em>' containment
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Huientities</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Huientities</em>' containment reference.
     * @see #setHuientities(Huientities)
     * @see de.sernet.eclipse.hitro.HitroPackage#getDocumentRoot_Huientities()
     * @model containment="true" upper="-2" transient="true" volatile="true"
     *        derived="true" extendedMetaData="kind='element' name='huientities'
     *        namespace='##targetNamespace'"
     * @generated
     */
    Huientities getHuientities();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.DocumentRoot#getHuientities
     * <em>Huientities</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Huientities</em>' containment
     *            reference.
     * @see #getHuientities()
     * @generated
     */
    void setHuientities(Huientities value);

} // DocumentRoot
