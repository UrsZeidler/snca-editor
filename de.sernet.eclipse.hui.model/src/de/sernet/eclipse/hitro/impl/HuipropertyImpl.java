/**
 */
package de.sernet.eclipse.hitro.impl;

import de.sernet.eclipse.hitro.DefaultRule;
import de.sernet.eclipse.hitro.Depends;
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Inputtypes;
import de.sernet.eclipse.hitro.Option;
import de.sernet.eclipse.hitro.Reference;
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
 * An implementation of the model object '<em><b>Huiproperty</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getDepends <em>Depends</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getReferences <em>References</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getDefaultRule <em>Default Rule</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getValidationRule <em>Validation Rule</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getOption <em>Option</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#isCrudButtons <em>Crud Buttons</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#isEditable <em>Editable</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#isFocus <em>Focus</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getInputtype <em>Inputtype</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#isIsURL <em>Is URL</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getMax <em>Max</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getMin <em>Min</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#isReport <em>Report</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#isShowInObjectBrowser <em>Show In Object Browser</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getTextrows <em>Textrows</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#getTooltip <em>Tooltip</em>}</li>
 *   <li>{@link de.sernet.eclipse.hitro.impl.HuipropertyImpl#isVisible <em>Visible</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HuipropertyImpl extends MinimalEObjectImpl.Container implements Huiproperty {
	/**
	 * The cached value of the '{@link #getDepends() <em>Depends</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepends()
	 * @generated
	 * @ordered
	 */
	protected EList<Depends> depends;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected Reference references;

	/**
	 * The cached value of the '{@link #getDefaultRule() <em>Default Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultRule()
	 * @generated
	 * @ordered
	 */
	protected DefaultRule defaultRule;

	/**
	 * The cached value of the '{@link #getValidationRule() <em>Validation Rule</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationRule()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidationRule> validationRule;

	/**
	 * The cached value of the '{@link #getOption() <em>Option</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOption()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> option;

	/**
	 * The default value of the '{@link #isCrudButtons() <em>Crud Buttons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCrudButtons()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CRUD_BUTTONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCrudButtons() <em>Crud Buttons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCrudButtons()
	 * @generated
	 * @ordered
	 */
	protected boolean crudButtons = CRUD_BUTTONS_EDEFAULT;

	/**
	 * This is true if the Crud Buttons attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean crudButtonsESet;

	/**
	 * The default value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected int defaultValue = DEFAULT_VALUE_EDEFAULT;

	/**
	 * This is true if the Default Value attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean defaultValueESet;

	/**
	 * The default value of the '{@link #isEditable() <em>Editable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEditable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EDITABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEditable() <em>Editable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEditable()
	 * @generated
	 * @ordered
	 */
	protected boolean editable = EDITABLE_EDEFAULT;

	/**
	 * This is true if the Editable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean editableESet;

	/**
	 * The default value of the '{@link #isFocus() <em>Focus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFocus()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FOCUS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFocus() <em>Focus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFocus()
	 * @generated
	 * @ordered
	 */
	protected boolean focus = FOCUS_EDEFAULT;

	/**
	 * This is true if the Focus attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean focusESet;

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
	 * The default value of the '{@link #getInputtype() <em>Inputtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputtype()
	 * @generated
	 * @ordered
	 */
	protected static final Inputtypes INPUTTYPE_EDEFAULT = Inputtypes.LINE;

	/**
	 * The cached value of the '{@link #getInputtype() <em>Inputtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputtype()
	 * @generated
	 * @ordered
	 */
	protected Inputtypes inputtype = INPUTTYPE_EDEFAULT;

	/**
	 * This is true if the Inputtype attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean inputtypeESet;

	/**
	 * The default value of the '{@link #isIsURL() <em>Is URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsURL()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_URL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsURL() <em>Is URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsURL()
	 * @generated
	 * @ordered
	 */
	protected boolean isURL = IS_URL_EDEFAULT;

	/**
	 * This is true if the Is URL attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isURLESet;

	/**
	 * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected int max = MAX_EDEFAULT;

	/**
	 * This is true if the Max attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maxESet;

	/**
	 * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected int min = MIN_EDEFAULT;

	/**
	 * This is true if the Min attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean minESet;

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
	 * The default value of the '{@link #isReport() <em>Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReport()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REPORT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isReport() <em>Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReport()
	 * @generated
	 * @ordered
	 */
	protected boolean report = REPORT_EDEFAULT;

	/**
	 * This is true if the Report attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean reportESet;

	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean required = REQUIRED_EDEFAULT;

	/**
	 * This is true if the Required attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean requiredESet;

	/**
	 * The default value of the '{@link #isShowInObjectBrowser() <em>Show In Object Browser</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowInObjectBrowser()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_IN_OBJECT_BROWSER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isShowInObjectBrowser() <em>Show In Object Browser</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowInObjectBrowser()
	 * @generated
	 * @ordered
	 */
	protected boolean showInObjectBrowser = SHOW_IN_OBJECT_BROWSER_EDEFAULT;

	/**
	 * This is true if the Show In Object Browser attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean showInObjectBrowserESet;

	/**
	 * The default value of the '{@link #getTags() <em>Tags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected static final String TAGS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected String tags = TAGS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTextrows() <em>Textrows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextrows()
	 * @generated
	 * @ordered
	 */
	protected static final int TEXTROWS_EDEFAULT = 4;

	/**
	 * The cached value of the '{@link #getTextrows() <em>Textrows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextrows()
	 * @generated
	 * @ordered
	 */
	protected int textrows = TEXTROWS_EDEFAULT;

	/**
	 * This is true if the Textrows attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean textrowsESet;

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
	 * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean visible = VISIBLE_EDEFAULT;

	/**
	 * This is true if the Visible attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean visibleESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HuipropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HitroPackage.Literals.HUIPROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Depends> getDepends() {
		if (depends == null) {
			depends = new EObjectContainmentEList<Depends>(Depends.class, this, HitroPackage.HUIPROPERTY__DEPENDS);
		}
		return depends;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getReferences() {
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferences(Reference newReferences, NotificationChain msgs) {
		Reference oldReferences = references;
		references = newReferences;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__REFERENCES, oldReferences, newReferences);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferences(Reference newReferences) {
		if (newReferences != references) {
			NotificationChain msgs = null;
			if (references != null)
				msgs = ((InternalEObject)references).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HitroPackage.HUIPROPERTY__REFERENCES, null, msgs);
			if (newReferences != null)
				msgs = ((InternalEObject)newReferences).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HitroPackage.HUIPROPERTY__REFERENCES, null, msgs);
			msgs = basicSetReferences(newReferences, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__REFERENCES, newReferences, newReferences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultRule getDefaultRule() {
		return defaultRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultRule(DefaultRule newDefaultRule, NotificationChain msgs) {
		DefaultRule oldDefaultRule = defaultRule;
		defaultRule = newDefaultRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__DEFAULT_RULE, oldDefaultRule, newDefaultRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultRule(DefaultRule newDefaultRule) {
		if (newDefaultRule != defaultRule) {
			NotificationChain msgs = null;
			if (defaultRule != null)
				msgs = ((InternalEObject)defaultRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HitroPackage.HUIPROPERTY__DEFAULT_RULE, null, msgs);
			if (newDefaultRule != null)
				msgs = ((InternalEObject)newDefaultRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HitroPackage.HUIPROPERTY__DEFAULT_RULE, null, msgs);
			msgs = basicSetDefaultRule(newDefaultRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__DEFAULT_RULE, newDefaultRule, newDefaultRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidationRule> getValidationRule() {
		if (validationRule == null) {
			validationRule = new EObjectContainmentEList<ValidationRule>(ValidationRule.class, this, HitroPackage.HUIPROPERTY__VALIDATION_RULE);
		}
		return validationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getOption() {
		if (option == null) {
			option = new EObjectContainmentEList<Option>(Option.class, this, HitroPackage.HUIPROPERTY__OPTION);
		}
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCrudButtons() {
		return crudButtons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrudButtons(boolean newCrudButtons) {
		boolean oldCrudButtons = crudButtons;
		crudButtons = newCrudButtons;
		boolean oldCrudButtonsESet = crudButtonsESet;
		crudButtonsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__CRUD_BUTTONS, oldCrudButtons, crudButtons, !oldCrudButtonsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCrudButtons() {
		boolean oldCrudButtons = crudButtons;
		boolean oldCrudButtonsESet = crudButtonsESet;
		crudButtons = CRUD_BUTTONS_EDEFAULT;
		crudButtonsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__CRUD_BUTTONS, oldCrudButtons, CRUD_BUTTONS_EDEFAULT, oldCrudButtonsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCrudButtons() {
		return crudButtonsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(int newDefaultValue) {
		int oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		boolean oldDefaultValueESet = defaultValueESet;
		defaultValueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__DEFAULT_VALUE, oldDefaultValue, defaultValue, !oldDefaultValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefaultValue() {
		int oldDefaultValue = defaultValue;
		boolean oldDefaultValueESet = defaultValueESet;
		defaultValue = DEFAULT_VALUE_EDEFAULT;
		defaultValueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__DEFAULT_VALUE, oldDefaultValue, DEFAULT_VALUE_EDEFAULT, oldDefaultValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefaultValue() {
		return defaultValueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditable(boolean newEditable) {
		boolean oldEditable = editable;
		editable = newEditable;
		boolean oldEditableESet = editableESet;
		editableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__EDITABLE, oldEditable, editable, !oldEditableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEditable() {
		boolean oldEditable = editable;
		boolean oldEditableESet = editableESet;
		editable = EDITABLE_EDEFAULT;
		editableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__EDITABLE, oldEditable, EDITABLE_EDEFAULT, oldEditableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEditable() {
		return editableESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFocus() {
		return focus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFocus(boolean newFocus) {
		boolean oldFocus = focus;
		focus = newFocus;
		boolean oldFocusESet = focusESet;
		focusESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__FOCUS, oldFocus, focus, !oldFocusESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFocus() {
		boolean oldFocus = focus;
		boolean oldFocusESet = focusESet;
		focus = FOCUS_EDEFAULT;
		focusESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__FOCUS, oldFocus, FOCUS_EDEFAULT, oldFocusESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFocus() {
		return focusESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inputtypes getInputtype() {
		return inputtype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputtype(Inputtypes newInputtype) {
		Inputtypes oldInputtype = inputtype;
		inputtype = newInputtype == null ? INPUTTYPE_EDEFAULT : newInputtype;
		boolean oldInputtypeESet = inputtypeESet;
		inputtypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__INPUTTYPE, oldInputtype, inputtype, !oldInputtypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInputtype() {
		Inputtypes oldInputtype = inputtype;
		boolean oldInputtypeESet = inputtypeESet;
		inputtype = INPUTTYPE_EDEFAULT;
		inputtypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__INPUTTYPE, oldInputtype, INPUTTYPE_EDEFAULT, oldInputtypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInputtype() {
		return inputtypeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsURL() {
		return isURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsURL(boolean newIsURL) {
		boolean oldIsURL = isURL;
		isURL = newIsURL;
		boolean oldIsURLESet = isURLESet;
		isURLESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__IS_URL, oldIsURL, isURL, !oldIsURLESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsURL() {
		boolean oldIsURL = isURL;
		boolean oldIsURLESet = isURLESet;
		isURL = IS_URL_EDEFAULT;
		isURLESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__IS_URL, oldIsURL, IS_URL_EDEFAULT, oldIsURLESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsURL() {
		return isURLESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax(int newMax) {
		int oldMax = max;
		max = newMax;
		boolean oldMaxESet = maxESet;
		maxESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__MAX, oldMax, max, !oldMaxESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMax() {
		int oldMax = max;
		boolean oldMaxESet = maxESet;
		max = MAX_EDEFAULT;
		maxESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__MAX, oldMax, MAX_EDEFAULT, oldMaxESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMax() {
		return maxESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin(int newMin) {
		int oldMin = min;
		min = newMin;
		boolean oldMinESet = minESet;
		minESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__MIN, oldMin, min, !oldMinESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMin() {
		int oldMin = min;
		boolean oldMinESet = minESet;
		min = MIN_EDEFAULT;
		minESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__MIN, oldMin, MIN_EDEFAULT, oldMinESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMin() {
		return minESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReport() {
		return report;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReport(boolean newReport) {
		boolean oldReport = report;
		report = newReport;
		boolean oldReportESet = reportESet;
		reportESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__REPORT, oldReport, report, !oldReportESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReport() {
		boolean oldReport = report;
		boolean oldReportESet = reportESet;
		report = REPORT_EDEFAULT;
		reportESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__REPORT, oldReport, REPORT_EDEFAULT, oldReportESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReport() {
		return reportESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(boolean newRequired) {
		boolean oldRequired = required;
		required = newRequired;
		boolean oldRequiredESet = requiredESet;
		requiredESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__REQUIRED, oldRequired, required, !oldRequiredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRequired() {
		boolean oldRequired = required;
		boolean oldRequiredESet = requiredESet;
		required = REQUIRED_EDEFAULT;
		requiredESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__REQUIRED, oldRequired, REQUIRED_EDEFAULT, oldRequiredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRequired() {
		return requiredESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShowInObjectBrowser() {
		return showInObjectBrowser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowInObjectBrowser(boolean newShowInObjectBrowser) {
		boolean oldShowInObjectBrowser = showInObjectBrowser;
		showInObjectBrowser = newShowInObjectBrowser;
		boolean oldShowInObjectBrowserESet = showInObjectBrowserESet;
		showInObjectBrowserESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__SHOW_IN_OBJECT_BROWSER, oldShowInObjectBrowser, showInObjectBrowser, !oldShowInObjectBrowserESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShowInObjectBrowser() {
		boolean oldShowInObjectBrowser = showInObjectBrowser;
		boolean oldShowInObjectBrowserESet = showInObjectBrowserESet;
		showInObjectBrowser = SHOW_IN_OBJECT_BROWSER_EDEFAULT;
		showInObjectBrowserESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__SHOW_IN_OBJECT_BROWSER, oldShowInObjectBrowser, SHOW_IN_OBJECT_BROWSER_EDEFAULT, oldShowInObjectBrowserESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShowInObjectBrowser() {
		return showInObjectBrowserESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTags(String newTags) {
		String oldTags = tags;
		tags = newTags;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__TAGS, oldTags, tags));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTextrows() {
		return textrows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextrows(int newTextrows) {
		int oldTextrows = textrows;
		textrows = newTextrows;
		boolean oldTextrowsESet = textrowsESet;
		textrowsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__TEXTROWS, oldTextrows, textrows, !oldTextrowsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextrows() {
		int oldTextrows = textrows;
		boolean oldTextrowsESet = textrowsESet;
		textrows = TEXTROWS_EDEFAULT;
		textrowsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__TEXTROWS, oldTextrows, TEXTROWS_EDEFAULT, oldTextrowsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextrows() {
		return textrowsESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__TOOLTIP, oldTooltip, tooltip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisible(boolean newVisible) {
		boolean oldVisible = visible;
		visible = newVisible;
		boolean oldVisibleESet = visibleESet;
		visibleESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HitroPackage.HUIPROPERTY__VISIBLE, oldVisible, visible, !oldVisibleESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVisible() {
		boolean oldVisible = visible;
		boolean oldVisibleESet = visibleESet;
		visible = VISIBLE_EDEFAULT;
		visibleESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, HitroPackage.HUIPROPERTY__VISIBLE, oldVisible, VISIBLE_EDEFAULT, oldVisibleESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVisible() {
		return visibleESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HitroPackage.HUIPROPERTY__DEPENDS:
				return ((InternalEList<?>)getDepends()).basicRemove(otherEnd, msgs);
			case HitroPackage.HUIPROPERTY__REFERENCES:
				return basicSetReferences(null, msgs);
			case HitroPackage.HUIPROPERTY__DEFAULT_RULE:
				return basicSetDefaultRule(null, msgs);
			case HitroPackage.HUIPROPERTY__VALIDATION_RULE:
				return ((InternalEList<?>)getValidationRule()).basicRemove(otherEnd, msgs);
			case HitroPackage.HUIPROPERTY__OPTION:
				return ((InternalEList<?>)getOption()).basicRemove(otherEnd, msgs);
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
			case HitroPackage.HUIPROPERTY__DEPENDS:
				return getDepends();
			case HitroPackage.HUIPROPERTY__REFERENCES:
				return getReferences();
			case HitroPackage.HUIPROPERTY__DEFAULT_RULE:
				return getDefaultRule();
			case HitroPackage.HUIPROPERTY__VALIDATION_RULE:
				return getValidationRule();
			case HitroPackage.HUIPROPERTY__OPTION:
				return getOption();
			case HitroPackage.HUIPROPERTY__CRUD_BUTTONS:
				return isCrudButtons();
			case HitroPackage.HUIPROPERTY__DEFAULT_VALUE:
				return getDefaultValue();
			case HitroPackage.HUIPROPERTY__EDITABLE:
				return isEditable();
			case HitroPackage.HUIPROPERTY__FOCUS:
				return isFocus();
			case HitroPackage.HUIPROPERTY__ID:
				return getId();
			case HitroPackage.HUIPROPERTY__INPUTTYPE:
				return getInputtype();
			case HitroPackage.HUIPROPERTY__IS_URL:
				return isIsURL();
			case HitroPackage.HUIPROPERTY__MAX:
				return getMax();
			case HitroPackage.HUIPROPERTY__MIN:
				return getMin();
			case HitroPackage.HUIPROPERTY__NAME:
				return getName();
			case HitroPackage.HUIPROPERTY__REPORT:
				return isReport();
			case HitroPackage.HUIPROPERTY__REQUIRED:
				return isRequired();
			case HitroPackage.HUIPROPERTY__SHOW_IN_OBJECT_BROWSER:
				return isShowInObjectBrowser();
			case HitroPackage.HUIPROPERTY__TAGS:
				return getTags();
			case HitroPackage.HUIPROPERTY__TEXTROWS:
				return getTextrows();
			case HitroPackage.HUIPROPERTY__TOOLTIP:
				return getTooltip();
			case HitroPackage.HUIPROPERTY__VISIBLE:
				return isVisible();
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
			case HitroPackage.HUIPROPERTY__DEPENDS:
				getDepends().clear();
				getDepends().addAll((Collection<? extends Depends>)newValue);
				return;
			case HitroPackage.HUIPROPERTY__REFERENCES:
				setReferences((Reference)newValue);
				return;
			case HitroPackage.HUIPROPERTY__DEFAULT_RULE:
				setDefaultRule((DefaultRule)newValue);
				return;
			case HitroPackage.HUIPROPERTY__VALIDATION_RULE:
				getValidationRule().clear();
				getValidationRule().addAll((Collection<? extends ValidationRule>)newValue);
				return;
			case HitroPackage.HUIPROPERTY__OPTION:
				getOption().clear();
				getOption().addAll((Collection<? extends Option>)newValue);
				return;
			case HitroPackage.HUIPROPERTY__CRUD_BUTTONS:
				setCrudButtons((Boolean)newValue);
				return;
			case HitroPackage.HUIPROPERTY__DEFAULT_VALUE:
				setDefaultValue((Integer)newValue);
				return;
			case HitroPackage.HUIPROPERTY__EDITABLE:
				setEditable((Boolean)newValue);
				return;
			case HitroPackage.HUIPROPERTY__FOCUS:
				setFocus((Boolean)newValue);
				return;
			case HitroPackage.HUIPROPERTY__ID:
				setId((String)newValue);
				return;
			case HitroPackage.HUIPROPERTY__INPUTTYPE:
				setInputtype((Inputtypes)newValue);
				return;
			case HitroPackage.HUIPROPERTY__IS_URL:
				setIsURL((Boolean)newValue);
				return;
			case HitroPackage.HUIPROPERTY__MAX:
				setMax((Integer)newValue);
				return;
			case HitroPackage.HUIPROPERTY__MIN:
				setMin((Integer)newValue);
				return;
			case HitroPackage.HUIPROPERTY__NAME:
				setName((String)newValue);
				return;
			case HitroPackage.HUIPROPERTY__REPORT:
				setReport((Boolean)newValue);
				return;
			case HitroPackage.HUIPROPERTY__REQUIRED:
				setRequired((Boolean)newValue);
				return;
			case HitroPackage.HUIPROPERTY__SHOW_IN_OBJECT_BROWSER:
				setShowInObjectBrowser((Boolean)newValue);
				return;
			case HitroPackage.HUIPROPERTY__TAGS:
				setTags((String)newValue);
				return;
			case HitroPackage.HUIPROPERTY__TEXTROWS:
				setTextrows((Integer)newValue);
				return;
			case HitroPackage.HUIPROPERTY__TOOLTIP:
				setTooltip((String)newValue);
				return;
			case HitroPackage.HUIPROPERTY__VISIBLE:
				setVisible((Boolean)newValue);
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
			case HitroPackage.HUIPROPERTY__DEPENDS:
				getDepends().clear();
				return;
			case HitroPackage.HUIPROPERTY__REFERENCES:
				setReferences((Reference)null);
				return;
			case HitroPackage.HUIPROPERTY__DEFAULT_RULE:
				setDefaultRule((DefaultRule)null);
				return;
			case HitroPackage.HUIPROPERTY__VALIDATION_RULE:
				getValidationRule().clear();
				return;
			case HitroPackage.HUIPROPERTY__OPTION:
				getOption().clear();
				return;
			case HitroPackage.HUIPROPERTY__CRUD_BUTTONS:
				unsetCrudButtons();
				return;
			case HitroPackage.HUIPROPERTY__DEFAULT_VALUE:
				unsetDefaultValue();
				return;
			case HitroPackage.HUIPROPERTY__EDITABLE:
				unsetEditable();
				return;
			case HitroPackage.HUIPROPERTY__FOCUS:
				unsetFocus();
				return;
			case HitroPackage.HUIPROPERTY__ID:
				setId(ID_EDEFAULT);
				return;
			case HitroPackage.HUIPROPERTY__INPUTTYPE:
				unsetInputtype();
				return;
			case HitroPackage.HUIPROPERTY__IS_URL:
				unsetIsURL();
				return;
			case HitroPackage.HUIPROPERTY__MAX:
				unsetMax();
				return;
			case HitroPackage.HUIPROPERTY__MIN:
				unsetMin();
				return;
			case HitroPackage.HUIPROPERTY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HitroPackage.HUIPROPERTY__REPORT:
				unsetReport();
				return;
			case HitroPackage.HUIPROPERTY__REQUIRED:
				unsetRequired();
				return;
			case HitroPackage.HUIPROPERTY__SHOW_IN_OBJECT_BROWSER:
				unsetShowInObjectBrowser();
				return;
			case HitroPackage.HUIPROPERTY__TAGS:
				setTags(TAGS_EDEFAULT);
				return;
			case HitroPackage.HUIPROPERTY__TEXTROWS:
				unsetTextrows();
				return;
			case HitroPackage.HUIPROPERTY__TOOLTIP:
				setTooltip(TOOLTIP_EDEFAULT);
				return;
			case HitroPackage.HUIPROPERTY__VISIBLE:
				unsetVisible();
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
			case HitroPackage.HUIPROPERTY__DEPENDS:
				return depends != null && !depends.isEmpty();
			case HitroPackage.HUIPROPERTY__REFERENCES:
				return references != null;
			case HitroPackage.HUIPROPERTY__DEFAULT_RULE:
				return defaultRule != null;
			case HitroPackage.HUIPROPERTY__VALIDATION_RULE:
				return validationRule != null && !validationRule.isEmpty();
			case HitroPackage.HUIPROPERTY__OPTION:
				return option != null && !option.isEmpty();
			case HitroPackage.HUIPROPERTY__CRUD_BUTTONS:
				return isSetCrudButtons();
			case HitroPackage.HUIPROPERTY__DEFAULT_VALUE:
				return isSetDefaultValue();
			case HitroPackage.HUIPROPERTY__EDITABLE:
				return isSetEditable();
			case HitroPackage.HUIPROPERTY__FOCUS:
				return isSetFocus();
			case HitroPackage.HUIPROPERTY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case HitroPackage.HUIPROPERTY__INPUTTYPE:
				return isSetInputtype();
			case HitroPackage.HUIPROPERTY__IS_URL:
				return isSetIsURL();
			case HitroPackage.HUIPROPERTY__MAX:
				return isSetMax();
			case HitroPackage.HUIPROPERTY__MIN:
				return isSetMin();
			case HitroPackage.HUIPROPERTY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HitroPackage.HUIPROPERTY__REPORT:
				return isSetReport();
			case HitroPackage.HUIPROPERTY__REQUIRED:
				return isSetRequired();
			case HitroPackage.HUIPROPERTY__SHOW_IN_OBJECT_BROWSER:
				return isSetShowInObjectBrowser();
			case HitroPackage.HUIPROPERTY__TAGS:
				return TAGS_EDEFAULT == null ? tags != null : !TAGS_EDEFAULT.equals(tags);
			case HitroPackage.HUIPROPERTY__TEXTROWS:
				return isSetTextrows();
			case HitroPackage.HUIPROPERTY__TOOLTIP:
				return TOOLTIP_EDEFAULT == null ? tooltip != null : !TOOLTIP_EDEFAULT.equals(tooltip);
			case HitroPackage.HUIPROPERTY__VISIBLE:
				return isSetVisible();
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
		result.append(" (crudButtons: ");
		if (crudButtonsESet) result.append(crudButtons); else result.append("<unset>");
		result.append(", defaultValue: ");
		if (defaultValueESet) result.append(defaultValue); else result.append("<unset>");
		result.append(", editable: ");
		if (editableESet) result.append(editable); else result.append("<unset>");
		result.append(", focus: ");
		if (focusESet) result.append(focus); else result.append("<unset>");
		result.append(", id: ");
		result.append(id);
		result.append(", inputtype: ");
		if (inputtypeESet) result.append(inputtype); else result.append("<unset>");
		result.append(", isURL: ");
		if (isURLESet) result.append(isURL); else result.append("<unset>");
		result.append(", max: ");
		if (maxESet) result.append(max); else result.append("<unset>");
		result.append(", min: ");
		if (minESet) result.append(min); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", report: ");
		if (reportESet) result.append(report); else result.append("<unset>");
		result.append(", required: ");
		if (requiredESet) result.append(required); else result.append("<unset>");
		result.append(", showInObjectBrowser: ");
		if (showInObjectBrowserESet) result.append(showInObjectBrowser); else result.append("<unset>");
		result.append(", tags: ");
		result.append(tags);
		result.append(", textrows: ");
		if (textrowsESet) result.append(textrows); else result.append("<unset>");
		result.append(", tooltip: ");
		result.append(tooltip);
		result.append(", visible: ");
		if (visibleESet) result.append(visible); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //HuipropertyImpl
