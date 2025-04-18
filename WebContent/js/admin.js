/**
 * admin画面のjavaScript
 */


$(function() {
	var buttonElm = document.getElementById('result');
	var i = "ii";
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

    buttonElm.addEventListener('click', function() {
    	console.log(i);
    	ws.send("goResult");
    });
  });