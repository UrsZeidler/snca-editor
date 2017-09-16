/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.components;

// Start of user code for imports
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Option;

import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.OptionPropertiesEditionPart;

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

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;


// End of user code

/**
 * 
 * 
 */
public class OptionPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public OptionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject option, String editing_mode) {
		super(editingContext, option, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = HitroViewsRepository.class;
		partKey = HitroViewsRepository.Option.class;
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
			
			final Option option = (Option)elt;
			final OptionPropertiesEditionPart basePart = (OptionPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(HitroViewsRepository.Option.Properties.id))
				basePart.setId(EEFConverterUtil.convertToString(XMLTypePackage.Literals.ID, option.getId()));
			
			if (isAccessible(HitroViewsRepository.Option.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING, option.getName()));
			
			if (isAccessible(HitroViewsRepository.Option.Properties.value))
				basePart.setValue(EEFConverterUtil.convertToString(XMLTypePackage.Literals.DECIMAL, option.getValue()));
			
			// init filters
			
			
			
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
		if (editorKey == HitroViewsRepository.Option.Properties.id) {
			return HitroPackage.eINSTANCE.getOption_Id();
		}
		if (editorKey == HitroViewsRepository.Option.Properties.name) {
			return HitroPackage.eINSTANCE.getOption_Name();
		}
		if (editorKey == HitroViewsRepository.Option.Properties.value) {
			return HitroPackage.eINSTANCE.getOption_Value();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Option option = (Option)semanticObject;
		if (HitroViewsRepository.Option.Properties.id == event.getAffectedEditor()) {
			option.setId((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.ID, (String)event.getNewValue()));
		}
		if (HitroViewsRepository.Option.Properties.name == event.getAffectedEditor()) {
			option.setName((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.STRING, (String)event.getNewValue()));
		}
		if (HitroViewsRepository.Option.Properties.value == event.getAffectedEditor()) {
			option.setValue((java.math.BigDecimal)EEFConverterUtil.createFromString(XMLTypePackage.Literals.DECIMAL, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			OptionPropertiesEditionPart basePart = (OptionPropertiesEditionPart)editingPart;
			if (HitroPackage.eINSTANCE.getOption_Id().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Option.Properties.id)) {
				if (msg.getNewValue() != null) {
					basePart.setId(EcoreUtil.convertToString(XMLTypePackage.Literals.ID, msg.getNewValue()));
				} else {
					basePart.setId("");
				}
			}
			if (HitroPackage.eINSTANCE.getOption_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Option.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (HitroPackage.eINSTANCE.getOption_Value().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Option.Properties.value)) {
				if (msg.getNewValue() != null) {
					basePart.setValue(EcoreUtil.convertToString(XMLTypePackage.Literals.DECIMAL, msg.getNewValue()));
				} else {
					basePart.setValue("");
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
			HitroPackage.eINSTANCE.getOption_Id(),
			HitroPackage.eINSTANCE.getOption_Name(),
			HitroPackage.eINSTANCE.getOption_Value()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == HitroViewsRepository.Option.Properties.id;
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
				if (HitroViewsRepository.Option.Properties.id == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getOption_Id().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getOption_Id().getEAttributeType(), newValue);
				}
				if (HitroViewsRepository.Option.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getOption_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getOption_Name().getEAttributeType(), newValue);
				}
				if (HitroViewsRepository.Option.Properties.value == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getOption_Value().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getOption_Value().getEAttributeType(), newValue);
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
