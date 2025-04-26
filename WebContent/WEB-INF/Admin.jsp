<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ sessionScope.question.text }
	<form action="QuestionSelection.action" method="post">
		<select name="id">
			<c:forEach var="q" items="${ sessionScope.qList }">
				<option value='${ q.questionId2 }'>${ q.questionId2 } : ${ q.text2 }</option>
			</c:forEach>
		</select>
		<input type="submit" value="送信">
	</form>
	<p id="standbycount"></p>
	<button id="result">解答</button>
	<button id="voting">出題</button>
</body>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/admin.js"></script>
</html>