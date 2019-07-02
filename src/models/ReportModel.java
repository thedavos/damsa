package models;

import clases.Reporte;
import db.ConnectionDB;
import static db.Config.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportModel extends ConnectionDB {
	
	public Boolean CreateReport(Reporte report) {
		String query = "";
		Boolean resp = null;
		
		try {
			
			query = "INSERT INTO ? (?, ?, ?, ?) VALUES(?, ?, ?, ?)";
			PreparedStatement pst = this.connect().prepareStatement(query);
			// campos de la tabla
			pst.setString(1, ReporteTableName);
			pst.setString(2, CodigoUsuario);
			pst.setString(3, ReporteURL);
			pst.setString(4, ReporteName);
			pst.setString(5, ReporteEXT);
			// Datos
			pst.setString(7, report.getCodUser());
			pst.setString(8, report.getDownload(report.getFolder(), report.getNameFile()));
			pst.setString(9, report.getNameFile());
			pst.setString(10, report.getExtension());
			
			resp = pst.execute();
			closeConnection(pst);
			
			return resp;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return resp;
		} 
	}
	
	public Reporte getReport(int ReportID) {
		Reporte report = null;
		String query = "";
		
		try {
			query = "SELECT * FROM ? WHERE ?=?";
			
			PreparedStatement pst = this.connect().prepareStatement(query);
			// Campos
			pst.setString(1, ReporteTableName);
			pst.setString(2, ReporteID);
			// Datos
			pst.setInt(3, ReportID);
			
			ResultSet rs = pst.executeQuery();
			report = new Reporte(rs);
			
			closeConnection(pst);
			
			return report;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
		return report;
	}
	
	public ArrayList<Reporte> getReports() {
		ArrayList<Reporte> reports = new ArrayList<Reporte>();
		String query = "";
		
		try {
			query = "SELECT * FROM ?";
			
			PreparedStatement pst = this.connect().prepareStatement(query);
			pst.setString(1, ReporteTableName);
			
			ResultSet rs = pst.executeQuery();
			
			do {
				Reporte report = new Reporte(rs);
				
				reports.add(report);
				
			} while(rs.next());
			
			closeConnection(pst);
			
			return reports;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
		return reports;
	}
}
