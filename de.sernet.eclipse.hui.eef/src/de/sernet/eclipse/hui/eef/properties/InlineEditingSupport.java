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

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

class InlineEditingSupport<T> extends ObservableValueEditingSupport {
	private CellEditor cellEditor;
	private String propertyName;
	
	/**
	 * @param viewer
	 * @param dbc
	 * @param the propery to observe
	 */
	public InlineEditingSupport(ColumnViewer viewer,
			DataBindingContext dbc, String propertyName) {
		
		super(viewer, dbc);
		cellEditor = new TextCellEditor((Composite) viewer.getControl());
		this.propertyName = propertyName;
	}
	
	protected CellEditor getCellEditor(Object element) {
		return cellEditor;
	}

	protected IObservableValue<T> doCreateCellEditorObservable(
			CellEditor cellEditor) {
		
		return SWTObservables.observeText(cellEditor
				.getControl(), SWT.Modify);
	}

	protected IObservableValue<T> doCreateElementObservable(Object element,
			ViewerCell cell) {
//		IObservableValue<T> value = BeanProperties.value(propertyName, element.getClass()).observe(element);
		return BeansObservables.observeValue(element, propertyName);
	}		
}