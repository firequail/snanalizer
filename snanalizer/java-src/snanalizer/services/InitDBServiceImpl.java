package snanalizer.services;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.AtributosRepository;
import snanalizer.data.DatosMaestrosRepository;
import snanalizer.data.NodosRepository;
import snanalizer.data.PuntosDeVistaRepository;
import snanalizer.data.RecursosRepository;
import snanalizer.data.RedesRepository;
import snanalizer.data.RelacionesRepository;
import snanalizer.data.UsuariosRepository;
import snanalizer.domain.Atributo;
import snanalizer.domain.DatoMaestro;
import snanalizer.domain.Nodo;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Recurso;
import snanalizer.domain.Red;
import snanalizer.domain.Relacion;
import snanalizer.domain.Usuario;

@Transactional
public class InitDBServiceImpl implements InitDBService {

	@Resource
	private RedesRepository redes;

	@Resource
	private PuntosDeVistaRepository puntosDeVista;

	@Resource
	private RecursosRepository recursos;

	@Resource
	private AtributosRepository atributos;

	@Resource
	private RelacionesRepository relaciones;

	@Resource
	private UsuariosRepository usuarios;

	@Resource
	private NodosRepository nodos;

	@Resource
	private DatosMaestrosRepository datosMaestros;

	public void initDB() {
		//Inicializar la DB para produccion
	}

	public void recrearTestDB() {
		cleanDB();
		crearUsuarios();
		crearRedDePrueba1();
		crearRedDePrueba2();
		crearRedDePrueba3();
		crearRedDePrueba4();
		crearDatosMaestros();
	}

	private void cleanDB() {
		redes.removeAll();
		puntosDeVista.removeAll();
		relaciones.removeAll();
		recursos.removeAll();
		usuarios.removeAll();
		nodos.removeAll();
		datosMaestros.removeAll();
		atributos.removeAll();
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
		Usuario usuario1 = new Usuario("r1@hotmail.com", "", "RECURSO", "Pepe", "Lopez");
		Usuario usuario2 = new Usuario("r2@hotmail.com", "", "RECURSO", "Nestor", "Ticolis");
		Usuario usuario3 = new Usuario("r3@hotmail.com", "", "RECURSO", "Juan", "Candado");
		Usuario usuario4 = new Usuario("r4@hotmail.com", "", "RECURSO", "Ariel", "Ortega");
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

		PuntoDeVista puntoDeVista1 = new PuntoDeVista(
				"Quien la tiene clara con usabilidad?");
		puntosDeVista.add(puntoDeVista1);

		puntoDeVista1.getNodos().add(nodo1);
		puntoDeVista1.getNodos().add(nodo2);
		puntoDeVista1.getNodos().add(nodo3);
		puntoDeVista1.getNodos().add(nodo4);

		Red red1 = new Red();
		red1.setDescripcion("Red de Prueba");
		redes.add(red1);

		red1.getPuntosDeVista().add(puntoDeVista1);

		// creo un grafo en forma de estrella
		Relacion relacion1 = new Relacion(nodo2, nodo1, 3);
		Relacion relacion2 = new Relacion(nodo2, nodo3, 3);
		Relacion relacion3 = new Relacion(nodo2, nodo4, 3);
		relaciones.add(relacion1);
		relaciones.add(relacion2);
		relaciones.add(relacion3);
	}

	private void crearRedDePrueba2() {
		Usuario usuario1 = new Usuario("r13@hotmail.com", "", "RECURSO", "Pepe", "Lopez");
		Usuario usuario2 = new Usuario("r14@hotmail.com", "", "RECURSO", "Nestor", "Ticolis");
		Usuario usuario3 = new Usuario("r15@hotmail.com", "", "RECURSO", "Juan", "Candado");
		Usuario usuario4 = new Usuario("r16@hotmail.com", "", "RECURSO", "Ariel", "Ortega");
		Usuario usuario5 = new Usuario("r17@hotmail.com", "", "RECURSO", "Hector", "Alterio");
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
	
		PuntoDeVista puntoDeVista1 = new PuntoDeVista("pto de vista 2");
		puntosDeVista.add(puntoDeVista1);
	
		puntoDeVista1.getNodos().add(nodo1);
		puntoDeVista1.getNodos().add(nodo2);
		puntoDeVista1.getNodos().add(nodo3);
		puntoDeVista1.getNodos().add(nodo4);
		puntoDeVista1.getNodos().add(nodo5);
	
		Red red1 = redes.getAll().get(0);
		redes.add(red1);
	
		red1.getPuntosDeVista().add(puntoDeVista1);
	
		// creo un grafo
		relaciones.add(new Relacion(nodo2, nodo1, 3));
		relaciones.add(new Relacion(nodo2, nodo3, 3));
	
		// creo otro grafo desconectado del anterior
		relaciones.add(new Relacion(nodo4, nodo5, 3));
	}

