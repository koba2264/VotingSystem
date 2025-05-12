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
<div id="result" class="loading-screen">
  結果は……
</div>
<div class="container">
	<!-- 問題 -->
	<div class="title">${ sessionScope.question.text }</div>
	<!-- vsマーク -->
    <div class="chart">
    	<div class="vs">対</div>
    </div>
    <!-- Aの問題文 -->
    <div class="amon">${ sessionScope.question.choicesA }</div>
    <!-- Aの％ -->
   	<div class="percent right" id="percentageright">0%</div>
    <!-- Aの人数 -->
    <div class="anum num" id="anum"></div>
    <!-- Bの問題文 -->
	<div class="bmon" >${ sessionScope.question.choicesB }</div>
    <!-- Bの％ -->
    <div class="percent left" id="percentageleft" >0%</div>
    <!-- Bの人数 -->
	<div class="bnum num" id="bnum"></div>
   	<!-- グラフ -->
	<div class='size'>
		<canvas id="myChart"></canvas>
  	</div>
</div>

  <script>
  	  //平均値
 	  const avgA = ${ sessionScope.avgA };
 	  const avgB = ${ sessionScope.avgB };
 	  //合計人数
 	  const rawA = ${ sessionScope.A };
 	  const rawB = ${ sessionScope.B };
 	  const intA = Math.round(rawA);
 	  const intB = Math.round(rawB);
 	 window.addEventListener("DOMContentLoaded", () => {
 		  const loading = document.getElementById("result");
 		  const chartCanvas = document.getElementById("myChart").parentElement;
 		  const allResultElements = document.querySelector(".container");

 		  document.getElementById("anum").textContent = intA + "グループ";
 		  document.getElementById("bnum").textContent = intB + "グループ";
 		  // 初期状態で非表示にしておく
 		  chartCanvas.style.display = "none";
 		  allResultElements.style.display = "none";

 		  // 結果表示の演出
 		  setTimeout(() => {
 		    loading.classList.add("hide");

 		    // 結果画面を表示
 		    chartCanvas.style.display = "flex";
 		    allResultElements.style.display = "flex";

 		   //グラフ
 		    var ctx = document.getElementById("myChart").getContext("2d");
 		    //グラフカラーA
 		  	var gradientA = ctx.createLinearGradient(0, 0,0, 300);
 		  	gradientA.addColorStop(0, "#00bfff");
 		  	gradientA.addColorStop(1, "#005FFF");
 		  	//グラフカラーB
 		  	var gradientB = ctx.createLinearGradient(0, 0, 0, 300);

 		  	gradientB.addColorStop(0, "#ff4d00");
 		  	gradientB.addColorStop(1, "#ff3399");

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
 		  	  duration: 5500,
 		  	 },
 		  	}
 		   });
 		    // 左(データ割合,表示するまでの時間)(A)
 		    animatePercentage(avgA, 4500, "percentageleft");
 		    // 右(データ割合,表示するまでの時間)(B)
 		    animatePercentage(avgB, 4500, "percentageright");
 		    // 勝者表示
 		    setTimeout(showWinner, 5000);
 		  },3500); // 3秒待ってから実行
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

//勝者の演出
      function showWinner() {
    	  if (avgA > avgB) {
    	    document.getElementById("percentageleft").classList.add("winner-percent");
    	    document.querySelector(".amon").classList.add("title-winner-a");
            document.body.classList.add("background-winner-a");
    	  } else if (avgB > avgA) {
    	    document.getElementById("percentageright").classList.add("winner-percent");
    	    document.querySelector(".bmon").classList.add("title-winner-b");
            document.body.classList.add("background-winner-b");
    	  }
    	  document.getElementById("anum").classList.add("show");
    	  document.getElementById("bnum").classList.add("show");
    	}

</script>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/result.js"></script>
</html>