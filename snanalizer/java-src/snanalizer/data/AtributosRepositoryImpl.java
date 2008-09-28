package snanalizer.data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.Atributo;
import snanalizer.domain.DatoMaestro;
import snanalizer.domain.Usuario;


public class AtributosRepositoryImpl extends BaseRepositoryImpl<Atributo> implements
		AtributosRepository {


	public Atributo getAtributo(int id) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("id",id));
		return findUnique(criteria);
	
	}
	
	/*
		public Usuario getUsuario(String email, String password) {

		Criteria criteria = createCriteria();

		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));

		return findUnique(criteria);
	} 
	
	 */
	
	public List<Atributo> getAtributos(DatoMaestro dm) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("datoMaestro", dm));

		return find(criteria);
	}
	
	
}