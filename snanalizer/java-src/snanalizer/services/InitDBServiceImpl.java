package snanalizer.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.AtributosRepository;
import snanalizer.data.DatosMaestrosRepository;
import snanalizer.data.GruposRecursosRepository;
import snanalizer.data.NodosRepository;
import snanalizer.data.PreguntasRepository;
import snanalizer.data.PuntosDeVistaRepository;
import snanalizer.data.RecursosRepository;
import snanalizer.data.RedesRepository;
import snanalizer.data.RelacionesRepository;
import snanalizer.data.UsuariosRepository;
import snanalizer.domain.Atributo;
import snanalizer.domain.DatoMaestro;
import snanalizer.domain.GrupoRecursos;
import snanalizer.domain.Nodo;
import snanalizer.domain.Pregunta;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Recurso;
import snanalizer.domain.Red;
import snanalizer.domain.Relacion;
import snanalizer.domain.Usuario;
import snanalizer.install.Installer;

@Transactional
public class InitDBServiceImpl implements InitDBService {

	@Resource
	private RedesRepository redes;

	@Resource
	private PuntosDeVistaRepository puntosDeVista;

	@Resource
	private RecursosRepository recursos;

	@Resource
	private AtributosRepository atributosRepository;

	@Resource
	private RelacionesRepository relaciones;

	@Resource
	private UsuariosRepository usuarios;

	@Resource
	private NodosRepository nodos;

	@Resource
	private DatosMaestrosRepository datosMaestros;

	@Resource
	private AtributosRepository atributos;

	@Resource
	private GruposRecursosRepository gruposRecursos;

	@Resource
	private PreguntasRepository preguntasRepository;

	public static void main(String[] args) {
		new Installer().install();
	}

	public void initDB() {
		// Inicializar la DB para produccion
	}

	public void recrearTestDB() {
		cleanDB();
		crearUsuarios();
		// crearDatosMaestros();
		crearRedDePrueba1();
		crearRedDePrueba2();
		crearRedDePrueba3();
		crearRedDePrueba4();
	}

	private void cleanDB() {
		redes.removeAll();
		puntosDeVista.removeAll();
		relaciones.removeAll();
		recursos.removeAll();
		usuarios.removeAll();
		nodos.removeAll();
		datosMaestros.removeAll();
		atributosRepository.removeAll();
	}

	private void crearUsuarios() {
		Usuario admin = new Usuario("admin", "admin", "ADMIN");
		Usuario analista = new Usuario("analista", "analista", "ANALISTA");
		Usuario hr = new Usuario("hr", "hr", "HR");
		usuarios.add(admin);
		usuarios.add(analista);
		usuarios.add(hr);
	}

