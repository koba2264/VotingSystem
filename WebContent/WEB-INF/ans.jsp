<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.Question" %>
<html>
<head>
    <title>問題表示</title>
</head>
<body>
    <%
        Question question = (Question) request.getAttribute("question");
    %>
    <h1>問題</h1>
    <p><%= question.getText() %></p>

    <h2>選択肢</h2>
    <ul>
        <li><%= question.getChoicesA() %></li>
        <li><%= question.getChoicesB() %></li>
    </ul>
</body>
</html>
