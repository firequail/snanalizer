package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Recurso extends DomainEntity {

	private Usuario usuario;

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String toXml() {
		return "<Node id=\"" + getId() + "\" name=\"" + getId() + "\" desc=\"Nodo 1\" nodeColor=\"0x333333\" nodeSize=\"32\" nodeClass=\"earth\" nodeIcon=\"center\" x=\"10\" y=\"10\" />";
	}
}
