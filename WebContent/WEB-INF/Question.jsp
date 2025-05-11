<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta content="text/html; charset=UTF-8">
    <title>問題</title>
    <link rel="stylesheet" href="css/question.css" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dela+Gothic+One&family=Kaisei+Opti&family=RocknRoll+One&display=swap" rel="stylesheet">
</head>
<body>
  <div class="text">

	<h1 id="title">${ sessionScope.question.text }</h1><br>
  </div>
  <div class="container">
    <!-- 左の選択肢 -->
    <div class="choice left">
        ${ sessionScope.question.choicesA }
    </div>

    <!-- 右の選択肢 -->
    <div class="choice right">
        ${ sessionScope.question.choicesB }
    </div>
  </div>
  <div class="popup">
    <div>
      <p class="popup-text">に投票しますか</p>
    </div>
    <div class="popup-button">
        <button class="ok-button">OK！</button>
        <button class="cancel-button">キャンセル</button>
    </div>
  </div>
</body>
<script src="js/select.js"></script>
<script>
  const choiceElm = document.querySelectorAll(".choice");
  const popupTxtElm = document.querySelector('.popup-text');
  for (const elm of choiceElm) {
    elm.addEventListener('click',() => {
      if (elm.classList.contains('left')) {
        popupTxtElm.innerHTML = '<p class="popup-text">${ sessionScope.question.choicesA }に投票しますか</p>';
      } else {
        popupTxtElm.innerHTML = '<p class="popup-text">${ sessionScope.question.choicesB }に投票しますか</p>';
      }
    });
  };
  window.location.replace('StandBy.action');
</script>
</html>