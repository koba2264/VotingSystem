import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Count;
import bean.Question;
import dao.CountDAO;
import dao.QestionDAO;
import tool.Action;

public class ResultAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		CountDAO cDao = new CountDAO();
		Count count = cDao.serch();
		QestionDAO qDao = new QestionDAO();
		Question question = qDao.question();

		double A = (double)count.getA();
		double B = (double)count.getB();
		double total = A + B;
		double avgA = (A / total) * 100;
		double avgB = (B / total) * 100;

		session.setAttribute("q",question);
		session.setAttribute("A",A);
		session.setAttribute("B",B);
		session.setAttribute("avgA",avgA);
		session.setAttribute("avgB",avgB);

		return "WEB-INF/Result.jsp";
	}

}
