package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Question;

public class QestionDAO extends DAO {
	public Question question() throws Exception {
		/**
		 * beanのQestionクラスをインスタンス化。idを取得
		 */
		Question q = new Question();
		int id = Question.getId();
		/**
		 * データベースに接続
		 */
		Connection con = getConnection();

		/**
		 * SQL文を実行。whereにidを入れ対応する問題文、選択肢A、選択肢Bを取り出す
		 */
		PreparedStatement st = con.prepareStatement("select * from questions where id = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();

		/**
		 * 取り出した値をbeanに保存
		 */
		rs.next();
		q.setText(rs.getString("text"));
		q.setChoicesA(rs.getString("choices_a"));
		q.setChoicesB(rs.getString("choices_b"));

		st.close();
		con.close();
		return q;
	}
}