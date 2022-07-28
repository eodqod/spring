<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">
		<a href="${pageContext.request.contextPath}/welcome">Home</a> | 
		<a href="${pageContext.request.contextPath}/addNewEmployee">Add Employee</a> |
		<a href="${pageContext.request.contextPath}/getEmployees">Show Employees</a> |
		   
		<a onclick="document.forms['logoutForm'].submit()" style="color: red;font-size: 13pt;cursor: pointer;">Logout</a>
	    <form id="logoutForm" method="POST" action="${contextPath}/logout"></form>
	</div>
