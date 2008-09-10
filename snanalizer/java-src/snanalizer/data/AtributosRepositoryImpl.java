package snanalizer.data;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.Atributo;

public class AtributosRepositoryImpl extends BaseRepositoryImpl<Atributo> implements
		AtributosRepository {

	public Atributo getAtributo(String nombre) {

		Criteria criteria = createCriteria();

		criteria.add(Restrictions.eq("nombre", nombre));
		
		return findUnique(criteria);
	}
}