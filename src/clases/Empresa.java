package clases;

import clases.Usuario;

public class Empresa extends Usuario {
	
	private String code, ruc;
	
	public Empresa(String ruc, String name, String email, String address, int phone, int cellPhone) {
		super(name, email, address, phone, cellPhone);
		this.ruc = ruc;
		this.code = "e" + name.toLowerCase();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
}
