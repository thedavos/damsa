package utils;

// Mysql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

  final private String driver = "com.mysql.jdbc.Driver";
  final private String databaseName = "b10rpladoweqjjgn97ba";
  final private String hostname = "b10rpladoweqjjgn97ba-mysql.services.clever-cloud.com";
  final private String port = "3306";
  final private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + databaseName + "?useSSL=false";
  final private String username = "u5mihwrfaijyeblj";
  final private String password = "7AM1Z9XXlnXdEeHOF0HP";

@SuppressWarnings("finally")
public Connection connectionMySQL() {
    Connection conn = null;

    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, username, password);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    } finally {
    	return conn;
	}
  }
}