package snanalizer.services;


import java.util.List;
import snanalizer.domain.RespuestaDeRecurso;

public interface RespuestasDeRecursosService {

	public void responderEncuesta(int recId,int encId, int rtaId);
	
	public List<RespuestaDeRecurso> getAllAnswersOf(int idRec);
	
	
}
