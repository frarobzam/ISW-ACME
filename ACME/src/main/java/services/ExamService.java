/* ExamService.java
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

import repositories.ExamRepository;
import domain.Exam;

@Service
@Transactional
public class ExamService {

	// Managed repository -----------------------------------------------------

	// FIXME ¿No es más sencillo acceder a la certificación y conseguir sus
	// exámenes?
	@Autowired
	private ExamRepository examRepository;

	// Supporting services ----------------------------------------------------

	// Constructors -----------------------------------------------------------

	public ExamService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	// Other business methods -------------------------------------------------

	public Collection<Exam> getExams(int certificationId) {
		Collection<Exam> result;

		result = examRepository.findByCertificationId(certificationId);

		return result;
	}

}