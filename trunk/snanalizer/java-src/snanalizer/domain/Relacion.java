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
		StringBuilder builder = new StringBuilder();
		
		builder.append("  <Edge ");

		addField(builder, "fromID", getOrigen().getId());
		addField(builder, "toID", getDestino().getId());
		addField(builder, "edgeLabel", getIntensidad());
		addField(builder, "fromIntensity", 3);
		addField(builder, "toIntensity", 2);
		
		builder.append("/>\n");
		return builder.toString();
	}

	private void addField(StringBuilder builder, String fieldName,
			Object fieldValue) {
		builder.append(fieldName + "=\"" + fieldValue + "\" ");
	}
}
