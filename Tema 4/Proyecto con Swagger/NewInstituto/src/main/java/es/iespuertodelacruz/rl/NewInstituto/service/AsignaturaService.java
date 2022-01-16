package es.iespuertodelacruz.rl.NewInstituto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.rl.NewInstituto.entities.Alumno;
import es.iespuertodelacruz.rl.NewInstituto.entities.Asignatura;
import es.iespuertodelacruz.rl.NewInstituto.repository.AsignaturaRepository;

@Component
public class AsignaturaService implements GenericService<Asignatura, Integer> {
	
	@Autowired
	private AsignaturaRepository asignaturarepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Asignatura> findAll() {
		// TODO Auto-generated method stub
		return asignaturarepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Asignatura> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return asignaturarepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Asignatura> findById(Integer id) {
		// TODO Auto-generated method stub
		return asignaturarepository.findById(id);
	}

	@Override
	@Transactional
	public Asignatura save(Asignatura obj) {
		// TODO Auto-generated method stub
		return asignaturarepository.save(obj);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		asignaturarepository.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Asignatura entity) {
		// TODO Auto-generated method stub
		asignaturarepository.delete(entity);
	}

}
