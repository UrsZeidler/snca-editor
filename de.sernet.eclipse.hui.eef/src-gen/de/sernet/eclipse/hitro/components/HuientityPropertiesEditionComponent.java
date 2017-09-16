/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.components;

// Start of user code for imports
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huientity;

import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.HuientityPropertiesEditionPart;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
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

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;


// End of user code

/**
 * 
 * 
 */
public class HuientityPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public HuientityPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject huientity, String editing_mode) {
		super(editingContext, huientity, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = HitroViewsRepository.class;
		partKey = HitroViewsRepository.Huientity.class;
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
			
			final Huientity huientity = (Huientity)elt;
			final HuientityPropertiesEditionPart basePart = (HuientityPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(HitroViewsRepository.Huientity.Properties.group))
				basePart.setGroup(huientity.getGroup());
			
			if (isAccessible(HitroViewsRepository.Huientity.Properties.id))
				basePart.setId(EEFConverterUtil.convertToString(XMLTypePackage.Literals.ID, huientity.getId()));
			
			if (isAccessible(HitroViewsRepository.Huientity.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING, huientity.getName()));
			
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
		if (editorKey == HitroViewsRepository.Huientity.Properties.group) {
			return HitroPackage.eINSTANCE.getHuientity_Group();
		}
		if (editorKey == HitroViewsRepository.Huientity.Properties.id) {
			return HitroPackage.eINSTANCE.getHuientity_Id();
		}
		if (editorKey == HitroViewsRepository.Huientity.Properties.name) {
			return HitroPackage.eINSTANCE.getHuientity_Name();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Huientity huientity = (Huientity)semanticObject;
		if (HitroViewsRepository.Huientity.Properties.group == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				huientity.getGroup().clear();
				huientity.getGroup().addAll(((EList) event.getNewValue()));
			}
		}
		if (HitroViewsRepository.Huientity.Properties.id == event.getAffectedEditor()) {
			huientity.setId((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.ID, (String)event.getNewValue()));
		}
		if (HitroViewsRepository.Huientity.Properties.name == event.getAffectedEditor()) {
			huientity.setName((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.STRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			HuientityPropertiesEditionPart basePart = (HuientityPropertiesEditionPart)editingPart;
			if (HitroPackage.eINSTANCE.getHuientity_Group().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Huientity.Properties.group)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setGroup((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setGroup(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setGroup(newValueAsList);
				}
			}
			
			if (HitroPackage.eINSTANCE.getHuientity_Id().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Huientity.Properties.id)) {
				if (msg.getNewValue() != null) {
					basePart.setId(EcoreUtil.convertToString(XMLTypePackage.Literals.ID, msg.getNewValue()));
				} else {
					basePart.setId("");
				}
			}
			if (HitroPackage.eINSTANCE.getHuientity_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Huientity.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING, msg.getNewValue()));
				} else {
					basePart.setName("");
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
			HitroPackage.eINSTANCE.getHuientity_Group(),
			HitroPackage.eINSTANCE.getHuientity_Id(),
			HitroPackage.eINSTANCE.getHuientity_Name()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == HitroViewsRepository.Huientity.Properties.id;
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
				if (HitroViewsRepository.Huientity.Properties.group == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getHuientity_Group().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (HitroViewsRepository.Huientity.Properties.id == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getHuientity_Id().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getHuientity_Id().getEAttributeType(), newValue);
				}
				if (HitroViewsRepository.Huientity.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getHuientity_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getHuientity_Name().getEAttributeType(), newValue);
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
