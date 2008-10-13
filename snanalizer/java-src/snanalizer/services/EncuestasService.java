package snanalizer.services;

import java.util.List;

import snanalizer.domain.Encuesta;
import snanalizer.domain.EncuestaDePortal;
import snanalizer.domain.Pregunta;

public interface EncuestasService {

	public void crear(Encuesta encuesta);

	public void crearEncuestaPortal(EncuestaDePortal encuestaDePortal);
	
	public List<Encuesta> getEncuestas();
	
	public List<EncuestaDePortal> getEncuestasPortal();
	
	public List<Encuesta> getSurveysOf(int recId);
	
	public List<Pregunta> getPreguntasOf(int encId);
}
