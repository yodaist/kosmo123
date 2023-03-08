<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<style>
#frame {
	max-width: 1000px;
	min-height: 500px;
	margin: 0 auto;
}

th {
	background-color: mistyrose;
	text-align: center;
	size: 15px;
}

#button {
	left: auto;
}

h3 {
	text-align: center;
	color: salmon;
	font-weight: bolder;
}
</style>

<link href="../resources/css/star.css" rel="stylesheet" />


<script>
	$.ajaxSetup({
		cache : false
	});

	$.ajax({
	url: "../review/getavg?recode="+${vo.ono},
	success: function (json) {
		console.log("����: " + json);
		if(json !== null){
			$('#starAvg').html(json +"��");
		} else if(json === null) {
			$('#starAvg').html("���� �򰡰� �����!");
		}
		
		}
	});
</script>

</head>
<body>

	<h3>������ �󼼺���</h3>

	<div id="frame">
		<table class="table table-bordered border-primary">
			<tr>
				<th>�� ��ȣ</th>
				<td>${vo.ono}</td>
			</tr>

			<tr>
				<th>����</th>
				<td>${vo.ottitle}</td>
			</tr>

			<tr>
				<th>����</th>
				<td id="starAvg"></td>
			</tr>

			<tr>
				<th>����</th>
				<td><img
					src="${pageContext.request.contextPath}/resources/imgfile/${vo.oimg}"></td>
			</tr>

			<tr>
				<th>����</th>
				<td><div id="map" style="width: 800px; height: 300px;"></div></td>
			</tr>

			<tr>
				<th>����</th>
				<td>${vo.ocontent}</td>
			</tr>
		</table>

		<div id="button">
			<a href="overseamodifyForm?num=${vo.ono}"><button type="button"
					class="btn btn-outline-danger">����</button></a> <a
				href="overseadelete?num=${vo.ono}"><button type="button"
					class="btn btn-outline-secondary">����</button></a>

		</div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e0548ec1c0d1a5e8a925a270d49e2192&libraries=LIBRARY"></script>
<script>
var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.4664799, 126.6526885), // ������ �߽���ǥ
        level: 3 // ������ Ȯ�� ����
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // ������ �����մϴ�

// ��Ŀ�� ǥ�õ� ��ġ�Դϴ� 
var markerPosition = new kakao.maps.LatLng(37.4664799, 126.6526885); 

// ��Ŀ�� �����մϴ�
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// ��Ŀ�� ���� ���� ǥ�õǵ��� �����մϴ�
marker.setMap(map);

// ��Ŀ�� �巡�� �����ϵ��� �����մϴ� 
marker.setDraggable(true); 
</script>

		<%-- ----------------------------------------------------------------- --%>
		<%-- ---------------------------���/���� ����----------------------------- --%>
		<hr class="border border-danger border-2 opacity-50">

		<%-- ---------------------------���� ����Ʈ------------------------------- --%>

		<div class="container">
			<h3>��� ����</h3>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>�� ��ȣ</th>
						<th>�� ����</th>
						<th>�ۼ���</th>
						<th>����</th>
						<th>�ۼ���¥</th>
					</tr>
				</thead>

				<tbody>
					<%-- �ݺ����� --%>
					<c:forEach var="e" items="${listReview}">
						<tr>
							<td class="align-middle text-center">${e.reno}</td>
							<td class="text-center">${e.retitle}</td>
							<td class="text-center">${e.rewriter}</td>
							<td class="align-middle">${e.recontent}</td>
							<td class="align-middle">${e.redate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<%-- ------------------------------modal------------------------------ --%>
		<c:choose>
			<c:when test="${sessionScope.sessionID==null }">

			</c:when>

			<c:when test="${sessionScope.sessionID!=null }">
				<button type="button" class="btn btn-outline-danger"
					data-bs-toggle="modal" data-bs-target="#exampleModal"
					data-bs-whatever="@fat"
					style="text-align: right; margin-top: 10px;">���� ����ϱ�</button>


				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title fs-5" id="exampleModalLabel">&#128147;����
									����ϱ�&#128147;</h1>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">

								<form action="addReview" method="post">
									<input type="hidden" name="recode" value="${vo.ono}">
									<div class="mb-3">
										<label for="recipient-name" class="col-form-label">����:</label>
										<input type="text" class="form-control" id="recipient-name"
											name="retitle" id="retitle" required="required"
											placeholder="������ �Է��ϼ���.">
									</div>

									<div class="mb-3">
										<label for="recipient-name" class="col-form-label">�ۼ���:
											${sessionScope.sessionName } ��</label> <input type="hidden"
											value="${sessionScope.sessionName }" name="rewriter"
											id="rewriter">
									</div>

									<%-- --------------���� ����------------------ --%>
									<div class="mb-3" id="myform">
										<fieldset>
											<input type="radio" name="star" value=5 id="rate1"> <label
												for="rate1">��</label> <input type="radio" name="star"
												value=4 id="rate2"> <label for="rate2">��</label> <input
												type="radio" name="star" value=3 id="rate3"> <label
												for="rate3">��</label> <input type="radio" name="star"
												value=2 id="rate4"> <label for="rate4">��</label> <input
												type="radio" name="star" value=1 id="rate5"> <label
												for="rate5">��</label>
										</fieldset>
									</div>
									<%-- --------------���� ����------------------ --%>

									<div class="mb-3">
										<label for="message-text" class="col-form-label">����:</label>
										<textarea class="form-control" id="message-text"
											placeholder="������ �Է��ϼ���." name="recontent" id="recontent"
											rows="10" cols="50" required="required"></textarea>
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">�ݱ�</button>
										<button type="submit" class="btn btn-primary">����ϱ�</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:when>
		</c:choose>

		<%-- ------------------------------modal------------------------------ --%>








		<%-- 
		<h3 align="center">��� �ۼ��ϱ�</h3>
		<form action="addReview" method="post">
			<input type="hidden" name="recode" value="${vo.lno}">

			<div class="input-group mb-3">
				<span class="input-group-text">����</span> <input type="text"
					class="form-control" name="retitle" id="retitle">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">�ۼ���</span> <input type="text"
					class="form-control" name="rewriter" id="rewriter">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">����</span>
				<textarea class="form-control" id="message-text"
					placeholder="������ �Է��ϼ���." name="recontent" id="recontent" rows="10"
					cols="50"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">����ϱ�</button>
		</form>
	</div>
	--%>
	</div>
</body>
</html>