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
import de.sernet.eclipse.hitro.Inputtypes;
import de.sernet.eclipse.hitro.Option;
import de.sernet.eclipse.hitro.ValidationRule;

import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart;

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
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

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
public class HuipropertyPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

    public static String BASE_PART = "Base"; //$NON-NLS-1$

    /**
     * Settings for depends ReferencesTable
     */
    protected ReferencesTableSettings dependsSettings;

    /**
     * Settings for validationRule ReferencesTable
     */
    protected ReferencesTableSettings validationRuleSettings;

    /**
     * Settings for option ReferencesTable
     */
    protected ReferencesTableSettings optionSettings;

    /**
     * Default constructor
     * 
     */
    public HuipropertyPropertiesEditionComponent(PropertiesEditingContext editingContext,
            EObject huiproperty, String editing_mode) {
        super(editingContext, huiproperty, editing_mode);
        parts = new String[] { BASE_PART };
        repositoryKey = HitroViewsRepository.class;
        partKey = HitroViewsRepository.Huiproperty.class;
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

            final Huiproperty huiproperty = (Huiproperty) elt;
            final HuipropertyPropertiesEditionPart basePart = (HuipropertyPropertiesEditionPart) editingPart;
            // init values
            if (isAccessible(HitroViewsRepository.Huiproperty.Childs.depends)) {
                dependsSettings = new ReferencesTableSettings(huiproperty,
                        HitroPackage.eINSTANCE.getHuiproperty_Depends());
                basePart.initDepends(dependsSettings);
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Childs.validationRule)) {
                validationRuleSettings = new ReferencesTableSettings(huiproperty,
                        HitroPackage.eINSTANCE.getHuiproperty_ValidationRule());
                basePart.initValidationRule(validationRuleSettings);
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Childs.option)) {
                optionSettings = new ReferencesTableSettings(huiproperty,
                        HitroPackage.eINSTANCE.getHuiproperty_Option());
                basePart.initOption(optionSettings);
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Properties.crudButtons)) {
                basePart.setCrudButtons(huiproperty.isCrudButtons());
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Properties.defaultValue)) {
                basePart.setDefaultValue(EEFConverterUtil.convertToString(
                        XMLTypePackage.Literals.INT, huiproperty.getDefaultValue()));
            }

            if (isAccessible(HitroViewsRepository.Huiproperty.Properties.editable)) {
                basePart.setEditable(huiproperty.isEditable());
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Properties.focus)) {
                basePart.setFocus(huiproperty.isFocus());
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Base.id))
                basePart.setId(EEFConverterUtil.convertToString(XMLTypePackage.Literals.ID,
                        huiproperty.getId()));

            if (isAccessible(HitroViewsRepository.Huiproperty.Type.inputtype)) {
                basePart.initInputtype(
                        EEFUtils.choiceOfValues(huiproperty,
                                HitroPackage.eINSTANCE.getHuiproperty_Inputtype()),
                        huiproperty.getInputtype());
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Type.isURL)) {
                basePart.setIsURL(huiproperty.isIsURL());
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Type.max)) {
                basePart.setMax(EEFConverterUtil.convertToString(XMLTypePackage.Literals.INT,
                        huiproperty.getMax()));
            }

            if (isAccessible(HitroViewsRepository.Huiproperty.Type.min)) {
                basePart.setMin(EEFConverterUtil.convertToString(XMLTypePackage.Literals.INT,
                        huiproperty.getMin()));
            }

            if (isAccessible(HitroViewsRepository.Huiproperty.Base.name))
                basePart.setName(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING,
                        huiproperty.getName()));

            if (isAccessible(HitroViewsRepository.Huiproperty.Properties.report)) {
                basePart.setReport(huiproperty.isReport());
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Properties.required)) {
                basePart.setRequired(huiproperty.isRequired());
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser)) {
                basePart.setShowInObjectBrowser(huiproperty.isShowInObjectBrowser());
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Properties.tags))
                basePart.setTags(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING,
                        huiproperty.getTags()));

            if (isAccessible(HitroViewsRepository.Huiproperty.Properties.textrows)) {
                basePart.setTextrows(EEFConverterUtil.convertToString(XMLTypePackage.Literals.INT,
                        huiproperty.getTextrows()));
            }

            if (isAccessible(HitroViewsRepository.Huiproperty.Properties.tooltip))
                basePart.setTooltip(EEFConverterUtil.convertToString(XMLTypePackage.Literals.STRING,
                        huiproperty.getTooltip()));

            if (isAccessible(HitroViewsRepository.Huiproperty.Properties.visible)) {
                basePart.setVisible(huiproperty.isVisible());
            }
            // init filters
            if (isAccessible(HitroViewsRepository.Huiproperty.Childs.depends)) {
                basePart.addFilterToDepends(new ViewerFilter() {
                    /**
                     * {@inheritDoc}
                     * 
                     * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer,
                     *      java.lang.Object, java.lang.Object)
                     */
                    public boolean select(Viewer viewer, Object parentElement, Object element) {
                        return (element instanceof String && element.equals("")) //$NON-NLS-1$
                                || (element instanceof Depends);
                    }

                });
                // Start of user code for additional businessfilters for depends
                // End of user code
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Childs.validationRule)) {
                basePart.addFilterToValidationRule(new ViewerFilter() {
                    /**
                     * {@inheritDoc}
                     * 
                     * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer,
                     *      java.lang.Object, java.lang.Object)
                     */
                    public boolean select(Viewer viewer, Object parentElement, Object element) {
                        return (element instanceof String && element.equals("")) //$NON-NLS-1$
                                || (element instanceof ValidationRule);
                    }

                });
                // Start of user code for additional businessfilters for
                // validationRule
                // End of user code
            }
            if (isAccessible(HitroViewsRepository.Huiproperty.Childs.option)) {
                basePart.addFilterToOption(new ViewerFilter() {
                    /**
                     * {@inheritDoc}
                     * 
                     * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer,
                     *      java.lang.Object, java.lang.Object)
                     */
                    public boolean select(Viewer viewer, Object parentElement, Object element) {
                        return (element instanceof String && element.equals("")) //$NON-NLS-1$
                                || (element instanceof Option);
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
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
     */
    public EStructuralFeature associatedFeature(Object editorKey) {
        if (editorKey == HitroViewsRepository.Huiproperty.Childs.depends) {
            return HitroPackage.eINSTANCE.getHuiproperty_Depends();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Childs.validationRule) {
            return HitroPackage.eINSTANCE.getHuiproperty_ValidationRule();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Childs.option) {
            return HitroPackage.eINSTANCE.getHuiproperty_Option();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Properties.crudButtons) {
            return HitroPackage.eINSTANCE.getHuiproperty_CrudButtons();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Properties.defaultValue) {
            return HitroPackage.eINSTANCE.getHuiproperty_DefaultValue();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Properties.editable) {
            return HitroPackage.eINSTANCE.getHuiproperty_Editable();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Properties.focus) {
            return HitroPackage.eINSTANCE.getHuiproperty_Focus();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Base.id) {
            return HitroPackage.eINSTANCE.getHuiproperty_Id();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Type.inputtype) {
            return HitroPackage.eINSTANCE.getHuiproperty_Inputtype();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Type.isURL) {
            return HitroPackage.eINSTANCE.getHuiproperty_IsURL();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Type.max) {
            return HitroPackage.eINSTANCE.getHuiproperty_Max();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Type.min) {
            return HitroPackage.eINSTANCE.getHuiproperty_Min();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Base.name) {
            return HitroPackage.eINSTANCE.getHuiproperty_Name();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Properties.report) {
            return HitroPackage.eINSTANCE.getHuiproperty_Report();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Properties.required) {
            return HitroPackage.eINSTANCE.getHuiproperty_Required();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser) {
            return HitroPackage.eINSTANCE.getHuiproperty_ShowInObjectBrowser();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Properties.tags) {
            return HitroPackage.eINSTANCE.getHuiproperty_Tags();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Properties.textrows) {
            return HitroPackage.eINSTANCE.getHuiproperty_Textrows();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Properties.tooltip) {
            return HitroPackage.eINSTANCE.getHuiproperty_Tooltip();
        }
        if (editorKey == HitroViewsRepository.Huiproperty.Properties.visible) {
            return HitroPackage.eINSTANCE.getHuiproperty_Visible();
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
        Huiproperty huiproperty = (Huiproperty) semanticObject;
        if (HitroViewsRepository.Huiproperty.Childs.depends == event.getAffectedEditor()) {
            if (event.getKind() == PropertiesEditionEvent.ADD) {
                EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(
                        editingContext, this, dependsSettings, editingContext.getAdapterFactory());
                PropertiesEditingProvider provider = (PropertiesEditingProvider) editingContext
                        .getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
                if (provider != null) {
                    PropertiesEditingPolicy policy = provider.getPolicy(context);
                    if (policy instanceof CreateEditingPolicy) {
                        policy.execute();
                    }
                }
            } else if (event.getKind() == PropertiesEditionEvent.EDIT) {
                EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(
                        editingContext, this, (EObject) event.getNewValue(),
                        editingContext.getAdapterFactory());
                PropertiesEditingProvider provider = (PropertiesEditingProvider) editingContext
                        .getAdapterFactory()
                        .adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
                if (provider != null) {
                    PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
                    if (editionPolicy != null) {
                        editionPolicy.execute();
                    }
                }
            } else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
                dependsSettings.removeFromReference((EObject) event.getNewValue());
            } else if (event.getKind() == PropertiesEditionEvent.MOVE) {
                dependsSettings.move(event.getNewIndex(), (Depends) event.getNewValue());
            }
        }
        if (HitroViewsRepository.Huiproperty.Childs.validationRule == event.getAffectedEditor()) {
            if (event.getKind() == PropertiesEditionEvent.ADD) {
                EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(
                        editingContext, this, validationRuleSettings,
                        editingContext.getAdapterFactory());
                PropertiesEditingProvider provider = (PropertiesEditingProvider) editingContext
                        .getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
                if (provider != null) {
                    PropertiesEditingPolicy policy = provider.getPolicy(context);
                    if (policy instanceof CreateEditingPolicy) {
                        policy.execute();
                    }
                }
            } else if (event.getKind() == PropertiesEditionEvent.EDIT) {
                EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(
                        editingContext, this, (EObject) event.getNewValue(),
                        editingContext.getAdapterFactory());
                PropertiesEditingProvider provider = (PropertiesEditingProvider) editingContext
                        .getAdapterFactory()
                        .adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
                if (provider != null) {
                    PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
                    if (editionPolicy != null) {
                        editionPolicy.execute();
                    }
                }
            } else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
                validationRuleSettings.removeFromReference((EObject) event.getNewValue());
            } else if (event.getKind() == PropertiesEditionEvent.MOVE) {
                validationRuleSettings.move(event.getNewIndex(),
                        (ValidationRule) event.getNewValue());
            }
        }
        if (HitroViewsRepository.Huiproperty.Childs.option == event.getAffectedEditor()) {
            if (event.getKind() == PropertiesEditionEvent.ADD) {
                EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(
                        editingContext, this, optionSettings, editingContext.getAdapterFactory());
                PropertiesEditingProvider provider = (PropertiesEditingProvider) editingContext
                        .getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
                if (provider != null) {
                    PropertiesEditingPolicy policy = provider.getPolicy(context);
                    if (policy instanceof CreateEditingPolicy) {
                        policy.execute();
                    }
                }
            } else if (event.getKind() == PropertiesEditionEvent.EDIT) {
                EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(
                        editingContext, this, (EObject) event.getNewValue(),
                        editingContext.getAdapterFactory());
                PropertiesEditingProvider provider = (PropertiesEditingProvider) editingContext
                        .getAdapterFactory()
                        .adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
                if (provider != null) {
                    PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
                    if (editionPolicy != null) {
                        editionPolicy.execute();
                    }
                }
            } else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
                optionSettings.removeFromReference((EObject) event.getNewValue());
            } else if (event.getKind() == PropertiesEditionEvent.MOVE) {
                optionSettings.move(event.getNewIndex(), (Option) event.getNewValue());
            }
        }
        if (HitroViewsRepository.Huiproperty.Properties.crudButtons == event.getAffectedEditor()) {
            huiproperty.setCrudButtons((Boolean) event.getNewValue());
        }
        if (HitroViewsRepository.Huiproperty.Properties.defaultValue == event.getAffectedEditor()) {
            huiproperty.setDefaultValue((EEFConverterUtil.createIntFromString(
                    XMLTypePackage.Literals.INT, (String) event.getNewValue())));
        }
        if (HitroViewsRepository.Huiproperty.Properties.editable == event.getAffectedEditor()) {
            huiproperty.setEditable((Boolean) event.getNewValue());
        }
        if (HitroViewsRepository.Huiproperty.Properties.focus == event.getAffectedEditor()) {
            huiproperty.setFocus((Boolean) event.getNewValue());
        }
        if (HitroViewsRepository.Huiproperty.Base.id == event.getAffectedEditor()) {
            huiproperty.setId((java.lang.String) EEFConverterUtil
                    .createFromString(XMLTypePackage.Literals.ID, (String) event.getNewValue()));
        }
        if (HitroViewsRepository.Huiproperty.Type.inputtype == event.getAffectedEditor()) {
            huiproperty.setInputtype((Inputtypes) event.getNewValue());
        }
        if (HitroViewsRepository.Huiproperty.Type.isURL == event.getAffectedEditor()) {
            huiproperty.setIsURL((Boolean) event.getNewValue());
        }
        if (HitroViewsRepository.Huiproperty.Type.max == event.getAffectedEditor()) {
            huiproperty.setMax((EEFConverterUtil.createIntFromString(XMLTypePackage.Literals.INT,
                    (String) event.getNewValue())));
        }
        if (HitroViewsRepository.Huiproperty.Type.min == event.getAffectedEditor()) {
            huiproperty.setMin((EEFConverterUtil.createIntFromString(XMLTypePackage.Literals.INT,
                    (String) event.getNewValue())));
        }
        if (HitroViewsRepository.Huiproperty.Base.name == event.getAffectedEditor()) {
            huiproperty.setName((java.lang.String) EEFConverterUtil.createFromString(
                    XMLTypePackage.Literals.STRING, (String) event.getNewValue()));
        }
        if (HitroViewsRepository.Huiproperty.Properties.report == event.getAffectedEditor()) {
            huiproperty.setReport((Boolean) event.getNewValue());
        }
        if (HitroViewsRepository.Huiproperty.Properties.required == event.getAffectedEditor()) {
            huiproperty.setRequired((Boolean) event.getNewValue());
        }
        if (HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser == event
                .getAffectedEditor()) {
            huiproperty.setShowInObjectBrowser((Boolean) event.getNewValue());
        }
        if (HitroViewsRepository.Huiproperty.Properties.tags == event.getAffectedEditor()) {
            huiproperty.setTags((java.lang.String) EEFConverterUtil.createFromString(
                    XMLTypePackage.Literals.STRING, (String) event.getNewValue()));
        }
        if (HitroViewsRepository.Huiproperty.Properties.textrows == event.getAffectedEditor()) {
            huiproperty
                    .setTextrows((EEFConverterUtil.createIntFromString(XMLTypePackage.Literals.INT,
                            (String) event.getNewValue())));
        }
        if (HitroViewsRepository.Huiproperty.Properties.tooltip == event.getAffectedEditor()) {
            huiproperty.setTooltip((java.lang.String) EEFConverterUtil.createFromString(
                    XMLTypePackage.Literals.STRING, (String) event.getNewValue()));
        }
        if (HitroViewsRepository.Huiproperty.Properties.visible == event.getAffectedEditor()) {
            huiproperty.setVisible((Boolean) event.getNewValue());
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
            HuipropertyPropertiesEditionPart basePart = (HuipropertyPropertiesEditionPart) editingPart;
            if (HitroPackage.eINSTANCE.getHuiproperty_Depends().equals(msg.getFeature())
                    && isAccessible(HitroViewsRepository.Huiproperty.Childs.depends))
                basePart.updateDepends();
            if (HitroPackage.eINSTANCE.getHuiproperty_ValidationRule().equals(msg.getFeature())
                    && isAccessible(HitroViewsRepository.Huiproperty.Childs.validationRule))
                basePart.updateValidationRule();
            if (HitroPackage.eINSTANCE.getHuiproperty_Option().equals(msg.getFeature())
                    && isAccessible(HitroViewsRepository.Huiproperty.Childs.option))
                basePart.updateOption();
            if (HitroPackage.eINSTANCE.getHuiproperty_CrudButtons().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Properties.crudButtons))
                basePart.setCrudButtons((Boolean) msg.getNewValue());

            if (HitroPackage.eINSTANCE.getHuiproperty_DefaultValue().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Properties.defaultValue)) {
                if (msg.getNewValue() != null) {
                    basePart.setDefaultValue(EcoreUtil.convertToString(XMLTypePackage.Literals.INT,
                            msg.getNewValue()));
                } else {
                    basePart.setDefaultValue("");
                }
            }
            if (HitroPackage.eINSTANCE.getHuiproperty_Editable().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Properties.editable))
                basePart.setEditable((Boolean) msg.getNewValue());

            if (HitroPackage.eINSTANCE.getHuiproperty_Focus().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Properties.focus))
                basePart.setFocus((Boolean) msg.getNewValue());

            if (HitroPackage.eINSTANCE.getHuiproperty_Id().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Base.id)) {
                if (msg.getNewValue() != null) {
                    basePart.setId(EcoreUtil.convertToString(XMLTypePackage.Literals.ID,
                            msg.getNewValue()));
                } else {
                    basePart.setId("");
                }
            }
            if (HitroPackage.eINSTANCE.getHuiproperty_Inputtype().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject)
                    && isAccessible(HitroViewsRepository.Huiproperty.Type.inputtype))
                basePart.setInputtype((Inputtypes) msg.getNewValue());

            if (HitroPackage.eINSTANCE.getHuiproperty_IsURL().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Type.isURL))
                basePart.setIsURL((Boolean) msg.getNewValue());

            if (HitroPackage.eINSTANCE.getHuiproperty_Max().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Type.max)) {
                if (msg.getNewValue() != null) {
                    basePart.setMax(EcoreUtil.convertToString(XMLTypePackage.Literals.INT,
                            msg.getNewValue()));
                } else {
                    basePart.setMax("");
                }
            }
            if (HitroPackage.eINSTANCE.getHuiproperty_Min().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Type.min)) {
                if (msg.getNewValue() != null) {
                    basePart.setMin(EcoreUtil.convertToString(XMLTypePackage.Literals.INT,
                            msg.getNewValue()));
                } else {
                    basePart.setMin("");
                }
            }
            if (HitroPackage.eINSTANCE.getHuiproperty_Name().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Base.name)) {
                if (msg.getNewValue() != null) {
                    basePart.setName(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING,
                            msg.getNewValue()));
                } else {
                    basePart.setName("");
                }
            }
            if (HitroPackage.eINSTANCE.getHuiproperty_Report().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Properties.report))
                basePart.setReport((Boolean) msg.getNewValue());

            if (HitroPackage.eINSTANCE.getHuiproperty_Required().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Properties.required))
                basePart.setRequired((Boolean) msg.getNewValue());

            if (HitroPackage.eINSTANCE.getHuiproperty_ShowInObjectBrowser().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(
                            HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser))
                basePart.setShowInObjectBrowser((Boolean) msg.getNewValue());

            if (HitroPackage.eINSTANCE.getHuiproperty_Tags().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Properties.tags)) {
                if (msg.getNewValue() != null) {
                    basePart.setTags(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING,
                            msg.getNewValue()));
                } else {
                    basePart.setTags("");
                }
            }
            if (HitroPackage.eINSTANCE.getHuiproperty_Textrows().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Properties.textrows)) {
                if (msg.getNewValue() != null) {
                    basePart.setTextrows(EcoreUtil.convertToString(XMLTypePackage.Literals.INT,
                            msg.getNewValue()));
                } else {
                    basePart.setTextrows("");
                }
            }
            if (HitroPackage.eINSTANCE.getHuiproperty_Tooltip().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Properties.tooltip)) {
                if (msg.getNewValue() != null) {
                    basePart.setTooltip(EcoreUtil.convertToString(XMLTypePackage.Literals.STRING,
                            msg.getNewValue()));
                } else {
                    basePart.setTooltip("");
                }
            }
            if (HitroPackage.eINSTANCE.getHuiproperty_Visible().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(HitroViewsRepository.Huiproperty.Properties.visible))
                basePart.setVisible((Boolean) msg.getNewValue());

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
                HitroPackage.eINSTANCE.getHuiproperty_Depends(),
                HitroPackage.eINSTANCE.getHuiproperty_ValidationRule(),
                HitroPackage.eINSTANCE.getHuiproperty_Option(),
                HitroPackage.eINSTANCE.getHuiproperty_CrudButtons(),
                HitroPackage.eINSTANCE.getHuiproperty_DefaultValue(),
                HitroPackage.eINSTANCE.getHuiproperty_Editable(),
                HitroPackage.eINSTANCE.getHuiproperty_Focus(),
                HitroPackage.eINSTANCE.getHuiproperty_Id(),
                HitroPackage.eINSTANCE.getHuiproperty_Inputtype(),
                HitroPackage.eINSTANCE.getHuiproperty_IsURL(),
                HitroPackage.eINSTANCE.getHuiproperty_Max(),
                HitroPackage.eINSTANCE.getHuiproperty_Min(),
                HitroPackage.eINSTANCE.getHuiproperty_Name(),
                HitroPackage.eINSTANCE.getHuiproperty_Report(),
                HitroPackage.eINSTANCE.getHuiproperty_Required(),
                HitroPackage.eINSTANCE.getHuiproperty_ShowInObjectBrowser(),
                HitroPackage.eINSTANCE.getHuiproperty_Tags(),
                HitroPackage.eINSTANCE.getHuiproperty_Textrows(),
                HitroPackage.eINSTANCE.getHuiproperty_Tooltip(),
                HitroPackage.eINSTANCE.getHuiproperty_Visible());
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
        return key == HitroViewsRepository.Huiproperty.Base.id;
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
                if (HitroViewsRepository.Huiproperty.Properties.crudButtons == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE
                                .getHuiproperty_CrudButtons().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_CrudButtons().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Properties.defaultValue == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE
                                .getHuiproperty_DefaultValue().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE
                            .getHuiproperty_DefaultValue().getEAttributeType(), newValue);
                }
                if (HitroViewsRepository.Huiproperty.Properties.editable == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE
                                .getHuiproperty_Editable().getEAttributeType(), (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Editable().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Properties.focus == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getHuiproperty_Focus().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Focus().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Base.id == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getHuiproperty_Id().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Id().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Type.inputtype == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE
                                .getHuiproperty_Inputtype().getEAttributeType(), (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Inputtype().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Type.isURL == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getHuiproperty_IsURL().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_IsURL().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Type.max == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getHuiproperty_Max().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Max().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Type.min == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getHuiproperty_Min().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Min().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Base.name == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getHuiproperty_Name().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Name().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Properties.report == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getHuiproperty_Report().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Report().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Properties.required == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE
                                .getHuiproperty_Required().getEAttributeType(), (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Required().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE
                                .getHuiproperty_ShowInObjectBrowser().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(HitroPackage.eINSTANCE
                            .getHuiproperty_ShowInObjectBrowser().getEAttributeType(), newValue);
                }
                if (HitroViewsRepository.Huiproperty.Properties.tags == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getHuiproperty_Tags().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Tags().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Properties.textrows == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(HitroPackage.eINSTANCE
                                .getHuiproperty_Textrows().getEAttributeType(), (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Textrows().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Properties.tooltip == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getHuiproperty_Tooltip().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Tooltip().getEAttributeType(),
                            newValue);
                }
                if (HitroViewsRepository.Huiproperty.Properties.visible == event
                        .getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                HitroPackage.eINSTANCE.getHuiproperty_Visible().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE.validate(
                            HitroPackage.eINSTANCE.getHuiproperty_Visible().getEAttributeType(),
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
