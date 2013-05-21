/* AbstractController.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public abstract class AbstractController {
	
	// Panic handler ----------------------------------------------------------
	
	@ExceptionHandler(Throwable.class)
	public ModelAndView panic(Throwable oops) {
		assert oops != null;
		
		ModelAndView result;

		result = new ModelAndView("misc/panic");
		result.addObject("name", ClassUtils.getShortName(oops.getClass()));
		result.addObject("exceptionMessage", oops.getMessage());
		result.addObject("stackTrace", ExceptionUtils.getStackTrace(oops));

		return result;
	}
	
	// Transaction management -------------------------------------------------
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	private TransactionStatus txStatus;
	
	protected void beginTransaction() {
		assert txStatus == null;
				
		beginTransaction(false);
	}
	
	protected void beginTransaction(boolean readOnly) {
		assert txStatus == null;
		
		DefaultTransactionDefinition definition; 
			
		definition = new DefaultTransactionDefinition();
		definition.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_DEFAULT);
		definition.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW);
		definition.setReadOnly(readOnly);		
		txStatus = transactionManager.getTransaction(definition);		
	}		
	
	protected void commitTransaction() {
		assert txStatus != null;
		
		try {
			transactionManager.commit(txStatus);
			txStatus = null;
		} catch (Throwable oops) {
			throw oops;
		}		
	}
	
	protected void rollbackTransaction() {
		assert txStatus != null;
		
		try {
			if (!txStatus.isCompleted())
				transactionManager.rollback(txStatus);
			txStatus = null;
		} catch (Throwable oops) {
			throw oops;
		} 
	}

}
