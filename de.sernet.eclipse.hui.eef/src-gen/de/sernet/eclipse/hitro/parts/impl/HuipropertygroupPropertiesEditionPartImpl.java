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

// Start of user code for imports
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;
import de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart;

import de.sernet.eclipse.hitro.providers.HitroMessages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.IStructuredSelection;
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

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class HuipropertygroupPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, HuipropertygroupPropertiesEditionPart {

	protected Text id;
	protected Text name;
	protected Text columns;
	protected Text tags;
	protected ReferencesTable huiproperty;
	protected List<ViewerFilter> huipropertyBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> huipropertyFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable depends;
	protected List<ViewerFilter> dependsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> dependsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public HuipropertygroupPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence huipropertygroupStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep baseStep = huipropertygroupStep.addStep(HitroViewsRepository.Huipropertygroup.Base.class);
		baseStep.addStep(HitroViewsRepository.Huipropertygroup.Base.id);
		baseStep.addStep(HitroViewsRepository.Huipropertygroup.Base.name);
		
		CompositionStep propertiesStep = huipropertygroupStep.addStep(HitroViewsRepository.Huipropertygroup.Properties.class);
		propertiesStep.addStep(HitroViewsRepository.Huipropertygroup.Properties.columns);
		propertiesStep.addStep(HitroViewsRepository.Huipropertygroup.Properties.tags);
		propertiesStep.addStep(HitroViewsRepository.Huipropertygroup.Properties.huiproperty);
		propertiesStep.addStep(HitroViewsRepository.Huipropertygroup.Properties.depends);
		
		
		composer = new PartComposer(huipropertygroupStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == HitroViewsRepository.Huipropertygroup.Base.class) {
					return createBaseGroup(parent);
				}
				if (key == HitroViewsRepository.Huipropertygroup.Base.id) {
					return createIdText(parent);
				}
				if (key == HitroViewsRepository.Huipropertygroup.Base.name) {
					return createNameText(parent);
				}
				if (key == HitroViewsRepository.Huipropertygroup.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == HitroViewsRepository.Huipropertygroup.Properties.columns) {
					return createColumnsText(parent);
				}
				if (key == HitroViewsRepository.Huipropertygroup.Properties.tags) {
					return createTagsText(parent);
				}
				if (key == HitroViewsRepository.Huipropertygroup.Properties.huiproperty) {
					return createHuipropertyAdvancedTableComposition(parent);
				}
				if (key == HitroViewsRepository.Huipropertygroup.Properties.depends) {
					return createDependsAdvancedReferencesTable(parent);
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
		baseGroup.setText(HitroMessages.HuipropertygroupPropertiesEditionPart_BaseGroupLabel);
		GridData baseGroupData = new GridData(GridData.FILL_HORIZONTAL);
		baseGroupData.horizontalSpan = 3;
		baseGroup.setLayoutData(baseGroupData);
		GridLayout baseGroupLayout = new GridLayout();
		baseGroupLayout.numColumns = 3;
		baseGroup.setLayout(baseGroupLayout);
		return baseGroup;
	}

	
	protected Composite createIdText(Composite parent) {
		createDescription(parent, HitroViewsRepository.Huipropertygroup.Base.id, HitroMessages.HuipropertygroupPropertiesEditionPart_IdLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Base.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Base.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
				}
			}

		});
		EditingUtils.setID(id, HitroViewsRepository.Huipropertygroup.Base.id);
		EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huipropertygroup.Base.id, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIdText

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, HitroViewsRepository.Huipropertygroup.Base.name, HitroMessages.HuipropertygroupPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Base.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Base.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, HitroViewsRepository.Huipropertygroup.Base.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huipropertygroup.Base.name, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(HitroMessages.HuipropertygroupPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createColumnsText(Composite parent) {
		createDescription(parent, HitroViewsRepository.Huipropertygroup.Properties.columns, HitroMessages.HuipropertygroupPropertiesEditionPart_ColumnsLabel);
		columns = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData columnsData = new GridData(GridData.FILL_HORIZONTAL);
		columns.setLayoutData(columnsData);
		columns.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.columns, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, columns.getText()));
			}

		});
		columns.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.columns, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, columns.getText()));
				}
			}

		});
		EditingUtils.setID(columns, HitroViewsRepository.Huipropertygroup.Properties.columns);
		EditingUtils.setEEFtype(columns, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huipropertygroup.Properties.columns, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createColumnsText

		// End of user code
		return parent;
	}

	
	protected Composite createTagsText(Composite parent) {
		createDescription(parent, HitroViewsRepository.Huipropertygroup.Properties.tags, HitroMessages.HuipropertygroupPropertiesEditionPart_TagsLabel);
		tags = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData tagsData = new GridData(GridData.FILL_HORIZONTAL);
		tags.setLayoutData(tagsData);
		tags.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.tags, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, tags.getText()));
			}

		});
		tags.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.tags, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, tags.getText()));
				}
			}

		});
		EditingUtils.setID(tags, HitroViewsRepository.Huipropertygroup.Properties.tags);
		EditingUtils.setEEFtype(tags, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huipropertygroup.Properties.tags, HitroViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTagsText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createHuipropertyAdvancedTableComposition(Composite parent) {
		this.huiproperty = new ReferencesTable(getDescription(HitroViewsRepository.Huipropertygroup.Properties.huiproperty, HitroMessages.HuipropertygroupPropertiesEditionPart_HuipropertyLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.huiproperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				huiproperty.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.huiproperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				huiproperty.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.huiproperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				huiproperty.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.huiproperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				huiproperty.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.huipropertyFilters) {
			this.huiproperty.addFilter(filter);
		}
		this.huiproperty.setHelpText(propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huipropertygroup.Properties.huiproperty, HitroViewsRepository.SWT_KIND));
		this.huiproperty.createControls(parent);
		this.huiproperty.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.huiproperty, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData huipropertyData = new GridData(GridData.FILL_HORIZONTAL);
		huipropertyData.horizontalSpan = 3;
		this.huiproperty.setLayoutData(huipropertyData);
		this.huiproperty.setLowerBound(0);
		this.huiproperty.setUpperBound(-1);
		huiproperty.setID(HitroViewsRepository.Huipropertygroup.Properties.huiproperty);
		huiproperty.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createHuipropertyAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createDependsAdvancedReferencesTable(Composite parent) {
		String label = getDescription(HitroViewsRepository.Huipropertygroup.Properties.depends, HitroMessages.HuipropertygroupPropertiesEditionPart_DependsLabel);		 
		this.depends = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addDepends(); }
			public void handleEdit(EObject element) { editDepends(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveDepends(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromDepends(element); }
			public void navigateTo(EObject element) { }
		});
		this.depends.setHelpText(propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huipropertygroup.Properties.depends, HitroViewsRepository.SWT_KIND));
		this.depends.createControls(parent);
		this.depends.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.depends, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData dependsData = new GridData(GridData.FILL_HORIZONTAL);
		dependsData.horizontalSpan = 3;
		this.depends.setLayoutData(dependsData);
		this.depends.disableMove();
		depends.setID(HitroViewsRepository.Huipropertygroup.Properties.depends);
		depends.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addDepends() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(depends.getInput(), dependsFilters, dependsBusinessFilters,
		"depends", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.depends,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				depends.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveDepends(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.depends, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		depends.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromDepends(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuipropertygroupPropertiesEditionPartImpl.this, HitroViewsRepository.Huipropertygroup.Properties.depends, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		depends.refresh();
	}

	/**
	 * 
	 */
	protected void editDepends(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				depends.refresh();
			}
		}
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
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#getId()
	 * 
	 */
	public String getId() {
		return id.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#setId(String newValue)
	 * 
	 */
	public void setId(String newValue) {
		if (newValue != null) {
			id.setText(newValue);
		} else {
			id.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huipropertygroup.Base.id);
		if (eefElementEditorReadOnlyState && id.isEnabled()) {
			id.setEnabled(false);
			id.setToolTipText(HitroMessages.Huipropertygroup_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !id.isEnabled()) {
			id.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huipropertygroup.Base.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(HitroMessages.Huipropertygroup_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#getColumns()
	 * 
	 */
	public String getColumns() {
		return columns.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#setColumns(String newValue)
	 * 
	 */
	public void setColumns(String newValue) {
		if (newValue != null) {
			columns.setText(newValue);
		} else {
			columns.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huipropertygroup.Properties.columns);
		if (eefElementEditorReadOnlyState && columns.isEnabled()) {
			columns.setEnabled(false);
			columns.setToolTipText(HitroMessages.Huipropertygroup_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !columns.isEnabled()) {
			columns.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#getTags()
	 * 
	 */
	public String getTags() {
		return tags.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#setTags(String newValue)
	 * 
	 */
	public void setTags(String newValue) {
		if (newValue != null) {
			tags.setText(newValue);
		} else {
			tags.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huipropertygroup.Properties.tags);
		if (eefElementEditorReadOnlyState && tags.isEnabled()) {
			tags.setEnabled(false);
			tags.setToolTipText(HitroMessages.Huipropertygroup_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !tags.isEnabled()) {
			tags.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#initHuiproperty(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initHuiproperty(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		huiproperty.setContentProvider(contentProvider);
		huiproperty.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huipropertygroup.Properties.huiproperty);
		if (eefElementEditorReadOnlyState && huiproperty.isEnabled()) {
			huiproperty.setEnabled(false);
			huiproperty.setToolTipText(HitroMessages.Huipropertygroup_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !huiproperty.isEnabled()) {
			huiproperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#updateHuiproperty()
	 * 
	 */
	public void updateHuiproperty() {
	huiproperty.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#addFilterHuiproperty(ViewerFilter filter)
	 * 
	 */
	public void addFilterToHuiproperty(ViewerFilter filter) {
		huipropertyFilters.add(filter);
		if (this.huiproperty != null) {
			this.huiproperty.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#addBusinessFilterHuiproperty(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToHuiproperty(ViewerFilter filter) {
		huipropertyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#isContainedInHuipropertyTable(EObject element)
	 * 
	 */
	public boolean isContainedInHuipropertyTable(EObject element) {
		return ((ReferencesTableSettings)huiproperty.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#initDepends(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initDepends(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		depends.setContentProvider(contentProvider);
		depends.setInput(settings);
		dependsBusinessFilters.clear();
		dependsFilters.clear();
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huipropertygroup.Properties.depends);
		if (eefElementEditorReadOnlyState && depends.getTable().isEnabled()) {
			depends.setEnabled(false);
			depends.setToolTipText(HitroMessages.Huipropertygroup_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !depends.getTable().isEnabled()) {
			depends.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#updateDepends()
	 * 
	 */
	public void updateDepends() {
	depends.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#addFilterDepends(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDepends(ViewerFilter filter) {
		dependsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#addBusinessFilterDepends(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDepends(ViewerFilter filter) {
		dependsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuipropertygroupPropertiesEditionPart#isContainedInDependsTable(EObject element)
	 * 
	 */
	public boolean isContainedInDependsTable(EObject element) {
		return ((ReferencesTableSettings)depends.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return HitroMessages.Huipropertygroup_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
