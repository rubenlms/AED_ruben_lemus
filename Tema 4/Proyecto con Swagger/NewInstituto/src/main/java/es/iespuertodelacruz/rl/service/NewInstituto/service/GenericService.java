package es.iespuertodelacruz.rl.service.NewInstituto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.iespuertodelacruz.rl.NewInstituto.entities.Alumno;
import es.iespuertodelacruz.rl.NewInstituto.entities.Asignatura;
import es.iespuertodelacruz.rl.NewInstituto.entities.Matricula;

@Service
public interface GenericService<T,E> {
	Iterable<T> findAll();
	Page<T> findAll(Pageable pageable);
	Optional<T> findById(E id);
	T save(T obj);
	void deleteById(E id);
	void delete(T entity);
}
