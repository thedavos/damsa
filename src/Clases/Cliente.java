package Clases;

import Clases.Usuario;

public class Cliente extends Usuario {
	private int age, dni;
	private String code, lastname;
	private char gender;
	
	public Cliente(int dni, String name, String lastname, char gender, int age, String email, String address, int phone, int cellPhone) {
		super(name, email, address, phone, cellPhone);
		this.dni = dni;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.code = "u" + name.toLowerCase().charAt(0) + getFirstLastname();
	}
	
	private String getFirstLastname() {
		if (this.lastname.contains(" ")) {
			String[] lastnames = this.lastname.split("\\s");
			String firstLastname = lastnames[0];
			
			return firstLastname.toLowerCase();
		}
		
		return this.lastname.toLowerCase();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
}
