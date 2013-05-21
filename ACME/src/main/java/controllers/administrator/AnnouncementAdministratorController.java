/* AnnouncementAdministratorController.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 *
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers.administrator;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AnnouncementService;
import services.CertificationService;
import services.ExamService;
import services.ReviewerService;
import controllers.AbstractController;
import domain.Announcement;
import domain.Certification;
import domain.Exam;
import domain.Reviewer;

@Controller
@Transactional
@RequestMapping("/announcement/administrator")
public class AnnouncementAdministratorController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private AnnouncementService announcementService;
	@Autowired
	private ExamService examService;
	@Autowired
	private CertificationService certificationService;
	@Autowired
	private ReviewerService reviewerService;

	// Constructors -----------------------------------------------------------

	public AnnouncementAdministratorController() {
		super();
	}

	// Listing ----------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Announcement> announcements;

		announcements = announcementService.findAll();
		result = new ModelAndView("announcement/list");
		result.addObject("announcements", announcements);
		result.addObject("requestURI", "announcement/administrator/list.do");

		return result;
	}

	// PRUEBA
	// Creation ---------------------------------------------------------------

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Announcement announcement;
		announcement = announcementService.create();
		result = createEditModelAndView(announcement);
		return result;
	}

	// Edition ----------------------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int announcementId) {
		ModelAndView result;

		Announcement announcement;
		// Is there any restriction?
		announcement = announcementService.findOne(announcementId);
		result = createEditModelAndView(announcement);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Announcement announcement,
			BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(announcement);
		} else {
			try {
				beginTransaction();
				announcementService.save(announcement);
				commitTransaction();
				// Required int parameter 'announcementId' is not present
				result = new ModelAndView("redirect:edit.do"
						+ "?announcementId=" + announcement.getId());
				// result = new ModelAndView("redirect:list.do");
			} catch (Throwable oops) {
				rollbackTransaction();
				result = createEditModelAndView(announcement,
						"announcement.commit.error");
			}
		}
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(Announcement announcement, BindingResult binding) {
		ModelAndView result;

		try {
			beginTransaction();
			announcementService.delete(announcement);
			commitTransaction();
			result = new ModelAndView("redirect:edit.do");
		} catch (Throwable oops) {
			rollbackTransaction();
			result = createEditModelAndView(announcement,
					"announcement.commit.error");
		}

		return result;
	}

	// Ancillary methods ------------------------------------------------------

	protected ModelAndView createEditModelAndView(Announcement announcement) {
		ModelAndView result;

		Collection<Certification> certifications = certificationService
				.findAll();
		Collection<Reviewer> reviewers = reviewerService.findAll();

		Certification certification = announcement.getCertification();

		Integer certificationId = certification.getId();
		Collection<Exam> exams = examService.getExams(certificationId);

		result = createEditModelAndView(announcement, null);

		result.addObject("certifications", certifications);
		result.addObject("reviewers", reviewers);
		result.addObject("exams", exams);

		return result;
	}

	protected ModelAndView createEditModelAndView(Announcement announcement,
			String message) {

		assert announcement != null;

		ModelAndView result;

		Collection<Certification> certifications = certificationService
				.findAll();
		Collection<Reviewer> reviewers = reviewerService.findAll();

		Certification certification = announcement.getCertification();

		Integer certificationId = certification.getId();
		Collection<Exam> exams = examService.getExams(certificationId);

		result = new ModelAndView("announcement/edit");
		result.addObject("announcement", announcement);
		result.addObject("certifications", certifications);
		result.addObject("reviewers", reviewers);
		result.addObject("exams", exams);
		
		result.addObject("message", message);

		return result;
	}

}
