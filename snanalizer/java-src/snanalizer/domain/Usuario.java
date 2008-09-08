package snanalizer.domain;

import javax.persistence.Entity;

@Entity
public class Usuario extends DomainEntity {
	private String email;
	private String password;
	private String rol;
	private String nombre = "";
	private String apellido = "";

	public Usuario() {

	}

	public Usuario(String email, String password, String rol) {
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	public Usuario(String email, String password, String rol, String nombre,
			String apellido) {
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Usuario(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellido() {
		return apellido;
	}
}
