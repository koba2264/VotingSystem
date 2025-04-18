<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/question.css" type="text/css">
</head>
<body>
<%-- 問題表示 --%>
<h1>${ sessionScope.q.text }</h1><br>
<body>
  <div class="container">
    <!-- 左の選択肢（猫派） -->
    <form class="choice-form" action="ChoiceServlet" method="post">
      <button type="submit" name="choice" value="A" class="choice-button left-button">${ sessionScope.q.choicesA }</button>
    </form>

    <!-- 右の選択肢（犬派） -->
    <form class="choice-form" action="ChoiceServlet" method="post">
      <button type="submit" name="choice" value="B" class="choice-button right-button">${ sessionScope.q.choicesB }</button>
    </form>
  </div>
</body>
</html>