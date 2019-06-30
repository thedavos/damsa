package clases;

import interfaces.IRepoManager;

public class Admin extends PersonaUsuario implements IRepoManager {
	
	public Admin() {
		setRole("Admin");
	}
	
	public Admin(int dni, String password, String name, String lastname, char gender, int age, String email, String address, int phone, int cellPhone, String profileUrl) {
		super(dni, password, name, lastname, gender, age, email, address, phone, cellPhone);
		String code = "a" + name.toLowerCase().charAt(0) + getFirstLastname();
		setCode(code);
		setProfileUrl(profileUrl);
		setRole("Admin");
	}
}
