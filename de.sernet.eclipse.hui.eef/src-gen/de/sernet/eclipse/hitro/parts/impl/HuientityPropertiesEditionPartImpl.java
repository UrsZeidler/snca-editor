/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.parts.impl;

// Start of user code for imports
import de.sernet.eclipse.hitro.HitroPackage;

import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.HuientityPropertiesEditionPart;

import de.sernet.eclipse.hitro.providers.HitroMessages;

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
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.jface.window.Window;

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
public class HuientityPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, HuientityPropertiesEditionPart {

	protected Text group;
	protected Button editGroup;
	protected EList groupList;
	protected Text id;
	protected Text name;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public HuientityPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence huientityStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = huientityStep.addStep(HitroViewsRepository.Huientity.Properties.class);
		propertiesStep.addStep(HitroViewsRepository.Huientity.Properties.group);
		propertiesStep.addStep(HitroViewsRepository.Huientity.Properties.id);
		propertiesStep.addStep(HitroViewsRepository.Huientity.Properties.name);
		
		
		composer = new PartComposer(huientityStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == HitroViewsRepository.Huientity.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == HitroViewsRepository.Huientity.Properties.group) {
					return createGroupMultiValuedEditor(parent);
				}
				if (key == HitroViewsRepository.Huientity.Properties.id) {
					return createIdText(parent);
				}
				if (key == HitroViewsRepository.Huientity.Properties.name) {
					return createNameText(parent);
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
		propertiesGroup.setText(HitroMessages.HuientityPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	protected Composite createGroupMultiValuedEditor(Composite parent) {
		group = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData groupData = new GridData(GridData.FILL_HORIZONTAL);
		groupData.horizontalSpan = 2;
		group.setLayoutData(groupData);
		EditingUtils.setID(group, HitroViewsRepository.Huientity.Properties.group);
		EditingUtils.setEEFtype(group, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editGroup = new Button(parent, SWT.NONE);
		editGroup.setText(getDescription(HitroViewsRepository.Huientity.Properties.group, HitroMessages.HuientityPropertiesEditionPart_GroupLabel));
		GridData editGroupData = new GridData();
		editGroup.setLayoutData(editGroupData);
		editGroup.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						group.getShell(), "Huientity", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						groupList, HitroPackage.eINSTANCE.getHuientity_Group().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					groupList = dialog.getResult();
					if (groupList == null) {
						groupList = new BasicEList();
					}
					group.setText(groupList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuientityPropertiesEditionPartImpl.this, HitroViewsRepository.Huientity.Properties.group, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(groupList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editGroup, HitroViewsRepository.Huientity.Properties.group);
		EditingUtils.setEEFtype(editGroup, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createGroupMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createIdText(Composite parent) {
		createDescription(parent, HitroViewsRepository.Huientity.Properties.id, HitroMessages.HuientityPropertiesEditionPart_IdLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuientityPropertiesEditionPartImpl.this, HitroViewsRepository.Huientity.Properties.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuientityPropertiesEditionPartImpl.this, HitroViewsRepository.Huientity.Properties.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
				}
			}

		});
		EditingUtils.setID(id, HitroViewsRepository.Huientity.Properties.id);
		EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huientity.Properties.id, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIdText

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, HitroViewsRepository.Huientity.Properties.name, HitroMessages.HuientityPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuientityPropertiesEditionPartImpl.this, HitroViewsRepository.Huientity.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuientityPropertiesEditionPartImpl.this, HitroViewsRepository.Huientity.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, HitroViewsRepository.Huientity.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huientity.Properties.name, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

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
	 * @see de.sernet.eclipse.hitro.parts.HuientityPropertiesEditionPart#getGroup()
	 * 
	 */
	public EList getGroup() {
		return groupList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuientityPropertiesEditionPart#setGroup(EList newValue)
	 * 
	 */
	public void setGroup(EList newValue) {
		groupList = newValue;
		if (newValue != null) {
			group.setText(groupList.toString());
		} else {
			group.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huientity.Properties.group);
		if (eefElementEditorReadOnlyState && group.isEnabled()) {
			group.setEnabled(false);
			group.setToolTipText(HitroMessages.Huientity_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !group.isEnabled()) {
			group.setEnabled(true);
		}	
		
	}

	public void addToGroup(Object newValue) {
		groupList.add(newValue);
		if (newValue != null) {
			group.setText(groupList.toString());
		} else {
			group.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToGroup(Object newValue) {
		groupList.remove(newValue);
		if (newValue != null) {
			group.setText(groupList.toString());
		} else {
			group.setText(""); //$NON-NLS-1$
		}
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
	 * @see de.sernet.eclipse.hitro.parts.HuientityPropertiesEditionPart#setId(String newValue)
	 * 
	 */
	public void setId(String newValue) {
		if (newValue != null) {
			id.setText(newValue);
		} else {
			id.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huientity.Properties.id);
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
	 * @see de.sernet.eclipse.hitro.parts.HuientityPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huientity.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(HitroMessages.Huientity_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}






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
