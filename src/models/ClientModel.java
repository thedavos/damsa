package models;

// Java packages
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import clases.Cliente;
import db.ConnectionDB;
import static db.Config.*;

public class ClientModel extends ConnectionDB {
	
	public void createClient(Cliente cliente) {
		String query = "";
		
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
					+ "contraseña, "
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
			preparedStmt.execute();
			
			preparedStmt.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				String password = result.getString("contraseña");
				
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
				String password = result.getString("contraseña");
				
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
			query = "UPDATE ? SET ?=?, ?=?, ?=?, ?=?, ?=?, ?=?, ?=?, ?=?, ?=?, ?=?, ?=? WHERE ?=?";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, ClientTableName);
			// Columna DNI
			preparedStmt.setString(2, ClientDNI);
			preparedStmt.setInt(3, cliente.getDni());
			// Columna Codigo
			preparedStmt.setString(4, CodigoUsuario);
			preparedStmt.setString(5, cliente.getCode());
			// Columna Nombre
			preparedStmt.setString(6, ClientName);
			preparedStmt.setString(7, cliente.getName());
			// Columna Apellido
			preparedStmt.setString(8, ClientLastname);
			preparedStmt.setString(9, cliente.getLastname());
			// Columna Edad
			preparedStmt.setString(10, ClientAge);
			preparedStmt.setInt(11, cliente.getAge());
			// Columna Genero
			preparedStmt.setString(12, ClientGender);
			preparedStmt.setString(13, String.valueOf(cliente.getGender()));
			// Columna Direccion
			preparedStmt.setString(14, ClientAddress);
			preparedStmt.setString(15, cliente.getAddress());
			// Columna Correo
			preparedStmt.setString(16, ClientEmail);
			preparedStmt.setString(17, cliente.getEmail());
			// Columna Telefono
			preparedStmt.setString(18, ClientPhone);
			preparedStmt.setInt(19, cliente.getPhone());
			// Columna Celular
			preparedStmt.setString(20, ClientCellPhone);
			preparedStmt.setInt(21, cliente.getCellphone());
			// Columna Imagen URL
			preparedStmt.setString(22, ClientURL);
			preparedStmt.setString(23, cliente.getProfileUrl());
			// Condicional
			preparedStmt.setString(24, ClientDNI);
			preparedStmt.setInt(25, dni);
			result = preparedStmt.executeUpdate();
			
			closeConnection(preparedStmt);
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}

