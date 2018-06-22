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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// Start of user code for imports
import de.sernet.eclipse.hitro.HitroPackage;
import de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart;
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.providers.HitroMessages;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class DocumentRootPropertiesEditionPartImpl extends CompositePropertiesEditionPart
        implements ISWTPropertiesEditionPart, DocumentRootPropertiesEditionPart {

    protected Text mixed;
    protected Button editMixed;
    protected EList mixedList;

    /**
     * Default constructor
     * 
     * @param editionComponent
     *            the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public DocumentRootPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
        CompositionSequence documentRootStep = new BindingCompositionSequence(
                propertiesEditionComponent);
        documentRootStep.addStep(HitroViewsRepository.DocumentRoot.Properties.class)
                .addStep(HitroViewsRepository.DocumentRoot.Properties.mixed);

        composer = new PartComposer(documentRootStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == HitroViewsRepository.DocumentRoot.Properties.class) {
                    return createPropertiesGroup(parent);
                }
                if (key == HitroViewsRepository.DocumentRoot.Properties.mixed) {
                    return createMixedMultiValuedEditor(parent);
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
                .setText(HitroMessages.DocumentRootPropertiesEditionPart_PropertiesGroupLabel);
        GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesGroupData.horizontalSpan = 3;
        propertiesGroup.setLayoutData(propertiesGroupData);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 3;
        propertiesGroup.setLayout(propertiesGroupLayout);
        return propertiesGroup;
    }

    protected Composite createMixedMultiValuedEditor(Composite parent) {
        mixed = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        GridData mixedData = new GridData(GridData.FILL_HORIZONTAL);
        mixedData.horizontalSpan = 2;
        mixed.setLayoutData(mixedData);
        EditingUtils.setID(mixed, HitroViewsRepository.DocumentRoot.Properties.mixed);
        EditingUtils.setEEFtype(mixed, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
        editMixed = new Button(parent, SWT.NONE);
        editMixed.setText(getDescription(HitroViewsRepository.DocumentRoot.Properties.mixed,
                HitroMessages.DocumentRootPropertiesEditionPart_MixedLabel));
        GridData editMixedData = new GridData();
        editMixed.setLayoutData(editMixedData);
        editMixed.addSelectionListener(new SelectionAdapter() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            public void widgetSelected(SelectionEvent e) {
                EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(mixed.getShell(),
                        "DocumentRoot", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
                        mixedList, HitroPackage.eINSTANCE.getDocumentRoot_Mixed().getEType(), null,
                        false, true, null, null);
                if (dialog.open() == Window.OK) {
                    mixedList = dialog.getResult();
                    if (mixedList == null) {
                        mixedList = new BasicEList();
                    }
                    mixed.setText(mixedList.toString());
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(DocumentRootPropertiesEditionPartImpl.this,
                                    HitroViewsRepository.DocumentRoot.Properties.mixed,
                                    PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null,
                                    new BasicEList(mixedList)));
                    setHasChanged(true);
                }
            }
        });
        EditingUtils.setID(editMixed, HitroViewsRepository.DocumentRoot.Properties.mixed);
        EditingUtils.setEEFtype(editMixed, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
        // Start of user code for createMixedMultiValuedEditor

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
     * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#getMixed()
     * 
     */
    public EList getMixed() {
        return mixedList;
    }

    /**
     * {@inheritDoc}
     * 
     * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#setMixed(EList
     *      newValue)
     * 
     */
    public void setMixed(EList newValue) {
        mixedList = newValue;
        if (newValue != null) {
            mixed.setText(mixedList.toString());
        } else {
            mixed.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(
                HitroViewsRepository.DocumentRoot.Properties.mixed);
        if (eefElementEditorReadOnlyState && mixed.isEnabled()) {
            mixed.setEnabled(false);
            mixed.setToolTipText(HitroMessages.DocumentRoot_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !mixed.isEnabled()) {
            mixed.setEnabled(true);
        }

    }

    public void addToMixed(Object newValue) {
        mixedList.add(newValue);
        if (newValue != null) {
            mixed.setText(mixedList.toString());
        } else {
            mixed.setText(""); //$NON-NLS-1$
        }
    }

    public void removeToMixed(Object newValue) {
        mixedList.remove(newValue);
        if (newValue != null) {
            mixed.setText(mixedList.toString());
        } else {
            mixed.setText(""); //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     * 
     */
    public String getTitle() {
        return HitroMessages.DocumentRoot_Part_Title;
    }

    // Start of user code additional methods

    // End of user code

}
