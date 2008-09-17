package snanalizer.services;

import javax.annotation.Resource;

import snanalizer.data.NodosRepository;
import snanalizer.domain.Nodo;

public class NodosServiceImpl implements NodosService {

	@Resource
	private NodosRepository nodos;
	
	public Nodo getById(int id) {
		return nodos.getById(id);
	}

	public void setNodos(NodosRepository nodos) {
		this.nodos = nodos;
	}

	public NodosRepository getNodos() {
		return nodos;
	}

}
