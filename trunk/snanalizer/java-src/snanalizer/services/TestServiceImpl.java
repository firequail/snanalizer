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
		crearRedDePrueba();
		crearRedDePrueba2();
	}

	private void crearRedDePrueba() {
		PuntoDeVista puntoDeVista1 = new PuntoDeVista();
		puntoDeVista1.setDescripcion("Quien la tiene clara con usabilidad?");
		puntosDeVista.add(puntoDeVista1);

		Red red1 = new Red();
		red1.setDescripcion("Red de Prueba");
		red1.getPuntosDeVista().add(puntoDeVista1);
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
		red1.getPuntosDeVista().add(puntoDeVista2);
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
