package clases;

import java.sql.Date;
import java.sql.*;

public class Factura {
	private int factura_id; 
	private String codigo_usuario;
	private Date creado;
	private Date modificado;
	private int material_id;
	private int cantidad;
	
	
	public Factura(int factura_id, String codigo_usuario, Date creado, Date modificado, int material_id, int cantidad) {
		super();
		this.factura_id = factura_id;
		this.codigo_usuario = codigo_usuario;
		this.creado = creado;
		this.modificado = modificado;
		this.material_id = material_id;
		this.cantidad = cantidad;
	}


	public int getFactura_id() {
		return factura_id;
	}


	public void setFactura_id(int factura_id) {
		this.factura_id = factura_id;
	}


	public String getCodigo_usuario() {
		return codigo_usuario;
	}


	public void setCodigo_usuario(String codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}


	public Date getCreado() {
		return creado;
	}


	public void setCreado(Date creado) {
		this.creado = creado;
	}


	public Date getModificado() {
		return modificado;
	}


	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}


	public int getMaterial_id() {
		return material_id;
	}


	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
