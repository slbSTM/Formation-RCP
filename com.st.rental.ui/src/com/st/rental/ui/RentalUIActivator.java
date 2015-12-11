package com.st.rental.ui;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUIActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.st.rental.ui"; //$NON-NLS-1$

	// The shared instance
	private static RentalUIActivator plugin;
	
	/**
	 * The constructor
	 */
	public RentalUIActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		readViewExtensions();
	}

	private void readViewExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		
		for (IConfigurationElement e : registry.getConfigurationElementsFor("org.eclipse.ui.views")) {
			if (e.getName().equals("view")) {
				System.out.print("Plugin : ");
				System.out.print(e.getNamespaceIdentifier());
				System.out.print("\t");
				System.out.print("View : ");
				System.out.print(e.getAttribute("name"));
				System.out.println();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RentalUIActivator getDefault() {
		return plugin;
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		Bundle b = FrameworkUtil.getBundle(this.getClass());
		
		reg.put(RentalUIConstants.IMG_AGENCY, ImageDescriptor.createFromURL(b.getEntry(RentalUIConstants.IMG_AGENCY)));
		reg.put(RentalUIConstants.IMG_CUSTOMERS, ImageDescriptor.createFromURL(b.getEntry(RentalUIConstants.IMG_CUSTOMERS)));
		reg.put(RentalUIConstants.IMG_RENTAL_OBJECTS, ImageDescriptor.createFromURL(b.getEntry(RentalUIConstants.IMG_RENTAL_OBJECTS)));
		reg.put(RentalUIConstants.IMG_RENTALS, ImageDescriptor.createFromURL(b.getEntry(RentalUIConstants.IMG_RENTALS)));
	}

}
