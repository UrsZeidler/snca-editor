package de.sernet.eclipse.hitro.presentation.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PatternFilter;

import de.sernet.eclipse.hitro.presentation.HitroEditorPlugin;

public final class TextControlContribution extends ControlContribution {
	private final PatternFilter filter;
	private ViewerPane viewerPane;
	private AutoCompleteField autoCompleteField;
	private List<String> proposals;

	public TextControlContribution(String id, PatternFilter filter, ViewerPane viewerPane) {
		super(id);
		this.filter = filter;
		this.viewerPane = viewerPane;
	}

	@Override
	protected Control createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(3, false);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		parent = composite;

		Label lblNewLabel = new Label(parent, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("filter: ");

		Text text = new Text(parent, SWT.NONE);
		text.setMessage("Filter ...");
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				boolean lineFeed = e.keyCode == (int) SWT.CR;
				if (lineFeed) {
					String newText = text.getText();
					if(!proposals.contains(newText)) {
						proposals.add(newText);
						autoCompleteField.setProposals(proposals.toArray(new String[] {}));
					}
				}
			}
		});
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				filter.setPattern(text.getText());
				viewerPane.getViewer().refresh();
			}
		});
		GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		text.setLayoutData(layoutData);
		layoutData.widthHint = 100;
		String[] items = HitroEditorPlugin.getPlugin().getDialogSettings().getArray("editor.filter.items");
		if (items == null) {
			proposals = new ArrayList<>();
			proposals.add("*");
			proposals.add("bp*");

		}
		autoCompleteField = new AutoCompleteField(text, new TextContentAdapter(), proposals.toArray(new String[] {}));
		return parent;
	}

	@Override
	public void dispose() {
		HitroEditorPlugin.getPlugin().getDialogSettings().put("editor.filter.items",
				proposals.toArray(new String[] {}));
		super.dispose();
	}
}