/* AnnouncementService.java
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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.AnnouncementRepository;
import domain.Announcement;
import domain.Certification;
import domain.Exam;
import domain.Registration;
import domain.Reviewer;

@Service
@Transactional
public class AnnouncementService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private AnnouncementRepository announcementRepository;

	// Supporting services ----------------------------------------------------

	// TODO: Add supporting services.

	// Constructors -----------------------------------------------------------

	public AnnouncementService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Announcement create() {
		Announcement result;
		Reviewer reviewer = new Reviewer();
		Certification certification = new Certification();
		Exam exam = new Exam();
		Set<Registration> registrations = new HashSet<Registration>();

		result = new Announcement();
		result.setReviewer(reviewer);
		result.setCertification(certification);
		result.setDescription("");
		result.setExam(exam);
		result.setRegistrations(registrations);

		return result;
	}

	public Collection<Announcement> findAll() {
		Collection<Announcement> result;

		result = announcementRepository.findAll();

		return result;
	}

	public Announcement findOne(int announcementId) {
		Announcement result;

		result = announcementRepository.findOne(announcementId);

		return result;
	}

	public void save(Announcement announcement) {

		assert announcement != null;

		Date currentDate = new Date();
		Date certificationDate = announcement.getCertification()
				.getExtinctionDate();

		Assert.isTrue(certificationDate.compareTo(currentDate) > 0);

		announcementRepository.save(announcement);

	}

	public void delete(Announcement announcement) {

		assert announcement != null;

		Assert.isTrue(announcement.getRegistrations().isEmpty());
		announcementRepository.delete(announcement.getId());

	}

	// Other business methods -------------------------------------------------

	public Collection<Announcement> findRegistered() {
		Collection<Announcement> result;

		result = announcementRepository.findRegistered();

		return result;
	}

	public Collection<Announcement> findAllActive() {
		Collection<Announcement> result;

		result = announcementRepository.findAllActive();

		return result;
	}

}