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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.sernet.eclipse.hitro.Depends;
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Huipropertygroup;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Huipropertygroup</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuipropertygroupImpl#getDepends
 * <em>Depends</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuipropertygroupImpl#getHuiproperty
 * <em>Huiproperty</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuipropertygroupImpl#getColumns
 * <em>Columns</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuipropertygroupImpl#getId
 * <em>Id</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuipropertygroupImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.HuipropertygroupImpl#getTags
 * <em>Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HuipropertygroupImpl extends MinimalEObjectImpl.Container implements Huipropertygroup {
    /**
     * The cached value of the '{@link #getDepends() <em>Depends</em>}'
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDepends()
     * @generated
     * @ordered
     */
    protected EList<Depends> depends;

    /**
     * The cached value of the '{@link #getHuiproperty() <em>Huiproperty</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHuiproperty()
     * @generated
     * @ordered
     */
    protected EList<Huiproperty> huiproperty;

    /**
     * The default value of the '{@link #getColumns() <em>Columns</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getColumns()
     * @generated
     * @ordered
     */
    protected static final int COLUMNS_EDEFAULT = 1;

    /**
     * The cached value of the '{@link #getColumns() <em>Columns</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getColumns()
     * @generated
     * @ordered
     */
    protected int columns = COLUMNS_EDEFAULT;

    /**
     * This is true if the Columns attribute has been set. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    protected boolean columnsESet;

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
     * The default value of the '{@link #getTags() <em>Tags</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTags()
     * @generated
     * @ordered
     */
    protected static final String TAGS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTags() <em>Tags</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTags()
     * @generated
     * @ordered
     */
    protected String tags = TAGS_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected HuipropertygroupImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return HitroPackage.Literals.HUIPROPERTYGROUP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Depends> getDepends() {
        if (depends == null) {
            depends = new EObjectEList<Depends>(Depends.class, this,
                    HitroPackage.HUIPROPERTYGROUP__DEPENDS);
        }
        return depends;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<Huiproperty> getHuiproperty() {
        if (huiproperty == null) {
            huiproperty = new EObjectContainmentEList<Huiproperty>(Huiproperty.class, this,
                    HitroPackage.HUIPROPERTYGROUP__HUIPROPERTY);
        }
        return huiproperty;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getColumns() {
        return columns;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setColumns(int newColumns) {
        int oldColumns = columns;
        columns = newColumns;
        boolean oldColumnsESet = columnsESet;
        columnsESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HitroPackage.HUIPROPERTYGROUP__COLUMNS, oldColumns, columns, !oldColumnsESet));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void unsetColumns() {
        int oldColumns = columns;
        boolean oldColumnsESet = columnsESet;
        columns = COLUMNS_EDEFAULT;
        columnsESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET,
                    HitroPackage.HUIPROPERTYGROUP__COLUMNS, oldColumns, COLUMNS_EDEFAULT,
                    oldColumnsESet));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean isSetColumns() {
        return columnsESet;
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
            eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTYGROUP__ID,
                    oldId, id));
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
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HitroPackage.HUIPROPERTYGROUP__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getTags() {
        return tags;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setTags(String newTags) {
        String oldTags = tags;
        tags = newTags;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    HitroPackage.HUIPROPERTYGROUP__TAGS, oldTags, tags));
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
        case HitroPackage.HUIPROPERTYGROUP__HUIPROPERTY:
            return ((InternalEList<?>) getHuiproperty()).basicRemove(otherEnd, msgs);
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
        case HitroPackage.HUIPROPERTYGROUP__DEPENDS:
            return getDepends();
        case HitroPackage.HUIPROPERTYGROUP__HUIPROPERTY:
            return getHuiproperty();
        case HitroPackage.HUIPROPERTYGROUP__COLUMNS:
            return getColumns();
        case HitroPackage.HUIPROPERTYGROUP__ID:
            return getId();
        case HitroPackage.HUIPROPERTYGROUP__NAME:
            return getName();
        case HitroPackage.HUIPROPERTYGROUP__TAGS:
            return getTags();
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
        case HitroPackage.HUIPROPERTYGROUP__DEPENDS:
            getDepends().clear();
            getDepends().addAll((Collection<? extends Depends>) newValue);
            return;
        case HitroPackage.HUIPROPERTYGROUP__HUIPROPERTY:
            getHuiproperty().clear();
            getHuiproperty().addAll((Collection<? extends Huiproperty>) newValue);
            return;
        case HitroPackage.HUIPROPERTYGROUP__COLUMNS:
            setColumns((Integer) newValue);
            return;
        case HitroPackage.HUIPROPERTYGROUP__ID:
            setId((String) newValue);
            return;
        case HitroPackage.HUIPROPERTYGROUP__NAME:
            setName((String) newValue);
            return;
        case HitroPackage.HUIPROPERTYGROUP__TAGS:
            setTags((String) newValue);
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
        case HitroPackage.HUIPROPERTYGROUP__DEPENDS:
            getDepends().clear();
            return;
        case HitroPackage.HUIPROPERTYGROUP__HUIPROPERTY:
            getHuiproperty().clear();
            return;
        case HitroPackage.HUIPROPERTYGROUP__COLUMNS:
            unsetColumns();
            return;
        case HitroPackage.HUIPROPERTYGROUP__ID:
            setId(ID_EDEFAULT);
            return;
        case HitroPackage.HUIPROPERTYGROUP__NAME:
            setName(NAME_EDEFAULT);
            return;
        case HitroPackage.HUIPROPERTYGROUP__TAGS:
            setTags(TAGS_EDEFAULT);
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
        case HitroPackage.HUIPROPERTYGROUP__DEPENDS:
            return depends != null && !depends.isEmpty();
        case HitroPackage.HUIPROPERTYGROUP__HUIPROPERTY:
            return huiproperty != null && !huiproperty.isEmpty();
        case HitroPackage.HUIPROPERTYGROUP__COLUMNS:
            return isSetColumns();
        case HitroPackage.HUIPROPERTYGROUP__ID:
            return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
        case HitroPackage.HUIPROPERTYGROUP__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case HitroPackage.HUIPROPERTYGROUP__TAGS:
            return TAGS_EDEFAULT == null ? tags != null : !TAGS_EDEFAULT.equals(tags);
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
        result.append(" (columns: ");
        if (columnsESet)
            result.append(columns);
        else
            result.append("<unset>");
        result.append(", id: ");
        result.append(id);
        result.append(", name: ");
        result.append(name);
        result.append(", tags: ");
        result.append(tags);
        result.append(')');
        return result.toString();
    }

} // HuipropertygroupImpl
