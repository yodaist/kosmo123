<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />


<header>
	<h1>overseamodify.jsp</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>

<div class="container">
	<h3>����������</h3>
	<form action="overseamodify" method="post" enctype="multipart/form-data"
		id="overseamodifyform">


		<div class="form-group">
			<label for="oarea">oarea</label> <input type="text"
				class="form-control" id="oarea" placeholder="${vo.oarea}"
				name="oarea">
		</div>



		<div class="form-group">
			<label for="ottitle">ottitle</label> <input type="text"
				class="form-control" id="ottitle" placeholder="${vo.ottitle}"
				name="ottitle">
		</div>



		<div class="form-group">
			<label for="ocontent">ocontent</label> <input type="text"
				class="form-control" id="ocontent" placeholder="${vo.ocontent}"
				name="ocontent">
		</div>



		<div class="row mb-3">
			<label class="col-sm-2 col-form-label">*�̹������ε�</label>
			<div class="col-sm-10">
				<input type="file" name="mfile" id="mfile">
			</div>
			<div class="col-sm-10">
				<img id="imgx" src="${ctrpath}/resources/img/${vo.oimg}">
			</div>
		</div>
		<input type="hidden" id="ono" name="ono" value="${vo.ono}">

		<!--  
		<div class="form-group">
			<label for="htcode">htcode</label> <input type="number" class="form-control"
				id="htcode" placeholder="htcode �Է�" name="htcode" maxlength="15"
				required="required">
		</div>
	-->


		<div class="form-group">
			<label for="oprice">oprice</label> <input type="number"
				class="form-control" id="oprice" placeholder="${vo.oprice}"
				name="oprice" required="required">
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

