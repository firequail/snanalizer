package snanalizer.services;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.EncuestasDePortalRepository;
import snanalizer.data.EncuestasRepository;
import snanalizer.data.RecursosRepository;
import snanalizer.data.RedesRepository;
import snanalizer.domain.Encuesta;
import snanalizer.domain.EncuestaDePortal;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;
import snanalizer.domain.Nodo;
import snanalizer.domain.Relacion;
import snanalizer.domain.Recurso;
import snanalizer.domain.Pregunta;


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
	
	public List<Encuesta> getSurveysOf(int recId) {
		
		Recurso recurso = recursosRepository.getById(recId);
		List<Encuesta> encuestasPendientes = new ArrayList<Encuesta>();
		List<Red> redes = redesRepository.getAll();
		
		for(Red red : redes) {
			for(PuntoDeVista ptoVista : red.getPuntosDeVista()) {
				for(Nodo node : ptoVista.getNodos()) {
					if(node.getRecurso().equals(recurso)) {
						if(!node.tieneRelacionesSalientes())
							if(!(encuestasPendientes.contains(ptoVista.getPregunta().getEncuesta())))
									encuestasPendientes.add(ptoVista.getPregunta().getEncuesta());
					}
				}
			}
		}
		return encuestasPendientes;
	}
	
	public List<Pregunta> getPreguntasOf(int encId) {
		return encuestasRepository.getById(encId).getPreguntas();
		
	}

}
