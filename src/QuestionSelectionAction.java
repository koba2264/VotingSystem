import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Question;
import dao.QestionDAO;
import tool.Action;

public class QuestionSelectionAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Question question = new Question();
		question.setId(id);
		QestionDAO dao = new QestionDAO();
		dao.question();

		return "Admin.action";
	}

}
