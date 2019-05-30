package clases;

public class PersonaUsuario extends Usuario {
	
	private int age, dni;
	private String lastname;
	private char gender;
	
	public PersonaUsuario(int dni, String name, String lastname, char gender, int age, String email, String address, int phone, int cellPhone) {
		super(name, email, address, phone, cellPhone);
		this.dni = dni;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
	}
	
	public PersonaUsuario(int dni, String password, String name, String lastname, char gender, int age, String email, String address, int phone, int cellPhone) {
		super(name, password, email, address, phone, cellPhone);
		this.dni = dni;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
	}
	
	public PersonaUsuario(int dni, String password, String name, String lastname, char gender, int age) {
		super(name, password);
		this.dni = dni;
		this.lastname = lastname;
		this.gender = gender;
		this.age = age;
	}
	
	public PersonaUsuario(int dni, String code, String password, String name, String lastname, char gender, int age, String email, String address, int phone, int cellPhone) {
		super(name, password, email, address, phone, cellPhone);
		this.dni = dni;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
	}
	
	public PersonaUsuario() {}
	
	protected String getFirstLastname() {
		String lastname = getLastname();
		if (lastname.contains(" ")) {
			String[] lastnames = lastname.split("\\s");
			String firstLastname = lastnames[0];
			
			return firstLastname.toLowerCase();
		}
		
		return lastname.toLowerCase();
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
