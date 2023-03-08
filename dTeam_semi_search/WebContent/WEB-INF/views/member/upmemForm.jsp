<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 2. 1. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />

<header>
	<h1>UpdateProcess Demo</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>
<div class="container">
	<h3>ȸ������</h3>
	<form action="updateProcess" method="post" id="updateInfo">
		<!--
		<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
	-->
		<input type="hidden" name="mid" value="${sessionScope.sessionID}">
		
		<div class="form-group">
			<label for="mname">�̸�</label> <input type="text" class="form-control"
				id="mname" placeholder="�̸� �Է�" name="mname" maxlength="10"
				required="required" pattern=".{2,10}">
		</div>
		<div class="form-group">
			<label for="mpwd">PWD</label> <input type="password"
				class="form-control" id="mpwd" placeholder="******" name="mpwd"
				maxlength="10" required="required" pattern=".{2,10}">
		</div>
		<!-- �ڵ�����ȣ �޴� �������� �ޱ� -->
		<div class="form-group">
			<label for="mphone">����ó</label> <input type="text"
				class="form-control" id="mphone" placeholder="����ó �Է�" name="mphone"
				maxlength="15" required="required">
		</div>
		<div class="form-group">
			<label for="maddr">�ּ�</label> <input type="text" class="form-control"
				id="maddr" placeholder="�ּ� �Է�" name="maddr" required="required">
		</div>
		<div class="form-group">
			<label for="memail">�̸���</label> <input type="text"
				class="form-control" id="memail" placeholder="�̸��� �Է�" name="memail"
				required="required">
		</div>
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary">���</button>
			&nbsp; 
			<a href="${ctrpath}/login/idpwdSearch">
			<button type="button" class="btn btn-primary" id="idpwdBtn">���̵�/���ã��</button>
			</a>
		</div>
	</form>
</div>