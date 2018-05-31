<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="topic-header">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<h1>UserAdminList</h1>
					<p>userList</p>
				</div>	<!-- End of /.col-md-4 -->
			</div>	<!-- End of /.row -->
		</div>	<!-- End of /.container -->
	</section>	<!-- End of /#Topic-header -->
	
<section id="shop">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
          <div class="esconde" id="opdRetro">
            <table class="table table-striped table-hover ">
            <thead>
                <tr class="bg-primary">
                    <th>회원번호</th>
                    <th>회원아이디</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                    <th>주소</th>
                    <th>가입일</th>
                    <th>탈퇴일</th>
                    <th>등급</th>
                    <th>탈퇴여부</th>
                </tr>
            </thead>
            <tbody> <!-- para abrir em outra aba adicionar target="_blank" -->
            				<c:choose>
					<c:when test="${empty userList}">
							<tr>
					  			<td colspan="8">--------유저가 없습니다.--------</td>
					  		</tr>
					</c:when>
					<c:otherwise>
						  		<c:forEach items="${userList }" var="userList">
						  			<tr>
						  				<td>${userList.urNo}</td>
						  				<td><a href="#">${userList.urId}</a></td>
						  				<td>${userList.urPhone}</td>
						  				<td>${userList.urEmail}</td>
						  				<td>${userList.urAddr}</td>
						  				<td><fmt:formatDate value="${userList.urRegdate}" pattern="yy-MM-dd"/></td>
						  				<td><fmt:formatDate value="${userList.urDropdate}" pattern="yy-MM-dd"/></td>
						  				<td>${userList.urGrade}</td>
									    <td>
									    <select name="urYn">
									      <option <c:if test="${userList.urYn == 'Y'}">checked</c:if>>Y</option>
									      <option <c:if test="${userList.urYn == 'N'}">checked</c:if>>N</option>
									    </select>
									    </td>
						  			</tr>
						  		</c:forEach>
						  	</c:otherwise>
				</c:choose>
				</tbody>
				</table>
				</div>
				</div>
			</div>
		</div>	<!-- End of /.container -->
	</section>	<!-- End of Section -->	
</body>
</html>