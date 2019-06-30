package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Empresa;
import utils.ConnectionDB;

public class EnterpriseModel {
	
	private Connection conn = null;
	
	private Connection connect() {
		ConnectionDB db = new ConnectionDB();
		this.conn = db.connectionMySQL();
		return this.conn;
	}
	
	public void createEnterprise(Empresa empresa) {
		String query = "";
		
		try {
			query = "INSERT INTO empresa("
					+ "ruc, "
					+ "codigo, "
					+ "nombre, "
					+ "direccion, "
					+ "correo, "
					+ "telefono, "
					+ "celular, "
					+ "contraseña)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, empresa.getRuc());
			preparedStmt.setString(2, empresa.getCode());
			preparedStmt.setString(3, empresa.getName());
			preparedStmt.setString(4, empresa.getAddress());
			preparedStmt.setString(5, empresa.getEmail());
			preparedStmt.setInt(6, empresa.getPhone());
			preparedStmt.setInt(7, empresa.getCellphone());
			preparedStmt.setString(8, empresa.getPassword());
			
			preparedStmt.execute();
			
			preparedStmt.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Empresa getEnterprise(String ruc) {
		String query = "";
		Empresa empresa = null;
		
		try {
			query = "SELECT * FROM empresa WHERE "
					+ "ruc = '" + ruc + "' AND "
					+ "estado = 1";
			
			Statement statement = this.connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				
				int id = result.getInt("empresa_id");
				String code = result.getString("codigo");
				String rucc = result.getString("ruc");
				String name = result.getString("nombre");
				String address = result.getString("direccion");
				String email = result.getString("correo");
				String password = result.getString("contraseña");
				int phone = result.getInt("telefono");
				int cellPhone = result.getInt("celular");
				
				empresa = new Empresa(
						rucc, 
						name,
						email,
						address,
						phone,
						cellPhone
				);
				
				empresa.setId(id);
				empresa.setCode(code);
				empresa.setPassword(password);
				
				return empresa;
			}
			
			statement.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return empresa;
	}
	
	public Empresa getEnterprise(Object cod) {
		String query = "";
		Empresa empresa = null;
		
		try {
			query = "SELECT * FROM empresa WHERE "
					+ "codigo = '" + cod + "' AND "
					+ "estado = 1";
			
			Statement statement = this.connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				
				int id = result.getInt("empresa_id");
				String code = result.getString("codigo");
				String rucc = result.getString("ruc");
				String name = result.getString("nombre");
				String address = result.getString("direccion");
				String email = result.getString("correo");
				String password = result.getString("contraseña");
				int phone = result.getInt("telefono");
				int cellPhone = result.getInt("celular");
				
				empresa = new Empresa(
						rucc, 
						name,
						email,
						address,
						phone,
						cellPhone
				);
				
				empresa.setId(id);
				empresa.setCode(code);
				empresa.setPassword(password);
				
				return empresa;
			}
			
			statement.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return empresa;
	}
	
	public ArrayList<Empresa> getEnterprises() {
		ArrayList<Empresa> enterprises = new ArrayList<Empresa>();
		String query = "";
		
		try {
			query = "SELECT * FROM empresa WHERE estado = 1";
			
			Statement statement = this.connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
				int id = result.getInt("empresa_id");
				String code = result.getString("codigo");
				String ruc = result.getString("ruc");
				String name = result.getString("nombre");
				String address = result.getString("direccion");
				String email = result.getString("correo");
				int phone = result.getInt("telefono");
				int cellPhone = result.getInt("celular");
				
				Empresa enterprise = new Empresa(
						ruc, 
						name,
						email,
						address,
						phone,
						cellPhone
				);
				
				enterprise.setId(id);
				enterprise.setCode(code);
				
				enterprises.add(enterprise);
			}
			
			statement.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return enterprises;	
	}
	
	public void updateEnterpriseField(Empresa enterprise, String field, Object value) {
		String query = "";
		
		try {
			query = "UPDATE empresa SET ? = ? WHERE ruc = ?";
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, field);
			preparedStmt.setObject(2, value);
			preparedStmt.setString(3, enterprise.getRuc());
			
			preparedStmt.executeUpdate();
			
			preparedStmt.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
