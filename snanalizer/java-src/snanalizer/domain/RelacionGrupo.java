package snanalizer.domain;

public class RelacionGrupo extends Relacion {

	public RelacionGrupo() {

	}

	public RelacionGrupo(Nodo grupoOrigen, Nodo grupoDestino, int intensidad) {
		super(grupoOrigen, grupoDestino, intensidad);
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Relacion)) {
			return false;
		}

		Relacion otro = (Relacion) obj;

		return this.getOrigen().equals(otro.getOrigen())
				&& this.getDestino().equals(otro.getDestino());
	}

	public int hashCode() {
		// Le sumo 1 al origen para q la relacion de vuelta no tenga el mismo
		// hashcode

		return (getOrigen().hashCode() + 1) * getDestino().hashCode();
	}
}
