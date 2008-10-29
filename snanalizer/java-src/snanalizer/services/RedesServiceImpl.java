package snanalizer.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.DatosMaestrosRepository;
import snanalizer.data.EncuestasRepository;
import snanalizer.data.GruposRecursosRepository;
import snanalizer.data.NodosRepository;
import snanalizer.data.PreguntasRepository;
import snanalizer.data.PuntosDeVistaRepository;
import snanalizer.data.RecursosRepository;
import snanalizer.data.RedesRepository;
import snanalizer.data.RelacionesRepository;
import snanalizer.domain.BloqueEstadistico;
import snanalizer.domain.DatoMaestro;
import snanalizer.domain.Encuesta;
import snanalizer.domain.Filtro;
import snanalizer.domain.GrupoRecursos;
import snanalizer.domain.Nodo;
import snanalizer.domain.Pregunta;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Recurso;
import snanalizer.domain.Red;
import snanalizer.domain.Relacion;

@Transactional
public class RedesServiceImpl implements RedesService {

	@Resource
	private PuntosDeVistaRepository puntosDeVistaRepository;

	@Resource
	private RedesRepository redesRepository;

	@Resource
	private NodosRepository nodosRepository;

	@Resource
	private RelacionesRepository relacionesRepository;
	
	@Resource
	private RecursosRepository recursosRepository;
	
	@Resource
	private PreguntasRepository preguntasRepository;


	@Resource
	private DatosMaestrosRepository datosMaestrosRepository;

	@Resource
	private EncuestasRepository encuestasRepository;

	@Resource
	private GruposRecursosRepository gruposRecursosRepository;

	@Resource
	private JavaMailSender mailSender;

	public void setPuntosDeVista(PuntosDeVistaRepository puntosDeVista) {
		this.puntosDeVistaRepository = puntosDeVista;
	}

