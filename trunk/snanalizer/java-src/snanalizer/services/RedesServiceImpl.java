package snanalizer.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.DatosMaestrosRepository;
import snanalizer.data.EncuestasRepository;
import snanalizer.data.GruposRecursosRepository;
import snanalizer.data.NodosRepository;
import snanalizer.data.PuntosDeVistaRepository;
import snanalizer.data.PreguntasRepository;
import snanalizer.data.RecursosRepository;
import snanalizer.data.RedesRepository;
import snanalizer.data.RelacionesRepository;
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

		if (idDatoMaestro == null) {

			return puntoDeVista.toXml();

		} else {

			DatoMaestro datoMaestro = datosMaestrosRepository
					.getById(idDatoMaestro);

			return puntoDeVista.toXml(datoMaestro);
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

		} catch (MailException e) {
			throw new RuntimeException(e);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
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
	
	public void generarRelaciones(int idRed,int idRec,List<Integer> preguntas,List<Integer> intensidades,List<Integer> recursos) {
		
		Red red = redesRepository.getById(idRed);
		int i = 0;
		//red.getPuntosDeVista()
		for(Integer idPreg : preguntas) {
			i++;
			PuntoDeVista ptoVista = puntosDeVistaRepository.getByPregunta(preguntasRepository.getById(idPreg));
			Nodo nodoOrigen = nodosRepository.getByRec(recursosRepository.getById(idRec));
			Nodo nodoDestino = nodosRepository.getById(recursos.get(i));
			ptoVista.getNodos().add(nodoOrigen);
			ptoVista.getNodos().add(nodoDestino);
			Relacion rel = nodoOrigen.linkTo(nodoDestino, intensidades.get(i));
			relacionesRepository.add(rel);	
 			
		}
		
		/*
		 Nodo nodo1 = new Nodo(recurso1);
		Nodo nodo2 = new Nodo(recurso2);
		Nodo nodo3 = new Nodo(recurso3);
		Nodo nodo4 = new Nodo(recurso4);
		nodos.add(nodo1);
		nodos.add(nodo2);
		nodos.add(nodo3);
		nodos.add(nodo4);

		Pregunta pregunta1 = new Pregunta();
		preguntasRepository.add(pregunta1);
		pregunta1.setDescripcion("Quien tiene mas conocimientos en usabilidad?");

		PuntoDeVista puntoDeVista1 = new PuntoDeVista();
		puntosDeVista.add(puntoDeVista1);
		puntoDeVista1.setPregunta(pregunta1);
		puntoDeVista1.setDescripcion(pregunta1.getDescripcion());
		puntoDeVista1.getNodos().add(nodo1);
		puntoDeVista1.getNodos().add(nodo2);
		puntoDeVista1.getNodos().add(nodo3);
		puntoDeVista1.getNodos().add(nodo4);

		Red red1 = new Red();
		redes.add(red1);
		red1.setDescripcion("Red de Prueba");
		red1.getPuntosDeVista().add(puntoDeVista1);

		// creo un grafo en forma de estrella
		Relacion relacion1 = nodo2.linkTo(nodo1, 3);
		Relacion relacion2 = nodo2.linkTo(nodo3, 3);
		Relacion relacion3 = nodo2.linkTo(nodo4, 3);
		Relacion relacion4 = nodo3.linkTo(nodo2, 3);
		relaciones.add(relacion1);
		relaciones.add(relacion2);
		relaciones.add(relacion3);
		relaciones.add(relacion4);
		 */
	}
}
