/* AnnouncementCustomerController.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;

@Controller
@Transactional
@RequestMapping("/announcement/customer")
public class AnnouncementCustomerController extends AbstractController {
	
	// Services ---------------------------------------------------------------

	// TODO: Add autowired services. 
	
	// Constructors -----------------------------------------------------------
	
	public AnnouncementCustomerController() {
		super();
	}

	// Listing ----------------------------------------------------------------
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;

		// TODO: Complete this method.
		result = null;

		
		return result;
	}

	// Registration -----------------------------------------------------------
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@RequestParam int announcementId) {
		ModelAndView result;		
				
		// TODO: Complete this method.
		result = null;
		
		return result;
	}
		
	@RequestMapping(value = "/unregister", method = RequestMethod.GET)
	public ModelAndView unregister(@RequestParam int announcementId) {
		ModelAndView result;		
				
		// TODO: Complete this method.
		result = null;
		
		return result;
	}
	
}