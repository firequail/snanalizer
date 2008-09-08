package snanalizer.services;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.DatosMaestrosRepository;
import snanalizer.domain.DatoMaestro;


@Transactional
public class DatosMaestrosServiceImpl implements DatosMaestrosService {
	
	@Resource
	private DatosMaestrosRepository datosMaestros;
	
	public List<DatoMaestro> getAll() {
		return datosMaestros.getAll();
	}
	

}
