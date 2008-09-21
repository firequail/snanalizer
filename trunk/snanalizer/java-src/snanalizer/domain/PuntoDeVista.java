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

	public String toXml() {
		return toXml(getSubgrafos(getNodos()));
	}

	public String toXml(DatoMaestro datoMaestro) {
		return toXml(getSubgrafosAgrupados(datoMaestro));
	}

	private String toXml(List<Grafo> subgrafos) {
		StringBuilder builder = new StringBuilder();

		for (Grafo subgrafo : subgrafos) {
			builder.append(subgrafo.toXml());
		}

		return builder.toString();
	}

	@Transient
	private List<Grafo> getSubgrafos(Collection<Nodo> nodos) {
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

	@Transient
	private List<Grafo> getSubgrafosAgrupados(DatoMaestro datoMaestro) {
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

			if (grupoOrigen != null && grupoDestino != null
					&& grupoOrigen != grupoDestino) {
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

		int id = 1;
		for (Atributo atributo : datoMaestro.getAtributos()) {
			Nodo nodo = crearGrupo(atributo, id);
			grupos.put(atributo, nodo);
			id++;
		}

		return grupos;
	}

	private Nodo crearGrupo(Atributo atributo, int id) {
		// TODO: quick hack, un grupo no tiene ni recurso ni usuario
		Usuario usuario = new Usuario();
		usuario.setEmail(atributo.getNombre());
		usuario.setNombre(atributo.getNombre());
		Nodo nodo = new NodoGrupo(new Recurso(usuario), id);
		return nodo;
	}
}