	private void crearRedDePrueba1() {

		/***********************************************************************
		 * Acá empieza la parte de creación de los datos maestros
		 **********************************************************************/

		// Atributos para puesto, area y seniority
		DatoMaestro dm1 = new DatoMaestro();
		DatoMaestro dm2 = new DatoMaestro();
		DatoMaestro dm3 = new DatoMaestro();

		Atributo atr1_dm1 = new Atributo();
		Atributo atr2_dm1 = new Atributo();
		Atributo atr3_dm1 = new Atributo();

		Atributo atr1_dm2 = new Atributo();
		Atributo atr2_dm2 = new Atributo();
		Atributo atr3_dm2 = new Atributo();
		Atributo atr1_dm3 = new Atributo();
		Atributo atr2_dm3 = new Atributo();
		Atributo atr3_dm3 = new Atributo();

		datosMaestros.add(dm1);
		datosMaestros.add(dm2);
		datosMaestros.add(dm3);

		atributosRepository.add(atr1_dm1);
		atributosRepository.add(atr2_dm1);
		atributosRepository.add(atr3_dm1);
		atributosRepository.add(atr1_dm2);
		atributosRepository.add(atr2_dm2);
		atributosRepository.add(atr3_dm2);
		atributosRepository.add(atr1_dm3);
		atributosRepository.add(atr2_dm3);
		atributosRepository.add(atr3_dm3);

		atr1_dm1.setNombre("DEV");
		atr2_dm1.setNombre("RRHH");
		atr3_dm1.setNombre("Finances");
		atr1_dm2.setNombre("FA");
		atr2_dm2.setNombre("DEV");
		atr3_dm2.setNombre("QC");
		atr1_dm3.setNombre("Junior");
		atr2_dm3.setNombre("Semisenior");
		atr3_dm3.setNombre("Senior");

		dm1.setDescripcion("Area");
		dm2.setDescripcion("Puesto");
		dm3.setDescripcion("Seniority");

		atr1_dm1.setDatoMaestro(dm1);
		atr2_dm1.setDatoMaestro(dm1);
		atr3_dm1.setDatoMaestro(dm1);
		atr1_dm2.setDatoMaestro(dm2);
		atr2_dm2.setDatoMaestro(dm2);
		atr3_dm2.setDatoMaestro(dm2);
		atr1_dm3.setDatoMaestro(dm3);
		atr2_dm3.setDatoMaestro(dm3);
		atr3_dm3.setDatoMaestro(dm3);

		dm1.getAtributos().add(atr1_dm1);
		dm1.getAtributos().add(atr2_dm1);
		dm1.getAtributos().add(atr3_dm1);
		dm2.getAtributos().add(atr1_dm2);
		dm2.getAtributos().add(atr2_dm2);
		dm2.getAtributos().add(atr3_dm2);
		dm3.getAtributos().add(atr1_dm3);
		dm3.getAtributos().add(atr2_dm3);
		dm3.getAtributos().add(atr3_dm3);

		// ****** Atributos para IDIOMAS ******//

		DatoMaestro dmIdiomas = new DatoMaestro();
		dmIdiomas.setDescripcion("Idioma");

		Atributo idiomaI = new Atributo("Inglés", "Idioma Inglés", true);
		Atributo idiomaP = new Atributo("Portugués", "Idioma Portugués", true);
		Atributo idiomaA = new Atributo("Alemán", "Idioma Alemán", true);
		Atributo idiomaF = new Atributo("Francés", "Idioma Francés", true);

		List<Atributo> listaIdiomas = new ArrayList<Atributo>();
		listaIdiomas.add(idiomaI);
		listaIdiomas.add(idiomaP);
		listaIdiomas.add(idiomaA);
		listaIdiomas.add(idiomaF);

		dmIdiomas.setAtributos(listaIdiomas);

		for (Iterator<Atributo> atr = listaIdiomas.iterator(); atr.hasNext();) {
			Atributo a = atr.next();
			a.setDatoMaestro(dmIdiomas);
		}

		// Agrego al repositorio

		atributosRepository.add(idiomaI);
		atributosRepository.add(idiomaP);
		atributosRepository.add(idiomaA);
		atributosRepository.add(idiomaF);
		datosMaestros.add(dmIdiomas);

		// ****** Atributos para NIVELES ******//

		DatoMaestro dmNiveles = new DatoMaestro();
		dmNiveles.setDescripcion("Nivel");

		Atributo nivel1 = new Atributo("Básico", "Nivel Básico", true);
		Atributo nivel2 = new Atributo("Intermedio", "Nivel Intermedio", true);
		Atributo nivel3 = new Atributo("Avanzado", "Nivel Avanzado", true);
		Atributo nivel4 = new Atributo("Nativo", "Nivel Nativo", true);

		List<Atributo> listaNiveles = new ArrayList<Atributo>();
		listaNiveles.add(nivel1);
		listaNiveles.add(nivel2);
		listaNiveles.add(nivel3);
		listaNiveles.add(nivel4);

		dmNiveles.setAtributos(listaNiveles);

		for (Iterator<Atributo> atr = listaNiveles.iterator(); atr.hasNext();) {
			Atributo a = atr.next();
			a.setDatoMaestro(dmNiveles);
		}

		// Agrego al repositorio

		atributosRepository.add(nivel1);
		atributosRepository.add(nivel2);
		atributosRepository.add(nivel3);
		atributosRepository.add(nivel4);
		datosMaestros.add(dmNiveles);

		// ****** Atributos para INSTUCIONES ******//

		DatoMaestro dmInst = new DatoMaestro();
		dmInst.setDescripcion("Institución");

		Atributo inst1 = new Atributo("UTN",
				"Universidad Tecnológica Nacional", true);
		Atributo inst2 = new Atributo("UBA", "Universidad de Buenos Aires",
				true);
		Atributo inst3 = new Atributo("ITBA", "Instituto Técnico de Bs. As.",
				true);
		Atributo inst4 = new Atributo("UADE",
				"Universidad Argentina de la Empresa", true);

		List<Atributo> listaInst = new ArrayList<Atributo>();
		listaInst.add(inst1);
		listaInst.add(inst2);
		listaInst.add(inst3);
		listaInst.add(inst4);

		dmInst.setAtributos(listaInst);

		for (Iterator<Atributo> atr = listaInst.iterator(); atr.hasNext();) {
			Atributo a = atr.next();
			a.setDatoMaestro(dmInst);
		}

		// Agrego al repositorio

		atributosRepository.add(inst1);
		atributosRepository.add(inst2);
		atributosRepository.add(inst3);
		atributosRepository.add(inst4);
		datosMaestros.add(dmInst);

		// ****** Atributos para HOBBIES ******//

		DatoMaestro dmHobb = new DatoMaestro();
		dmHobb.setDescripcion("Hobby");

		Atributo hob1 = new Atributo("Deporte", "Deporte", true);
		Atributo hob2 = new Atributo("Teatro", "Teatro", true);
		Atributo hob3 = new Atributo("Traveling", "Viajes", true);
		Atributo hob4 = new Atributo("Paintball", "Paintball", true);

		List<Atributo> listaHob = new ArrayList<Atributo>();
		listaHob.add(hob1);
		listaHob.add(hob2);
		listaHob.add(hob3);
		listaHob.add(hob4);

		dmHobb.setAtributos(listaHob);

		for (Iterator<Atributo> atr = listaHob.iterator(); atr.hasNext();) {
			Atributo a = atr.next();
			a.setDatoMaestro(dmHobb);
		}

		// Agrego al repositorio

		atributosRepository.add(hob1);
		atributosRepository.add(hob2);
		atributosRepository.add(hob3);
		atributosRepository.add(hob4);
		datosMaestros.add(dmHobb);

		/***********************************************************************
		 * Acá termina la creación de datos maestros
		 **********************************************************************/

		Usuario usuario1 = new Usuario("r1@hotmail.com", "", "RECURSO", "Pepe",
				"Lopez");
		Usuario usuario2 = new Usuario("r2@hotmail.com", "", "RECURSO",
				"Nestor", "Ticolis");
		Usuario usuario3 = new Usuario("r3@hotmail.com", "", "RECURSO", "Juan",
				"Candado");
		Usuario usuario4 = new Usuario("r4@hotmail.com", "", "RECURSO",
				"Ariel", "Ortega");
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		usuarios.add(usuario4);

		Recurso recurso1 = new Recurso(usuario1);
		Recurso recurso2 = new Recurso(usuario2);
		Recurso recurso3 = new Recurso(usuario3);
		Recurso recurso4 = new Recurso(usuario4);

		recurso1.setArea(atributos.getAll().get(0));
		recurso1.setPuesto(atributos.getAll().get(4));
		recurso1.setSeniority(atributos.getAll().get(6));
		recurso1.setHobbie1(hob1);
		recurso1.setHobbie2(hob2);
		recurso1.setHobbie3(hob3);
		recurso1.setHobbie4(hob4);
		recurso1.setIdioma1(idiomaI);
		recurso1.setIdioma2(idiomaP);
		recurso1.setIdioma3(idiomaF);
		recurso1.setNivelIdioma1(nivel1);
		recurso1.setNivelIdioma2(nivel2);
		recurso1.setNivelIdioma3(nivel1);
		recurso1.setInstitucion(inst1);

		recurso2.setArea(atributos.getAll().get(0));
		recurso2.setPuesto(atributos.getAll().get(4));
		recurso2.setSeniority(atributos.getAll().get(7));
		recurso2.setHobbie1(hob1);
		recurso2.setHobbie2(hob2);
		recurso2.setHobbie3(hob3);
		recurso2.setHobbie4(hob4);
		recurso2.setIdioma1(idiomaI);
		recurso2.setIdioma2(idiomaP);
		recurso2.setIdioma3(idiomaF);
		recurso2.setNivelIdioma1(nivel1);
		recurso2.setNivelIdioma2(nivel2);
		recurso2.setNivelIdioma3(nivel1);
		recurso2.setInstitucion(inst1);

		recurso3.setArea(atributos.getAll().get(0));
		recurso3.setPuesto(atributos.getAll().get(5));
		recurso3.setSeniority(atributos.getAll().get(8));
		recurso3.setHobbie1(hob1);
		recurso3.setHobbie2(hob2);
		recurso3.setHobbie3(hob3);
		recurso3.setHobbie4(hob4);
		recurso3.setIdioma1(idiomaI);
		recurso3.setIdioma2(idiomaP);
		recurso3.setIdioma3(idiomaF);
		recurso3.setNivelIdioma1(nivel1);
		recurso3.setNivelIdioma2(nivel2);
		recurso3.setNivelIdioma3(nivel1);
		recurso3.setInstitucion(inst1);

		recurso4.setArea(atributos.getAll().get(0));
		recurso4.setPuesto(atributos.getAll().get(4));
		recurso4.setSeniority(atributos.getAll().get(7));
		recurso4.setHobbie1(hob1);
		recurso4.setHobbie2(hob2);
		recurso4.setHobbie3(hob3);
		recurso4.setHobbie4(hob4);
		recurso4.setIdioma1(idiomaI);
		recurso4.setIdioma2(idiomaP);
		recurso4.setIdioma3(idiomaF);
		recurso4.setNivelIdioma1(nivel1);
		recurso4.setNivelIdioma2(nivel2);
		recurso4.setNivelIdioma3(nivel1);
		recurso4.setInstitucion(inst1);

		recursos.add(recurso1);
		recursos.add(recurso2);
		recursos.add(recurso3);
		recursos.add(recurso4);

		// Grupos de Recursos
		GrupoRecursos grupo = new GrupoRecursos();
		grupo.setDescripcion("Grupo de Recursos de DEV");
		grupo.getRecursos().add(recurso1);
		grupo.getRecursos().add(recurso2);
		grupo.getRecursos().add(recurso3);
		grupo.getRecursos().add(recurso4);

		gruposRecursos.add(grupo);

		List<Atributo> atributos = datosMaestros.getAll().get(1).getAtributos();
		recurso1.setAtributo(atributos.get(0));
		recurso2.setAtributo(atributos.get(0));
		recurso3.setAtributo(atributos.get(1));
		recurso4.setAtributo(atributos.get(1));

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
		pregunta1
				.setDescripcion("Quien tiene mas conocimientos en usabilidad?");

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
	}

