package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Count;
import bean.Question;
import tool.Answer;

/**
 * COUNTテーブルへのDB操作をするクラス
 * @author s_kobayashi
 *
 */
public class CountDAO extends DAO {

	/**
	 * 問題IDから投票数を取得するメソッド
	 * @param id 問題ID
	 * @return 投票数を格納したCountクラス
	 * @throws Exception
	 */
	public Count serch() throws Exception {
		int id = Question.getId();
		Count count = null;
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"SELECT A,B FROM COUNT WHERE ID = ?;");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();


		if(rs.next()) {
			count = new Count();
			count.setA(rs.getInt("A"));
			count.setB(rs.getInt("B"));
		}

		return count;
	}

	/**
	 * 投票をするメソッド
	 * @param answer 投票の選択肢
	 * @return 成功したら1
	 * @throws Exception
	 */
	public int vote(Answer answer) throws Exception {
		int id = Question.getId();
		Connection con = getConnection();
		PreparedStatement st = null;
//		選択肢によって回数を増やす方を変更
		if (answer == Answer.A) {
			st = con.prepareStatement(
					"UPDATE COUNT SET A = A + 1 WHERE ID = ?;");
		} else if (answer == Answer.B) {
			st = con.prepareStatement(
					"UPDATE COUNT SET B = B + 1 WHERE ID = ?;");
		}
		st.setInt(1, id);

		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;
	}

}
