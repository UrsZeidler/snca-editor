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

// Start of user code for imports
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.ReferencePropertiesEditionPart;

import de.sernet.eclipse.hitro.providers.HitroMessages;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

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

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class ReferencePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ReferencePropertiesEditionPart {

	protected EObjectFlatComboViewer entitytype;
	protected Text linkType;



	/**
	 * For {@link ISection} use only.
	 */
	public ReferencePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ReferencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
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
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence referenceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = referenceStep.addStep(HitroViewsRepository.Reference.Properties.class);
		propertiesStep.addStep(HitroViewsRepository.Reference.Properties.entitytype);
		propertiesStep.addStep(HitroViewsRepository.Reference.Properties.linkType);
		
		
		composer = new PartComposer(referenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == HitroViewsRepository.Reference.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == HitroViewsRepository.Reference.Properties.entitytype) {
					return createEntitytypeFlatComboViewer(parent, widgetFactory);
				}
				if (key == HitroViewsRepository.Reference.Properties.linkType) {
					return createLinkTypeText(widgetFactory, parent);
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
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(HitroMessages.ReferencePropertiesEditionPart_PropertiesGroupLabel);
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
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createEntitytypeFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, HitroViewsRepository.Reference.Properties.entitytype, HitroMessages.ReferencePropertiesEditionPart_EntitytypeLabel);
		entitytype = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(HitroViewsRepository.Reference.Properties.entitytype, HitroViewsRepository.FORM_KIND));
		widgetFactory.adapt(entitytype);
		entitytype.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData entitytypeData = new GridData(GridData.FILL_HORIZONTAL);
		entitytype.setLayoutData(entitytypeData);
		entitytype.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencePropertiesEditionPartForm.this, HitroViewsRepository.Reference.Properties.entitytype, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEntitytype()));
			}

		});
		entitytype.setID(HitroViewsRepository.Reference.Properties.entitytype);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Reference.Properties.entitytype, HitroViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEntitytypeFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createLinkTypeText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, HitroViewsRepository.Reference.Properties.linkType, HitroMessages.ReferencePropertiesEditionPart_LinkTypeLabel);
		linkType = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		linkType.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData linkTypeData = new GridData(GridData.FILL_HORIZONTAL);
		linkType.setLayoutData(linkTypeData);
		linkType.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ReferencePropertiesEditionPartForm.this,
							HitroViewsRepository.Reference.Properties.linkType,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, linkType.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ReferencePropertiesEditionPartForm.this,
									HitroViewsRepository.Reference.Properties.linkType,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, linkType.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ReferencePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		linkType.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencePropertiesEditionPartForm.this, HitroViewsRepository.Reference.Properties.linkType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, linkType.getText()));
				}
			}
		});
		EditingUtils.setID(linkType, HitroViewsRepository.Reference.Properties.linkType);
		EditingUtils.setEEFtype(linkType, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Reference.Properties.linkType, HitroViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLinkTypeText

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
	 * @see de.sernet.eclipse.hitro.parts.ReferencePropertiesEditionPart#getEntitytype()
	 * 
	 */
	public EObject getEntitytype() {
		if (entitytype.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) entitytype.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.ReferencePropertiesEditionPart#initEntitytype(EObjectFlatComboSettings)
	 */
	public void initEntitytype(EObjectFlatComboSettings settings) {
		entitytype.setInput(settings);
		if (current != null) {
			entitytype.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Reference.Properties.entitytype);
		if (eefElementEditorReadOnlyState && entitytype.isEnabled()) {
			entitytype.setEnabled(false);
			entitytype.setToolTipText(HitroMessages.Reference_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !entitytype.isEnabled()) {
			entitytype.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.ReferencePropertiesEditionPart#setEntitytype(EObject newValue)
	 * 
	 */
	public void setEntitytype(EObject newValue) {
		if (newValue != null) {
			entitytype.setSelection(new StructuredSelection(newValue));
		} else {
			entitytype.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Reference.Properties.entitytype);
		if (eefElementEditorReadOnlyState && entitytype.isEnabled()) {
			entitytype.setEnabled(false);
			entitytype.setToolTipText(HitroMessages.Reference_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !entitytype.isEnabled()) {
			entitytype.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.ReferencePropertiesEditionPart#setEntitytypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEntitytypeButtonMode(ButtonsModeEnum newValue) {
		entitytype.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.ReferencePropertiesEditionPart#addFilterEntitytype(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEntitytype(ViewerFilter filter) {
		entitytype.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.ReferencePropertiesEditionPart#addBusinessFilterEntitytype(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEntitytype(ViewerFilter filter) {
		entitytype.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.ReferencePropertiesEditionPart#getLinkType()
	 * 
	 */
	public String getLinkType() {
		return linkType.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.ReferencePropertiesEditionPart#setLinkType(String newValue)
	 * 
	 */
	public void setLinkType(String newValue) {
		if (newValue != null) {
			linkType.setText(newValue);
		} else {
			linkType.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Reference.Properties.linkType);
		if (eefElementEditorReadOnlyState && linkType.isEnabled()) {
			linkType.setEnabled(false);
			linkType.setToolTipText(HitroMessages.Reference_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !linkType.isEnabled()) {
			linkType.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return HitroMessages.Reference_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
