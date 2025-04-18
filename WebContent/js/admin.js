/**
 * admin画面のjavaScript
 */


$(function() {
	var resultElm = document.getElementById('result');
	var votingElm = document.getElementById('voting');
    var url = "ws://localhost:8080/VotingSystem/WebSocketServer";
    var ws = new WebSocket(url);
    var flag = false;

    ws.onmessage = function(receive) {
        $("#current_text").text(receive.data);
        console.log(receive.data);
    };

    ws.onopen = function() {
      ws.send("newConnection");
      console.log("接続");
    };

    resultElm.addEventListener('click', function() {
    	ws.send("goResult");
    });

    votingElm.addEventListener('click', function() {
    	ws.send("goVoting");
    });

  });