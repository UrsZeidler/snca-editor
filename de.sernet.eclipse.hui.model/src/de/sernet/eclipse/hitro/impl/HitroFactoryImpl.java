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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

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

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class HitroFactoryImpl extends EFactoryImpl implements HitroFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static HitroFactory init() {
        try {
            HitroFactory theHitroFactory = (HitroFactory) EPackage.Registry.INSTANCE
                    .getEFactory(HitroPackage.eNS_URI);
            if (theHitroFactory != null) {
                return theHitroFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new HitroFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public HitroFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case HitroPackage.DEFAULT_RULE:
            return createDefaultRule();
        case HitroPackage.DEPENDS:
            return createDepends();
        case HitroPackage.DOCUMENT_ROOT:
            return createDocumentRoot();
        case HitroPackage.HUIENTITIES:
            return createHuientities();
        case HitroPackage.HUIENTITY:
            return createHuientity();
        case HitroPackage.HUIPROPERTY:
            return createHuiproperty();
        case HitroPackage.HUIPROPERTYGROUP:
            return createHuipropertygroup();
        case HitroPackage.HUIRELATION:
            return createHuirelation();
        case HitroPackage.OPTION:
            return createOption();
        case HitroPackage.PARAM:
            return createParam();
        case HitroPackage.REFERENCE:
            return createReference();
        case HitroPackage.VALIDATION_RULE:
            return createValidationRule();
        default:
            throw new IllegalArgumentException(
                    "The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
        case HitroPackage.INPUTTYPES:
            return createInputtypesFromString(eDataType, initialValue);
        case HitroPackage.INPUTTYPES_OBJECT:
            return createInputtypesObjectFromString(eDataType, initialValue);
        default:
            throw new IllegalArgumentException(
                    "The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
        case HitroPackage.INPUTTYPES:
            return convertInputtypesToString(eDataType, instanceValue);
        case HitroPackage.INPUTTYPES_OBJECT:
            return convertInputtypesObjectToString(eDataType, instanceValue);
        default:
            throw new IllegalArgumentException(
                    "The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DefaultRule createDefaultRule() {
        DefaultRuleImpl defaultRule = new DefaultRuleImpl();
        return defaultRule;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Depends createDepends() {
        DependsImpl depends = new DependsImpl();
        return depends;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DocumentRoot createDocumentRoot() {
        DocumentRootImpl documentRoot = new DocumentRootImpl();
        return documentRoot;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Huientities createHuientities() {
        HuientitiesImpl huientities = new HuientitiesImpl();
        return huientities;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Huientity createHuientity() {
        HuientityImpl huientity = new HuientityImpl();
        return huientity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Huiproperty createHuiproperty() {
        HuipropertyImpl huiproperty = new HuipropertyImpl();
        return huiproperty;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Huipropertygroup createHuipropertygroup() {
        HuipropertygroupImpl huipropertygroup = new HuipropertygroupImpl();
        return huipropertygroup;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Huirelation createHuirelation() {
        HuirelationImpl huirelation = new HuirelationImpl();
        return huirelation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Option createOption() {
        OptionImpl option = new OptionImpl();
        return option;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Param createParam() {
        ParamImpl param = new ParamImpl();
        return param;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Reference createReference() {
        ReferenceImpl reference = new ReferenceImpl();
        return reference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ValidationRule createValidationRule() {
        ValidationRuleImpl validationRule = new ValidationRuleImpl();
        return validationRule;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Inputtypes createInputtypesFromString(EDataType eDataType, String initialValue) {
        Inputtypes result = Inputtypes.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue
                    + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertInputtypesToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Inputtypes createInputtypesObjectFromString(EDataType eDataType, String initialValue) {
        return createInputtypesFromString(HitroPackage.Literals.INPUTTYPES, initialValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertInputtypesObjectToString(EDataType eDataType, Object instanceValue) {
        return convertInputtypesToString(HitroPackage.Literals.INPUTTYPES, instanceValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public HitroPackage getHitroPackage() {
        return (HitroPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static HitroPackage getPackage() {
        return HitroPackage.eINSTANCE;
    }

} // HitroFactoryImpl
