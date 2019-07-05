package models;

//Java packages
import java.sql.SQLException;
import java.sql.Statement;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import clases.Admin;
import clases.Cliente;
import clases.Empresa;
import db.ConnectionDB;
import utils.Encryption;

import static db.Config.*;

public class AdminModel extends ConnectionDB {
	
	public void createAdmin(Admin admin) {
		String query = "";
		
		try {
			query = "INSERT INTO " + AdminTableName + " ("
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
	
	public Admin getAdmin(int dni) {
		String query = "";
		Admin admin = null;
		
		try {
			query = "SELECT * FROM " + AdminTableName + " WHERE "
					+ "dni = '" + dni + "' AND "
					+ "estado = 1";
			
			Statement statement = this.connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				
				int id = result.getInt("admin_id");
				String code = result.getString("codigo");
				int dnii = result.getInt("dni");
				String name = result.getString("nombre");
				String lastname = result.getString("apellidos");
				int age = result.getInt("edad");
				char gender = result.getString("genero").charAt(0);
				String address = result.getString("direccion");
				String email = result.getString("correo");
				int phone = result.getInt("telefono");
				int cellPhone = result.getInt("celular");
				String password = result.getString("contraseña");
				String profileUrl = result.getString("profile_url");
				
				admin = new Admin(
						dnii, 
						password,
						name,
						lastname,
						gender,
						age,
						email,
						address,
						phone,
						cellPhone, 
						profileUrl
				);
				
				admin.setId(id);
				admin.setCode(code);
				admin.setProfileUrl(profileUrl);
				
				return admin;
			}
			
			statement.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return admin;
	}
	
	public Admin getAdmin(String cod) {
		String query = "";
		Admin admin = null;
		
		try {
			query = "SELECT * FROM " + AdminTableName + " WHERE "
					+ "codigo = '" + cod + "' AND "
					+ "estado = 1";
			
			Statement statement = this.connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				
				int id = result.getInt("admin_id");
				String code = result.getString("codigo");
				int dnii = result.getInt("dni");
				String name = result.getString("nombre");
				String lastname = result.getString("apellidos");
				int age = result.getInt("edad");
				char gender = result.getString("genero").charAt(0);
				String address = result.getString("direccion");
				String email = result.getString("correo");
				int phone = result.getInt("telefono");
				int cellPhone = result.getInt("celular");
				String password = result.getString("contraseña");
				String profileUrl = result.getString("profile_url");
				
				admin = new Admin(
						dnii, 
						password,
						name,
						lastname,
						gender,
						age,
						email,
						address,
						phone,
						cellPhone, 
						profileUrl
				);
				
				admin.setId(id);
				admin.setCode(code);
				admin.setProfileUrl(profileUrl);
				
				return admin;
			}
			
			statement.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	public int updateAdmin(Admin admin, int dni) {
		String query = "";
		int result = 0;
		
		try {
			query = "UPDATE " + AdminTableName + " SET " + 
					AdminDNI + "=?, " + 
					AdminCod + "=?, " +
					AdminName + "=?, " +
					AdminLastname + "=?, " +
					AdminAge + "=?, " +
					AdminGender + "=?, " +
					AdminAddress + "=?, " +
					AdminEmail + "=?, " +
					AdminPhone + "=?, " +
					AdminCellPhone + "=?, " +
					AdminURL + "=? " +
					"WHERE " + AdminDNI + "=?";
			
			System.out.println(query);
			
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
			preparedStmt.setString(11, admin.getProfileUrl());
			preparedStmt.setInt(12, dni);
			result = preparedStmt.executeUpdate();
			
			closeConnection(preparedStmt);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updatePassword(Admin admin, int dni) {
		String query = "";
		int result = 0;
		
		try {
			query = "UPDATE " + AdminTableName + " SET " + 
					AdminPassword + "=? " +
					"WHERE " + AdminDNI + "=?";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, Encryption.SHA1(admin.getPassword()));
			preparedStmt.setInt(2, admin.getDni());
			
			result = preparedStmt.executeUpdate();
			
			closeConnection(preparedStmt);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteAdmin(Admin admin, int dni) {
		String query = "";
		int result = 0;
		
		try {
			query = "UPDATE " + AdminTableName + " SET " + 
					AdminState + "=? " +
					"WHERE " + AdminDNI + "=?";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setInt(1, 0);
			preparedStmt.setInt(2, admin.getDni());
			
			result = preparedStmt.executeUpdate();
			
			closeConnection(preparedStmt);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
