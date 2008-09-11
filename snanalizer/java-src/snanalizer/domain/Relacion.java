package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Relacion extends DomainEntity {

	private Nodo origen;

	private Nodo destino;

	private int intensidad;
	
	public Relacion() {
		
	}
	
	public Relacion(Nodo origen, Nodo destino, int intensidad) {
		this.origen = origen;
		this.destino = destino;
		this.intensidad = intensidad;
		origen.getRelaciones().add(this);
	}

	public void setOrigen(Nodo origen) {
		this.origen = origen;
	}

	@ManyToOne
	public Nodo getOrigen() {
		return origen;
	}

	public void setDestino(Nodo destino) {
		this.destino = destino;
	}

	@ManyToOne
	public Nodo getDestino() {
		return destino;
	}

	public void setIntensidad(int intensidad) {
		this.intensidad = intensidad;
	}

	public int getIntensidad() {
		return intensidad;
	}

	public String toXml() {
		return "<Edge fromID=\"" + getOrigen().getId() + "\" toID=\"" + getDestino().getId() + "\" edgeLabel=\"" + getIntensidad() + "\" />";
	}
}
