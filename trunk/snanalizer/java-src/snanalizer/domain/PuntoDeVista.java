package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PuntoDeVista extends DomainEntity {

	private String descripcion;
	
	private Red red;

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setRed(Red red) {
		this.red = red;
	}

	@ManyToOne
	public Red getRed() {
		return red;
	}
}
