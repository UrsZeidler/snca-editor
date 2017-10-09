package de.sernet.eclipse.hitro.presentation.actions;

import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.PatternFilter;

public class PatternFilterAction extends Action {
	/**
	 * 
	 */
	private final PatternFilter filter;
	private final ViewerPane viewer;
	private String pattern = "*";

	public PatternFilterAction(String text, PatternFilter filter, ViewerPane viewerPane) {
		super(text);
		this.filter = filter;
		this.viewer = viewerPane;
	}
	public PatternFilterAction(String text, PatternFilter filter, ViewerPane viewerPane, ImageDescriptor image) {
		super(text, image);
		this.filter = filter;
		this.viewer = viewerPane;
	}

	@Override
	public void run() {
		InputDialog inputDialog = new InputDialog(Display.getCurrent().getActiveShell(), "Filter",
				"Filter tree with an pattern, * / ? are allowed.", pattern, null);
		if (inputDialog.open() == SWT.CANCEL)
			return;
		String patternString = inputDialog.getValue();
		filter.setPattern(patternString);
		pattern = patternString;
		viewer.getViewer().refresh();
	}
}