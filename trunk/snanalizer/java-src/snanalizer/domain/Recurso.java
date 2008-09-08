package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Recurso extends DomainEntity {

	private Usuario usuario;

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Recurso() {
		
	}
	
	public Recurso(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}
	
	@Transient
	public String getNombre() {
		return getUsuario().getNombre();
	}
	
	@Transient
	public String getApellido() {
		return getUsuario().getApellido();
	}
	
	public String toXml() {
		//TODO: usar StringBuilder
		return "<Node id=\"" + getId() + "\" name=\"" + getNombre() + " " + getApellido() + "\"/>";
	}
}
