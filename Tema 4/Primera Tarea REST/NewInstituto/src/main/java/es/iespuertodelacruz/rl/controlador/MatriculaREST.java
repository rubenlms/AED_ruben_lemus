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
import es.iespuertodelacruz.rl.entities.Alumno;
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
	public List<Matricula> getAll(){
		
		ArrayList<Matricula> Matriculas = new ArrayList<Matricula>();
	
		matriculaservice.findAll().forEach(mat -> Matriculas.add((Matricula)mat));

		return Matriculas;
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		Optional<Matricula> optM = matriculaservice.findById(id);
		if(optM.isPresent()) {
			matriculaservice.deleteById(id);
			return ResponseEntity.ok("Matricula con id:" + id + " borrado");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}
	
	/*
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Matricula matriculaDTO){
		Matricula mat;
		Alumno alumno;
		mat.setIdmatricula(matriculaDTO.getIdmatricula());
		mat.setYear(matriculaDTO.getYear());
		for(Alumno a: alumnoservice.findAll()) {
			ArrayList<Matricula>matriculas = (ArrayList<Matricula>) a.getMatriculas();
			for(Matricula m: matriculas) {
				if(m.getIdmatricula()==matriculaDTO.getIdmatricula()) {
					
					alumno.setDni(a.getDni()),
							a.getNombre(),
							a.getApellidos(),
							a.getFechanacimiento());
				}
			}
		}
		//mat.setAlumno(alumno);
		matriculaservice.save(mat);
		
		return ResponseEntity.ok().body(new Matricula(mat));
	}*/
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id,
	@RequestBody Matricula matriculaDTO){
		Optional<Matricula> optM = matriculaservice.findById(id);

		if(optM.isPresent()) {
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
