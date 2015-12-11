package com.st.rental.ui.prefs;

import java.util.Map;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.st.rental.ui.Palette;
import com.st.rental.ui.RentalUIActivator;
import com.st.rental.ui.RentalUIConstants;

public class PalettesPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage,RentalUIConstants {

	public PalettesPreferencePage() {
		super(GRID);
		setPreferenceStore(RentalUIActivator.getDefault().getPreferenceStore());
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		Map<String, Palette> palettes = RentalUIActivator.getDefault().getPaletteManager();
		
		String[][] comboValues = new String[palettes.size()][2];
		int i = 0;
		for (Palette p : palettes.values()) {
			comboValues[i][0] = p.getName();
			comboValues[i][1] = p.getId();
			i ++;
		}
		
		addField(new ComboFieldEditor(PREF_PALETTE, "Palette", comboValues, getFieldEditorParent()));
	}
}
