package snanalizer.services;

import java.util.List;

import snanalizer.domain.Encuesta;
import snanalizer.domain.EncuestaDePortal;
import snanalizer.domain.Pregunta;
import snanalizer.domain.Recurso;
import snanalizer.domain.Red;
import snanalizer.domain.RespuestaValor;

public interface EncuestasService {

	public void crear(Encuesta encuesta);

	public void crearEncuestaPortal(EncuestaDePortal encuestaDePortal);
	
	public List<Encuesta> getEncuestas();
	
	public List<EncuestaDePortal> getEncuestasPortal();
	
	public List<Red> getSurveysOf(int recId);
	
	public List<Pregunta> getPreguntasOf(int encId);
	
	public List<EncuestaDePortal> getEncuestasDePortalPendientes(int recId);
	
	public List<EncuestaDePortal> getEncuestasDePortalHechas(int recId);
	
	public List<RespuestaValor> getTotalRespuestas(int encId);


}
