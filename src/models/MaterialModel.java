package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.Material;
import db.ConnectionDB;
import static db.Config.*;

public class MaterialModel extends ConnectionDB {
	
	public int createMaterial(Material mat) {
		String query = "";
		int result=0;
		
		try {
			query = "insertar_materiales(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = this.connect().prepareStatement(query);
			preparedStmt.setString(1, mat.getCodUser());
			preparedStmt.setString(2, mat.getCodMat());
			preparedStmt.setString(3, mat.getNombre());
			preparedStmt.setString(4, mat.getDesc());
			preparedStmt.setDouble(5, mat.getPrecioVenta());
			preparedStmt.setInt(6, mat.getCantidad());
			preparedStmt.setString(7, mat.getTipo());
			preparedStmt.setString(8, mat.getEstado());
			preparedStmt.setString(9, mat.getMaterialUrl());
			
			result =preparedStmt.executeUpdate();
			
			preparedStmt.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public void buscamaterial(Material mat){
		String query="";
		try {
			query="visualizar_stock ("+"'"+ mat.getNombre()+"'"+")";
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
