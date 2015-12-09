package com.st.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.st.rental.core.RentalCoreActivator;

public class RentalAgencyView extends ViewPart {

	public RentalAgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		RentalProvider rentalProvider = new RentalProvider();	
		TreeViewer tv = new TreeViewer(parent);

		tv.setContentProvider(rentalProvider);
		tv.setLabelProvider(rentalProvider);
		Collection<RentalAgency> agencyCollection = new ArrayList<RentalAgency>();
		agencyCollection.add(RentalCoreActivator.getAgency());
		tv.setInput(agencyCollection);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
