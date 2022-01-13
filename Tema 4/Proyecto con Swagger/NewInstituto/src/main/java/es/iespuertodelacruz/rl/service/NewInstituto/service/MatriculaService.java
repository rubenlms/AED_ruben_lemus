package es.iespuertodelacruz.rl.service.NewInstituto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.rl.NewInstituto.entities.Matricula;
import es.iespuertodelacruz.rl.repository.NewInstituto.repository.MatriculaRepository;

@Component
public class MatriculaService implements GenericService<Matricula, Integer> {
	
	@Autowired
	private MatriculaRepository matricularepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Matricula> findAll() {
		// TODO Auto-generated method stub
		return matricularepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Matricula> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return matricularepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Matricula> findById(Integer id) {
		// TODO Auto-generated method stub
		return matricularepository.findById(id);
	}

	@Override
	@Transactional
	public Matricula save(Matricula obj) {
		// TODO Auto-generated method stub
		return matricularepository.save(obj);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		matricularepository.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Matricula entity) {
		// TODO Auto-generated method stub
		matricularepository.delete(entity);
	}

}
