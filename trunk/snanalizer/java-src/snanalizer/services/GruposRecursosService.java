package snanalizer.services;

import java.util.List;

import snanalizer.domain.GrupoRecursos;
import snanalizer.domain.Recurso;

public interface GruposRecursosService {

	public List<GrupoRecursos> getAll();
	
	public List<Recurso> getRecursos(int grupoId);
}
