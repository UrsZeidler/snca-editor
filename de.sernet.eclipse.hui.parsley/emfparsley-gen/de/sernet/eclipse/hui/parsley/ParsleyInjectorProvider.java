package de.sernet.eclipse.hui.parsley;

import org.eclipse.emf.parsley.runtime.ui.PluginUtil;

import com.google.inject.Guice;
import com.google.inject.Injector;

@SuppressWarnings("all")
public class ParsleyInjectorProvider {
    private static Injector injector;

    public static synchronized Injector getInjector() {
        if (injector == null) {
            injector = Guice.createInjector(new ParsleyEmfParsleyGuiceModule(
                    PluginUtil.getPlugin(PluginUtil.getBundle(ParsleyInjectorProvider.class))));
        }
        return injector;
    }
}
