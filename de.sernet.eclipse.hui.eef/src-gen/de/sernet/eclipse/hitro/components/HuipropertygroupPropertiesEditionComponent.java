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
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Huipropertygroup;

import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart;

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

import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

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
 * @author Urs Zeidler
 * 
 */
public class HuipropertygroupPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for depends ReferencesTable
	 */
	private ReferencesTableSettings dependsSettings;
	
	/**
	 * Settings for huiproperty ReferencesTable
	 */
	protected ReferencesTableSettings huipropertySettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public HuipropertygroupPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject huipropertygroup, String editing_mode) {
		super(editingContext, huipropertygroup, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = HitroViewsRepository.class;
		partKey = HitroViewsRepository.Huipropertygroup.class;
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
			
			final Huipropertygroup huipropertygroup = (Huipropertygroup)elt;
			final HuipropertygroupPropertiesEditionPart basePart = (HuipropertygroupPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(HitroViewsRepository.Huipropertygroup.Properties.depends)) {
				dependsSettings = new ReferencesTableSettings(huipropertygroup, HitroPackage.eINSTANCE.getHuipropertygroup_Depends());
				basePart.initDepends(dependsSettings);
			}
			if (isAccessible(HitroViewsRepository.Huipropertygroup.Properties.huiproperty)) {
				huipropertySettings = new ReferencesTableSettings(huipropertygroup, HitroPackage.eINSTANCE.getHuipropertygroup_Huiproperty());
				basePart.initHuiproperty(huipropertySettings);
			}
			if (isAccessible(HitroViewsRepository.Huipropertygroup.Properties.columns)) {
				basePart.setColumns(EEFConverterUtil.convertToString(XMLTypePackage.Literals.INT, huipropertygroup.getColumns()));
			}
			
			if (isAccessible(HitroViewsRepository.Huipropertygroup.Base.id))
				basePart.setId(EEFConverterUtil.convertToString(XMLTypePackage.Literals.ID, huipropertygroup.getId()));
			
			if (isAccessible(HitroViewsRepository.Huipropertygroup.Base.name))
				basePart.setName(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING, huipropertygroup.getName()));
			
			if (isAccessible(HitroViewsRepository.Huipropertygroup.Properties.tags))
				basePart.setTags(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING, huipropertygroup.getTags()));
			
			// init filters
			if (isAccessible(HitroViewsRepository.Huipropertygroup.Properties.depends)) {
				basePart.addFilterToDepends(new EObjectFilter(HitroPackage.Literals.DEPENDS));
				// Start of user code for additional businessfilters for depends
				// End of user code
			}
			if (isAccessible(HitroViewsRepository.Huipropertygroup.Properties.huiproperty)) {
				basePart.addFilterToHuiproperty(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Huiproperty); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for huiproperty
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
		if (editorKey == HitroViewsRepository.Huipropertygroup.Properties.depends) {
			return HitroPackage.eINSTANCE.getHuipropertygroup_Depends();
		}
		if (editorKey == HitroViewsRepository.Huipropertygroup.Properties.huiproperty) {
			return HitroPackage.eINSTANCE.getHuipropertygroup_Huiproperty();
		}
		if (editorKey == HitroViewsRepository.Huipropertygroup.Properties.columns) {
			return HitroPackage.eINSTANCE.getHuipropertygroup_Columns();
		}
		if (editorKey == HitroViewsRepository.Huipropertygroup.Base.id) {
			return HitroPackage.eINSTANCE.getHuipropertygroup_Id();
		}
		if (editorKey == HitroViewsRepository.Huipropertygroup.Base.name) {
			return HitroPackage.eINSTANCE.getHuipropertygroup_Name();
		}
		if (editorKey == HitroViewsRepository.Huipropertygroup.Properties.tags) {
			return HitroPackage.eINSTANCE.getHuipropertygroup_Tags();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Huipropertygroup huipropertygroup = (Huipropertygroup)semanticObject;
		if (HitroViewsRepository.Huipropertygroup.Properties.depends == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Depends) {
					dependsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				dependsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				dependsSettings.move(event.getNewIndex(), (Depends) event.getNewValue());
			}
		}
		if (HitroViewsRepository.Huipropertygroup.Properties.huiproperty == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, huipropertySettings, editingContext.getAdapterFactory());
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
				huipropertySettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				huipropertySettings.move(event.getNewIndex(), (Huiproperty) event.getNewValue());
			}
		}
		if (HitroViewsRepository.Huipropertygroup.Properties.columns == event.getAffectedEditor()) {
			huipropertygroup.setColumns((EEFConverterUtil.createIntFromString(XMLTypePackage.Literals.INT, (String)event.getNewValue())));
		}
		if (HitroViewsRepository.Huipropertygroup.Base.id == event.getAffectedEditor()) {
			huipropertygroup.setId((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.ID, (String)event.getNewValue()));
		}
		if (HitroViewsRepository.Huipropertygroup.Base.name == event.getAffectedEditor()) {
			huipropertygroup.setName((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.STRING, (String)event.getNewValue()));
		}
		if (HitroViewsRepository.Huipropertygroup.Properties.tags == event.getAffectedEditor()) {
			huipropertygroup.setTags((java.lang.String)EEFConverterUtil.createFromString(XMLTypePackage.Literals.STRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			HuipropertygroupPropertiesEditionPart basePart = (HuipropertygroupPropertiesEditionPart)editingPart;
			if (HitroPackage.eINSTANCE.getHuipropertygroup_Depends().equals(msg.getFeature())  && isAccessible(HitroViewsRepository.Huipropertygroup.Properties.depends))
				basePart.updateDepends();
			if (HitroPackage.eINSTANCE.getHuipropertygroup_Huiproperty().equals(msg.getFeature()) && isAccessible(HitroViewsRepository.Huipropertygroup.Properties.huiproperty))
				basePart.updateHuiproperty();
			if (HitroPackage.eINSTANCE.getHuipropertygroup_Columns().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Huipropertygroup.Properties.columns)) {
				if (msg.getNewValue() != null) {
					basePart.setColumns(EcoreUtil.convertToString(XMLTypePackage.Literals.INT, msg.getNewValue()));
				} else {
					basePart.setColumns("");
				}
			}
			if (HitroPackage.eINSTANCE.getHuipropertygroup_Id().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Huipropertygroup.Base.id)) {
				if (msg.getNewValue() != null) {
					basePart.setId(EcoreUtil.convertToString(XMLTypePackage.Literals.ID, msg.getNewValue()));
				} else {
					basePart.setId("");
				}
			}
			if (HitroPackage.eINSTANCE.getHuipropertygroup_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Huipropertygroup.Base.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (HitroPackage.eINSTANCE.getHuipropertygroup_Tags().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.Huipropertygroup.Properties.tags)) {
				if (msg.getNewValue() != null) {
					basePart.setTags(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING, msg.getNewValue()));
				} else {
					basePart.setTags("");
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
			HitroPackage.eINSTANCE.getHuipropertygroup_Depends(),
			HitroPackage.eINSTANCE.getHuipropertygroup_Huiproperty(),
			HitroPackage.eINSTANCE.getHuipropertygroup_Columns(),
			HitroPackage.eINSTANCE.getHuipropertygroup_Id(),
			HitroPackage.eINSTANCE.getHuipropertygroup_Name(),
			HitroPackage.eINSTANCE.getHuipropertygroup_Tags()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == HitroViewsRepository.Huipropertygroup.Base.id || key == HitroViewsRepository.Huipropertygroup.Base.name;
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
				if (HitroViewsRepository.Huipropertygroup.Properties.columns == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getHuipropertygroup_Columns().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getHuipropertygroup_Columns().getEAttributeType(), newValue);
				}
				if (HitroViewsRepository.Huipropertygroup.Base.id == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getHuipropertygroup_Id().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getHuipropertygroup_Id().getEAttributeType(), newValue);
				}
				if (HitroViewsRepository.Huipropertygroup.Base.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getHuipropertygroup_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getHuipropertygroup_Name().getEAttributeType(), newValue);
				}
				if (HitroViewsRepository.Huipropertygroup.Properties.tags == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE.getHuipropertygroup_Tags().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getHuipropertygroup_Tags().getEAttributeType(), newValue);
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