	private void crearRedDePrueba2() {
		Usuario usuario1 = new Usuario("r13@hotmail.com", "", "RECURSO",
				"Pepe", "Lopez");
		Usuario usuario2 = new Usuario("r14@hotmail.com", "", "RECURSO",
				"Nestor", "Ticolis");
		Usuario usuario3 = new Usuario("r15@hotmail.com", "", "RECURSO",
				"Juan", "Candado");
		Usuario usuario4 = new Usuario("r16@hotmail.com", "", "RECURSO",
				"Ariel", "Ortega");
		Usuario usuario5 = new Usuario("r17@hotmail.com", "", "RECURSO",
				"Hector", "Alterio");
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		usuarios.add(usuario4);
		usuarios.add(usuario5);

		Recurso recurso1 = new Recurso(usuario1);
		Recurso recurso2 = new Recurso(usuario2);
		Recurso recurso3 = new Recurso(usuario3);
		Recurso recurso4 = new Recurso(usuario4);
		Recurso recurso5 = new Recurso(usuario5);
		recursos.add(recurso1);
		recursos.add(recurso2);
		recursos.add(recurso3);
		recursos.add(recurso4);
		recursos.add(recurso5);

		Nodo nodo1 = new Nodo(recurso1);
		Nodo nodo2 = new Nodo(recurso2);
		Nodo nodo3 = new Nodo(recurso3);
		Nodo nodo4 = new Nodo(recurso4);
		Nodo nodo5 = new Nodo(recurso5);
		nodos.add(nodo1);
		nodos.add(nodo2);
		nodos.add(nodo3);
		nodos.add(nodo4);
		nodos.add(nodo5);

		Pregunta pregunta1 = new Pregunta();
		preguntasRepository.add(pregunta1);
		pregunta1.setDescripcion("pto de vista 2");

		PuntoDeVista puntoDeVista1 = new PuntoDeVista();
		puntosDeVista.add(puntoDeVista1);
		puntoDeVista1.setPregunta(pregunta1);
		puntoDeVista1.setDescripcion(pregunta1.getDescripcion());
		puntoDeVista1.getNodos().add(nodo1);
		puntoDeVista1.getNodos().add(nodo2);
		puntoDeVista1.getNodos().add(nodo3);
		puntoDeVista1.getNodos().add(nodo4);
		puntoDeVista1.getNodos().add(nodo5);

		Red red1 = redes.getAll().get(0);
		redes.add(red1);

		red1.getPuntosDeVista().add(puntoDeVista1);

		// creo un grafo
		Relacion relacion1 = nodo2.linkTo(nodo1, 3);
		relaciones.add(relacion1);

		// dejo el nodo 3 desconectado

		// creo otro grafo desconectado del anterior
		Relacion relacion2 = nodo4.linkTo(nodo5, 3);
		relaciones.add(relacion2);
	}

