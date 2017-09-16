/**
 */
package de.sernet.eclipse.hitro.impl;

import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huientity;
import de.sernet.eclipse.hitro.Huirelation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Huirelation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuirelationImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuirelationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuirelationImpl#getReversename <em>Reversename</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuirelationImpl#getTo <em>To</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuirelationImpl#getTooltip <em>Tooltip</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HuirelationImpl extends MinimalEObjectImpl.Container implements Huirelation {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getReversename() <em>Reversename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReversename()
	 * @generated
	 * @ordered
	 */
	protected static final String REVERSENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReversename() <em>Reversename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReversename()
	 * @generated
	 * @ordered
	 */
	protected String reversename = REVERSENAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected Huientity to;

	/**
	 * The default value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltip()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOLTIP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltip()
	 * @generated
	 * @ordered
	 */
	protected String tooltip = TOOLTIP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HuirelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HitroPackage.Literals.HUIRELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIRELATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIRELATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReversename() {
		return reversename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReversename(String newReversename) {
		String oldReversename = reversename;
		reversename = newReversename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIRELATION__REVERSENAME, oldReversename, reversename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Huientity getTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(Huientity newTo) {
		Huientity oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIRELATION__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTooltip() {
		return tooltip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTooltip(String newTooltip) {
		String oldTooltip = tooltip;
		tooltip = newTooltip;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIRELATION__TOOLTIP, oldTooltip, tooltip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HitroPackage.HUIRELATION__ID:
				return getId();
			case HitroPackage.HUIRELATION__NAME:
				return getName();
			case HitroPackage.HUIRELATION__REVERSENAME:
				return getReversename();
			case HitroPackage.HUIRELATION__TO:
				return getTo();
			case HitroPackage.HUIRELATION__TOOLTIP:
				return getTooltip();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case HitroPackage.HUIRELATION__ID:
				setId((String)newValue);
				return;
			case HitroPackage.HUIRELATION__NAME:
				setName((String)newValue);
				return;
			case HitroPackage.HUIRELATION__REVERSENAME:
				setReversename((String)newValue);
				return;
			case HitroPackage.HUIRELATION__TO:
				setTo((Huientity)newValue);
				return;
			case HitroPackage.HUIRELATION__TOOLTIP:
				setTooltip((String)newValue);
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
			case HitroPackage.HUIRELATION__ID:
				setId(ID_EDEFAULT);
				return;
			case HitroPackage.HUIRELATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HitroPackage.HUIRELATION__REVERSENAME:
				setReversename(REVERSENAME_EDEFAULT);
				return;
			case HitroPackage.HUIRELATION__TO:
				setTo((Huientity)null);
				return;
			case HitroPackage.HUIRELATION__TOOLTIP:
				setTooltip(TOOLTIP_EDEFAULT);
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
			case HitroPackage.HUIRELATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case HitroPackage.HUIRELATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HitroPackage.HUIRELATION__REVERSENAME:
				return REVERSENAME_EDEFAULT == null ? reversename != null : !REVERSENAME_EDEFAULT.equals(reversename);
			case HitroPackage.HUIRELATION__TO:
				return to != null;
			case HitroPackage.HUIRELATION__TOOLTIP:
				return TOOLTIP_EDEFAULT == null ? tooltip != null : !TOOLTIP_EDEFAULT.equals(tooltip);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", reversename: ");
		result.append(reversename);
		result.append(", tooltip: ");
		result.append(tooltip);
		result.append(')');
		return result.toString();
	}

} //HuirelationImpl
