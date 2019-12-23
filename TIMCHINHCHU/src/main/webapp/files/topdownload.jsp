<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>FREE SOFTWARE FOR EVERYONE</title>
<!--====== Favicon Icon ======-->
<link rel="shortcut icon" href="<c:url value="/images/logo.png" />"
	type="image/png">
	
<meta charset="UTF-8">
  <meta name="description" content="FREE SOFTWARE FOR EVERYONE">
  <meta name="keywords" content="FREE SOFTWARE, FREESOFT, FULL CRACK">
  <meta name="author" content="kosselhuynh">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<!-- <script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> -->
<!-- <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->
<link rel="stylesheet" href=" https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">

<link rel="stylesheet"	href="http://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<script	src="https://code.jquery.com/jquery-3.3.1.js"></script>
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
</style>
<script type="text/javascript">

$(document).ready(function() {
	var table = $('#filestable').DataTable( {
		searching:false,
		pageLength: 15,
 		bInfo: false,
		lengthChange: false,
	    ajax: {
	        url: '/filestopdownload',
	        dataSrc: ''
	    },
	    columns: [
	    	{
                "className":      'details-control',
                "orderable":      false,
                data:           "catalogy",
                render: function (data, type, row, meta ) {
					return  '<img src=/images/'+data+'.png width="30" height="30">';
		  		},
		  		/* <img src="pic_trulli.jpg" alt="Trulli" width="500" height="333"> */
                "defaultContent": ''
                    
            },
			{data:'name'},
			{data:'size'},
			{
				data:'downloads',
				render: function (data, type, row, meta ) {
							return data + '<span style="color: #6464b1;font-size: 11px;font-style: italic;"> Downloads</span>';
				  		}
			},
			{
				data:'dateUpload'
	
			}
	     ],
	     columnDefs:[
	         {
	           targets:4, render:function(data){
	             return moment(data).format('MMMM Do YYYY'); 
	           }
	         }
	       ]
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
            '<td>Name:</td>'+
            '<td>'+data.name+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Size:</td>'+
            '<td>'+data.size+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Download link:</td>'+
            '<td><a href = "'+data.id+'" id="'+data.id+'">Download</a></td>'+
        '</tr>'+
    '</table>';
}
</script>
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
		                                <option>OPERATOR_SYSTEM</option>
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
		<p></p>
	
<!-- END SEARCH -->
<!-- STRAT FILES HOT -->
<div style="background-color:lightblue">
  <h3 style="color:red">Hot files share </h3>
  </br>
<div class="blockquote text-center" style="text-align: justify; display:block;">
<a href = "https://caodang7eduvn-my.sharepoint.com/:f:/g/personal/nghienphim_club_caodang7_edu_vn/Erurl6_Q0wFKiGHYAWmeAqgBJIv9Joo7cUH40flRquhcpw?e=ajOLDq">SPRING MVC - ANGULAR - KALI</a><br>
<a href = "https://ez4linkss.com/st?api=48d62de687b299c7bdcf23f9895928e092e813b1&url=https://caodang7eduvn-my.sharepoint.com/:u:/g/personal/nghienphim_club_caodang7_edu_vn/ESvlVSVstYdFhk20AG5_7zMBZzzNsXh_NgjR5dtxnClzig?e=P5kjAX">Windows 10 Pro 19H2 X64 incl Office 2019 en-US NOV 2019 {Gen2} - (Setup Win 10 newest + Office 2019 cracked)</a>
</div>
</div>
<p></p>
<!-- END FILES HOT -->
<!-- START TABLE -->
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-striped table-bordered" id="filestable">
					<thead>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Size</th>
							<th>Downloads</th>
							<th>Date Upload</th>
						</tr>
					</thead>
			<%-- 		<tbody>
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
					</tbody> --%>
				</table>
				<hr>
			</div>
		</div>
<!-- END TABLE -->
	</div>

</body>
</html>



