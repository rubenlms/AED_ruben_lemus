package es.iespuertodelacruz.rl.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import es.iespuertodelacruz.rl.dto.MatriculaDTO;
import es.iespuertodelacruz.rl.entities.Matricula;
import es.iespuertodelacruz.rl.service.AlumnoService;
import es.iespuertodelacruz.rl.service.MatriculaService;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaREST {
	
	private Logger logger =
			(Logger) LoggerFactory.getLogger(MatriculaREST.class);
	
	@Autowired
	MatriculaService matriculaservice;
	AlumnoService alumnoservice;
	
	@GetMapping
	public ResponseEntity<List<MatriculaDTO>> getAll(){

		logger.info("llega a consulta5r todas las matrículas");
		ArrayList<MatriculaDTO> matriculas = new ArrayList<MatriculaDTO>();
	
		matriculaservice.findAll().forEach(mat -> {
			Matricula m = new Matricula();
			MatriculaDTO mDTO = new MatriculaDTO(m);
			matriculas.add((MatriculaDTO)mDTO);
		});
			
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(matriculas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getbyID(@PathVariable int id){	
		
		Optional<Matricula> optMatricula = matriculaservice.findById(id);
		
		if(optMatricula.isPresent()) {
			MatriculaDTO aDTO = new MatriculaDTO(optMatricula.get());
			return ResponseEntity.ok().body(aDTO);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		Optional<Matricula> optMatricula = matriculaservice.findById(id);
		if(optMatricula.isPresent()) {
			matriculaservice.deleteById(id);
			return ResponseEntity.ok("Matricula con id:" + id + " borrado");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Matricula matricula){
		Matricula mat = new Matricula();
		
		mat.setIdmatricula(matricula.getIdmatricula());
		mat.setYear(matricula.getYear());
		mat.setAlumno(matricula.getAlumno());
	 
		matriculaservice.save(mat);
		
		return ResponseEntity.ok().body(new MatriculaDTO(mat));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id,
	@RequestBody Matricula matriculaDTO){
		Optional<Matricula> optMatricula = matriculaservice.findById(id);

		if(optMatricula.isPresent()) {
			Matricula mat = new Matricula();
			mat.setIdmatricula(matriculaDTO.getIdmatricula());
			mat.setYear(matriculaDTO.getYear());
			//mat.setAlumno(null);
			
			
			return ResponseEntity.ok(matriculaservice.save(mat));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}

}
