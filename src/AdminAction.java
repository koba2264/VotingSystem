import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Question;
import dao.QestionDAO;
import tool.Action;

/**
 * 主催者画面への遷移
 * @author s_kobayashi
 *
 */
public class AdminAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QestionDAO dao = new QestionDAO();
		List<Question> qList = dao.allQuestion();
		HttpSession session = request.getSession();
		session.setAttribute("question", new Question());
		session.setAttribute("qList", qList);

		return "WEB-INF/Admin.jsp";
	}

}
