<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<header>
	<h1>SignUpProcess Demo</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="container">
	<h3>회원가입</h3>
	<form action="signUpProcess" method="post" id="signUpInfo">
		<!--
		<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
	-->
		<div class="form-group">
			<label for="mname">이름</label> <input type="text" class="form-control"
				id="mname" placeholder="이름 입력" name="mname" maxlength="10"
				required="required" pattern=".{2,10}">
		</div>
		<div class="form-group">
			<label for="mid">ID</label> <input type="text" class="form-control"
				id="mid" placeholder="아이디 입력" name="mid" maxlength="10"
				required="required" pattern=".{2,10}">
			<button type="button" class="btn btn-primary" id="idchk">중복확인</button>
			<div id="target"></div>

		</div>
		<div class="form-group">
			<label for="mpwd">PWD</label> <input type="password"
				class="form-control" id="mpwd" placeholder="******" name="mpwd"
				maxlength="10" required="required" pattern=".{2,10}">
		</div>
		<!-- 핸드폰번호 받는 형식으로 받기 -->
		<div class="form-group">
			<label for="mphone">연락처</label> <input type="text"
				class="form-control" id="mphone" placeholder="연락처 입력" name="mphone"
				maxlength="15" required="required">
		</div>
		<div class="form-group">
			<label for="mcall">비상연락망</label> <input type="text"
				class="form-control" id="mcall" placeholder="비상연락망 입력" name="mcall"
				maxlength="15" required="required">
		</div>
		<div class="form-group">
			<label for="mjumin">주민번호</label> <input type="text"
				class="form-control" id="mjumin" placeholder="주민번호 입력" name="mjumin"
				required="required">
		</div>
		<div class="form-group">
			<label for="maddr">주소</label> <input type="text" class="form-control"
				id="maddr" placeholder="주소 입력" name="maddr" required="required">
		</div>
		<div class="form-group">
			<label for="memail">이메일</label> <input type="text"
				class="form-control" id="memail" placeholder="이메일 입력" name="memail"
				required="required">
		</div>

		<input type="hidden" id="mgrade" name="mgrade" value="10">
		<input type="hidden" id="mpoint" name="mpoint" value="1000">
		<input
			type="hidden" id="mno" name="mno" value="1">

		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary">등록</button>
			&nbsp; <a href="${ctrpath}/login/idpwdSearch">
				<button type="button" class="btn btn-primary" id="idpwdBtn">아이디/비번찾기</button>
			</a>
		</div>
	</form>

</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
	/*
	 $(function() {
	 $('#idpwdBtn').click(function() {
	 location="/login/idpwdSearch";
	 });
	 });
	 */

	$(function() {
		$('#idchk').click(
				function() {
					let param = $('#mid').val();
					$.ajax({
						url : "../idcheck?mid=" + param,
						success : function(data) {
							console.log(data);
							if (data == 1) {
								$('#target').css('background-color', 'red')
										.css('color', 'white').html(
												'사용중인 아이디 입니다.');
							} else {
								$('#target').css('background-color', 'blue')
										.css('color', 'white').html(
												'사용 가능한 아이디 입니다.');
							}
						}
					});
				});
	});
</script>