package clases;

import java.util.Date;

public class Sesion {
	int id;
	String cod_user;
	Date created;
	
	public Sesion() {
		
	}
	
	public Sesion(int id, String cod_user, Date created) {
		this.id=id;
		this.cod_user=cod_user;
		this.created=created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCod_user() {
		return cod_user;
	}

	public void setCod_user(String cod_user) {
		this.cod_user = cod_user;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
