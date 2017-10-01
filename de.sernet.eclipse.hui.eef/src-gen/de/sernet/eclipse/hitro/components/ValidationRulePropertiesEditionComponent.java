/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.components;

// Start of user code for imports
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Param;
import de.sernet.eclipse.hitro.ValidationRule;

import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.ValidationRulePropertiesEditionPart;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public class ValidationRulePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for param ReferencesTable
	 */
	protected ReferencesTableSettings paramSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ValidationRulePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject validationRule, String editing_mode) {
		super(editingContext, validationRule, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = HitroViewsRepository.class;
		partKey = HitroViewsRepository.ValidationRule.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final ValidationRule validationRule = (ValidationRule)elt;
			final ValidationRulePropertiesEditionPart basePart = (ValidationRulePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(HitroViewsRepository.ValidationRule.Properties.param)) {
				paramSettings = new ReferencesTableSettings(validationRule, HitroPackage.eINSTANCE.getValidationRule_Param());
				basePart.initParam(paramSettings);
			}
			if (isAccessible(HitroViewsRepository.ValidationRule.Properties.class_))
				basePart.setClass_(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING, validationRule.getClass_()));
			
			if (isAccessible(HitroViewsRepository.ValidationRule.Properties.hint))
				basePart.setHint(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING, validationRule.getHint()));
			
			// init filters
			if (isAccessible(HitroViewsRepository.ValidationRule.Properties.param)) {
				basePart.addFilterToParam(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Param); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for param
				// End of user code
			}
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}






	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == HitroViewsRepository.ValidationRule.Properties.param) {
			return HitroPackage.eINSTANCE.getValidationRule_Param();
		}
		if (editorKey == HitroViewsRepository.ValidationRule.Properties.class_) {
			return HitroPackage.eINSTANCE.getValidationRule_Class();
		}
		if (editorKey == HitroViewsRepository.ValidationRule.Properties.hint) {
			return HitroPackage.eINSTANCE.getValidationRule_Hint();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ValidationRule validationRule = (ValidationRule)semanticObject;
		if (HitroViewsRepository.ValidationRule.Properties.param == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, paramSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				paramSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				paramSettings.move(event.getNewIndex(), (Param) event.getNewValue());
			}
		}
		if (HitroViewsRepository.ValidationRule.Properties.class_ == event.getAffectedEditor()) {
			validationRule.setClass((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.STRING, (String)event.getNewValue()));
		}
		if (HitroViewsRepository.ValidationRule.Properties.hint == event.getAffectedEditor()) {
			validationRule.setHint((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.STRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ValidationRulePropertiesEditionPart basePart = (ValidationRulePropertiesEditionPart)editingPart;
			if (HitroPackage.eINSTANCE.getValidationRule_Param().equals(msg.getFeature()) && isAccessible(HitroViewsRepository.ValidationRule.Properties.param))
				basePart.updateParam();
			if (HitroPackage.eINSTANCE.getValidationRule_Class().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.ValidationRule.Properties.class_)) {
				if (msg.getNewValue() != null) {
					basePart.setClass_(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING, msg.getNewValue()));
				} else {
					basePart.setClass_("");
				}
			}
			if (HitroPackage.eINSTANCE.getValidationRule_Hint().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.ValidationRule.Properties.hint)) {
				if (msg.getNewValue() != null) {
					basePart.setHint(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING, msg.getNewValue()));
				} else {
					basePart.setHint("");
				}
			}
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			HitroPackage.eINSTANCE.getValidationRule_Param(),
			HitroPackage.eINSTANCE.getValidationRule_Class(),
			HitroPackage.eINSTANCE.getValidationRule_Hint()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == HitroViewsRepository.ValidationRule.Properties.class_;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (HitroViewsRepository.ValidationRule.Properties.class_ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getValidationRule_Class().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getValidationRule_Class().getEAttributeType(), newValue);
				}
				if (HitroViewsRepository.ValidationRule.Properties.hint == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getValidationRule_Hint().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getValidationRule_Hint().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
