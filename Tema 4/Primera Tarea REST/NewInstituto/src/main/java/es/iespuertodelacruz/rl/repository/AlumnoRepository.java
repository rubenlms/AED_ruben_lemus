package es.iespuertodelacruz.rl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespuertodelacruz.rl.entities.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, String> {

}
