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

<!-- 차트 -->
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
	<!-- 멤버+멤버쉽 : name 출력(세션/ResultMap) -->
	<h3 align="center">${sessionScope.sessionName}님회원정보</h3>
	<!-- name 출력(세션) -->
	<table border="1" align="center">
		<!-- name 출력(ResultMap) -->
		<c:forEach var="e" items="${mbsvo.member }">
			<tr>
				<th>${e.mname }님의등급</th>
				<th>${e.mname }님의포인트</th>
			</tr>
			<tr>
				<td>${mbsvo.mbsname }</td>
				<td>${e.mpoint }</td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="2">다음 등급까지</th>
		</tr>
		<tr>
			<td colspan="2">이만큼 남음!(+도넛차트?)<!-- 차트 -->

			</td>
		</tr>
	</table>
</div>
<div class="container mt-3" align="center">
	<a href="upmemForm"><button type="button" class="btn btn-secondary">
			상세 보기</button></a>
</div>

<br>
<!-- ================================================== -->

<div>
	<h3 align="center">상세 정보_상세보기 페이지로 이동해도 됨/Ajax로 탭 클릭 처리</h3>
	<table border="1" align="center">
		<!-- 멤버 출력(ResultMap) -->
		<c:forEach var="e" items="${mbsvo.member }">
			<tr>
				<th>아이디</th>
				<td>${e.mid }</td>
				<th>이름</th>
				<td>${e.mname }</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${e.mphone }</td>
				<th>이메일 주소</th>
				<td>${e.memail }</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${e.gender }</td>
				<th>(만) 나이</th>
				<td>${e.mage }</td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td>${e.mdate }</td>
				<th>주소</th>
				<td>${e.maddr }</td>
			</tr>
		</c:forEach>
	</table>
</div>

<div class="container mt-3" align="center">
	<a href="upmemForm"><button type="button" class="btn btn-secondary">
			회원 수정</button></a>
</div>
<div class="container mt-3" align="center">
	<a href="delmem?mid=${sessionScope.sessionID}"><button
			type="button" class="btn btn-warning">회원 탈퇴</button></a>
</div>

<br>
<!-- ================================================== -->

<div>
	<h3 align="center">최근 이용 내역</h3>
	<h3 align="center">더보기 클릭하면 Ajax로 밑에 데이터 출력되도록??</h3>
	<table border="1" align="center">
		<tr>
			<th>예약 일시</th>
			<th>이용 일시</th>
			<th>이용 숙소</th>
			<th>결제 방법</th>
			<th>결제 금액</th>
		</tr>
		<tr>
			<td>foreach문 돌리기!</td>
			<td>3개만!</td>
			<td>가장</td>
			<td>가장</td>
			<td>가장</td>
		</tr>
		<tr>
			<td>가장</td>
			<td>가장</td>
			<td>가장</td>
			<td>가장</td>
			<td>가장</td>
		</tr>
		<tr>
			<td>가장</td>
			<td>가장</td>
			<td>가장</td>
			<td>가장</td>
			<td>가장</td>
		</tr>
	</table>
</div>
<div class="container mt-3" align="center">
	<a href="upmemForm"><button type="button" class="btn btn-secondary">
			더 보기</button></a>
</div>

<br>
<!-- ================================================== -->

<div>
	<h3 align="center">차트_평균 사용 금액</h3>

	<table border="1" align="center">
		<tr>
			<td>COUNT : 여행횟수</td>
		</tr>
		<tr>
			<td rowspan="6" align="center" width="500" height="400">
				<div id="tourCountChart"></div>
			</td>
		</tr>
		<!--  
	<tr>
		<td>COUNT : 매 월 여행횟수</td> => 매 년 여행횟수
		<td>MAX : 최대 여행 기간 or 비용</td>
		<td>SUM : 여행 간 기간 합산 비용</td>
		<td>AVG : 여행 평균 기간</td>
		<td>AVG : 데이터 비교해서 여행 갈 시즌 등 비용</td>
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
				type="button" class="btn btn-secondary">차트내역</button></a>
	</div>
</div>

<br>
<!-- ================================================== -->



<!-- ================================================== -->

<script>
$.ajaxSetup({
	cache : false //캐시삭제
});
$.ajax({
	//데이터를 주고받을 파일 주소 입력
	url : "../tourCountJson?mnum=${sessionScope.sessionNum}",
	//작업이 성공적으로 발생했을 경우
	success : function(jsondata){
		$('#tourCountChart').html(""); //비우기
		console.log(jsondata);
		//====================================
		var chart = c3.generate({
			bindto : '#tourCountChart', //차트 표시될 부분(id)
			data : { //success해서 받아온 jsondata데이터 핸들링
				json : [jsondata[1]], //1번지
				keys : {
					value : Object.keys(jsondata[1]),
				},
				type : 'donut'
			},
			donut : {
				title : jsondata[0].sub, //0번지
			},
		});
		//====================================
	},
	//에러가 났을 경우 실행시킬 코드
	error : function(e) {
		console.log("error:" + e);
	}	
});
$.ajax({
	//데이터를 주고받을 파일 주소 입력
	url : "../tourCountJson?mid=${sessionScope.sessionID}",
	//작업이 성공적으로 발생했을 경우
	success : function(jsondata){
		$('#tourCountChart').html(""); //비우기
		console.log(jsondata);
		//====================================
	},
	//에러가 났을 경우 실행시킬 코드
	error : function(e) {
		console.log("error:" + e);
	}	
});
</script>