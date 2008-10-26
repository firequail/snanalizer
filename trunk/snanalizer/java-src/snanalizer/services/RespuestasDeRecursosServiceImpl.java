package snanalizer.services;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import snanalizer.data.RecursosRepository;
import snanalizer.data.RespuestasDePortalRepository;
import snanalizer.data.EncuestasDePortalRepository;
import snanalizer.data.RespuestasDeRecursosRepository;

import snanalizer.domain.Recurso;
import snanalizer.domain.EncuestaDePortal;
import snanalizer.domain.RespuestaDePortal;
import snanalizer.domain.RespuestaDeRecurso;


@Transactional
public class RespuestasDeRecursosServiceImpl implements RespuestasDeRecursosService {
	
	@Resource
	private RecursosRepository recursos;
	@Resource
	private RespuestasDePortalRepository respuestasPortal;
	@Resource
	private EncuestasDePortalRepository encuestasPortal;
	@Resource
	private RespuestasDeRecursosRepository respuestasRecurso;
		
	
	public void responderEncuesta(int recId,int encId, int rtaId) {
		Recurso rec = recursos.getById(recId);
		EncuestaDePortal enc = encuestasPortal.getById(encId);
		RespuestaDePortal res = respuestasPortal.getById(rtaId);
		
		RespuestaDeRecurso respuestaRec = new RespuestaDeRecurso(rec,enc,res);
		
		respuestasRecurso.add(respuestaRec);
		
	}
	
	public List<RespuestaDeRecurso> getAllAnswersOf(int idRec) {
		return respuestasRecurso.getRespuestasDeRecurso(recursos.getById(idRec));
	}

}
