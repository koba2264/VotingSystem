import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Question;
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
		HttpSession session = request.getSession();
		String sessionId = session.getId();

		if (!Question.checkSessionList(sessionId)) {
			String ans = request.getParameter("choice");
			Answer answer = null;
			System.out.println(ans);
			if (ans.equals("A")) {
				answer = Answer.A;
			} else if (ans.equals("B")) {
				answer = Answer.B;
			}

			session.setAttribute("ans", ans);

			CountDAO dao = new CountDAO();
			dao.vote(answer);
			System.out.println("投票");
			Question.setSessionList(sessionId);
		}
		System.out.println(sessionId);

		return "WEB-INF/StandBy.jsp";
	}

}
