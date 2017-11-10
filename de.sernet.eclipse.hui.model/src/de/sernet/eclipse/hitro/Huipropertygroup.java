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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Huipropertygroup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Group of properties, may have dependencies, which means it will only
 * be displayed when one of the given options has been previously selected.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.sernet.eclipse.hitro.Huipropertygroup#getDepends <em>Depends</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.Huipropertygroup#getHuiproperty <em>Huiproperty</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.Huipropertygroup#getColumns <em>Columns</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.Huipropertygroup#getId <em>Id</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.Huipropertygroup#getName <em>Name</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.Huipropertygroup#getTags <em>Tags</em>}</li>
 * </ul>
 *
 * @see de.sernet.eclipse.hitro.HitroPackage#getHuipropertygroup()
 * @model extendedMetaData="name='huipropertygrouptype' kind='elementOnly'"
 * @generated
 */
public interface Huipropertygroup extends EObject {
    /**
     * Returns the value of the '<em><b>Depends</b></em>' reference list.
     * The list contents are of type {@link de.sernet.eclipse.hitro.Depends}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Depends</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Depends</em>' reference list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuipropertygroup_Depends()
     * @model resolveProxies="false"
     *        extendedMetaData="kind='element' name='depends'"
     * @generated
     */
    EList<Depends> getDepends();

    /**
     * Returns the value of the '<em><b>Huiproperty</b></em>' containment reference list.
     * The list contents are of type {@link de.sernet.eclipse.hitro.Huiproperty}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Huiproperty</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Huiproperty</em>' containment reference list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuipropertygroup_Huiproperty()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='huiproperty'"
     * @generated
     */
    EList<Huiproperty> getHuiproperty();

    /**
     * Returns the value of the '<em><b>Columns</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Columns</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Columns</em>' attribute.
     * @see #isSetColumns()
     * @see #unsetColumns()
     * @see #setColumns(int)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuipropertygroup_Columns()
     * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='columns'"
     * @generated
     */
    int getColumns();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huipropertygroup#getColumns <em>Columns</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Columns</em>' attribute.
     * @see #isSetColumns()
     * @see #unsetColumns()
     * @see #getColumns()
     * @generated
     */
    void setColumns(int value);

    /**
     * Unsets the value of the '{@link de.sernet.eclipse.hitro.Huipropertygroup#getColumns <em>Columns</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetColumns()
     * @see #getColumns()
     * @see #setColumns(int)
     * @generated
     */
    void unsetColumns();

    /**
     * Returns whether the value of the '{@link de.sernet.eclipse.hitro.Huipropertygroup#getColumns <em>Columns</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Columns</em>' attribute is set.
     * @see #unsetColumns()
     * @see #getColumns()
     * @see #setColumns(int)
     * @generated
     */
    boolean isSetColumns();

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuipropertygroup_Id()
     * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID" required="true"
     *        extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huipropertygroup#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuipropertygroup_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huipropertygroup#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Tags</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tags</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tags</em>' attribute.
     * @see #setTags(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuipropertygroup_Tags()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='tags'"
     * @generated
     */
    String getTags();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huipropertygroup#getTags <em>Tags</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tags</em>' attribute.
     * @see #getTags()
     * @generated
     */
    void setTags(String value);

} // Huipropertygroup
