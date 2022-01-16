package es.iespuertodelacruz.rl.NewInstituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.iespuertodelacruz.rl.NewInstituto.entities.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{

}
