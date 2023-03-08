<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />


<header>
	<h1>localmodify.jsp</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>

<div class="container">
	<h3>����������</h3>
	<form action="localmodify" method="post" enctype="multipart/form-data"
		id="localmodifyform">


		<div class="form-group">
			<label for="larea">larea</label> <input type="text"
				class="form-control" id="larea" placeholder="${vo.larea}"
				name="larea">
		</div>



		<div class="form-group">
			<label for="ltitle">ltitle</label> <input type="text"
				class="form-control" id="ltitle" placeholder="${vo.ltitle}"
				name="ltitle">
		</div>



		<div class="form-group">
			<label for="lcontent">lcontent</label> <input type="text"
				class="form-control" id="lcontent" placeholder="${vo.lcontent}"
				name="lcontent">
		</div>



		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">*�̹������ε�</label>
			<div class="col-sm-10">
				<input type="file" name="mfile" id="mfile">
			</div>
			<div class="col-sm-10">
				<img id="imgx" src="${ctrpath}/resources/img/${vo.limg}">
			</div>
		</div>
		<input type="hidden" id="lno" name="lno" value="${vo.lno}">

		<!--  
		<div class="form-group">
			<label for="htcode">htcode</label> <input type="number" class="form-control"
				id="htcode" placeholder="htcode �Է�" name="htcode" maxlength="15"
				required="required">
		</div>
	-->


		<div class="form-group">
			<label for="lprice">lprice</label> <input type="number"
				class="form-control" id="lprice" placeholder="${vo.lprice}"
				name="lprice" required="required">
		</div>


		<!--		
		<div class="form-group">
			<label for="tsort">tsort</label> <input type="number" class="form-control"
				id="tsort" placeholder="tsort �Է�" name="tsort"
				required="required">
		</div>
-->




		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary">����</button>


		</div>
	</form>

</div>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
	//javascript�� Ŭ���̾�Ʈ �� ���
	//HTML, CSS�� �������� �����ϴ� �������� �ַ� ���
	//html5���� �����ϴ� filereader()�Լ��� ����� �̹��� �̸����� ����
	//�Լ��� �޼���� ���

	/*
	 * �޼���: pulic void readURL(String input){}
	 * ����: String reader => var reader
	 */

	function readURL(input) {
		//input type = "file"�� �ּҸ� ������. 
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#imgx').attr('src', e.target.result); //setter
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	//jQuery ����: main ���α׷�, �ù���?
	$(function() {
		//jQuery ������
		//��� �����ڿ��� ��ȭ�� �����ϴ� �̺�Ʈ: chagne()
		//��ȭ�� ������ �� function() ~ �� ���۵ȴ�.
		$('#mfile').change(function() {

			if ($(this).val().length > 0) {
				//�Լ� ȣ��
				readURL(this);
			} else {
				console.log("�̹��� �����ϴ�.");
			}

		});

	});
</script>

