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
<body>
  <div id = "target">
	  <div class="title">投票中・・・</div>
	  <div id="count" class="text"></div>
	  <img src="vacation.gif" class="gif">
  </div>
</body>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/stand_by.js"></script>
    <script>
    	var ans = "${ sessionScope.ans }"
    	if (ans == "A") {
	    	$('#target').addClass("red");
    	} else {
    		$('#target').addClass("blue");
    	}
    </script>
</html>