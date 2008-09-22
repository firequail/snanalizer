package snanalizer.domain;

public class NodoGrupo extends Nodo {

	public NodoGrupo() {

	}

	public NodoGrupo(Recurso recurso, int id) {
		super(recurso);
		setId(id);
	}
	
	public Relacion linkTo(Nodo nodoDestino, int intensidad) {
		for (Relacion relacion : getRelaciones()) {
			if (relacion.getDestino().equals(nodoDestino)) {
				relacion.setIntensidad(relacion.getIntensidad() + intensidad);
				return relacion;
			}
		}
		
		RelacionGrupo relacion = new RelacionGrupo(this,
				nodoDestino, intensidad);
		this.addRelacion(relacion);
		nodoDestino.addRelacion(relacion);
		
		return relacion;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NodoGrupo)) {
			return false;
		}

		NodoGrupo otro = (NodoGrupo) obj;

		return this.getRecurso().getUsuario().getEmail().equals(
				otro.getRecurso().getUsuario().getEmail());
	}

	public int hashCode() {
		return 23 * getRecurso().getUsuario().getEmail().hashCode();
	}
}
