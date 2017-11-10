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
import de.sernet.eclipse.hitro.parts.HuientitiesPropertiesEditionPart;

import de.sernet.eclipse.hitro.providers.HitroMessages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

// End of user code

/**
 * @author Urs Zeidler
 * 
 */
public class HuientitiesPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, HuientitiesPropertiesEditionPart {

	protected ReferencesTable huientity;
	protected List<ViewerFilter> huientityBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> huientityFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public HuientitiesPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence huientitiesStep = new BindingCompositionSequence(propertiesEditionComponent);
		huientitiesStep
			.addStep(HitroViewsRepository.Huientities.Properties.class)
			.addStep(HitroViewsRepository.Huientities.Properties.huientity);
		
		
		composer = new PartComposer(huientitiesStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == HitroViewsRepository.Huientities.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == HitroViewsRepository.Huientities.Properties.huientity) {
					return createHuientityAdvancedTableComposition(parent);
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
		propertiesGroup.setText(HitroMessages.HuientitiesPropertiesEditionPart_PropertiesGroupLabel);
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
	protected Composite createHuientityAdvancedTableComposition(Composite parent) {
		this.huientity = new ReferencesTable(getDescription(HitroViewsRepository.Huientities.Properties.huientity, HitroMessages.HuientitiesPropertiesEditionPart_HuientityLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuientitiesPropertiesEditionPartImpl.this, HitroViewsRepository.Huientities.Properties.huientity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				huientity.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuientitiesPropertiesEditionPartImpl.this, HitroViewsRepository.Huientities.Properties.huientity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				huientity.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuientitiesPropertiesEditionPartImpl.this, HitroViewsRepository.Huientities.Properties.huientity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				huientity.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuientitiesPropertiesEditionPartImpl.this, HitroViewsRepository.Huientities.Properties.huientity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				huientity.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.huientityFilters) {
			this.huientity.addFilter(filter);
		}
		this.huientity.setHelpText(propertiesEditionComponent.getHelpContent(HitroViewsRepository.Huientities.Properties.huientity, HitroViewsRepository.SWT_KIND));
		this.huientity.createControls(parent);
		this.huientity.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(HuientitiesPropertiesEditionPartImpl.this, HitroViewsRepository.Huientities.Properties.huientity, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData huientityData = new GridData(GridData.FILL_HORIZONTAL);
		huientityData.horizontalSpan = 3;
		this.huientity.setLayoutData(huientityData);
		this.huientity.setLowerBound(1);
		this.huientity.setUpperBound(-1);
		huientity.setID(HitroViewsRepository.Huientities.Properties.huientity);
		huientity.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createHuientityAdvancedTableComposition

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
	 * @see de.sernet.eclipse.hitro.parts.HuientitiesPropertiesEditionPart#initHuientity(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initHuientity(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		huientity.setContentProvider(contentProvider);
		huientity.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.Huientities.Properties.huientity);
		if (eefElementEditorReadOnlyState && huientity.isEnabled()) {
			huientity.setEnabled(false);
			huientity.setToolTipText(HitroMessages.Huientities_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !huientity.isEnabled()) {
			huientity.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuientitiesPropertiesEditionPart#updateHuientity()
	 * 
	 */
	public void updateHuientity() {
	huientity.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuientitiesPropertiesEditionPart#addFilterHuientity(ViewerFilter filter)
	 * 
	 */
	public void addFilterToHuientity(ViewerFilter filter) {
		huientityFilters.add(filter);
		if (this.huientity != null) {
			this.huientity.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuientitiesPropertiesEditionPart#addBusinessFilterHuientity(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToHuientity(ViewerFilter filter) {
		huientityBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.HuientitiesPropertiesEditionPart#isContainedInHuientityTable(EObject element)
	 * 
	 */
	public boolean isContainedInHuientityTable(EObject element) {
		return ((ReferencesTableSettings)huientity.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return HitroMessages.Huientities_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
