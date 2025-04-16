package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Question;

public class VotingDAO extends DAO {
	public Question question(int id) throws Exception {
		Question q = null;
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("select * from questions where = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();

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