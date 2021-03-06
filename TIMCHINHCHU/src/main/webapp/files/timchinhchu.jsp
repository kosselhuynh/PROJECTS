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
<link rel="stylesheet"	href="http://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
 <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
 <script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href=" https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">


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
		order : [[4,"desc"]],
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
				data:'dateUploadConvert'

			}
	     ],
	     columnDefs:[
	         {
	           targets:4, render:function(data){
	        	   return moment(data).format('YYYY-MM-DD HH:mm:ss'); // return moment(data).format('HH:MM:ss DD/MM/YYYY'); 
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


    $('#btnDelete').click(function() {
        bootbox.confirm("Are you sure want to delete?", function(result) {
          alert("Confirm result: " + result);
        });
      });
    
} );



/* Formatting function for row details - modify as you need */
function format ( data ) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;background-color: #97e1ff;">'+
        '<tr>'+
            '<td width="15%">Địa chỉ:</td>'+
            '<td>'+data.address+'; '+data.wardName+'; '+data.areaName+'; '+data.regionName+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td width="15%">Người đăng:</td>'+
            '<td>'+data.accountName+'</td>'+
        '</tr>'+
        '<tr>'+
        '<td width="15%">Pháp lý và Hướng nhà:</td>'+
        '<td>'+data.propertyLegalDocument+'/' +data.direction+ '</td>'+
    '</tr>'+
        '<tr>'+
        '<td width="15%">Thông tin:</td>'+
       		 '<td>'+data.body+'</td>'+
    	'</tr>'+
        '<tr width="15%">'+
            '<td>Số của mối giới:</td>'+
//             '<td><a href = "'+data.phone+'" id="'+data.phone+'">Yêu cầu xóa</a></td>'+
				'<td><a data-href="'+data.phone+'" data-toggle="modal" data-target="#confirm-delete" class="btn btn-primary"> Đây là số của môi giới </a></td>'+
        '</tr>'+
    '</table>';
}


</script>


<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Xác nhận</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
                </div>
                <div class="modal-body">
                    <p>Đây là số điện thoại của môi giới</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                    	Đóng
                    </button>
                 	<a class="btn btn-danger btn-ok" style="padding: 6px 10px;">Đồng ý</a>
                </div>
            </div>
        </div>
</div> 


 <script>
 $('#confirm-delete').on('show.bs.modal', function(e) {
	 var data = $(e.relatedTarget).data();
     $('.title', this).text(data.recordTitle);
     $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
 });
    </script>

</head>


