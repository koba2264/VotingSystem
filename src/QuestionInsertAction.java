import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Question;
import dao.QestionDAO;
import tool.Action;

public class QuestionInsertAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QestionDAO dao = new QestionDAO();
		Question que = new Question();
		dao.delete();
		String[][] queList = {
				{"人生において大事だと思う方はどっち?","金","愛"},
				{"より長く一緒に過ごしたいのはどっち？","親","親友"},
				{"どっち派？","きのこの山","たけのこの里"},
				{"なれるならならどっち？","嫌われ者の<br>お金持ち","愛される<br>貧乏人"},
				{"一度だけ叶えられるならどっち？","過去に戻る","未来に行く"},
				{"無人島に1人連れていくならどっち?","猪口先生","山本先生"},
				{"理想の生活環境は?","田舎","都会"},
				{"選ぶとしたら？","確実に貰える<br>1000万円","2/1で貰える<br>1億円"},
				{"映画を見るならどっち?","映画館","家"},
				{"生まれ変わるならどっち?","男","女"},
				{"季節が1つになるならどっち？","夏","冬"},
				{"教科書はどっちがいい？","紙","電子書籍"},
				{"遊びに行くならどっち?","海","山"},
				{"ポテトどっち派？","揚げたて","冷め"},
		};
		for (String[] q : queList) {
			que.setText2(q[0]);
			que.setChoicesA2(q[1]);
			que.setChoicesB2(q[2]);
			dao.insert(que);
		}
		return "WEB-INF/Admin.jsp";
	}

}
