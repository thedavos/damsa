package src.models;

// Java packages
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import src.clases.Cliente;
import src.utils.ConnectionDB;

public class ClientModel {
	
	private Connection conn = null;
	
	private Connection connect() {
		ConnectionDB db = new ConnectionDB();
		this.conn = db.connectionMySQL();
		return this.conn;
	}
	
	public void createClient(Cliente cliente) {
		String query = "";
		
		try {
			query = "INSERT INTO Cliente("
					+ "dni, "
					+ "codigo, "
					+ "nombre, "
					+ "apellidos, "
					+ "edad, "
					+ "genero, "
					+ "direccion, "
					+ "correo, "
					+ "telefono, "

					+ "celular)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"

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
			query = "SELECT * FROM Cliente WHERE "
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
			query = "SELECT * FROM " + tableName + " WHERE "
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

			query = "SELECT * FROM Cliente WHERE "
					+ "is_admin = 0 AND ";

			query = "SELECT * FROM " + tableName + " WHERE "

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
	
	public void updateClientField(Cliente client, String field, Object value) {
		String query = "";
		
		try {

			query = "UPDATE Cliente SET ? = ? WHERE dni = ?";

			query = "UPDATE " + tableName + " SET "
					+ "dni = ?, "
					+ "nombre = ?, "
					+ "apellidos = ?, "
					+ "contraseña = ? "
					+ " = ? "
					+ "WHERE dni = ?";

			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, field);
			preparedStmt.setObject(2, value);
			preparedStmt.setInt(3, client.getDni());
			
			preparedStmt.executeUpdate();
			
			preparedStmt.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

