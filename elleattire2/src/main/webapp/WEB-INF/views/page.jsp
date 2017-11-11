<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<!-- HEADER -->
<%@include file = "./shared/header.jsp" %>

<body>

    
   <!-- NAVIGATION -->
 <%@include file = "./shared/navbar.jsp" %>

    <!-- PAGE CONTENT -->
  
<!-- LOADING THE HOME CONTENT -->

  <c:if test="${userClickHome == true }">
  <%@include file = "home.jsp" %>
    </c:if>
    
  <!-- LOAD ONLY IF USER CLICKS ABOUT -->
     <c:if test="${userClickAbout == true }">
  <%@include file = "about.jsp" %>
    </c:if>
    
  <!-- LOAD ONLY IF USER CLICKS CONTACT -->
    <c:if test="${userClickContact == true }">
  <%@include file = "contact.jsp" %>
    </c:if>
   

    <!-- FOOTER -->
   <%@include file = "./shared/footer.jsp" %>
   

    <!-- JavaScript -->
    <script src="${js}/jquery-1.10.2.js"></script>
    <script src="${js}/bootstrap.js"></script>

</body>

</html>

