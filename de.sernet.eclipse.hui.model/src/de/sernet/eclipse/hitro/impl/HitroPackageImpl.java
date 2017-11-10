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
package de.sernet.eclipse.hitro.impl;

import de.sernet.eclipse.hitro.DefaultRule;
import de.sernet.eclipse.hitro.Depends;
import de.sernet.eclipse.hitro.DocumentRoot;
import de.sernet.eclipse.hitro.HitroFactory;
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huientities;
import de.sernet.eclipse.hitro.Huientity;
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Huipropertygroup;
import de.sernet.eclipse.hitro.Huirelation;
import de.sernet.eclipse.hitro.Inputtypes;
import de.sernet.eclipse.hitro.Option;
import de.sernet.eclipse.hitro.Param;
import de.sernet.eclipse.hitro.Reference;
import de.sernet.eclipse.hitro.ValidationRule;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HitroPackageImpl extends EPackageImpl implements HitroPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass defaultRuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dependsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass documentRootEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass huientitiesEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass huientityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass huipropertyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass huipropertygroupEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass huirelationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass optionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass paramEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass referenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass validationRuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum inputtypesEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType inputtypesObjectEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.sernet.eclipse.hitro.HitroPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private HitroPackageImpl() {
        super(eNS_URI, HitroFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link HitroPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static HitroPackage init() {
        if (isInited) return (HitroPackage)EPackage.Registry.INSTANCE.getEPackage(HitroPackage.eNS_URI);

        // Obtain or create and register package
        HitroPackageImpl theHitroPackage = (HitroPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HitroPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HitroPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theHitroPackage.createPackageContents();

        // Initialize created meta-data
        theHitroPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theHitroPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(HitroPackage.eNS_URI, theHitroPackage);
        return theHitroPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDefaultRule() {
        return defaultRuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDefaultRule_Param() {
        return (EReference)defaultRuleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDefaultRule_Class() {
        return (EAttribute)defaultRuleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDepends() {
        return dependsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDepends_Inverse() {
        return (EAttribute)dependsEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDepends_Option() {
        return (EReference)dependsEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDepends_Value() {
        return (EAttribute)dependsEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDocumentRoot() {
        return documentRootEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentRoot_Mixed() {
        return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_XMLNSPrefixMap() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_XSISchemaLocation() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Huientities() {
        return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHuientities() {
        return huientitiesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuientities_Huientity() {
        return (EReference)huientitiesEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHuientity() {
        return huientityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuientity_Group() {
        return (EAttribute)huientityEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuientity_Huiproperty() {
        return (EReference)huientityEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuientity_Huipropertygroup() {
        return (EReference)huientityEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuientity_Huirelation() {
        return (EReference)huientityEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuientity_Id() {
        return (EAttribute)huientityEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuientity_Name() {
        return (EAttribute)huientityEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHuiproperty() {
        return huipropertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuiproperty_Depends() {
        return (EReference)huipropertyEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuiproperty_References() {
        return (EReference)huipropertyEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuiproperty_DefaultRule() {
        return (EReference)huipropertyEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuiproperty_ValidationRule() {
        return (EReference)huipropertyEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuiproperty_Option() {
        return (EReference)huipropertyEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_CrudButtons() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_DefaultValue() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Editable() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Focus() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Id() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Inputtype() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_IsURL() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Max() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Min() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Name() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Report() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Required() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_ShowInObjectBrowser() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Tags() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Textrows() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Tooltip() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuiproperty_Visible() {
        return (EAttribute)huipropertyEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHuipropertygroup() {
        return huipropertygroupEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuipropertygroup_Depends() {
        return (EReference)huipropertygroupEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuipropertygroup_Huiproperty() {
        return (EReference)huipropertygroupEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuipropertygroup_Columns() {
        return (EAttribute)huipropertygroupEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuipropertygroup_Id() {
        return (EAttribute)huipropertygroupEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuipropertygroup_Name() {
        return (EAttribute)huipropertygroupEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuipropertygroup_Tags() {
        return (EAttribute)huipropertygroupEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHuirelation() {
        return huirelationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuirelation_Id() {
        return (EAttribute)huirelationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuirelation_Name() {
        return (EAttribute)huirelationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuirelation_Reversename() {
        return (EAttribute)huirelationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getHuirelation_To() {
        return (EReference)huirelationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHuirelation_Tooltip() {
        return (EAttribute)huirelationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOption() {
        return optionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOption_Id() {
        return (EAttribute)optionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOption_Name() {
        return (EAttribute)optionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOption_Value() {
        return (EAttribute)optionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getParam() {
        return paramEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParam_Mixed() {
        return (EAttribute)paramEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getParam_Id() {
        return (EAttribute)paramEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReference() {
        return referenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getReference_Entitytype() {
        return (EReference)referenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReference_LinkType() {
        return (EAttribute)referenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getValidationRule() {
        return validationRuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getValidationRule_Param() {
        return (EReference)validationRuleEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValidationRule_Class() {
        return (EAttribute)validationRuleEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValidationRule_Hint() {
        return (EAttribute)validationRuleEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getInputtypes() {
        return inputtypesEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getInputtypesObject() {
        return inputtypesObjectEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HitroFactory getHitroFactory() {
        return (HitroFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        defaultRuleEClass = createEClass(DEFAULT_RULE);
        createEReference(defaultRuleEClass, DEFAULT_RULE__PARAM);
        createEAttribute(defaultRuleEClass, DEFAULT_RULE__CLASS);

        dependsEClass = createEClass(DEPENDS);
        createEAttribute(dependsEClass, DEPENDS__INVERSE);
        createEReference(dependsEClass, DEPENDS__OPTION);
        createEAttribute(dependsEClass, DEPENDS__VALUE);

        documentRootEClass = createEClass(DOCUMENT_ROOT);
        createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        createEReference(documentRootEClass, DOCUMENT_ROOT__HUIENTITIES);

        huientitiesEClass = createEClass(HUIENTITIES);
        createEReference(huientitiesEClass, HUIENTITIES__HUIENTITY);

        huientityEClass = createEClass(HUIENTITY);
        createEAttribute(huientityEClass, HUIENTITY__GROUP);
        createEReference(huientityEClass, HUIENTITY__HUIPROPERTY);
        createEReference(huientityEClass, HUIENTITY__HUIPROPERTYGROUP);
        createEReference(huientityEClass, HUIENTITY__HUIRELATION);
        createEAttribute(huientityEClass, HUIENTITY__ID);
        createEAttribute(huientityEClass, HUIENTITY__NAME);

        huipropertyEClass = createEClass(HUIPROPERTY);
        createEReference(huipropertyEClass, HUIPROPERTY__DEPENDS);
        createEReference(huipropertyEClass, HUIPROPERTY__REFERENCES);
        createEReference(huipropertyEClass, HUIPROPERTY__DEFAULT_RULE);
        createEReference(huipropertyEClass, HUIPROPERTY__VALIDATION_RULE);
        createEReference(huipropertyEClass, HUIPROPERTY__OPTION);
        createEAttribute(huipropertyEClass, HUIPROPERTY__CRUD_BUTTONS);
        createEAttribute(huipropertyEClass, HUIPROPERTY__DEFAULT_VALUE);
        createEAttribute(huipropertyEClass, HUIPROPERTY__EDITABLE);
        createEAttribute(huipropertyEClass, HUIPROPERTY__FOCUS);
        createEAttribute(huipropertyEClass, HUIPROPERTY__ID);
        createEAttribute(huipropertyEClass, HUIPROPERTY__INPUTTYPE);
        createEAttribute(huipropertyEClass, HUIPROPERTY__IS_URL);
        createEAttribute(huipropertyEClass, HUIPROPERTY__MAX);
        createEAttribute(huipropertyEClass, HUIPROPERTY__MIN);
        createEAttribute(huipropertyEClass, HUIPROPERTY__NAME);
        createEAttribute(huipropertyEClass, HUIPROPERTY__REPORT);
        createEAttribute(huipropertyEClass, HUIPROPERTY__REQUIRED);
        createEAttribute(huipropertyEClass, HUIPROPERTY__SHOW_IN_OBJECT_BROWSER);
        createEAttribute(huipropertyEClass, HUIPROPERTY__TAGS);
        createEAttribute(huipropertyEClass, HUIPROPERTY__TEXTROWS);
        createEAttribute(huipropertyEClass, HUIPROPERTY__TOOLTIP);
        createEAttribute(huipropertyEClass, HUIPROPERTY__VISIBLE);

        huipropertygroupEClass = createEClass(HUIPROPERTYGROUP);
        createEReference(huipropertygroupEClass, HUIPROPERTYGROUP__DEPENDS);
        createEReference(huipropertygroupEClass, HUIPROPERTYGROUP__HUIPROPERTY);
        createEAttribute(huipropertygroupEClass, HUIPROPERTYGROUP__COLUMNS);
        createEAttribute(huipropertygroupEClass, HUIPROPERTYGROUP__ID);
        createEAttribute(huipropertygroupEClass, HUIPROPERTYGROUP__NAME);
        createEAttribute(huipropertygroupEClass, HUIPROPERTYGROUP__TAGS);

        huirelationEClass = createEClass(HUIRELATION);
        createEAttribute(huirelationEClass, HUIRELATION__ID);
        createEAttribute(huirelationEClass, HUIRELATION__NAME);
        createEAttribute(huirelationEClass, HUIRELATION__REVERSENAME);
        createEReference(huirelationEClass, HUIRELATION__TO);
        createEAttribute(huirelationEClass, HUIRELATION__TOOLTIP);

        optionEClass = createEClass(OPTION);
        createEAttribute(optionEClass, OPTION__ID);
        createEAttribute(optionEClass, OPTION__NAME);
        createEAttribute(optionEClass, OPTION__VALUE);

        paramEClass = createEClass(PARAM);
        createEAttribute(paramEClass, PARAM__MIXED);
        createEAttribute(paramEClass, PARAM__ID);

        referenceEClass = createEClass(REFERENCE);
        createEReference(referenceEClass, REFERENCE__ENTITYTYPE);
        createEAttribute(referenceEClass, REFERENCE__LINK_TYPE);

        validationRuleEClass = createEClass(VALIDATION_RULE);
        createEReference(validationRuleEClass, VALIDATION_RULE__PARAM);
        createEAttribute(validationRuleEClass, VALIDATION_RULE__CLASS);
        createEAttribute(validationRuleEClass, VALIDATION_RULE__HINT);

        // Create enums
        inputtypesEEnum = createEEnum(INPUTTYPES);

        // Create data types
        inputtypesObjectEDataType = createEDataType(INPUTTYPES_OBJECT);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes, features, and operations; add parameters
        initEClass(defaultRuleEClass, DefaultRule.class, "DefaultRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDefaultRule_Param(), this.getParam(), null, "param", null, 0, -1, DefaultRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDefaultRule_Class(), theXMLTypePackage.getString(), "class", null, 1, 1, DefaultRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dependsEClass, Depends.class, "Depends", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDepends_Inverse(), theXMLTypePackage.getBoolean(), "inverse", "false", 0, 1, Depends.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDepends_Option(), this.getHuiproperty(), null, "option", null, 1, 1, Depends.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDepends_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, Depends.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDocumentRoot_Huientities(), this.getHuientities(), null, "huientities", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

        initEClass(huientitiesEClass, Huientities.class, "Huientities", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getHuientities_Huientity(), this.getHuientity(), null, "huientity", null, 1, -1, Huientities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(huientityEClass, Huientity.class, "Huientity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getHuientity_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, Huientity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHuientity_Huiproperty(), this.getHuiproperty(), null, "huiproperty", null, 0, -1, Huientity.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getHuientity_Huipropertygroup(), this.getHuipropertygroup(), null, "huipropertygroup", null, 0, -1, Huientity.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getHuientity_Huirelation(), this.getHuirelation(), null, "huirelation", null, 0, -1, Huientity.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuientity_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, Huientity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuientity_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Huientity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(huipropertyEClass, Huiproperty.class, "Huiproperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getHuiproperty_Depends(), this.getDepends(), null, "depends", null, 0, -1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHuiproperty_References(), this.getReference(), null, "references", null, 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHuiproperty_DefaultRule(), this.getDefaultRule(), null, "defaultRule", null, 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHuiproperty_ValidationRule(), this.getValidationRule(), null, "validationRule", null, 0, -1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHuiproperty_Option(), this.getOption(), null, "option", null, 0, -1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_CrudButtons(), theXMLTypePackage.getBoolean(), "crudButtons", "false", 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_DefaultValue(), theXMLTypePackage.getInt(), "defaultValue", "0", 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Editable(), theXMLTypePackage.getBoolean(), "editable", "true", 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Focus(), theXMLTypePackage.getBoolean(), "focus", "false", 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Inputtype(), this.getInputtypes(), "inputtype", "line", 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_IsURL(), theXMLTypePackage.getBoolean(), "isURL", "false", 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Max(), theXMLTypePackage.getInt(), "max", null, 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Min(), theXMLTypePackage.getInt(), "min", null, 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Report(), theXMLTypePackage.getBoolean(), "report", "true", 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Required(), theXMLTypePackage.getBoolean(), "required", "false", 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_ShowInObjectBrowser(), theXMLTypePackage.getBoolean(), "showInObjectBrowser", "false", 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Tags(), theXMLTypePackage.getString(), "tags", null, 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Textrows(), theXMLTypePackage.getInt(), "textrows", "4", 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Tooltip(), theXMLTypePackage.getString(), "tooltip", null, 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuiproperty_Visible(), theXMLTypePackage.getBoolean(), "visible", "true", 0, 1, Huiproperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(huipropertygroupEClass, Huipropertygroup.class, "Huipropertygroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getHuipropertygroup_Depends(), this.getDepends(), null, "depends", null, 0, -1, Huipropertygroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHuipropertygroup_Huiproperty(), this.getHuiproperty(), null, "huiproperty", null, 0, -1, Huipropertygroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuipropertygroup_Columns(), theXMLTypePackage.getInt(), "columns", "1", 0, 1, Huipropertygroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuipropertygroup_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, Huipropertygroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuipropertygroup_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Huipropertygroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuipropertygroup_Tags(), theXMLTypePackage.getString(), "tags", null, 0, 1, Huipropertygroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(huirelationEClass, Huirelation.class, "Huirelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getHuirelation_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, Huirelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuirelation_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Huirelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuirelation_Reversename(), theXMLTypePackage.getString(), "reversename", null, 0, 1, Huirelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getHuirelation_To(), this.getHuientity(), null, "to", null, 1, 1, Huirelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getHuirelation_Tooltip(), theXMLTypePackage.getString(), "tooltip", null, 0, 1, Huirelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(optionEClass, Option.class, "Option", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOption_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOption_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOption_Value(), theXMLTypePackage.getDecimal(), "value", null, 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(paramEClass, Param.class, "Param", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getParam_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getParam_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, Param.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getReference_Entitytype(), this.getHuientity(), null, "entitytype", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getReference_LinkType(), theXMLTypePackage.getIDREF(), "linkType", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(validationRuleEClass, ValidationRule.class, "ValidationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getValidationRule_Param(), this.getParam(), null, "param", null, 0, -1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getValidationRule_Class(), theXMLTypePackage.getString(), "class", null, 1, 1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getValidationRule_Hint(), theXMLTypePackage.getString(), "hint", null, 0, 1, ValidationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(inputtypesEEnum, Inputtypes.class, "Inputtypes");
        addEEnumLiteral(inputtypesEEnum, Inputtypes.LINE);
        addEEnumLiteral(inputtypesEEnum, Inputtypes.SINGLEOPTION);
        addEEnumLiteral(inputtypesEEnum, Inputtypes.MULTIOPTION);
        addEEnumLiteral(inputtypesEEnum, Inputtypes.TEXT);
        addEEnumLiteral(inputtypesEEnum, Inputtypes.REFERENCE);
        addEEnumLiteral(inputtypesEEnum, Inputtypes.CNALINK_REFERENCE);
        addEEnumLiteral(inputtypesEEnum, Inputtypes.DATE);
        addEEnumLiteral(inputtypesEEnum, Inputtypes.NUMERICOPTION);
        addEEnumLiteral(inputtypesEEnum, Inputtypes.BOOLEANOPTION);

        // Initialize data types
        initEDataType(inputtypesObjectEDataType, Inputtypes.class, "InputtypesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExtendedMetaDataAnnotations() {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
        addAnnotation
          (defaultRuleEClass, 
           source, 
           new String[] {
             "name", "defaultRule_._type",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getDefaultRule_Param(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "param"
           });	
        addAnnotation
          (getDefaultRule_Class(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "class"
           });	
        addAnnotation
          (dependsEClass, 
           source, 
           new String[] {
             "name", "dependstype",
             "kind", "empty"
           });	
        addAnnotation
          (getDepends_Inverse(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "inverse"
           });	
        addAnnotation
          (getDepends_Option(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "option"
           });	
        addAnnotation
          (getDepends_Value(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "value"
           });	
        addAnnotation
          (documentRootEClass, 
           source, 
           new String[] {
             "name", "",
             "kind", "mixed"
           });	
        addAnnotation
          (getDocumentRoot_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getDocumentRoot_XMLNSPrefixMap(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xmlns:prefix"
           });	
        addAnnotation
          (getDocumentRoot_XSISchemaLocation(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "xsi:schemaLocation"
           });	
        addAnnotation
          (getDocumentRoot_Huientities(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "huientities",
             "namespace", "##targetNamespace"
           });	
        addAnnotation
          (huientitiesEClass, 
           source, 
           new String[] {
             "name", "huientities_._type",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getHuientities_Huientity(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "huientity"
           });	
        addAnnotation
          (huientityEClass, 
           source, 
           new String[] {
             "name", "huientitytype",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getHuientity_Group(), 
           source, 
           new String[] {
             "kind", "group",
             "name", "group:0"
           });	
        addAnnotation
          (getHuientity_Huiproperty(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "huiproperty",
             "group", "#group:0"
           });	
        addAnnotation
          (getHuientity_Huipropertygroup(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "huipropertygroup",
             "group", "#group:0"
           });	
        addAnnotation
          (getHuientity_Huirelation(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "huirelation",
             "group", "#group:0"
           });	
        addAnnotation
          (getHuientity_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });	
        addAnnotation
          (getHuientity_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (huipropertyEClass, 
           source, 
           new String[] {
             "name", "huipropertytype",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getHuiproperty_Depends(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "depends"
           });	
        addAnnotation
          (getHuiproperty_References(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "references"
           });	
        addAnnotation
          (getHuiproperty_DefaultRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "defaultRule"
           });	
        addAnnotation
          (getHuiproperty_ValidationRule(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "validationRule"
           });	
        addAnnotation
          (getHuiproperty_Option(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "option"
           });	
        addAnnotation
          (getHuiproperty_CrudButtons(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "crudButtons"
           });	
        addAnnotation
          (getHuiproperty_DefaultValue(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "defaultValue"
           });	
        addAnnotation
          (getHuiproperty_Editable(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "editable"
           });	
        addAnnotation
          (getHuiproperty_Focus(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "focus"
           });	
        addAnnotation
          (getHuiproperty_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });	
        addAnnotation
          (getHuiproperty_Inputtype(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "inputtype"
           });	
        addAnnotation
          (getHuiproperty_IsURL(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "isURL"
           });	
        addAnnotation
          (getHuiproperty_Max(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "max"
           });	
        addAnnotation
          (getHuiproperty_Min(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "min"
           });	
        addAnnotation
          (getHuiproperty_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (getHuiproperty_Report(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "report"
           });	
        addAnnotation
          (getHuiproperty_Required(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "required"
           });	
        addAnnotation
          (getHuiproperty_ShowInObjectBrowser(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "showInObjectBrowser"
           });	
        addAnnotation
          (getHuiproperty_Tags(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "tags"
           });	
        addAnnotation
          (getHuiproperty_Textrows(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "textrows"
           });	
        addAnnotation
          (getHuiproperty_Tooltip(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "tooltip"
           });	
        addAnnotation
          (getHuiproperty_Visible(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "visible"
           });	
        addAnnotation
          (huipropertygroupEClass, 
           source, 
           new String[] {
             "name", "huipropertygrouptype",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getHuipropertygroup_Depends(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "depends"
           });	
        addAnnotation
          (getHuipropertygroup_Huiproperty(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "huiproperty"
           });	
        addAnnotation
          (getHuipropertygroup_Columns(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "columns"
           });	
        addAnnotation
          (getHuipropertygroup_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });	
        addAnnotation
          (getHuipropertygroup_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (getHuipropertygroup_Tags(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "tags"
           });	
        addAnnotation
          (huirelationEClass, 
           source, 
           new String[] {
             "name", "huirelationtype",
             "kind", "empty"
           });	
        addAnnotation
          (getHuirelation_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });	
        addAnnotation
          (getHuirelation_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (getHuirelation_Reversename(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "reversename"
           });	
        addAnnotation
          (getHuirelation_To(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "to"
           });	
        addAnnotation
          (getHuirelation_Tooltip(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "tooltip"
           });	
        addAnnotation
          (inputtypesEEnum, 
           source, 
           new String[] {
             "name", "inputtypes"
           });	
        addAnnotation
          (inputtypesObjectEDataType, 
           source, 
           new String[] {
             "name", "inputtypes:Object",
             "baseType", "inputtypes"
           });	
        addAnnotation
          (optionEClass, 
           source, 
           new String[] {
             "name", "option_._type",
             "kind", "empty"
           });	
        addAnnotation
          (getOption_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });	
        addAnnotation
          (getOption_Name(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "name"
           });	
        addAnnotation
          (getOption_Value(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "value"
           });	
        addAnnotation
          (paramEClass, 
           source, 
           new String[] {
             "name", "param",
             "kind", "mixed"
           });	
        addAnnotation
          (getParam_Mixed(), 
           source, 
           new String[] {
             "kind", "elementWildcard",
             "name", ":mixed"
           });	
        addAnnotation
          (getParam_Id(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "id"
           });	
        addAnnotation
          (referenceEClass, 
           source, 
           new String[] {
             "name", "referencestype",
             "kind", "empty"
           });	
        addAnnotation
          (getReference_Entitytype(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "entitytype"
           });	
        addAnnotation
          (getReference_LinkType(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "linkType"
           });	
        addAnnotation
          (validationRuleEClass, 
           source, 
           new String[] {
             "name", "validationRule_._type",
             "kind", "elementOnly"
           });	
        addAnnotation
          (getValidationRule_Param(), 
           source, 
           new String[] {
             "kind", "element",
             "name", "param"
           });	
        addAnnotation
          (getValidationRule_Class(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "class"
           });	
        addAnnotation
          (getValidationRule_Hint(), 
           source, 
           new String[] {
             "kind", "attribute",
             "name", "hint"
           });
    }

} //HitroPackageImpl
