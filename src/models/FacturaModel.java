package models;

import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import clases.Factura;
import db.ConnectionDB;
import static db.Config.*;
import clases.Cliente;

public class FacturaModel extends ConnectionDB {
	
	public void createFactura(Factura factura) {
		String query="";
		try {
			query ="INSERT INTO"+ FacturaTableName +" ("
					+"factura_id,"
					+"codigo_usuario,"
					+"creado,"
					+"modificado,"
					+"material_id,"
					+"cantidad,"
					+"values(?,?,?,?,?,?)";
			PreparedStatement preparedStmt= this.connect().prepareStatement(query);
			preparedStmt.setInt(1, factura.getFactura_id());
			preparedStmt.setString(2, factura.getCodigo_usuario());
			preparedStmt.setDate(3, factura.getCreado());
			preparedStmt.setDate(4, factura.getModificado());
			preparedStmt.setInt(5, factura.getMaterial_id());
			preparedStmt.setInt(6, factura.getCantidad());
			preparedStmt.execute();
			
			preparedStmt.close();
			this.conn.close();
			this.conn=null;
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Factura getFactura(int factura_id) {
		String query="";
		Factura factu=null;
		try {
			query="SELECT * FROM"+  FacturaTableName  + "WHERE"
					+"factura_id= '"+ factura_id +"' AND"
					+ "codigo_usuario= '"+ CodigoUsuario;
			Statement statement = this.connect().createStatement();
			ResultSet result = statement.executeQuery(query);
			 while(result.next()) {
				 int id =result.getInt("factura_id");
				 String codusu= result.getString("codigo_usuario");
				 Date cread= result.getDate("creado");
				 Date modif=result.getDate("modificado");
				 int idMate=result.getInt("material_id");
				 int cant=result.getInt("cantidad");
				 
				 factu= new Factura(
						 id,
						 codusu,
						 cread,
						 modif,
						 idMate,
						 cant
						 );
				 factu.setFactura_id(id);
				 factu.setCodigo_usuario(codusu);
				 factu.setCreado(cread);
				 factu.setModificado(modif);
				 factu.setMaterial_id(idMate);
				 factu.setCantidad(cant);
				 
				return factu;			 
			 }
			 statement.close();
			 this.conn.close();
			 this.conn=null;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return factu;
	}

}
