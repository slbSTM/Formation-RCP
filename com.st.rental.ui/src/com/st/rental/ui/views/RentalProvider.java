package com.st.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.st.rental.ui.RentalUIActivator;
import com.st.rental.ui.RentalUIConstants;

public class RentalProvider extends LabelProvider implements ITreeContentProvider, IColorProvider, RentalUIConstants {

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
			nodes[0] = new Node(NODE_CUSTOMERS, agency);
			nodes[1] = new Node(NODE_RENTAL_OBJECTS, agency);
			nodes[2] = new Node(NODE_RENTALS, agency);
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

	@Override
	public Image getImage(Object element) {
		if (element instanceof RentalAgency) {
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_AGENCY);
		}
		else if (element instanceof Node) {
			return ((Node) element).getImage();
		}
		else if (element instanceof Customer) {
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_CUSTOMERS);
		}
		else if (element instanceof RentalObject) {
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_RENTAL_OBJECTS);
		}
		else if (element instanceof Rental) {
			return RentalUIActivator.getDefault().getImageRegistry().get(IMG_RENTALS);
		}

		return super.getImage(element);
	}

	@Override
	public Color getForeground(Object element) {
		Display display = Display.getCurrent();

		if (element instanceof RentalAgency) {
			return display.getSystemColor(SWT.COLOR_DARK_GRAY);
		}
		else if (element instanceof Node) {
			return ((Node) element).getForeround();
		}
		else if (element instanceof Customer) {
			return display.getSystemColor(SWT.COLOR_DARK_BLUE);
		}
		else if (element instanceof RentalObject) {
			return display.getSystemColor(SWT.COLOR_DARK_GREEN);
		}
		else if (element instanceof Rental) {
			return display.getSystemColor(SWT.COLOR_DARK_RED);
		}

		return null;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}


	// Node
	class Node {
		private String title;
		private RentalAgency agency;

		public Node(String title, RentalAgency agency) {
			super();
			this.title = title;
			this.agency = agency;
		}
		
		public Object[] getChildren() {
			if (title == NODE_CUSTOMERS) {
				return agency.getCustomers().toArray();
			}
			else if (title == NODE_RENTAL_OBJECTS) {
				return agency.getObjectsToRent().toArray();
			}
			else if (title == NODE_RENTALS) {
				return agency.getRentals().toArray();
			}

			return null;
		}
		
		@Override
		public String toString() {
			return title;
		}

		public Color getForeround() {
			Display display = Display.getCurrent();

			if (title == NODE_CUSTOMERS) {
				return display.getSystemColor(SWT.COLOR_DARK_BLUE);
			}
			else if (title == NODE_RENTAL_OBJECTS) {
				return display.getSystemColor(SWT.COLOR_DARK_GREEN);
			}
			else if (title == NODE_RENTALS) {
				return display.getSystemColor(SWT.COLOR_DARK_RED);
			}

			return null;
		}

		public Image getImage() {
			if (title == NODE_CUSTOMERS) {
				return RentalUIActivator.getDefault().getImageRegistry().get(IMG_CUSTOMERS);
			}
			else if (title == NODE_RENTAL_OBJECTS) {
				return RentalUIActivator.getDefault().getImageRegistry().get(IMG_RENTAL_OBJECTS);
			}
			else if (title == NODE_RENTALS) {
				return RentalUIActivator.getDefault().getImageRegistry().get(IMG_RENTALS);
			}

			return null;
		}
	}
}
