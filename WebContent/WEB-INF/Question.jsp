<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 問題表示 --%>
<h1>${ sessionScope.q.text }</h1><br>
<%--選択肢2つ表示。 --%>
<form action="StandBy.action" method="post">
	<input type="radio" id="choices" name="choice" value="A" checked />
    <label for="A">${ sessionScope.q.choicesA }</label>
    <input type="radio" id="choices" name="choice" value="B" checked />
    <label for="B">${ sessionScope.q.choicesB }</label>
</form>

</body>
</html>