<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${ sessionScope.q.text }</h1><br>
<input type = "submit" value = "${ sessionScope.q.choicesA }">
<input type = "submit" value = "${ sessionScope.q.choicesB }">



</body>
</html>