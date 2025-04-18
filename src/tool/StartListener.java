package tool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.CountDAO;

public class StartListener implements ServletContextListener {

	// アプリ終了時
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {


	}

	// アプリ開始時
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		int ok = 0;
		CountDAO dao = new CountDAO();
		try {
			ok = dao.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ok);
	}

}
