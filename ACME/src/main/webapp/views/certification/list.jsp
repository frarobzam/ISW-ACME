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

<display:table name="certifications" pagesize="5" class="displaytag"
	requestURI="${requestURI}" id="row">

	<display:column property="title" titleKey="certification.title"
		sortable="true" />

	<display:column property="description"
		titleKey="certification.description" sortable="true" />

	<display:column property="extinctionDate"
		titleKey="certification.extinctionDate" format="{0,date,dd/MM/yyyy HH:mm}" />

	<display:column property="fee" titleKey="certification.fee" />

</display:table>