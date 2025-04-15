$(function() {
    var url = "ws://localhost:8080/VotingSystem/WebSocketServer";
    var ws = new WebSocket(url);
    var flag = false;

    ws.onmessage = function(receive) {
        $("#id").text(receive.data);
    };

    ws.onopen = function() {
      ws.send("WebSocketでメッセージを送信します！");
      console.log("メッセージを送信しました！");
    };
  });