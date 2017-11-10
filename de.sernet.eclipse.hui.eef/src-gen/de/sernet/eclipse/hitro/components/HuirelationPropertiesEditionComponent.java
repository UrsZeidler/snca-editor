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
package de.sernet.eclipse.hitro.components;

// Start of user code for imports
import de.sernet.eclipse.hitro.HitroFactory;
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huientity;
import de.sernet.eclipse.hitro.Huirelation;

import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart;

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

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class HuirelationPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for to EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings toSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public HuirelationPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject huirelation, String editing_mode) {
		super(editingContext, huirelation, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = HitroViewsRepository.class;
		partKey = HitroViewsRepository.Huirelation.class;
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
			
			final Huirelation huirelation = (Huirelation)elt;
			final HuirelationPropertiesEditionPart basePart = (HuirelationPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(HitroViewsRepository.Huirelation.Base.id))
				basePart.setId(EEFConverterUtil.convertToString(XMLTypePackage.Literals.ID, huirelation.getId()));
			
			if (isAccessible(HitroViewsRepository.Huirelation.Base.name))
				basePart.setName(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING, huirelation.getName()));
			
			if (isAccessible(HitroViewsRepository.Huirelation.Properties.reversename))
				basePart.setReversename(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING, huirelation.getReversename()));
			
			if (isAccessible(HitroViewsRepository.Huirelation.Properties.to)) {
				// init part
				toSettings = new EObjectFlatComboSettings(huirelation, HitroPackage.eINSTANCE.getHuirelation_To());
				basePart.initTo(toSettings);
				// set the button mode
				basePart.setToButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(HitroViewsRepository.Huirelation.Properties.tooltip))
				basePart.setTooltip(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING, huirelation.getTooltip()));
			
			// init filters
			
			
			
			if (isAccessible(HitroViewsRepository.Huirelation.Properties.to)) {
				basePart.addFilterToTo(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Huientity);
					}
					
				});
				// Start of user code for additional businessfilters for to
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
		if (editorKey == HitroViewsRepository.Huirelation.Base.id) {
			return HitroPackage.eINSTANCE.getHuirelation_Id();
		}
		if (editorKey == HitroViewsRepository.Huirelation.Base.name) {
			return HitroPackage.eINSTANCE.getHuirelation_Name();
		}
		if (editorKey == HitroViewsRepository.Huirelation.Properties.reversename) {
			return HitroPackage.eINSTANCE.getHuirelation_Reversename();
		}
		if (editorKey == HitroViewsRepository.Huirelation.Properties.to) {
			return HitroPackage.eINSTANCE.getHuirelation_To();
		}
		if (editorKey == HitroViewsRepository.Huirelation.Properties.tooltip) {
			return HitroPackage.eINSTANCE.getHuirelation_Tooltip();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Huirelation huirelation = (Huirelation)semanticObject;
		if (HitroViewsRepository.Huirelation.Base.id == event.getAffectedEditor()) {
			huirelation.setId((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.ID, (String)event.getNewValue()));
		}
		if (HitroViewsRepository.Huirelation.Base.name == event.getAffectedEditor()) {
			huirelation.setName((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.STRING, (String)event.getNewValue()));
		}
		if (HitroViewsRepository.Huirelation.Properties.reversename == event.getAffectedEditor()) {
			huirelation.setReversename((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.STRING, (String)event.getNewValue()));
		}
		if (HitroViewsRepository.Huirelation.Properties.to == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				toSettings.setToReference((Huientity)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Huientity eObject = HitroFactory.eINSTANCE.createHuientity();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				toSettings.setToReference(eObject);
			}
		}
		if (HitroViewsRepository.Huirelation.Properties.tooltip == event.getAffectedEditor()) {
			huirelation.setTooltip((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.STRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			HuirelationPropertiesEditionPart basePart = (HuirelationPropertiesEditionPart)editingPart;
			if (HitroPackage.eINSTANCE.getHuirelation_Id().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Huirelation.Base.id)) {
				if (msg.getNewValue() != null) {
					basePart.setId(EcoreUtil.convertToString(XMLTypePackage.Literals.ID, msg.getNewValue()));
				} else {
					basePart.setId("");
				}
			}
			if (HitroPackage.eINSTANCE.getHuirelation_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Huirelation.Base.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (HitroPackage.eINSTANCE.getHuirelation_Reversename().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Huirelation.Properties.reversename)) {
				if (msg.getNewValue() != null) {
					basePart.setReversename(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING, msg.getNewValue()));
				} else {
					basePart.setReversename("");
				}
			}
			if (HitroPackage.eINSTANCE.getHuirelation_To().equals(msg.getFeature()) && basePart != null && isAccessible(HitroViewsRepository.Huirelation.Properties.to))
				basePart.setTo((EObject)msg.getNewValue());
			if (HitroPackage.eINSTANCE.getHuirelation_Tooltip().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Huirelation.Properties.tooltip)) {
				if (msg.getNewValue() != null) {
					basePart.setTooltip(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING, msg.getNewValue()));
				} else {
					basePart.setTooltip("");
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
			HitroPackage.eINSTANCE.getHuirelation_Id(),
			HitroPackage.eINSTANCE.getHuirelation_Name(),
			HitroPackage.eINSTANCE.getHuirelation_Reversename(),
			HitroPackage.eINSTANCE.getHuirelation_To(),
			HitroPackage.eINSTANCE.getHuirelation_Tooltip()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == HitroViewsRepository.Huirelation.Base.id || key == HitroViewsRepository.Huirelation.Properties.to;
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
				if (HitroViewsRepository.Huirelation.Base.id == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getHuirelation_Id().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getHuirelation_Id().getEAttributeType(), newValue);
				}
				if (HitroViewsRepository.Huirelation.Base.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getHuirelation_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getHuirelation_Name().getEAttributeType(), newValue);
				}
				if (HitroViewsRepository.Huirelation.Properties.reversename == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getHuirelation_Reversename().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getHuirelation_Reversename().getEAttributeType(), newValue);
				}
				if (HitroViewsRepository.Huirelation.Properties.tooltip == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getHuirelation_Tooltip().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getHuirelation_Tooltip().getEAttributeType(), newValue);
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
