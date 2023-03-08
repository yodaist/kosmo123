<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<article>
	<header>
		<h1>����</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>��ȣ</th>
					<th>����</th>
					<th>�ۼ���</th>
					<th>�ۼ���¥</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="e" items="${list}">
					<tr>
						<td>${e.nnum }</td>
						<td>${e.nsub }</td>
						<td>${e.nwriter }</td>
						<!-- <td>1000</td> -->
						<td>${e.ndate}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
					<%@include file="../page/pageModule.jsp" %>
					</td>
				</tr>
				<tr>
					<th colspan="4">
						<form class="d-flex" method="post" action="listNo">
							<select class="form-control btn-mini" name="searchType" id="searchType"
								style="margin-left: 120px;">
								<option value="">�˻�</option>
								<option value="1">����</option>
								<option value="2">�̸�</option>
							</select> <input class="form-control me-2" type="text"
								style="width: 300px" name="searchValue" id="searchValue">
							<button class="btn btn-outline-secondary" type="submit">Search</button>
						</form>
					</th>
				</tr>
				<tr>
					<td colspan="4" style="text-align: right;">
					<c:if test="${searchType == 1 or searchType == 2}">
						${totalRecord}����  �Խù����� <b>${searchValue}</b> �� �˻� �Ǿ����ϴ�.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
        				<a href="${pageContext.request.contextPath}/upload/upform">
						<button type="button" class="btn btn-outline-secondary" id="wbtn">���ۼ�</button>
						</a>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</article>