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
package de.sernet.eclipse.hui.eef.properties.part.forms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;

import com.google.common.collect.Sets;

import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Inputtypes;
// Start of user code for imports
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart;
import de.sernet.eclipse.hitro.providers.HitroMessages;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class CustomHuipropertyPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, HuipropertyPropertiesEditionPart {

    private static final String EEF_CHECKBOX = "eef::Checkbox";
    private static final String EEF_TEXT = "eef::Text";
    protected Text id;
    protected Text name;
    protected EMFComboViewer inputtype;
    protected Button isURL;
    protected Text min;
    protected Text max;
    protected Button crudButtons;
    protected Text defaultValue;
    protected Button editable;
    protected Button focus;
    protected Button report;
    protected Button required;
    protected Button showInObjectBrowser;
    protected Text tags;
    protected Text textrows;
    protected Text tooltip;
    protected Button visible;
    protected ReferencesTable depends;
    protected List<ViewerFilter> dependsBusinessFilters = new ArrayList<>();
    protected List<ViewerFilter> dependsFilters = new ArrayList<>();
    protected ReferencesTable validationRule;
    protected List<ViewerFilter> validationRuleBusinessFilters = new ArrayList<>();
    protected List<ViewerFilter> validationRuleFilters = new ArrayList<>();
    protected ReferencesTable option;
    protected List<ViewerFilter> optionBusinessFilters = new ArrayList<>();
    protected List<ViewerFilter> optionFilters = new ArrayList<>();
    private Map<Object, Composite> fieldCompositeMap = new HashMap<>();
    public static final Set<Object> ALL_WIDGET_CONTAINERS = Sets.newHashSet(
            HitroViewsRepository.Huiproperty.Type.isURL, HitroViewsRepository.Huiproperty.Type.max,
            HitroViewsRepository.Huiproperty.Type.min,
            HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser,
            HitroViewsRepository.Huiproperty.Properties.textrows);
    public static final Set<Object> NUMBER_WIDGET_CONTAINERS = Sets.newHashSet(
            HitroViewsRepository.Huiproperty.Type.isURL,
            HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser,
            HitroViewsRepository.Huiproperty.Properties.textrows);
    public static final Set<Object> BOOLEAN_WIDGET_CONTAINERS = Sets.newHashSet(
            HitroViewsRepository.Huiproperty.Type.isURL,
            HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser,
            HitroViewsRepository.Huiproperty.Properties.textrows,
            HitroViewsRepository.Huiproperty.Type.max, HitroViewsRepository.Huiproperty.Type.min);
    public static final Set<Object> TEXT_WIDGET_CONTAINERS = Sets.newHashSet(
            HitroViewsRepository.Huiproperty.Type.isURL, HitroViewsRepository.Huiproperty.Type.max,
            HitroViewsRepository.Huiproperty.Type.min);
    public static final Set<Object> LINE_WIDGET_CONTAINERS = Sets.newHashSet(
            HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser,
            HitroViewsRepository.Huiproperty.Properties.textrows,
            HitroViewsRepository.Huiproperty.Type.max, HitroViewsRepository.Huiproperty.Type.min);

    /**
     * For {@link ISection} use only.
     */
    public CustomHuipropertyPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent
     *            the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public CustomHuipropertyPropertiesEditionPartForm(
            IPropertiesEditionComponent editionComponent) {
        super(editionComponent);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createFigure(org.eclipse.swt.widgets.Composite,
     *      org.eclipse.ui.forms.widgets.FormToolkit)
     * 
     */
    public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
        ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
        Form form = scrolledForm.getForm();
        view = form.getBody();
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        view.setLayout(layout);
        createControls(widgetFactory, view);
        return scrolledForm;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createControls(org.eclipse.ui.forms.widgets.FormToolkit,
     *      org.eclipse.swt.widgets.Composite)
     * 
     */
    public void createControls(final FormToolkit widgetFactory, Composite view) {
        CompositionSequence huipropertyStep = new BindingCompositionSequence(
                propertiesEditionComponent);
        CompositionStep baseStep = huipropertyStep
                .addStep(HitroViewsRepository.Huiproperty.Base.class);
        baseStep.addStep(HitroViewsRepository.Huiproperty.Base.id);
        baseStep.addStep(HitroViewsRepository.Huiproperty.Base.name);

        CompositionStep typeStep = huipropertyStep
                .addStep(HitroViewsRepository.Huiproperty.Type.class);
        typeStep.addStep(HitroViewsRepository.Huiproperty.Type.inputtype);
        typeStep.addStep(HitroViewsRepository.Huiproperty.Type.isURL);
        typeStep.addStep(HitroViewsRepository.Huiproperty.Type.min);
        typeStep.addStep(HitroViewsRepository.Huiproperty.Type.max);
        CompositionStep propertiesStep = huipropertyStep
                .addStep(HitroViewsRepository.Huiproperty.Properties.class);
        propertiesStep.addStep(HitroViewsRepository.Huiproperty.Properties.defaultValue);
        propertiesStep.addStep(HitroViewsRepository.Huiproperty.Properties.editable);
        propertiesStep.addStep(HitroViewsRepository.Huiproperty.Properties.focus);
        propertiesStep.addStep(HitroViewsRepository.Huiproperty.Properties.report);
        propertiesStep.addStep(HitroViewsRepository.Huiproperty.Properties.required);
        propertiesStep.addStep(HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser);
        propertiesStep.addStep(HitroViewsRepository.Huiproperty.Properties.tags);
        propertiesStep.addStep(HitroViewsRepository.Huiproperty.Properties.textrows);
        propertiesStep.addStep(HitroViewsRepository.Huiproperty.Properties.tooltip);
        propertiesStep.addStep(HitroViewsRepository.Huiproperty.Properties.visible);

        CompositionStep childsStep = huipropertyStep
                .addStep(HitroViewsRepository.Huiproperty.Childs.class);
        childsStep.addStep(HitroViewsRepository.Huiproperty.Childs.depends);
        childsStep.addStep(HitroViewsRepository.Huiproperty.Childs.validationRule);
        childsStep.addStep(HitroViewsRepository.Huiproperty.Childs.option);

        composer = new PartComposer(huipropertyStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == HitroViewsRepository.Huiproperty.Base.class) {
                    return createBaseGroup(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Base.id) {
                    return createIdText(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Base.name) {
                    return createNameText(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Type.class) {
                    return createTypeGroup(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Type.inputtype) {
                    return createInputtypeEMFComboViewer(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Type.isURL) {
                    Composite fieldContainer = createIsURLCheckbox(widgetFactory, parent);
                    fieldCompositeMap.put(key, fieldContainer);
                    return fieldContainer;
                }
                if (key == HitroViewsRepository.Huiproperty.Type.min) {
                    Composite fieldContainer = createMinText(widgetFactory, parent);
                    fieldCompositeMap.put(key, fieldContainer);
                    return fieldContainer;

                }
                if (key == HitroViewsRepository.Huiproperty.Type.max) {
                    Composite fieldContainer = createMaxText(widgetFactory, parent);
                    fieldCompositeMap.put(key, fieldContainer);
                    return fieldContainer;
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.defaultValue) {
                    return createDefaultValueText(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.editable) {
                    return createEditableCheckbox(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.focus) {
                    return createFocusCheckbox(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.report) {
                    return createReportCheckbox(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.required) {
                    return createRequiredCheckbox(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser) {
                    Composite fieldContainer = createShowInObjectBrowserCheckbox(widgetFactory,
                            parent);
                    fieldCompositeMap.put(key, fieldContainer);
                    return fieldContainer;
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.tags) {
                    return createTagsText(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.textrows) {
                    Composite fieldContainer = createTextrowsText(widgetFactory, parent);
                    fieldCompositeMap.put(key, fieldContainer);
                    return fieldContainer;
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.tooltip) {
                    return createTooltipText(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.visible) {
                    return createVisibleCheckbox(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Childs.class) {
                    return createChildsGroup(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Childs.depends) {
                    return createDependsTableComposition(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Childs.validationRule) {
                    return createValidationRuleTableComposition(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Childs.option) {
                    return createOptionTableComposition(widgetFactory, parent);
                }
                return parent;
            }
        };
        composer.compose(view);
        updateVisibility();
    }

    private Huiproperty getHuiProperty() {
        return (Huiproperty) eObject;
    }

    private void updateVisibility() {

        Inputtypes inputtypes = getHuiProperty().getInputtype();
        switch (inputtypes) {
        case DATE:
        case LINE:
            updateAllWidgets(LINE_WIDGET_CONTAINERS);
            break;
        case TEXT:
            updateAllWidgets(TEXT_WIDGET_CONTAINERS);
            break;
        case MULTIOPTION:
        case SINGLEOPTION:
        case NUMERICOPTION:
            updateAllWidgets(NUMBER_WIDGET_CONTAINERS);
            break;
        case BOOLEANOPTION:
            updateAllWidgets(BOOLEAN_WIDGET_CONTAINERS);
            break;
        default:
            break;
        }
    }

    private void updateAllWidgets(Collection<Object> widgetContainers) {
        ALL_WIDGET_CONTAINERS.stream().forEach(k -> {
            Composite c = fieldCompositeMap.get(k);
            if (c != null && !c.isDisposed()) {
                boolean visible2 = !widgetContainers.contains(k);
                c.setVisible(visible2);
                GridData parentData = new GridData(SWT.FILL, SWT.TOP, true, false);
                parentData.horizontalSpan = 3;
                parentData.verticalSpan = 1;
                parentData.heightHint = visible2 ? 32 : 0;
                c.setLayoutData(parentData);
                c.getParent().layout(visible2);
                Composite parent = c.getParent().getParent();
                if (parent instanceof Section) {
                    Section section = (Section) parent;
//                    section.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
                    Control client = section.getClient();
                    client.requestLayout();
                }
                parent.layout(true);
            }
        });
    }

    private Composite createFieldComposite(FormToolkit widgetFactory, Composite parent) {
        parent = widgetFactory.createComposite(parent, SWT.NONE);
        GridData parentData = new GridData(SWT.FILL, SWT.TOP, true, false);
        parentData.horizontalSpan = 3;
        parentData.verticalSpan = 1;
        parentData.heightHint = 40;
        parent.setLayoutData(parentData);
        GridLayout layout = new GridLayout(2, false);
        layout.marginWidth = 0;
        layout.marginHeight = 2;
        parent.setLayout(layout);
        parent.pack();
        return parent;
    }

    /**
     * 
     */
    protected Composite createBaseGroup(FormToolkit widgetFactory, final Composite parent) {
        Section baseSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        baseSection.setText(HitroMessages.HuipropertyPropertiesEditionPart_BaseGroupLabel);
        GridData baseSectionData = new GridData(GridData.FILL_HORIZONTAL);
        baseSectionData.horizontalSpan = 3;
        baseSection.setLayoutData(baseSectionData);
        Composite baseGroup = widgetFactory.createComposite(baseSection);
        GridLayout baseGroupLayout = new GridLayout();
        baseGroupLayout.numColumns = 3;
        baseGroup.setLayout(baseGroupLayout);
        baseSection.setClient(baseGroup);
        return baseGroup;
    }

    protected Composite createIdText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Base.id,
                HitroMessages.HuipropertyPropertiesEditionPart_IdLabel);
        id = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        id.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData idData = new GridData(GridData.FILL_HORIZONTAL);
        id.setLayoutData(idData);
        id.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Base.id, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, id.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Base.id,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                            null, id.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        id.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR && propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Base.id, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, id.getText()));
            }
        });
        EditingUtils.setID(id, HitroViewsRepository.Huiproperty.Base.id);
        EditingUtils.setEEFtype(id, EEF_TEXT); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Base.id, HitroViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createIdText

        // End of user code
        return parent;
    }

    protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Base.name,
                HitroMessages.HuipropertyPropertiesEditionPart_NameLabel);
        name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
        name.setLayoutData(nameData);
        name.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Base.name,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            name.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Base.name,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                            null, name.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        name.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR && propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Base.name,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            name.getText()));
            }
        });
        EditingUtils.setID(name, HitroViewsRepository.Huiproperty.Base.name);
        EditingUtils.setEEFtype(name, EEF_TEXT); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Base.name, HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createNameText

        // End of user code
        return parent;
    }

    /**
     * 
     */
    protected Composite createTypeGroup(FormToolkit widgetFactory, final Composite parent) {
        Section typeSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        typeSection.setText(HitroMessages.HuipropertyPropertiesEditionPart_TypeGroupLabel);
        GridData typeSectionData = new GridData(GridData.FILL_HORIZONTAL);
        typeSectionData.horizontalSpan = 3;
        typeSection.setLayoutData(typeSectionData);
        Composite typeGroup = widgetFactory.createComposite(typeSection);
        GridLayout typeGroupLayout = new GridLayout();
        typeGroupLayout.numColumns = 3;
        typeGroup.setLayout(typeGroupLayout);
        typeSection.setClient(typeGroup);
        return typeGroup;
    }

    protected Composite createInputtypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Type.inputtype,
                HitroMessages.HuipropertyPropertiesEditionPart_InputtypeLabel);
        inputtype = new EMFComboViewer(parent);
        inputtype.setContentProvider(new ArrayContentProvider());
        inputtype.setLabelProvider(
                new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData inputtypeData = new GridData(GridData.FILL_HORIZONTAL);
        inputtype.getCombo().setLayoutData(inputtypeData);
        inputtype.addSelectionChangedListener(e -> {
            if (propertiesEditionComponent != null)
                propertiesEditionComponent.firePropertiesChanged(
                        new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Type.inputtype,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                getInputtype()));
            updateVisibility();
        });
        inputtype.setID(HitroViewsRepository.Huiproperty.Type.inputtype);
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Type.inputtype,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createInputtypeEMFComboViewer

        // End of user code
        return parent;
    }

    protected Composite createIsURLCheckbox(FormToolkit widgetFactory, Composite parent) {
        parent = createFieldComposite(widgetFactory, parent);
        isURL = widgetFactory
                .createButton(parent,
                        getDescription(HitroViewsRepository.Huiproperty.Type.isURL,
                                HitroMessages.HuipropertyPropertiesEditionPart_IsURLLabel),
                        SWT.CHECK);
        isURL.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Type.isURL,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            Boolean.valueOf(isURL.getSelection())));
            }

        });
        GridData isURLData = new GridData(GridData.FILL_HORIZONTAL);
        isURLData.horizontalSpan = 2;
        isURL.setLayoutData(isURLData);
        EditingUtils.setID(isURL, HitroViewsRepository.Huiproperty.Type.isURL);
        EditingUtils.setEEFtype(isURL, EEF_CHECKBOX); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Type.isURL, HitroViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createIsURLCheckbox

        // End of user code
        return parent;
    }

    protected Composite createMinText(FormToolkit widgetFactory, Composite p) {
        Composite parent = createFieldComposite(widgetFactory, p);
        createDescription(parent, HitroViewsRepository.Huiproperty.Type.min,
                HitroMessages.HuipropertyPropertiesEditionPart_MinLabel);
        min = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        min.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData minData = new GridData(GridData.FILL_HORIZONTAL);
        min.setLayoutData(minData);
        min.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Type.min,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            min.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Type.min,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                            null, min.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        min.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR && propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Type.min,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            min.getText()));
            }
        });
        EditingUtils.setID(min, HitroViewsRepository.Huiproperty.Type.min);
        EditingUtils.setEEFtype(min, EEF_TEXT); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Type.min, HitroViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createMinText

        // End of user code
        return parent;
    }

    protected Composite createMaxText(FormToolkit widgetFactory, Composite parent) {
        parent = createFieldComposite(widgetFactory, parent);
        createDescription(parent, HitroViewsRepository.Huiproperty.Type.max,
                HitroMessages.HuipropertyPropertiesEditionPart_MaxLabel);
        max = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        max.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData maxData = new GridData(GridData.FILL_HORIZONTAL);
        max.setLayoutData(maxData);
        max.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Type.max,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            max.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Type.max,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                            null, max.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        max.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR && propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Type.max,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            max.getText()));
            }
        });
        EditingUtils.setID(max, HitroViewsRepository.Huiproperty.Type.max);
        EditingUtils.setEEFtype(max, EEF_TEXT); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Type.max, HitroViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createMaxText

        // End of user code
        return parent;
    }

    /**
     * 
     */
    protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
        Section propertiesSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        propertiesSection
                .setText(HitroMessages.HuipropertyPropertiesEditionPart_PropertiesGroupLabel);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = 3;
        propertiesSection.setLayoutData(propertiesSectionData);
        Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 3;
        propertiesGroup.setLayout(propertiesGroupLayout);
        propertiesSection.setClient(propertiesGroup);
        return propertiesGroup;
    }

    protected Composite createDefaultValueText(FormToolkit widgetFactory, Composite parent) {
        parent = createFieldComposite(widgetFactory, parent);
        createDescription(parent, HitroViewsRepository.Huiproperty.Properties.defaultValue,
                HitroMessages.HuipropertyPropertiesEditionPart_DefaultValueLabel);
        defaultValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        defaultValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData defaultValueData = new GridData(GridData.FILL_HORIZONTAL);
        defaultValue.setLayoutData(defaultValueData);
        defaultValue.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.defaultValue,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            defaultValue.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.defaultValue,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                            null, defaultValue.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        defaultValue.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR && propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.defaultValue,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            defaultValue.getText()));
            }
        });
        EditingUtils.setID(defaultValue, HitroViewsRepository.Huiproperty.Properties.defaultValue);
        EditingUtils.setEEFtype(defaultValue, EEF_TEXT); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.defaultValue,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createDefaultValueText

        // End of user code
        return parent;
    }

    protected Composite createEditableCheckbox(FormToolkit widgetFactory, Composite parent) {
        editable = widgetFactory
                .createButton(parent,
                        getDescription(HitroViewsRepository.Huiproperty.Properties.editable,
                                HitroMessages.HuipropertyPropertiesEditionPart_EditableLabel),
                        SWT.CHECK);
        editable.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.editable,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            Boolean.valueOf(editable.getSelection())));
            }

        });
        GridData editableData = new GridData(GridData.FILL_HORIZONTAL);
        editableData.horizontalSpan = 2;
        editable.setLayoutData(editableData);
        EditingUtils.setID(editable, HitroViewsRepository.Huiproperty.Properties.editable);
        EditingUtils.setEEFtype(editable, EEF_CHECKBOX); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.editable,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createEditableCheckbox

        // End of user code
        return parent;
    }

    protected Composite createFocusCheckbox(FormToolkit widgetFactory, Composite parent) {
        focus = widgetFactory
                .createButton(parent,
                        getDescription(HitroViewsRepository.Huiproperty.Properties.focus,
                                HitroMessages.HuipropertyPropertiesEditionPart_FocusLabel),
                        SWT.CHECK);
        focus.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.focus,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            Boolean.valueOf(focus.getSelection())));
            }

        });
        GridData focusData = new GridData(GridData.FILL_HORIZONTAL);
        focusData.horizontalSpan = 2;
        focus.setLayoutData(focusData);
        EditingUtils.setID(focus, HitroViewsRepository.Huiproperty.Properties.focus);
        EditingUtils.setEEFtype(focus, EEF_CHECKBOX); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.focus,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createFocusCheckbox

        // End of user code
        return parent;
    }

    protected Composite createReportCheckbox(FormToolkit widgetFactory, Composite parent) {
        report = widgetFactory
                .createButton(parent,
                        getDescription(HitroViewsRepository.Huiproperty.Properties.report,
                                HitroMessages.HuipropertyPropertiesEditionPart_ReportLabel),
                        SWT.CHECK);
        report.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.report,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            Boolean.valueOf(report.getSelection())));
            }

        });
        GridData reportData = new GridData(GridData.FILL_HORIZONTAL);
        reportData.horizontalSpan = 2;
        report.setLayoutData(reportData);
        EditingUtils.setID(report, HitroViewsRepository.Huiproperty.Properties.report);
        EditingUtils.setEEFtype(report, EEF_CHECKBOX); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.report,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createReportCheckbox

        // End of user code
        return parent;
    }

    protected Composite createRequiredCheckbox(FormToolkit widgetFactory, Composite parent) {
        required = widgetFactory
                .createButton(parent,
                        getDescription(HitroViewsRepository.Huiproperty.Properties.required,
                                HitroMessages.HuipropertyPropertiesEditionPart_RequiredLabel),
                        SWT.CHECK);
        required.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.required,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            Boolean.valueOf(required.getSelection())));
            }

        });
        GridData requiredData = new GridData(GridData.FILL_HORIZONTAL);
        requiredData.horizontalSpan = 2;
        required.setLayoutData(requiredData);
        EditingUtils.setID(required, HitroViewsRepository.Huiproperty.Properties.required);
        EditingUtils.setEEFtype(required, EEF_CHECKBOX); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.required,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createRequiredCheckbox

        // End of user code
        return parent;
    }

    protected Composite createShowInObjectBrowserCheckbox(FormToolkit widgetFactory,
            Composite parent) {
        parent = createFieldComposite(widgetFactory, parent);
        showInObjectBrowser = widgetFactory.createButton(parent,
                getDescription(HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser,
                        HitroMessages.HuipropertyPropertiesEditionPart_ShowInObjectBrowserLabel),
                SWT.CHECK);
        showInObjectBrowser.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            Boolean.valueOf(showInObjectBrowser.getSelection())));
            }

        });
        GridData showInObjectBrowserData = new GridData(GridData.FILL_HORIZONTAL);
        showInObjectBrowserData.horizontalSpan = 2;
        showInObjectBrowser.setLayoutData(showInObjectBrowserData);
        EditingUtils.setID(showInObjectBrowser,
                HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser);
        EditingUtils.setEEFtype(showInObjectBrowser, EEF_CHECKBOX); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createShowInObjectBrowserCheckbox

        // End of user code
        return parent;
    }

    protected Composite createTagsText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Properties.tags,
                HitroMessages.HuipropertyPropertiesEditionPart_TagsLabel);
        tags = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        tags.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData tagsData = new GridData(GridData.FILL_HORIZONTAL);
        tags.setLayoutData(tagsData);
        tags.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.tags,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            tags.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.tags,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                            null, tags.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        tags.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR && propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.tags,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            tags.getText()));
            }
        });
        EditingUtils.setID(tags, HitroViewsRepository.Huiproperty.Properties.tags);
        EditingUtils.setEEFtype(tags, EEF_TEXT); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.tags,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createTagsText

        // End of user code
        return parent;
    }

    protected Composite createTextrowsText(FormToolkit widgetFactory, Composite parent) {
        parent = createFieldComposite(widgetFactory, parent);
        createDescription(parent, HitroViewsRepository.Huiproperty.Properties.textrows,
                HitroMessages.HuipropertyPropertiesEditionPart_TextrowsLabel);
        textrows = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        textrows.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData textrowsData = new GridData(GridData.FILL_HORIZONTAL);
        textrows.setLayoutData(textrowsData);
        textrows.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.textrows,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            textrows.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.textrows,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                            null, textrows.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        textrows.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR && propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.textrows,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            textrows.getText()));
            }
        });
        EditingUtils.setID(textrows, HitroViewsRepository.Huiproperty.Properties.textrows);
        EditingUtils.setEEFtype(textrows, EEF_TEXT); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.textrows,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createTextrowsText

        // End of user code
        return parent;
    }

    protected Composite createTooltipText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Properties.tooltip,
                HitroMessages.HuipropertyPropertiesEditionPart_TooltipLabel);
        tooltip = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        tooltip.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData tooltipData = new GridData(GridData.FILL_HORIZONTAL);
        tooltip.setLayoutData(tooltipData);
        tooltip.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.tooltip,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            tooltip.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.tooltip,
                            PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
                            null, tooltip.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this, null,
                            PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        tooltip.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR && propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.tooltip,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            tooltip.getText()));
            }
        });
        EditingUtils.setID(tooltip, HitroViewsRepository.Huiproperty.Properties.tooltip);
        EditingUtils.setEEFtype(tooltip, EEF_TEXT); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.tooltip,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createTooltipText

        // End of user code
        return parent;
    }

    protected Composite createVisibleCheckbox(FormToolkit widgetFactory, Composite parent) {
        visible = widgetFactory
                .createButton(parent,
                        getDescription(HitroViewsRepository.Huiproperty.Properties.visible,
                                HitroMessages.HuipropertyPropertiesEditionPart_VisibleLabel),
                        SWT.CHECK);
        visible.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Properties.visible,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                            Boolean.valueOf(visible.getSelection())));
            }

        });
        GridData visibleData = new GridData(GridData.FILL_HORIZONTAL);
        visibleData.horizontalSpan = 2;
        visible.setLayoutData(visibleData);
        EditingUtils.setID(visible, HitroViewsRepository.Huiproperty.Properties.visible);
        EditingUtils.setEEFtype(visible, EEF_CHECKBOX); // $NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.visible,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createVisibleCheckbox

        // End of user code
        return parent;
    }

    /**
     * 
     */
    protected Composite createChildsGroup(FormToolkit widgetFactory, final Composite parent) {
        Section childsSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        childsSection.setText(HitroMessages.HuipropertyPropertiesEditionPart_ChildsGroupLabel);
        GridData childsSectionData = new GridData(GridData.FILL_HORIZONTAL);
        childsSectionData.horizontalSpan = 3;
        childsSection.setLayoutData(childsSectionData);
        Composite childsGroup = widgetFactory.createComposite(childsSection);
        GridLayout childsGroupLayout = new GridLayout();
        childsGroupLayout.numColumns = 3;
        childsGroup.setLayout(childsGroupLayout);
        childsSection.setClient(childsGroup);
        return childsGroup;
    }

    /**
     * @param container
     * 
     */
    protected Composite createDependsTableComposition(FormToolkit widgetFactory, Composite parent) {
        this.depends = new ReferencesTable(
                getDescription(HitroViewsRepository.Huiproperty.Childs.depends,
                        HitroMessages.HuipropertyPropertiesEditionPart_DependsLabel),
                new ReferencesTableListener() {
                    public void handleAdd() {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.depends,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null,
                                null));
                        depends.refresh();
                    }

                    public void handleEdit(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.depends,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null,
                                element));
                        depends.refresh();
                    }

                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.depends,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element,
                                newIndex));
                        depends.refresh();
                    }

                    public void handleRemove(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.depends,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null,
                                element));
                        depends.refresh();
                    }

                    public void navigateTo(EObject element) {
                        // nothing
                    }
                });
        for (ViewerFilter filter : this.dependsFilters) {
            this.depends.addFilter(filter);
        }
        this.depends.setHelpText(propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Childs.depends, HitroViewsRepository.FORM_KIND));
        this.depends.createControls(parent, widgetFactory);
        this.depends.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Childs.depends,
                            PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED,
                            null, e.item.getData()));
                }
            }

        });
        GridData dependsData = new GridData(GridData.FILL_HORIZONTAL);
        dependsData.horizontalSpan = 3;
        this.depends.setLayoutData(dependsData);
        this.depends.setLowerBound(0);
        this.depends.setUpperBound(-1);
        depends.setID(HitroViewsRepository.Huiproperty.Childs.depends);
        depends.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
        // Start of user code for createDependsTableComposition

        // End of user code
        return parent;
    }

    /**
     * @param container
     * 
     */
    protected Composite createValidationRuleTableComposition(FormToolkit widgetFactory,
            Composite parent) {
        this.validationRule = new ReferencesTable(
                getDescription(HitroViewsRepository.Huiproperty.Childs.validationRule,
                        HitroMessages.HuipropertyPropertiesEditionPart_ValidationRuleLabel),
                new ReferencesTableListener() {
                    public void handleAdd() {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.validationRule,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null,
                                null));
                        validationRule.refresh();
                    }

                    public void handleEdit(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.validationRule,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null,
                                element));
                        validationRule.refresh();
                    }

                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.validationRule,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element,
                                newIndex));
                        validationRule.refresh();
                    }

                    public void handleRemove(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.validationRule,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null,
                                element));
                        validationRule.refresh();
                    }

                    public void navigateTo(EObject element) {
                        // nothing
                    }
                });
        for (ViewerFilter filter : this.validationRuleFilters) {
            this.validationRule.addFilter(filter);
        }
        this.validationRule.setHelpText(propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Childs.validationRule,
                HitroViewsRepository.FORM_KIND));
        this.validationRule.createControls(parent, widgetFactory);
        this.validationRule.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Childs.validationRule,
                            PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED,
                            null, e.item.getData()));
                }
            }

        });
        GridData validationRuleData = new GridData(GridData.FILL_HORIZONTAL);
        validationRuleData.horizontalSpan = 3;
        this.validationRule.setLayoutData(validationRuleData);
        this.validationRule.setLowerBound(0);
        this.validationRule.setUpperBound(-1);
        validationRule.setID(HitroViewsRepository.Huiproperty.Childs.validationRule);
        validationRule.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
        // Start of user code for createValidationRuleTableComposition

        // End of user code
        return parent;
    }

    /**
     * @param container
     * 
     */
    protected Composite createOptionTableComposition(FormToolkit widgetFactory, Composite parent) {
        this.option = new ReferencesTable(
                getDescription(HitroViewsRepository.Huiproperty.Childs.option,
                        HitroMessages.HuipropertyPropertiesEditionPart_OptionLabel),
                new ReferencesTableListener() {
                    public void handleAdd() {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.option,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null,
                                null));
                        option.refresh();
                    }

                    public void handleEdit(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.option,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null,
                                element));
                        option.refresh();
                    }

                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.option,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element,
                                newIndex));
                        option.refresh();
                    }

                    public void handleRemove(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartForm.this,
                                HitroViewsRepository.Huiproperty.Childs.option,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null,
                                element));
                        option.refresh();
                    }

                    public void navigateTo(EObject element) {
                        // nothing
                    }
                });
        for (ViewerFilter filter : this.optionFilters) {
            this.option.addFilter(filter);
        }
        this.option.setHelpText(propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Childs.option, HitroViewsRepository.FORM_KIND));
        this.option.createControls(parent, widgetFactory);
        this.option.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartForm.this,
                            HitroViewsRepository.Huiproperty.Childs.option,
                            PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED,
                            null, e.item.getData()));
                }
            }

        });
        GridData optionData = new GridData(GridData.FILL_HORIZONTAL);
        optionData.horizontalSpan = 3;
        this.option.setLayoutData(optionData);
        this.option.setLowerBound(0);
        this.option.setUpperBound(-1);
        option.setID(HitroViewsRepository.Huiproperty.Childs.option);
        option.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
        // Start of user code for createOptionTableComposition

        // End of user code
        return parent;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     * 
     */
    public void firePropertiesChanged(IPropertiesEditionEvent event) {
        // Start of user code for tab synchronization

        // End of user code
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getId()
     * 
     */
    public String getId() {
        return id.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setId(String
     *      newValue)
     * 
     */
    public void setId(String newValue) {
        if (newValue != null) {
            id.setText(newValue);
        } else {
            id.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Base.id);
        if (eefElementEditorReadOnlyState && id.isEnabled()) {
            id.setEnabled(false);
            id.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !id.isEnabled()) {
            id.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getName()
     * 
     */
    public String getName() {
        return name.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setName(String
     *      newValue)
     * 
     */
    public void setName(String newValue) {
        if (newValue != null) {
            name.setText(newValue);
        } else {
            name.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Base.name);
        if (eefElementEditorReadOnlyState && name.isEnabled()) {
            name.setEnabled(false);
            name.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
            name.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getInputtype()
     * 
     */
    public Enumerator getInputtype() {
        return (Enumerator) ((StructuredSelection) inputtype.getSelection()).getFirstElement();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#initInputtype(Object
     *      input, Enumerator current)
     */
    public void initInputtype(Object input, Enumerator current) {
        inputtype.setInput(input);
        inputtype.modelUpdating(new StructuredSelection(current));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Type.inputtype);
        if (eefElementEditorReadOnlyState && inputtype.isEnabled()) {
            inputtype.setEnabled(false);
            inputtype.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !inputtype.isEnabled()) {
            inputtype.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setInputtype(Enumerator
     *      newValue)
     * 
     */
    public void setInputtype(Enumerator newValue) {
        inputtype.modelUpdating(new StructuredSelection(newValue));
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Type.inputtype);
        if (eefElementEditorReadOnlyState && inputtype.isEnabled()) {
            inputtype.setEnabled(false);
            inputtype.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !inputtype.isEnabled()) {
            inputtype.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getIsURL()
     * 
     */
    public Boolean getIsURL() {
        return Boolean.valueOf(isURL.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setIsURL(Boolean
     *      newValue)
     * 
     */
    public void setIsURL(Boolean newValue) {
        if (newValue != null) {
            isURL.setSelection(newValue.booleanValue());
        } else {
            isURL.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Type.isURL);
        if (eefElementEditorReadOnlyState && isURL.isEnabled()) {
            isURL.setEnabled(false);
            isURL.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !isURL.isEnabled()) {
            isURL.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getMin()
     * 
     */
    public String getMin() {
        return min.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setMin(String
     *      newValue)
     * 
     */
    public void setMin(String newValue) {
        if (newValue != null) {
            min.setText(newValue);
        } else {
            min.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Type.min);
        if (eefElementEditorReadOnlyState && min.isEnabled()) {
            min.setEnabled(false);
            min.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !min.isEnabled()) {
            min.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getMax()
     * 
     */
    public String getMax() {
        return max.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setMax(String
     *      newValue)
     * 
     */
    public void setMax(String newValue) {
        if (newValue != null) {
            max.setText(newValue);
        } else {
            max.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Type.max);
        if (eefElementEditorReadOnlyState && max.isEnabled()) {
            max.setEnabled(false);
            max.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !max.isEnabled()) {
            max.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getCrudButtons()
     * 
     */
    public Boolean getCrudButtons() {
        return Boolean.valueOf(crudButtons.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setCrudButtons(Boolean
     *      newValue)
     * 
     */
    public void setCrudButtons(Boolean newValue) {
        if (newValue != null) {
            crudButtons.setSelection(newValue.booleanValue());
        } else {
            crudButtons.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Properties.crudButtons);
        if (eefElementEditorReadOnlyState && crudButtons.isEnabled()) {
            crudButtons.setEnabled(false);
            crudButtons.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !crudButtons.isEnabled()) {
            crudButtons.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getDefaultValue()
     * 
     */
    public String getDefaultValue() {
        return defaultValue.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setDefaultValue(String
     *      newValue)
     * 
     */
    public void setDefaultValue(String newValue) {
        if (newValue != null) {
            defaultValue.setText(newValue);
        } else {
            defaultValue.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Properties.defaultValue);
        if (eefElementEditorReadOnlyState && defaultValue.isEnabled()) {
            defaultValue.setEnabled(false);
            defaultValue.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !defaultValue.isEnabled()) {
            defaultValue.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getEditable()
     * 
     */
    public Boolean getEditable() {
        return Boolean.valueOf(editable.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setEditable(Boolean
     *      newValue)
     * 
     */
    public void setEditable(Boolean newValue) {
        if (newValue != null) {
            editable.setSelection(newValue.booleanValue());
        } else {
            editable.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Properties.editable);
        if (eefElementEditorReadOnlyState && editable.isEnabled()) {
            editable.setEnabled(false);
            editable.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !editable.isEnabled()) {
            editable.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getFocus()
     * 
     */
    public Boolean getFocus() {
        return Boolean.valueOf(focus.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setFocus(Boolean
     *      newValue)
     * 
     */
    public void setFocus(Boolean newValue) {
        if (newValue != null) {
            focus.setSelection(newValue.booleanValue());
        } else {
            focus.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Properties.focus);
        if (eefElementEditorReadOnlyState && focus.isEnabled()) {
            focus.setEnabled(false);
            focus.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !focus.isEnabled()) {
            focus.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getReport()
     * 
     */
    public Boolean getReport() {
        return Boolean.valueOf(report.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setReport(Boolean
     *      newValue)
     * 
     */
    public void setReport(Boolean newValue) {
        if (newValue != null) {
            report.setSelection(newValue.booleanValue());
        } else {
            report.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Properties.report);
        if (eefElementEditorReadOnlyState && report.isEnabled()) {
            report.setEnabled(false);
            report.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !report.isEnabled()) {
            report.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getRequired()
     * 
     */
    public Boolean getRequired() {
        return Boolean.valueOf(required.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setRequired(Boolean
     *      newValue)
     * 
     */
    public void setRequired(Boolean newValue) {
        if (newValue != null) {
            required.setSelection(newValue.booleanValue());
        } else {
            required.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Properties.required);
        if (eefElementEditorReadOnlyState && required.isEnabled()) {
            required.setEnabled(false);
            required.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !required.isEnabled()) {
            required.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getShowInObjectBrowser()
     * 
     */
    public Boolean getShowInObjectBrowser() {
        return Boolean.valueOf(showInObjectBrowser.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setShowInObjectBrowser(Boolean
     *      newValue)
     * 
     */
    public void setShowInObjectBrowser(Boolean newValue) {
        if (newValue != null) {
            showInObjectBrowser.setSelection(newValue.booleanValue());
        } else {
            showInObjectBrowser.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser);
        if (eefElementEditorReadOnlyState && showInObjectBrowser.isEnabled()) {
            showInObjectBrowser.setEnabled(false);
            showInObjectBrowser.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !showInObjectBrowser.isEnabled()) {
            showInObjectBrowser.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getTags()
     * 
     */
    public String getTags() {
        return tags.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setTags(String
     *      newValue)
     * 
     */
    public void setTags(String newValue) {
        if (newValue != null) {
            tags.setText(newValue);
        } else {
            tags.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Properties.tags);
        if (eefElementEditorReadOnlyState && tags.isEnabled()) {
            tags.setEnabled(false);
            tags.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !tags.isEnabled()) {
            tags.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getTextrows()
     * 
     */
    public String getTextrows() {
        return textrows.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setTextrows(String
     *      newValue)
     * 
     */
    public void setTextrows(String newValue) {
        if (newValue != null) {
            textrows.setText(newValue);
        } else {
            textrows.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Properties.textrows);
        if (eefElementEditorReadOnlyState && textrows.isEnabled()) {
            textrows.setEnabled(false);
            textrows.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !textrows.isEnabled()) {
            textrows.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getTooltip()
     * 
     */
    public String getTooltip() {
        return tooltip.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setTooltip(String
     *      newValue)
     * 
     */
    public void setTooltip(String newValue) {
        if (newValue != null) {
            tooltip.setText(newValue);
        } else {
            tooltip.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Properties.tooltip);
        if (eefElementEditorReadOnlyState && tooltip.isEnabled()) {
            tooltip.setEnabled(false);
            tooltip.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !tooltip.isEnabled()) {
            tooltip.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#getVisible()
     * 
     */
    public Boolean getVisible() {
        return Boolean.valueOf(visible.getSelection());
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#setVisible(Boolean
     *      newValue)
     * 
     */
    public void setVisible(Boolean newValue) {
        if (newValue != null) {
            visible.setSelection(newValue.booleanValue());
        } else {
            visible.setSelection(false);
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Properties.visible);
        if (eefElementEditorReadOnlyState && visible.isEnabled()) {
            visible.setEnabled(false);
            visible.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !visible.isEnabled()) {
            visible.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#initDepends(EObject
     *      current, EReference containingFeature, EReference feature)
     */
    public void initDepends(ReferencesTableSettings settings) {
        if (current.eResource() != null && current.eResource().getResourceSet() != null)
            this.resourceSet = current.eResource().getResourceSet();
        ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
        depends.setContentProvider(contentProvider);
        depends.setInput(settings);
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Childs.depends);
        if (eefElementEditorReadOnlyState && depends.isEnabled()) {
            depends.setEnabled(false);
            depends.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !depends.isEnabled()) {
            depends.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#updateDepends()
     * 
     */
    public void updateDepends() {
        depends.refresh();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#addFilterDepends(ViewerFilter
     *      filter)
     * 
     */
    public void addFilterToDepends(ViewerFilter filter) {
        dependsFilters.add(filter);
        if (this.depends != null) {
            this.depends.addFilter(filter);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#addBusinessFilterDepends(ViewerFilter
     *      filter)
     * 
     */
    public void addBusinessFilterToDepends(ViewerFilter filter) {
        dependsBusinessFilters.add(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#isContainedInDependsTable(EObject
     *      element)
     * 
     */
    public boolean isContainedInDependsTable(EObject element) {
        return ((ReferencesTableSettings) depends.getInput()).contains(element);
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#initValidationRule(EObject
     *      current, EReference containingFeature, EReference feature)
     */
    public void initValidationRule(ReferencesTableSettings settings) {
        if (current.eResource() != null && current.eResource().getResourceSet() != null)
            this.resourceSet = current.eResource().getResourceSet();
        ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
        validationRule.setContentProvider(contentProvider);
        validationRule.setInput(settings);
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Childs.validationRule);
        if (eefElementEditorReadOnlyState && validationRule.isEnabled()) {
            validationRule.setEnabled(false);
            validationRule.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !validationRule.isEnabled()) {
            validationRule.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#updateValidationRule()
     * 
     */
    public void updateValidationRule() {
        validationRule.refresh();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#addFilterValidationRule(ViewerFilter
     *      filter)
     * 
     */
    public void addFilterToValidationRule(ViewerFilter filter) {
        validationRuleFilters.add(filter);
        if (this.validationRule != null) {
            this.validationRule.addFilter(filter);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#addBusinessFilterValidationRule(ViewerFilter
     *      filter)
     * 
     */
    public void addBusinessFilterToValidationRule(ViewerFilter filter) {
        validationRuleBusinessFilters.add(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#isContainedInValidationRuleTable(EObject
     *      element)
     * 
     */
    public boolean isContainedInValidationRuleTable(EObject element) {
        return ((ReferencesTableSettings) validationRule.getInput()).contains(element);
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#initOption(EObject
     *      current, EReference containingFeature, EReference feature)
     */
    public void initOption(ReferencesTableSettings settings) {
        if (current.eResource() != null && current.eResource().getResourceSet() != null)
            this.resourceSet = current.eResource().getResourceSet();
        ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
        option.setContentProvider(contentProvider);
        option.setInput(settings);
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Huiproperty.Childs.option);
        if (eefElementEditorReadOnlyState && option.isEnabled()) {
            option.setEnabled(false);
            option.setToolTipText(HitroMessages.Huiproperty_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !option.isEnabled()) {
            option.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#updateOption()
     * 
     */
    public void updateOption() {
        option.refresh();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#addFilterOption(ViewerFilter
     *      filter)
     * 
     */
    public void addFilterToOption(ViewerFilter filter) {
        optionFilters.add(filter);
        if (this.option != null) {
            this.option.addFilter(filter);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#addBusinessFilterOption(ViewerFilter
     *      filter)
     * 
     */
    public void addBusinessFilterToOption(ViewerFilter filter) {
        optionBusinessFilters.add(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart#isContainedInOptionTable(EObject
     *      element)
     * 
     */
    public boolean isContainedInOptionTable(EObject element) {
        return ((ReferencesTableSettings) option.getInput()).contains(element);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     * 
     */
    public String getTitle() {
        return HitroMessages.Huiproperty_Part_Title;
    }

    // Start of user code additional methods

    // End of user code

}
