package snanalizer.data;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.Usuario;

public class UsuarioRepositoryImpl extends BaseRepositoryImpl<Usuario> implements
		UsuarioRepository {

	public Usuario getUsuario(String email, String password) {

		Criteria criteria = createCriteria();

		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));

		return findUnique(criteria);
	}
}
