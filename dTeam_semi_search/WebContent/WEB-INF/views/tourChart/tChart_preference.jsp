<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

	<!-- Load c3.css -->
	<link href="${path}/css/c3.css" rel="stylesheet">

	<!-- Load d3.js and c3.js -->
	<script src="${path}/js/d3-5.8.2.min.js" charset="utf-8"></script>
	<script src="${path}/js/c3.min.js"></script>

<body>
	<header>
		<h1>�������� ��Ȳ ��ȸ</h1>
		<h2>�����ڰ� ���� ����!</h2>
	</header>
	
	<input type="number" id="num">
	<button id="chk">��ȸ</button>
	
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
	<div id="chart"></div>

	</div>
</body>
<script>

$(function(){
	$('#chk').click(function(){
		
		let param = $('#num').val();
		
		$.ajaxSetup({
			cache : false
		});
		$.ajax({
			url : "../tourChartJson?num="+param,
			success : function(jsondata){
				$('#chart').html(""); //����
				console.log(jsondata);
				//====================================
				var chart = c3.generate({
					bindto : '#chart',
					data : {
						json : [jsondata[1]], //1����
						keys : {
							value : Object.keys(jsondata[1]),
						},
						type : 'donut'
					},
					donut : {
						title : jsondata[0].sub, //0����
					},
				});
				//====================================
			},
			error : function(e) {
				console.log("error:" + e);
				$('#chart').html("�����Ͱ� ������~");
			}	
		});

	});
});



</script>
