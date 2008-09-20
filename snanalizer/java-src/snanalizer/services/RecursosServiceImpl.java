package snanalizer.services;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import snanalizer.data.RecursosRepository;
import snanalizer.data.UsuariosRepository;
import snanalizer.domain.Recurso;
import snanalizer.domain.Usuario;

@Transactional
public class RecursosServiceImpl implements RecursosService {

	@Resource
	private RecursosRepository recursos;
	@Resource
	private UsuariosRepository usuarios;
	
	public List<Recurso> getAll() {
		return recursos.getAll();
	}
	

	
}
