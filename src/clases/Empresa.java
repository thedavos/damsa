package clases;

import interfaces.IRepoManager;

public class Empresa extends Usuario implements IRepoManager  {
	
	private String ruc;
	private static int counter;
	
	public Empresa() {
		setRole("Empresa");
	}
	
	public Empresa(String ruc, String name, String email, String address, int phone, int cellPhone) {
		super(name, email, address, phone, cellPhone);
		this.ruc = ruc;
		counter += 1;
		String code = "e" + name.toLowerCase() + "000" + counter;
		setCode(code);
		setRole("Empresa");
	}
	
	public Empresa(String ruc, String name) {
		this.ruc = ruc;
		counter += 1;
		String code = "e" + name.toLowerCase() + "000" + counter;
		setCode(code);
		setName(name);
		setRole("Empresa");
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
}
