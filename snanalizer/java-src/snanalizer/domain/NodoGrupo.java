package snanalizer.domain;

public class NodoGrupo extends Nodo {

	public NodoGrupo() {

	}

	public NodoGrupo(Recurso recurso, int id) {
		super(recurso);
		setId(id);
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
