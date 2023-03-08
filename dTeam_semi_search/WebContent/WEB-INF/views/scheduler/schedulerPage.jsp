<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--2023. 2. 3./Kosmo--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style>
.form-select {
	width: 150px;
	margin: 0 auto;
}

.container {
	display: flex;
	gap: 30px;
	max-width: 1450px;
	min-height: 300px;
	margin: 0 auto;
}

.column {
	flex-basis: 20%;
	background: gainsboro;
	height: 60vh;
	padding: 5px;
	border-radius: 10px;
}

.column2 {
	flex-basis: 60%;
	background: gainsboro;
	height: 90vh;
	padding: 5px;
	border-radius: 10px;
}

.column3 {
	flex-basis: 60%;
	background: lavender;
	height: 90vh;
	padding: 5px;
	border-radius: 10px;
}

#sortablediv {
	background: white;
	border-radius: 10px;
	height: 550px;
	padding: 5px;
}

.column h1 {
	text-align: center;
	font-size: 22px;
}

.column2 h1 {
	text-align: center;
	font-size: 22px;
}

.list-group-item {
	text-align: center;
	background: #fff;
	margin: 20px;
	padding: 20px;
	border-radius: 5px;
	cursor: pointer;
}

.ui-state-default {
	text-align: center;
	background: #fff;
	margin: 8px;
	padding: 20px;
	border-radius: 5px;
	cursor: pointer;
}

td {
	text-align: center;
	background: #fff;
	margin: 5px;
	padding: 10px;
	border-radius: 5px;
	cursor: pointer;
}

/* ==============제목==================*/
.nine h1 {
	text-align: center;
	font-size: 50px;
	text-transform: uppercase;
	color: #222;
	letter-spacing: 1px;
	font-family: "Playfair Display", serif;
	font-weight: 400;
}

.nine h1 span {
	margin-top: 5px;
	font-size: 15px;
	color: #444;
	word-spacing: 1px;
	font-weight: normal;
	letter-spacing: 2px;
	text-transform: uppercase;
	font-family: "Raleway", sans-serif;
	font-weight: 500;
	display: grid;
	grid-template-columns: 1fr max-content 1fr;
	grid-template-rows: 27px 0;
	grid-gap: 20px;
	align-items: center;
}

.nine h1 span:after, .nine h1 span:before {
	content: " ";
	display: block;
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #ccc;
	height: 5px;
	background-color: #f8f8f8;
}

/* ============버튼====================*/
.custom-btn {
	width: 130px;
	height: 40px;
	color: #fff;
	border-radius: 5px;
	padding: 10px 25px;
	font-weight: 500;
	background: whitesmoke;
	cursor: pointer;
	transition: all 0.3s ease;
	position: relative;
	display: inline-block;
	box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5), 7px 7px 20px
		0px rgba(0, 0, 0, .1), 4px 4px 5px 0px rgba(0, 0, 0, .1);
	outline: none;
}

button {
	margin: 20px;
}

/**/
.btn-16 {
	border: none;
	color: #000;
}

.btn-16:after {
	position: absolute;
	content: "";
	width: 0;
	height: 100%;
	top: 0;
	left: 0;
	direction: rtl;
	z-index: -1;
	box-shadow: -7px -7px 20px 0px #fff9, -4px -4px 5px 0px #fff9, 7px 7px
		20px 0px #0002, 4px 4px 5px 0px #0001;
	transition: all 0.3s ease;
}

.btn-16:hover {
	color: #000;
}

.btn-16:hover:after {
	left: auto;
	right: 0;
	width: 100%;
}

.btn-16:active {
	top: 2px;
}
</style>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
<script>
	$(function() {
		$("#accom").click(function() {
			$.ajaxSetup({
				cache : false
			});

			$.ajax({
				url : "../schedulerRest/showList",
				success : function(json) {
					$('#target').html("");
					$.each(json, function(k, v) {
						let htmlTag = "<tr>";
						$.each(v, function(i, j) {
							if (j !== null) {
								console.log(i + ":" + j);
								htmlTag += "<td>" + j + "</td>";
							}
						})
						htmlTag += "</tr>";
						$('#target').append(htmlTag);
					})
				}
			});
		});

	});
</script>

</head>
<body>
	<div class="nine">
		<h1>
			Scheduler <span>Just Drag And Drop your way</span>
		</h1>
	</div>

	<div class="container">
		<div class="column">
			<h1>Options</h1>
			<%-- ----------------select---------------- --%>
			<div>
				<select class="form-select">
					<option selected>여행 지역</option>
					<option value="1">서울</option>
					<option value="2">인천</option>
					<option value="3">경기</option>
					<option value="4">충청</option>
					<option value="5">전라</option>
					<option value="6">경상</option>
					<option value="7">강원</option>
					<option value="8">제주</option>
				</select>
			</div>
			<%-- ----------------select---------------- --%>

			<button class="custom-btn btn-16" id="departure">출발</button>
			<button class="custom-btn btn-16" id="accom">숙소</button>
			<button class="custom-btn btn-16" id="meal">식사</button>
			<button class="custom-btn btn-16" id="cafe">카페</button>
			<button class="custom-btn btn-16" id="tour">관광지</button>
			<button class="custom-btn btn-16">귀가</button>


		</div>


		<div class="column2">
			<h1>Options</h1>
			<table class="table table-bordered border-primary">

				<tbody id="target">
				</tbody>
			</table>
		</div>


		<div class="column3">
			<h1>Schedule</h1>
			<div id="sortablediv">
		
				<ul id="sortable">
					<li class="ui-state-default" draggable="true" id="depart"><span
						class="ui-icon ui-icon-arrowthick-2-n-s"></span>출발</li>
					<li class="ui-state-default" draggable="true"><span
						class="ui-icon ui-icon-arrowthick-2-n-s"></span>종로 오죽이네</li>
					<li class="ui-state-default" draggable="true"><span
						class="ui-icon ui-icon-arrowthick-2-n-s"></span>신촌 카페몬지</li>
					<li class="ui-state-default" draggable="true"><span
						class="ui-icon ui-icon-arrowthick-2-n-s"></span>신용산 닭한마리</li>
					<li class="ui-state-default" draggable="true"><span
						class="ui-icon ui-icon-arrowthick-2-n-s"></span>용산 몽탄</li>
					<li class="ui-state-default" draggable="true"><span
						class="ui-icon ui-icon-arrowthick-2-n-s"></span>강남 알베르</li>
					<li class="ui-state-default" draggable="true"><span
						class="ui-icon ui-icon-arrowthick-2-n-s"></span>귀가</li>
				</ul>
			</div>

		</div>
	</div>
</body>

<script>
	$("#sortable").sortable({
		placeholder : "itemBoxHighlight", /* 이동할 위치 css 적용  */
		start : function(event, ui) {
			// 드래그 시작 시 호출
		},
		stop : function(event, ui) {
			// 드래그 종료 시 호출
			reorder();
		}
	});

	/* 번호 재입력(내부적으로) */
	function reorder() {
		$("#sortable li").each(function(i, box) {
			$(box).val(i + 1);
		});
	}
</script>
</html>