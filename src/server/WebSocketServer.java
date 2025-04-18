package server;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import bean.Question;

@ServerEndpoint("/WebSocketServer")
public class WebSocketServer {

//	待機状態のセッションを保存する変数
	private static final Set<Session> StandBySessions = new CopyOnWriteArraySet<>();
//	解答画面表示状態のセッションを保存する変数
	private static final Set<Session> ResultSessions = new CopyOnWriteArraySet<>();

    @OnMessage
    public String onMessage(String message,Session senderSession) {
    	System.out.println("WebSocketで受信したメッセージ：" + message);
    	// データベース接続
    	if (message.equals("StandBy")){
    		StandBySessions.add(senderSession);
    		// 待機画面にいる人数
    		String tmp = String.valueOf(StandBySessions.size());
    		// 保存しているセッションIDの数繰り返す
    		for (Session session : StandBySessions) {
    			// セッションが開いている場合
    			if (session.isOpen()) {
    				// 人数を送る
    				session.getAsyncRemote().sendText(tmp);
    			}
    		}
    	} else if (message.equals("Result")) {
    		ResultSessions.add(senderSession);
    	} else if (message.equals("goResult")) {
    		for (Session session : StandBySessions) {
    			// セッションが開いている場合
    			if (session.isOpen()) {
    				session.getAsyncRemote().sendText(message);
    			}
    		}
    	} else if (message.equals("goVoting")) {
    		Question.resetSessionList();
    		for (Session session : ResultSessions) {
    			// セッションが開いている場合
    			if (session.isOpen()) {
    				session.getAsyncRemote().sendText(message);
    			}
    		}
    	}
        return null;
    }

    @OnError
    public void onError(Throwable th) {
        // WebSocketエラーが発生した際の処理を実装
        System.out.println("WebSocketエラーが発生：" + th.getMessage());
    }

    @OnOpen
    public void onOpen(Session session) {
        // セッションが確立した際の処理を実装
    	// セッションIDを保存
    	System.out.println("WebSocketセッション確立");
    }

    @OnClose
    public void onClose(Session session) {
    	// セッションを終了する際の処理を実装
    	// セッションIDを削除
    	StandBySessions.remove(session);
    	ResultSessions.remove(session);
		String tmp = String.valueOf(StandBySessions.size());
		// 保存しているセッションIDの数繰り返す
		for (Session session1 : StandBySessions) {
			// セッションが開いている場合
			if (session1.isOpen()) {
				// 人数を送る
				session.getAsyncRemote().sendText(tmp);
			}
		}
        System.out.println("WebSocketセッション終了");
    }
}