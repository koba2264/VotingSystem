package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Count;

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
	public Count serch(int id) throws Exception {
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

}
