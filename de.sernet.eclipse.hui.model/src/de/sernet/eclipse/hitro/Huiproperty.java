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
 * '<em><b>Huiproperty</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> A property to be documented.
 * 
 * May have dependencies, which means it will only be displayed when one of the
 * given options has been previously selected.
 * 
 * Attributes: name: name of property, i.e. "Colour" enum: free text entry, or
 * selection of fixed options? multiselect: can user select multiple items at
 * once? <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getDepends
 * <em>Depends</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getReferences
 * <em>References</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getDefaultRule <em>Default
 * Rule</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getValidationRule
 * <em>Validation Rule</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getOption
 * <em>Option</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#isCrudButtons <em>Crud
 * Buttons</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getDefaultValue <em>Default
 * Value</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#isEditable
 * <em>Editable</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#isFocus <em>Focus</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getId <em>Id</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getInputtype
 * <em>Inputtype</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#isIsURL <em>Is URL</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getMax <em>Max</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getMin <em>Min</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getName <em>Name</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#isReport <em>Report</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#isRequired
 * <em>Required</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#isShowInObjectBrowser <em>Show
 * In Object Browser</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getTags <em>Tags</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getTextrows
 * <em>Textrows</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#getTooltip
 * <em>Tooltip</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.Huiproperty#isVisible
 * <em>Visible</em>}</li>
 * </ul>
 *
 * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty()
 * @model extendedMetaData="name='huipropertytype' kind='elementOnly'"
 * @generated
 */
public interface Huiproperty extends EObject {
    /**
     * Returns the value of the '<em><b>Depends</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.sernet.eclipse.hitro.Depends}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Depends</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Depends</em>' containment reference list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Depends()
     * @model containment="true" extendedMetaData="kind='element'
     *        name='depends'"
     * @generated
     */
    EList<Depends> getDepends();

    /**
     * Returns the value of the '<em><b>References</b></em>' containment
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>References</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>References</em>' containment reference.
     * @see #setReferences(Reference)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_References()
     * @model containment="true" extendedMetaData="kind='element'
     *        name='references'"
     * @generated
     */
    Reference getReferences();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getReferences
     * <em>References</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>References</em>' containment
     *            reference.
     * @see #getReferences()
     * @generated
     */
    void setReferences(Reference value);

    /**
     * Returns the value of the '<em><b>Default Rule</b></em>' containment
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Rule</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Rule</em>' containment reference.
     * @see #setDefaultRule(DefaultRule)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_DefaultRule()
     * @model containment="true" extendedMetaData="kind='element'
     *        name='defaultRule'"
     * @generated
     */
    DefaultRule getDefaultRule();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getDefaultRule <em>Default
     * Rule</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Default Rule</em>' containment
     *            reference.
     * @see #getDefaultRule()
     * @generated
     */
    void setDefaultRule(DefaultRule value);

    /**
     * Returns the value of the '<em><b>Validation Rule</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.sernet.eclipse.hitro.ValidationRule}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Validation Rule</em>' containment reference
     * list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Validation Rule</em>' containment reference
     *         list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_ValidationRule()
     * @model containment="true" extendedMetaData="kind='element'
     *        name='validationRule'"
     * @generated
     */
    EList<ValidationRule> getValidationRule();

    /**
     * Returns the value of the '<em><b>Option</b></em>' containment reference
     * list. The list contents are of type
     * {@link de.sernet.eclipse.hitro.Option}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Option</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Option</em>' containment reference list.
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Option()
     * @model containment="true" extendedMetaData="kind='element' name='option'"
     * @generated
     */
    EList<Option> getOption();

