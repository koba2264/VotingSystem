import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Question;
import dao.QestionDAO;
import tool.Action;


public class VotingAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QestionDAO dao = new QestionDAO();
		Question q = dao.question();
		HttpSession session = request.getSession();
		session.setAttribute("q", q);

		return "WEB-INF/mon.jsp";
	}

}
