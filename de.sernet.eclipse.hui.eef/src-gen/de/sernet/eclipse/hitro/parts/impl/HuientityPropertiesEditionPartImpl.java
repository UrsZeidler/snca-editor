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
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.HuientityPropertiesEditionPart;
import de.sernet.eclipse.hitro.providers.HitroMessages;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class HuientityPropertiesEditionPartImpl extends CompositePropertiesEditionPart
        implements ISWTPropertiesEditionPart, HuientityPropertiesEditionPart {

    protected Text id;
    protected Text name;
    // Start of user code for TestName widgets declarations

    // End of user code

    /**
     * Default constructor
     * 
     * @param editionComponent
     *            the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public HuientityPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
        CompositionSequence huientityStep = new BindingCompositionSequence(
                propertiesEditionComponent);
        CompositionStep baseStep = huientityStep.addStep(HitroViewsRepository.Huientity.Base.class);
        baseStep.addStep(HitroViewsRepository.Huientity.Base.id);
        baseStep.addStep(HitroViewsRepository.Huientity.Base.name);

        huientityStep.addStep(HitroViewsRepository.Huientity.Test.class)
                .addStep(HitroViewsRepository.Huientity.Test.testName);

        composer = new PartComposer(huientityStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == HitroViewsRepository.Huientity.Base.class) {
                    return createBaseGroup(parent);
                }
                if (key == HitroViewsRepository.Huientity.Base.id) {
                    return createIdText(parent);
                }
                if (key == HitroViewsRepository.Huientity.Base.name) {
                    return createNameText(parent);
                }
                if (key == HitroViewsRepository.Huientity.Test.class) {
                    return createTestGroup(parent);
                }
                // Start of user code for TestName addToPart creation

                // End of user code
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
        baseGroup.setText(HitroMessages.HuientityPropertiesEditionPart_BaseGroupLabel);
        GridData baseGroupData = new GridData(GridData.FILL_HORIZONTAL);
        baseGroupData.horizontalSpan = 3;
        baseGroup.setLayoutData(baseGroupData);
        GridLayout baseGroupLayout = new GridLayout();
        baseGroupLayout.numColumns = 3;
        baseGroup.setLayout(baseGroupLayout);
        return baseGroup;
    }

    protected Composite createIdText(Composite parent) {
        createDescription(parent, HitroViewsRepository.Huientity.Base.id,
                HitroMessages.HuientityPropertiesEditionPart_IdLabel);
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
                            HuientityPropertiesEditionPartImpl.this,
                            HitroViewsRepository.Huientity.Base.id, PropertiesEditionEvent.COMMIT,
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
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(HuientityPropertiesEditionPartImpl.this,
                                        HitroViewsRepository.Huientity.Base.id,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                        null, id.getText()));
                }
            }

        });
        EditingUtils.setID(id, HitroViewsRepository.Huientity.Base.id);
        EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huientity.Base.id, HitroViewsRepository.SWT_KIND), null); // $NON-NLS-1$
        // Start of user code for createIdText

        // End of user code
        return parent;
    }

    protected Composite createNameText(Composite parent) {
        createDescription(parent, HitroViewsRepository.Huientity.Base.name,
                HitroMessages.HuientityPropertiesEditionPart_NameLabel);
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
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            HuientityPropertiesEditionPartImpl.this,
                            HitroViewsRepository.Huientity.Base.name, PropertiesEditionEvent.COMMIT,
                            PropertiesEditionEvent.SET, null, name.getText()));
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
                        propertiesEditionComponent.firePropertiesChanged(
                                new PropertiesEditionEvent(HuientityPropertiesEditionPartImpl.this,
                                        HitroViewsRepository.Huientity.Base.name,
                                        PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET,
                                        null, name.getText()));
                }
            }

        });
        EditingUtils.setID(name, HitroViewsRepository.Huientity.Base.name);
        EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
        SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(
                HitroViewsRepository.Huientity.Base.name, HitroViewsRepository.SWT_KIND), null); // $NON-NLS-1$
        // Start of user code for createNameText

        // End of user code
        return parent;
    }

    /**
     * 
     */
    protected Composite createTestGroup(Composite parent) {
        Group testGroup = new Group(parent, SWT.NONE);
        testGroup.setText(HitroMessages.HuientityPropertiesEditionPart_TestGroupLabel);
        GridData testGroupData = new GridData(GridData.FILL_HORIZONTAL);
        testGroupData.horizontalSpan = 3;
        testGroup.setLayoutData(testGroupData);
        GridLayout testGroupLayout = new GridLayout();
        testGroupLayout.numColumns = 3;
        testGroup.setLayout(testGroupLayout);
        return testGroup;
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
     * @see de.sernet.eclipse.hitro.parts.HuientityPropertiesEditionPart#getId()
     * 
     */
    public String getId() {
        return id.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuientityPropertiesEditionPart#setId(String
     *      newValue)
     * 
     */
    public void setId(String newValue) {
        if (newValue != null) {
            id.setText(newValue);
        } else {
            id.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huientity.Base.id);
        if (eefElementEditorReadOnlyState && id.isEnabled()) {
            id.setEnabled(false);
            id.setToolTipText(HitroMessages.Huientity_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !id.isEnabled()) {
            id.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuientityPropertiesEditionPart#getName()
     * 
     */
    public String getName() {
        return name.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.HuientityPropertiesEditionPart#setName(String
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
                HitroViewsRepository.Huientity.Base.name);
        if (eefElementEditorReadOnlyState && name.isEnabled()) {
            name.setEnabled(false);
            name.setToolTipText(HitroMessages.Huientity_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
            name.setEnabled(true);
        }

    }

    // Start of user code for TestName specific getters and setters
    // implementation

    // End of user code

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     * 
     */
    public String getTitle() {
        return HitroMessages.Huientity_Part_Title;
    }

    // Start of user code additional methods

    // End of user code

}
