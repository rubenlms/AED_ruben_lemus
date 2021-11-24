package es.iespuertodelacruz.rl.dao;

import java.util.List;

public interface CRUD<T, E> {
	
	T findbyID(E id);
	List<T> findAll();
	T save(T obj);
	boolean update(T obj);
	boolean delete(E id);
}
