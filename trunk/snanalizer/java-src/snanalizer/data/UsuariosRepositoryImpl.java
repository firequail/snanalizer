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
	
	public void removeAllRecursos() {
		Criteria criteria = createCriteria();
		
		criteria.add( Restrictions.eq("rol", "RECURSO"));
		
		List<Usuario> usuariosRecurso = find(criteria);
		
		for (Usuario usuario : usuariosRecurso) {
			remove(usuario);
		}
	}
}
