package de.sernet.eclipse.hui.parsley;

import com.google.inject.Injector;
import de.sernet.eclipse.hui.parsley.ParsleyInjectorProvider;
import org.eclipse.emf.parsley.runtime.ui.AbstractGuiceAwareExecutableExtensionFactory;

@SuppressWarnings("all")
public class ParsleyExecutableExtensionFactory
        extends AbstractGuiceAwareExecutableExtensionFactory {
    @Override
    public Injector getInjector() throws Exception {
        return ParsleyInjectorProvider.getInjector();
    }
}
