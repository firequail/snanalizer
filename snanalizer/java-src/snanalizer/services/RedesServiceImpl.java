package snanalizer.services;

import java.io.FileNotFoundException;
import java.util.Arrays;
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
	PuntosDeVistaRepository puntosDeVista;

	@Resource
	RedesRepository redes;

	@Resource
	private RelacionesRepository relaciones;

	public void setPuntosDeVista(PuntosDeVistaRepository puntosDeVista) {
		this.puntosDeVista = puntosDeVista;
	}

	public PuntosDeVistaRepository getPuntosDeVista() {
		return puntosDeVista;
	}

	public void setRedes(RedesRepository redes) {
		this.redes = redes;
	}

	public RedesRepository getRedes() {
		return redes;
	}

	public void setRelaciones(RelacionesRepository relaciones) {
		this.relaciones = relaciones;
	}

	public RelacionesRepository getRelaciones() {
		return relaciones;
	}

	public String getGrafo(int puntoDeVistaId) throws FileNotFoundException {
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

	private String getGrafoHardcodeado() {
		return "<Graph><Node id=\"1\" name=\"0\" desc=\"Nodo 1\" nodeColor=\"0x333333\" nodeSize=\"32\" nodeClass=\"earth\" nodeIcon=\"center\" x=\"10\" y=\"10\" />"
				+ "<Node id=\"2\" name=\"A\" desc=\"Nodo 2\" nodeColor=\"0x8F8FFF\" nodeSize=\"12\" nodeClass=\"tree\" nodeIcon=\"2\" x=\"10\" y=\"15\" />"
				+ "<Edge fromID=\"1\" toID=\"2\" edgeLabel=\"Relacion 1\" flow=\"50\" color=\"0x556b2f\" edgeClass=\"sun\" edgeIcon=\"NoChange\" /></Graph>";
	}

	public List<PuntoDeVista> getPuntosDeVista(int redId) {
		Red red = redes.getById(redId);
		return puntosDeVista.getPuntosDeVista(red);
	}
}
