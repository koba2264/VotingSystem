import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Count;
import bean.Question;
import tool.Action;

public class ResultAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		Count count = new Count();
		double A = (double)count.getA();
		double B = (double)count.getB();
		double total = A + B;
		double avgA = (A / total) * 100;
		double avgB = (B / total) * 100;

		session.setAttribute("question", new Question());
		session.setAttribute("A",A);
		session.setAttribute("B",B);
		session.setAttribute("avgA",avgA);
		session.setAttribute("avgB",avgB);

		return "WEB-INF/Result.jsp";
	}

}
