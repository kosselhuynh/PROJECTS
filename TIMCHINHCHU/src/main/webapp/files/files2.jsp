<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>FREE SOFTWARE FOR EVERYONE</title>
<!--====== Favicon Icon ======-->
<link rel="shortcut icon" href="<c:url value="/images/favicon.png" />"
	type="image/png">
	
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
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
</style>

</head>

<body>
<!-- MENU -->
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <a class="navbar-brand" href="files">FREE SOFTWARE FOR EVERYONE</a>
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
<!--           <li class="nav-item"> -->
<!--             <a class="nav-link" href="upload">Upload</a> -->
<!--           </li> -->
        </ul>
<!--         <button type="button" class="btn btn-info-menu"> -->
<!--         	<i class="fa fa-search" aria-hidden="true"></i> -->
<!-- 			<a href="register">Register</a> -->
<!-- 		</button> -->
<!-- 		<li></li> -->
		<button type="button" class="btn btn-info-menu">
			<i class="fa fa-user" aria-hidden="true"></i>
			<a href="login">Login</a>
		</button>
      </div>
    </nav>
<hr class="new">
<!-- END MENU -->
<!-- START SEARCH -->
	<div class="container">
		<div class="container">
		    <div class="row pt-1 pb-1">
		        <div class="col-lg-12">
		            <h4 class="text-center">FIND FREE SOFTWARE</h4>
		            <h6 class="text-center">Always update new software</h6>
		            <p></p>
		        </div>
		    </div>
		</div>
		
		<section class="search-sec">
		    <div class="container">
		        <form action="actionFormSearch" method="GET" novalidate="novalidate">
		            <div class="row">
		                <div class="col-lg-12">
		                    <div class="row">
		                    	<div class="col-lg- col-md-3 col-sm-12 p-0">
		                            
		                        </div>
		                        <div class="col-lg-4 col-md-4 col-sm-12 p-0">
		                            <input type="text" class="form-control search-slt" placeholder="Enter name software" name="nameSearch">
		                        </div>
		                   
		                        <div class="col-lg-2 col-md-2 col-sm-12 p-0">
		                            <select class="form-control search-slt" id="catalogy" name="catalogy">
		                                <option>Select catalogies</option>
		                                <option>ANTIVIRUS</option>
		                                <option>DRIVER</option>
		                                <option>OFFICE</option>
		                                <option>OPERATOR SYSTEM</option>
		                                <option>PROGRAMER</option>
		                                <option>SCIENCE</option>
		                                <option>MULTIMEDIA</option>
		                                <option>GRAPHICS</option>
		                                <option>GAMES</option>
		                                <option>NETWORK</option>
		                                <option>INTERNET</option>
		                                <option>ORTHER</option>
		                            </select>
		                        </div>
		                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
		                            <button type="submit" class="btn btn-danger wrn-btn">Search</button>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </form>
		    </div>
		</section>
		<p style="color:red;">${errors }</p>
	
<!-- END SEARCH -->
<!-- START TABLE -->
		<div class="row">
			<div class="col-lg-12">
				<table class="table" id="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Size</th>
							<th>Downloads</th>
							<th>Date Upload</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="file" items="${files }">
							<tr>
								<td><a href = "${file.id}" id="${file.id}">${file.name }</a></br>
									<span style="color: #6464b1;font-size: 11px;font-style: italic;">Catalogy : ${file.catalogy }</span>
								</td>
								<td>${file.size }</td>
								<td>
									${file.downloads }
									<span style="color: #6464b1;font-size: 11px;font-style: italic;"> downloads</span>
								</td>
								<td>
									
									<fmt:formatDate value="${file.dateUpload }" pattern="dd/MM/yyyy"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<hr>
			</div>
		</div>
<!-- END TABLE -->
	</div>

</body>
</html>



