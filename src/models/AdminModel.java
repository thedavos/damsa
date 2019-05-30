package models;

//Java packages
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import clases.Admin;
import utils.ConnectionDB;

public class AdminModel {
	
	final private String tableName = "admin";
	private Connection conn = null;
	
	private Connection connect() {
		ConnectionDB db = new ConnectionDB();
		this.conn = db.connectionMySQL();
		return this.conn;
	}
	
	public void createAdmin(Admin admin) {
		String query = "";
		
		try {
			query = "INSERT INTO " + tableName + " ("
					+ "dni, "
					+ "codigo, "
					+ "nombre, "
					+ "apellidos, "
					+ "edad, "
					+ "genero, "
					+ "direccion, "
					+ "correo, "
					+ "telefono, "
					+ "celular, "
					+ "contraseña, "
					+ "profile_url)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setInt(1, admin.getDni());
			preparedStmt.setString(2, admin.getCode());
			preparedStmt.setString(3, admin.getName());
			preparedStmt.setString(4, admin.getLastname());
			preparedStmt.setInt(5, admin.getAge());
			preparedStmt.setString(6, String.valueOf(admin.getGender()));
			preparedStmt.setString(7, admin.getAddress());
			preparedStmt.setString(8, admin.getEmail());
			preparedStmt.setInt(9, admin.getPhone());
			preparedStmt.setInt(10, admin.getCellphone());
			preparedStmt.setString(11, admin.getPassword());
			preparedStmt.setString(12, admin.getProfileUrl());
			preparedStmt.execute();
			
			preparedStmt.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
