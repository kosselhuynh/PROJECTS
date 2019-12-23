<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="shortcut icon" href="<c:url value="/images/logo.png" />"
	type="image/png">
<meta charset="UTF-8">
  <meta name="description" content="FREE SOFTWARE FOR EVERYONE">
  <meta name="keywords" content="FREE SOFTWARE, FREESOFT, FULL CRACK">
  <meta name="author" content="kosselhuynh">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href=" https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">

<style>
.input-group.md-form.form-sm.form-1 input {
	border: 1px solid #bdbdbd;
	border-top-right-radius: 0.25rem;
	border-bottom-right-radius: 0.25rem;
}

.btn-info-menu {
	background-color: #f8f9fa;
	border-color: #e18fe4;
}
hr.new {
	margin-top: 0rem;
    border: 2px solid red;
}
.jumbotron {
    padding: 2rem 1rem;
    margin-bottom: 2rem;
    background-color: #d237c230;
    border-radius: .3rem;
}
</style>
</head>

<body>
<!-- MENU -->
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <a class="navbar-brand" href="files"><img src="<c:url value="/images/logo.png" />" height="30" width="30">REE SOFTWARE FOR EVERYONE</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample03">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="topdownloads">Top Downloads</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="trending">Trending</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contact">Contact</a>
          </li>
        </ul>
		<button type="button" class="btn btn-info-menu">
			<i class="fa fa-user" aria-hidden="true"></i>
			<a href="login">Login</a>
		</button>
      </div>
    </nav>
<hr class="new">
<!-- END MENU -->


 <!--====== CONACT PART START ======-->
    
  <div class="jumbotron jumbotron-sm">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <h1 class="h1">
                    Contact us </h1>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="well well-sm">
                <form:form action="actionSendMail" modelAttribute="contact">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Full Name</label>
                            <form:input type="text" class="form-control" id="name" placeholder="Enter full name" required="required" path="fullname" />
                        </div>
                        <div class="form-group">
                            <label for="email">
                                Email Address</label>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <form:input type="email" class="form-control" id="email" placeholder="Enter email" required="required" path="email"/></div>
                        </div>
                        <div class="form-group">
                            <label for="subject">
                                Subject</label>
                            <form:select id="subject" name="subject" class="form-control" required="required" path="subject">
                                <form:option value="na" selected="">Choose One:</form:option>
                                <form:option value="software">I need find software</form:option>
                                <form:option value="uploader">Uploader</form:option>
                            </form:select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Message</label>
                            <form:textarea name="message" id="message" class="form-control" rows="9" cols="25" required="required"
                                placeholder="Message" path="message"></form:textarea>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary pull-right" id="btnContactUs">
                            Send Message</button>
                            <span style="color:blue;font-weight:bold">${messagereturn}</span>
                    </div>
                    
                </div>
                </form:form>
            </div>
        </div>
        <div class="col-md-4">
            <form>
            <legend><i class="fas fa-paint-brush"></i> DESIGNER</legend>
            <address>
                <strong>Spring Framework</strong><br>
                <img src="<c:url value="/images/logo.png" />" height="30" width="30">ree software for everyone<br>
            </address>
            <address>
                <strong>Email</strong><br>
                <a href="mailto:#">kosselhuynh@gmail.com</a>
            </address>
            </form>
        </div>
    </div>
</div>

    
    <!--====== CONACT PART ENDS ======-->

</body>
</html>