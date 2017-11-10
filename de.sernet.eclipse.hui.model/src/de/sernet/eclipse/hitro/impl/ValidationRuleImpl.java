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

import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Param;
import de.sernet.eclipse.hitro.ValidationRule;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validation Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.sernet.eclipse.hitro.impl.ValidationRuleImpl#getParam <em>Param</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.ValidationRuleImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.ValidationRuleImpl#getHint <em>Hint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValidationRuleImpl extends MinimalEObjectImpl.Container implements ValidationRule {
    /**
     * The cached value of the '{@link #getParam() <em>Param</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParam()
     * @generated
     * @ordered
     */
    protected EList<Param> param;

    /**
     * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getClass_()
     * @generated
     * @ordered
     */
    protected static final String CLASS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getClass_()
     * @generated
     * @ordered
     */
    protected String class_ = CLASS_EDEFAULT;

    /**
     * The default value of the '{@link #getHint() <em>Hint</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHint()
     * @generated
     * @ordered
     */
    protected static final String HINT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHint() <em>Hint</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHint()
     * @generated
     * @ordered
     */
    protected String hint = HINT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValidationRuleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return HitroPackage.Literals.VALIDATION_RULE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Param> getParam() {
        if (param == null) {
            param = new EObjectContainmentEList<Param>(Param.class, this, HitroPackage.VALIDATION_RULE__PARAM);
        }
        return param;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getClass_() {
        return class_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setClass(String newClass) {
        String oldClass = class_;
        class_ = newClass;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.VALIDATION_RULE__CLASS, oldClass, class_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHint() {
        return hint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHint(String newHint) {
        String oldHint = hint;
        hint = newHint;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.VALIDATION_RULE__HINT, oldHint, hint));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case HitroPackage.VALIDATION_RULE__PARAM:
                return ((InternalEList<?>)getParam()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case HitroPackage.VALIDATION_RULE__PARAM:
                return getParam();
            case HitroPackage.VALIDATION_RULE__CLASS:
                return getClass_();
            case HitroPackage.VALIDATION_RULE__HINT:
                return getHint();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case HitroPackage.VALIDATION_RULE__PARAM:
                getParam().clear();
                getParam().addAll((Collection<? extends Param>)newValue);
                return;
            case HitroPackage.VALIDATION_RULE__CLASS:
                setClass((String)newValue);
                return;
            case HitroPackage.VALIDATION_RULE__HINT:
                setHint((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case HitroPackage.VALIDATION_RULE__PARAM:
                getParam().clear();
                return;
            case HitroPackage.VALIDATION_RULE__CLASS:
                setClass(CLASS_EDEFAULT);
                return;
            case HitroPackage.VALIDATION_RULE__HINT:
                setHint(HINT_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case HitroPackage.VALIDATION_RULE__PARAM:
                return param != null && !param.isEmpty();
            case HitroPackage.VALIDATION_RULE__CLASS:
                return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
            case HitroPackage.VALIDATION_RULE__HINT:
                return HINT_EDEFAULT == null ? hint != null : !HINT_EDEFAULT.equals(hint);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (class: ");
        result.append(class_);
        result.append(", hint: ");
        result.append(hint);
        result.append(')');
        return result.toString();
    }

} //ValidationRuleImpl
