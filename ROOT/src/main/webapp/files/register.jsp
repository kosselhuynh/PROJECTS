<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<link rel="shortcut icon" href="<c:url value="/images/favicon.pngG" />"
	type="image/png">

<!--====== Title ======-->

<!--====== Favicon Icon ======-->
<link rel="shortcut icon" href="<c:url value="/images/logo.png" />"
	type="image/png">

<!--======css ======-->
<link href="<c:url value="/css/owl.carousel.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/css/magnific-popup.css" />" rel="stylesheet">
<link href="<c:url value="/css/slick.css" />" rel="stylesheet">
<link href="<c:url value="/css/nice-select.css" />" rel="stylesheet">
<link href="<c:url value="/css/jquery.nice-number.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/css/default.css" />" rel="stylesheet">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/responsive.css" />" rel="stylesheet">

<style>
		.error {color:red}
	</style>
</head>
<body>
	<!--====== LOGIN PART START ======-->
<form:form action="actionRegister" modelAttribute="user">	
		<div id="login-part" class="pt-85 pb-80">
			<div class="container">
				<div class="row no-gutters justify-content-center">
					<div class="col-xl-4 col-lg-5 col-md-7 col-sm-10">
						<div class="login-form text-center">
							<div class="logo mb-50">
<%-- 								<a href="#"><img src="<c:url value="/images/logo.png" />" --%>
<!-- 									alt="Logo"></a> -->
									<span style="color:blue;font-weight:bold">FREE SOFTWARE FOR EVERYONE</span>
							</div>
							
								<div class="singel-form">
									<form:input path="fullname" placeholder="Full Name ..." />
									<form:errors path="fullname" cssClass="error" />
								</div>
								<div class="singel-form">
									<form:input  path="email" placeholder="Enter your email...." />
									<form:errors path="email" cssClass="error" />
								</div>
								<div class="singel-form">
									<form:input path="password" placeholder="Enter your Password...." type="password"/>
									<form:errors path="password" cssClass="error" />
								</div>
								<div class="singel-form">
									<form:input path="confirmPassword" placeholder="Enter your comfirmPassword..." type="password"/>
									<form:errors path="confirmPassword" cssClass="error" />
								</div>
<!-- 								<div class="singel-form"> -->
<!-- 									<p>or</p> -->
<!-- 									<ul class="social-loogin pt-15"> -->
<!-- 										<li><a href="#"><i class="fa fa-facebook-f"></i>Facebook</a></li> -->
<!-- 										<li><a href="#"><i class="fa fa-google-plus"></i>Google</a></li> -->
<!-- 									</ul> -->
<!-- 								</div> -->
								<div class="singel-form pt-30">
									<button type="submit">Join Now</button>
								</div>
								<a href="files">Back</a>
<!-- 								<div class="singel-form pt-25"> -->
<!-- 									<ul class="remember"> -->
<!-- 										<li><input type="checkbox" name="checkbox" id="checkbox"> -->
<!-- 											<label for="checkbox"><span></span>Remember Me</label></li> -->
<!-- 										<li> -->
<!-- 											<p> -->
<!-- 												Forgot <a href="#">password?</a> -->
<!-- 											</p> -->
<!-- 										</li> -->
<!-- 									</ul> -->
<!-- 								</div> -->
							
						</div>
					</div>
				</div>
			</div>
		</div>
</form:form>
	<!--====== LOGIN PART ENDS ======-->
</body>
</html>
