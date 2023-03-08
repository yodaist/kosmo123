<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
	<form action="hostupdate" method="post" id="updateInfo">
		<!--
		<input type="hidden" name="reip" value="<%=request.getRemoteAddr()%>">
	-->
		<input type="hidden" id="hid" name="hid" value="${sessionScope.sessionHID}">
		
		<div class="form-group">
			<label for="hname">�̸�</label> <input type="text" class="form-control"
				id="hname" placeholder="�̸� �Է�" name="hname" maxlength="20"
				required="required" pattern=".{2,20}">
		</div>
		<div class="form-group">
			<label for="hpwd">PWD</label> <input type="password"
				class="form-control" id="hpwd" placeholder="******" name="hpwd"
				maxlength="20" required="required" pattern=".{2,20}">
		</div>
		<!-- �ڵ�����ȣ �޴� �������� �ޱ� -->
		<div class="form-group">
			<label for="hphone">����ó</label> <input type="text"
				class="form-control" id="hphone" placeholder="����ó �Է�" name="hphone"
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
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<input type="submit" class="btn btn-primary" value="���">
			&nbsp; 
			<a href="${ctrpath}/login/idpwdSearch">
			<button type="button" class="btn btn-primary" id="hidpwdBtn">���̵�/���ã��</button>
			</a>
		</div>
	</form>
</div>