<%--
 * list.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<display:table name="announcements" pagesize="5" class="displaytag"
	requestURI="${requestURI}" id="row">

	<security:authorize access="hasRole('ADMIN')">
		<display:column>
			<a href="announcement/administrator/edit.do?announcementId=${row.id}">
				<spring:message code="announcement.edit" />
			</a>
		</display:column>
	</security:authorize>

	<display:column property="title" titleKey="announcement.title"
		sortable="true" />

	<display:column property="moment" titleKey="announcement.moment"
		sortable="true" format="{0,date,dd/MM/yyyy HH:mm}" />

	<display:column property="description"
		titleKey="announcement.description" />

</display:table>

<security:authorize access="hasRole('ADMIN')">
	<a href="announcement/administrator/create.do"> <spring:message
			code="announcement.create" />
	</a>
</security:authorize>