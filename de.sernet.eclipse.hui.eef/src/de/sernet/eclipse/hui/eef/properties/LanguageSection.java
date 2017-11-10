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
package de.sernet.eclipse.hui.eef.properties;

import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.sernet.eclipse.hitro.lang.LangEntry;
import de.sernet.eclipse.hitro.lang.LanguagesEntry;
import de.sernet.eclipse.hitro.presentation.HitroEditor;


/**
 * @author urszeidler
 *
 */
public class LanguageSection extends AbstractPropertySection {

	private Map<EObject, LanguagesEntry> entryMap;
	private DataBindingContext m_bindingContext;
	private TableViewer tableViewer;
	private TableViewerColumn tableViewerColumn_1;
	private TableViewerColumn tableViewerColumn;
	private LanguagesEntry selected;
	private List<Object> entries = new WritableList<Object>();
	

	/**
	 * 
	 */
	public LanguageSection() {
		ISelection selection2 = getSelection();
		selectionChange(selection2);
	}

	private void selectionChange	(ISelection selection2) {
		if (selection2 instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) selection2;
			Object element = ss.getFirstElement();
			if (element instanceof EObject) {
				EObject eo = (EObject) element;
				selected = entryMap.get(eo);
				if (selected != null) {
					entries.clear();
					entries.addAll(selected.getEntries());
					tableViewer.setInput(entries);
				}
			}
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		createWidget(parent);
	}

	private void createWidget(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("lang");

		tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("text");
				
		m_bindingContext = initDataBindings();
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap[] observeMaps = BeansObservables.observeMaps(listContentProvider.getKnownElements(), LangEntry.class, new String[]{"lang", "text"});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableList selfList = Properties.selfList(LangEntry.class).observe(entries);
		tableViewer.setInput(selfList);
		//
		tableViewerColumn_1.setEditingSupport(new InlineEditingSupport<String>(tableViewer,
				bindingContext,"text"));
		
		//
		return bindingContext;
	}


	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (part instanceof HitroEditor) {
			HitroEditor he = (HitroEditor) part;
			entryMap = he.getEntryMap();
			selectionChange(selection);
		}
	}

}
