package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import clases.Material;
import db.ConnectionDB;
import static db.Config.*;

public class MaterialModel extends ConnectionDB {
	
	public int createMaterial(Material mat) {
		String query = "";
		int result=0;
		
		try {
			query = "call insertar_materiales(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
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
	public ArrayList<Material> getMaterials(){
		ArrayList<Material> materials = new ArrayList<Material>();
		String query="";
		try {
			query="call vertodo";
			Material mate;
			
			Statement statement = connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			String nombre,descripcion,tipo,estado,img,codmate,codusu;
			double precio;
			int cant,matid;
			Date inicio;
			
			while(result.next()){
				matid = result.getInt(MaterialID);
				codusu = result.getString(CodigoUsuario);
				codmate = result.getString(MaterialCod);
				nombre = result.getString(MaterialName);
				descripcion = result.getString(MaterialDescription);
				precio = result.getDouble(MaterialPrice);
				cant = result.getInt(MaterialQuantity);
				tipo = result.getString(MaterialType);
				estado = result.getString(MaterialState);
				img = result.getString(MaterialURL);
				inicio =(Date)result.getDate(Created);
				
				mate = new Material(
						nombre,
						codusu,
						descripcion,
						cant,
						tipo,
						estado,
						img,
						precio
						);
				mate.setId(matid);
				mate.setCodMat(codmate);
				mate.setInicio(inicio);
				
				materials.add(mate);
			}
			statement.close();
			this.conn.close();
			this.conn = null;
			
			
			
			return materials;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
		return materials;
	}
}
