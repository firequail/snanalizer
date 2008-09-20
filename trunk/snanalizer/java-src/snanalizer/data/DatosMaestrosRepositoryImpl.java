package snanalizer.data;


import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.DatoMaestro;

public class DatosMaestrosRepositoryImpl extends BaseRepositoryImpl<DatoMaestro> 
	implements DatosMaestrosRepository {
	
	
	public DatoMaestro getDatoMaestro(String desc) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("descripcion", desc));
		return findUnique(criteria);
	}

}
