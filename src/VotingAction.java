import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Question;
import dao.QestionDAO;
import tool.Action;


public class VotingAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		/**
		 * セッション取得
		 */
		HttpSession session = request.getSession();

		/**
		 * daoから問題文、選択肢A、選択肢Bを取り出しQestion型のqに保存
		 */
		QestionDAO dao = new QestionDAO();
		Question q = dao.question();

		session.setAttribute("q", q);
		return "start.jsp";

	}

}
