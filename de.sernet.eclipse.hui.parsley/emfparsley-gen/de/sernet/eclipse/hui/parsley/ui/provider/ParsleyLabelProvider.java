package de.sernet.eclipse.hui.parsley.ui.provider;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.parsley.ui.provider.ViewerLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.google.inject.Inject;

import de.sernet.eclipse.hitro.Huientity;
import de.sernet.eclipse.hitro.Huiproperty;
import de.sernet.eclipse.hitro.Huipropertygroup;
import de.sernet.eclipse.hitro.Huirelation;

@SuppressWarnings("all")
public class ParsleyLabelProvider extends ViewerLabelProvider {
    @Inject
    public ParsleyLabelProvider(final AdapterFactoryLabelProvider delegate) {
        super(delegate);
    }

    public String text(final Huientity it) {
        String _name = it.getName();
        String _plus = (_name + " [");
        String _id = it.getId();
        String _plus_1 = (_plus + _id);
        String _plus_2 = (_plus_1 + "]");
        return _plus_2;
    }

    public String text(final Huiproperty it) {
        String _name = it.getName();
        String _plus = (_name + " [");
        String _id = it.getId();
        String _plus_1 = (_plus + _id);
        String _plus_2 = (_plus_1 + "]");
        return _plus_2;
    }

    public String text(final Huipropertygroup it) {
        String _name = it.getName();
        String _plus = (_name + " [");
        String _id = it.getId();
        String _plus_1 = (_plus + _id);
        String _plus_2 = (_plus_1 + "]");
        return _plus_2;
    }

    public String text(final Huirelation it) {
        String _name = it.getName();
        String _plus = (_name + " [");
        String _id = it.getId();
        String _plus_1 = (_plus + _id);
        String _plus_2 = (_plus_1 + "]");
        return _plus_2;
    }

    public Color foreground(final Huipropertygroup it) {
        Color _systemColor = Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
        return _systemColor;
    }

    public Color foreground(final Huientity it) {
        Color _systemColor = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN);
        return _systemColor;
    }

    public Color foreground(final Huiproperty it) {
        Color _systemColor = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_YELLOW);
        return _systemColor;
    }
}