<body>
<!-- MENU -->
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <a class="navbar-brand" href="files">
      <img src="<c:url value="/images/logo.png" />" height="30" width="30">ÌM CHÍNH CHỦ
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample03">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="backupsdtco">Backup SDT</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="backuptansuat">Backup Tan Suat</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="test">aaa</a>
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
		            <h4 class="text-center"><img src="<c:url value="/images/logo.png" />" height="30" width="30">ÌM CHÍNH CHỦ</h4>
		            <h6 class="text-center">Cập nhật liên tục thông tin nhà đất toàn quốc</h6>
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
		                        
								<div class="col-lg-2 col-md-2 col-sm-12 p-0">
		                            <select style="font-family: 'FontAwesome', Arial;" class="form-control search-slt" id="tinhthanhpho" name="tinhthanhpho" onchange="location = this.value;">
		                                <c:if test="${khuvuc != null}">
		                                	<option>${khuvuc}</option>
		                                </c:if>
		                                <c:if test="${khuvuc == null}">
		                                	<option>&#xf041;  Toàn quốc</option>
		                                </c:if>
		                                    <c:forEach var = "i" begin = "1" end = "${tinhTP.size()}">
											          <option value="${i}">${tinhTP.get(i)}</option>
											      </c:forEach>
									 </select>
		                        </div>
		                        <div class="col-lg-2 col-md-2 col-sm-12 p-0">
		                            <select style="font-family: 'FontAwesome', Arial;" class="form-control search-slt" id="quanhuyen" name="quanhuyen">
		                                <option>&#xf02c; Chọn quận huyện ...</option>
		                                	<c:if test="${listAreaName.size() > 0}">
				                                <c:forEach var = "i" begin = "0" end = "${listAreaName.size() - 1}">
											          <option>${listAreaName.get(i)}</option>
											      </c:forEach>
									      </c:if>
		                            </select>
		                        </div>
								<div class="col-lg-2 col-md-2 col-sm-12 p-0">
		                            <select style="font-family: 'FontAwesome', Arial;" class="form-control selectpicker test" id="loai" name="loai">
		                            <option>&#xf015; Chọn loại ...</option>
									  <optgroup label="Cần bán">
									    <c:if test="${arrayNhatDat_CanBan.size() > 0}">
				                                <c:forEach var = "i" begin = "0" end = "${arrayNhatDat_CanBan.size() - 1}">
											          <option>${arrayNhatDat_CanBan.get(i)}</option>
											      </c:forEach>
									      </c:if>
									  </optgroup>
									  <optgroup label="Cần mua">
									    <c:if test="${arrayNhatDat_CanMua.size() > 0}">
				                                <c:forEach var = "i" begin = "0" end = "${arrayNhatDat_CanMua.size() - 1}">
											          <option>${arrayNhatDat_CanMua.get(i)}</option>
											      </c:forEach>
									      </c:if>
									  </optgroup>
									  <optgroup label="Cho thuê">
									    <c:if test="${arrayNhatDat_ChoThue.size() > 0}">
				                                <c:forEach var = "i" begin = "0" end = "${arrayNhatDat_ChoThue.size() - 1}">
											          <option>${arrayNhatDat_ChoThue.get(i)}</option>
											      </c:forEach>
									      </c:if>
									  </optgroup>
									  <optgroup label="Cần thuê">
									    <c:if test="${arrayNhatDat_CanThue.size() > 0}">
				                                <c:forEach var = "i" begin = "0" end = "${arrayNhatDat_CanThue.size() - 1}">
											          <option>${arrayNhatDat_CanThue.get(i)}</option>
											      </c:forEach>
									      </c:if>
									  </optgroup>
									</select>
		                        </div>
								<div class="col-lg-3 col-md-3 col-sm-12 p-0">
		                            <input type="text" class="form-control search-slt" placeholder="Nhập thông tin cần tìm" id="tutimkiem" name="tutimkiem">
		                        </div>
		                        <div class="col-lg-2 col-md-2 col-sm-12 p-0">
		                            <button type="submit" class="btn btn-danger wrn-btn">
		                            <i class="fas fa-key" aria-hidden="true"></i>
		                            Tìm kiếm
		                            
		                            </button>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </form>
		    </div>
		</section>
		<p></p>
	
<!-- END SEARCH -->
<!-- ADVAN SEARCH -->
<!-- <p> -->
<!--   <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample"> -->
<!--     Tìm kiếm nâng cao -->
<!--   </a> -->
<!--   <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample"> -->
<!--     Button with data-target -->
<!--   </button> -->
<!-- </p> -->
<!-- <div class="collapse" id="collapseExample"> -->
<!--   <div class="card card-body"> -->
<!--   	<div class="col-lg-2 col-md-2 col-sm-10 p-0"> -->
<!-- 		<select class="form-control search-slt" id="chuyenmuc" name="chuyenmuc"> -->
<!-- 		     <option>Chọn chuyên mục ...</option> -->
<%-- 		     <c:if test="${listCatalogyName.size() > 0}"> --%>
<%-- 			      <c:forEach var = "i" begin = "0" end = "${listCatalogyName.size() - 1}"> --%>
<%-- 				       <option>${listCatalogyName.get(i)}</option> --%>
<%-- 				  </c:forEach> --%>
<%-- 			 </c:if> --%>
<!-- 		</select> -->
<!-- 	</div> -->
<!--   </div> -->
<!-- </div> -->

<!-- END ADVAN SEARCH -->
Tổng số tin : ${tongsotin}
<!-- START TABLE -->
		<div class="row">
			<div class="col-lg-10">
				<table class="table table-striped table-bordered table-responsive" id="filestable">
					<thead>
						<tr style="background-color: skyblue;">
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



