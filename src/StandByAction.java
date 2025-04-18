import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CountDAO;
import tool.Action;
import tool.Answer;

/**
 * 待機状態へ移行するためのActionクラス
 * @author s_kobayashi
 *
 */
public class StandByAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ans = request.getParameter("");
		Answer answer = null;
		if (ans.equals("A")) {
			answer = Answer.A;
		} else if (ans.equals("B")) {
			answer = Answer.B;
		}

		CountDAO dao = new CountDAO();
		dao.vote(answer);

		return "WEB-INF/StandBy.jsp";
	}

}
