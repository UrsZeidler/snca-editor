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
import de.sernet.eclipse.hitro.Huientity;
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Huipropertygroup;
import de.sernet.eclipse.hitro.Huirelation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Huientity</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuientityImpl#getGroup
 * <em>Group</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuientityImpl#getHuiproperty
 * <em>Huiproperty</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuientityImpl#getHuipropertygroup
 * <em>Huipropertygroup</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuientityImpl#getHuirelation
 * <em>Huirelation</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuientityImpl#getId <em>Id</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuientityImpl#getName
 * <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HuientityImpl extends MinimalEObjectImpl.Container implements Huientity {
    /**
     * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getGroup()
     * @generated
     * @ordered
     */
    protected FeatureMap group;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected HuientityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return HitroPackage.Literals.HUIENTITY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public FeatureMap getGroup() {
        if (group == null) {
            group = new BasicFeatureMap(this, HitroPackage.HUIENTITY__GROUP);
        }
        return group;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Huiproperty> getHuiproperty() {
        return getGroup().list(HitroPackage.Literals.HUIENTITY__HUIPROPERTY);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Huipropertygroup> getHuipropertygroup() {
        return getGroup().list(HitroPackage.Literals.HUIENTITY__HUIPROPERTYGROUP);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Huirelation> getHuirelation() {
        return getGroup().list(HitroPackage.Literals.HUIENTITY__HUIRELATION);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setId(String newId) {
        String oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIENTITY__ID, oldId,
                    id));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIENTITY__NAME,
                    oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
            NotificationChain msgs) {
        switch (featureID) {
        case HitroPackage.HUIENTITY__GROUP:
            return ((InternalEList<?>) getGroup()).basicRemove(otherEnd, msgs);
        case HitroPackage.HUIENTITY__HUIPROPERTY:
            return ((InternalEList<?>) getHuiproperty()).basicRemove(otherEnd, msgs);
        case HitroPackage.HUIENTITY__HUIPROPERTYGROUP:
            return ((InternalEList<?>) getHuipropertygroup()).basicRemove(otherEnd, msgs);
        case HitroPackage.HUIENTITY__HUIRELATION:
            return ((InternalEList<?>) getHuirelation()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case HitroPackage.HUIENTITY__GROUP:
            if (coreType)
                return getGroup();
            return ((FeatureMap.Internal) getGroup()).getWrapper();
        case HitroPackage.HUIENTITY__HUIPROPERTY:
            return getHuiproperty();
        case HitroPackage.HUIENTITY__HUIPROPERTYGROUP:
            return getHuipropertygroup();
        case HitroPackage.HUIENTITY__HUIRELATION:
            return getHuirelation();
        case HitroPackage.HUIENTITY__ID:
            return getId();
        case HitroPackage.HUIENTITY__NAME:
            return getName();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case HitroPackage.HUIENTITY__GROUP:
            ((FeatureMap.Internal) getGroup()).set(newValue);
            return;
        case HitroPackage.HUIENTITY__HUIPROPERTY:
            getHuiproperty().clear();
            getHuiproperty().addAll((Collection<? extends Huiproperty>) newValue);
            return;
        case HitroPackage.HUIENTITY__HUIPROPERTYGROUP:
            getHuipropertygroup().clear();
            getHuipropertygroup().addAll((Collection<? extends Huipropertygroup>) newValue);
            return;
        case HitroPackage.HUIENTITY__HUIRELATION:
            getHuirelation().clear();
            getHuirelation().addAll((Collection<? extends Huirelation>) newValue);
            return;
        case HitroPackage.HUIENTITY__ID:
            setId((String) newValue);
            return;
        case HitroPackage.HUIENTITY__NAME:
            setName((String) newValue);
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
        case HitroPackage.HUIENTITY__GROUP:
            getGroup().clear();
            return;
        case HitroPackage.HUIENTITY__HUIPROPERTY:
            getHuiproperty().clear();
            return;
        case HitroPackage.HUIENTITY__HUIPROPERTYGROUP:
            getHuipropertygroup().clear();
            return;
        case HitroPackage.HUIENTITY__HUIRELATION:
            getHuirelation().clear();
            return;
        case HitroPackage.HUIENTITY__ID:
            setId(ID_EDEFAULT);
            return;
        case HitroPackage.HUIENTITY__NAME:
            setName(NAME_EDEFAULT);
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
        case HitroPackage.HUIENTITY__GROUP:
            return group != null && !group.isEmpty();
        case HitroPackage.HUIENTITY__HUIPROPERTY:
            return !getHuiproperty().isEmpty();
        case HitroPackage.HUIENTITY__HUIPROPERTYGROUP:
            return !getHuipropertygroup().isEmpty();
        case HitroPackage.HUIENTITY__HUIRELATION:
            return !getHuirelation().isEmpty();
        case HitroPackage.HUIENTITY__ID:
            return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
        case HitroPackage.HUIENTITY__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
        result.append(" (group: ");
        result.append(group);
        result.append(", id: ");
        result.append(id);
        result.append(", name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} // HuientityImpl
