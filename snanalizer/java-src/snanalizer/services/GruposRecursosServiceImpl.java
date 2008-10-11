package snanalizer.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.GruposRecursosRepository;
import snanalizer.data.RecursosRepository;
import snanalizer.domain.GrupoRecursos;
import snanalizer.domain.Recurso;

@Transactional
public class GruposRecursosServiceImpl implements GruposRecursosService {

	@Resource
	private GruposRecursosRepository gruposRecursosRepo;
	@Resource
	public RecursosRepository recursosRepo;

	public List<GrupoRecursos> getAll() {
		return gruposRecursosRepo.getAll();
	}

	public List<Recurso> getRecursos(int grupoId) {
		GrupoRecursos grupo = gruposRecursosRepo.getById(grupoId);
		return grupo.getRecursos();
	}

	public void updateGrupo(int grupoId, List<Recurso> listaRec) {
		gruposRecursosRepo.getById(grupoId).getRecursos().clear();
		gruposRecursosRepo.getById(grupoId).getRecursos().addAll(listaRec);
	}

	public GrupoRecursos getById(int grupoId) {
		return gruposRecursosRepo.getById(grupoId);
	}

	public void crear(GrupoRecursos grupo) {
		gruposRecursosRepo.add(grupo);
	}

	public void nuevoGrupo(String descripcion, List<Integer> idsRecursos) {
		GrupoRecursos grupo = new GrupoRecursos();
		gruposRecursosRepo.add(grupo);
		grupo.setDescripcion(descripcion);

		List<Recurso> recursos = recursosRepo.getById(idsRecursos);
		grupo.setRecursos(recursos);
	}
}
