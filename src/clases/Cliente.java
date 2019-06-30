package clases;

import interfaces.IRepoManager;

public class Cliente extends PersonaUsuario implements IRepoManager {
	private static int counter;
	
	public Cliente() {
		setRole("Cliente");
	}
	
	/**
	 * Creacion del objeto Cliente sin el campo contraseña
	 */
	public Cliente(int dni, String name, String lastname, char gender, int age, String email, String address, int phone, int cellPhone) {
		super(dni, name, lastname, gender, age, email, address, phone, cellPhone);
		counter += 1;
		String code = "c" + name.toLowerCase().charAt(0) + getFirstLastname() + "000" + counter;
		setCode(code);
		setRole("Cliente");
	}
	
	/**
	 * Para registar al cliente con el campo contraseña
	 */
	public Cliente(int dni, String password, String name, String lastname, char gender, int age, String email, String address, int phone, int cellPhone) {
		super(dni, password, name, lastname, gender, age, email, address, phone, cellPhone);
		counter += 1;
		String code = "c" + name.toLowerCase().charAt(0) + getFirstLastname() + "000" + counter;
		setCode(code);
		setRole("Cliente");
	}
	
	/**
	 * Creación de una instancia Cliente sin password, ni datos no obligatorios
	 */
	public Cliente(int dni, String password, String name, String lastname, char gender, int age) {
		super(dni, password, name, lastname, gender, age);
		String code = "c" + name.toLowerCase().charAt(0) + getFirstLastname() + "000" + counter;
		setCode(code);
		setRole("Cliente");
	}
}
