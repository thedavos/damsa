package clases;

public abstract class Usuario {
	private int phone, cellPhone, id;
	private String name, email, address, password, profileUrl, role, code;
	final private String folder = "users";
	
	public Usuario(String name, String password, String email, String address, int phone, int cellPhone) {
		this.phone = phone;
		this.cellPhone = cellPhone;
		this.name = name;
		this.email = email;
		this.address = address;
		this.password = password;
	}
	
	public Usuario(String name, String email, String address, int phone, int cellPhone) {
		this.phone = phone;
		this.cellPhone = cellPhone;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public Usuario(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public Usuario() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFolder() {
		return folder;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
