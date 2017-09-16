/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.parts.impl;

// Start of user code for imports
import de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart;
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;

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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 * 
 */
public class DependsPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, DependsPropertiesEditionPart {

	protected Button inverse;
	protected EObjectFlatComboViewer option;
	protected Text value;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DependsPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence dependsStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = dependsStep.addStep(HitroViewsRepository.Depends.Properties.class);
		propertiesStep.addStep(HitroViewsRepository.Depends.Properties.inverse);
		propertiesStep.addStep(HitroViewsRepository.Depends.Properties.option);
		propertiesStep.addStep(HitroViewsRepository.Depends.Properties.value);
		
		
		composer = new PartComposer(dependsStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == HitroViewsRepository.Depends.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == HitroViewsRepository.Depends.Properties.inverse) {
					return createInverseCheckbox(parent);
				}
				if (key == HitroViewsRepository.Depends.Properties.option) {
					return createOptionFlatComboViewer(parent);
				}
				if (key == HitroViewsRepository.Depends.Properties.value) {
					return createValueText(parent);
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
		propertiesGroup.setText(HitroMessages.DependsPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createInverseCheckbox(Composite parent) {
		inverse = new Button(parent, SWT.CHECK);
		inverse.setText(getDescription(HitroViewsRepository.Depends.Properties.inverse, HitroMessages.DependsPropertiesEditionPart_InverseLabel));
		inverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DependsPropertiesEditionPartImpl.this, HitroViewsRepository.Depends.Properties.inverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(inverse.getSelection())));
			}

		});
		GridData inverseData = new GridData(GridData.FILL_HORIZONTAL);
		inverseData.horizontalSpan = 2;
		inverse.setLayoutData(inverseData);
		EditingUtils.setID(inverse, HitroViewsRepository.Depends.Properties.inverse);
		EditingUtils.setEEFtype(inverse, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Depends.Properties.inverse, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInverseCheckbox

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createOptionFlatComboViewer(Composite parent) {
		createDescription(parent, HitroViewsRepository.Depends.Properties.option, HitroMessages.DependsPropertiesEditionPart_OptionLabel);
		option = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(HitroViewsRepository.Depends.Properties.option, HitroViewsRepository.SWT_KIND));
		option.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		option.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DependsPropertiesEditionPartImpl.this, HitroViewsRepository.Depends.Properties.option, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getOption()));
			}

		});
		GridData optionData = new GridData(GridData.FILL_HORIZONTAL);
		option.setLayoutData(optionData);
		option.setID(HitroViewsRepository.Depends.Properties.option);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Depends.Properties.option, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOptionFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createValueText(Composite parent) {
		createDescription(parent, HitroViewsRepository.Depends.Properties.value, HitroMessages.DependsPropertiesEditionPart_ValueLabel);
		value = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		value.setLayoutData(valueData);
		value.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DependsPropertiesEditionPartImpl.this, HitroViewsRepository.Depends.Properties.value, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, value.getText()));
			}

		});
		value.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DependsPropertiesEditionPartImpl.this, HitroViewsRepository.Depends.Properties.value, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, value.getText()));
				}
			}

		});
		EditingUtils.setID(value, HitroViewsRepository.Depends.Properties.value);
		EditingUtils.setEEFtype(value, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Depends.Properties.value, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart#getInverse()
	 * 
	 */
	public Boolean getInverse() {
		return Boolean.valueOf(inverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart#setInverse(Boolean newValue)
	 * 
	 */
	public void setInverse(Boolean newValue) {
		if (newValue != null) {
			inverse.setSelection(newValue.booleanValue());
		} else {
			inverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Depends.Properties.inverse);
		if (eefElementEditorReadOnlyState && inverse.isEnabled()) {
			inverse.setEnabled(false);
			inverse.setToolTipText(HitroMessages.Depends_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inverse.isEnabled()) {
			inverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart#getOption()
	 * 
	 */
	public EObject getOption() {
		if (option.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) option.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart#initOption(EObjectFlatComboSettings)
	 */
	public void initOption(EObjectFlatComboSettings settings) {
		option.setInput(settings);
		if (current != null) {
			option.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Depends.Properties.option);
		if (eefElementEditorReadOnlyState && option.isEnabled()) {
			option.setEnabled(false);
			option.setToolTipText(HitroMessages.Depends_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !option.isEnabled()) {
			option.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart#setOption(EObject newValue)
	 * 
	 */
	public void setOption(EObject newValue) {
		if (newValue != null) {
			option.setSelection(new StructuredSelection(newValue));
		} else {
			option.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Depends.Properties.option);
		if (eefElementEditorReadOnlyState && option.isEnabled()) {
			option.setEnabled(false);
			option.setToolTipText(HitroMessages.Depends_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !option.isEnabled()) {
			option.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart#setOptionButtonMode(ButtonsModeEnum newValue)
	 */
	public void setOptionButtonMode(ButtonsModeEnum newValue) {
		option.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart#addFilterOption(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOption(ViewerFilter filter) {
		option.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart#addBusinessFilterOption(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOption(ViewerFilter filter) {
		option.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart#getValue()
	 * 
	 */
	public String getValue() {
		return value.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DependsPropertiesEditionPart#setValue(String newValue)
	 * 
	 */
	public void setValue(String newValue) {
		if (newValue != null) {
			value.setText(newValue);
		} else {
			value.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Depends.Properties.value);
		if (eefElementEditorReadOnlyState && value.isEnabled()) {
			value.setEnabled(false);
			value.setToolTipText(HitroMessages.Depends_ReadOnly);
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
		return HitroMessages.Depends_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
