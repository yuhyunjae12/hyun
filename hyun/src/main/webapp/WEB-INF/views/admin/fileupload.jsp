<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>Please Select File to upload!!!</h1>

  <form method="POST" action="uploadFile" enctype="multipart/form-data">
	File to upload: <input type="file" name="file"> 
	<input type="submit" value="Upload">Press here to upload the file!
  </form>
	
  <p>${message}</p>
	
	
  <c:choose>
    <c:when test="${not empty fileName}">
	<img src="${fileName}" /> 
    </c:when>
    <c:otherwise>
	<p>Nothing to show</p>
    </c:otherwise>
 </c:choose>
	

</body>
</html>