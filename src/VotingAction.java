import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Question;
import dao.VotingDAO;
import tool.Action;


public class VotingAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * セッション取得
		 */
		HttpSession session = request.getSession();
		//仮の数字
		int id = 1;
		

		/**
		 * daoから問題文、選択肢A、選択肢Bを取り出しQestion型のqに保存
		 */
		VotingDAO vd = new VotingDAO();
		Question q = vd.question(id);

		session.setAttribute("q", q);
		return "start.jsp";
	}

}
