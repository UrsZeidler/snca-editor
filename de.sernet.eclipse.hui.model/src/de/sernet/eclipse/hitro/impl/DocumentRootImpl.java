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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import de.sernet.eclipse.hitro.DocumentRoot;
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huientities;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Document Root</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link de.sernet.eclipse.hitro.impl.DocumentRootImpl#getMixed
 * <em>Mixed</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.DocumentRootImpl#getXMLNSPrefixMap
 * <em>XMLNS Prefix Map</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.DocumentRootImpl#getXSISchemaLocation
 * <em>XSI Schema Location</em>}</li>
 * <li>{@link de.sernet.eclipse.hitro.impl.DocumentRootImpl#getHuientities
 * <em>Huientities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DocumentRootImpl extends MinimalEObjectImpl.Container implements DocumentRoot {
    /**
     * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getMixed()
     * @generated
     * @ordered
     */
    protected FeatureMap mixed;

    /**
     * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix
     * Map</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getXMLNSPrefixMap()
     * @generated
     * @ordered
     */
    protected EMap<String, String> xMLNSPrefixMap;

    /**
     * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema
     * Location</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getXSISchemaLocation()
     * @generated
     * @ordered
     */
    protected EMap<String, String> xSISchemaLocation;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DocumentRootImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return HitroPackage.Literals.DOCUMENT_ROOT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public FeatureMap getMixed() {
        if (mixed == null) {
            mixed = new BasicFeatureMap(this, HitroPackage.DOCUMENT_ROOT__MIXED);
        }
        return mixed;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EMap<String, String> getXMLNSPrefixMap() {
        if (xMLNSPrefixMap == null) {
            xMLNSPrefixMap = new EcoreEMap<String, String>(
                    EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
                    EStringToStringMapEntryImpl.class, this,
                    HitroPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
        }
        return xMLNSPrefixMap;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EMap<String, String> getXSISchemaLocation() {
        if (xSISchemaLocation == null) {
            xSISchemaLocation = new EcoreEMap<String, String>(
                    EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY,
                    EStringToStringMapEntryImpl.class, this,
                    HitroPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
        }
        return xSISchemaLocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Huientities getHuientities() {
        return (Huientities) getMixed().get(HitroPackage.Literals.DOCUMENT_ROOT__HUIENTITIES, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetHuientities(Huientities newHuientities,
            NotificationChain msgs) {
        return ((FeatureMap.Internal) getMixed())
                .basicAdd(HitroPackage.Literals.DOCUMENT_ROOT__HUIENTITIES, newHuientities, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setHuientities(Huientities newHuientities) {
        ((FeatureMap.Internal) getMixed()).set(HitroPackage.Literals.DOCUMENT_ROOT__HUIENTITIES,
                newHuientities);
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
        case HitroPackage.DOCUMENT_ROOT__MIXED:
            return ((InternalEList<?>) getMixed()).basicRemove(otherEnd, msgs);
        case HitroPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
            return ((InternalEList<?>) getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
        case HitroPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
            return ((InternalEList<?>) getXSISchemaLocation()).basicRemove(otherEnd, msgs);
        case HitroPackage.DOCUMENT_ROOT__HUIENTITIES:
            return basicSetHuientities(null, msgs);
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
        case HitroPackage.DOCUMENT_ROOT__MIXED:
            if (coreType)
                return getMixed();
            return ((FeatureMap.Internal) getMixed()).getWrapper();
        case HitroPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
            if (coreType)
                return getXMLNSPrefixMap();
            else
                return getXMLNSPrefixMap().map();
        case HitroPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
            if (coreType)
                return getXSISchemaLocation();
            else
                return getXSISchemaLocation().map();
        case HitroPackage.DOCUMENT_ROOT__HUIENTITIES:
            return getHuientities();
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
        case HitroPackage.DOCUMENT_ROOT__MIXED:
            ((FeatureMap.Internal) getMixed()).set(newValue);
            return;
        case HitroPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
            ((EStructuralFeature.Setting) getXMLNSPrefixMap()).set(newValue);
            return;
        case HitroPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
            ((EStructuralFeature.Setting) getXSISchemaLocation()).set(newValue);
            return;
        case HitroPackage.DOCUMENT_ROOT__HUIENTITIES:
            setHuientities((Huientities) newValue);
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
        case HitroPackage.DOCUMENT_ROOT__MIXED:
            getMixed().clear();
            return;
        case HitroPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
            getXMLNSPrefixMap().clear();
            return;
        case HitroPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
            getXSISchemaLocation().clear();
            return;
        case HitroPackage.DOCUMENT_ROOT__HUIENTITIES:
            setHuientities((Huientities) null);
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
        case HitroPackage.DOCUMENT_ROOT__MIXED:
            return mixed != null && !mixed.isEmpty();
        case HitroPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
            return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
        case HitroPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
            return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
        case HitroPackage.DOCUMENT_ROOT__HUIENTITIES:
            return getHuientities() != null;
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
        result.append(" (mixed: ");
        result.append(mixed);
        result.append(')');
        return result.toString();
    }

} // DocumentRootImpl
