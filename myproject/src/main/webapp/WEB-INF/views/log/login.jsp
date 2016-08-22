
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<html>
<head>
<link href="<c:url value="css/login.css" />" rel="stylesheet">
<title>Login Page</title>
</head>
<body >

	<h1>Spring Security Login Form (Database + Hibernate Authentication)</h1>

	<div id="login-box">

		<h3>Login with Username and Password</h3>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

	   <form class="login-form" id="formSignIn" <%--action="/signin"--%> action="<c:url value='./' />" method="post">
      <input type="text" placeholder="username" name="username"/>
      <input type="password" placeholder="password" name="password" />
      <button> Logare</button>

      
    </form>	</div>

</body>
</html>