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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;

// Start of user code for imports
import de.sernet.eclipse.hitro.parts.DefaultRulePropertiesEditionPart;
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.providers.HitroMessages;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class DefaultRulePropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, DefaultRulePropertiesEditionPart {

    protected ReferencesTable param;
    protected List<ViewerFilter> paramBusinessFilters = new ArrayList<ViewerFilter>();
    protected List<ViewerFilter> paramFilters = new ArrayList<ViewerFilter>();
    protected Text class_;

    /**
     * For {@link ISection} use only.
     */
    public DefaultRulePropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent
     *            the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public DefaultRulePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
        CompositionSequence defaultRuleStep = new BindingCompositionSequence(
                propertiesEditionComponent);
        CompositionStep propertiesStep = defaultRuleStep
                .addStep(HitroViewsRepository.DefaultRule.Properties.class);
        propertiesStep.addStep(HitroViewsRepository.DefaultRule.Properties.param);
        propertiesStep.addStep(HitroViewsRepository.DefaultRule.Properties.class_);

        composer = new PartComposer(defaultRuleStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == HitroViewsRepository.DefaultRule.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.DefaultRule.Properties.param) {
                    return createParamTableComposition(widgetFactory, parent);
                }
                if (key == HitroViewsRepository.DefaultRule.Properties.class_) {
                    return createClass_Text(widgetFactory, parent);
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
        propertiesSection
                .setText(HitroMessages.DefaultRulePropertiesEditionPart_PropertiesGroupLabel);
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

    /**
     * @param container
     * 
     */
    protected Composite createParamTableComposition(FormToolkit widgetFactory, Composite parent) {
        this.param = new ReferencesTable(
                getDescription(HitroViewsRepository.DefaultRule.Properties.param,
                        HitroMessages.DefaultRulePropertiesEditionPart_ParamLabel),
                new ReferencesTableListener() {
                    public void handleAdd() {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                DefaultRulePropertiesEditionPartForm.this,
                                HitroViewsRepository.DefaultRule.Properties.param,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null,
                                null));
                        param.refresh();
                    }

                    public void handleEdit(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                DefaultRulePropertiesEditionPartForm.this,
                                HitroViewsRepository.DefaultRule.Properties.param,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null,
                                element));
                        param.refresh();
                    }

                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                DefaultRulePropertiesEditionPartForm.this,
                                HitroViewsRepository.DefaultRule.Properties.param,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element,
                                newIndex));
                        param.refresh();
                    }

                    public void handleRemove(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                DefaultRulePropertiesEditionPartForm.this,
                                HitroViewsRepository.DefaultRule.Properties.param,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null,
                                element));
                        param.refresh();
                    }

                    public void navigateTo(EObject element) {
                    }
                });
        for (ViewerFilter filter : this.paramFilters) {
            this.param.addFilter(filter);
        }
        this.param.setHelpText(propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.DefaultRule.Properties.param, HitroViewsRepository.FORM_KIND));
        this.param.createControls(parent, widgetFactory);
        this.param.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            DefaultRulePropertiesEditionPartForm.this,
                            HitroViewsRepository.DefaultRule.Properties.param,
                            PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED,
                            null, e.item.getData()));
                }
            }

        });
        GridData paramData = new GridData(GridData.FILL_HORIZONTAL);
        paramData.horizontalSpan = 3;
        this.param.setLayoutData(paramData);
        this.param.setLowerBound(0);
        this.param.setUpperBound(-1);
        param.setID(HitroViewsRepository.DefaultRule.Properties.param);
        param.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
        // Start of user code for createParamTableComposition

        // End of user code
        return parent;
    }

    protected Composite createClass_Text(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, HitroViewsRepository.DefaultRule.Properties.class_,
                HitroMessages.DefaultRulePropertiesEditionPart_Class_Label);
        class_ = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        class_.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData class_Data = new GridData(GridData.FILL_HORIZONTAL);
        class_.setLayoutData(class_Data);
        class_.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(DefaultRulePropertiesEditionPartForm.this,
                                    HitroViewsRepository.DefaultRule.Properties.class_,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    class_.getText()));
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(DefaultRulePropertiesEditionPartForm.this,
                                    HitroViewsRepository.DefaultRule.Properties.class_,
                                    PropertiesEditionEvent.FOCUS_CHANGED,
                                    PropertiesEditionEvent.FOCUS_LOST, null, class_.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(DefaultRulePropertiesEditionPartForm.this,
                                    null, PropertiesEditionEvent.FOCUS_CHANGED,
                                    PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        class_.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                DefaultRulePropertiesEditionPartForm.this,
                                HitroViewsRepository.DefaultRule.Properties.class_,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                class_.getText()));
                }
            }
        });
        EditingUtils.setID(class_, HitroViewsRepository.DefaultRule.Properties.class_);
        EditingUtils.setEEFtype(class_, "eef::Text"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.DefaultRule.Properties.class_,
                        HitroViewsRepository.FORM_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createClass_Text

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
     * @see de.sernet.eclipse.hitro.parts.DefaultRulePropertiesEditionPart#initParam(EObject
     *      current, EReference containingFeature, EReference feature)
     */
    public void initParam(ReferencesTableSettings settings) {
        if (current.eResource() != null && current.eResource().getResourceSet() != null)
            this.resourceSet = current.eResource().getResourceSet();
        ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
        param.setContentProvider(contentProvider);
        param.setInput(settings);
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.DefaultRule.Properties.param);
        if (eefElementEditorReadOnlyState && param.isEnabled()) {
            param.setEnabled(false);
            param.setToolTipText(HitroMessages.DefaultRule_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !param.isEnabled()) {
            param.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.DefaultRulePropertiesEditionPart#updateParam()
     * 
     */
    public void updateParam() {
        param.refresh();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.DefaultRulePropertiesEditionPart#addFilterParam(ViewerFilter
     *      filter)
     * 
     */
    public void addFilterToParam(ViewerFilter filter) {
        paramFilters.add(filter);
        if (this.param != null) {
            this.param.addFilter(filter);
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.DefaultRulePropertiesEditionPart#addBusinessFilterParam(ViewerFilter
     *      filter)
     * 
     */
    public void addBusinessFilterToParam(ViewerFilter filter) {
        paramBusinessFilters.add(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.DefaultRulePropertiesEditionPart#isContainedInParamTable(EObject
     *      element)
     * 
     */
    public boolean isContainedInParamTable(EObject element) {
        return ((ReferencesTableSettings) param.getInput()).contains(element);
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.DefaultRulePropertiesEditionPart#getClass_()
     * 
     */
    public String getClass_() {
        return class_.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.DefaultRulePropertiesEditionPart#setClass_(String
     *      newValue)
     * 
     */
    public void setClass_(String newValue) {
        if (newValue != null) {
            class_.setText(newValue);
        } else {
            class_.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.DefaultRule.Properties.class_);
        if (eefElementEditorReadOnlyState && class_.isEnabled()) {
            class_.setEnabled(false);
            class_.setToolTipText(HitroMessages.DefaultRule_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !class_.isEnabled()) {
            class_.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     * 
     */
    public String getTitle() {
        return HitroMessages.DefaultRule_Part_Title;
    }

    // Start of user code additional methods

    // End of user code

}