	private void crearRedDePrueba3() {
		Usuario usuario1 = new Usuario("r9@hotmail.com", "", "RECURSO", "Pepe", "Lopez");
		Usuario usuario2 = new Usuario("r10@hotmail.com", "", "RECURSO", "Nestor", "Ticolis");
		Usuario usuario3 = new Usuario("r11hotmail.com", "", "RECURSO", "Juan", "Candado");
		Usuario usuario4 = new Usuario("r12@hotmail.com", "", "RECURSO", "Ariel", "Ortega");
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
	
		PuntoDeVista puntoDeVista1 = new PuntoDeVista("pto de vista 1");
		puntosDeVista.add(puntoDeVista1);
	
		puntoDeVista1.getNodos().add(nodo1);
		puntoDeVista1.getNodos().add(nodo2);
		puntoDeVista1.getNodos().add(nodo3);
		puntoDeVista1.getNodos().add(nodo4);
	
		Red red1 = new Red();
		red1.setDescripcion("Red de Prueba2");
		redes.add(red1);
	
		red1.getPuntosDeVista().add(puntoDeVista1);
	
		// creo un grafo con dos relaciones entre nodo2 y nodo1
		relaciones.add(new Relacion(nodo2, nodo1, 3));
		relaciones.add(new Relacion(nodo2, nodo3, 3));
		relaciones.add(new Relacion(nodo2, nodo4, 3));
		relaciones.add(new Relacion(nodo1, nodo2, 3));
	}

	private void crearRedDePrueba4() {
		Usuario usuario1 = new Usuario("r5@hotmail.com", "", "RECURSO", "Pepe", "Lopez");
		Usuario usuario2 = new Usuario("r6@hotmail.com", "", "RECURSO", "Nestor", "Ticolis");
		Usuario usuario3 = new Usuario("r7@hotmail.com", "", "RECURSO", "Juan", "Candado");
		Usuario usuario4 = new Usuario("r8@hotmail.com", "", "RECURSO", "Ariel", "Ortega");
		Usuario usuario5 = new Usuario("r9@hotmail.com", "", "RECURSO", "Anibal", "Ibarra");
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

		PuntoDeVista puntoDeVista1 = new PuntoDeVista(
				"Quien la tiene clara con testing?");
		puntosDeVista.add(puntoDeVista1);

		puntoDeVista1.getNodos().add(nodo1);
		puntoDeVista1.getNodos().add(nodo2);
		puntoDeVista1.getNodos().add(nodo3);
		puntoDeVista1.getNodos().add(nodo4);
		puntoDeVista1.getNodos().add(nodo5);

		Red red1 = redes.getAll().get(1);
		redes.add(red1);

		red1.getPuntosDeVista().add(puntoDeVista1);

		// creo un grafo en forma de estrella
		relaciones.add(new Relacion(nodo2, nodo1, 3));
		relaciones.add(new Relacion(nodo2, nodo3, 3));
		relaciones.add(new Relacion(nodo2, nodo4, 3));
		relaciones.add(new Relacion(nodo3, nodo5, 3));
	}

	private void crearDatosMaestros() {
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

		atr1_dm1.setNombre("DEV");
		atr2_dm1.setNombre("RRHH");
		atr3_dm1.setNombre("Finances");
		atr1_dm2.setNombre("FA");
		atr2_dm2.setNombre("DEV");
		atr3_dm2.setNombre("QC");
		atr1_dm3.setNombre("Junior");
		atr2_dm3.setNombre("Semisenior");
		atr3_dm3.setNombre("Senior");

		atributos.add(atr1_dm1);
		atributos.add(atr2_dm1);
		atributos.add(atr3_dm1);
		atributos.add(atr1_dm2);
		atributos.add(atr2_dm2);
		atributos.add(atr3_dm2);
		atributos.add(atr1_dm3);
		atributos.add(atr2_dm3);
		atributos.add(atr3_dm3);

		atr1_dm1.setDatoMaestro(dm1);
		atr2_dm1.setDatoMaestro(dm1);
		atr3_dm1.setDatoMaestro(dm1);
		atr1_dm2.setDatoMaestro(dm2);
		atr2_dm2.setDatoMaestro(dm2);
		atr3_dm2.setDatoMaestro(dm2);
		atr1_dm3.setDatoMaestro(dm3);
		atr2_dm3.setDatoMaestro(dm3);
		atr3_dm3.setDatoMaestro(dm3);

		dm1.setDescripcion("Area");
		dm2.setDescripcion("Puesto");
		dm3.setDescripcion("Seniority");

		datosMaestros.add(dm1);
		datosMaestros.add(dm2);
		datosMaestros.add(dm3);
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
}
