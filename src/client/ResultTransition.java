package client;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class ResultTransition {

	private Session session;

    @OnOpen
    public void onOpen(Session session) {
    	this.session = session;
        System.out.println("Connected to server");
        sendMessage("goResult");
    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://echo.websocket.org";
        try {
            container.connectToServer(ResultTransition.class, URI.create(uri));
            System.out.println("Connected to server");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}
