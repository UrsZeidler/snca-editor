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
package de.sernet.eclipse.hui.eef.properties.part.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// Start of user code for imports
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.HuipropertyPropertiesEditionPart;
import de.sernet.eclipse.hitro.providers.HitroMessages;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class CustomHuipropertyPropertiesEditionPartImpl extends CompositePropertiesEditionPart
        implements ISWTPropertiesEditionPart, HuipropertyPropertiesEditionPart {

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
    protected List<ViewerFilter> dependsBusinessFilters = new ArrayList<ViewerFilter>();
    protected List<ViewerFilter> dependsFilters = new ArrayList<ViewerFilter>();
    protected ReferencesTable validationRule;
    protected List<ViewerFilter> validationRuleBusinessFilters = new ArrayList<ViewerFilter>();
    protected List<ViewerFilter> validationRuleFilters = new ArrayList<ViewerFilter>();
    protected ReferencesTable option;
    protected List<ViewerFilter> optionBusinessFilters = new ArrayList<ViewerFilter>();
    protected List<ViewerFilter> optionFilters = new ArrayList<ViewerFilter>();

    /**
     * Default constructor
     * 
     * @param editionComponent
     *            the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public CustomHuipropertyPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
        super(editionComponent);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
     *      createFigure(org.eclipse.swt.widgets.Composite)
     * 
     */
    public Composite createFigure(final Composite parent) {
        view = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        view.setLayout(layout);
        createControls(view);
        return view;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
     *      createControls(org.eclipse.swt.widgets.Composite)
     * 
     */
    public void createControls(Composite view) {
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
        propertiesStep.addStep(HitroViewsRepository.Huiproperty.Properties.crudButtons);
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
                    return createBaseGroup(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Base.id) {
                    return createIdText(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Base.name) {
                    return createNameText(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Type.class) {
                    return createTypeGroup(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Type.inputtype) {
                    return createInputtypeEMFComboViewer(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Type.isURL) {
                    return createIsURLCheckbox(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Type.min) {
                    return createMinText(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Type.max) {
                    return createMaxText(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.class) {
                    return createPropertiesGroup(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.crudButtons) {
                    return createCrudButtonsCheckbox(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.defaultValue) {
                    return createDefaultValueText(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.editable) {
                    return createEditableCheckbox(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.focus) {
                    return createFocusCheckbox(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.report) {
                    return createReportCheckbox(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.required) {
                    return createRequiredCheckbox(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser) {
                    return createShowInObjectBrowserCheckbox(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.tags) {
                    return createTagsText(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.textrows) {
                    return createTextrowsText(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.tooltip) {
                    return createTooltipText(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Properties.visible) {
                    return createVisibleCheckbox(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Childs.class) {
                    return createChildsGroup(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Childs.depends) {
                    return createDependsAdvancedTableComposition(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Childs.validationRule) {
                    return createValidationRuleAdvancedTableComposition(parent);
                }
                if (key == HitroViewsRepository.Huiproperty.Childs.option) {
                    return createOptionAdvancedTableComposition(parent);
                }
                return parent;
            }
        };
        composer.compose(view);
    }

    /**
     * 
     */
    protected Composite createBaseGroup(Composite parent) {
        Group baseGroup = new Group(parent, SWT.NONE);
        baseGroup.setText(HitroMessages.HuipropertyPropertiesEditionPart_BaseGroupLabel);
        GridData baseGroupData = new GridData(GridData.FILL_HORIZONTAL);
        baseGroupData.horizontalSpan = 3;
        baseGroup.setLayoutData(baseGroupData);
        GridLayout baseGroupLayout = new GridLayout();
        baseGroupLayout.numColumns = 3;
        baseGroup.setLayout(baseGroupLayout);
        return baseGroup;
    }

    protected Composite createIdText(Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Base.id,
                HitroMessages.HuipropertyPropertiesEditionPart_IdLabel);
        id = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData idData = new GridData(GridData.FILL_HORIZONTAL);
        id.setLayoutData(idData);
        id.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartImpl.this,
                            HitroViewsRepository.Huiproperty.Base.id, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, id.getText()));
            }

        });
        id.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Base.id,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                id.getText()));
                }
            }

        });
        EditingUtils.setID(id, HitroViewsRepository.Huiproperty.Base.id);
        EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Base.id, HitroViewsRepository.SWT_KIND), null); // $NON-NLS-1$
        // Start of user code for createIdText

        // End of user code
        return parent;
    }

    protected Composite createNameText(Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Base.name,
                HitroMessages.HuipropertyPropertiesEditionPart_NameLabel);
        name = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
        name.setLayoutData(nameData);
        name.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Base.name,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    name.getText()));
            }

        });
        name.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Base.name,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                name.getText()));
                }
            }

        });
        EditingUtils.setID(name, HitroViewsRepository.Huiproperty.Base.name);
        EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Base.name, HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createNameText

        // End of user code
        return parent;
    }

    /**
     * 
     */
    protected Composite createTypeGroup(Composite parent) {
        Group typeGroup = new Group(parent, SWT.NONE);
        typeGroup.setText(HitroMessages.HuipropertyPropertiesEditionPart_TypeGroupLabel);
        GridData typeGroupData = new GridData(GridData.FILL_HORIZONTAL);
        typeGroupData.horizontalSpan = 3;
        typeGroup.setLayoutData(typeGroupData);
        GridLayout typeGroupLayout = new GridLayout();
        typeGroupLayout.numColumns = 3;
        typeGroup.setLayout(typeGroupLayout);
        return typeGroup;
    }

    protected Composite createInputtypeEMFComboViewer(Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Type.inputtype,
                HitroMessages.HuipropertyPropertiesEditionPart_InputtypeLabel);
        inputtype = new EMFComboViewer(parent);
        inputtype.setContentProvider(new ArrayContentProvider());
        inputtype.setLabelProvider(
                new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
        GridData inputtypeData = new GridData(GridData.FILL_HORIZONTAL);
        inputtype.getCombo().setLayoutData(inputtypeData);
        inputtype.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             * 
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Type.inputtype,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    getInputtype()));
            }

        });
        inputtype.setID(HitroViewsRepository.Huiproperty.Type.inputtype);
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Type.inputtype,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createInputtypeEMFComboViewer

        // End of user code
        return parent;
    }

    protected Composite createIsURLCheckbox(Composite parent) {
        isURL = new Button(parent, SWT.CHECK);
        isURL.setText(getDescription(HitroViewsRepository.Huiproperty.Type.isURL,
                HitroMessages.HuipropertyPropertiesEditionPart_IsURLLabel));
        isURL.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Type.isURL,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new Boolean(isURL.getSelection())));
            }

        });
        GridData isURLData = new GridData(GridData.FILL_HORIZONTAL);
        isURLData.horizontalSpan = 2;
        isURL.setLayoutData(isURLData);
        EditingUtils.setID(isURL, HitroViewsRepository.Huiproperty.Type.isURL);
        EditingUtils.setEEFtype(isURL, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Type.isURL, HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createIsURLCheckbox

        // End of user code
        return parent;
    }

    protected Composite createMinText(Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Type.min,
                HitroMessages.HuipropertyPropertiesEditionPart_MinLabel);
        min = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData minData = new GridData(GridData.FILL_HORIZONTAL);
        min.setLayoutData(minData);
        min.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Type.min,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    min.getText()));
            }

        });
        min.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Type.min,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                min.getText()));
                }
            }

        });
        EditingUtils.setID(min, HitroViewsRepository.Huiproperty.Type.min);
        EditingUtils.setEEFtype(min, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Type.min, HitroViewsRepository.SWT_KIND), null); // $NON-NLS-1$
        // Start of user code for createMinText

        // End of user code
        return parent;
    }

    protected Composite createMaxText(Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Type.max,
                HitroMessages.HuipropertyPropertiesEditionPart_MaxLabel);
        max = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData maxData = new GridData(GridData.FILL_HORIZONTAL);
        max.setLayoutData(maxData);
        max.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Type.max,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    max.getText()));
            }

        });
        max.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Type.max,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                max.getText()));
                }
            }

        });
        EditingUtils.setID(max, HitroViewsRepository.Huiproperty.Type.max);
        EditingUtils.setEEFtype(max, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Type.max, HitroViewsRepository.SWT_KIND), null); // $NON-NLS-1$
        // Start of user code for createMaxText

        // End of user code
        return parent;
    }

    /**
     * 
     */
    protected Composite createPropertiesGroup(Composite parent) {
        Group propertiesGroup = new Group(parent, SWT.NONE);
        propertiesGroup
                .setText(HitroMessages.HuipropertyPropertiesEditionPart_PropertiesGroupLabel);
        GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesGroupData.horizontalSpan = 3;
        propertiesGroup.setLayoutData(propertiesGroupData);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 3;
        propertiesGroup.setLayout(propertiesGroupLayout);
        return propertiesGroup;
    }

    protected Composite createCrudButtonsCheckbox(Composite parent) {
        crudButtons = new Button(parent, SWT.CHECK);
        crudButtons.setText(getDescription(HitroViewsRepository.Huiproperty.Properties.crudButtons,
                HitroMessages.HuipropertyPropertiesEditionPart_CrudButtonsLabel));
        crudButtons.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Properties.crudButtons,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new Boolean(crudButtons.getSelection())));
            }

        });
        GridData crudButtonsData = new GridData(GridData.FILL_HORIZONTAL);
        crudButtonsData.horizontalSpan = 2;
        crudButtons.setLayoutData(crudButtonsData);
        EditingUtils.setID(crudButtons, HitroViewsRepository.Huiproperty.Properties.crudButtons);
        EditingUtils.setEEFtype(crudButtons, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.crudButtons,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createCrudButtonsCheckbox

        // End of user code
        return parent;
    }

    protected Composite createDefaultValueText(Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Properties.defaultValue,
                HitroMessages.HuipropertyPropertiesEditionPart_DefaultValueLabel);
        defaultValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData defaultValueData = new GridData(GridData.FILL_HORIZONTAL);
        defaultValue.setLayoutData(defaultValueData);
        defaultValue.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Properties.defaultValue,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    defaultValue.getText()));
            }

        });
        defaultValue.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Properties.defaultValue,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                defaultValue.getText()));
                }
            }

        });
        EditingUtils.setID(defaultValue, HitroViewsRepository.Huiproperty.Properties.defaultValue);
        EditingUtils.setEEFtype(defaultValue, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.defaultValue,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createDefaultValueText

        // End of user code
        return parent;
    }

    protected Composite createEditableCheckbox(Composite parent) {
        editable = new Button(parent, SWT.CHECK);
        editable.setText(getDescription(HitroViewsRepository.Huiproperty.Properties.editable,
                HitroMessages.HuipropertyPropertiesEditionPart_EditableLabel));
        editable.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Properties.editable,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new Boolean(editable.getSelection())));
            }

        });
        GridData editableData = new GridData(GridData.FILL_HORIZONTAL);
        editableData.horizontalSpan = 2;
        editable.setLayoutData(editableData);
        EditingUtils.setID(editable, HitroViewsRepository.Huiproperty.Properties.editable);
        EditingUtils.setEEFtype(editable, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.editable,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createEditableCheckbox

        // End of user code
        return parent;
    }

    protected Composite createFocusCheckbox(Composite parent) {
        focus = new Button(parent, SWT.CHECK);
        focus.setText(getDescription(HitroViewsRepository.Huiproperty.Properties.focus,
                HitroMessages.HuipropertyPropertiesEditionPart_FocusLabel));
        focus.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Properties.focus,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new Boolean(focus.getSelection())));
            }

        });
        GridData focusData = new GridData(GridData.FILL_HORIZONTAL);
        focusData.horizontalSpan = 2;
        focus.setLayoutData(focusData);
        EditingUtils.setID(focus, HitroViewsRepository.Huiproperty.Properties.focus);
        EditingUtils.setEEFtype(focus, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.focus,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createFocusCheckbox

        // End of user code
        return parent;
    }

    protected Composite createReportCheckbox(Composite parent) {
        report = new Button(parent, SWT.CHECK);
        report.setText(getDescription(HitroViewsRepository.Huiproperty.Properties.report,
                HitroMessages.HuipropertyPropertiesEditionPart_ReportLabel));
        report.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Properties.report,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new Boolean(report.getSelection())));
            }

        });
        GridData reportData = new GridData(GridData.FILL_HORIZONTAL);
        reportData.horizontalSpan = 2;
        report.setLayoutData(reportData);
        EditingUtils.setID(report, HitroViewsRepository.Huiproperty.Properties.report);
        EditingUtils.setEEFtype(report, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.report,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createReportCheckbox

        // End of user code
        return parent;
    }

    protected Composite createRequiredCheckbox(Composite parent) {
        required = new Button(parent, SWT.CHECK);
        required.setText(getDescription(HitroViewsRepository.Huiproperty.Properties.required,
                HitroMessages.HuipropertyPropertiesEditionPart_RequiredLabel));
        required.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Properties.required,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new Boolean(required.getSelection())));
            }

        });
        GridData requiredData = new GridData(GridData.FILL_HORIZONTAL);
        requiredData.horizontalSpan = 2;
        required.setLayoutData(requiredData);
        EditingUtils.setID(required, HitroViewsRepository.Huiproperty.Properties.required);
        EditingUtils.setEEFtype(required, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.required,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createRequiredCheckbox

        // End of user code
        return parent;
    }

    protected Composite createShowInObjectBrowserCheckbox(Composite parent) {
        showInObjectBrowser = new Button(parent, SWT.CHECK);
        showInObjectBrowser.setText(
                getDescription(HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser,
                        HitroMessages.HuipropertyPropertiesEditionPart_ShowInObjectBrowserLabel));
        showInObjectBrowser.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new Boolean(showInObjectBrowser.getSelection())));
            }

        });
        GridData showInObjectBrowserData = new GridData(GridData.FILL_HORIZONTAL);
        showInObjectBrowserData.horizontalSpan = 2;
        showInObjectBrowser.setLayoutData(showInObjectBrowserData);
        EditingUtils.setID(showInObjectBrowser,
                HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser);
        EditingUtils.setEEFtype(showInObjectBrowser, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.showInObjectBrowser,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createShowInObjectBrowserCheckbox

        // End of user code
        return parent;
    }

    protected Composite createTagsText(Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Properties.tags,
                HitroMessages.HuipropertyPropertiesEditionPart_TagsLabel);
        tags = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData tagsData = new GridData(GridData.FILL_HORIZONTAL);
        tags.setLayoutData(tagsData);
        tags.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Properties.tags,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    tags.getText()));
            }

        });
        tags.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Properties.tags,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                tags.getText()));
                }
            }

        });
        EditingUtils.setID(tags, HitroViewsRepository.Huiproperty.Properties.tags);
        EditingUtils.setEEFtype(tags, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.tags,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createTagsText

        // End of user code
        return parent;
    }

    protected Composite createTextrowsText(Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Properties.textrows,
                HitroMessages.HuipropertyPropertiesEditionPart_TextrowsLabel);
        textrows = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData textrowsData = new GridData(GridData.FILL_HORIZONTAL);
        textrows.setLayoutData(textrowsData);
        textrows.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Properties.textrows,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    textrows.getText()));
            }

        });
        textrows.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Properties.textrows,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                textrows.getText()));
                }
            }

        });
        EditingUtils.setID(textrows, HitroViewsRepository.Huiproperty.Properties.textrows);
        EditingUtils.setEEFtype(textrows, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.textrows,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createTextrowsText

        // End of user code
        return parent;
    }

    protected Composite createTooltipText(Composite parent) {
        createDescription(parent, HitroViewsRepository.Huiproperty.Properties.tooltip,
                HitroMessages.HuipropertyPropertiesEditionPart_TooltipLabel);
        tooltip = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData tooltipData = new GridData(GridData.FILL_HORIZONTAL);
        tooltip.setLayoutData(tooltipData);
        tooltip.addFocusListener(new FocusAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Properties.tooltip,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    tooltip.getText()));
            }

        });
        tooltip.addKeyListener(new KeyAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Properties.tooltip,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                tooltip.getText()));
                }
            }

        });
        EditingUtils.setID(tooltip, HitroViewsRepository.Huiproperty.Properties.tooltip);
        EditingUtils.setEEFtype(tooltip, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.tooltip,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createTooltipText

        // End of user code
        return parent;
    }

    protected Composite createVisibleCheckbox(Composite parent) {
        visible = new Button(parent, SWT.CHECK);
        visible.setText(getDescription(HitroViewsRepository.Huiproperty.Properties.visible,
                HitroMessages.HuipropertyPropertiesEditionPart_VisibleLabel));
        visible.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             *
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             * 
             */
            public void widgetSelected(SelectionEvent e) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(CustomHuipropertyPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.Huiproperty.Properties.visible,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new Boolean(visible.getSelection())));
            }

        });
        GridData visibleData = new GridData(GridData.FILL_HORIZONTAL);
        visibleData.horizontalSpan = 2;
        visible.setLayoutData(visibleData);
        EditingUtils.setID(visible, HitroViewsRepository.Huiproperty.Properties.visible);
        EditingUtils.setEEFtype(visible, "eef::Checkbox"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Huiproperty.Properties.visible,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createVisibleCheckbox

        // End of user code
        return parent;
    }

    /**
     * 
     */
    protected Composite createChildsGroup(Composite parent) {
        Group childsGroup = new Group(parent, SWT.NONE);
        childsGroup.setText(HitroMessages.HuipropertyPropertiesEditionPart_ChildsGroupLabel);
        GridData childsGroupData = new GridData(GridData.FILL_HORIZONTAL);
        childsGroupData.horizontalSpan = 3;
        childsGroup.setLayoutData(childsGroupData);
        GridLayout childsGroupLayout = new GridLayout();
        childsGroupLayout.numColumns = 3;
        childsGroup.setLayout(childsGroupLayout);
        return childsGroup;
    }

    /**
     * @param container
     * 
     */
    protected Composite createDependsAdvancedTableComposition(Composite parent) {
        this.depends = new ReferencesTable(
                getDescription(HitroViewsRepository.Huiproperty.Childs.depends,
                        HitroMessages.HuipropertyPropertiesEditionPart_DependsLabel),
                new ReferencesTableListener() {
                    public void handleAdd() {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.depends,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null,
                                null));
                        depends.refresh();
                    }

                    public void handleEdit(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.depends,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null,
                                element));
                        depends.refresh();
                    }

                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.depends,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element,
                                newIndex));
                        depends.refresh();
                    }

                    public void handleRemove(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.depends,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null,
                                element));
                        depends.refresh();
                    }

                    public void navigateTo(EObject element) {
                    }
                });
        for (ViewerFilter filter : this.dependsFilters) {
            this.depends.addFilter(filter);
        }
        this.depends.setHelpText(propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Childs.depends, HitroViewsRepository.SWT_KIND));
        this.depends.createControls(parent);
        this.depends.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartImpl.this,
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
        // Start of user code for createDependsAdvancedTableComposition

        // End of user code
        return parent;
    }

    /**
     * @param container
     * 
     */
    protected Composite createValidationRuleAdvancedTableComposition(Composite parent) {
        this.validationRule = new ReferencesTable(
                getDescription(HitroViewsRepository.Huiproperty.Childs.validationRule,
                        HitroMessages.HuipropertyPropertiesEditionPart_ValidationRuleLabel),
                new ReferencesTableListener() {
                    public void handleAdd() {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.validationRule,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null,
                                null));
                        validationRule.refresh();
                    }

                    public void handleEdit(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.validationRule,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null,
                                element));
                        validationRule.refresh();
                    }

                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.validationRule,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element,
                                newIndex));
                        validationRule.refresh();
                    }

                    public void handleRemove(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.validationRule,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null,
                                element));
                        validationRule.refresh();
                    }

                    public void navigateTo(EObject element) {
                    }
                });
        for (ViewerFilter filter : this.validationRuleFilters) {
            this.validationRule.addFilter(filter);
        }
        this.validationRule.setHelpText(propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Childs.validationRule,
                HitroViewsRepository.SWT_KIND));
        this.validationRule.createControls(parent);
        this.validationRule.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartImpl.this,
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
        // Start of user code for createValidationRuleAdvancedTableComposition

        // End of user code
        return parent;
    }

    /**
     * @param container
     * 
     */
    protected Composite createOptionAdvancedTableComposition(Composite parent) {
        this.option = new ReferencesTable(
                getDescription(HitroViewsRepository.Huiproperty.Childs.option,
                        HitroMessages.HuipropertyPropertiesEditionPart_OptionLabel),
                new ReferencesTableListener() {
                    public void handleAdd() {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.option,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null,
                                null));
                        option.refresh();
                    }

                    public void handleEdit(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.option,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null,
                                element));
                        option.refresh();
                    }

                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.option,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element,
                                newIndex));
                        option.refresh();
                    }

                    public void handleRemove(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                CustomHuipropertyPropertiesEditionPartImpl.this,
                                HitroViewsRepository.Huiproperty.Childs.option,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null,
                                element));
                        option.refresh();
                    }

                    public void navigateTo(EObject element) {
                    }
                });
        for (ViewerFilter filter : this.optionFilters) {
            this.option.addFilter(filter);
        }
        this.option.setHelpText(propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huiproperty.Childs.option, HitroViewsRepository.SWT_KIND));
        this.option.createControls(parent);
        this.option.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            CustomHuipropertyPropertiesEditionPartImpl.this,
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
        // Start of user code for createOptionAdvancedTableComposition

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
        Enumerator selection = (Enumerator) ((StructuredSelection) inputtype.getSelection())
                .getFirstElement();
        return selection;
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
