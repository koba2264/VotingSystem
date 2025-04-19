<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.text.DecimalFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>結果発表</title>
  <link rel="stylesheet" href="css/result.css" type="text/css">
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Dela+Gothic+One&family=Kaisei+Opti&family=RocknRoll+One&display=swap" rel="stylesheet">
</head>
<body>
<div class="container">
	<div class="title">${ sessionScope.q.text }</div>
    <div class="chart">
    	<div class="vs">VS</div>
    </div>
    <div class="amon">${ sessionScope.q.choicesA }</div>
   	<div class="percent right" id="percentageright">0%</div>
	<div class="bmon" >${ sessionScope.q.choicesB }</div>
    <div class="percent left" id="percentageleft" >0%</div>
	<div class='size'>
		<canvas id="myChart"></canvas>
  	</div>
</div>

  <script>
 	  const avgA = ${ sessionScope.avgA };
 	  const avgB = ${ sessionScope.avgB };

 //グラフ
	  var ctx = document.getElementById("myChart").getContext("2d");
 	  //グラフカラーA
	  var gradientA = ctx.createLinearGradient(0, 0,0, 300);
	  gradientA.addColorStop(0, "#C299FF");
	  gradientA.addColorStop(1, "#FFABCE");
	  //グラフカラーB
	  var gradientB = ctx.createLinearGradient(0, 0, 0, 300);
	  gradientB.addColorStop(0, "#FF773E");
	  gradientB.addColorStop(1, "#FFC7AF");

	  var myChart = new Chart(ctx, {
	    //円グラフの指定
		type: 'pie',
	    data: {
	      //labels: ["B","A"],
	      datasets: [{
	       //グラフの色
	      backgroundColor: [gradientA, gradientB],
	       //データ割合
	      data: [${ sessionScope.B },${ sessionScope.A }],
	      //外枠
	      borderWidth: 0.6
	      }]
	    },
	    options: {
	      title: {
	        //display: true,
	  		text: '究極の選択',
	      },
	      animation: {
	        //グラフの表示にかかる時間
	  		duration: 4000,
	      },
	    }
	  });
      // パーセンテージアニメーション
      function animatePercentage(target, duration, elementId) {
    	  target = Math.round(target);
          let start = 0;
          let end = target;
          let range = end - start;
          let stepTime = Math.abs(Math.floor(duration / range));
          let obj = document.getElementById(elementId);
          let current = start;
          let increment = end > start ? 1 : -1;
          //値がゼロのときアニメーションさせない
          if (end === 0) {
        	    obj.textContent = "0%";
        	    return;
        	}

          let timer = setInterval(function() {
              current += increment;
              obj.textContent = current + "%";
              if (current == end) {
                  clearInterval(timer);
              }
          }, stepTime);
      }
      function showWinner() {
    	  if (avgA > avgB) {
    	    document.getElementById("percentageleft").classList.add("winner-percent");
    	    document.querySelector(".title").classList.add("title-winner-a");
    	  } else if (avgB > avgA) {
    	    document.getElementById("percentageright").classList.add("winner-percent");
    	    document.querySelector(".title").classList.add("title-winner-b");
    	  }
    	}
      // 左(データ割合,表示するまでの時間)(A)
      animatePercentage(avgA, 3000, "percentageleft");
      // 右(データ割合,表示するまでの時間)(B)
      animatePercentage(avgB, 3000, "percentageright");
      // グラフ＆アニメ終了後に勝者エフェクト発動
      setTimeout(showWinner, 4000);


</script>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/result.js"></script>
</html>