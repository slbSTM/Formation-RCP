package com.st.rental.ui.prefs;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;

import com.st.rental.ui.RentalUIActivator;
import com.st.rental.ui.RentalUIConstants;

public class RentalColorsPreferenceInitializer extends AbstractPreferenceInitializer implements RentalUIConstants {

	public RentalColorsPreferenceInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = RentalUIActivator.getDefault().getPreferenceStore();

		RGB black = new RGB(0, 0, 0);
		RGB red = new RGB(255, 0, 0);
		RGB green = new RGB(0, 255, 0);
		RGB blue = new RGB(0, 0, 255);
		store.setDefault(PREF_COLOR_AGENCIES, StringConverter.asString(black));
		store.setDefault(PREF_COLOR_CUSTOMERS, StringConverter.asString(red));
		store.setDefault(PREF_COLOR_RENTAL_OBJECTS, StringConverter.asString(green));
		store.setDefault(PREF_COLOR_RENTALS, StringConverter.asString(blue));

		store.setDefault(PREF_PALETTE, "com.st.rental.ui.palette.default");
	}
}
