package snanalizer.data;

import snanalizer.domain.RespuestaDeRecurso; 
import java.util.List;

import snanalizer.domain.Recurso;
import snanalizer.domain.EncuestaDePortal;
import snanalizer.domain.RespuestaDePortal;


public interface RespuestasDeRecursosRepository extends BaseRepository<RespuestaDeRecurso> {
	
	public List<RespuestaDeRecurso> getRespuestasDeRecurso(Recurso rec);
	
	public List<RespuestaDeRecurso> getRespuestasDeEncuesta(EncuestaDePortal enc);
	
	public List<RespuestaDeRecurso> getRespuestas(RespuestaDePortal rta);


}
