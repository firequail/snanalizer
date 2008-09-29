package snanalizer.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


import snanalizer.domain.Recurso;
import snanalizer.domain.Usuario;

public class RecursosRepositoryImpl extends BaseRepositoryImpl<Recurso> implements RecursosRepository {
	
	public List<Recurso> buscarRecursoByName(Usuario user) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("usuario",user));
		//criteria.add(Restrictions.eq("estado",true));
		return find(criteria);
	}

}
