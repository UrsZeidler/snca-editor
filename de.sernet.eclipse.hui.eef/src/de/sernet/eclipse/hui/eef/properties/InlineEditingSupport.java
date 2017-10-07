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