    /**
     * Returns the value of the '<em><b>Crud Buttons</b></em>' attribute. The
     * default value is <code>"false"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Crud Buttons</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Crud Buttons</em>' attribute.
     * @see #isSetCrudButtons()
     * @see #unsetCrudButtons()
     * @see #setCrudButtons(boolean)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_CrudButtons()
     * @model default="false" unsettable="true"
     *        dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='crudButtons'"
     * @generated
     */
    boolean isCrudButtons();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isCrudButtons <em>Crud
     * Buttons</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Crud Buttons</em>' attribute.
     * @see #isSetCrudButtons()
     * @see #unsetCrudButtons()
     * @see #isCrudButtons()
     * @generated
     */
    void setCrudButtons(boolean value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isCrudButtons <em>Crud
     * Buttons</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetCrudButtons()
     * @see #isCrudButtons()
     * @see #setCrudButtons(boolean)
     * @generated
     */
    void unsetCrudButtons();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isCrudButtons <em>Crud
     * Buttons</em>}' attribute is set. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return whether the value of the '<em>Crud Buttons</em>' attribute is
     *         set.
     * @see #unsetCrudButtons()
     * @see #isCrudButtons()
     * @see #setCrudButtons(boolean)
     * @generated
     */
    boolean isSetCrudButtons();

    /**
     * Returns the value of the '<em><b>Default Value</b></em>' attribute. The
     * default value is <code>"0"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Default Value</em>' attribute.
     * @see #isSetDefaultValue()
     * @see #unsetDefaultValue()
     * @see #setDefaultValue(int)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_DefaultValue()
     * @model default="0" unsettable="true"
     *        dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='defaultValue'"
     * @generated
     */
    int getDefaultValue();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getDefaultValue <em>Default
     * Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Default Value</em>' attribute.
     * @see #isSetDefaultValue()
     * @see #unsetDefaultValue()
     * @see #getDefaultValue()
     * @generated
     */
    void setDefaultValue(int value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getDefaultValue <em>Default
     * Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetDefaultValue()
     * @see #getDefaultValue()
     * @see #setDefaultValue(int)
     * @generated
     */
    void unsetDefaultValue();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getDefaultValue <em>Default
     * Value</em>}' attribute is set. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return whether the value of the '<em>Default Value</em>' attribute is
     *         set.
     * @see #unsetDefaultValue()
     * @see #getDefaultValue()
     * @see #setDefaultValue(int)
     * @generated
     */
    boolean isSetDefaultValue();

    /**
     * Returns the value of the '<em><b>Editable</b></em>' attribute. The
     * default value is <code>"true"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Editable</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Editable</em>' attribute.
     * @see #isSetEditable()
     * @see #unsetEditable()
     * @see #setEditable(boolean)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Editable()
     * @model default="true" unsettable="true"
     *        dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='editable'"
     * @generated
     */
    boolean isEditable();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isEditable
     * <em>Editable</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Editable</em>' attribute.
     * @see #isSetEditable()
     * @see #unsetEditable()
     * @see #isEditable()
     * @generated
     */
    void setEditable(boolean value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isEditable
     * <em>Editable</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #isSetEditable()
     * @see #isEditable()
     * @see #setEditable(boolean)
     * @generated
     */
    void unsetEditable();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isEditable
     * <em>Editable</em>}' attribute is set. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return whether the value of the '<em>Editable</em>' attribute is set.
     * @see #unsetEditable()
     * @see #isEditable()
     * @see #setEditable(boolean)
     * @generated
     */
    boolean isSetEditable();

    /**
     * Returns the value of the '<em><b>Focus</b></em>' attribute. The default
     * value is <code>"false"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Focus</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Focus</em>' attribute.
     * @see #isSetFocus()
     * @see #unsetFocus()
     * @see #setFocus(boolean)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Focus()
     * @model default="false" unsettable="true"
     *        dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='focus'"
     * @generated
     */
    boolean isFocus();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huiproperty#isFocus
     * <em>Focus</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Focus</em>' attribute.
     * @see #isSetFocus()
     * @see #unsetFocus()
     * @see #isFocus()
     * @generated
     */
    void setFocus(boolean value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isFocus <em>Focus</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetFocus()
     * @see #isFocus()
     * @see #setFocus(boolean)
     * @generated
     */
    void unsetFocus();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isFocus <em>Focus</em>}'
     * attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return whether the value of the '<em>Focus</em>' attribute is set.
     * @see #unsetFocus()
     * @see #isFocus()
     * @see #setFocus(boolean)
     * @generated
     */
    boolean isSetFocus();

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
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Id()
     * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID"
     *        required="true" extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
    String getId();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huiproperty#getId
     * <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId(String value);

