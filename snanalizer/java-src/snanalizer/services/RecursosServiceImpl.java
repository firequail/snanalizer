package snanalizer.services;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.RecursosRepository;
import snanalizer.domain.Recurso;

public class RecursosServiceImpl implements RecursosService {

	@Resource
	private RecursosRepository recursos;
	
	public List<Recurso> getAll() {
		return recursos.getAll();
	}
	
}
