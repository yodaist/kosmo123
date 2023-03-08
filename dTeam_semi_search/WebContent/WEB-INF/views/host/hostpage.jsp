<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />
<div class="container rounded bg-white mt-5 mb-5">
	<div class="row">
		<div class="col-md-3 border-right">
			<div
				class="d-flex flex-column align-items-center text-center p-3 py-5">
				<img class="rounded-circle mt-5" width="150px"
					src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
					class="font-weight-bold"></span><span class="text-black-50"></span><span>
				</span>
			</div>
		</div>
		<div class="col-md-5 border-right">
			<div class="p-3 py-5">
				<div class="d-flex justify-content-between align-items-center mb-3">
					<h4 class="text-right">Host Page</h4>
				</div>
				<div class="row mt-2">
					<div class="col-md-12">
						<label class="labels">��й�ȣ</label><input type="password"
							class="form-control" value="${hvo.hpwd}" readonly="readonly">
					</div>
					<div class="col-md-12">
						<label class="labels">�̸�</label><input type="text"
							class="form-control" value="${hvo.hname}" readonly="readonly">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-md-12">
						<label class="labels">��ȭ��ȣ 1</label><input type="text"
							class="form-control" value="${hvo.hphone}" readonly="readonly">
					</div>
					<div class="col-md-12">
						<label class="labels">�ּ�</label><input type="text"
							class="form-control" value="${hvo.haddr}" readonly="readonly">
					</div>
					<div class="col-md-12">
						<label class="labels">email</label><input type="text"
							class="form-control" value="${hvo.hemail}" readonly="readonly">
					</div>
					<div class="col-md-12">
						<label class="labels">��ȭ��ȣ 2</label><input type="text"
							class="form-control" value="${hvo.hcall}" readonly="readonly">
					</div>
					<div class="col-md-12">
						<label class="labels">�������</label><input type="text"
							class="form-control" value="${hvo.haccount}" readonly="readonly">
					</div>

				</div>

				<div class="mt-5 text-right">
					<a href="${ctrpath}/host/uphostForm"><button
							class="btn btn-danger profile-button" style="-c: #E95A49"
							type="button">����</button></a> <a
						href="${ctrpath}/host/delmem?hid=${session.sessionHID}"><button
							class="btn btn-danger profile-button" style="-c: #E95A49"
							type="button">Ż��</button></a>
				</div>
			</div>

		</div>
		<div class="col-md-4">
            <div class="p-3 py-5">
                <div
                    class="d-flex justify-content-between align-items-center experience">
                    <span>��� ���� ����</span>
                </div>
                <br>
                <div class="col-md-12">
                    <label class="labels">Experience in Designing</label><input
                        type="text" class="form-control" placeholder="experience" value="">
                </div>
                <br>
                <div class="col-md-12">
                    <label class="labels">Additional Details</label><input type="text"
                        class="form-control" placeholder="additional details" value="">
                </div>
                <div class="mt-5 text-right">
                    <a href="${ctrpath}/local/localUpForm"><button
                            class="btn btn-danger profile-button" style="-c: #E95A49"
                            type="button">���</button></a> <a
                        href="${ctrpath}/host/delmem?hid=${session.sessionHID}"><button
                            class="btn btn-danger profile-button" style="-c: #E95A49"
                            type="button">����</button></a>
                </div>
            </div>
        </div>
		
		
	</div>
</div>