package de.sernet.eclipse.hui.parsley;

import org.eclipse.emf.parsley.runtime.ui.AbstractGuiceAwareExecutableExtensionFactory;

import com.google.inject.Injector;

@SuppressWarnings("all")
public class ParsleyExecutableExtensionFactory
        extends AbstractGuiceAwareExecutableExtensionFactory {
    @Override
    public Injector getInjector() throws Exception {
        return ParsleyInjectorProvider.getInjector();
    }
}
