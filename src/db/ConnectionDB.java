package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static db.Config.*;

public class ConnectionDB {
	
	protected Connection conn = null;
	
	@SuppressWarnings("finally")
	protected Connection connectionMySQL() {
	    Connection conn = null;

	    try {
	      Class.forName(Driver);
	      conn = DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException | SQLException e) {
	      e.printStackTrace();
	    } finally {
	    	return conn;
	    }
    }
	
	protected Connection connect() {
		this.conn = connectionMySQL();
		return this.conn;
	}
	
	protected void closeConnection(PreparedStatement pst) {
		try {
			pst.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
