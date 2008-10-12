package snanalizer.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.EncuestasDePortalRepository;
import snanalizer.data.EncuestasRepository;
import snanalizer.domain.Encuesta;
import snanalizer.domain.EncuestaDePortal;

@Transactional
public class EncuestasServiceImpl implements EncuestasService {

	@Resource
	private EncuestasRepository encuestasRepository;

	@Resource
	private EncuestasDePortalRepository encuestasDePortalRepository;

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
}
