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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Huirelation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.sernet.eclipse.hitro.Huirelation#getId <em>Id</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.Huirelation#getName <em>Name</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.Huirelation#getReversename <em>Reversename</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.Huirelation#getTo <em>To</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.Huirelation#getTooltip <em>Tooltip</em>}</li>
 * </ul>
 *
 * @see de.sernet.eclipse.hitro.HitroPackage#getHuirelation()
 * @model extendedMetaData="name='huirelationtype' kind='empty'"
 * @generated
 */
public interface Huirelation extends EObject {
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
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuirelation_Id()
     * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID" required="true"
     *        extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huirelation#getId <em>Id</em>}' attribute.
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
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuirelation_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huirelation#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Reversename</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reversename</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reversename</em>' attribute.
     * @see #setReversename(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuirelation_Reversename()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='reversename'"
     * @generated
     */
    String getReversename();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huirelation#getReversename <em>Reversename</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reversename</em>' attribute.
     * @see #getReversename()
     * @generated
     */
    void setReversename(String value);

    /**
     * Returns the value of the '<em><b>To</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' reference.
     * @see #setTo(Huientity)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuirelation_To()
     * @model resolveProxies="false" required="true"
     *        extendedMetaData="kind='attribute' name='to'"
     * @generated
     */
    Huientity getTo();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huirelation#getTo <em>To</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>To</em>' reference.
     * @see #getTo()
     * @generated
     */
    void setTo(Huientity value);

    /**
     * Returns the value of the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tooltip</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tooltip</em>' attribute.
     * @see #setTooltip(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuirelation_Tooltip()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='tooltip'"
     * @generated
     */
    String getTooltip();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huirelation#getTooltip <em>Tooltip</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tooltip</em>' attribute.
     * @see #getTooltip()
     * @generated
     */
    void setTooltip(String value);

} // Huirelation
