package fantasy;

import java.sql.Connection;
// Connection conn = ConnectionManager.getInstance();
//
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager connManager;
	private static Connection connection;
	
	private ConnectionManager() {
	}
	
	public static ConnectionManager getInstance() {
		if (connManager == null) {
			connManager = new ConnectionManager();
			try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "npallavi", "Pallavi26");
			}
			catch(Exception e){
		    	  System.out.println(e);
		    }
		}
		return connManager;
	}
	
	public static Connection getConnection() {
		return connection;
		
	}
	
	public static void closeConnection() {
		try {
	        if (connection != null) {
	            connection.close();
	        }
	      } catch (SQLException ex) {
	          System.out.println(ex.getMessage());
	      }
		
	}
}
