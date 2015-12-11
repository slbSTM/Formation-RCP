package com.st.rental.ui.palette;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Color;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.st.rental.ui.RentalUIActivator;
import com.st.rental.ui.RentalUIConstants;


public class DefaultPalette implements IColorProvider,RentalUIConstants {

	public DefaultPalette() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getForeground(Object element) {
		IPreferenceStore store = RentalUIActivator.getDefault().getPreferenceStore();
		Color color = null;

		if (element instanceof RentalAgency) {
			color = getColor(store.getString(PREF_COLOR_AGENCIES));
		}
		else if (element instanceof Customer) {
			color = getColor(store.getString(PREF_COLOR_CUSTOMERS));
		}
		else if (element instanceof RentalObject) {
			color = getColor(store.getString(PREF_COLOR_RENTAL_OBJECTS));
		}
		else if (element instanceof Rental) {
			color = getColor(store.getString(PREF_COLOR_RENTALS));
		}

		return color;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	private Color getColor(String rgbKey) {
		ColorRegistry registry = JFaceResources.getColorRegistry();
		Color color = registry.get(rgbKey);
		if (color == null) {
			registry.put(rgbKey, StringConverter.asRGB(rgbKey));
			color = registry.get(rgbKey);
		}

		return color;
	}
}
