package snanalizer.services;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.domain.Atributo;
import snanalizer.domain.Encuesta;
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
	
	public void updateGrupo(int grupoId,List<Recurso> listaRec) {
		gruposRecursos.getById(grupoId).getRecursos().clear();
		gruposRecursos.getById(grupoId).getRecursos().addAll(listaRec);
	}
	
	public GrupoRecursos getById(int grupoId) {
		return gruposRecursos.getById(grupoId);
	}
	
	
	public void crear(GrupoRecursos grupo) {
		gruposRecursos.add(grupo);
	}
	  
	 
	
	
}
