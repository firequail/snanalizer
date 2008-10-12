package snanalizer.services;

import java.util.List;

import snanalizer.domain.GrupoRecursos;

public interface GruposRecursosService {

	public List<GrupoRecursos> getAll();

	public void nuevoGrupo(String descripcion, List<Integer> idsRecursos);

	public void modificarGrupo(int grupoId, String descripcion,
			List<Integer> idsRecursos);

	public void eliminar(int grupoId);
}
