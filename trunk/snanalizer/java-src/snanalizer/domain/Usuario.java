package snanalizer.domain;

import javax.persistence.Entity;

@Entity
public class Usuario extends DomainEntity {
	private String email;
	private String password;
	private String rol;

	public Usuario() {
		
	}
	
	public Usuario(String email, String password, String rol) {
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getRol() {
		return rol;
	}
}
