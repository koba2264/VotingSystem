/**
 *
 */
$(function() {
    var url = "ws://98.80.123.11:8080/VotingSystem/WebSocketServer";
    var ws = new WebSocket(url);
    var flag = false;

    ws.onmessage = function(receive) {
    	if (receive.data=="goVoting") {
    		window.location.href = "Voting.action";
    	}
        console.log(receive.data);
    };

    ws.onopen = function() {
      ws.send("Result");
      console.log("接続");
    };
  });

