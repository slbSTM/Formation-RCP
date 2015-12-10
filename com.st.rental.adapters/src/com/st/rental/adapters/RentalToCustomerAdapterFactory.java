package com.st.rental.adapters;

import org.eclipse.core.runtime.IAdapterFactory;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;

public class RentalToCustomerAdapterFactory implements IAdapterFactory {

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		if (adaptableObject instanceof Rental) {
			if (adapterType == Customer.class) {
				Customer customer = ((Rental)adaptableObject).getCustomer();
				return (T)customer;
			}
		}

		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[] { Customer.class };
	}

}
