package models;

import clases.Sesion;

import db.ConnectionDB;
import static db.Config.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class SesionModel extends ConnectionDB {
	
	public int createSesion(Sesion sesion) {
		String query = "";
		int result = 0;
		
		try {
			query = "INSERT INTO " + SesionTableName +
					" (" + CodigoUsuario +
					") VALUES (?)";
					
			PreparedStatement pst = this.connect().prepareStatement(query);
			pst.setString(1, sesion.getCod_user());
			
			result = pst.executeUpdate();
			
			closeConnection(pst);
			
			return result; 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	public Sesion getSesion(int SesionId) {
		Sesion sesion = null;
		String query = "";
		
		try {
			
			query = "SELECT " + 
					SesionID + ", " +
					CodigoUsuario + ", " +
					Created + ", " +
					"FROM " + SesionTableName +
					" WHERE " + SesionID + "=?";
			
			PreparedStatement pst = this.connect().prepareStatement(query);
			pst.setInt(1, SesionId);
			
			ResultSet rs = pst.executeQuery();
			
			int id = rs.getInt(SesionID);
			String code = rs.getString(CodigoUsuario);
			Date date = (Date) rs.getDate(Created);
			
			sesion = new Sesion(id, code, date);
			
			closeConnection(pst);
			
			return sesion;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return sesion;
	}
	
	public ArrayList<Sesion> getSesions() {
		ArrayList<Sesion> sesions = new ArrayList<Sesion>();
		String query = null;
		
		try {
			query = "SELECT " + 
					SesionID + ", " +
					CodigoUsuario + ", " +
					Created + ", " +
					"FROM " + SesionTableName;
			
			
			PreparedStatement pst = this.connect().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			do {
				int id = rs.getInt(SesionID);
				String code = rs.getString(CodigoUsuario);
				Date date = (Date) rs.getDate(Created);
				
				Sesion sesion = new Sesion(id, code, date);
				
				sesions.add(sesion);
			} while(rs.next());
			
			closeConnection(pst);
			
			return sesions;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return sesions;
	}
	
}
