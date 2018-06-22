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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huientity;
import de.sernet.eclipse.hitro.Reference;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.impl.ReferenceImpl#getEntitytype
 * <em>Entitytype</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.ReferenceImpl#getLinkType <em>Link
 * Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceImpl extends MinimalEObjectImpl.Container implements Reference {
    /**
     * The cached value of the '{@link #getEntitytype() <em>Entitytype</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEntitytype()
     * @generated
     * @ordered
     */
    protected Huientity entitytype;

    /**
     * The default value of the '{@link #getLinkType() <em>Link Type</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLinkType()
     * @generated
     * @ordered
     */
    protected static final String LINK_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLinkType() <em>Link Type</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLinkType()
     * @generated
     * @ordered
     */
    protected String linkType = LINK_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return HitroPackage.Literals.REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Huientity getEntitytype() {
        return entitytype;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setEntitytype(Huientity newEntitytype) {
        Huientity oldEntitytype = entitytype;
        entitytype = newEntitytype;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HitroPackage.REFERENCE__ENTITYTYPE, oldEntitytype, entitytype));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getLinkType() {
        return linkType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLinkType(String newLinkType) {
        String oldLinkType = linkType;
        linkType = newLinkType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.REFERENCE__LINK_TYPE,
                    oldLinkType, linkType));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case HitroPackage.REFERENCE__ENTITYTYPE:
            return getEntitytype();
        case HitroPackage.REFERENCE__LINK_TYPE:
            return getLinkType();
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
        case HitroPackage.REFERENCE__ENTITYTYPE:
            setEntitytype((Huientity) newValue);
            return;
        case HitroPackage.REFERENCE__LINK_TYPE:
            setLinkType((String) newValue);
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
        case HitroPackage.REFERENCE__ENTITYTYPE:
            setEntitytype((Huientity) null);
            return;
        case HitroPackage.REFERENCE__LINK_TYPE:
            setLinkType(LINK_TYPE_EDEFAULT);
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
        case HitroPackage.REFERENCE__ENTITYTYPE:
            return entitytype != null;
        case HitroPackage.REFERENCE__LINK_TYPE:
            return LINK_TYPE_EDEFAULT == null ? linkType != null
                    : !LINK_TYPE_EDEFAULT.equals(linkType);
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
        result.append(" (linkType: ");
        result.append(linkType);
        result.append(')');
        return result.toString();
    }

} // ReferenceImpl
