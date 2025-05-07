import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Question;
import tool.Action;


public class VotingAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String sessionId = session.getId();

		if (Question.checkSessionList(sessionId)) {
			return "WEB-INF/StandBy.jsp";
		} else {
			session.setAttribute("question", new Question());

			return "WEB-INF/Question.jsp";
		}

	}

}
