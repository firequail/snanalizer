package snanalizer.data;

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
}
