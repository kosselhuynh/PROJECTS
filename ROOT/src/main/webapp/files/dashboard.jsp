<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
.form-control-dashboard {
    display: block;
    /* width: 100%; */
    height: calc(1.5em + .75rem + 2px);
    padding: .375rem .75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #495057;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    border-radius: .25rem;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</style>
</head>

<body>
${email}

<c:url value="/uploadExcelFile" var="uploadFileUrl" />
<form method="post" enctype="multipart/form-data"
  action="${uploadFileUrl}">
    <input type="file" name="file" accept=".xls,.xlsx" /> 
    <input type="submit" value="Upload file" /> <a class="nav-link" href="files">Home</a>
</form>
${message}
<!-- Count Catalogy -->
 <table>
	  <tr>
		  <c:forEach var="i" begin="0" end="${listCountCatalogy.size()-1}">
			<th><c:out value = "${listCountCatalogy.get(i).getCatalogy()}"/></th>
		</c:forEach>
	  </tr>
	  <tr>
		  <c:forEach var="j" begin="0" end="${listCountCatalogy.size()-1}">
			<td><c:out value = "${listCountCatalogy.get(j).getCount()}"/></td>
		</c:forEach>
	  </tr>
 </table> 
 <p></p>
 <table>
	  <tr>
		  	<th>Name Search</th>
			<th>Number Search</th>
			<th>Date Search</th>
	  </tr>
	   <c:forEach var="i" begin="0" end="${listTrending.size()-1}">
	  <tr>
		 
			<th><c:out value = "${listTrending.get(i).getNameSearch()}"/></th>
			<th><c:out value = "${listTrending.get(i).getNumberSearch()}"/></th>
			<th><c:out value = "${listTrending.get(i).getDateSearch()}"/></th>
		
	  </tr>
	  </c:forEach>
 </table> 
 

<p></p>
<!-- Get Message  -->
<div class="row">
			<div class="col-lg-12">
				<table class="table" id="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>FULLNAME</th>
							<th>EMAIL</th>
							<th>SUBJECT</th>
							<th>MESSAGE</th>
							<th>DATE SEND</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="contact" items="${contacts }">
							<tr>
								<td>${contact.id }</td>
								<td>${contact.fullname }</td>
								<td>${contact.email }</td>
								<td>${contact.subject }</td>
								<td>${contact.message }</td>
								<td>${contact.dateSend }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<hr>
			</div>
		</div>
</body>
</html>