package de.sernet.eclipse.hui.ui.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class SNCAPerspective implements IPerspectiveFactory {

	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		addFastViews(layout);
		addViewShortcuts(layout);
		addPerspectiveShortcuts(layout);
		layout.addView("org.eclipse.ui.views.ResourceNavigator", IPageLayout.LEFT, 0.2f, IPageLayout.ID_EDITOR_AREA);
		layout.addView("org.eclipse.ui.views.PropertySheet", IPageLayout.RIGHT, 0.54f, IPageLayout.ID_EDITOR_AREA);
		layout.addView("org.eclipse.ui.views.ProblemView", IPageLayout.BOTTOM, 0.8f, IPageLayout.ID_EDITOR_AREA);
	}

	/**
	 * Add fast views to the perspective.
	 */
	private void addFastViews(IPageLayout layout) {
	}

	/**
	 * Add view shortcuts to the perspective.
	 */
	private void addViewShortcuts(IPageLayout layout) {
		layout.addShowViewShortcut("org.eclipse.ui.views.AllMarkersView");
		layout.addShowViewShortcut("org.eclipse.ui.views.ContentOutline");
	}

	/**
	 * Add perspective shortcuts to the perspective.
	 */
	private void addPerspectiveShortcuts(IPageLayout layout) {
	}

}
