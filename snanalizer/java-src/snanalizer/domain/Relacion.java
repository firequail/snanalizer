package snanalizer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import snanalizer.util.XmlTagBuilder;

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
		origen.addRelacion(this);
		destino.addRelacion(this);
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
		XmlTagBuilder builder = new XmlTagBuilder("Edge");

		builder.addAttribute("fromID", getOrigen().getId());
		builder.addAttribute("toID", getDestino().getId());
		builder.addAttribute("edgeLabel", getIntensidad());
		builder.addAttribute("fromIntensity", 3);
		builder.addAttribute("toIntensity", 2);
		
		return "  " + builder.toString() + "\n";
	}
}
