package snanalizer.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.PuntosDeVistaRepository;
import snanalizer.data.RedesRepository;
import snanalizer.data.RelacionesRepository;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Recurso;
import snanalizer.domain.Red;
import snanalizer.domain.Relacion;

@Transactional
public class RedesServiceImpl implements RedesService {

	@Resource
	public PuntosDeVistaRepository puntosDeVista;

	@Resource
	public RedesRepository redesRepository;

	@Resource
	private RelacionesRepository relaciones;

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

	public void setRelaciones(RelacionesRepository relaciones) {
		this.relaciones = relaciones;
	}

	public RelacionesRepository getRelaciones() {
		return relaciones;
	}

	public String getGrafo(int puntoDeVistaId) {
		PuntoDeVista puntoDeVista = puntosDeVista.getById(puntoDeVistaId);
		List<Relacion> listaRelaciones = relaciones.getRelaciones(puntoDeVista);

		HashSet<Recurso> conjuntoDeRecursos = new HashSet<Recurso>();

		for (Relacion relacion : listaRelaciones) {
			conjuntoDeRecursos.add(relacion.getOrigen());
			conjuntoDeRecursos.add(relacion.getDestino());
		}

		return buildGrafo(conjuntoDeRecursos, listaRelaciones);
	}

	private String buildGrafo(Collection<Recurso> recursos,
			Collection<Relacion> listaRelaciones) {

		StringBuilder builder = new StringBuilder("<Graph>");

		for (Recurso recurso : recursos) {
			builder.append(recurso.toXml());
		}

		for (Relacion relacion : listaRelaciones) {
			builder.append(relacion.toXML());
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
