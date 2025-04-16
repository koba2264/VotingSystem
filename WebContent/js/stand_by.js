$(function() {
    var url = "ws://localhost:8080/VotingSystem/WebSocketServer";
    var ws = new WebSocket(url);
    var flag = false;

    ws.onmessage = function(receive) {
        $("#count").text(receive.data);
        console.log(receive.data);
    };

    ws.onopen = function() {
      ws.send("newConnection");
      console.log("接続");
    };
  });