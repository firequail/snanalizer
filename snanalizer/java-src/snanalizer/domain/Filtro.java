package snanalizer.domain;

import java.util.LinkedList;
import java.util.List;

public class Filtro {

	private int areaId;

	private int puestoId;

	private int seniorityId;

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setPuestoId(int puestoId) {
		this.puestoId = puestoId;
	}

	public int getPuestoId() {
		return puestoId;
	}

	public void setSeniorityId(int seniorityId) {
		this.seniorityId = seniorityId;
	}

	public int getSeniorityId() {
		return seniorityId;
	}

	public List<Nodo> filtrarNodos(List<Nodo> nodos) {
		List<Nodo> nodosFiltrados = new LinkedList<Nodo>();

		for (Nodo nodo : nodos) {
			if (filtrar(nodo)) {
				nodosFiltrados.add(nodo);
			}
		}

		return nodosFiltrados;
	}

	public List<Relacion> filtrarRelaciones(List<Relacion> relaciones) {
		List<Relacion> relacionesFiltradas = new LinkedList<Relacion>();

		for (Relacion relacion : relaciones) {
			if (filtrar(relacion.getOrigen()) && filtrar(relacion.getDestino())) {
				relacionesFiltradas.add(relacion);
			}
		}

		return relacionesFiltradas;
	}

	public List<Atributo> filtrarAtributos(List<Atributo> atributos) {
		List<Atributo> atributosFiltrados = new LinkedList<Atributo>();

		for (Atributo atributo : atributos) {
			// TODO
			atributosFiltrados.add(atributo);
		}

		return atributosFiltrados;
	}

	private boolean filtrar(Nodo nodo) {
		return matchesArea(nodo) && matchesPuesto(nodo)
				&& matchesSeniority(nodo);
	}

	private boolean matchesSeniority(Nodo nodo) {
		return seniorityId == 0 || nodo.getRecurso() == null
				|| nodo.getRecurso().getSeniority() == null
				|| seniorityId == nodo.getRecurso().getSeniority().getId();
	}

	private boolean matchesPuesto(Nodo nodo) {
		return puestoId == 0 || nodo.getRecurso() == null
				|| nodo.getRecurso().getPuesto() == null
				|| puestoId == nodo.getRecurso().getPuesto().getId();
	}

	private boolean matchesArea(Nodo nodo) {
		return areaId == 0 || nodo.getRecurso() == null
				|| nodo.getRecurso().getArea() == null
				|| areaId == nodo.getRecurso().getArea().getId();
	}
}
