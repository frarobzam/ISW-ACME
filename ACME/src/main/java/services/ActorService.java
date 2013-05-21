/* ActorService.java
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

import repositories.ActorRepository;
import security.UserAccount;
import security.UserAccountRepository;
import domain.Actor;

@Service
@Transactional
public class ActorService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private ActorRepository actorRepository;

	// Supporting services ----------------------------------------------------

	@Autowired
	private UserAccountRepository userAccountRepository;

	// Constructors -----------------------------------------------------------

	public ActorService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Collection<Actor> findAll() {
		Collection<Actor> result;

		result = actorRepository.findAll();

		return result;
	}

	public Actor findOne(int actorId) {
		Actor result;

		result = actorRepository.findOne(actorId);

		return result;
	}

	public void save(Actor actor) {
		assert actor != null;

		actorRepository.save(actor);
	}

	public void delete(Actor actor) {
		assert actor != null;

		actorRepository.delete(actor.getId());
	}

	// Other business methods -------------------------------------------------

	public UserAccount findUserAccount(Actor actor) {

		assert actor != null;

		UserAccount result;

		result = userAccountRepository.findByActorId(actor.getId());

		assert result != null;

		return result;
	}
}