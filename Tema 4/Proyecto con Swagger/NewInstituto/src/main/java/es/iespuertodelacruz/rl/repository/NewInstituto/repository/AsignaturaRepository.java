package es.iespuertodelacruz.rl.repository.NewInstituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iespuertodelacruz.rl.NewInstituto.entities.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {

}
