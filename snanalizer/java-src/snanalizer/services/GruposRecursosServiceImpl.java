package snanalizer.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.domain.GrupoRecursos;
import snanalizer.data.RecursosRepository;
import snanalizer.data.GruposRecursosRepository;
import snanalizer.domain.Recurso;


@Transactional
public class GruposRecursosServiceImpl implements GruposRecursosService {

	@Resource
	private GruposRecursosRepository gruposRecursos;
	@Resource
	public RecursosRepository recursos;
	
	public List<GrupoRecursos> getAll() {
		return gruposRecursos.getAll();
	}

	public List<Recurso> getRecursos(int grupoId) {
		GrupoRecursos grupo = gruposRecursos.getById(grupoId);
		return grupo.getRecursos();
	}
	
}
