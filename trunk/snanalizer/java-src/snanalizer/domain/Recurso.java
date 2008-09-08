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
		//TODO: usar StringBuilder, pensar si no se puede hacer esto en flex, sacar colores y demas a styles
		return "<Node id=\"" + getId() + "\" name=\"" + getNombre() + " " + getApellido() + "\" desc=\"Nodo 1\" nodeColor=\"0x333333\" nodeSize=\"32\" nodeClass=\"earth\" nodeIcon=\"center\" x=\"0\" y=\"0\" />";
	}
}
