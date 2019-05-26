package clases;

public abstract class Usuario {
	private int phone, cellPhone, id;
	private String name, email, address;
	
	public Usuario(String name, String email, String address, int phone, int cellPhone) {
		this.phone = phone;
		this.cellPhone = cellPhone;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getCellphone() {
		return cellPhone;
	}

	public void setCellphone(int cellphone) {
		this.cellPhone = cellphone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
