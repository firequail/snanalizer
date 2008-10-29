package snanalizer.test;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import snanalizer.domain.Recurso;
import snanalizer.domain.Relacion;
import snanalizer.services.DatosMaestrosService;
import snanalizer.services.RecursosService;
import snanalizer.services.RedesService;

public class RedesServiceTest extends TestCase {

	private ApplicationContext context;
	private RedesService redesService;
	private DatosMaestrosService datosMaestrosService;
	private RecursosService recursosService;

	/**
	 * Esto se ejecuta antes de cada test
	 */
	protected void setUp() {
		context = new ClassPathXmlApplicationContext(
				"snanalizer/applicationContext.xml");
		redesService = (RedesService) context.getBean("redesService");
		datosMaestrosService = (DatosMaestrosService) context
				.getBean("datosMaestrosService");
		recursosService = (RecursosService) context.getBean("recursosService");
	}

	/**
	 * Esto se ejecuta despues de cada test
	 */
	protected void tearDown() {

	}

	public void xtestGetGrafo() {
		Integer idPtoVista = redesService.getRedes().get(1).getPuntosDeVista()
				.get(1).getId();
		String grafo = redesService.getGrafo(idPtoVista, null, null);

		System.out.println(grafo);
		assertNotNull(grafo);
	}

	public void xtestGetGrafo_agrupado() {
		Integer idPtoVista = redesService.getRedes().get(0).getPuntosDeVista()
				.get(0).getId();
		Integer idDatoMaestro = datosMaestrosService.getAll().get(1).getId();
		String grafo = redesService.getGrafo(idPtoVista, idDatoMaestro, null);

		System.out.println(grafo);
		assertNotNull(grafo);
	}

	public void xtestBusquedaRecursos() {
		List<Recurso> recursos = recursosService.buscarRecursoByName("pepe",
				"lopez");

		System.out.println(recursos);
	}

	public void xtestMail() {
		List<Recurso> recursos = recursosService.buscarRecursoByName("pepe",
				"lopez");
		redesService.enviarEncuesta(recursos);
	}

	public void xtestCaminoMasCorto() {
		int idDestino = 4;
		int idOrigen = 3;
		List<Relacion> caminoMasCorto = redesService.getCaminoMasCorto(
				idOrigen, idDestino);
		System.out.println(caminoMasCorto);
	}
}
