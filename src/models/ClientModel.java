package models;

// Java packages
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import clases.Cliente;
import db.ConnectionDB;
import utils.Encryption;

import static db.Config.*;

public class ClientModel extends ConnectionDB {
	
	public int createClient(Cliente cliente) {
		String query = "";
		int isCreated = 0;
		
		try {
			query = "INSERT INTO " + ClientTableName + " ("
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
					+ "contraseņa, "
					+ "profile_url)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setInt(1, cliente.getDni());
			preparedStmt.setString(2, cliente.getCode());
			preparedStmt.setString(3, cliente.getName());
			preparedStmt.setString(4, cliente.getLastname());
			preparedStmt.setInt(5, cliente.getAge());
			preparedStmt.setString(6, String.valueOf(cliente.getGender()));
			preparedStmt.setString(7, cliente.getAddress());
			preparedStmt.setString(8, cliente.getEmail());
			preparedStmt.setInt(9, cliente.getPhone());
			preparedStmt.setInt(10, cliente.getCellphone());
			preparedStmt.setString(11, cliente.getPassword());
			preparedStmt.setString(12, cliente.getProfileUrl());
			
			isCreated = preparedStmt.executeUpdate();
			closeConnection(preparedStmt);
			
			return isCreated;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isCreated;
	}
	
	public Cliente getClient(int dni) {
		String query = "";
		Cliente client = null;
		
		try {
			query = "SELECT * FROM " + ClientTableName + " WHERE "
					+ "dni = '" + dni + "' AND "
					+ "estado = 1";
			
			Statement statement = this.connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				
				int id = result.getInt("cliente_id");
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
				String profileUrl = result.getString("profile_url");
				String password = result.getString("contraseņa");
				
				client = new Cliente(
						dnii, 
						name,
						lastname,
						gender,
						age,
						email,
						address,
						phone,
						cellPhone
				);
				
				client.setId(id);
				client.setCode(code);
				client.setProfileUrl(profileUrl);
				client.setPassword(password);
				
				return client;
			}
			
			statement.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return client;
	}
	
	public Cliente getClient(String cod) {
		String query = "";
		Cliente client = null;
		
		try {
			query = "SELECT * FROM " + ClientTableName + " WHERE "
					+ "codigo = '" + cod + "' AND "
					+ "estado = 1";
			
			Statement statement = this.connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				
				int id = result.getInt("cliente_id");
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
				String profileUrl = result.getString("profile_url");
				String password = result.getString("contraseņa");
				
				client = new Cliente(
						dnii, 
						name,
						lastname,
						gender,
						age,
						email,
						address,
						phone,
						cellPhone
				);
				
				client.setId(id);
				client.setCode(code);
				client.setProfileUrl(profileUrl);
				client.setPassword(password);
				
				return client;
			}
			
			statement.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return client;
	}
	
	public ArrayList<Cliente> getClients() {
		ArrayList<Cliente> clients = new ArrayList<Cliente>();
		String query = "";
		
		try {
			query = "SELECT * FROM " + ClientTableName + " WHERE "
					+ "estado = 1";
			
			Statement statement = this.connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
				int id = result.getInt("id");
				String code = result.getString("codigo");
				int dni = result.getInt("dni");
				String name = result.getString("nombre");
				String lastname = result.getString("apellidos");
				int age = result.getInt("edad");
				char gender = result.getString("genero").charAt(0);
				String address = result.getString("direccion");
				String email = result.getString("correo");
				int phone = result.getInt("telefono");
				int cellPhone = result.getInt("celular");
				String profileUrl = result.getString("profile_url");
				
				Cliente client = new Cliente(
						dni, 
						name,
						lastname,
						gender,
						age,
						email,
						address,
						phone,
						cellPhone
				);
				
				
				client.setId(id);
				client.setCode(code);
				client.setProfileUrl(profileUrl);
				
				clients.add(client);
			}
			
			statement.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clients;	
	}
	
	public int updateClient(Cliente cliente, int dni) {
		String query = "";
		int result = 0;
		
		try {
			query = "UPDATE " + ClientTableName + " SET " + 
					ClientDNI + "=?, " + 
					ClientCod + "=?, " +
					ClientName + "=?, " +
					ClientLastname + "=?, " +
					ClientAge + "=?, " +
					ClientGender + "=?, " +
					ClientAddress + "=?, " +
					ClientEmail + "=?, " +
					ClientPhone + "=?, " +
					ClientCellPhone + "=?, " +
					ClientURL + "=? " +
					"WHERE " + ClientDNI + "=?";
			
			System.out.println(query);
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			// Columna DNI
			preparedStmt.setInt(1, cliente.getDni());
			// Columna Codigo
			preparedStmt.setString(2, cliente.getCode());
			// Columna Nombre
			preparedStmt.setString(3, cliente.getName());
			// Columna Apellido
			preparedStmt.setString(4, cliente.getLastname());
			// Columna Edad
			preparedStmt.setInt(5, cliente.getAge());
			// Columna Genero
			preparedStmt.setString(6, String.valueOf(cliente.getGender()));
			// Columna Direccion
			preparedStmt.setString(7, cliente.getAddress());
			// Columna Correo
			preparedStmt.setString(8, cliente.getEmail());
			// Columna Telefono
			preparedStmt.setInt(9, cliente.getPhone());
			// Columna Celular
			preparedStmt.setInt(10, cliente.getCellphone());
			// Columna Imagen URL
			preparedStmt.setString(11, cliente.getProfileUrl());
			// Condicional
			preparedStmt.setInt(12, dni);
			result = preparedStmt.executeUpdate();
			
			closeConnection(preparedStmt);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updatePassword(Cliente cliente, int dni) {
		String query = "";
		int result = 0;
		
		try {
			query = "UPDATE " + ClientTableName + " SET " + 
					ClientPassword + "=? " +
					"WHERE " + ClientDNI + "=?";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, Encryption.SHA1(cliente.getPassword()));
			preparedStmt.setInt(2, cliente.getDni());
			
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
	
	public int deleteClient(Cliente cliente, int dni) {
		String query = "";
		int result = 0;
		
		try {
			query = "UPDATE " + ClientTableName + " SET " + 
					ClientState + "=? " +
					"WHERE " + ClientDNI + "=?";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setInt(1, 0);
			preparedStmt.setInt(2, cliente.getDni());
			
			result = preparedStmt.executeUpdate();
			
			closeConnection(preparedStmt);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

