package es.iespuertodelacruz.rl.dao;

import java.util.List;

//T-> Objeto
//E->
public interface CRUD<T, E> {
	T findbyID(E id);
	List<T> findAll();
	T save(T obj);
	boolean update(T obj);//para que devuelva si se ha modificado o no
	boolean delete(E id);
}