    /**
     * Returns the value of the '<em><b>Inputtype</b></em>' attribute. The
     * default value is <code>"line"</code>. The literals are from the
     * enumeration {@link de.sernet.eclipse.hitro.Inputtypes}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inputtype</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Inputtype</em>' attribute.
     * @see de.sernet.eclipse.hitro.Inputtypes
     * @see #isSetInputtype()
     * @see #unsetInputtype()
     * @see #setInputtype(Inputtypes)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Inputtype()
     * @model default="line" unsettable="true"
     *        extendedMetaData="kind='attribute' name='inputtype'"
     * @generated
     */
    Inputtypes getInputtype();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getInputtype
     * <em>Inputtype</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Inputtype</em>' attribute.
     * @see de.sernet.eclipse.hitro.Inputtypes
     * @see #isSetInputtype()
     * @see #unsetInputtype()
     * @see #getInputtype()
     * @generated
     */
    void setInputtype(Inputtypes value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getInputtype
     * <em>Inputtype</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #isSetInputtype()
     * @see #getInputtype()
     * @see #setInputtype(Inputtypes)
     * @generated
     */
    void unsetInputtype();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getInputtype
     * <em>Inputtype</em>}' attribute is set. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return whether the value of the '<em>Inputtype</em>' attribute is set.
     * @see #unsetInputtype()
     * @see #getInputtype()
     * @see #setInputtype(Inputtypes)
     * @generated
     */
    boolean isSetInputtype();

    /**
     * Returns the value of the '<em><b>Is URL</b></em>' attribute. The default
     * value is <code>"false"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is URL</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Is URL</em>' attribute.
     * @see #isSetIsURL()
     * @see #unsetIsURL()
     * @see #setIsURL(boolean)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_IsURL()
     * @model default="false" unsettable="true"
     *        dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='isURL'"
     * @generated
     */
    boolean isIsURL();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huiproperty#isIsURL
     * <em>Is URL</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Is URL</em>' attribute.
     * @see #isSetIsURL()
     * @see #unsetIsURL()
     * @see #isIsURL()
     * @generated
     */
    void setIsURL(boolean value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isIsURL <em>Is URL</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetIsURL()
     * @see #isIsURL()
     * @see #setIsURL(boolean)
     * @generated
     */
    void unsetIsURL();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isIsURL <em>Is URL</em>}'
     * attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return whether the value of the '<em>Is URL</em>' attribute is set.
     * @see #unsetIsURL()
     * @see #isIsURL()
     * @see #setIsURL(boolean)
     * @generated
     */
    boolean isSetIsURL();

    /**
     * Returns the value of the '<em><b>Max</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Max</em>' attribute.
     * @see #isSetMax()
     * @see #unsetMax()
     * @see #setMax(int)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Max()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='max'"
     * @generated
     */
    int getMax();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huiproperty#getMax
     * <em>Max</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Max</em>' attribute.
     * @see #isSetMax()
     * @see #unsetMax()
     * @see #getMax()
     * @generated
     */
    void setMax(int value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getMax <em>Max</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetMax()
     * @see #getMax()
     * @see #setMax(int)
     * @generated
     */
    void unsetMax();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getMax <em>Max</em>}'
     * attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return whether the value of the '<em>Max</em>' attribute is set.
     * @see #unsetMax()
     * @see #getMax()
     * @see #setMax(int)
     * @generated
     */
    boolean isSetMax();

