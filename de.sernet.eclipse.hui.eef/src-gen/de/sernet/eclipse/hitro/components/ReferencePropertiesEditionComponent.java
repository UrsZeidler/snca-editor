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
import de.sernet.eclipse.hitro.Reference;

import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.ReferencePropertiesEditionPart;

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
public class ReferencePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

    public static String BASE_PART = "Base"; //$NON-NLS-1$

    /**
     * Settings for entitytype EObjectFlatComboViewer
     */
    private EObjectFlatComboSettings entitytypeSettings;

    /**
     * Default constructor
     * 
     */
    public ReferencePropertiesEditionComponent(PropertiesEditingContext editingContext,
            EObject reference, String editing_mode) {
        super(editingContext, reference, editing_mode);
        parts = new String[] { BASE_PART };
        repositoryKey = HitroViewsRepository.class;
        partKey = HitroViewsRepository.Reference.class;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object,
     *      int, org.eclipse.emf.ecore.EObject,
     *      org.eclipse.emf.ecore.resource.ResourceSet)
     * 
     */
    public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
        setInitializing(true);
        if (editingPart != null && key == partKey) {
            editingPart.setContext(elt, allResource);

            final Reference reference = (Reference) elt;
            final ReferencePropertiesEditionPart basePart = (ReferencePropertiesEditionPart) editingPart;
            // init values
            if (isAccessible(HitroViewsRepository.Reference.Properties.entitytype)) {
                // init part
                entitytypeSettings = new EObjectFlatComboSettings(reference,
                        HitroPackage.eINSTANCE.getReference_Entitytype());
                basePart.initEntitytype(entitytypeSettings);
                // set the button mode
                basePart.setEntitytypeButtonMode(ButtonsModeEnum.BROWSE);
            }
            if (isAccessible(HitroViewsRepository.Reference.Properties.linkType))
                basePart.setLinkType(EEFConverterUtil.convertToString(XMLTypePackage.Literals.IDREF,
                        reference.getLinkType()));

            // init filters
            if (isAccessible(HitroViewsRepository.Reference.Properties.entitytype)) {
                basePart.addFilterToEntitytype(new ViewerFilter() {

                    /**
                     * {@inheritDoc}
                     * 
                     * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer,
                     *      java.lang.Object, java.lang.Object)
                     */
                    public boolean select(Viewer viewer, Object parentElement, Object element) {
                        return (element instanceof String && element.equals("")) //$NON-NLS-1$
                                || (element instanceof Huientity);
                    }

                });
                // Start of user code for additional businessfilters for
                // entitytype
                // End of user code
            }

            // init values for referenced views

            // init filters for referenced views

        }
        setInitializing(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
     */
    public EStructuralFeature associatedFeature(Object editorKey) {
        if (editorKey == HitroViewsRepository.Reference.Properties.entitytype) {
            return HitroPackage.eINSTANCE.getReference_Entitytype();
        }
        if (editorKey == HitroViewsRepository.Reference.Properties.linkType) {
            return HitroPackage.eINSTANCE.getReference_LinkType();
        }
        return super.associatedFeature(editorKey);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     * 
     */
    public void updateSemanticModel(final IPropertiesEditionEvent event) {
        Reference reference = (Reference) semanticObject;
        if (HitroViewsRepository.Reference.Properties.entitytype == event.getAffectedEditor()) {
            if (event.getKind() == PropertiesEditionEvent.SET) {
                entitytypeSettings.setToReference((Huientity) event.getNewValue());
            } else if (event.getKind() == PropertiesEditionEvent.ADD) {
                Huientity eObject = HitroFactory.eINSTANCE.createHuientity();
                EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(
                        editingContext, this, eObject, editingContext.getAdapterFactory());
                PropertiesEditingProvider provider = (PropertiesEditingProvider) editingContext
                        .getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
                if (provider != null) {
                    PropertiesEditingPolicy policy = provider.getPolicy(context);
                    if (policy != null) {
                        policy.execute();
                    }
                }
                entitytypeSettings.setToReference(eObject);
            }
        }
        if (HitroViewsRepository.Reference.Properties.linkType == event.getAffectedEditor()) {
            reference.setLinkType((java.lang.String) EEFConverterUtil
                    .createFromString(XMLTypePackage.Literals.IDREF, (String) event.getNewValue()));
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
     */
    public void updatePart(Notification msg) {
        super.updatePart(msg);
        if (editingPart.isVisible()) {
            ReferencePropertiesEditionPart basePart = (ReferencePropertiesEditionPart) editingPart;
            if (HitroPackage.eINSTANCE.getReference_Entitytype().equals(msg.getFeature())
                    && basePart != null
                    && isAccessible(HitroViewsRepository.Reference.Properties.entitytype))
                basePart.setEntitytype((EObject) msg.getNewValue());
            if (HitroPackage.eINSTANCE.getReference_LinkType().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Reference.Properties.linkType)) {
                if (msg.getNewValue() != null) {
                    basePart.setLinkType(EcoreUtil.convertToString(XMLTypePackage.Literals.IDREF,
                            msg.getNewValue()));
                } else {
                    basePart.setLinkType("");
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
                HitroPackage.eINSTANCE.getReference_Entitytype(),
                HitroPackage.eINSTANCE.getReference_LinkType());
        return new NotificationFilter[] { filter, };
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
                if (HitroViewsRepository.Reference.Properties.linkType == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getReference_LinkType().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getReference_LinkType().getEAttributeType(),
                            newValue);
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
