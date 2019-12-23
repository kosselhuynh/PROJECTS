//$(function () {
//    $( '#table' ).searchable({
//        striped: true,
//        oddRow: { 'background-color': '#f5f5f5' },
//        evenRow: { 'background-color': '#fff' },
//        searchType: 'fuzzy'
//    });
//    
//    $( '#searchable-container' ).searchable({
//        searchField: '#container-search',
//        selector: '.row',
//        childSelector: '.col-xs-4',
//        show: function( elem ) {
//            elem.slideDown(100);
//        },
//        hide: function( elem ) {
//            elem.slideUp( 100 );
//        }
//    })
//});


//$(document).ready( function () {
//	 var table = $('#filesTable').DataTable({
//			"sAjaxSource": "/files",
//			"sAjaxDataProp": "",
//			"order": [[ 0, "asc" ]],
//			"aoColumns": [
//		          { "mData": "name" },
//				  { "mData": "size" },
//				  { "mData": "downloads" },
//				  { "mData": "dateUpload" }
//			]
//	 })
//});

//$(document).ready(function() {
//    $('#filesTable').DataTable( {
//        "ajax": {
//            "url": "/files",
//            "dataSrc": "data"
//        },
//        "columns": [
//            { "data": "name" },
//            { "data": "size" },
//            { "data": "downloads" },
//            { "data": "dateUpload" }
//        ]
//    } );
//} );