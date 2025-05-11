package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Question;

public class QestionDAO extends DAO {
	public void question() throws Exception {
		Question question = new Question();

		int id = question.getId();
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
		question.setText(rs.getString("text"));
		question.setChoicesA(rs.getString("choices_a"));
		question.setChoicesB(rs.getString("choices_b"));

		st.close();
		con.close();
	}

	/**
	 * 全問取得
	 * @return
	 * @throws Exception
	 */
	public List<Question> allQuestion() throws Exception {
		List<Question> qList = new ArrayList<>();
		Question q = null;
		/**
		 * データベースに接続
		 */
		Connection con = getConnection();

		/**
		 * 全件取得
		 */
		PreparedStatement st = con.prepareStatement("select * from questions");
		ResultSet rs = st.executeQuery();

		/**
		 * 取り出した値をbeanに保存
		 */
		while(rs.next()) {
			q = new Question();
			q.setQuestionId2(rs.getInt("id"));
			q.setText2(rs.getString("text"));
			q.setChoicesA2(rs.getString("choices_a"));
			q.setChoicesB2(rs.getString("choices_b"));
			qList.add(q);
		}

		st.close();
		con.close();
		return qList;
	}

	public int insert(Question que) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into questions(text,choices_a,choices_b) values (?,?,?);");
		st.setString(1, que.getText2());
		st.setString(2, que.getChoicesA2());
		st.setString(3, que.getChoicesB2());
		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

	public void delete() throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"delete from count;delete from questions;");
		st.close();
		con.close();
	}
}