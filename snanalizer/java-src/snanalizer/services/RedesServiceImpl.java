package snanalizer.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.DatosMaestrosRepository;
import snanalizer.data.NodosRepository;
import snanalizer.data.PuntosDeVistaRepository;
import snanalizer.data.RedesRepository;
import snanalizer.domain.DatoMaestro;
import snanalizer.domain.Nodo;
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

	@Resource
	private DatosMaestrosRepository datosMaestrosRepository;

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

	public void setDatosMaestrosRepository(
			DatosMaestrosRepository datosMaestrosRepository) {
		this.datosMaestrosRepository = datosMaestrosRepository;
	}

	public DatosMaestrosRepository getDatosMaestrosRepository() {
		return datosMaestrosRepository;
	}

	public List<PuntoDeVista> getPuntosDeVista(int redId) {
		Red red = redesRepository.getById(redId);
		return red.getPuntosDeVista();
	}

	public List<Red> getRedes() {
		return redesRepository.getAll();
	}
	
	public List<DatoMaestro> getDatosMaestros() {
		return datosMaestrosRepository.getAll();
	}

	public Nodo getNodo(int id) {
		return nodosRepository.getById(id);
	}

	public String getGrafo(Integer idPtoVista, Integer idDatoMaestro) {
		PuntoDeVista puntoDeVista = puntosDeVista.getById(idPtoVista);

		if (idDatoMaestro == null) {

			return puntoDeVista.toXml();

		} else {

			DatoMaestro datoMaestro = datosMaestrosRepository
					.getById(idDatoMaestro);

			return puntoDeVista.toXml(datoMaestro);
		}
	}
}
