package snanalizer.data;

import java.util.List;

import snanalizer.domain.DomainEntity;

public interface BaseRepository<E extends DomainEntity> {

	public List<E> getAll();

	public E getById(Integer id);
	
	public List<E> getById(List<Integer> ids);

	public void add(E newEntity);

	public void remove(Integer id);
	
	public void remove(E entity);
	
	public void removeAll();
}