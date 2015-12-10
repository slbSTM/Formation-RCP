package com.st.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.st.rental.core.RentalCoreActivator;
import com.st.rental.ui.RentalUIActivator;

public class RentalAgencyView extends ViewPart implements IPropertyChangeListener {

	private TreeViewer tv;

	public RentalAgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		RentalProvider rentalProvider = new RentalProvider();	
		tv = new TreeViewer(parent);

		tv.setContentProvider(rentalProvider);
		tv.setLabelProvider(rentalProvider);
		Collection<RentalAgency> agencyCollection = new ArrayList<RentalAgency>();
		agencyCollection.add(RentalCoreActivator.getAgency());
		tv.setInput(agencyCollection);
		
		tv.expandAll();
		
		getSite().setSelectionProvider(tv);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		RentalUIActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}
	
	@Override
	public void dispose() {
		RentalUIActivator.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		super.dispose();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		tv.refresh();
	}
}
