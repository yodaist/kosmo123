<%@page import="kr.co.kosmo.mvc.vo.BookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<meta charset="EUC-KR">

<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar-scheduler@6.1.0/index.global.min.js'></script>

<!-- calendar -->
<script>
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView : 'dayGridMonth',
		locale : 'ko', // 한국어 설정
		headerToolbar : {
        	start : "title", //우측
            center : "prev,addEventButton,next", //중간
            end : 'dayGridMonth,dayGridWeek,dayGridDay' //좌측
            },
	selectable : true,
    customButtons: {
        addEventButton: {
          text: 'add event...',
          click: function() {
            var dateStr = prompt('Enter a date in YYYY-MM-DD format');
            var date = new Date(dateStr + 'T00:00:00'); // will be in local time

            if (!isNaN(date.valueOf())) { // valid?
              calendar.addEvent({
                title: 'dynamic event',
                start: date,
                allDay: true
              });
              alert('You just updated your schedule! XD');
            } else {
              alert('Invalid date:(');
            }
          }
        }
      },
	droppable : true,
	editable : true,
	events : [ 
    	    <%List<BookVO> calendarList = (List<BookVO>) request.getAttribute("calendarList");%>
            <%if (calendarList != null) {%>
            <%for (BookVO vo : calendarList) {%>
            {
            	title : '<%=vo.getBstatus()%>',
                start : '<%=vo.getSdate()%>',
                end : '<%=vo.getEdate()%>',
                color : '#' + Math.round(Math.random() * 0xffffff).toString(16)
             },
				<%}
}%>
				]				
			});
			calendar.render();
		});
</script>

<header>
	<h1>MY Calendar</h1>
</header>
<ul class="list-unstyled">
	<li class="border-top my-3"></li>
</ul>

<div class="container mt-3" align="center">
	<%-- calendar --%>
	<div id='calendar'></div>
	<%-- calendar --%>

	<div class="container mt-3" align="center">
		<a href="pro.kosmo?cmd=nvdate&scmd=nform"><button type="button"
				class="btn btn-primary">예약 수정</button></a> <a
			href="pro.kosmo?cmd=nvdate&scmd=resercancel"><button
				type="button" class="btn btn-secondary">예약 취소</button></a>
	</div>
</div>

<br>
