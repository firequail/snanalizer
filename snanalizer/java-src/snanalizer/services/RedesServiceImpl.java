package snanalizer.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.NodosRepository;
import snanalizer.data.PuntosDeVistaRepository;
import snanalizer.data.RedesRepository;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;

@Transactional
public class RedesServiceImpl implements RedesService {

	@Resource
	private PuntosDeVistaRepository puntosDeVista;

	@Resource
	private RedesRepository redesRepository;

	@Resource
	private NodosRepository nodosRepository;

	public void setPuntosDeVista(PuntosDeVistaRepository puntosDeVista) {
		this.puntosDeVista = puntosDeVista;
	}

	public PuntosDeVistaRepository getPuntosDeVista() {
		return puntosDeVista;
	}

	public void setRedesRepository(RedesRepository redes) {
		this.redesRepository = redes;
	}

	public RedesRepository getRedesRepository() {
		return redesRepository;
	}

	public void setNodosRepository(NodosRepository nodosRepository) {
		this.nodosRepository = nodosRepository;
	}

	public NodosRepository getNodosRepository() {
		return nodosRepository;
	}

	public List<PuntoDeVista> getPuntosDeVista(int redId) {
		Red red = redesRepository.getById(redId);
		return red.getPuntosDeVista();
	}

	public List<Red> getRedes() {
		return redesRepository.getAll();
	}

	public String getGrafo(int puntoDeVistaId) {
		PuntoDeVista puntoDeVista = puntosDeVista.getById(puntoDeVistaId);
		return puntoDeVista.toXml();
	}
}
