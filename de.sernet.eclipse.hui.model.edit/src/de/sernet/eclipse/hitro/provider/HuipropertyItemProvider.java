/**
 */
package de.sernet.eclipse.hitro.provider;


import de.sernet.eclipse.hitro.HitroFactory;
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huiproperty;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.sernet.eclipse.hitro.Huiproperty} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class HuipropertyItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HuipropertyItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addCrudButtonsPropertyDescriptor(object);
			addDefaultValuePropertyDescriptor(object);
			addEditablePropertyDescriptor(object);
			addFocusPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addInputtypePropertyDescriptor(object);
			addIsURLPropertyDescriptor(object);
			addMaxPropertyDescriptor(object);
			addMinPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addReportPropertyDescriptor(object);
			addRequiredPropertyDescriptor(object);
			addShowInObjectBrowserPropertyDescriptor(object);
			addTagsPropertyDescriptor(object);
			addTextrowsPropertyDescriptor(object);
			addTooltipPropertyDescriptor(object);
			addVisiblePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Crud Buttons feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCrudButtonsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_crudButtons_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_crudButtons_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__CRUD_BUTTONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_defaultValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_defaultValue_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__DEFAULT_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Editable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_editable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_editable_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__EDITABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Focus feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFocusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_focus_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_focus_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__FOCUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_id_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Inputtype feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputtypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_inputtype_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_inputtype_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__INPUTTYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is URL feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsURLPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_isURL_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_isURL_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__IS_URL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_max_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_max_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__MAX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Min feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_min_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_min_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__MIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_name_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Report feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReportPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_report_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_report_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__REPORT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Required feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_required_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_required_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__REQUIRED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Show In Object Browser feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addShowInObjectBrowserPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_showInObjectBrowser_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_showInObjectBrowser_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__SHOW_IN_OBJECT_BROWSER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tags feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTagsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_tags_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_tags_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__TAGS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Textrows feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTextrowsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_textrows_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_textrows_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__TEXTROWS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tooltip feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTooltipPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_tooltip_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_tooltip_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__TOOLTIP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Visible feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisiblePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Huiproperty_visible_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Huiproperty_visible_feature", "_UI_Huiproperty_type"),
				 HitroPackage.Literals.HUIPROPERTY__VISIBLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(HitroPackage.Literals.HUIPROPERTY__DEPENDS);
			childrenFeatures.add(HitroPackage.Literals.HUIPROPERTY__REFERENCES);
			childrenFeatures.add(HitroPackage.Literals.HUIPROPERTY__DEFAULT_RULE);
			childrenFeatures.add(HitroPackage.Literals.HUIPROPERTY__VALIDATION_RULE);
			childrenFeatures.add(HitroPackage.Literals.HUIPROPERTY__OPTION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Huiproperty.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Huiproperty"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public String getText(Object object) {
		Huiproperty huiproperty = (Huiproperty)object;
		String label = huiproperty.getName();
		
		label += " ["+huiproperty.getInputtype()+"]";
		return label == null || label.length() == 0 ?
			getString("_UI_Huiproperty_type") :
			getString("_UI_Huiproperty_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Huiproperty.class)) {
			case HitroPackage.HUIPROPERTY__CRUD_BUTTONS:
			case HitroPackage.HUIPROPERTY__DEFAULT_VALUE:
			case HitroPackage.HUIPROPERTY__EDITABLE:
			case HitroPackage.HUIPROPERTY__FOCUS:
			case HitroPackage.HUIPROPERTY__ID:
			case HitroPackage.HUIPROPERTY__INPUTTYPE:
			case HitroPackage.HUIPROPERTY__IS_URL:
			case HitroPackage.HUIPROPERTY__MAX:
			case HitroPackage.HUIPROPERTY__MIN:
			case HitroPackage.HUIPROPERTY__NAME:
			case HitroPackage.HUIPROPERTY__REPORT:
			case HitroPackage.HUIPROPERTY__REQUIRED:
			case HitroPackage.HUIPROPERTY__SHOW_IN_OBJECT_BROWSER:
			case HitroPackage.HUIPROPERTY__TAGS:
			case HitroPackage.HUIPROPERTY__TEXTROWS:
			case HitroPackage.HUIPROPERTY__TOOLTIP:
			case HitroPackage.HUIPROPERTY__VISIBLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case HitroPackage.HUIPROPERTY__DEPENDS:
			case HitroPackage.HUIPROPERTY__REFERENCES:
			case HitroPackage.HUIPROPERTY__DEFAULT_RULE:
			case HitroPackage.HUIPROPERTY__VALIDATION_RULE:
			case HitroPackage.HUIPROPERTY__OPTION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(HitroPackage.Literals.HUIPROPERTY__DEPENDS,
				 HitroFactory.eINSTANCE.createDepends()));

		newChildDescriptors.add
			(createChildParameter
				(HitroPackage.Literals.HUIPROPERTY__REFERENCES,
				 HitroFactory.eINSTANCE.createReference()));

		newChildDescriptors.add
			(createChildParameter
				(HitroPackage.Literals.HUIPROPERTY__DEFAULT_RULE,
				 HitroFactory.eINSTANCE.createDefaultRule()));

		newChildDescriptors.add
			(createChildParameter
				(HitroPackage.Literals.HUIPROPERTY__VALIDATION_RULE,
				 HitroFactory.eINSTANCE.createValidationRule()));

		newChildDescriptors.add
			(createChildParameter
				(HitroPackage.Literals.HUIPROPERTY__OPTION,
				 HitroFactory.eINSTANCE.createOption()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return HitroEditPlugin.INSTANCE;
	}

}
