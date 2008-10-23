package snanalizer.services;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.EncuestasDePortalRepository;
import snanalizer.data.EncuestasRepository;
import snanalizer.data.RecursosRepository;
import snanalizer.data.RedesRepository;
import snanalizer.data.RespuestasDeRecursosRepository;
import snanalizer.domain.Encuesta;
import snanalizer.domain.EncuestaDePortal;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;
import snanalizer.domain.Nodo;
import snanalizer.domain.Relacion;
import snanalizer.domain.Recurso;
import snanalizer.domain.Pregunta;
import snanalizer.domain.RespuestaDeRecurso;
import snanalizer.domain.RespuestaValor;
import snanalizer.domain.RespuestaDePortal;



@Transactional
public class EncuestasServiceImpl implements EncuestasService {

	@Resource
	private EncuestasRepository encuestasRepository;
	@Resource
	private EncuestasDePortalRepository encuestasDePortalRepository;
	@Resource
	private RecursosRepository recursosRepository;
	@Resource
	private RedesRepository redesRepository;
	@Resource
	private RespuestasDeRecursosRepository rtasRepository;

	public EncuestasDePortalRepository getEncuestasDePortalRepository() {
		return encuestasDePortalRepository;
	}

	public void setEncuestasDePortalRepository(
			EncuestasDePortalRepository encuestasDePortalRepository) {
		this.encuestasDePortalRepository = encuestasDePortalRepository;
	}

	public void crear(Encuesta encuesta) {
		encuestasRepository.add(encuesta);
	}

	public void crearEncuestaPortal(EncuestaDePortal encuestaDePortal) {
		encuestasDePortalRepository.add(encuestaDePortal);
	}

	public void setEncuestasRepository(EncuestasRepository encuestasRepository) {
		this.encuestasRepository = encuestasRepository;
	}

	public EncuestasRepository getEncuestasRepository() {
		return encuestasRepository;
	}

	public List<Encuesta> getEncuestas() {
		return encuestasRepository.getAll();
	}

	public List<EncuestaDePortal> getEncuestasPortal() {
		return encuestasDePortalRepository.getAll();
	}
	
	public List<Red> getSurveysOf(int recId) {
		
		Recurso recurso = recursosRepository.getById(recId);

		List<Red> redes = new ArrayList<Red>();
		
		
		for(Red red : redesRepository.getAll()) {
			for(PuntoDeVista ptoVista : red.getPuntosDeVista()) {
				for(Nodo node : ptoVista.getNodos()) {
					if(node.getRecurso().equals(recurso)) {
						if(!node.tieneRelacionesSalientes())
							if(!redes.contains(red))
								redes.add(red);
					}
				}
			}
		}
		return redes;
	}
	
	public List<Pregunta> getPreguntasOf(int encId) {
		return encuestasRepository.getById(encId).getPreguntas();
		
	}
	
	public List<EncuestaDePortal> getEncuestasDePortalPendientes(int recId) {
		List<EncuestaDePortal> encuestas = new ArrayList<EncuestaDePortal>();
		encuestas = encuestasDePortalRepository.getAll();
		encuestas.removeAll(this.getEncuestasDePortalHechas(recId));
		
		return encuestas;  

	}
	
	public List<EncuestaDePortal> getEncuestasDePortalHechas(int recId) {
		List<EncuestaDePortal> encuestas = new ArrayList<EncuestaDePortal>();
		List<RespuestaDeRecurso> listaRtas = new ArrayList<RespuestaDeRecurso>();
		
		listaRtas = rtasRepository.getRespuestasDeRecurso(recursosRepository.getById(recId));

		for(RespuestaDeRecurso rta : listaRtas)
			encuestas.add(rta.getEncuesta());
			
		
		return encuestas;
	}
	
	public List<RespuestaValor> getTotalRespuestas(int encId) {
		
		EncuestaDePortal encuesta = encuestasDePortalRepository.getById(encId);
		List<RespuestaDePortal> rtas = encuesta.getPreguntas().get(0).getRespuestas();
		List<RespuestaValor> resultados = new ArrayList<RespuestaValor>();
		
		for(RespuestaDePortal r : rtas) {
			RespuestaValor rv = new RespuestaValor();
			rv.setRespuesta(r.getDescripcion());
			rv.setValor(rtasRepository.getRespuestas(r).size());
			resultados.add(rv);
		}
		
		return resultados;	
		
	}
	


}
