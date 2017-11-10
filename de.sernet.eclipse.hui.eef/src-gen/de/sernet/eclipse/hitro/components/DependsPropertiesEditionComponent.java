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
import de.sernet.eclipse.hitro.Depends;
import de.sernet.eclipse.hitro.HitroFactory;
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huiproperty;

import de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart;
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;

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
public class DependsPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for option EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings optionSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public DependsPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject depends, String editing_mode) {
		super(editingContext, depends, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = HitroViewsRepository.class;
		partKey = HitroViewsRepository.Depends.class;
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
			
			final Depends depends = (Depends)elt;
			final DependsPropertiesEditionPart basePart = (DependsPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(HitroViewsRepository.Depends.Properties.inverse)) {
				basePart.setInverse(depends.isInverse());
			}
			if (isAccessible(HitroViewsRepository.Depends.Properties.option)) {
				// init part
				optionSettings = new EObjectFlatComboSettings(depends, HitroPackage.eINSTANCE.getDepends_Option());
				basePart.initOption(optionSettings);
				// set the button mode
				basePart.setOptionButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(HitroViewsRepository.Depends.Properties.value))
				basePart.setValue(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING, depends.getValue()));
			
			// init filters
			
			if (isAccessible(HitroViewsRepository.Depends.Properties.option)) {
				basePart.addFilterToOption(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Huiproperty);
					}
					
				});
				// Start of user code for additional businessfilters for option
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
		if (editorKey == HitroViewsRepository.Depends.Properties.inverse) {
			return HitroPackage.eINSTANCE.getDepends_Inverse();
		}
		if (editorKey == HitroViewsRepository.Depends.Properties.option) {
			return HitroPackage.eINSTANCE.getDepends_Option();
		}
		if (editorKey == HitroViewsRepository.Depends.Properties.value) {
			return HitroPackage.eINSTANCE.getDepends_Value();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Depends depends = (Depends)semanticObject;
		if (HitroViewsRepository.Depends.Properties.inverse == event.getAffectedEditor()) {
			depends.setInverse((Boolean)event.getNewValue());
		}
		if (HitroViewsRepository.Depends.Properties.option == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				optionSettings.setToReference((Huiproperty)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Huiproperty eObject = HitroFactory.eINSTANCE.createHuiproperty();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				optionSettings.setToReference(eObject);
			}
		}
		if (HitroViewsRepository.Depends.Properties.value == event.getAffectedEditor()) {
			depends.setValue((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.STRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			DependsPropertiesEditionPart basePart = (DependsPropertiesEditionPart)editingPart;
			if (HitroPackage.eINSTANCE.getDepends_Inverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Depends.Properties.inverse))
				basePart.setInverse((Boolean)msg.getNewValue());
			
			if (HitroPackage.eINSTANCE.getDepends_Option().equals(msg.getFeature()) && basePart != null && isAccessible(HitroViewsRepository.Depends.Properties.option))
				basePart.setOption((EObject)msg.getNewValue());
			if (HitroPackage.eINSTANCE.getDepends_Value().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Depends.Properties.value)) {
				if (msg.getNewValue() != null) {
					basePart.setValue(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING, msg.getNewValue()));
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
			HitroPackage.eINSTANCE.getDepends_Inverse(),
			HitroPackage.eINSTANCE.getDepends_Option(),
			HitroPackage.eINSTANCE.getDepends_Value()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == HitroViewsRepository.Depends.Properties.option;
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
				if (HitroViewsRepository.Depends.Properties.inverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getDepends_Inverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getDepends_Inverse().getEAttributeType(), newValue);
				}
				if (HitroViewsRepository.Depends.Properties.value == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getDepends_Value().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getDepends_Value().getEAttributeType(), newValue);
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
