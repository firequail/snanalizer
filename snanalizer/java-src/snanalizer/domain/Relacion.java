package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Relacion extends DomainEntity {

	private Recurso origen;

	private Recurso destino;

	private int intensidad;
	
	private PuntoDeVista puntoDeVista;

	public Relacion() {
		
	}
	
	public Relacion(Recurso origen, Recurso destino, int intensidad, PuntoDeVista puntoDeVista) {
		this.origen = origen;
		this.destino = destino;
		this.intensidad = intensidad;
		this.puntoDeVista = puntoDeVista;
	}

	public void setOrigen(Recurso origen) {
		this.origen = origen;
	}

	@ManyToOne
	public Recurso getOrigen() {
		return origen;
	}

	public void setDestino(Recurso destino) {
		this.destino = destino;
	}

	@ManyToOne
	public Recurso getDestino() {
		return destino;
	}

	public void setIntensidad(int intensidad) {
		this.intensidad = intensidad;
	}

	public int getIntensidad() {
		return intensidad;
	}

	public void setPuntoDeVista(PuntoDeVista puntoDeVista) {
		this.puntoDeVista = puntoDeVista;
	}

	@ManyToOne
	public PuntoDeVista getPuntoDeVista() {
		return puntoDeVista;
	}
	
	public String toXML() {
		return "<Edge fromID=\"" + getOrigen().getId() + "\" toID=\"" + getDestino().getId() + "\" edgeLabel=\"" + getIntensidad() + "\" />";
	}
}