	private void crearRedDePrueba3() {
		Usuario usuario1 = new Usuario("r9@hotmail.com", "", "RECURSO", "Pepe",
				"Lopez");
		Usuario usuario2 = new Usuario("r10@hotmail.com", "", "RECURSO",
				"Nestor", "Ticolis");
		Usuario usuario3 = new Usuario("r11hotmail.com", "", "RECURSO", "Juan",
				"Candado");
		Usuario usuario4 = new Usuario("r12@hotmail.com", "", "RECURSO",
				"Ariel", "Ortega");
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		usuarios.add(usuario4);

		Recurso recurso1 = new Recurso(usuario1);
		Recurso recurso2 = new Recurso(usuario2);
		Recurso recurso3 = new Recurso(usuario3);
		Recurso recurso4 = new Recurso(usuario4);
		recursos.add(recurso1);
		recursos.add(recurso2);
		recursos.add(recurso3);
		recursos.add(recurso4);

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
		pregunta1.setDescripcion("pto de vista 1");

		PuntoDeVista puntoDeVista1 = new PuntoDeVista();
		puntosDeVista.add(puntoDeVista1);
		puntoDeVista1.setPregunta(pregunta1);
		puntoDeVista1.setDescripcion(pregunta1.getDescripcion());
		puntoDeVista1.getNodos().add(nodo1);
		puntoDeVista1.getNodos().add(nodo2);
		puntoDeVista1.getNodos().add(nodo3);
		puntoDeVista1.getNodos().add(nodo4);

		Red red1 = new Red();
		red1.setDescripcion("Red de Prueba2");
		redes.add(red1);

		red1.getPuntosDeVista().add(puntoDeVista1);

		// creo un grafo con dos relaciones entre nodo2 y nodo1
		Relacion relacion1 = nodo2.linkTo(nodo1, 3);
		Relacion relacion2 = nodo2.linkTo(nodo3, 3);
		Relacion relacion3 = nodo2.linkTo(nodo4, 3);
		Relacion relacion4 = nodo1.linkTo(nodo2, 3);
		relaciones.add(relacion1);
		relaciones.add(relacion2);
		relaciones.add(relacion3);
		relaciones.add(relacion4);
	}

