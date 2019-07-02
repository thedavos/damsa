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
	
	public Sesion createSesion(Sesion sesion) {
		String query = "";
		Sesion ssn = null;
		
		try {
			query = "INSERT INTO ? (?) VALUES (?)";
					
			PreparedStatement pst = this.connect().prepareStatement(query);
			pst.setString(1, SesionTableName);
			pst.setString(2, CodigoUsuario);
			pst.setString(3, sesion.getCod_user());
			
			ResultSet rs = pst.executeQuery();
			
			int id = rs.getInt(SesionID);
			String code = rs.getString(CodigoUsuario);
			Date date = (Date) rs.getDate(Created);
			
			ssn = new Sesion(id, code, date);
			
			closeConnection(pst);
			
			return ssn; 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return ssn;
	}
	
	public Sesion getSesion(int SesionId) {
		Sesion sesion = null;
		String query = "";
		
		try {
			
			query = "SELECT ?, ?, ? FROM ? WHERE ?=?";
			
			PreparedStatement pst = this.connect().prepareStatement(query);
			pst.setString(1, SesionID);
			pst.setString(2, CodigoUsuario);
			pst.setString(3, Created);
			pst.setString(4, SesionTableName);
			pst.setInt(5, SesionId);
			
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
			query = "SELECT ?, ?, ? FROM ?";
			
			PreparedStatement pst = this.connect().prepareStatement(query);
			pst.setString(1, SesionID);
			pst.setString(2, CodigoUsuario);
			pst.setString(3, Created);
			
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
