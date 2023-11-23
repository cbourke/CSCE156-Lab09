package unl.soc.database;

public class DatabaseInfo {

	/**
	 * Connection parameters that are necessary for server configuration
	 */
	public static final String PARAMETERS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static final String USERNAME = "login";
	public static final String PASSWORD = "password";
	public static final String URL = "jdbc:mysql://cse.unl.edu/" + USERNAME + PARAMETERS;

}
