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
package de.sernet.eclipse.hitro.parts.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// Start of user code for imports
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.ValidationRulePropertiesEditionPart;
import de.sernet.eclipse.hitro.providers.HitroMessages;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class ValidationRulePropertiesEditionPartImpl extends CompositePropertiesEditionPart
        implements ISWTPropertiesEditionPart, ValidationRulePropertiesEditionPart {

    protected ReferencesTable param;
    protected List<ViewerFilter> paramBusinessFilters = new ArrayList<ViewerFilter>();
    protected List<ViewerFilter> paramFilters = new ArrayList<ViewerFilter>();
    protected Text class_;
    protected Text hint;

    /**
     * Default constructor
     * 
     * @param editionComponent
     *            the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public ValidationRulePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
        CompositionSequence validationRuleStep = new BindingCompositionSequence(
                propertiesEditionComponent);
        CompositionStep propertiesStep = validationRuleStep
                .addStep(HitroViewsRepository.ValidationRule.Properties.class);
        propertiesStep.addStep(HitroViewsRepository.ValidationRule.Properties.param);
        propertiesStep.addStep(HitroViewsRepository.ValidationRule.Properties.class_);
        propertiesStep.addStep(HitroViewsRepository.ValidationRule.Properties.hint);

        composer = new PartComposer(validationRuleStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == HitroViewsRepository.ValidationRule.Properties.class) {
                    return createPropertiesGroup(parent);
                }
                if (key == HitroViewsRepository.ValidationRule.Properties.param) {
                    return createParamAdvancedTableComposition(parent);
                }
                if (key == HitroViewsRepository.ValidationRule.Properties.class_) {
                    return createClass_Text(parent);
                }
                if (key == HitroViewsRepository.ValidationRule.Properties.hint) {
                    return createHintText(parent);
                }
                return parent;
            }
        };
        composer.compose(view);
    }

    /**
     * 
     */
    protected Composite createPropertiesGroup(Composite parent) {
        Group propertiesGroup = new Group(parent, SWT.NONE);
        propertiesGroup
                .setText(HitroMessages.ValidationRulePropertiesEditionPart_PropertiesGroupLabel);
        GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesGroupData.horizontalSpan = 3;
        propertiesGroup.setLayoutData(propertiesGroupData);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 3;
        propertiesGroup.setLayout(propertiesGroupLayout);
        return propertiesGroup;
    }

    /**
     * @param container
     * 
     */
    protected Composite createParamAdvancedTableComposition(Composite parent) {
        this.param = new ReferencesTable(
                getDescription(HitroViewsRepository.ValidationRule.Properties.param,
                        HitroMessages.ValidationRulePropertiesEditionPart_ParamLabel),
                new ReferencesTableListener() {
                    public void handleAdd() {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                ValidationRulePropertiesEditionPartImpl.this,
                                HitroViewsRepository.ValidationRule.Properties.param,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null,
                                null));
                        param.refresh();
                    }

                    public void handleEdit(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                ValidationRulePropertiesEditionPartImpl.this,
                                HitroViewsRepository.ValidationRule.Properties.param,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null,
                                element));
                        param.refresh();
                    }

                    public void handleMove(EObject element, int oldIndex, int newIndex) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                ValidationRulePropertiesEditionPartImpl.this,
                                HitroViewsRepository.ValidationRule.Properties.param,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element,
                                newIndex));
                        param.refresh();
                    }

                    public void handleRemove(EObject element) {
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                ValidationRulePropertiesEditionPartImpl.this,
                                HitroViewsRepository.ValidationRule.Properties.param,
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
                HitroViewsRepository.ValidationRule.Properties.param,
                HitroViewsRepository.SWT_KIND));
        this.param.createControls(parent);
        this.param.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                if (e.item != null && e.item.getData() instanceof EObject) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            ValidationRulePropertiesEditionPartImpl.this,
                            HitroViewsRepository.ValidationRule.Properties.param,
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
        param.setID(HitroViewsRepository.ValidationRule.Properties.param);
        param.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
        // Start of user code for createParamAdvancedTableComposition

        // End of user code
        return parent;
    }

    protected Composite createClass_Text(Composite parent) {
        createDescription(parent, HitroViewsRepository.ValidationRule.Properties.class_,
                HitroMessages.ValidationRulePropertiesEditionPart_Class_Label);
        class_ = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData class_Data = new GridData(GridData.FILL_HORIZONTAL);
        class_.setLayoutData(class_Data);
        class_.addFocusListener(new FocusAdapter() {

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
                            new PropertiesEditionEvent(ValidationRulePropertiesEditionPartImpl.this,
                                    HitroViewsRepository.ValidationRule.Properties.class_,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    class_.getText()));
            }

        });
        class_.addKeyListener(new KeyAdapter() {

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
                                ValidationRulePropertiesEditionPartImpl.this,
                                HitroViewsRepository.ValidationRule.Properties.class_,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                class_.getText()));
                }
            }

        });
        EditingUtils.setID(class_, HitroViewsRepository.ValidationRule.Properties.class_);
        EditingUtils.setEEFtype(class_, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.ValidationRule.Properties.class_,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createClass_Text

        // End of user code
        return parent;
    }

    protected Composite createHintText(Composite parent) {
        createDescription(parent, HitroViewsRepository.ValidationRule.Properties.hint,
                HitroMessages.ValidationRulePropertiesEditionPart_HintLabel);
        hint = SWTUtils.createScrollableText(parent, SWT.BORDER);
        GridData hintData = new GridData(GridData.FILL_HORIZONTAL);
        hint.setLayoutData(hintData);
        hint.addFocusListener(new FocusAdapter() {

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
                            new PropertiesEditionEvent(ValidationRulePropertiesEditionPartImpl.this,
                                    HitroViewsRepository.ValidationRule.Properties.hint,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    hint.getText()));
            }

        });
        hint.addKeyListener(new KeyAdapter() {

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
                                ValidationRulePropertiesEditionPartImpl.this,
                                HitroViewsRepository.ValidationRule.Properties.hint,
                                PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                hint.getText()));
                }
            }

        });
        EditingUtils.setID(hint, HitroViewsRepository.ValidationRule.Properties.hint);
        EditingUtils.setEEFtype(hint, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent,
                propertiesEditionComponent.getHelpContent(
                        HitroViewsRepository.ValidationRule.Properties.hint,
                        HitroViewsRepository.SWT_KIND),
                null); // $NON-NLS-1$
        // Start of user code for createHintText

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
     * @see de.sernet.eclipse.hitro.parts.ValidationRulePropertiesEditionPart#initParam(EObject
     *      current, EReference containingFeature, EReference feature)
     */
    public void initParam(ReferencesTableSettings settings) {
        if (current.eResource() != null && current.eResource().getResourceSet() != null)
            this.resourceSet = current.eResource().getResourceSet();
        ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
        param.setContentProvider(contentProvider);
        param.setInput(settings);
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.ValidationRule.Properties.param);
        if (eefElementEditorReadOnlyState && param.isEnabled()) {
            param.setEnabled(false);
            param.setToolTipText(HitroMessages.ValidationRule_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !param.isEnabled()) {
            param.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.ValidationRulePropertiesEditionPart#updateParam()
     * 
     */
    public void updateParam() {
        param.refresh();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.ValidationRulePropertiesEditionPart#addFilterParam(ViewerFilter
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
     * @see de.sernet.eclipse.hitro.parts.ValidationRulePropertiesEditionPart#addBusinessFilterParam(ViewerFilter
     *      filter)
     * 
     */
    public void addBusinessFilterToParam(ViewerFilter filter) {
        paramBusinessFilters.add(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.ValidationRulePropertiesEditionPart#isContainedInParamTable(EObject
     *      element)
     * 
     */
    public boolean isContainedInParamTable(EObject element) {
        return ((ReferencesTableSettings) param.getInput()).contains(element);
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.ValidationRulePropertiesEditionPart#getClass_()
     * 
     */
    public String getClass_() {
        return class_.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.ValidationRulePropertiesEditionPart#setClass_(String
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
                HitroViewsRepository.ValidationRule.Properties.class_);
        if (eefElementEditorReadOnlyState && class_.isEnabled()) {
            class_.setEnabled(false);
            class_.setToolTipText(HitroMessages.ValidationRule_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !class_.isEnabled()) {
            class_.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.ValidationRulePropertiesEditionPart#getHint()
     * 
     */
    public String getHint() {
        return hint.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.ValidationRulePropertiesEditionPart#setHint(String
     *      newValue)
     * 
     */
    public void setHint(String newValue) {
        if (newValue != null) {
            hint.setText(newValue);
        } else {
            hint.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.ValidationRule.Properties.hint);
        if (eefElementEditorReadOnlyState && hint.isEnabled()) {
            hint.setEnabled(false);
            hint.setToolTipText(HitroMessages.ValidationRule_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !hint.isEnabled()) {
            hint.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     * 
     */
    public String getTitle() {
        return HitroMessages.ValidationRule_Part_Title;
    }

    // Start of user code additional methods

    // End of user code

}
