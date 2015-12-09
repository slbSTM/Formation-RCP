package com.st.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.st.rental.ui.RentalUIConstants;

public class RentalProvider extends LabelProvider implements ITreeContentProvider {

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection<?>) {
			return ((Collection<?>) inputElement).toArray();
		}

		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] elements = null;

		if (parentElement instanceof RentalAgency) {
			RentalAgency agency = (RentalAgency)parentElement;
			Node[] nodes = new Node[3];
			nodes[0] = new Node(RentalUIConstants.NODE_CUSTOMERS, agency);
			nodes[1] = new Node(RentalUIConstants.NODE_RENTAL_OBJECTS, agency);
			nodes[2] = new Node(RentalUIConstants.NODE_RENTALS, agency);
			elements = nodes;
		}
		else if (parentElement instanceof Node) {
			return ((Node) parentElement).getChildren();
		}

		return elements;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof RentalAgency) {
			return true;
		}
		else if (element instanceof Node) {
			return true;
		}

		return false;
	}

	
	@Override
	public String getText(Object element) {
		if (element instanceof RentalAgency) {
			return ((RentalAgency) element).getName();
		}
		else if (element instanceof Customer) {
			return ((Customer) element).getDisplayName();
		}
		else if (element instanceof RentalObject) {
			return ((RentalObject) element).getName();
		}
		else if (element instanceof Rental) {
			return ((Rental) element).toString();
		}

		return super.getText(element);
	}


	class Node {
		private String title;
		private RentalAgency agency;

		public Node(String title, RentalAgency agency) {
			super();
			this.title = title;
			this.agency = agency;
		}
		
		public Object[] getChildren() {
			if (title == RentalUIConstants.NODE_CUSTOMERS) {
				return agency.getCustomers().toArray();
			}
			else if (title == RentalUIConstants.NODE_RENTAL_OBJECTS) {
				return agency.getObjectsToRent().toArray();
			}
			else if (title == RentalUIConstants.NODE_RENTALS) {
				return agency.getRentals().toArray();
			}

			return null;
		}
		
		@Override
		public String toString() {
			return title;
		}
	}
}
