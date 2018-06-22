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
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Validation Rule</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.ValidationRule#getParam
 * <em>Param</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.ValidationRule#getClass_
 * <em>Class</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.ValidationRule#getHint <em>Hint</em>}</li>
 * </ul>
 *
 * @see de.sernet.eclipse.hitro.HitroPackage#getValidationRule()
 * @model extendedMetaData="name='validationRule_._type' kind='elementOnly'"
 * @generated
 */
public interface ValidationRule extends EObject {
    /**
     * Returns the value of the '<em><b>Param</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.sernet.eclipse.hitro.Param}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Param</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Param</em>' containment reference list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getValidationRule_Param()
     * @model containment="true" extendedMetaData="kind='element' name='param'"
     * @generated
     */
    EList<Param> getParam();

    /**
     * Returns the value of the '<em><b>Class</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Class</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Class</em>' attribute.
     * @see #setClass(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getValidationRule_Class()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='class'"
     * @generated
     */
    String getClass_();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.ValidationRule#getClass_ <em>Class</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Class</em>' attribute.
     * @see #getClass_()
     * @generated
     */
    void setClass(String value);

    /**
     * Returns the value of the '<em><b>Hint</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hint</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Hint</em>' attribute.
     * @see #setHint(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getValidationRule_Hint()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='hint'"
     * @generated
     */
    String getHint();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.ValidationRule#getHint <em>Hint</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Hint</em>' attribute.
     * @see #getHint()
     * @generated
     */
    void setHint(String value);

} // ValidationRule
