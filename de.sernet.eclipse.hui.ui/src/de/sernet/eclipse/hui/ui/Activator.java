package de.sernet.eclipse.hui.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "de.sernet.eclipse.hui.ui"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
     * BundleContext)
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
     * BundleContext)
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    public static void logError(String message, Exception e) {
        plugin.getLog()
                .log(new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(), message, e));
    }

    public static void logError(String message) {
        plugin.getLog()
                .log(new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(), message));
    }

    public static void logError(Exception e) {
        plugin.getLog().log(
                new Status(IStatus.ERROR, plugin.getBundle().getSymbolicName(), e.getMessage(), e));
    }

    public static void logInfo(String message) {
        plugin.getLog()
                .log(new Status(IStatus.INFO, plugin.getBundle().getSymbolicName(), message));
    }
}
