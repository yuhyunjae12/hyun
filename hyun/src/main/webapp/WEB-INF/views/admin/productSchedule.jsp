<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='/resources/css/theme.css' />
<link rel='stylesheet' type='text/css' href='/resources/css/fullcalendar.css' />
<script type='text/javascript' src='/resources/js/jquery.js'></script>
<script type='text/javascript' src='/resources/js/jquery-ui-custom.js'></script>
<script type='text/javascript' src='/resources/js/fullcalendar.min.js'></script>
<script type='text/javascript'>

	$(document).ready(function() {
	
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		$('#calendar').fullCalendar({
			theme: true,
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			editable: true,
			events: [
				{
					title: 'All Day Event',
					start: new Date(y, m, 1)
				},
				{
					title: 'Long Event',
					start: new Date(y, m, d-5),
					end: new Date(y, m, d-2)
				},

			]
		});
		
	});

</script>
<style type='text/css'>

	body {
		margin-top: 40px;
		text-align: center;
		font-size: 13px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		}

	#calendar {
		width: 900px;
		margin: 0 auto;
		}

</style>
</head>
<body>

<div id='calendar'></div>

<select class="memotype">
	<c:choose>
		<c:when test="${empty userList}">
		  	<option>--------회원이없습니다--------</option>
		</c:when>
		<c:otherwise>
	  		<c:forEach items="${userList }" var="userList">
	  			<option>${userList.uId}</option>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</select>

<select class="memotype">
	<option>분양주소</option>
	<option>분양주소</option>
	<option>분양시간</option>
</select>
<select class="memotype">
	<option>분양시간</option>
	<option>분양주소</option>
	<option>분양시간</option>
</select>
<input type="text" value="날짜"/>
<input type="text" value="상품이름"/>
<textarea>여기는 메모공간</textarea>





</body>
</html>
