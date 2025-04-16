package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Question;

public class VotingDAO extends DAO {
	public Question question(int id) throws Exception {
		/**
		 * beanのQestionクラスをインスタンス化。最初はnullを設定
		 */
		Question q = null;
		/**
		 * データベースに接続
		 */
		Connection con = getConnection();
		
		/**
		 * SQL文を実行。whereにidを入れ対応する問題文、選択肢A、選択肢Bを取り出す
		 */
		PreparedStatement st = con.prepareStatement("select * from questions where = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		
		/**
		 * 取り出した値をbeanに保存
		 */
		rs.next();
		q = new Question();
		q.setText(rs.getString("text"));
		q.setChoicesA(rs.getString("choices_a"));
		q.setChoicesB(rs.getString("choices_b"));

		st.close();
		con.close();
		return q;
	}
}