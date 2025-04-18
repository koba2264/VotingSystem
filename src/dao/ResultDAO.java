package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Question;

public class ResultDAO extends DAO {
	public Question search()
		throws Exception {
		Question q = new Question();
		int id = Question.getId();

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
			"SELECT QUESTIONS.TEXT,QUESTIONS.CHOICES_A,QUESTIONS.CHOICES_B COUNT.A COUNT.B FROM QUESTIONS JOIN COUNT ON QUESTIONS.ID = COUNT.ID WHERE QUESTIONS.ID = ?;");
		st.setInt(1,id);
		ResultSet rs = st.executeQuery();
		
		rs.next();
		q.setText(rs.getString("text"));
		q.setChoicesA(rs.getString("choices_a"));
		q.setChoicesB(rs.getString("choices_b"));
		
		st.close();
		con.close();
		return q;
	}
}