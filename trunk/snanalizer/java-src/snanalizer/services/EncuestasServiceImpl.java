package snanalizer.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.EncuestasRepository;
import snanalizer.domain.Encuesta;

@Transactional
public class EncuestasServiceImpl implements EncuestasService {

	@Resource
	private EncuestasRepository encuestasRepository;

	public void crear(Encuesta encuesta) {
		encuestasRepository.add(encuesta);
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
}
