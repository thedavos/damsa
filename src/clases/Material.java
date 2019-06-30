package clases;

import interfaces.IRepoManager;

public class Material implements IRepoManager {
	private int id, cantidad;
	private String codUser, codMat, nombre, desc, tipo, estado, materialUrl;
	private double precioVenta;
	
	public Material() {}

	/**
	 * Constructor para ser usado en el model, en el método get
	 * */
	public Material(int id, String codMat, String codUser, String nombre, String desc, int cantidad, String tipo, String estado, String materialUrl,
			double precioVenta) {
		this.id = id;
		this.codUser = codUser;
		this.codMat = codMat;
		this.nombre = nombre;
		this.desc = desc;
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.estado = estado;
		this.materialUrl = materialUrl;
		this.precioVenta = precioVenta;
	}
	
	/**
	 * Constructor para el registro de cada material
	 * */
	public Material(String nombre, String codUser, String desc, int cantidad, String tipo, String estado, String materialUrl,
			double precioVenta) {
		this.nombre = nombre;
		this.codUser = codUser;
		this.desc = desc;
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.estado = estado;
		this.materialUrl = materialUrl;
		this.precioVenta = precioVenta;
		
		String codMat = nombre;
		setCodUser(codUser);
		setCodMat(codMat);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMaterialUrl() {
		return materialUrl;
	}

	public void setMaterialUrl(String materialUrl) {
		this.materialUrl = materialUrl;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getCodUser() {
		return codUser;
	}

	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}

	public String getCodMat() {
		return codMat;
	}

	public void setCodMat(String codMat) {
		this.codMat = codMat;
	};
	
}
