package snanalizer.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.NodosRepository;
import snanalizer.data.PuntosDeVistaRepository;
import snanalizer.data.RedesRepository;
import snanalizer.domain.Nodo;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Red;
import snanalizer.domain.Relacion;

@Transactional
public class RedesServiceImpl implements RedesService {

	@Resource
	public PuntosDeVistaRepository puntosDeVista;

	@Resource
	public RedesRepository redesRepository;

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

	public String getGrafo(int puntoDeVistaId) {
		PuntoDeVista puntoDeVista = puntosDeVista.getById(puntoDeVistaId);
		List<Nodo> nodos = nodosRepository.getNodos(puntoDeVista);

		return buildGrafo(nodos);
	}

	private String buildGrafo(List<Nodo> nodos) {

		StringBuilder builder = new StringBuilder("<Graph>");

		for (Nodo nodo : nodos) {
			builder.append(nodo.toXml());
		}
		
		for (Nodo nodo : nodos) {
			for (Relacion relacion : nodo.getRelaciones()) {
				builder.append(relacion.toXml());
			}
		}

		builder.append("</Graph>");

		return builder.toString();

	}

	public List<PuntoDeVista> getPuntosDeVista(int redId) {
		Red red = redesRepository.getById(redId);
		return puntosDeVista.getPuntosDeVista(red);
	}

	public List<Red> getRedes() {
		return redesRepository.getAll();
	}
}
