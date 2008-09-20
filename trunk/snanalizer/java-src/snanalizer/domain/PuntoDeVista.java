package snanalizer.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class PuntoDeVista extends DomainEntity {

	private String descripcion;

	private List<Nodo> nodos = new LinkedList<Nodo>();

	public PuntoDeVista() {

	}

	public PuntoDeVista(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	public List<Nodo> getNodos() {
		return nodos;
	}

	@Transient
	public List<Grafo> getSubgrafos(Collection<Nodo> nodos) {
		List<Nodo> nodosRestantes = new LinkedList<Nodo>(nodos);
		List<Grafo> subgrafos = new LinkedList<Grafo>();

		while (!nodosRestantes.isEmpty()) {
			Nodo root = nodosRestantes.get(0);
			Grafo subgrafo = root.getGrafo();
			subgrafos.add(subgrafo);
			nodosRestantes.removeAll(subgrafo.getNodos());
		}

		return subgrafos;
	}

	public String toXml() {
		StringBuilder builder = new StringBuilder();

		for (Grafo subgrafo : getSubgrafos(getNodos())) {
			builder.append(subgrafo.toXml());
		}

		return builder.toString();
	}

	@Transient
	public List<Grafo> getSubgrafosAgrupados(DatoMaestro datoMaestro) {

		// Tal vez haya q crear un clase grupo en vez de nodo
		Map<Atributo, Nodo> mapaAtributosGrupos = crearMapaGrupos(datoMaestro);

		asignarRelaciones(mapaAtributosGrupos, getRelaciones(), datoMaestro);

		Collection<Nodo> grupos = mapaAtributosGrupos.values();

		return getSubgrafos(grupos);
	}

	private void asignarRelaciones(Map<Atributo, Nodo> mapaAtributosGrupos,
			Set<Relacion> conjuntoRelaciones, DatoMaestro datoMaestro) {
		for (Relacion relacion : conjuntoRelaciones) {

			Nodo grupoOrigen = mapaAtributosGrupos.get(relacion.getOrigen()
					.getRecurso().getAtributo(datoMaestro));

			Nodo grupoDestino = mapaAtributosGrupos.get(relacion.getDestino()
					.getRecurso().getAtributo(datoMaestro));

			if (grupoOrigen != null && grupoDestino != null) {
				new RelacionGrupo(grupoOrigen, grupoDestino, relacion
						.getIntensidad());
			}
		}
	}

	@Transient
	private Set<Relacion> getRelaciones() {
		Set<Relacion> relaciones = new HashSet<Relacion>();

		for (Nodo nodo : getNodos()) {
			nodo.addRelacionesTo(relaciones);
		}

		return relaciones;
	}

	private Map<Atributo, Nodo> crearMapaGrupos(DatoMaestro datoMaestro) {
		HashMap<Atributo, Nodo> grupos = new HashMap<Atributo, Nodo>(
				datoMaestro.getAtributos().size());

		for (Atributo atributo : datoMaestro.getAtributos()) {
			Nodo nodo = crearGrupo(atributo);
			grupos.put(atributo, nodo);
		}

		return grupos;
	}

	private Nodo crearGrupo(Atributo atributo) {
		// TODO: quick hack, un grupo no tiene ni recurso ni usuario, pensar en
		// usar una clase grupo en lugar de un nodo
		Usuario usuario = new Usuario();
		usuario.setEmail(atributo.getNombre());
		usuario.setNombre(atributo.getNombre());
		Nodo nodo = new NodoGrupo(new Recurso(usuario));
		return nodo;
	}
}
