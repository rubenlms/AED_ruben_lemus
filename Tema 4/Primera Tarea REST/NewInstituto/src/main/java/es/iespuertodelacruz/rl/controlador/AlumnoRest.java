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
import es.iespuertodelacruz.rl.service.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoRest {
	
	private Logger logger =
			(Logger) LoggerFactory.getLogger(AlumnoRest.class);
	
	@Autowired
	AlumnoService alumnoservice;
	
	@GetMapping
	public List<Alumno> getAll(){
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		//logger.info("si queremos hacer debug por ejemplo");
	
		alumnoservice.findAll().forEach(alum -> alumnos.add((Alumno)alum));

		return alumnos;
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		Optional<Alumno> optM = alumnoservice.findById(id);
		if(optM.isPresent()) {
			alumnoservice.deleteById(id);
			return ResponseEntity.ok("alumno con id:" + id + " borrado");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}
	
	/*
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Alumno alumnoDTO){
		Alumno alum;
		alum.setDni(alumnoDTO.getDni());
		alum.setNombre(alumnoDTO.getNombre());
		alum.setApellidos(alumnoDTO.getApellidos());
		alum.setFechanacimiento(alumnoDTO.getFechanacimiento());
		//falta las matriculas del alumno
		alumnoservice.save(alum);
		
		return ResponseEntity.ok().body(new Alumno(alum));
	}*/
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id,
	@RequestBody Alumno alumnoDTO){
		Optional<Alumno> optM = alumnoservice.findById(id);

		if(optM.isPresent()) {
			Alumno alum = optM.get();
			alum.setDni(alumnoDTO.getDni());
			alum.setNombre(alumnoDTO.getNombre());
			alum.setApellidos(alumnoDTO.getApellidos());
			alum.setFechanacimiento(alumnoDTO.getFechanacimiento());
			
			
			return ResponseEntity.ok(alumnoservice.save(alum));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}
	
	 
}
