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

import de.sernet.eclipse.hitro.Depends;
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huiproperty;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Depends</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.impl.DependsImpl#isInverse
 * <em>Inverse</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.DependsImpl#getOption
 * <em>Option</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.DependsImpl#getValue
 * <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependsImpl extends MinimalEObjectImpl.Container implements Depends {
    /**
     * The default value of the '{@link #isInverse() <em>Inverse</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isInverse()
     * @generated
     * @ordered
     */
    protected static final boolean INVERSE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isInverse() <em>Inverse</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isInverse()
     * @generated
     * @ordered
     */
    protected boolean inverse = INVERSE_EDEFAULT;

    /**
     * This is true if the Inverse attribute has been set. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    protected boolean inverseESet;

    /**
     * The cached value of the '{@link #getOption() <em>Option</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOption()
     * @generated
     * @ordered
     */
    protected Huiproperty option;

    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DependsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return HitroPackage.Literals.DEPENDS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isInverse() {
        return inverse;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setInverse(boolean newInverse) {
        boolean oldInverse = inverse;
        inverse = newInverse;
        boolean oldInverseESet = inverseESet;
        inverseESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.DEPENDS__INVERSE,
                    oldInverse, inverse, !oldInverseESet));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void unsetInverse() {
        boolean oldInverse = inverse;
        boolean oldInverseESet = inverseESet;
        inverse = INVERSE_EDEFAULT;
        inverseESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.DEPENDS__INVERSE,
                    oldInverse, INVERSE_EDEFAULT, oldInverseESet));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isSetInverse() {
        return inverseESet;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Huiproperty getOption() {
        return option;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setOption(Huiproperty newOption) {
        Huiproperty oldOption = option;
        option = newOption;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.DEPENDS__OPTION,
                    oldOption, option));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.DEPENDS__VALUE,
                    oldValue, value));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case HitroPackage.DEPENDS__INVERSE:
            return isInverse();
        case HitroPackage.DEPENDS__OPTION:
            return getOption();
        case HitroPackage.DEPENDS__VALUE:
            return getValue();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case HitroPackage.DEPENDS__INVERSE:
            setInverse((Boolean) newValue);
            return;
        case HitroPackage.DEPENDS__OPTION:
            setOption((Huiproperty) newValue);
            return;
        case HitroPackage.DEPENDS__VALUE:
            setValue((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case HitroPackage.DEPENDS__INVERSE:
            unsetInverse();
            return;
        case HitroPackage.DEPENDS__OPTION:
            setOption((Huiproperty) null);
            return;
        case HitroPackage.DEPENDS__VALUE:
            setValue(VALUE_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case HitroPackage.DEPENDS__INVERSE:
            return isSetInverse();
        case HitroPackage.DEPENDS__OPTION:
            return option != null;
        case HitroPackage.DEPENDS__VALUE:
            return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (inverse: ");
        if (inverseESet)
            result.append(inverse);
        else
            result.append("<unset>");
        result.append(", value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} // DependsImpl
