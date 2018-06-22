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

    public PatternFilterAction(String text, PatternFilter filter, ViewerPane viewerPane,
            ImageDescriptor image) {
        super(text, image);
        this.filter = filter;
        this.viewer = viewerPane;
    }

    @Override
    public void run() {
        InputDialog inputDialog = new InputDialog(Display.getCurrent().getActiveShell(), "Filter",
                "Filter tree with a pattern, * / ? are allowed.", pattern, null);
        if (inputDialog.open() == SWT.CANCEL)
            return;
        String patternString = inputDialog.getValue();
        filter.setPattern(patternString);
        pattern = patternString;
        viewer.getViewer().refresh();
    }
}