	public PuntosDeVistaRepository getPuntosDeVista() {
		return puntosDeVistaRepository;
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

	public EncuestasRepository getEncuestasRepository() {
		return encuestasRepository;
	}

	public void setEncuestasRepository(EncuestasRepository encuestasRepository) {
		this.encuestasRepository = encuestasRepository;
	}

	public GruposRecursosRepository getGruposRecursosRepository() {
		return gruposRecursosRepository;
	}

	public void setGruposRecursosRepository(
			GruposRecursosRepository gruposRecursosRepository) {
		this.gruposRecursosRepository = gruposRecursosRepository;
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
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


	public String getGrafo(Integer idPtoVista, Integer idDatoMaestro,
			Filtro filtro) {
		PuntoDeVista puntoDeVista = puntosDeVistaRepository.getById(idPtoVista);
		
		if (filtro == null) {
			filtro = new Filtro();
		}

		if (idDatoMaestro == null) {

			return puntoDeVista.toXml(filtro);

		} else {

			DatoMaestro datoMaestro = datosMaestrosRepository
					.getById(idDatoMaestro);

			return puntoDeVista.toXml(datoMaestro, filtro);
		}
	}

	public void crearRed(String nombre, String descripcion, int idGrupo,
			int idEncuesta) {

		Encuesta encuesta = encuestasRepository.getById(idEncuesta);
		GrupoRecursos grupo = gruposRecursosRepository.getById(idGrupo);

		Red red = new Red();
		redesRepository.add(red);
		red.setNombre(nombre);
		red.setDescripcion(descripcion);
		red.setEncuesta(encuesta);

		for (Pregunta pregunta : encuesta.getPreguntas()) {
			PuntoDeVista puntoDeVista = new PuntoDeVista();
			puntosDeVistaRepository.add(puntoDeVista);
			puntoDeVista.setPregunta(pregunta);
			puntoDeVista.setDescripcion(pregunta.getDescripcion());
			red.getPuntosDeVista().add(puntoDeVista);

			for (Recurso recurso : grupo.getRecursos()) {
				Nodo nodo = new Nodo();
				nodosRepository.add(nodo);
				nodo.setRecurso(recurso);
				puntoDeVista.getNodos().add(nodo);
			}
		}

		enviarEncuesta(grupo.getRecursos());
	}

	public void enviarEncuesta(List<Recurso> recursos) {

		try {
			List<MimeMessage> mails = new ArrayList<MimeMessage>(recursos
					.size());

			for (Recurso recurso : recursos) {
				MimeMessage msg = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(msg, true);
				helper.setTo(recurso.getUsuario().getEmail());
				helper.setFrom("snanalizer@gmail.com");
				helper.setSubject("SNA");
				helper
						.setText(
								"<html><body><b>msg</b> de prueba de sna</body></html>",
								true);
				mails.add(msg);
			}

			MimeMessage[] msgs = mails.toArray(new MimeMessage[0]);
			mailSender.send(msgs);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Recurso> getRecursosOf(int redId) {
		List<Recurso> recursos = new ArrayList<Recurso>();
		
		for(PuntoDeVista ptoVista : redesRepository.getById(redId).getPuntosDeVista()) {
			 for(Nodo nodo : ptoVista.getNodos())
				 if(!recursos.contains(nodo.getRecurso()))
					 recursos.add(nodo.getRecurso());
		}
		return recursos;
	}
	
	public List<Recurso> getRecursosOfExcept(int redId,int recursoId) {

		List<Recurso> recursos = new ArrayList<Recurso>();
		recursos = this.getRecursosOf(redId);
		recursos.remove(recursosRepository.getById(recursoId));
		return recursos;
	}
	
	public void generarRelaciones(int idRed,int idRec,List<Integer> preguntas,List<Integer> intensidades,List<Integer> recursos) {
		
		int i = -1;

		for(int idPreg : preguntas) {
			i++;

			PuntoDeVista ptoVista = this.getPtoVistaByPreguntaFromRed(idRed,preguntasRepository.getById(idPreg));
			Nodo nodoOrigen = ptoVista.getNodoByRec(recursosRepository.getById(idRec));
			Nodo nodoDestino = ptoVista.getNodoByRec(recursosRepository.getById(recursos.get(i)));

			Relacion rel = nodoOrigen.linkTo(nodoDestino, intensidades.get(i));
			relacionesRepository.add(rel);
 			
		}
		

	}
	
	public PuntoDeVista getPtoVistaByPreguntaFromRed(int idRed, Pregunta pregunta) {

		Red red = redesRepository.getById(idRed);
		for(PuntoDeVista ptoVista : red.getPuntosDeVista())
			if(ptoVista.getPregunta().equals(pregunta))
				return ptoVista;
		
		return null;
	}

	public List<Relacion> getCaminoMasCorto(int idOrigen, int idDestino) {
		
		if( idOrigen == 0 || idDestino == 0) {
			return new ArrayList<Relacion>(0);
		}
		
		Nodo origen = nodosRepository.getById(idOrigen);
		Nodo destino = nodosRepository.getById(idDestino);
		
		return origen.caminoMasCorto(destino);
	}
	
	public List<Red> getRedesById(List<Integer> ids) {
		return redesRepository.getById(ids);
	}
	
	
	public BloqueEstadistico getBloqueEstadistico(int idRed,int idPtoVista) {

		PuntoDeVista ptoVista = puntosDeVistaRepository.getById(idPtoVista);
		BloqueEstadistico bloque = new BloqueEstadistico();

		
		int cEnl = 0;
		int sumaInt = 0;
		// Nodo con + cantidad de enlaces entrantes
		int maxEnlEnt = 0;
		Nodo nodoMaxEnlEnt = null;
		// Nodo con + cantidad de enlaces salientes
		int maxEnlSal = 0;
		Nodo nodoMaxEnlSal = null;
		// Nodo con + cantidad de enlaces entrantes
		int maxIntEnt = 0;
		Nodo nodoMaxIntEnt = null;
		// Nodo con + cantidad de enlaces salientes
		int maxIntSal = 0;
		Nodo nodoMaxIntSal = null;

		
		for(Nodo nodo: ptoVista.getNodos()) {
			cEnl += nodo.getRelaciones().size();
			sumaInt += nodo.getIntensidadTotalEntrante() + nodo.getIntensidadTotalSaliente();
			if(nodo.getRelacionesEntrantes().size() > maxEnlEnt) {
				maxEnlEnt = nodo.getRelacionesEntrantes().size();
				nodoMaxEnlEnt = nodo;
			}
			if(nodo.getRelacionesSalientes().size() > maxEnlSal) {
				maxEnlSal = nodo.getRelacionesSalientes().size();
				nodoMaxEnlSal = nodo;
			}
			if(nodo.getIntensidadTotalEntrante() > maxIntEnt) {
				maxIntEnt = nodo.getIntensidadTotalEntrante();
				nodoMaxIntEnt = nodo;
			}
			if(nodo.getIntensidadTotalSaliente() > maxIntSal) {
				maxIntSal = nodo.getIntensidadTotalSaliente();
				nodoMaxIntSal = nodo;
			}

			
		}

		bloque.setCantNodos(ptoVista.getNodos().size());
		bloque.setCantEnlaces(cEnl/2);
		bloque.setPromEnl(cEnl/ptoVista.getNodos().size());
		bloque.setPromInt(sumaInt/ptoVista.getNodos().size()/2);
		bloque.setMaxEnlEnt(maxEnlEnt);
		bloque.setMaxEnlSal(maxEnlSal);
		bloque.setNodoMaxEnlEnt(nodoMaxEnlEnt);
		bloque.setNodoMaxEnlSal(nodoMaxEnlSal);
		bloque.setMaxSumEnlEnt(maxIntEnt);
		bloque.setMaxSumEnlSal(maxIntSal);
		bloque.setNodoMaxSumEnlEnt(nodoMaxIntEnt);
		bloque.setNodoMaxSumEnlSal(nodoMaxIntSal);
		
		
		return bloque;
	}

	public Red getRedById(int redId) {
		return redesRepository.getById(redId);
	}
	
	
}