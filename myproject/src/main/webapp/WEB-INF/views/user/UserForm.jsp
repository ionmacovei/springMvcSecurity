<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<c:url value="css/errorClass.css" />" rel="stylesheet">
    
    <%@ include file="../menu.jsp" %>
	<div align="center">
		<h1>New/Edit User</h1>
		<table>
			<form:form action="saveUser" method="post" modelAttribute="user">
			<form:hidden path="id"/>
			<tr>
				<td>Username:</td>
				<td><form:input path="username"/></td>
				<td><form:errors path="username" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email"/></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password"/></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Save">
				</td>
			</tr>			
			</form:form>
		</table>
	</div>
	
</body>
</html>