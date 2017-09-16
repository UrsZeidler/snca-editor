/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.components;

// Start of user code for imports
import de.sernet.eclipse.hitro.DocumentRoot;
import de.sernet.eclipse.hitro.HitroPackage;

import de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart;
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;

import java.util.Iterator;
import java.util.List;

import java.util.Map.Entry;

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
public class DocumentRootPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for xMLNSPrefixMap ReferencesTable
	 */
	protected ReferencesTableSettings xMLNSPrefixMapSettings;
	
	/**
	 * Settings for xSISchemaLocation ReferencesTable
	 */
	protected ReferencesTableSettings xSISchemaLocationSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public DocumentRootPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject documentRoot, String editing_mode) {
		super(editingContext, documentRoot, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = HitroViewsRepository.class;
		partKey = HitroViewsRepository.DocumentRoot.class;
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
			
			final DocumentRoot documentRoot = (DocumentRoot)elt;
			final DocumentRootPropertiesEditionPart basePart = (DocumentRootPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(HitroViewsRepository.DocumentRoot.Properties.mixed))
				basePart.setMixed(documentRoot.getMixed());
			
			if (isAccessible(HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap)) {
				xMLNSPrefixMapSettings = new ReferencesTableSettings(documentRoot, HitroPackage.eINSTANCE.getDocumentRoot_XMLNSPrefixMap());
				basePart.initXMLNSPrefixMap(xMLNSPrefixMapSettings);
			}
			if (isAccessible(HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation)) {
				xSISchemaLocationSettings = new ReferencesTableSettings(documentRoot, HitroPackage.eINSTANCE.getDocumentRoot_XSISchemaLocation());
				basePart.initXSISchemaLocation(xSISchemaLocationSettings);
			}
			// init filters
			
			if (isAccessible(HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap)) {
				basePart.addFilterToXMLNSPrefixMap(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Entry); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for xMLNSPrefixMap
				// End of user code
			}
			if (isAccessible(HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation)) {
				basePart.addFilterToXSISchemaLocation(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Entry); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for xSISchemaLocation
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
		if (editorKey == HitroViewsRepository.DocumentRoot.Properties.mixed) {
			return HitroPackage.eINSTANCE.getDocumentRoot_Mixed();
		}
		if (editorKey == HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap) {
			return HitroPackage.eINSTANCE.getDocumentRoot_XMLNSPrefixMap();
		}
		if (editorKey == HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation) {
			return HitroPackage.eINSTANCE.getDocumentRoot_XSISchemaLocation();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		DocumentRoot documentRoot = (DocumentRoot)semanticObject;
		if (HitroViewsRepository.DocumentRoot.Properties.mixed == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				documentRoot.getMixed().clear();
				documentRoot.getMixed().addAll(((EList) event.getNewValue()));
			}
		}
		if (HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, xMLNSPrefixMapSettings, editingContext.getAdapterFactory());
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
				xMLNSPrefixMapSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
//				xMLNSPrefixMapSettings.move(event.getNewIndex(), (Entry) event.getNewValue());
			}
		}
		if (HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, xSISchemaLocationSettings, editingContext.getAdapterFactory());
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
				xSISchemaLocationSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
//				xSISchemaLocationSettings.move(event.getNewIndex(), (Entry) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			DocumentRootPropertiesEditionPart basePart = (DocumentRootPropertiesEditionPart)editingPart;
			if (HitroPackage.eINSTANCE.getDocumentRoot_Mixed().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(HitroViewsRepository.DocumentRoot.Properties.mixed)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setMixed((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setMixed(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setMixed(newValueAsList);
				}
			}
			
			if (HitroPackage.eINSTANCE.getDocumentRoot_XMLNSPrefixMap().equals(msg.getFeature()) && isAccessible(HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap))
				basePart.updateXMLNSPrefixMap();
			if (HitroPackage.eINSTANCE.getDocumentRoot_XSISchemaLocation().equals(msg.getFeature()) && isAccessible(HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation))
				basePart.updateXSISchemaLocation();
			
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
			HitroPackage.eINSTANCE.getDocumentRoot_Mixed(),
			HitroPackage.eINSTANCE.getDocumentRoot_XMLNSPrefixMap(),
			HitroPackage.eINSTANCE.getDocumentRoot_XSISchemaLocation()		);
		return new NotificationFilter[] {filter,};
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
				if (HitroViewsRepository.DocumentRoot.Properties.mixed == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE.getDocumentRoot_Mixed().getEAttributeType(), iterator.next()));
					}
					ret = chain;
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
