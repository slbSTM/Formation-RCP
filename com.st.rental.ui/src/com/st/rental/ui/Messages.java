package com.st.rental.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.st.rental.ui.messages"; //$NON-NLS-1$
	public static String SampleHandler_0;
	public static String SampleHandler_1;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
