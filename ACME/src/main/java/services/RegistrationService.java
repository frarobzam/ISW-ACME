/* RegistrationService.java
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

import domain.Announcement;
import domain.Customer;
import domain.Registration;

@Service
@Transactional
public class RegistrationService {
	
	// Managed repository -----------------------------------------------------

	// TODO: Add managed repository.
	
	// Supporting services ----------------------------------------------------

	// TODO: Add supporting services.
	
	// Constructors -----------------------------------------------------------

	public RegistrationService() {
		super();
	}
	
	// Simple CRUD methods ----------------------------------------------------
	
	public Registration createRegistration(Announcement announcement) {
		Registration result;
		
		// TODO: Complete this method. 
		result = null;
		
		return result;
	}

	public void save(Registration registration) {
		// TODO: Complete this method. 
	}
	
	public void delete(Registration registration) {
		// TODO: Complete this method. 
	}
	
	// Business methods -------------------------------------------------------

	public Collection<Registration> findByPrincipal() {
		Collection<Registration> result;

		// TODO: Complete this method. 
		result = null;

		return result;
	}
	
	public boolean existsRegistrationForAnnouncement(Announcement announcement) {
		boolean result;
		
		// TODO: Complete this method. 
		result = false;

		return result;
	}

	public Registration findByCustomerAndAnnouncement(Customer customer, Announcement announcement) {
		Registration result;

		// TODO: Complete this method. 
		result = null;
				
		return result;
	}

}
