package org.niit.ellebackend2.dao;

import java.util.List;

import org.niit.ellebackend2.dto.Address;
import org.niit.ellebackend2.dto.User;

public interface UserDAO {
	// user related operation
		User getByEmail(String email);
		User get(int id);

		boolean add(User user);
		
		// adding and updating a new address
		Address getAddress(int addressId);
		boolean addAddress(Address address);
		boolean updateAddress(Address address);
		Address getBillingAddress(int userId);
		List<Address> listShippingAddresses(int userId);
		
}
