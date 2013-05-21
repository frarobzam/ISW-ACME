/* CertificationService.java
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.CertificationRepository;
import domain.Certification;

@Service
@Transactional
public class CertificationService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private CertificationRepository certificationRepository;

	// Supporting services ----------------------------------------------------

	// TODO: Add supporting services.

	// Constructors -----------------------------------------------------------

	public CertificationService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Collection<Certification> findAll() {
		Collection<Certification> result;

		result = certificationRepository.findAll();

		return result;
	}

	// Other business methods -------------------------------------------------

	public Collection<Certification> findAllActive() {
		Collection<Certification> result;

		result = certificationRepository.findAllActive();

		assert result != null;
		
		return result;
	}

}