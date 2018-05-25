<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="productForm" name="productForm" action="/admin/productWriterAfter" method="post" enctype="multipart/form-data">

	<h3>상품 등록</h3>

		<input type="text" name="pdName" placeholder="이름을 입력해주세요">
			<br>
				<form:errors path="pdName" />
			<br>
		<select name="pdGender">
				<option>남</option>
				<option>여</option>
		</select>	
			<br>
				<form:errors path="pdGender" />
			<br>
		<input type="text" name="pdKind" placeholder="품종을 입력해주세요">
			<br>
				<form:errors path="pdKind" />
			<br>
		<input type="text" name="pdPrice" placeholder="가격을 입력해주세요">
			<br>
				<form:errors path="pdPrice" />
			<br>
		<select name="pdSale">
			<option>Y</option>
			<option>N</option>
		</select>
			<br>
				<form:errors path="pdSale" />
			<br>
		<select name="pdVaccine">
			<option>1차예방접종완료</option>
			<option>2차예방접종완료</option>
		</select>
			<br>
				<form:errors path="pdVaccine" />
			<br>
		<input type="text" name="pdBirth" placeholder="생일을 입력해주세요">
			<br>
				<form:errors path="pdBirth" />
			<br>
		<input type="file" name="productImg" id="productImg" />
			<br>
				<input type="submit" value="등록">
			<br>
</form:form>
	<a class="btnnew noty" onclick="javascript:history.back();">취소</a>
</body>
</html>