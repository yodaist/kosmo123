<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<header>
	<h1>Host SignUpProcess Demo</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="container">
	<h3>ȸ������</h3>
	<form action="hsignUpProcess" method="post" id="signUpInfo">
		<div class="form-group">
			<label for="hname">�̸�</label> <input type="text" class="form-control"
				id="hname" placeholder="�̸� �Է�" name="hname" maxlength="10"
				required="required" pattern=".{2,10}">
		</div>
		<div class="form-group">
			<label for="hid">ID</label> <input type="text" class="form-control"
				id="hid" placeholder="���̵� �Է�" name="hid" maxlength="10"
				required="required" pattern=".{2,10}">
			
			<button type="button" class="btn btn-primary" id="hidchk">�ߺ�Ȯ��</button>
			<div id="target"></div>

		</div>
		<div class="form-group">
			<label for="hpwd">PWD</label> <input type="password"
				class="form-control" id="hpwd" placeholder="******" name="hpwd"
				maxlength="10" required="required" pattern=".{2,10}">
		</div>
		<!-- �ڵ�����ȣ �޴� �������� �ޱ� -->
		<div class="form-group">
			<label for="hphone">����ó 1</label> <input type="text"
				class="form-control" id="hphone" placeholder="����ó 1�Է�" name="hphone"
				maxlength="15" required="required">
		</div>
		<div class="form-group">
			<label for="haddr">�ּ�</label> <input type="text" class="form-control"
				id="haddr" placeholder="�ּ� �Է�" name="haddr" required="required">
		</div>
		<div class="form-group">
			<label for="hemail">�̸���</label> <input type="text"
				class="form-control" id="hemail" placeholder="�̸��� �Է�" name="hemail"
				required="required">
		</div>
		<div class="form-group">
			<label for="hcall">����ó 2</label> <input type="text"
				class="form-control" id="hcall" placeholder="����ó2 �Է�" name="hcall">
		</div>
		<div class="form-group">
			<label for="haccount">���� ���</label> <input type="text"
				class="form-control" id="haccount" placeholder="�������" name="haccount"
				required="required">
		</div>
<!-- 
		<input type="hidden" id="mgrade" name="mgrade" value="10">
		<input type="hidden" id="mpoint" name="mpoint" value="1000">
		 -->
		<input
			type="hidden" id="hno" name="hno" value="1">

		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary">���</button>
			
			&nbsp; <a href="${ctrpath}/login/idpwdSearch">
				<button type="button" class="btn btn-primary" id="idpwdBtn">���̵�/���ã��</button>
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
		$('#hidchk').click(
				function() {
					let param = $('#hid').val();
					$.ajax({
						url : "../hidcheck?hid=" + param,
						success : function(data) {
							console.log(data);
							if (data == 1) {
								$('#target').css('background-color', 'red')
										.css('color', 'white').html(
												'������� ���̵� �Դϴ�.');
							} else {
								$('#target').css('background-color', 'blue')
										.css('color', 'white').html(
												'��� ������ ���̵� �Դϴ�.');
							}
						}
					});
				});
	});
</script>