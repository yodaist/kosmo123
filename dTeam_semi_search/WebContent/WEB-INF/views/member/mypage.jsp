<%@page import="kr.co.kosmo.mvc.vo.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<style>
th {
	background-color: aliceblue;
}

h3 {
	color: #6495ed;
}

table {
	border-collapse: collapse;
	width: 70%;
}

#calendar {
	max-width: 900px;
	min-height: 400px;
	margin: 40px auto;
}
</style>



<link href="fullcalendar/main.css" rel="stylesheet" />
<script src="fullcalendar/main.js"></script>

<!-- ��Ʈ -->
<!-- Load c3.css -->
<link href="${path }/css/c3.css" rel="stylesheet">
<!-- Load d3.js and c3.js -->
<script src="${path }/js/d3-5.8.2.min.js" charset="utf-8"></script>
<script src="${path }/js/c3.min.js"></script>

<header>
	<h1>MY PAGE</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>

<div>
	<!-- ���+����� : name ���(����/ResultMap) -->
	<h3 align="center">${sessionScope.sessionName}��ȸ������</h3>
	<!-- name ���(����) -->
	<table border="1" align="center">
		<!-- name ���(ResultMap) -->
		<c:forEach var="e" items="${mbsvo.member }">
			<tr>
				<th>${e.mname }���ǵ��</th>
				<th>${e.mname }��������Ʈ</th>
			</tr>
			<tr>
				<td>${mbsvo.mbsname }</td>
				<td>${e.mpoint }</td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="2">���� ��ޱ���</th>
		</tr>
		<tr>
			<td colspan="2">�̸�ŭ ����!(+������Ʈ?)<!-- ��Ʈ -->

			</td>
		</tr>
	</table>
</div>
<div class="container mt-3" align="center">
	<a href="upmemForm"><button type="button" class="btn btn-secondary">
			�� ����</button></a>
</div>

<br>
<!-- ================================================== -->

<div>
	<h3 align="center">�� ����_�󼼺��� �������� �̵��ص� ��/Ajax�� �� Ŭ�� ó��</h3>
	<table border="1" align="center">
		<!-- ��� ���(ResultMap) -->
		<c:forEach var="e" items="${mbsvo.member }">
			<tr>
				<th>���̵�</th>
				<td>${e.mid }</td>
				<th>�̸�</th>
				<td>${e.mname }</td>
			</tr>
			<tr>
				<th>��ȭ��ȣ</th>
				<td>${e.mphone }</td>
				<th>�̸��� �ּ�</th>
				<td>${e.memail }</td>
			</tr>
			<tr>
				<th>����</th>
				<td>${e.gender }</td>
				<th>(��) ����</th>
				<td>${e.mage }</td>
			</tr>
			<tr>
				<th>��������</th>
				<td>${e.mdate }</td>
				<th>�ּ�</th>
				<td>${e.maddr }</td>
			</tr>
		</c:forEach>
	</table>
</div>

<div class="container mt-3" align="center">
	<a href="upmemForm"><button type="button" class="btn btn-secondary">
			ȸ�� ����</button></a>
</div>
<div class="container mt-3" align="center">
	<a href="delmem?mid=${sessionScope.sessionID}"><button
			type="button" class="btn btn-warning">ȸ�� Ż��</button></a>
</div>

<br>
<!-- ================================================== -->

<div>
	<h3 align="center">�ֱ� �̿� ����</h3>
	<h3 align="center">������ Ŭ���ϸ� Ajax�� �ؿ� ������ ��µǵ���??</h3>
	<table border="1" align="center">
		<tr>
			<th>���� �Ͻ�</th>
			<th>�̿� �Ͻ�</th>
			<th>�̿� ����</th>
			<th>���� ���</th>
			<th>���� �ݾ�</th>
		</tr>
		<tr>
			<td>foreach�� ������!</td>
			<td>3����!</td>
			<td>����</td>
			<td>����</td>
			<td>����</td>
		</tr>
		<tr>
			<td>����</td>
			<td>����</td>
			<td>����</td>
			<td>����</td>
			<td>����</td>
		</tr>
		<tr>
			<td>����</td>
			<td>����</td>
			<td>����</td>
			<td>����</td>
			<td>����</td>
		</tr>
	</table>
</div>
<div class="container mt-3" align="center">
	<a href="upmemForm"><button type="button" class="btn btn-secondary">
			�� ����</button></a>
</div>

<br>
<!-- ================================================== -->

<div>
	<h3 align="center">��Ʈ_��� ��� �ݾ�</h3>

	<table border="1" align="center">
		<tr>
			<td>COUNT : ����Ƚ��</td>
		</tr>
		<tr>
			<td rowspan="6" align="center" width="500" height="400">
				<div id="tourCountChart"></div>
			</td>
		</tr>
		<!--  
	<tr>
		<td>COUNT : �� �� ����Ƚ��</td> => �� �� ����Ƚ��
		<td>MAX : �ִ� ���� �Ⱓ or ���</td>
		<td>SUM : ���� �� �Ⱓ �ջ� ���</td>
		<td>AVG : ���� ��� �Ⱓ</td>
		<td>AVG : ������ ���ؼ� ���� �� ���� �� ���</td>
	</tr>
	<tr>
		<td rowspan="6" align="center" width="500" height="400"><img
			src="img/blood.png" width="800" height="400"></td>
		<td rowspan="6" align="center" width="500" height="400"><img
			src="img/blood.png" width="800" height="400"></td>
		<td rowspan="6" align="center" width="500" height="400"><img
			src="img/blood.png" width="800" height="400"></td>
		<td rowspan="6" align="center" width="500" height="400"><img
			src="img/blood.png" width="800" height="400"></td>
		<td rowspan="6" align="center" width="500" height="400"><img
			src="img/blood.png" width="800" height="400"></td>
	</tr>
	-->

	</table>
	<div class="container mt-3" align="center">
		<a href="pro.kosmo?cmd=patient&scmd=chdetails"><button
				type="button" class="btn btn-secondary">��Ʈ����</button></a>
	</div>
</div>

<br>
<!-- ================================================== -->



<!-- ================================================== -->

<script>
$.ajaxSetup({
	cache : false //ĳ�û���
});
$.ajax({
	//�����͸� �ְ���� ���� �ּ� �Է�
	url : "../tourCountJson?mnum=${sessionScope.sessionNum}",
	//�۾��� ���������� �߻����� ���
	success : function(jsondata){
		$('#tourCountChart').html(""); //����
		console.log(jsondata);
		//====================================
		var chart = c3.generate({
			bindto : '#tourCountChart', //��Ʈ ǥ�õ� �κ�(id)
			data : { //success�ؼ� �޾ƿ� jsondata������ �ڵ鸵
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
	//������ ���� ��� �����ų �ڵ�
	error : function(e) {
		console.log("error:" + e);
	}	
});
$.ajax({
	//�����͸� �ְ���� ���� �ּ� �Է�
	url : "../tourCountJson?mid=${sessionScope.sessionID}",
	//�۾��� ���������� �߻����� ���
	success : function(jsondata){
		$('#tourCountChart').html(""); //����
		console.log(jsondata);
		//====================================
	},
	//������ ���� ��� �����ų �ڵ�
	error : function(e) {
		console.log("error:" + e);
	}	
});
</script>