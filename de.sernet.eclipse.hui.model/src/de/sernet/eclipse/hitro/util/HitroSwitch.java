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
package de.sernet.eclipse.hitro.util;

import de.sernet.eclipse.hitro.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see de.sernet.eclipse.hitro.HitroPackage
 * @generated
 */
public class HitroSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static HitroPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public HitroSwitch() {
        if (modelPackage == null) {
            modelPackage = HitroPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns
     * a non null result; it yields that result. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code>
     *         call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case HitroPackage.DEFAULT_RULE: {
            DefaultRule defaultRule = (DefaultRule) theEObject;
            T result = caseDefaultRule(defaultRule);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case HitroPackage.DEPENDS: {
            Depends depends = (Depends) theEObject;
            T result = caseDepends(depends);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case HitroPackage.DOCUMENT_ROOT: {
            DocumentRoot documentRoot = (DocumentRoot) theEObject;
            T result = caseDocumentRoot(documentRoot);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case HitroPackage.HUIENTITIES: {
            Huientities huientities = (Huientities) theEObject;
            T result = caseHuientities(huientities);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case HitroPackage.HUIENTITY: {
            Huientity huientity = (Huientity) theEObject;
            T result = caseHuientity(huientity);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case HitroPackage.HUIPROPERTY: {
            Huiproperty huiproperty = (Huiproperty) theEObject;
            T result = caseHuiproperty(huiproperty);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case HitroPackage.HUIPROPERTYGROUP: {
            Huipropertygroup huipropertygroup = (Huipropertygroup) theEObject;
            T result = caseHuipropertygroup(huipropertygroup);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case HitroPackage.HUIRELATION: {
            Huirelation huirelation = (Huirelation) theEObject;
            T result = caseHuirelation(huirelation);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case HitroPackage.OPTION: {
            Option option = (Option) theEObject;
            T result = caseOption(option);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case HitroPackage.PARAM: {
            Param param = (Param) theEObject;
            T result = caseParam(param);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case HitroPackage.REFERENCE: {
            Reference reference = (Reference) theEObject;
            T result = caseReference(reference);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case HitroPackage.VALIDATION_RULE: {
            ValidationRule validationRule = (ValidationRule) theEObject;
            T result = caseValidationRule(validationRule);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Default Rule</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Default Rule</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDefaultRule(DefaultRule object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Depends</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Depends</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDepends(Depends object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Document Root</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Document Root</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentRoot(DocumentRoot object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Huientities</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Huientities</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHuientities(Huientities object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Huientity</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Huientity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHuientity(Huientity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Huiproperty</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Huiproperty</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHuiproperty(Huiproperty object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Huipropertygroup</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Huipropertygroup</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHuipropertygroup(Huipropertygroup object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Huirelation</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Huirelation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHuirelation(Huirelation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Option</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Option</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOption(Option object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Param</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Param</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParam(Param object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Reference</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReference(Reference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>Validation Rule</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>Validation Rule</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValidationRule(ValidationRule object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of
     * '<em>EObject</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch, but this is
     * the last case anyway. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of
     *         '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} // HitroSwitch
