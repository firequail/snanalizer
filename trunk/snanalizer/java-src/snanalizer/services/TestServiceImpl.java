package snanalizer.services;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Recurso;
import snanalizer.domain.Red;
import snanalizer.domain.Relacion;

@Transactional
public class TestServiceImpl implements TestService {

	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public String getDate() {
		return new Date().toString();
	}

	private void save(Object entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public void test() {
		crearRedDePrueba();
	}
	
	private void crearRedDePrueba() {
		PuntoDeVista puntoDeVista1 = new PuntoDeVista();
		puntoDeVista1.setDescripcion("Quien la tiene clara con usabilidad?");
		save(puntoDeVista1);
		
		Red red1 = new Red();
		red1.setDescripcion("Red de Prueba");
		red1.getPuntosDeVista().add(puntoDeVista1);
		save(red1);

		Recurso recurso1 = new Recurso();
		Recurso recurso2 = new Recurso();
		Recurso recurso3 = new Recurso();
		Recurso recurso4 = new Recurso();
		save(recurso1);
		save(recurso2);
		save(recurso3);
		save(recurso4);

		// creo un grafo en forma de estrella
		save(new Relacion(recurso1, recurso2, 3, puntoDeVista1));
		save(new Relacion(recurso1, recurso3, 3, puntoDeVista1));
		save(new Relacion(recurso1, recurso4, 3, puntoDeVista1));
	}
}
