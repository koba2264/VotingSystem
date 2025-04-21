$(function() {
    var url = "ws://localhost:8080/VotingSystem/WebSocketServer";
    var ws = new WebSocket(url);
    var flag = false;

    ws.onmessage = function(receive) {
    	if (receive.data=="goResult") {
    		window.location.href = "Result.action";
    	} else {
    		$("#count").text('現在' + receive.data + 'グループが投票済み');
    	}
        console.log(receive.data);
    };

    ws.onopen = function() {
      ws.send("StandBy");
      console.log("接続");
    };
  });