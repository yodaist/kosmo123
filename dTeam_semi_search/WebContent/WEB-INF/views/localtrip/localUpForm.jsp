<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!-- 2023. 1. 19. / Kosmo -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />


<header>
	<h1>localUpForm.jsp</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>

<div class="container">
	<h3>����������</h3>
	<form action="localUpProcess" method="post"
		enctype="multipart/form-data" id="localupform">



		<div class="form-group">
			<label for="larea">larea</label> <input type="text"
				class="form-control" id="larea" placeholder="larea �Է�" name="larea">
		</div>



		<div class="form-group">
			<label for="ltitle">ltitle</label> <input type="text"
				class="form-control" id="ltitle" placeholder="ltitle �Է�"
				name="ltitle">
		</div>



		<div class="form-group">
			<label for="lcontent">lcontent</label> <input type="text"
				class="form-control" id="lcontent" placeholder="lcontent �Է�"
				name="lcontent">
		</div>

		<div class="input-group mb-3">
			<label class="input-group-text" for="mfile">*�̹������ε�</label> <input
				type="file" name="mfile" id="mfile" class="form-control">
		</div>
		<div class="col-sm-10">
			<img id="imgx" src="${ctrpath}/resources/img/logo.png">
		</div>

		<!--  
		<div class="form-group">
			<label for="htcode">htcode</label> <input type="number" class="form-control"
				id="htcode" placeholder="htcode �Է�" name="htcode" maxlength="15"
				required="required">
		</div>
	-->


		<div class="form-group">
			<label for="lprice">lprice</label> <input type="number"
				class="form-control" id="lprice" placeholder="lprice �Է�"
				name="lprice" required="required">
		</div>

		<div class="form-group">
			<label>Item(�ִ� 10��)</label>
			<table class="table table-bordered border-primary">
				<thead>
					<tr>
						<th>No</th>
						<th>iname</th>
						<th>iprice</th>
						<th>iimg</th>
						<th>*�̹������ε�</th>
						<th>istock</th>
					</tr>
				</thead>
				<tbody id="item">
					<tr>
						<td>1</td>
						<td><input type="text" name="iname" class="form-control"></td>
						<td><input type="text" name="iprice" class="form-control"></td>
						<td><img id="iimg" src="${ctrpath}/resources/img/logo.png"
							style="width: 137.986px; height: 40.990px;" class="iimg"></td>
						<td><input type="file" name="ifile" class="ifile"></td>
						<td><input type="number" name="istock" value="1" min="1"
							step="1" class="form-control"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							<button type="button" id="addBtn" class="btn btn-outline-danger">�߰�</button>
							<button type="button" id="deleteBtn"
								class="btn btn-outline-secondary">����</button>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>

		<!--		
		<div class="form-group">
			<label for="tsort">tsort</label> <input type="number" class="form-control"
				id="tsort" placeholder="tsort �Է�" name="tsort"
				required="required">
		</div>
-->

		<input type="hidden" id="htcode" name="htcode" value="1"> <input
			type="hidden" id="tsort" name="tsort" value="1">


		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="submit" class="btn btn-primary">���</button>


		</div>
	</form>

</div>
<script>
	function readURL(element) {
		//input type = "file"�� �ּҸ� ������.
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#imgx').attr('src', e.target.result); //setter
		}
		reader.readAsDataURL(element.files[0]);
	}
	function readItem(i) {
		//input type = "file"�� �ּҸ� ������.
		var reader = new FileReader();
		reader.onload = function(e) {
			$('.iimg').eq(i).attr('src', e.target.result); //setter
		}
		reader.readAsDataURL($('.ifile').eq(i).prop('files')[0]);
	}
	//jQuery ����: main ���α׷�, �ù���?
	$(function() {
		//jQuery ������
		//��� �����ڿ��� ��ȭ�� �����ϴ� �̺�Ʈ: change()
		//��ȭ�� ������ �� function() ~ �� ���۵ȴ�.
		$('#mfile').change(function() {
			if ($(this).val().length != 0) {
				//�Լ� ȣ��
				readURL(this);
			} else {
				console.log("�̹��� �����ϴ�.");
			}
		});
		$('.ifile').change(function() {
			if ($(this).val().length != 0) {
				let c = this;

				$('.ifile').each(function(i, element) {
					if (this == c) {
						//�Լ� ȣ��
						readItem(i)
					}
				})
			} else {
				console.log("�̹��� �����ϴ�.");
			}
		});
	});

	$('#addBtn')
			.click(
					function() {
						if ($('#item').children().length < 10) {
							let html = '<tr><td>'
									+ ($('#item').children().length + 1)
									+ '</td>';
							html += '<td><input type="text" name="iname" class="form-control"></td>';
							html += '<td><input type="text" name="iprice" class="form-control"></td>';
							html += '<td><img src="${ctrpath}/resources/img/logo.png" style="width: 137.986px; height: 40.990px;" class="iimg"></td>';
							html += '<td><input type="file" name="ifile'
									+ ($('#item').children().length + 1)
									+ '" class="ifile"></td>';
							html += '<td><input type="number" name="istock" value="1" min="1" step="1" class="form-control"></td></tr>';

							$('#item').append(html);
						}

						$('.ifile').change(function() {
							if ($(this).val().length != 0) {
								let c = this;

								$('.ifile').each(function(i, element) {
									if (this == c) {
										//�Լ� ȣ��
										readItem(i)
									}
								})
							} else {
								console.log("�̹��� �����ϴ�.");
							}
						});
					})
	$('#deleteBtn').click(
			function() {
				if ($('#item').children().length > 1) {
					$('#item').children('tr').eq(
							$('#item').children('tr').length - 1).remove();
				}
			})
</script>