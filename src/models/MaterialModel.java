package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.Material;
import db.ConnectionDB;
import static db.Config.*;

public class MaterialModel extends ConnectionDB {
	
	public void createMaterial(Material mat) {
		String query = "";
		
		try {
			query = "INSERT INTO " + MaterialTableName + " ("
					+ "codigo_usuario, "
					+ "codigo_material, "
					+ "nombre, "
					+ "descripcion, "
					+ "precio_venta, "
					+ "cantidad, "
					+ "tipo, "
					+ "estado, "
					+ "material_img)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, mat.getCodUser());
			preparedStmt.setString(2, mat.getCodMat());
//			preparedStmt.setInt(1, admin.getDni());
//			preparedStmt.setString(2, admin.getCode());
//			preparedStmt.setString(3, admin.getName());
//			preparedStmt.setString(4, admin.getLastname());
//			preparedStmt.setInt(5, admin.getAge());
//			preparedStmt.setString(6, String.valueOf(admin.getGender()));
//			preparedStmt.setString(7, admin.getAddress());
//			preparedStmt.setString(8, admin.getEmail());
//			preparedStmt.setInt(9, admin.getPhone());
//			preparedStmt.setInt(10, admin.getCellphone());
//			preparedStmt.setString(11, admin.getPassword());
//			preparedStmt.setString(12, admin.getProfileUrl());
			preparedStmt.execute();
			
			preparedStmt.close();
			this.conn.close();
			this.conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