	private void crearRedDePrueba4() {
		Usuario usuario1 = new Usuario("r5@hotmail.com", "", "RECURSO", "Pepe",
				"Lopez");
		Usuario usuario2 = new Usuario("r6@hotmail.com", "", "RECURSO",
				"Nestor", "Ticolis");
		Usuario usuario3 = new Usuario("r7@hotmail.com", "", "RECURSO", "Juan",
				"Candado");
		Usuario usuario4 = new Usuario("r8@hotmail.com", "", "RECURSO",
				"Ariel", "Ortega");
		Usuario usuario5 = new Usuario("r9@hotmail.com", "", "RECURSO",
				"Anibal", "Ibarra");
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		usuarios.add(usuario4);
		usuarios.add(usuario5);

		Recurso recurso1 = new Recurso(usuario1);
		Recurso recurso2 = new Recurso(usuario2);
		Recurso recurso3 = new Recurso(usuario3);
		Recurso recurso4 = new Recurso(usuario4);
		Recurso recurso5 = new Recurso(usuario5);
		recursos.add(recurso1);
		recursos.add(recurso2);
		recursos.add(recurso3);
		recursos.add(recurso4);
		recursos.add(recurso5);

		Nodo nodo1 = new Nodo(recurso1);
		Nodo nodo2 = new Nodo(recurso2);
		Nodo nodo3 = new Nodo(recurso3);
		Nodo nodo4 = new Nodo(recurso4);
		Nodo nodo5 = new Nodo(recurso5);
		nodos.add(nodo1);
		nodos.add(nodo2);
		nodos.add(nodo3);
		nodos.add(nodo4);
		nodos.add(nodo5);

		Pregunta pregunta1 = new Pregunta();
		preguntasRepository.add(pregunta1);
		pregunta1.setDescripcion("Quien tiene mas conocimientos en testing?");

		PuntoDeVista puntoDeVista1 = new PuntoDeVista();
		puntosDeVista.add(puntoDeVista1);
		puntoDeVista1.setPregunta(pregunta1);
		puntoDeVista1.setDescripcion(pregunta1.getDescripcion());
		puntoDeVista1.getNodos().add(nodo1);
		puntoDeVista1.getNodos().add(nodo2);
		puntoDeVista1.getNodos().add(nodo3);
		puntoDeVista1.getNodos().add(nodo4);
		puntoDeVista1.getNodos().add(nodo5);

		Red red1 = redes.getAll().get(1);
		redes.add(red1);

		red1.getPuntosDeVista().add(puntoDeVista1);

		// creo un grafo en forma de estrella
		Relacion relacion1 = nodo2.linkTo(nodo1, 3);
		Relacion relacion2 = nodo2.linkTo(nodo3, 3);
		Relacion relacion3 = nodo2.linkTo(nodo4, 3);
		Relacion relacion4 = nodo3.linkTo(nodo5, 3);
		relaciones.add(relacion1);
		relaciones.add(relacion2);
		relaciones.add(relacion3);
		relaciones.add(relacion4);
	}