    /**
     * Returns the value of the '<em><b>Min</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Min</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Min</em>' attribute.
     * @see #isSetMin()
     * @see #unsetMin()
     * @see #setMin(int)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Min()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='min'"
     * @generated
     */
    int getMin();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huiproperty#getMin
     * <em>Min</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Min</em>' attribute.
     * @see #isSetMin()
     * @see #unsetMin()
     * @see #getMin()
     * @generated
     */
    void setMin(int value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getMin <em>Min</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetMin()
     * @see #getMin()
     * @see #setMin(int)
     * @generated
     */
    void unsetMin();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getMin <em>Min</em>}'
     * attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return whether the value of the '<em>Min</em>' attribute is set.
     * @see #unsetMin()
     * @see #getMin()
     * @see #setMin(int)
     * @generated
     */
    boolean isSetMin();

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
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huiproperty#getName
     * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Report</b></em>' attribute. The default
     * value is <code>"true"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Report</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Report</em>' attribute.
     * @see #isSetReport()
     * @see #unsetReport()
     * @see #setReport(boolean)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Report()
     * @model default="true" unsettable="true"
     *        dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='report'"
     * @generated
     */
    boolean isReport();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isReport <em>Report</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Report</em>' attribute.
     * @see #isSetReport()
     * @see #unsetReport()
     * @see #isReport()
     * @generated
     */
    void setReport(boolean value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isReport <em>Report</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetReport()
     * @see #isReport()
     * @see #setReport(boolean)
     * @generated
     */
    void unsetReport();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isReport <em>Report</em>}'
     * attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return whether the value of the '<em>Report</em>' attribute is set.
     * @see #unsetReport()
     * @see #isReport()
     * @see #setReport(boolean)
     * @generated
     */
    boolean isSetReport();

    /**
     * Returns the value of the '<em><b>Required</b></em>' attribute. The
     * default value is <code>"false"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Required</em>' attribute.
     * @see #isSetRequired()
     * @see #unsetRequired()
     * @see #setRequired(boolean)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Required()
     * @model default="false" unsettable="true"
     *        dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='required'"
     * @generated
     */
    boolean isRequired();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isRequired
     * <em>Required</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Required</em>' attribute.
     * @see #isSetRequired()
     * @see #unsetRequired()
     * @see #isRequired()
     * @generated
     */
    void setRequired(boolean value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isRequired
     * <em>Required</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #isSetRequired()
     * @see #isRequired()
     * @see #setRequired(boolean)
     * @generated
     */
    void unsetRequired();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isRequired
     * <em>Required</em>}' attribute is set. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return whether the value of the '<em>Required</em>' attribute is set.
     * @see #unsetRequired()
     * @see #isRequired()
     * @see #setRequired(boolean)
     * @generated
     */
    boolean isSetRequired();

    /**
     * Returns the value of the '<em><b>Show In Object Browser</b></em>'
     * attribute. The default value is <code>"false"</code>. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>Show In Object Browser</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Show In Object Browser</em>' attribute.
     * @see #isSetShowInObjectBrowser()
     * @see #unsetShowInObjectBrowser()
     * @see #setShowInObjectBrowser(boolean)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_ShowInObjectBrowser()
     * @model default="false" unsettable="true"
     *        dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='showInObjectBrowser'"
     * @generated
     */
    boolean isShowInObjectBrowser();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isShowInObjectBrowser
     * <em>Show In Object Browser</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Show In Object Browser</em>'
     *            attribute.
     * @see #isSetShowInObjectBrowser()
     * @see #unsetShowInObjectBrowser()
     * @see #isShowInObjectBrowser()
     * @generated
     */
    void setShowInObjectBrowser(boolean value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isShowInObjectBrowser
     * <em>Show In Object Browser</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #isSetShowInObjectBrowser()
     * @see #isShowInObjectBrowser()
     * @see #setShowInObjectBrowser(boolean)
     * @generated
     */
    void unsetShowInObjectBrowser();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isShowInObjectBrowser
     * <em>Show In Object Browser</em>}' attribute is set. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @return whether the value of the '<em>Show In Object Browser</em>'
     *         attribute is set.
     * @see #unsetShowInObjectBrowser()
     * @see #isShowInObjectBrowser()
     * @see #setShowInObjectBrowser(boolean)
     * @generated
     */
    boolean isSetShowInObjectBrowser();

