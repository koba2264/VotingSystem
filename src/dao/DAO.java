package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * @author s_kobayashi
 * データベース操作の継承元
 */

public class DAO {
	/** データベースの情報 */
	static DataSource ds;

	/**
	 * @return 設定したデータベースへの接続情報
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		if (ds == null) {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:/comp/env/jdbc/voting");
		}
		return ds.getConnection();
	}

}