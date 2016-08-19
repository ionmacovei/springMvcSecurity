
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%@ include file="../menu.jsp" %>
<div class="login-page">
  <div class="form">
                                                                                          <%--value="j_spring_security_check" fara slash--%>
    <form class="login-form" id="formSignIn" <%--action="/signin"--%> action="<c:url value='j_spring_security_check' />" method="post">
      <input type="text" placeholder="username" name="username"/>
      <input type="password" placeholder="password" name="password" />
      <button> Logare</button>

      <p class="message">
       <!--  <a href="/registration">Inregistrare</a>  --></p>
    </form>
  </div>
</div>
</body>
</html>