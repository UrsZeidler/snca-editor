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

// Start of user code for imports
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.Param;
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.ParamPropertiesEditionPart;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class ParamPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

    public static String BASE_PART = "Base"; //$NON-NLS-1$

    /**
     * Default constructor
     * 
     */
    public ParamPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject param,
            String editing_mode) {
        super(editingContext, param, editing_mode);
        parts = new String[] { BASE_PART };
        repositoryKey = HitroViewsRepository.class;
        partKey = HitroViewsRepository.Param.class;
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

            final Param param = (Param) elt;
            final ParamPropertiesEditionPart basePart = (ParamPropertiesEditionPart) editingPart;
            // init values
            if (isAccessible(HitroViewsRepository.Param.Properties.mixed))
                basePart.setMixed(param.getMixed());

            if (isAccessible(HitroViewsRepository.Param.Properties.id))
                basePart.setId(EEFConverterUtil.convertToString(XMLTypePackage.Literals.ID,
                        param.getId()));

            // init filters

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
        if (editorKey == HitroViewsRepository.Param.Properties.mixed) {
            return HitroPackage.eINSTANCE.getParam_Mixed();
        }
        if (editorKey == HitroViewsRepository.Param.Properties.id) {
            return HitroPackage.eINSTANCE.getParam_Id();
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
        Param param = (Param) semanticObject;
        if (HitroViewsRepository.Param.Properties.mixed == event.getAffectedEditor()) {
            if (event.getKind() == PropertiesEditionEvent.SET) {
                param.getMixed().clear();
                param.getMixed().addAll(((EList) event.getNewValue()));
            }
        }
        if (HitroViewsRepository.Param.Properties.id == event.getAffectedEditor()) {
            param.setId((java.lang.String) EEFConverterUtil
                    .createFromString(XMLTypePackage.Literals.ID, (String) event.getNewValue()));
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
            ParamPropertiesEditionPart basePart = (ParamPropertiesEditionPart) editingPart;
            if (HitroPackage.eINSTANCE.getParam_Mixed().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Param.Properties.mixed)) {
                if (msg.getNewValue() instanceof EList<?>) {
                    basePart.setMixed((EList<?>) msg.getNewValue());
                } else if (msg.getNewValue() == null) {
                    basePart.setMixed(new BasicEList<Object>());
                } else {
                    BasicEList<Object> newValueAsList = new BasicEList<Object>();
                    newValueAsList.add(msg.getNewValue());
                    basePart.setMixed(newValueAsList);
                }
            }

            if (HitroPackage.eINSTANCE.getParam_Id().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Param.Properties.id)) {
                if (msg.getNewValue() != null) {
                    basePart.setId(EcoreUtil.convertToString(XMLTypePackage.Literals.ID,
                            msg.getNewValue()));
                } else {
                    basePart.setId("");
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
                HitroPackage.eINSTANCE.getParam_Mixed(), HitroPackage.eINSTANCE.getParam_Id());
        return new NotificationFilter[] { filter, };
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object,
     *      int)
     * 
     */
    public boolean isRequired(Object key, int kind) {
        return key == HitroViewsRepository.Param.Properties.id;
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
                if (HitroViewsRepository.Param.Properties.mixed == event.getAffectedEditor()) {
                    BasicDiagnostic chain = new BasicDiagnostic();
                    for (Iterator iterator = ((List) event.getNewValue()).iterator(); iterator
                            .hasNext();) {
                        chain.add(Diagnostician.INSTANCE.validate(
                                HitroPackage.eINSTANCE.getParam_Mixed().getEAttributeType(),
                                iterator.next()));
                    }
                    ret = chain;
                }
                if (HitroViewsRepository.Param.Properties.id == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getParam_Id().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getParam_Id().getEAttributeType(), newValue);
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
