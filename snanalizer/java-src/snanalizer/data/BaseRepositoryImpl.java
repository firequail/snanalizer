package snanalizer.data;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import snanalizer.domain.DomainEntity;

public class BaseRepositoryImpl<E extends DomainEntity> implements
		BaseRepository<E> {

	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<E> getAll() {
		return createCriteria().list();
	}

	@SuppressWarnings("unchecked")
	public E getById(Integer id) {
		return (E) createCriteria().add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<E> getById(List<Integer> ids) {
		return createCriteria().add(Restrictions.in("id", ids)).list();
	}

	public void add(E newEntity) {
		this.sessionFactory.getCurrentSession().save(newEntity);
	}

	public void remove(Integer id) {
		E e = getById(id);
		this.sessionFactory.getCurrentSession().delete(e);
	}

	public void remove(E entity) {
		this.sessionFactory.getCurrentSession().delete(entity);
	}

	public void removeAll() {
		for (E entity : getAll()) {
			remove(entity);
		}
	}

	protected Criteria createCriteria() {
		return this.sessionFactory.getCurrentSession()
				.createCriteria(getType());
	}

	@SuppressWarnings("unchecked")
	protected List<E> find(Criteria criteria) {
		return (List<E>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	protected E findUnique(Criteria criteria) {
		return (E) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	private Class<E> getType() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Type type = actualTypeArguments[0];
		return (Class<E>) type;
	}
}
