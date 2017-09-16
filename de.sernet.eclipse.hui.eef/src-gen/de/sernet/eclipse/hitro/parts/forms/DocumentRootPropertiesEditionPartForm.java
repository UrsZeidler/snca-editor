/**
 * Generated with Acceleo
 */
package de.sernet.eclipse.hitro.parts.forms;

// Start of user code for imports
import de.sernet.eclipse.hitro.HitroPackage;

import de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart;
import de.sernet.eclipse.hitro.parts.HitroViewsRepository;

import de.sernet.eclipse.hitro.providers.HitroMessages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

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

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
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
public class DocumentRootPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, DocumentRootPropertiesEditionPart {

	protected Text mixed;
	protected Button editMixed;
	protected EList mixedList;
	protected ReferencesTable xMLNSPrefixMap;
	protected List<ViewerFilter> xMLNSPrefixMapBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> xMLNSPrefixMapFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable xSISchemaLocation;
	protected List<ViewerFilter> xSISchemaLocationBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> xSISchemaLocationFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public DocumentRootPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DocumentRootPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence documentRootStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = documentRootStep.addStep(HitroViewsRepository.DocumentRoot.Properties.class);
		propertiesStep.addStep(HitroViewsRepository.DocumentRoot.Properties.mixed);
		propertiesStep.addStep(HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap);
		propertiesStep.addStep(HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation);
		
		
		composer = new PartComposer(documentRootStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == HitroViewsRepository.DocumentRoot.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == HitroViewsRepository.DocumentRoot.Properties.mixed) {
					return createMixedMultiValuedEditor(widgetFactory, parent);
				}
				if (key == HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap) {
					return createXMLNSPrefixMapTableComposition(widgetFactory, parent);
				}
				if (key == HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation) {
					return createXSISchemaLocationTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(HitroMessages.DocumentRootPropertiesEditionPart_PropertiesGroupLabel);
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
	 * 
	 */
	protected Composite createMixedMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		mixed = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData mixedData = new GridData(GridData.FILL_HORIZONTAL);
		mixedData.horizontalSpan = 2;
		mixed.setLayoutData(mixedData);
		EditingUtils.setID(mixed, HitroViewsRepository.DocumentRoot.Properties.mixed);
		EditingUtils.setEEFtype(mixed, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editMixed = widgetFactory.createButton(parent, getDescription(HitroViewsRepository.DocumentRoot.Properties.mixed, HitroMessages.DocumentRootPropertiesEditionPart_MixedLabel), SWT.NONE);
		GridData editMixedData = new GridData();
		editMixed.setLayoutData(editMixedData);
		editMixed.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						mixed.getShell(), "DocumentRoot", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						mixedList, HitroPackage.eINSTANCE.getDocumentRoot_Mixed().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					mixedList = dialog.getResult();
					if (mixedList == null) {
						mixedList = new BasicEList();
					}
					mixed.setText(mixedList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentRootPropertiesEditionPartForm.this, HitroViewsRepository.DocumentRoot.Properties.mixed, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(mixedList)));
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
	 * @param container
	 * 
	 */
	protected Composite createXMLNSPrefixMapTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.xMLNSPrefixMap = new ReferencesTable(getDescription(HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap, HitroMessages.DocumentRootPropertiesEditionPart_XMLNSPrefixMapLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentRootPropertiesEditionPartForm.this, HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				xMLNSPrefixMap.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentRootPropertiesEditionPartForm.this, HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				xMLNSPrefixMap.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentRootPropertiesEditionPartForm.this, HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				xMLNSPrefixMap.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentRootPropertiesEditionPartForm.this, HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				xMLNSPrefixMap.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.xMLNSPrefixMapFilters) {
			this.xMLNSPrefixMap.addFilter(filter);
		}
		this.xMLNSPrefixMap.setHelpText(propertiesEditionComponent.getHelpContent(HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap, HitroViewsRepository.FORM_KIND));
		this.xMLNSPrefixMap.createControls(parent, widgetFactory);
		this.xMLNSPrefixMap.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentRootPropertiesEditionPartForm.this, HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData xMLNSPrefixMapData = new GridData(GridData.FILL_HORIZONTAL);
		xMLNSPrefixMapData.horizontalSpan = 3;
		this.xMLNSPrefixMap.setLayoutData(xMLNSPrefixMapData);
		this.xMLNSPrefixMap.setLowerBound(0);
		this.xMLNSPrefixMap.setUpperBound(-1);
		xMLNSPrefixMap.setID(HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap);
		xMLNSPrefixMap.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createXMLNSPrefixMapTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createXSISchemaLocationTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.xSISchemaLocation = new ReferencesTable(getDescription(HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation, HitroMessages.DocumentRootPropertiesEditionPart_XSISchemaLocationLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentRootPropertiesEditionPartForm.this, HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				xSISchemaLocation.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentRootPropertiesEditionPartForm.this, HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				xSISchemaLocation.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentRootPropertiesEditionPartForm.this, HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				xSISchemaLocation.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentRootPropertiesEditionPartForm.this, HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				xSISchemaLocation.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.xSISchemaLocationFilters) {
			this.xSISchemaLocation.addFilter(filter);
		}
		this.xSISchemaLocation.setHelpText(propertiesEditionComponent.getHelpContent(HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation, HitroViewsRepository.FORM_KIND));
		this.xSISchemaLocation.createControls(parent, widgetFactory);
		this.xSISchemaLocation.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentRootPropertiesEditionPartForm.this, HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData xSISchemaLocationData = new GridData(GridData.FILL_HORIZONTAL);
		xSISchemaLocationData.horizontalSpan = 3;
		this.xSISchemaLocation.setLayoutData(xSISchemaLocationData);
		this.xSISchemaLocation.setLowerBound(0);
		this.xSISchemaLocation.setUpperBound(-1);
		xSISchemaLocation.setID(HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation);
		xSISchemaLocation.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createXSISchemaLocationTableComposition

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
	 * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#setMixed(EList newValue)
	 * 
	 */
	public void setMixed(EList newValue) {
		mixedList = newValue;
		if (newValue != null) {
			mixed.setText(mixedList.toString());
		} else {
			mixed.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.DocumentRoot.Properties.mixed);
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
	 * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#initXMLNSPrefixMap(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initXMLNSPrefixMap(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		xMLNSPrefixMap.setContentProvider(contentProvider);
		xMLNSPrefixMap.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.DocumentRoot.Properties.xMLNSPrefixMap);
		if (eefElementEditorReadOnlyState && xMLNSPrefixMap.isEnabled()) {
			xMLNSPrefixMap.setEnabled(false);
			xMLNSPrefixMap.setToolTipText(HitroMessages.DocumentRoot_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !xMLNSPrefixMap.isEnabled()) {
			xMLNSPrefixMap.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#updateXMLNSPrefixMap()
	 * 
	 */
	public void updateXMLNSPrefixMap() {
	xMLNSPrefixMap.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#addFilterXMLNSPrefixMap(ViewerFilter filter)
	 * 
	 */
	public void addFilterToXMLNSPrefixMap(ViewerFilter filter) {
		xMLNSPrefixMapFilters.add(filter);
		if (this.xMLNSPrefixMap != null) {
			this.xMLNSPrefixMap.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#addBusinessFilterXMLNSPrefixMap(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToXMLNSPrefixMap(ViewerFilter filter) {
		xMLNSPrefixMapBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#isContainedInXMLNSPrefixMapTable(EObject element)
	 * 
	 */
	public boolean isContainedInXMLNSPrefixMapTable(EObject element) {
		return ((ReferencesTableSettings)xMLNSPrefixMap.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#initXSISchemaLocation(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initXSISchemaLocation(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		xSISchemaLocation.setContentProvider(contentProvider);
		xSISchemaLocation.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(HitroViewsRepository.DocumentRoot.Properties.xSISchemaLocation);
		if (eefElementEditorReadOnlyState && xSISchemaLocation.isEnabled()) {
			xSISchemaLocation.setEnabled(false);
			xSISchemaLocation.setToolTipText(HitroMessages.DocumentRoot_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !xSISchemaLocation.isEnabled()) {
			xSISchemaLocation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#updateXSISchemaLocation()
	 * 
	 */
	public void updateXSISchemaLocation() {
	xSISchemaLocation.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#addFilterXSISchemaLocation(ViewerFilter filter)
	 * 
	 */
	public void addFilterToXSISchemaLocation(ViewerFilter filter) {
		xSISchemaLocationFilters.add(filter);
		if (this.xSISchemaLocation != null) {
			this.xSISchemaLocation.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#addBusinessFilterXSISchemaLocation(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToXSISchemaLocation(ViewerFilter filter) {
		xSISchemaLocationBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see de.sernet.eclipse.hitro.parts.DocumentRootPropertiesEditionPart#isContainedInXSISchemaLocationTable(EObject element)
	 * 
	 */
	public boolean isContainedInXSISchemaLocationTable(EObject element) {
		return ((ReferencesTableSettings)xSISchemaLocation.getInput()).contains(element);
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
