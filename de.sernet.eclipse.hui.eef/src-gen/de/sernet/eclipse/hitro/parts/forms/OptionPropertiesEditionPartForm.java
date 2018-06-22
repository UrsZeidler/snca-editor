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
package de.sernet.eclipse.hitro.parts.forms;

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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;

// Start of user code for imports
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.OptionPropertiesEditionPart;
import de.sernet.eclipse.hitro.providers.HitroMessages;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class OptionPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, OptionPropertiesEditionPart {

    protected Text id;
    protected Text name;
    protected Text value;

    /**
     * For {@link ISection} use only.
     */
    public OptionPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent
     *            the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public OptionPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
        CompositionSequence optionStep = new BindingCompositionSequence(propertiesEditionComponent);
        CompositionStep propertiesStep = optionStep
                .addStep(HitroViewsRepository.Option.Properties.class);
        propertiesStep.addStep(HitroViewsRepository.Option.Properties.id);
        propertiesStep.addStep(HitroViewsRepository.Option.Properties.name);
        propertiesStep.addStep(HitroViewsRepository.Option.Properties.value);

        composer = new PartComposer(optionStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == HitroViewsRepository.Option.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Option.Properties.id) {
                    return createIdText(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Option.Properties.name) {
                    return createNameText(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.Option.Properties.value) {
                    return createValueText(widgetFactory, parent);
                }
                return parent;
            }
        };
        composer.compose(view);
    }

    /**
     * 
     */
    protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
        Section propertiesSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        propertiesSection.setText(HitroMessages.OptionPropertiesEditionPart_PropertiesGroupLabel);
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

    protected Composite createIdText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, HitroViewsRepository.Option.Properties.id,
                HitroMessages.OptionPropertiesEditionPart_IdLabel);
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
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this,
                                    HitroViewsRepository.Option.Properties.id,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    id.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this,
                                    HitroViewsRepository.Option.Properties.id,
                                    PropertiesEditionEvent.FOCUS_CHANGED,
                                    PropertiesEditionEvent.FOCUS_LOST, null, id.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this, null,
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
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this,
                                        HitroViewsRepository.Option.Properties.id,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                        null, id.getText()));
                }
            }
        });
        EditingUtils.setID(id, HitroViewsRepository.Option.Properties.id);
        EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Option.Properties.id, HitroViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createIdText

        // End of user code
        return parent;
    }

    protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, HitroViewsRepository.Option.Properties.name,
                HitroMessages.OptionPropertiesEditionPart_NameLabel);
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
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this,
                                    HitroViewsRepository.Option.Properties.name,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    name.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this,
                                    HitroViewsRepository.Option.Properties.name,
                                    PropertiesEditionEvent.FOCUS_CHANGED,
                                    PropertiesEditionEvent.FOCUS_LOST, null, name.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this, null,
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
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this,
                                        HitroViewsRepository.Option.Properties.name,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                        null, name.getText()));
                }
            }
        });
        EditingUtils.setID(name, HitroViewsRepository.Option.Properties.name);
        EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Option.Properties.name, HitroViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createNameText

        // End of user code
        return parent;
    }

    protected Composite createValueText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, HitroViewsRepository.Option.Properties.value,
                HitroMessages.OptionPropertiesEditionPart_ValueLabel);
        value = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        value.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        value.setLayoutData(valueData);
        value.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this,
                                    HitroViewsRepository.Option.Properties.value,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    value.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this,
                                    HitroViewsRepository.Option.Properties.value,
                                    PropertiesEditionEvent.FOCUS_CHANGED,
                                    PropertiesEditionEvent.FOCUS_LOST, null, value.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this, null,
                                    PropertiesEditionEvent.FOCUS_CHANGED,
                                    PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        value.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(OptionPropertiesEditionPartForm.this,
                                        HitroViewsRepository.Option.Properties.value,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                        null, value.getText()));
                }
            }
        });
        EditingUtils.setID(value, HitroViewsRepository.Option.Properties.value);
        EditingUtils.setEEFtype(value, "eef::Text"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.Option.Properties.value,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createValueText

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
     * @see de.sernet.eclipse.hitro.parts.OptionPropertiesEditionPart#getId()
     * 
     */
    public String getId() {
        return id.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.OptionPropertiesEditionPart#setId(String
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
                HitroViewsRepository.Option.Properties.id);
        if (eefElementEditorReadOnlyState && id.isEnabled()) {
            id.setEnabled(false);
            id.setToolTipText(HitroMessages.Option_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !id.isEnabled()) {
            id.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.OptionPropertiesEditionPart#getName()
     * 
     */
    public String getName() {
        return name.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.OptionPropertiesEditionPart#setName(String
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
                HitroViewsRepository.Option.Properties.name);
        if (eefElementEditorReadOnlyState && name.isEnabled()) {
            name.setEnabled(false);
            name.setToolTipText(HitroMessages.Option_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
            name.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.OptionPropertiesEditionPart#getValue()
     * 
     */
    public String getValue() {
        return value.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.OptionPropertiesEditionPart#setValue(String
     *      newValue)
     * 
     */
    public void setValue(String newValue) {
        if (newValue != null) {
            value.setText(newValue);
        } else {
            value.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.Option.Properties.value);
        if (eefElementEditorReadOnlyState && value.isEnabled()) {
            value.setEnabled(false);
            value.setToolTipText(HitroMessages.Option_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !value.isEnabled()) {
            value.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     * 
     */
    public String getTitle() {
        return HitroMessages.Option_Part_Title;
    }

    // Start of user code additional methods

    // End of user code

}
