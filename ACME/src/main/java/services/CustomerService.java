/* CustomerService.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import security.UserAccount;
import domain.Customer;

@Service
@Transactional
public class CustomerService {

	// Managed repository -----------------------------------------------------

	// TODO: Add managed repository
	
	// Supporting services ----------------------------------------------------
	
	// TODO: Add supporting services
		
	// Constructors -----------------------------------------------------------

	public CustomerService() {
		super();
	}
	
	// Simple CRUD methods ----------------------------------------------------

	public Customer create() {
		Customer result;

		// TODO: Complete this method.
		result = null;

		return result;
	}

	public Collection<Customer> findAll() {
		Collection<Customer> result;

		// TODO: Complete this method.
		result = null;

		return result;
	}

	public Customer findOne(int customerId) {
		Customer result;

		// TODO: Complete this method.
		result = null;

		return result;
	}

	public void save(Customer customer) {
		// TODO: Complete this method.		
	}

	public void delete(Customer customer) {
		// TODO: Complete this method.		
	}

	// Other business methods -------------------------------------------------
	
	public Customer findByPrincipal() {
		Customer result;
		
		// TODO: Complete this method.
		result = null;

		return result;
	}
	
	public Customer findByUserAccount(UserAccount userAccount) {
		Customer result;
		
		// TODO: Complete this method.
		result = null;		

		return result;
	}
	
	public void registerPrincipal(int announcementId) {
		// TODO: Complete this method.		
	}
	
	public void unregisterPrincipal(int announcementId) {
		// TODO: Complete this method.
	}

}