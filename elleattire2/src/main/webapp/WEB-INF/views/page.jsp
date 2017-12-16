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

<div class="wrapper">
    
   <!-- NAVIGATION -->
   <%@include file = "./shared/navbar.jsp" %>

	   <!-- PAGE CONTENT -->

		<div class="content">

			<!-- LOADING THE HOME CONTENT -->

			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- LOAD ONLY IF USER CLICKS ABOUT -->
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- LOAD ONLY IF USER CLICKS CONTACT -->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<%-- <c:if test="${userClickLogin == true }">
				<%@include file="login.jsp"%>
			</c:if>

			<c:if test="${userClickRegister == true }">
				<%@include file="register.jsp"%>
			</c:if> --%>
			
			
			<!-- LOAD ONLY IF USER CLICKS list products -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts }">
				<%@include file="listProducts.jsp"%>
			</c:if> 

			<!-- LOAD ONLY IF USER CLICKS Show product -->
			<c:if test="${userClickShowProduct == true }">
				<%@include file="singleProduct.jsp"%>
			</c:if> 
			
			<!-- LOAD ONLY IF USER CLICKS Manage products -->
			<c:if test="${userClickManageProducts == true }">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			
		</div>

		<!-- FOOTER -->
   <%@include file = "./shared/footer.jsp" %>
   

    <!-- JQuery -->
    <script src="${js}/jquery.js"></script>
    
    <!-- BootStrap Core JavaScript -->
    <script src="${js}/bootstrap.js"></script>
    
    <!-- DataTable Plugin -->
    <script src="${js}/jquery.dataTables.js"></script>
    
    <!-- DataTable Bootstrap Script -->
    <script src="${js}/dataTables.bootstrap.js"></script>
    
	<!-- SELF CODED JAVASCRIPT -->
	<script src="${js}/myapp.js"></script>

</div>

</body> 

</html>