    /**
     * Returns the value of the '<em><b>Tags</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tags</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Tags</em>' attribute.
     * @see #setTags(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Tags()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='tags'"
     * @generated
     */
    String getTags();

    /**
     * Sets the value of the '{@link de.sernet.eclipse.hitro.Huiproperty#getTags
     * <em>Tags</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Tags</em>' attribute.
     * @see #getTags()
     * @generated
     */
    void setTags(String value);

    /**
     * Returns the value of the '<em><b>Textrows</b></em>' attribute. The
     * default value is <code>"4"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Textrows</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Textrows</em>' attribute.
     * @see #isSetTextrows()
     * @see #unsetTextrows()
     * @see #setTextrows(int)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Textrows()
     * @model default="4" unsettable="true"
     *        dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='textrows'"
     * @generated
     */
    int getTextrows();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getTextrows
     * <em>Textrows</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Textrows</em>' attribute.
     * @see #isSetTextrows()
     * @see #unsetTextrows()
     * @see #getTextrows()
     * @generated
     */
    void setTextrows(int value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getTextrows
     * <em>Textrows</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #isSetTextrows()
     * @see #getTextrows()
     * @see #setTextrows(int)
     * @generated
     */
    void unsetTextrows();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getTextrows
     * <em>Textrows</em>}' attribute is set. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return whether the value of the '<em>Textrows</em>' attribute is set.
     * @see #unsetTextrows()
     * @see #getTextrows()
     * @see #setTextrows(int)
     * @generated
     */
    boolean isSetTextrows();

    /**
     * Returns the value of the '<em><b>Tooltip</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tooltip</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Tooltip</em>' attribute.
     * @see #setTooltip(String)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Tooltip()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='tooltip'"
     * @generated
     */
    String getTooltip();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#getTooltip <em>Tooltip</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Tooltip</em>' attribute.
     * @see #getTooltip()
     * @generated
     */
    void setTooltip(String value);

    /**
     * Returns the value of the '<em><b>Visible</b></em>' attribute. The default
     * value is <code>"true"</code>. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visible</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Visible</em>' attribute.
     * @see #isSetVisible()
     * @see #unsetVisible()
     * @see #setVisible(boolean)
     * @see de.sernet.eclipse.hitro.HitroPackage#getHuiproperty_Visible()
     * @model default="true" unsettable="true"
     *        dataType="org.eclipse.emf.ecore.xml.type.Boolean"
     *        extendedMetaData="kind='attribute' name='visible'"
     * @generated
     */
    boolean isVisible();

    /**
     * Sets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isVisible <em>Visible</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Visible</em>' attribute.
     * @see #isSetVisible()
     * @see #unsetVisible()
     * @see #isVisible()
     * @generated
     */
    void setVisible(boolean value);

    /**
     * Unsets the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isVisible <em>Visible</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetVisible()
     * @see #isVisible()
     * @see #setVisible(boolean)
     * @generated
     */
    void unsetVisible();

    /**
     * Returns whether the value of the
     * '{@link de.sernet.eclipse.hitro.Huiproperty#isVisible <em>Visible</em>}'
     * attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return whether the value of the '<em>Visible</em>' attribute is set.
     * @see #unsetVisible()
     * @see #isVisible()
     * @see #setVisible(boolean)
     * @generated
     */
    boolean isSetVisible();

} // Huiproperty
