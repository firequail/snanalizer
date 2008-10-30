package snanalizer.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.AtributosRepository;
import snanalizer.data.DatosMaestrosRepository;
import snanalizer.domain.Atributo;
import snanalizer.domain.DatoMaestro;



@Transactional
public class DatosMaestrosServiceImpl implements DatosMaestrosService {
	
	@Resource
	private DatosMaestrosRepository datosMaestros;
	@Resource
	public AtributosRepository atributosRepo;
	
	public List<DatoMaestro> getAll() {
		return datosMaestros.getAll();
	}
	
	public AtributosRepository getAtributos() {
		return atributosRepo;
	}
	
	public List<Atributo> getAtributos(int datoMaestroId) {
		DatoMaestro dm = datosMaestros.getById(datoMaestroId);
		return atributosRepo.getAtributos(dm);
	}
	
	public List<Atributo> getAtributosByDesc(String desc) {
		DatoMaestro dm = datosMaestros.getDatoMaestro(desc);
		return atributosRepo.getAtributos(dm);
	}
	
	public List<Atributo> getAreas() { return this.getAtributosByDesc("Area"); }
	public List<Atributo> getPuestos() { return this.getAtributosByDesc("Puesto"); }
	public List<Atributo> getSeniorities() { return this.getAtributosByDesc("Seniority"); }
	public List<Atributo> getHobbies() {  return this.getAtributosByDesc("Hobby"); }
	public List<Atributo> getInstituciones() {return this.getAtributosByDesc("Institución"); }
	public List<Atributo> getNiveles() {return this.getAtributosByDesc("Nivel"); }
	public List<Atributo> getIdiomas() {return this.getAtributosByDesc("Idioma"); }
	public List<Atributo> getProvincias() {return this.getAtributosByDesc("Provincia"); }
	public List<Atributo> getEstadosCiviles() {return this.getAtributosByDesc("Estado Civil"); }
}
