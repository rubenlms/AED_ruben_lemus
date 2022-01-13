package es.iespuertodelacruz.rl.repository.NewInstituto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iespuertodelacruz.rl.NewInstituto.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {
	
	
	
}
