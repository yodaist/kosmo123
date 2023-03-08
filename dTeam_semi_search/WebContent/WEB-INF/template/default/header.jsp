<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}/resources" />
<c:set var="ctrpath" value="${pageContext.request.contextPath}" />


<header>
	<div class="header-area ">
		<div id="sticky-header" class="main-header-area">
			<div class="container-fluid">
				<div class="header_bottom_border">
					<div class="row align-items-center">
						<div class="col-xl-2 col-lg-2">
							<div class="logo">
								<a href="${ctrpath}/main"> <img
									src="${path}/img/tour_logo1.png" alt=""
									onmouseover="this.src='${path}/img/tour_logo2.png'"
									onmouseout="this.src='${path}/img/tour_logo1.png'">
								</a>
							</div>
						</div>
						<div class="col-xl-6 col-lg-6">
							<div class="main-menu  d-none d-lg-block">
								<nav>
									<ul id="navigation">
										<li><a class="active"
											href="${ctrpath}/local/localboardList">��������</a></li>
										<li><a class="active"
											href="${ctrpath}/oversea/overseatrip">�ؿܿ���</a></li>
										<li><a href="#">��õ������ <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="${ctrpath}/recommend/home">���ɴ� �� ������</a></li>
												<li><a href="${ctrpath}/recommend/home">���� �� ������</a></li>
												<li><a href="${ctrpath}/recommend/home">�׸� �� ������</a></li>
												<li><a href="${ctrpath}/recommend/home">mbti �� ������</a></li>
											</ul></li>
										<li><a href="#">�����ı� <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="${ctrpath}/survey/surveyForm">��������</a></li>
												<li><a href="${ctrpath}/survey/surveyList">�ؿܿ���</a></li>
												
											</ul></li>
																				
										<li><a href="#">�������� <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="${ctrpath}/survey/surveyForm">�������� ���</a></li>
												<li><a href="${ctrpath}/survey/surveyList">���� ����Ʈ</a></li>
												<li><a href="${ctrpath}/tchart/preference">��Ʈpreference</a></li>
												<li><a href="${ctrpath}/tchart/gender">��Ʈgender</a></li>
											</ul></li>
										
										<li><a class="active"
											href="${ctrpath}/customernotice/listNo">��������</a></li>
										<!-- ������ or ȣ��Ʈ�� ���� ����? 	
										<li><a class="active" href="${ctrpath}/mail/emailForm">��������</a></li>
										-->
										<c:choose>
											<c:when test="${sessionScope.sessionID != null }">
												<li><a class="active"
													href="${ctrpath}/scheduler/schePath"> [
														${sessionScope.sessionName} ]���� ���� �����ٷ�</a></li>
											</c:when>
										</c:choose>
									</ul>
								</nav>
							</div>
						</div>
						<div class="col-xl-4 col-lg-4 d-none d-lg-block">
							<div
								class="social_wrap d-flex align-items-center justify-content-end">
								<link rel="stylesheet" href="${path}/css/header_text_neon.css">
								<div class="text">
									<c:choose>
										<c:when test="${sessionScope.sessionID == null }">
											<h3 class="neonText">welcome</h3>
										</c:when>
										<c:when test="${sessionScope.sessionID != null }">
											<h3 class="neonText">${sessionID }</h3>
										</c:when>
									</c:choose>
								</div>
								&nbsp;&nbsp;&nbsp;

								<div class="social_links d-none d-xl-block">
									<ul>
										<c:choose>
											<c:when test="${sessionScope.sessionID == null && sessionScope.sessionHID == null}">
												<li><a href="${ctrpath}/chooseLogin">LogIn</a></li>
												<li><a href="${ctrpath}/chooseSignup">SignUp</a></li>
											</c:when>
											<c:when test="${sessionScope.sessionID != null }">
												<li><a href="${ctrpath}/calendar/calendarList">���೻��</a></li>
												<li><a href="${ctrpath}/interest/listCart">����</a></li>
												<li><a
													href="${ctrpath}/member/mypage?mid=${sessionScope.sessionID}">����������</a></li>
												<li><a href="${ctrpath}/login/logoutProcess">LogOut</a></li>
											</c:when>
											<c:when test="${sessionScope.sessionHID != null }">
												<li><a href="${ctrpath}/calendar/calendarList">����Ȯ���ϱ�</a></li>
												<li><a
													href="${ctrpath}/host/hostpage?hid=${sessionScope.sessionHID}">ȣ��Ʈ������</a></li>
												<li><a href="${ctrpath}/hlogin/hlogoutProcess">LogOut</a></li>
											</c:when>
										</c:choose>


									</ul>
								</div>
							</div>
						</div>
						<div class="seach_icon">
							<a data-toggle="modal" data-target="#exampleModalCenter" href="#">
								<i class="fa fa-search"></i>
							</a>
						</div>
						<div class="col-12">
							<div class="mobile_menu d-block d-lg-none"></div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</header>