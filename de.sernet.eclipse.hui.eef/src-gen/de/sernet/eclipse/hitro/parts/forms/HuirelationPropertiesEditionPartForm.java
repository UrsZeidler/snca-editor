/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.parts.forms;

// Start of user code for imports
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart;

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
 * 
 * 
 */
public class HuirelationPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, HuirelationPropertiesEditionPart {

	protected Text id;
	protected Text name;
	protected Text reversename;
	protected EObjectFlatComboViewer to;
	protected Text tooltip;



	/**
	 * For {@link ISection} use only.
	 */
	public HuirelationPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public HuirelationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence huirelationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = huirelationStep.addStep(HitroViewsRepository.Huirelation.Properties.class);
		propertiesStep.addStep(HitroViewsRepository.Huirelation.Properties.id);
		propertiesStep.addStep(HitroViewsRepository.Huirelation.Properties.name);
		propertiesStep.addStep(HitroViewsRepository.Huirelation.Properties.reversename);
		propertiesStep.addStep(HitroViewsRepository.Huirelation.Properties.to);
		propertiesStep.addStep(HitroViewsRepository.Huirelation.Properties.tooltip);
		
		
		composer = new PartComposer(huirelationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == HitroViewsRepository.Huirelation.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == HitroViewsRepository.Huirelation.Properties.id) {
					return createIdText(widgetFactory, parent);
				}
				if (key == HitroViewsRepository.Huirelation.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == HitroViewsRepository.Huirelation.Properties.reversename) {
					return createReversenameText(widgetFactory, parent);
				}
				if (key == HitroViewsRepository.Huirelation.Properties.to) {
					return createToFlatComboViewer(parent, widgetFactory);
				}
				if (key == HitroViewsRepository.Huirelation.Properties.tooltip) {
					return createTooltipText(widgetFactory, parent);
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
		propertiesSection.setText(HitroMessages.HuirelationPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, HitroViewsRepository.Huirelation.Properties.id, HitroMessages.HuirelationPropertiesEditionPart_IdLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							HuirelationPropertiesEditionPartForm.this,
							HitroViewsRepository.Huirelation.Properties.id,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									HuirelationPropertiesEditionPartForm.this,
									HitroViewsRepository.Huirelation.Properties.id,
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
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									HuirelationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartForm.this, HitroViewsRepository.Huirelation.Properties.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
				}
			}
		});
		EditingUtils.setID(id, HitroViewsRepository.Huirelation.Properties.id);
		EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huirelation.Properties.id, HitroViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createIdText

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, HitroViewsRepository.Huirelation.Properties.name, HitroMessages.HuirelationPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							HuirelationPropertiesEditionPartForm.this,
							HitroViewsRepository.Huirelation.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									HuirelationPropertiesEditionPartForm.this,
									HitroViewsRepository.Huirelation.Properties.name,
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
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									HuirelationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartForm.this, HitroViewsRepository.Huirelation.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, HitroViewsRepository.Huirelation.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huirelation.Properties.name, HitroViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createReversenameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, HitroViewsRepository.Huirelation.Properties.reversename, HitroMessages.HuirelationPropertiesEditionPart_ReversenameLabel);
		reversename = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		reversename.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData reversenameData = new GridData(GridData.FILL_HORIZONTAL);
		reversename.setLayoutData(reversenameData);
		reversename.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							HuirelationPropertiesEditionPartForm.this,
							HitroViewsRepository.Huirelation.Properties.reversename,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, reversename.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									HuirelationPropertiesEditionPartForm.this,
									HitroViewsRepository.Huirelation.Properties.reversename,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, reversename.getText()));
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
									HuirelationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		reversename.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartForm.this, HitroViewsRepository.Huirelation.Properties.reversename, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, reversename.getText()));
				}
			}
		});
		EditingUtils.setID(reversename, HitroViewsRepository.Huirelation.Properties.reversename);
		EditingUtils.setEEFtype(reversename, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huirelation.Properties.reversename, HitroViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReversenameText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createToFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, HitroViewsRepository.Huirelation.Properties.to, HitroMessages.HuirelationPropertiesEditionPart_ToLabel);
		to = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(HitroViewsRepository.Huirelation.Properties.to, HitroViewsRepository.FORM_KIND));
		widgetFactory.adapt(to);
		to.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData toData = new GridData(GridData.FILL_HORIZONTAL);
		to.setLayoutData(toData);
		to.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartForm.this, HitroViewsRepository.Huirelation.Properties.to, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTo()));
			}

		});
		to.setID(HitroViewsRepository.Huirelation.Properties.to);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huirelation.Properties.to, HitroViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createToFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createTooltipText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, HitroViewsRepository.Huirelation.Properties.tooltip, HitroMessages.HuirelationPropertiesEditionPart_TooltipLabel);
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
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							HuirelationPropertiesEditionPartForm.this,
							HitroViewsRepository.Huirelation.Properties.tooltip,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, tooltip.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									HuirelationPropertiesEditionPartForm.this,
									HitroViewsRepository.Huirelation.Properties.tooltip,
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
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									HuirelationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		tooltip.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartForm.this, HitroViewsRepository.Huirelation.Properties.tooltip, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, tooltip.getText()));
				}
			}
		});
		EditingUtils.setID(tooltip, HitroViewsRepository.Huirelation.Properties.tooltip);
		EditingUtils.setEEFtype(tooltip, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huirelation.Properties.tooltip, HitroViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTooltipText

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
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#getId()
	 * 
	 */
	public String getId() {
		return id.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#setId(String newValue)
	 * 
	 */
	public void setId(String newValue) {
		if (newValue != null) {
			id.setText(newValue);
		} else {
			id.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huirelation.Properties.id);
		if (eefElementEditorReadOnlyState && id.isEnabled()) {
			id.setEnabled(false);
			id.setToolTipText(HitroMessages.Huirelation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !id.isEnabled()) {
			id.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huirelation.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(HitroMessages.Huirelation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#getReversename()
	 * 
	 */
	public String getReversename() {
		return reversename.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#setReversename(String newValue)
	 * 
	 */
	public void setReversename(String newValue) {
		if (newValue != null) {
			reversename.setText(newValue);
		} else {
			reversename.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huirelation.Properties.reversename);
		if (eefElementEditorReadOnlyState && reversename.isEnabled()) {
			reversename.setEnabled(false);
			reversename.setToolTipText(HitroMessages.Huirelation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reversename.isEnabled()) {
			reversename.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#getTo()
	 * 
	 */
	public EObject getTo() {
		if (to.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) to.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#initTo(EObjectFlatComboSettings)
	 */
	public void initTo(EObjectFlatComboSettings settings) {
		to.setInput(settings);
		if (current != null) {
			to.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huirelation.Properties.to);
		if (eefElementEditorReadOnlyState && to.isEnabled()) {
			to.setEnabled(false);
			to.setToolTipText(HitroMessages.Huirelation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !to.isEnabled()) {
			to.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#setTo(EObject newValue)
	 * 
	 */
	public void setTo(EObject newValue) {
		if (newValue != null) {
			to.setSelection(new StructuredSelection(newValue));
		} else {
			to.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huirelation.Properties.to);
		if (eefElementEditorReadOnlyState && to.isEnabled()) {
			to.setEnabled(false);
			to.setToolTipText(HitroMessages.Huirelation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !to.isEnabled()) {
			to.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#setToButtonMode(ButtonsModeEnum newValue)
	 */
	public void setToButtonMode(ButtonsModeEnum newValue) {
		to.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#addFilterTo(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTo(ViewerFilter filter) {
		to.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#addBusinessFilterTo(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTo(ViewerFilter filter) {
		to.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#getTooltip()
	 * 
	 */
	public String getTooltip() {
		return tooltip.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart#setTooltip(String newValue)
	 * 
	 */
	public void setTooltip(String newValue) {
		if (newValue != null) {
			tooltip.setText(newValue);
		} else {
			tooltip.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huirelation.Properties.tooltip);
		if (eefElementEditorReadOnlyState && tooltip.isEnabled()) {
			tooltip.setEnabled(false);
			tooltip.setToolTipText(HitroMessages.Huirelation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !tooltip.isEnabled()) {
			tooltip.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return HitroMessages.Huirelation_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
