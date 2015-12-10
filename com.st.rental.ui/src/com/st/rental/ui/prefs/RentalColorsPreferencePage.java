package com.st.rental.ui.prefs;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.st.rental.core.RentalCoreActivator;
import com.st.rental.ui.RentalUIActivator;
import com.st.rental.ui.RentalUIConstants;

public class RentalColorsPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage, RentalUIConstants {

	public RentalColorsPreferencePage() {
		super(GRID);
		setPreferenceStore(RentalUIActivator.getDefault().getPreferenceStore());
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		addField(new ColorFieldEditor(PREF_COLOR_AGENCIES, NODE_AGENCIES, getFieldEditorParent()));
		addField(new ColorFieldEditor(PREF_COLOR_CUSTOMERS, NODE_CUSTOMERS, getFieldEditorParent()));
		addField(new ColorFieldEditor(PREF_COLOR_RENTAL_OBJECTS, NODE_RENTAL_OBJECTS, getFieldEditorParent()));
		addField(new ColorFieldEditor(PREF_COLOR_RENTALS, NODE_RENTALS, getFieldEditorParent()));
	}
}
