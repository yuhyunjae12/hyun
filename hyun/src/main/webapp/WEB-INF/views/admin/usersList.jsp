<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<style type="text/css">
<!--
a:link { font-family: "";font-size:14pt; text-decoration:none; color:darkblue}
a:visited { font-family: "";font-size:14pt;text-decoration:none; color:darkblue}
a:hover {font-family: "";font-size:14pt;text-decoration::none; color:red}
font {  font-family: ""; font-size:14pt; text-decoration: none}
.inputline {  border:1 solid; color: #002669}
.input {  border:1 solid}
.head {  font-family: "arial"; font-size: 10pt; font-weight: bold; color: #000000}
.text_jp {  font-family: ""; font-size:9pt; line-height: 12pt}
.text_sjp {  font-family: ""; font-size:8pt; line-height: 12pt}
.text_mjp {  font-family: ""; font-size:11pt; line-height: 12pt}
.text_bjp {  font-family: ""; font-size:12pt; line-height: 12pt}
.body1{ font-size:38px;}
.body2{ font-size:26px;}
.body3{ font-size:14px;}
.body4{ font-size:8px;}
.body5{ font-size:10px;}
.body6{ font-size:9px;}
.lt { font-size:12pt; text-decoration: line-through }
input.locked {  background-color:#DDDDDD;  } 
-->
</style>
<%@ page import ="java.text.*,java.util.*" contentType="text/html;charset=euc-kr" %>
<%   
int year;
int month;
   Calendar today=Calendar.getInstance();
   Calendar cal = new GregorianCalendar();
   year = (request.getParameter("year")==null) ?  today.get(Calendar.YEAR) :      Integer.parseInt(request.getParameter("year").trim()) ;
 month = (request.getParameter("month")==null) ?   today.get(Calendar.MONTH)+1:      Integer.parseInt(request.getParameter("month").trim()) ;
if (month<=0){
 month = 12;
 year  =year- 1;
}else if (month>=13){
 month = 1;
 year =year+ 1;
}
   cal.set(Calendar.YEAR,year);
   cal.set(Calendar.MONTH,(month-1));
   cal.set(Calendar.DATE,1);
%>

<body>


<table align="center" bgcolor='#CCE3C6'>
<table align="center" bgcolor='#CCE3C6'>
<tr >
 <td align="center" bgcolor='#CCE3C6' height='18' valign='bottom' colspan="7">
   <a href='calendar.jsp?year=<%=cal.get(Calendar.YEAR)%>&month=<%=((cal.get(Calendar.MONTH)+1)-1)%>'><font color='484848' size='2'>◀ </font></a><font color='484848' size='2'><%=cal.get(Calendar.YEAR)%> / <%=(cal.get(Calendar.MONTH)+1)%> </font><a href='calendar.jsp?year=<%=cal.get(Calendar.YEAR)%>&month=<%=((cal.get(Calendar.MONTH)+1)+1)%>'><font color='484848' size='2'>▶ </font></a>
 </td></tr>
<tr align="right" bgcolor="#6ea1aa">
<td>  일</td><td>  월</td><td>  화</td><td>  수</td><td>  목</td><td>  금</td><td>  토</td>
</tr>
<%   
cal.set(year, month-1, 1);
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
%>
<tr align="right" bgcolor="#6ea1aa">
<%
for(int i=1;i<dayOfWeek;i++){ 
%><td align="right" bgcolor="#CCE3C6"></td>
<% }
for(int i=1;
        i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++){
    %>
<td>
  <a href='day.jsp?year=<%=cal.get(Calendar.YEAR)%>&month=<%=((cal.get(Calendar.MONTH)+1))%>&day=<%=i %>'><%=i %></a>
  </td><% 
            if((dayOfWeek-1+i)%7==0){
                %></tr><tr align="right" bgcolor="#6ea1aa">
   <% }
  }%>
 
 </tr>
</table>
</table>


</body>
</html>