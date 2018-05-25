<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<form:form modelAttribute="productForm" name="productForm" action="/admin/productUpdateAfter" method="post" enctype="multipart/form-data">
	<table width="100%">
				  <col width="10%">
				  <col width="10%">
				  <col width="10%">
				  <col width="10%">
				  <col width="10%">
				  <col width="10%">
				  <col width="10%">
				  <col width="10%">
				  <col width="10%">
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
					<tr>
						<td>${productDetail.pdNo}</td>
						<td>${productDetail.pdName}</td>
						<td>${productDetail.pdGender}</td>
						<td>${productDetail.pdKind}</td>
						<td>${productDetail.pdPrice}</td>
						<td>${productDetail.pdSale}</td>
						<td>${productDetail.pdVaccine}</td>
						<td>${productDetail.pdBirth}</td>
						<td>${productDetail.pdImg}</td>
						<td>${productDetail.pdRegdate}</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="수정">
							<a class="btnnew noty" onclick="javascript:history.back();">취소</a>
						</td>
					</tr>
	</table>
</form:form>
</body>
</html>