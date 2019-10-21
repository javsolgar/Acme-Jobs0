<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.gonzalezbulletin.list.label.dni" path="dni" width="40%"/>	
	<acme:list-column code="anonymous.gonzalezbulletin.list.label.name" path="name" width="30%"/>
	<acme:list-column code="anonymous.gonzalezbulletin.list.label.surname" path="surname" width="30%"/>
</acme:list> 