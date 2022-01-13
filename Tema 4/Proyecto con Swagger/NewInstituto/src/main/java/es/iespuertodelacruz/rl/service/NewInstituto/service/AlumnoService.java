package es.iespuertodelacruz.rl.service.NewInstituto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.rl.NewInstituto.entities.Alumno;
import es.iespuertodelacruz.rl.repository.NewInstituto.repository.AlumnoRepository;

@Component
public class AlumnoService implements GenericService<Alumno, String>{
	
		@Autowired
		private AlumnoRepository alumnorepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Alumno> findAll() {
		
		return alumnorepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Alumno> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return alumnorepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Alumno> findById(String id) {
		// TODO Auto-generated method stub
		return alumnorepository.findById(id);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		alumnorepository.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Alumno entity) {
		// TODO Auto-generated method stub
		alumnorepository.delete(entity);
	}

	@Override
	@Transactional
	public Alumno save(Alumno obj) {
		// TODO Auto-generated method stub
		return alumnorepository.save(obj);
	}

	

	
	
	
}
