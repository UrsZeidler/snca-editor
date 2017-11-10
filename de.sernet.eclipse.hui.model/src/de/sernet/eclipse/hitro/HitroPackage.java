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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.sernet.eclipse.hitro.HitroFactory
 * @model kind="package"
 * @generated
 */
public interface HitroPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "hitro";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://www.sernet.de/hitro";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "hitro";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    HitroPackage eINSTANCE = de.sernet.eclipse.hitro.impl.HitroPackageImpl.init();

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.DefaultRuleImpl <em>Default Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.DefaultRuleImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getDefaultRule()
     * @generated
     */
    int DEFAULT_RULE = 0;

    /**
     * The feature id for the '<em><b>Param</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_RULE__PARAM = 0;

    /**
     * The feature id for the '<em><b>Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_RULE__CLASS = 1;

    /**
     * The number of structural features of the '<em>Default Rule</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_RULE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Default Rule</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_RULE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.DependsImpl <em>Depends</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.DependsImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getDepends()
     * @generated
     */
    int DEPENDS = 1;

    /**
     * The feature id for the '<em><b>Inverse</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPENDS__INVERSE = 0;

    /**
     * The feature id for the '<em><b>Option</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPENDS__OPTION = 1;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPENDS__VALUE = 2;

    /**
     * The number of structural features of the '<em>Depends</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPENDS_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Depends</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEPENDS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.DocumentRootImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getDocumentRoot()
     * @generated
     */
    int DOCUMENT_ROOT = 2;

    /**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__MIXED = 0;

    /**
     * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

    /**
     * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

    /**
     * The feature id for the '<em><b>Huientities</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__HUIENTITIES = 3;

    /**
     * The number of structural features of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.HuientitiesImpl <em>Huientities</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.HuientitiesImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getHuientities()
     * @generated
     */
    int HUIENTITIES = 3;

    /**
     * The feature id for the '<em><b>Huientity</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIENTITIES__HUIENTITY = 0;

    /**
     * The number of structural features of the '<em>Huientities</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIENTITIES_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Huientities</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIENTITIES_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.HuientityImpl <em>Huientity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.HuientityImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getHuientity()
     * @generated
     */
    int HUIENTITY = 4;

    /**
     * The feature id for the '<em><b>Group</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIENTITY__GROUP = 0;

    /**
     * The feature id for the '<em><b>Huiproperty</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIENTITY__HUIPROPERTY = 1;

    /**
     * The feature id for the '<em><b>Huipropertygroup</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIENTITY__HUIPROPERTYGROUP = 2;

    /**
     * The feature id for the '<em><b>Huirelation</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIENTITY__HUIRELATION = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIENTITY__ID = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIENTITY__NAME = 5;

    /**
     * The number of structural features of the '<em>Huientity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIENTITY_FEATURE_COUNT = 6;

    /**
     * The number of operations of the '<em>Huientity</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIENTITY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl <em>Huiproperty</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.HuipropertyImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getHuiproperty()
     * @generated
     */
    int HUIPROPERTY = 5;

    /**
     * The feature id for the '<em><b>Depends</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__DEPENDS = 0;

    /**
     * The feature id for the '<em><b>References</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__REFERENCES = 1;

    /**
     * The feature id for the '<em><b>Default Rule</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__DEFAULT_RULE = 2;

    /**
     * The feature id for the '<em><b>Validation Rule</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__VALIDATION_RULE = 3;

    /**
     * The feature id for the '<em><b>Option</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__OPTION = 4;

    /**
     * The feature id for the '<em><b>Crud Buttons</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__CRUD_BUTTONS = 5;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__DEFAULT_VALUE = 6;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__EDITABLE = 7;

    /**
     * The feature id for the '<em><b>Focus</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__FOCUS = 8;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__ID = 9;

    /**
     * The feature id for the '<em><b>Inputtype</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__INPUTTYPE = 10;

    /**
     * The feature id for the '<em><b>Is URL</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__IS_URL = 11;

    /**
     * The feature id for the '<em><b>Max</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__MAX = 12;

    /**
     * The feature id for the '<em><b>Min</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__MIN = 13;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__NAME = 14;

    /**
     * The feature id for the '<em><b>Report</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__REPORT = 15;

    /**
     * The feature id for the '<em><b>Required</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__REQUIRED = 16;

    /**
     * The feature id for the '<em><b>Show In Object Browser</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__SHOW_IN_OBJECT_BROWSER = 17;

    /**
     * The feature id for the '<em><b>Tags</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__TAGS = 18;

    /**
     * The feature id for the '<em><b>Textrows</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__TEXTROWS = 19;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__TOOLTIP = 20;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY__VISIBLE = 21;

    /**
     * The number of structural features of the '<em>Huiproperty</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY_FEATURE_COUNT = 22;

    /**
     * The number of operations of the '<em>Huiproperty</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.HuipropertygroupImpl <em>Huipropertygroup</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.HuipropertygroupImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getHuipropertygroup()
     * @generated
     */
    int HUIPROPERTYGROUP = 6;

    /**
     * The feature id for the '<em><b>Depends</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTYGROUP__DEPENDS = 0;

    /**
     * The feature id for the '<em><b>Huiproperty</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTYGROUP__HUIPROPERTY = 1;

    /**
     * The feature id for the '<em><b>Columns</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTYGROUP__COLUMNS = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTYGROUP__ID = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTYGROUP__NAME = 4;

    /**
     * The feature id for the '<em><b>Tags</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTYGROUP__TAGS = 5;

    /**
     * The number of structural features of the '<em>Huipropertygroup</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTYGROUP_FEATURE_COUNT = 6;

    /**
     * The number of operations of the '<em>Huipropertygroup</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIPROPERTYGROUP_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.HuirelationImpl <em>Huirelation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.HuirelationImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getHuirelation()
     * @generated
     */
    int HUIRELATION = 7;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIRELATION__ID = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIRELATION__NAME = 1;

    /**
     * The feature id for the '<em><b>Reversename</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIRELATION__REVERSENAME = 2;

    /**
     * The feature id for the '<em><b>To</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIRELATION__TO = 3;

    /**
     * The feature id for the '<em><b>Tooltip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIRELATION__TOOLTIP = 4;

    /**
     * The number of structural features of the '<em>Huirelation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIRELATION_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>Huirelation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HUIRELATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.OptionImpl <em>Option</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.OptionImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getOption()
     * @generated
     */
    int OPTION = 8;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTION__ID = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTION__NAME = 1;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTION__VALUE = 2;

    /**
     * The number of structural features of the '<em>Option</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTION_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Option</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.ParamImpl <em>Param</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.ParamImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getParam()
     * @generated
     */
    int PARAM = 9;

    /**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAM__MIXED = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAM__ID = 1;

    /**
     * The number of structural features of the '<em>Param</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAM_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Param</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARAM_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.ReferenceImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getReference()
     * @generated
     */
    int REFERENCE = 10;

    /**
     * The feature id for the '<em><b>Entitytype</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE__ENTITYTYPE = 0;

    /**
     * The feature id for the '<em><b>Link Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE__LINK_TYPE = 1;

    /**
     * The number of structural features of the '<em>Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.impl.ValidationRuleImpl <em>Validation Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.impl.ValidationRuleImpl
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getValidationRule()
     * @generated
     */
    int VALIDATION_RULE = 11;

    /**
     * The feature id for the '<em><b>Param</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATION_RULE__PARAM = 0;

    /**
     * The feature id for the '<em><b>Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATION_RULE__CLASS = 1;

    /**
     * The feature id for the '<em><b>Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATION_RULE__HINT = 2;

    /**
     * The number of structural features of the '<em>Validation Rule</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATION_RULE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Validation Rule</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALIDATION_RULE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link de.sernet.eclipse.hitro.Inputtypes <em>Inputtypes</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.Inputtypes
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getInputtypes()
     * @generated
     */
    int INPUTTYPES = 12;

    /**
     * The meta object id for the '<em>Inputtypes Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.sernet.eclipse.hitro.Inputtypes
     * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getInputtypesObject()
     * @generated
     */
    int INPUTTYPES_OBJECT = 13;


    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.DefaultRule <em>Default Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Default Rule</em>'.
     * @see de.sernet.eclipse.hitro.DefaultRule
     * @generated
     */
    EClass getDefaultRule();

    /**
     * Returns the meta object for the containment reference list '{@link de.sernet.eclipse.hitro.DefaultRule#getParam <em>Param</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Param</em>'.
     * @see de.sernet.eclipse.hitro.DefaultRule#getParam()
     * @see #getDefaultRule()
     * @generated
     */
    EReference getDefaultRule_Param();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.DefaultRule#getClass_ <em>Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Class</em>'.
     * @see de.sernet.eclipse.hitro.DefaultRule#getClass_()
     * @see #getDefaultRule()
     * @generated
     */
    EAttribute getDefaultRule_Class();

    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.Depends <em>Depends</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Depends</em>'.
     * @see de.sernet.eclipse.hitro.Depends
     * @generated
     */
    EClass getDepends();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Depends#isInverse <em>Inverse</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Inverse</em>'.
     * @see de.sernet.eclipse.hitro.Depends#isInverse()
     * @see #getDepends()
     * @generated
     */
    EAttribute getDepends_Inverse();

    /**
     * Returns the meta object for the reference '{@link de.sernet.eclipse.hitro.Depends#getOption <em>Option</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Option</em>'.
     * @see de.sernet.eclipse.hitro.Depends#getOption()
     * @see #getDepends()
     * @generated
     */
    EReference getDepends_Option();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Depends#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.sernet.eclipse.hitro.Depends#getValue()
     * @see #getDepends()
     * @generated
     */
    EAttribute getDepends_Value();

    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Document Root</em>'.
     * @see de.sernet.eclipse.hitro.DocumentRoot
     * @generated
     */
    EClass getDocumentRoot();

    /**
     * Returns the meta object for the attribute list '{@link de.sernet.eclipse.hitro.DocumentRoot#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see de.sernet.eclipse.hitro.DocumentRoot#getMixed()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_Mixed();

    /**
     * Returns the meta object for the map '{@link de.sernet.eclipse.hitro.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
     * @see de.sernet.eclipse.hitro.DocumentRoot#getXMLNSPrefixMap()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XMLNSPrefixMap();

    /**
     * Returns the meta object for the map '{@link de.sernet.eclipse.hitro.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XSI Schema Location</em>'.
     * @see de.sernet.eclipse.hitro.DocumentRoot#getXSISchemaLocation()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XSISchemaLocation();

    /**
     * Returns the meta object for the containment reference '{@link de.sernet.eclipse.hitro.DocumentRoot#getHuientities <em>Huientities</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Huientities</em>'.
     * @see de.sernet.eclipse.hitro.DocumentRoot#getHuientities()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Huientities();

    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.Huientities <em>Huientities</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Huientities</em>'.
     * @see de.sernet.eclipse.hitro.Huientities
     * @generated
     */
    EClass getHuientities();

    /**
     * Returns the meta object for the containment reference list '{@link de.sernet.eclipse.hitro.Huientities#getHuientity <em>Huientity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Huientity</em>'.
     * @see de.sernet.eclipse.hitro.Huientities#getHuientity()
     * @see #getHuientities()
     * @generated
     */
    EReference getHuientities_Huientity();

    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.Huientity <em>Huientity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Huientity</em>'.
     * @see de.sernet.eclipse.hitro.Huientity
     * @generated
     */
    EClass getHuientity();

    /**
     * Returns the meta object for the attribute list '{@link de.sernet.eclipse.hitro.Huientity#getGroup <em>Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Group</em>'.
     * @see de.sernet.eclipse.hitro.Huientity#getGroup()
     * @see #getHuientity()
     * @generated
     */
    EAttribute getHuientity_Group();

    /**
     * Returns the meta object for the containment reference list '{@link de.sernet.eclipse.hitro.Huientity#getHuiproperty <em>Huiproperty</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Huiproperty</em>'.
     * @see de.sernet.eclipse.hitro.Huientity#getHuiproperty()
     * @see #getHuientity()
     * @generated
     */
    EReference getHuientity_Huiproperty();

    /**
     * Returns the meta object for the containment reference list '{@link de.sernet.eclipse.hitro.Huientity#getHuipropertygroup <em>Huipropertygroup</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Huipropertygroup</em>'.
     * @see de.sernet.eclipse.hitro.Huientity#getHuipropertygroup()
     * @see #getHuientity()
     * @generated
     */
    EReference getHuientity_Huipropertygroup();

    /**
     * Returns the meta object for the containment reference list '{@link de.sernet.eclipse.hitro.Huientity#getHuirelation <em>Huirelation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Huirelation</em>'.
     * @see de.sernet.eclipse.hitro.Huientity#getHuirelation()
     * @see #getHuientity()
     * @generated
     */
    EReference getHuientity_Huirelation();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huientity#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see de.sernet.eclipse.hitro.Huientity#getId()
     * @see #getHuientity()
     * @generated
     */
    EAttribute getHuientity_Id();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huientity#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.sernet.eclipse.hitro.Huientity#getName()
     * @see #getHuientity()
     * @generated
     */
    EAttribute getHuientity_Name();

    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.Huiproperty <em>Huiproperty</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Huiproperty</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty
     * @generated
     */
    EClass getHuiproperty();

    /**
     * Returns the meta object for the containment reference list '{@link de.sernet.eclipse.hitro.Huiproperty#getDepends <em>Depends</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Depends</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getDepends()
     * @see #getHuiproperty()
     * @generated
     */
    EReference getHuiproperty_Depends();

    /**
     * Returns the meta object for the containment reference '{@link de.sernet.eclipse.hitro.Huiproperty#getReferences <em>References</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>References</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getReferences()
     * @see #getHuiproperty()
     * @generated
     */
    EReference getHuiproperty_References();

    /**
     * Returns the meta object for the containment reference '{@link de.sernet.eclipse.hitro.Huiproperty#getDefaultRule <em>Default Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Default Rule</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getDefaultRule()
     * @see #getHuiproperty()
     * @generated
     */
    EReference getHuiproperty_DefaultRule();

    /**
     * Returns the meta object for the containment reference list '{@link de.sernet.eclipse.hitro.Huiproperty#getValidationRule <em>Validation Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Validation Rule</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getValidationRule()
     * @see #getHuiproperty()
     * @generated
     */
    EReference getHuiproperty_ValidationRule();

    /**
     * Returns the meta object for the containment reference list '{@link de.sernet.eclipse.hitro.Huiproperty#getOption <em>Option</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Option</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getOption()
     * @see #getHuiproperty()
     * @generated
     */
    EReference getHuiproperty_Option();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#isCrudButtons <em>Crud Buttons</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Crud Buttons</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#isCrudButtons()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_CrudButtons();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#getDefaultValue <em>Default Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Value</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getDefaultValue()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_DefaultValue();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#isEditable <em>Editable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Editable</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#isEditable()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Editable();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#isFocus <em>Focus</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Focus</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#isFocus()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Focus();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getId()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Id();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#getInputtype <em>Inputtype</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Inputtype</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getInputtype()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Inputtype();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#isIsURL <em>Is URL</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is URL</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#isIsURL()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_IsURL();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#getMax <em>Max</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getMax()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Max();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#getMin <em>Min</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Min</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getMin()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Min();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getName()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Name();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#isReport <em>Report</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Report</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#isReport()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Report();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#isRequired <em>Required</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Required</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#isRequired()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Required();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#isShowInObjectBrowser <em>Show In Object Browser</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Show In Object Browser</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#isShowInObjectBrowser()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_ShowInObjectBrowser();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#getTags <em>Tags</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tags</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getTags()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Tags();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#getTextrows <em>Textrows</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Textrows</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getTextrows()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Textrows();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#getTooltip <em>Tooltip</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tooltip</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#getTooltip()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Tooltip();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huiproperty#isVisible <em>Visible</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Visible</em>'.
     * @see de.sernet.eclipse.hitro.Huiproperty#isVisible()
     * @see #getHuiproperty()
     * @generated
     */
    EAttribute getHuiproperty_Visible();

    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.Huipropertygroup <em>Huipropertygroup</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Huipropertygroup</em>'.
     * @see de.sernet.eclipse.hitro.Huipropertygroup
     * @generated
     */
    EClass getHuipropertygroup();

    /**
     * Returns the meta object for the reference list '{@link de.sernet.eclipse.hitro.Huipropertygroup#getDepends <em>Depends</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Depends</em>'.
     * @see de.sernet.eclipse.hitro.Huipropertygroup#getDepends()
     * @see #getHuipropertygroup()
     * @generated
     */
    EReference getHuipropertygroup_Depends();

    /**
     * Returns the meta object for the containment reference list '{@link de.sernet.eclipse.hitro.Huipropertygroup#getHuiproperty <em>Huiproperty</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Huiproperty</em>'.
     * @see de.sernet.eclipse.hitro.Huipropertygroup#getHuiproperty()
     * @see #getHuipropertygroup()
     * @generated
     */
    EReference getHuipropertygroup_Huiproperty();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huipropertygroup#getColumns <em>Columns</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Columns</em>'.
     * @see de.sernet.eclipse.hitro.Huipropertygroup#getColumns()
     * @see #getHuipropertygroup()
     * @generated
     */
    EAttribute getHuipropertygroup_Columns();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huipropertygroup#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see de.sernet.eclipse.hitro.Huipropertygroup#getId()
     * @see #getHuipropertygroup()
     * @generated
     */
    EAttribute getHuipropertygroup_Id();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huipropertygroup#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.sernet.eclipse.hitro.Huipropertygroup#getName()
     * @see #getHuipropertygroup()
     * @generated
     */
    EAttribute getHuipropertygroup_Name();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huipropertygroup#getTags <em>Tags</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tags</em>'.
     * @see de.sernet.eclipse.hitro.Huipropertygroup#getTags()
     * @see #getHuipropertygroup()
     * @generated
     */
    EAttribute getHuipropertygroup_Tags();

    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.Huirelation <em>Huirelation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Huirelation</em>'.
     * @see de.sernet.eclipse.hitro.Huirelation
     * @generated
     */
    EClass getHuirelation();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huirelation#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see de.sernet.eclipse.hitro.Huirelation#getId()
     * @see #getHuirelation()
     * @generated
     */
    EAttribute getHuirelation_Id();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huirelation#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.sernet.eclipse.hitro.Huirelation#getName()
     * @see #getHuirelation()
     * @generated
     */
    EAttribute getHuirelation_Name();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huirelation#getReversename <em>Reversename</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Reversename</em>'.
     * @see de.sernet.eclipse.hitro.Huirelation#getReversename()
     * @see #getHuirelation()
     * @generated
     */
    EAttribute getHuirelation_Reversename();

    /**
     * Returns the meta object for the reference '{@link de.sernet.eclipse.hitro.Huirelation#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>To</em>'.
     * @see de.sernet.eclipse.hitro.Huirelation#getTo()
     * @see #getHuirelation()
     * @generated
     */
    EReference getHuirelation_To();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Huirelation#getTooltip <em>Tooltip</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tooltip</em>'.
     * @see de.sernet.eclipse.hitro.Huirelation#getTooltip()
     * @see #getHuirelation()
     * @generated
     */
    EAttribute getHuirelation_Tooltip();

    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.Option <em>Option</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Option</em>'.
     * @see de.sernet.eclipse.hitro.Option
     * @generated
     */
    EClass getOption();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Option#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see de.sernet.eclipse.hitro.Option#getId()
     * @see #getOption()
     * @generated
     */
    EAttribute getOption_Id();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Option#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.sernet.eclipse.hitro.Option#getName()
     * @see #getOption()
     * @generated
     */
    EAttribute getOption_Name();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Option#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.sernet.eclipse.hitro.Option#getValue()
     * @see #getOption()
     * @generated
     */
    EAttribute getOption_Value();

    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.Param <em>Param</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Param</em>'.
     * @see de.sernet.eclipse.hitro.Param
     * @generated
     */
    EClass getParam();

    /**
     * Returns the meta object for the attribute list '{@link de.sernet.eclipse.hitro.Param#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see de.sernet.eclipse.hitro.Param#getMixed()
     * @see #getParam()
     * @generated
     */
    EAttribute getParam_Mixed();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Param#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see de.sernet.eclipse.hitro.Param#getId()
     * @see #getParam()
     * @generated
     */
    EAttribute getParam_Id();

    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.Reference <em>Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reference</em>'.
     * @see de.sernet.eclipse.hitro.Reference
     * @generated
     */
    EClass getReference();

    /**
     * Returns the meta object for the reference '{@link de.sernet.eclipse.hitro.Reference#getEntitytype <em>Entitytype</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Entitytype</em>'.
     * @see de.sernet.eclipse.hitro.Reference#getEntitytype()
     * @see #getReference()
     * @generated
     */
    EReference getReference_Entitytype();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.Reference#getLinkType <em>Link Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Link Type</em>'.
     * @see de.sernet.eclipse.hitro.Reference#getLinkType()
     * @see #getReference()
     * @generated
     */
    EAttribute getReference_LinkType();

    /**
     * Returns the meta object for class '{@link de.sernet.eclipse.hitro.ValidationRule <em>Validation Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Validation Rule</em>'.
     * @see de.sernet.eclipse.hitro.ValidationRule
     * @generated
     */
    EClass getValidationRule();

    /**
     * Returns the meta object for the containment reference list '{@link de.sernet.eclipse.hitro.ValidationRule#getParam <em>Param</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Param</em>'.
     * @see de.sernet.eclipse.hitro.ValidationRule#getParam()
     * @see #getValidationRule()
     * @generated
     */
    EReference getValidationRule_Param();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.ValidationRule#getClass_ <em>Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Class</em>'.
     * @see de.sernet.eclipse.hitro.ValidationRule#getClass_()
     * @see #getValidationRule()
     * @generated
     */
    EAttribute getValidationRule_Class();

    /**
     * Returns the meta object for the attribute '{@link de.sernet.eclipse.hitro.ValidationRule#getHint <em>Hint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Hint</em>'.
     * @see de.sernet.eclipse.hitro.ValidationRule#getHint()
     * @see #getValidationRule()
     * @generated
     */
    EAttribute getValidationRule_Hint();

    /**
     * Returns the meta object for enum '{@link de.sernet.eclipse.hitro.Inputtypes <em>Inputtypes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Inputtypes</em>'.
     * @see de.sernet.eclipse.hitro.Inputtypes
     * @generated
     */
    EEnum getInputtypes();

    /**
     * Returns the meta object for data type '{@link de.sernet.eclipse.hitro.Inputtypes <em>Inputtypes Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Inputtypes Object</em>'.
     * @see de.sernet.eclipse.hitro.Inputtypes
     * @model instanceClass="de.sernet.eclipse.hitro.Inputtypes"
     *        extendedMetaData="name='inputtypes:Object' baseType='inputtypes'"
     * @generated
     */
    EDataType getInputtypesObject();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    HitroFactory getHitroFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.DefaultRuleImpl <em>Default Rule</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.DefaultRuleImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getDefaultRule()
         * @generated
         */
        EClass DEFAULT_RULE = eINSTANCE.getDefaultRule();

        /**
         * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEFAULT_RULE__PARAM = eINSTANCE.getDefaultRule_Param();

        /**
         * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEFAULT_RULE__CLASS = eINSTANCE.getDefaultRule_Class();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.DependsImpl <em>Depends</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.DependsImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getDepends()
         * @generated
         */
        EClass DEPENDS = eINSTANCE.getDepends();

        /**
         * The meta object literal for the '<em><b>Inverse</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEPENDS__INVERSE = eINSTANCE.getDepends_Inverse();

        /**
         * The meta object literal for the '<em><b>Option</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEPENDS__OPTION = eINSTANCE.getDepends_Option();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEPENDS__VALUE = eINSTANCE.getDepends_Value();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.DocumentRootImpl <em>Document Root</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.DocumentRootImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getDocumentRoot()
         * @generated
         */
        EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

        /**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

        /**
         * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

        /**
         * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

        /**
         * The meta object literal for the '<em><b>Huientities</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__HUIENTITIES = eINSTANCE.getDocumentRoot_Huientities();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.HuientitiesImpl <em>Huientities</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.HuientitiesImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getHuientities()
         * @generated
         */
        EClass HUIENTITIES = eINSTANCE.getHuientities();

        /**
         * The meta object literal for the '<em><b>Huientity</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIENTITIES__HUIENTITY = eINSTANCE.getHuientities_Huientity();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.HuientityImpl <em>Huientity</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.HuientityImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getHuientity()
         * @generated
         */
        EClass HUIENTITY = eINSTANCE.getHuientity();

        /**
         * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIENTITY__GROUP = eINSTANCE.getHuientity_Group();

        /**
         * The meta object literal for the '<em><b>Huiproperty</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIENTITY__HUIPROPERTY = eINSTANCE.getHuientity_Huiproperty();

        /**
         * The meta object literal for the '<em><b>Huipropertygroup</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIENTITY__HUIPROPERTYGROUP = eINSTANCE.getHuientity_Huipropertygroup();

        /**
         * The meta object literal for the '<em><b>Huirelation</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIENTITY__HUIRELATION = eINSTANCE.getHuientity_Huirelation();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIENTITY__ID = eINSTANCE.getHuientity_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIENTITY__NAME = eINSTANCE.getHuientity_Name();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl <em>Huiproperty</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.HuipropertyImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getHuiproperty()
         * @generated
         */
        EClass HUIPROPERTY = eINSTANCE.getHuiproperty();

        /**
         * The meta object literal for the '<em><b>Depends</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIPROPERTY__DEPENDS = eINSTANCE.getHuiproperty_Depends();

        /**
         * The meta object literal for the '<em><b>References</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIPROPERTY__REFERENCES = eINSTANCE.getHuiproperty_References();

        /**
         * The meta object literal for the '<em><b>Default Rule</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIPROPERTY__DEFAULT_RULE = eINSTANCE.getHuiproperty_DefaultRule();

        /**
         * The meta object literal for the '<em><b>Validation Rule</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIPROPERTY__VALIDATION_RULE = eINSTANCE.getHuiproperty_ValidationRule();

        /**
         * The meta object literal for the '<em><b>Option</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIPROPERTY__OPTION = eINSTANCE.getHuiproperty_Option();

        /**
         * The meta object literal for the '<em><b>Crud Buttons</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__CRUD_BUTTONS = eINSTANCE.getHuiproperty_CrudButtons();

        /**
         * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__DEFAULT_VALUE = eINSTANCE.getHuiproperty_DefaultValue();

        /**
         * The meta object literal for the '<em><b>Editable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__EDITABLE = eINSTANCE.getHuiproperty_Editable();

        /**
         * The meta object literal for the '<em><b>Focus</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__FOCUS = eINSTANCE.getHuiproperty_Focus();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__ID = eINSTANCE.getHuiproperty_Id();

        /**
         * The meta object literal for the '<em><b>Inputtype</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__INPUTTYPE = eINSTANCE.getHuiproperty_Inputtype();

        /**
         * The meta object literal for the '<em><b>Is URL</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__IS_URL = eINSTANCE.getHuiproperty_IsURL();

        /**
         * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__MAX = eINSTANCE.getHuiproperty_Max();

        /**
         * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__MIN = eINSTANCE.getHuiproperty_Min();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__NAME = eINSTANCE.getHuiproperty_Name();

        /**
         * The meta object literal for the '<em><b>Report</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__REPORT = eINSTANCE.getHuiproperty_Report();

        /**
         * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__REQUIRED = eINSTANCE.getHuiproperty_Required();

        /**
         * The meta object literal for the '<em><b>Show In Object Browser</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__SHOW_IN_OBJECT_BROWSER = eINSTANCE.getHuiproperty_ShowInObjectBrowser();

        /**
         * The meta object literal for the '<em><b>Tags</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__TAGS = eINSTANCE.getHuiproperty_Tags();

        /**
         * The meta object literal for the '<em><b>Textrows</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__TEXTROWS = eINSTANCE.getHuiproperty_Textrows();

        /**
         * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__TOOLTIP = eINSTANCE.getHuiproperty_Tooltip();

        /**
         * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTY__VISIBLE = eINSTANCE.getHuiproperty_Visible();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.HuipropertygroupImpl <em>Huipropertygroup</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.HuipropertygroupImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getHuipropertygroup()
         * @generated
         */
        EClass HUIPROPERTYGROUP = eINSTANCE.getHuipropertygroup();

        /**
         * The meta object literal for the '<em><b>Depends</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIPROPERTYGROUP__DEPENDS = eINSTANCE.getHuipropertygroup_Depends();

        /**
         * The meta object literal for the '<em><b>Huiproperty</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIPROPERTYGROUP__HUIPROPERTY = eINSTANCE.getHuipropertygroup_Huiproperty();

        /**
         * The meta object literal for the '<em><b>Columns</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTYGROUP__COLUMNS = eINSTANCE.getHuipropertygroup_Columns();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTYGROUP__ID = eINSTANCE.getHuipropertygroup_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTYGROUP__NAME = eINSTANCE.getHuipropertygroup_Name();

        /**
         * The meta object literal for the '<em><b>Tags</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIPROPERTYGROUP__TAGS = eINSTANCE.getHuipropertygroup_Tags();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.HuirelationImpl <em>Huirelation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.HuirelationImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getHuirelation()
         * @generated
         */
        EClass HUIRELATION = eINSTANCE.getHuirelation();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIRELATION__ID = eINSTANCE.getHuirelation_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIRELATION__NAME = eINSTANCE.getHuirelation_Name();

        /**
         * The meta object literal for the '<em><b>Reversename</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIRELATION__REVERSENAME = eINSTANCE.getHuirelation_Reversename();

        /**
         * The meta object literal for the '<em><b>To</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HUIRELATION__TO = eINSTANCE.getHuirelation_To();

        /**
         * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HUIRELATION__TOOLTIP = eINSTANCE.getHuirelation_Tooltip();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.OptionImpl <em>Option</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.OptionImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getOption()
         * @generated
         */
        EClass OPTION = eINSTANCE.getOption();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPTION__ID = eINSTANCE.getOption_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPTION__NAME = eINSTANCE.getOption_Name();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPTION__VALUE = eINSTANCE.getOption_Value();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.ParamImpl <em>Param</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.ParamImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getParam()
         * @generated
         */
        EClass PARAM = eINSTANCE.getParam();

        /**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAM__MIXED = eINSTANCE.getParam_Mixed();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PARAM__ID = eINSTANCE.getParam_Id();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.ReferenceImpl <em>Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.ReferenceImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getReference()
         * @generated
         */
        EClass REFERENCE = eINSTANCE.getReference();

        /**
         * The meta object literal for the '<em><b>Entitytype</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REFERENCE__ENTITYTYPE = eINSTANCE.getReference_Entitytype();

        /**
         * The meta object literal for the '<em><b>Link Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REFERENCE__LINK_TYPE = eINSTANCE.getReference_LinkType();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.impl.ValidationRuleImpl <em>Validation Rule</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.impl.ValidationRuleImpl
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getValidationRule()
         * @generated
         */
        EClass VALIDATION_RULE = eINSTANCE.getValidationRule();

        /**
         * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VALIDATION_RULE__PARAM = eINSTANCE.getValidationRule_Param();

        /**
         * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALIDATION_RULE__CLASS = eINSTANCE.getValidationRule_Class();

        /**
         * The meta object literal for the '<em><b>Hint</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALIDATION_RULE__HINT = eINSTANCE.getValidationRule_Hint();

        /**
         * The meta object literal for the '{@link de.sernet.eclipse.hitro.Inputtypes <em>Inputtypes</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.Inputtypes
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getInputtypes()
         * @generated
         */
        EEnum INPUTTYPES = eINSTANCE.getInputtypes();

        /**
         * The meta object literal for the '<em>Inputtypes Object</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see de.sernet.eclipse.hitro.Inputtypes
         * @see de.sernet.eclipse.hitro.impl.HitroPackageImpl#getInputtypesObject()
         * @generated
         */
        EDataType INPUTTYPES_OBJECT = eINSTANCE.getInputtypesObject();

    }

} //HitroPackage
