package snanalizer.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.Recurso;
import snanalizer.domain.Usuario;

public class RecursosRepositoryImpl extends BaseRepositoryImpl<Recurso>
		implements RecursosRepository {

	public List<Recurso> buscarRecursoByName(List<Usuario> usuarios) {
		if (!usuarios.isEmpty()) {
			Criteria criteria = createCriteria();
			criteria.add(Restrictions.eq("usuario", usuarios.get(0)));
			// criteria.add(Restrictions.eq("estado",true));
			return find(criteria);
		}
		return new ArrayList<Recurso>(0);
	}

	public List<Recurso> buscarRecursoByName(String nombre, String apellido) {
		Criteria criteria = createCriteria();
		criteria.createAlias("usuario", "usuario");
		criteria.add(Restrictions.like("usuario.nombre", "%" + nombre + "%"));
		criteria.add(Restrictions.like("usuario.apellido", "%" + apellido + "%"));
		// criteria.add(Restrictions.eq("estado",true));
		return find(criteria);
	}
	
	public Recurso getByUsuario(Usuario usuario) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("usuario", usuario));
		return findUnique(criteria);
	}
}
