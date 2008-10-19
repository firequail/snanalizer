package snanalizer.services;

import java.util.List;

import snanalizer.domain.DatoMaestro;
import snanalizer.domain.Filtro;
import snanalizer.domain.Nodo;
import snanalizer.domain.PuntoDeVista;
import snanalizer.domain.Recurso;
import snanalizer.domain.Red;

public interface RedesService {

	public List<PuntoDeVista> getPuntosDeVista(int redId);
	
	public List<Red> getRedes();
	
	public Nodo getNodo(int id);

	public String getGrafo(Integer idPtoVista, Integer idDatoMaestro, Filtro filtro);

	public List<DatoMaestro> getDatosMaestros();

	public void crearRed(String nombre, String descripcion, int idGrupo, int idEncuesta);
	
	public List<Recurso> getRecursosOf(int redId);
	
	public void generarRelaciones(int idRed,int idRec,List<Integer> preguntas,List<Integer> intensidades,List<Integer> recursos);
	
	public void enviarEncuesta(List<Recurso> recursos);
}