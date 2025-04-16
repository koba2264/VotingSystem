package server;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import bean.Count;
import dao.CountDAO;

@ServerEndpoint("/WebSocketServer")
public class WebSocketServer {

	private static final Set<Session> sessions = new CopyOnWriteArraySet<>();

    @OnMessage
    public String onMessage(String message,Session senderSession) {
    	System.out.println("WebSocketで受信したメッセージ：" + message);
    	// データベース接続
    	CountDAO dao = new CountDAO();
    	Count count = null;
    	try {
    		count = dao.serch(1);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	// 待機人数受け取り
    	String result = String.valueOf(count.sum());
    	// 保存しているセッションIDの数繰り返す
        for (Session session : sessions) {
        	// セッションが開いている場合
            if (session.isOpen()) {
//            	人数を送る
                session.getAsyncRemote().sendText(result);
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
    	sessions.add(session);
    	System.out.println("WebSocketセッション確立");
    }

    @OnClose
    public void onClose(Session session) {
    	// セッションを終了する際の処理を実装
    	// セッションIDを削除
    	sessions.remove(session);
        System.out.println("WebSocketセッション終了");
    }
}