	private void crearDatosMaestros() {
		// ACA ESTABA todo LO DE DATOS MAESTROS
	}

	public void setRedes(RedesRepository redes) {
		this.redes = redes;
	}

	public RedesRepository getRedes() {
		return redes;
	}

	public void setPuntosDeVista(PuntosDeVistaRepository puntosDeVista) {
		this.puntosDeVista = puntosDeVista;
	}

	public PuntosDeVistaRepository getPuntosDeVista() {
		return puntosDeVista;
	}

	public void setRecursos(RecursosRepository recursos) {
		this.recursos = recursos;
	}

	public RecursosRepository getRecursos() {
		return recursos;
	}

	public void setRelaciones(RelacionesRepository relaciones) {
		this.relaciones = relaciones;
	}

	public RelacionesRepository getRelaciones() {
		return relaciones;
	}

	public void setUsuarios(UsuariosRepository usuarios) {
		this.usuarios = usuarios;
	}

	public UsuariosRepository getUsuarios() {
		return usuarios;
	}

	public void setNodos(NodosRepository nodos) {
		this.nodos = nodos;
	}

	public NodosRepository getNodos() {
		return nodos;
	}

	public void setPreguntasRepository(PreguntasRepository preguntasRepository) {
		this.preguntasRepository = preguntasRepository;
	}

	public PreguntasRepository getPreguntasRepository() {
		return preguntasRepository;
	}
}
