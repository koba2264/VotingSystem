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
  <div class="text">
	<h1>${ sessionScope.q.text }</h1><br>
  </div>
  <div class="container">
    <!-- 左の選択肢 -->
    <form class="choice-form" action="StandBy.action" method="post">
      <button type="submit" name="choice" value="A" class="choice-button left-button">${ sessionScope.q.choicesA }</button>
    </form>

    <!-- 右の選択肢 -->
    <form class="choice-form" action="StandBy.action" method="post">
      <button type="submit" name="choice" value="B" class="choice-button right-button">${ sessionScope.q.choicesB }</button>
    </form>
  </div>
</body>
<script>
window.confirm("これが確認ダイアログです。");
</script>
</html>