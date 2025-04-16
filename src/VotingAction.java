import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Question;
import dao.VotingDAO;
import tool.Action;


public class VotingAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int id = 1;

		VotingDAO vd = new VotingDAO();
		Question q = vd.question(id);

		session.setAttribute("q", q);
		return "start.jsp";
	}

}
