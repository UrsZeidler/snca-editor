package de.sernet.eclipse.hui.parsley;

import de.sernet.eclipse.hui.parsley.ui.provider.ParsleyLabelProvider;
import org.eclipse.emf.parsley.EmfParsleyGuiceModule;
import org.eclipse.emf.parsley.edit.IEditingStrategy;
import org.eclipse.emf.parsley.edit.UndoableEditingStrategy;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * de.sernet.eclipse.hui.parsley EMF Parsley Dsl Module file
 */
@SuppressWarnings("all")
public class ParsleyEmfParsleyGuiceModule extends EmfParsleyGuiceModule {
  public ParsleyEmfParsleyGuiceModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  @Override
  public Class<? extends IEditingStrategy> bindIEditingStrategy() {
    return UndoableEditingStrategy.class;
  }
  
  @Override
  public int valueTreeFormSashStyle() {
    return SWT.HORIZONTAL;
  }
  
  @Override
  public Class<? extends ILabelProvider> bindILabelProvider() {
    return ParsleyLabelProvider.class;
  }
}
