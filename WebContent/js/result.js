/**
 *
 */
$(function() {
    var url = "ws://localhost:8080/VotingSystem/WebSocketServer";
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

