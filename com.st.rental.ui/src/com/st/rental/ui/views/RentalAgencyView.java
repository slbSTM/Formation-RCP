package com.st.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.st.rental.core.RentalCoreActivator;
import com.st.rental.ui.RentalUIActivator;

public class RentalAgencyView extends ViewPart implements IPropertyChangeListener {

	private TreeViewer agencyViewer;

	public RentalAgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		RentalProvider rentalProvider = new RentalProvider();	
		agencyViewer = new TreeViewer(parent);

		agencyViewer.setContentProvider(rentalProvider);
		agencyViewer.setLabelProvider(rentalProvider);
		Collection<RentalAgency> agencyCollection = new ArrayList<RentalAgency>();
		agencyCollection.add(RentalCoreActivator.getAgency());
		agencyViewer.setInput(agencyCollection);
		
		agencyViewer.expandAll();
		
		getSite().setSelectionProvider(agencyViewer);

		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(agencyViewer.getControl());
		agencyViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuManager, agencyViewer);
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
		agencyViewer.refresh();
	}
}
