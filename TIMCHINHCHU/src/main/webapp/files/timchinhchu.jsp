<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>TIM NHA CHINH CHU</title>
  <meta charset="UTF-8">
  <meta name="description" content="TIM NHA CHINH CHU">
  <meta name="keywords" content="TIM NHA CHINH CHU">
  <meta name="author" content="kosselhuynh">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--====== Favicon Icon ======-->
<link rel="shortcut icon" href="<c:url value="/images/logo.png" />"
	type="image/png">
	

<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
 <script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href=" https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">

<link rel="stylesheet"	href="http://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<!-- <script	src="https://code.jquery.com/jquery-3.3.1.js"></script> -->
<script	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script	src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.4/moment.min.js"></script>
<script	src="http://cdn.datatables.net/plug-ins/1.10.20/sorting/datetime-moment.js"></script>

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

h1 {
  color: red;
}
a {
    color: #000000;
    text-decoration: none;
    background-color: transparent;
}
</style>

<script type="text/javascript">

$(document).ready(function() {
	var table = $('#filestable').DataTable( {
		searching:false,
		pageLength: 15,
 		bInfo: false,
		lengthChange: false,
	    ajax: {
	        url: '/fileshome',
	        dataSrc: ''
	    },
	    columns: [
	    	{
                data:           "id",
            },
			{
    			data:'subject'

			},
			{data:'priceString'},
			{
				data:'phone',

			},
			{
				data:'dateUpload'

			}
	     ],

	} );
	// Add event listener for opening and closing details
    $('#filestable tbody').on('click', 'td', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );
} );

/* Formatting function for row details - modify as you need */
function format ( data ) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td width="15%">Địa chỉ:</td>'+
            '<td>'+data.address+'; '+data.wardName+'; '+data.areaName+'; '+data.regionName+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td width="15%">Người đăng:</td>'+
            '<td>'+data.accountName+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td width="15%">Loại nhà:</td>'+
        '<td>'+data.typeName+'</td>'+
    '</tr>'+
        '<tr>'+
        '<td width="15%">Thông tin:</td>'+
       		 '<td>'+data.body+'</td>'+
    	'</tr>'+
        '<tr width="15%">'+
            '<td>Số của mối giới:</td>'+
            '<td><a href = "'+data.phone+'" id="'+data.phone+'">Yêu cầu xóa</a></td>'+
        '</tr>'+
    '</table>';
}
</script>
</head>

<body>

<!-- MENU -->
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <a class="navbar-brand" href="files">
      <img src="<c:url value="/images/logo.png" />" height="30" width="30">REE SOFTWARE FOR EVERYONE
      </a>
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
         <button type="button" class="btn btn-info-menu" style="float: right;">
			<i class="fa fa-user" aria-hidden="true"></i>
			<a href="register">Đăng ký</a>
		</button>
		<button type="button" class="btn btn-info-menu" style="float: right;">
			<i class="fas fa-key" aria-hidden="true"></i>
			<a href="login">Đăng nhập</a>
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
		            <h4 class="text-center">FIND <img src="<c:url value="/images/logo.png" />" height="30" width="30">REE SOFTWARE</h4>
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
		                        <div class="col-lg-4 col-md-4 col-sm-12 p-0">
		                            <input type="text" class="form-control search-slt" placeholder="Enter name software" id="nameSearch" name="nameSearch">
		                        </div>
								<div class="col-lg-2 col-md-2 col-sm-12 p-0">
		                            <select class="form-control search-slt" id="catalogy" name="catalogy" onchange="location = this.value;">
		                                <option>Toàn quốc</option>
		                                    <c:forEach var = "i" begin = "1" end = "${tinhTP.size()}">
											          <option value="${i}">${tinhTP.get(i)}</option>
											      </c:forEach>
									 </select>
		                        </div>
		                        <div class="col-lg-2 col-md-2 col-sm-12 p-0">
		                            <select class="form-control search-slt" id="catalogy" name="catalogy">
		                                <option>Chọn quận, huyện </option>
		                                	<c:if test="${listAreaName.size() > 0}">
				                                <c:forEach var = "i" begin = "0" end = "${listAreaName.size() - 1}">
											          <option>${listAreaName.get(i)}</option>
											      </c:forEach>
									      </c:if>
		                            </select>
		                        </div>
		                        
		                        <div class="col-lg-2 col-md-2 col-sm-12 p-0">
		                            <button type="submit" class="btn btn-danger wrn-btn">Search</button>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </form>
		    </div>
		</section>
		<p></p>
	
<!-- END SEARCH -->

<!-- START TABLE -->
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-striped table-bordered" id="filestable">
					<thead>
						<tr>
							<th>STT</th>
							<th>Tiêu đề</th>
							<th>Giá</th>
							<th>Số điện thoại</th>
							<th>Ngày đăng tin</th>
						</tr>
					</thead>
				</table>
				<hr>
			</div>
		</div>
<!-- END TABLE -->
	</div>

</body>
</html>



