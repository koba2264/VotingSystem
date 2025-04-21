<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>待機画面</title>
  <link rel="stylesheet" href="css/standby.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Dela+Gothic+One&family=Kaisei+Opti&family=RocknRoll+One&display=swap" rel="stylesheet">
</head>
<body id = "target">
  <div>
	  <div class="title">投票中・・・</div>
	  <div id="count" class="text"></div>
	  <img src="vacation.gif" class="gif">
  </div>
</body>
    <script>
    	var bodyElm = document.getElementById("target");
    	var ans = "${ sessionScope.ans }"
    	if (ans == "A") {
    		bodyElm.style.background = "linear-gradient(to right,#FF3399,#FFEEFF,#FF3399)";
    	} else {
    		bodyElm.style.background = "linear-gradient(to right,#54acdb,#FFEEFF,#54acdb)";
    	}
    </script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/stand_by.js"></script>
</html>