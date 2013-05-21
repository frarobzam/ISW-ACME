/* AnnouncementRepository.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Announcement;

@Repository
public interface AnnouncementRepository extends
		JpaRepository<Announcement, Integer> {

	@Query("select a from Announcement a where a.registrations.size > 0 ")
	Collection<Announcement> findRegistered();

	@Query("select a from Announcement a where a.moment > CURRENT_DATE")
	Collection<Announcement> findAllActive();
}
