package snanalizer.services;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.DatosMaestrosRepository;
import snanalizer.data.AtributosRepository;
import snanalizer.domain.DatoMaestro;
import snanalizer.domain.Atributo;



@Transactional
public class DatosMaestrosServiceImpl implements DatosMaestrosService {
	
	@Resource
	private DatosMaestrosRepository datosMaestros;
	@Resource
	public AtributosRepository atributos;
	
	public List<DatoMaestro> getAll() {
		return datosMaestros.getAll();
	}
	
	public AtributosRepository getAtributos() {
		return atributos;
	}
	
	public List<Atributo> getAtributos(int datoMaestroId) {
		DatoMaestro dm = datosMaestros.getById(datoMaestroId);
		return atributos.getAtributos(dm);
	}
	
	public List<Atributo> getAtributos(String desc) {
		DatoMaestro dm = datosMaestros.getDatoMaestro(desc);
		return this.getAtributos(dm.getId());
	}

}
