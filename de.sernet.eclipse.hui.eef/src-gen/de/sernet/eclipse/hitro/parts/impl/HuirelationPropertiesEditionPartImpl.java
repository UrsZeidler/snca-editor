/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.parts.impl;

// Start of user code for imports
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.HuirelationPropertiesEditionPart;

import de.sernet.eclipse.hitro.providers.HitroMessages;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 * 
 */
public class HuirelationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, HuirelationPropertiesEditionPart {

	protected Text id;
	protected Text name;
	protected Text reversename;
	protected EObjectFlatComboViewer to;
	protected Text tooltip;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public HuirelationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
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
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence huirelationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep baseStep = huirelationStep.addStep(HitroViewsRepository.Huirelation.Base.class);
		baseStep.addStep(HitroViewsRepository.Huirelation.Base.id);
		baseStep.addStep(HitroViewsRepository.Huirelation.Base.name);
		
		CompositionStep propertiesStep = huirelationStep.addStep(HitroViewsRepository.Huirelation.Properties.class);
		propertiesStep.addStep(HitroViewsRepository.Huirelation.Properties.reversename);
		propertiesStep.addStep(HitroViewsRepository.Huirelation.Properties.to);
		propertiesStep.addStep(HitroViewsRepository.Huirelation.Properties.tooltip);
		
		
		composer = new PartComposer(huirelationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == HitroViewsRepository.Huirelation.Base.class) {
					return createBaseGroup(parent);
				}
				if (key == HitroViewsRepository.Huirelation.Base.id) {
					return createIdText(parent);
				}
				if (key == HitroViewsRepository.Huirelation.Base.name) {
					return createNameText(parent);
				}
				if (key == HitroViewsRepository.Huirelation.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == HitroViewsRepository.Huirelation.Properties.reversename) {
					return createReversenameText(parent);
				}
				if (key == HitroViewsRepository.Huirelation.Properties.to) {
					return createToFlatComboViewer(parent);
				}
				if (key == HitroViewsRepository.Huirelation.Properties.tooltip) {
					return createTooltipText(parent);
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
		baseGroup.setText(HitroMessages.HuirelationPropertiesEditionPart_BaseGroupLabel);
		GridData baseGroupData = new GridData(GridData.FILL_HORIZONTAL);
		baseGroupData.horizontalSpan = 3;
		baseGroup.setLayoutData(baseGroupData);
		GridLayout baseGroupLayout = new GridLayout();
		baseGroupLayout.numColumns = 3;
		baseGroup.setLayout(baseGroupLayout);
		return baseGroup;
	}

	
	protected Composite createIdText(Composite parent) {
		createDescription(parent, HitroViewsRepository.Huirelation.Base.id, HitroMessages.HuirelationPropertiesEditionPart_IdLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartImpl.this, HitroViewsRepository.Huirelation.Base.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartImpl.this, HitroViewsRepository.Huirelation.Base.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
				}
			}

		});
		EditingUtils.setID(id, HitroViewsRepository.Huirelation.Base.id);
		EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huirelation.Base.id, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIdText

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, HitroViewsRepository.Huirelation.Base.name, HitroMessages.HuirelationPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartImpl.this, HitroViewsRepository.Huirelation.Base.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartImpl.this, HitroViewsRepository.Huirelation.Base.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, HitroViewsRepository.Huirelation.Base.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huirelation.Base.name, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(HitroMessages.HuirelationPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createReversenameText(Composite parent) {
		createDescription(parent, HitroViewsRepository.Huirelation.Properties.reversename, HitroMessages.HuirelationPropertiesEditionPart_ReversenameLabel);
		reversename = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData reversenameData = new GridData(GridData.FILL_HORIZONTAL);
		reversename.setLayoutData(reversenameData);
		reversename.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartImpl.this, HitroViewsRepository.Huirelation.Properties.reversename, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, reversename.getText()));
			}

		});
		reversename.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartImpl.this, HitroViewsRepository.Huirelation.Properties.reversename, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, reversename.getText()));
				}
			}

		});
		EditingUtils.setID(reversename, HitroViewsRepository.Huirelation.Properties.reversename);
		EditingUtils.setEEFtype(reversename, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huirelation.Properties.reversename, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createReversenameText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createToFlatComboViewer(Composite parent) {
		createDescription(parent, HitroViewsRepository.Huirelation.Properties.to, HitroMessages.HuirelationPropertiesEditionPart_ToLabel);
		to = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(HitroViewsRepository.Huirelation.Properties.to, HitroViewsRepository.SWT_KIND));
		to.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		to.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartImpl.this, HitroViewsRepository.Huirelation.Properties.to, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getTo()));
			}

		});
		GridData toData = new GridData(GridData.FILL_HORIZONTAL);
		to.setLayoutData(toData);
		to.setID(HitroViewsRepository.Huirelation.Properties.to);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huirelation.Properties.to, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createToFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createTooltipText(Composite parent) {
		createDescription(parent, HitroViewsRepository.Huirelation.Properties.tooltip, HitroMessages.HuirelationPropertiesEditionPart_TooltipLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartImpl.this, HitroViewsRepository.Huirelation.Properties.tooltip, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, tooltip.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuirelationPropertiesEditionPartImpl.this, HitroViewsRepository.Huirelation.Properties.tooltip, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, tooltip.getText()));
				}
			}

		});
		EditingUtils.setID(tooltip, HitroViewsRepository.Huirelation.Properties.tooltip);
		EditingUtils.setEEFtype(tooltip, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huirelation.Properties.tooltip, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huirelation.Base.id);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huirelation.Base.name);
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
