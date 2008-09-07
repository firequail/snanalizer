package snanalizer.services;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.PuntosDeVistaRepository;
import snanalizer.data.RecursosRepository;
import snanalizer.data.RedesRepository;
import snanalizer.data.RelacionesRepository;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Recurso;
import snanalizer.domain.Red;
import snanalizer.domain.Relacion;

@Transactional
public class TestServiceImpl implements TestService {

	@Resource
	private RedesRepository redes;
	
	@Resource
	private PuntosDeVistaRepository puntosDeVista;
	
	@Resource
	private RecursosRepository recursos;
	
	@Resource
	private RelacionesRepository relaciones;
	
	public String getDate() {
		return new Date().toString();
	}

	public void recrearDB() {
		cleanDB();
		crearRedDePrueba1();
		crearRedDePrueba2();
		crearRedDePrueba3();
		crearRedDePrueba4();
	}

	private void cleanDB() {
		for (Red red : redes.getAll()) {
			redes.remove(red);
		}
		for (PuntoDeVista puntoDeVista: puntosDeVista.getAll()) {
			puntosDeVista.remove(puntoDeVista);
		}
		for (Relacion relacion: relaciones.getAll()) {
			relaciones.remove(relacion);
		}
		for (Recurso recurso: recursos.getAll()) {
			recursos.remove(recurso);
		}
	}

	private void crearRedDePrueba1() {
		PuntoDeVista puntoDeVista1 = new PuntoDeVista();
		puntoDeVista1.setDescripcion("Quien la tiene clara con usabilidad?");
		puntosDeVista.add(puntoDeVista1);

		Red red1 = new Red();
		red1.setDescripcion("Red de Prueba");
		puntoDeVista1.setRed(red1);
		redes.add(red1);

		Recurso recurso1 = new Recurso();
		Recurso recurso2 = new Recurso();
		Recurso recurso3 = new Recurso();
		Recurso recurso4 = new Recurso();
		recursos.add(recurso1);
		recursos.add(recurso2);
		recursos.add(recurso3);
		recursos.add(recurso4);

		// creo un grafo en forma de estrella
		relaciones.add(new Relacion(recurso1, recurso2, 3, puntoDeVista1));
		relaciones.add(new Relacion(recurso1, recurso3, 3, puntoDeVista1));
		relaciones.add(new Relacion(recurso1, recurso4, 3, puntoDeVista1));
	}

	private void crearRedDePrueba2() {
		PuntoDeVista puntoDeVista2 = new PuntoDeVista();
		puntoDeVista2.setDescripcion("Quien la tiene clara con testing?");
		puntosDeVista.add(puntoDeVista2);

		Red red1 = redes.getAll().get(0);
		puntoDeVista2.setRed(red1);
		redes.add(red1);

		Recurso recurso5 = new Recurso();
		Recurso recurso6 = new Recurso();
		Recurso recurso7 = new Recurso();
		Recurso recurso8 = new Recurso();
		recursos.add(recurso5);
		recursos.add(recurso6);
		recursos.add(recurso7);
		recursos.add(recurso8);

		// creo un grafo en forma de estrella
		relaciones.add(new Relacion(recurso6, recurso5, 3, puntoDeVista2));
		relaciones.add(new Relacion(recurso6, recurso7, 3, puntoDeVista2));
		relaciones.add(new Relacion(recurso6, recurso8, 3, puntoDeVista2));
	}
	
	private void crearRedDePrueba3() {
		PuntoDeVista puntoDeVista1 = new PuntoDeVista();
		puntoDeVista1.setDescripcion("pto de vista 1");
		puntosDeVista.add(puntoDeVista1);

		Red red1 = new Red();
		red1.setDescripcion("Red de Prueba2");
		puntoDeVista1.setRed(red1);
		redes.add(red1);

		Recurso recurso9 = new Recurso();
		Recurso recurso10 = new Recurso();
		Recurso recurso11 = new Recurso();
		Recurso recurso12 = new Recurso();
		recursos.add(recurso9);
		recursos.add(recurso10);
		recursos.add(recurso11);
		recursos.add(recurso12);

		// creo un grafo en forma de estrella
		relaciones.add(new Relacion(recurso9, recurso10, 3, puntoDeVista1));
		relaciones.add(new Relacion(recurso9, recurso11, 3, puntoDeVista1));
		relaciones.add(new Relacion(recurso9, recurso12, 3, puntoDeVista1));
	}

	private void crearRedDePrueba4() {
		PuntoDeVista puntoDeVista2 = new PuntoDeVista();
		puntoDeVista2.setDescripcion("pto de vista 2");
		puntosDeVista.add(puntoDeVista2);

		Red red1 = redes.getAll().get(1);
		puntoDeVista2.setRed(red1);
		redes.add(red1);

		Recurso recurso13 = new Recurso();
		Recurso recurso14 = new Recurso();
		Recurso recurso15 = new Recurso();
		Recurso recurso16 = new Recurso();
		recursos.add(recurso13);
		recursos.add(recurso14);
		recursos.add(recurso15);
		recursos.add(recurso16);

		// creo un grafo en forma de estrella
		relaciones.add(new Relacion(recurso14, recurso13, 3, puntoDeVista2));
		relaciones.add(new Relacion(recurso14, recurso15, 3, puntoDeVista2));
		relaciones.add(new Relacion(recurso14, recurso16, 3, puntoDeVista2));
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
}
