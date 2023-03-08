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
											href="${ctrpath}/local/localboardList">국내여행</a></li>
										<li><a class="active"
											href="${ctrpath}/oversea/overseatrip">해외여행</a></li>
										<li><a href="#">추천여행지 <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="${ctrpath}/recommend/home">연령대 별 여행지</a></li>
												<li><a href="${ctrpath}/recommend/home">지역 별 여행지</a></li>
												<li><a href="${ctrpath}/recommend/home">테마 별 여행지</a></li>
												<li><a href="${ctrpath}/recommend/home">mbti 별 여행지</a></li>
											</ul></li>
										<li><a href="#">여행후기 <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="${ctrpath}/survey/surveyForm">국내여행</a></li>
												<li><a href="${ctrpath}/survey/surveyList">해외여행</a></li>
												
											</ul></li>
																				
										<li><a href="#">설문조사 <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="${ctrpath}/survey/surveyForm">설문조사 등록</a></li>
												<li><a href="${ctrpath}/survey/surveyList">설문 리스트</a></li>
												<li><a href="${ctrpath}/tchart/preference">차트preference</a></li>
												<li><a href="${ctrpath}/tchart/gender">차트gender</a></li>
											</ul></li>
										
										<li><a class="active"
											href="${ctrpath}/customernotice/listNo">공지사항</a></li>
										<!-- 관리자 or 호스트만 보기 가능? 	
										<li><a class="active" href="${ctrpath}/mail/emailForm">메일전송</a></li>
										-->
										<c:choose>
											<c:when test="${sessionScope.sessionID != null }">
												<li><a class="active"
													href="${ctrpath}/scheduler/schePath"> [
														${sessionScope.sessionName} ]님의 여행 스케줄러</a></li>
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
												<li><a href="${ctrpath}/calendar/calendarList">예약내역</a></li>
												<li><a href="${ctrpath}/interest/listCart">찜목록</a></li>
												<li><a
													href="${ctrpath}/member/mypage?mid=${sessionScope.sessionID}">마이페이지</a></li>
												<li><a href="${ctrpath}/login/logoutProcess">LogOut</a></li>
											</c:when>
											<c:when test="${sessionScope.sessionHID != null }">
												<li><a href="${ctrpath}/calendar/calendarList">예약확인하기</a></li>
												<li><a
													href="${ctrpath}/host/hostpage?hid=${sessionScope.sessionHID}">호스트페이지</a></li>
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