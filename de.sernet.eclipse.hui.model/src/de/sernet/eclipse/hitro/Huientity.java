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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Huientity</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.Huientity#getGroup <em>Group</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huientity#getHuiproperty
 * <em>Huiproperty</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huientity#getHuipropertygroup
 * <em>Huipropertygroup</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huientity#getHuirelation
 * <em>Huirelation</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huientity#getId <em>Id</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huientity#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see de.sernet.eclipse.hitro.HitroPackage#getHuientity()
 * @model extendedMetaData="name='huientitytype' kind='elementOnly'"
 * @generated
 */
public interface Huientity extends EObject {
    /**
     * Returns the value of the '<em><b>Group</b></em>' attribute list. The list
     * contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Group</em>' attribute list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Group</em>' attribute list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuientity_Group()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry"
     *        many="true" extendedMetaData="kind='group' name='group:0'"
     * @generated
     */
    FeatureMap getGroup();

    /**
     * Returns the value of the '<em><b>Huiproperty</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.sernet.eclipse.hitro.Huiproperty}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Huiproperty</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Huiproperty</em>' containment reference
     *         list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuientity_Huiproperty()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='huiproperty'
     *        group='#group:0'"
     * @generated
     */
    EList<Huiproperty> getHuiproperty();

    /**
     * Returns the value of the '<em><b>Huipropertygroup</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.sernet.eclipse.hitro.Huipropertygroup}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Huipropertygroup</em>' containment reference
     * list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Huipropertygroup</em>' containment
     *         reference list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuientity_Huipropertygroup()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='huipropertygroup'
     *        group='#group:0'"
     * @generated
     */
    EList<Huipropertygroup> getHuipropertygroup();

    /**
     * Returns the value of the '<em><b>Huirelation</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.sernet.eclipse.hitro.Huirelation}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Huirelation</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Huirelation</em>' containment reference
     *         list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuientity_Huirelation()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='huirelation'
     *        group='#group:0'"
     * @generated
     */
    EList<Huirelation> getHuirelation();

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuientity_Id()
     * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID"
     *        required="true" extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huientity#getId
     * <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuientity_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huientity#getName
     * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // Huientity
