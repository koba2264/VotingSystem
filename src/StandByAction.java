import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

/**
 * 待機状態へ移行するためのActionクラス
 * @author s_kobayashi
 *
 */
public class StandByAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "WEB-INF/StandBy.jsp";
	}

}
