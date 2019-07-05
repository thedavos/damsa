package models;

import static db.Config.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Admin;
import clases.Cliente;
import clases.Empresa;
import db.ConnectionDB;
import utils.Encryption;

public class EnterpriseModel extends ConnectionDB {
	
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
	
	public int updateEnterprise(Empresa enterprise, String ruc) {
		String query = "";
		int result = 0;
		
		try {
			query = "UPDATE " + EnterpriseTableName + " SET " + 
					EnterpriseRUC + "=?, " +
					EnterpriseCod + "=?, " +
					EnterpriseName + "=?, " +
					EnterpriseAddress + "=?, " +
					EnterpriseEmail + "=?, " +
					EnterprisePhone + "=?, " +
					EnterpriseCellPhone + "=?, " +
					EnterpriseURL + "=? " +
					"WHERE " + EnterpriseRUC + "=?";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, enterprise.getRuc());
			preparedStmt.setString(2, enterprise.getCode());
			preparedStmt.setString(3, enterprise.getName());
			preparedStmt.setString(4, enterprise.getAddress());
			preparedStmt.setString(5, enterprise.getEmail());
			preparedStmt.setInt(6, enterprise.getPhone());
			preparedStmt.setInt(7, enterprise.getCellphone());
			preparedStmt.setString(8, enterprise.getProfileUrl());
			preparedStmt.setString(9, ruc);
			
			result = preparedStmt.executeUpdate();
			
			closeConnection(preparedStmt);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updatePassword(Empresa empresa, String ruc) {
		String query = "";
		int result = 0;
		
		try {
			query = "UPDATE " + EnterpriseTableName + " SET " + 
					EnterprisePassword + "=? " +
					"WHERE " + EnterpriseRUC + "=?";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, Encryption.SHA1(empresa.getPassword()));
			preparedStmt.setString(2, ruc);
			
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
	
	public int deleteEnterprise(Empresa empresa, String ruc) {
		String query = "";
		int result = 0;
		
		try {
			query = "UPDATE " + EnterpriseTableName + " SET " + 
					EnterpriseState + "=? " +
					"WHERE " + EnterpriseRUC + "=?";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, empresa.getRuc());
			
			result = preparedStmt.executeUpdate();
			
			closeConnection(preparedStmt);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
