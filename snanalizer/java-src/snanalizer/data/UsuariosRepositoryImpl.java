package snanalizer.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.Usuario;

public class UsuariosRepositoryImpl extends BaseRepositoryImpl<Usuario> implements
		UsuariosRepository {

	public Usuario getUsuario(String email, String password) {

		Criteria criteria = createCriteria();

		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));

		return findUnique(criteria);
	}
	
	public List<Usuario> getUsuarioByName(String name, String apellido) {

		Criteria criteria = createCriteria();
		//if(name!=null)
			criteria.add(Restrictions.eq("nombre",name));
		//if(apellido!=null)
			criteria.add(Restrictions.eq("apellido", apellido));

		return find(criteria);
	}
	
	public void removeAllRecursos() {
		Criteria criteria = createCriteria();
		
		criteria.add( Restrictions.eq("rol", "RECURSO"));
		
		List<Usuario> usuariosRecurso = find(criteria);
		
		for (Usuario usuario : usuariosRecurso) {
			remove(usuario);
		}
	}

	public List<Usuario> getNoRecursos() {
		Criteria criteria = createCriteria();
		
		criteria.add(Restrictions.ne("rol", "RECURSO"));
		
		return find(criteria);
	}
	
	public Usuario getByEmail(String email) {
		Criteria criteria = createCriteria();
		
		criteria.add(Restrictions.eq("email", email));
		
		return findUnique(criteria);
	}
}
