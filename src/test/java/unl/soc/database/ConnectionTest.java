package unl.soc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.Test.None;

import unl.soc.database.DatabaseInfo;

public class ConnectionTest {

	@Test(expected = None.class)
	public void databaseConnectionTest() {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.USERNAME, DatabaseInfo.PASSWORD);
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
