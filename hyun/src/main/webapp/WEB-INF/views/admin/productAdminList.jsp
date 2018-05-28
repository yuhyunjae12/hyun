<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<section id="topic-header">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<h1>ProductAdminList</h1>
					<p>AdminProducts</p>
				</div>	<!-- End of /.col-md-4 -->
				<div class="col-md-8 hidden-xs">
					<ol class="breadcrumb pull-right">
					  	<li><a href="/admin/main">admin</a></li>
					  	<li class="active">ProductAdminList</li>
					</ol>
				</div>	<!-- End of /.col-md-8 -->
			</div>	<!-- End of /.row -->
		</div>	<!-- End of /.container -->
	</section>	<!-- End of /#Topic-header -->
	
<section id="shop">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="products-heading">
						<h2>ProductList</h2>
				</div>	<!-- End of /.Products-heading -->
			<table width="100%" class="table table-condensed table-hover">
						  <col width="5%">
						  <col width="10%">
						  <col width="5%">
						  <col width="10%">
						  <col width="10%">
						  <col width="10%">
						  <col width="15%">
						  <col width="10%">
						  <col width="15%">
						  <col width="10%">
						  <tr style="text-align: center;">
						    <th>No</th>
						    <th>상품명</th>
						    <th>성별</th>
						    <th>품종</th>
						    <th>가격</th>
						    <th>분양여부</th>
						    <th>예방접종</th>
						    <th>생년월일</th>
						    <th>이미지</th>
						    <th>등록일</th>
						  </tr>
				<c:choose>
					<c:when test="${empty productList}">
							<tr>
					  			<td colspan="10">--------상품이없습니다--------</td>
					  		</tr>
					</c:when>
					<c:otherwise>
						  		<c:forEach items="${productList }" var="productList">
						  			<tr>
						  				<td>${productList.pdNo}</td>
						  				<td><a href="/admin/productAdminDetail?pdNo=${productList.pdNo}">${productList.pdName}</a></td>
						  				<td>${productList.pdGender}</td>
						  				<td>${productList.pdKind}</td>
						  				<td><fmt:formatNumber value="${productList.pdPrice}" pattern="#,###"/></td>
						  				<td>${productList.pdSale}</td>
						  				<td>${productList.pdVaccine}</td>
						  				<td>${productList.pdBirth}</td>
						  				<td>${productList.pdImg}</td>
						  				<td><fmt:formatDate value="${productList.pdRegdate}" pattern="yy-MM-dd"/></td>
						  			</tr>
						  		</c:forEach>
						  	</c:otherwise>
				</c:choose>
			</table>
			<input type="button" class="btn btn-success" value="상품등록" onclick="location.href='/admin/productWrite';">
			<a href="/admin/product/productExcelDownload"><img width="22px" height="22px" src="/resources/images/excellogo.png" />엑셀 다운로드</a>	
			<div class="pagination-bottom">
				<ul class="pagination">
				  	<li class="disabled"><a href="#">&laquo;</a></li>
				  	<li class="active"><a href="#">1 <span class="sr-only"></span></a></li>
				  	<li><a href="#">2</a></li>
				  	<li><a href="#">3</a></li>
				  	<li><a href="#">4</a></li>
				  	<li><a href="#">»</a></li>
				</ul>	<!-- End of /.pagination -->
				</div>
				</div>
			</div>
		</div>	<!-- End of /.container -->
	</section>	<!-- End of Section -->	
</body>
</html>