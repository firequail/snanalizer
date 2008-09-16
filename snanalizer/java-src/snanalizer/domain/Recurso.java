package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import java.util.Date;
import snanalizer.domain.Atributo;

@Entity
public class Recurso extends DomainEntity {

	private Usuario usuario;
	private String nombre;
	private String apellido;
	private Date fechaNac;
	private Atributo area;
	private Atributo puesto;
	private Atributo seniority;
	private Boolean estado;

	public Recurso() {

	}

	public Recurso(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}

	@ManyToOne
	public Atributo _getArea() {
		return area;
	}

	@Transient
	public String getNombre() {
		return getUsuario().getNombre();
	}

	@Transient
	public String getApellido() {
		return getUsuario().getApellido();
	}

	@Transient
	public String getArea() {
		return _getArea().getNombre();
	}
}
