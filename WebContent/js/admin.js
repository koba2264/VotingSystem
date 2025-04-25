/**
 * admin画面のjavaScript
 */


$(function() {
	var resultElm = document.getElementById('result');
	var votingElm = document.getElementById('voting');
    var url = "ws://54.226.220.20:8080/VotingSystem/WebSocketServer";
    var ws = new WebSocket(url);
    var flag = false;

    ws.onmessage = function(receive) {
        $("#standbycount").text('待機人数 : '+ receive.data + '人');
        console.log(receive.data);
    };

    ws.onopen = function() {
      ws.send("getStandByCount");
      console.log("接続");
    };

    resultElm.addEventListener('click', function() {
    	ws.send("goResult");
    });

    votingElm.addEventListener('click', function() {
    	ws.send("goVoting");
    });

  });