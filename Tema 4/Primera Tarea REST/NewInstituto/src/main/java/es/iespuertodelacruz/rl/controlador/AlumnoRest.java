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
import es.iespuertodelacruz.rl.dto.AlumnoDTO;
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
	public ResponseEntity<List<AlumnoDTO>> getAll(){
		
		ArrayList<AlumnoDTO> alumnos = new ArrayList<AlumnoDTO>();	
	
		alumnoservice.findAll().forEach(alum -> {
			Alumno a = (Alumno)alum;
			AlumnoDTO aDTO = new AlumnoDTO(a);
			alumnos.add((AlumnoDTO)aDTO);
		});

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(alumnos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getbyID(@PathVariable String id){	
		
		Optional<Alumno> optM = alumnoservice.findById(id);
		
		if(optM.isPresent()) {
			AlumnoDTO aDTO = new AlumnoDTO(optM.get());
			return ResponseEntity.ok().body(aDTO);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
		
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
	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Alumno al){
		Alumno alum=new Alumno();
		
		alum.setDni(al.getDni());
		alum.setNombre(al.getNombre());
		alum.setApellidos(al.getApellidos());
		alum.setFechanacimiento(al.getFechanacimiento());
		alum.setMatriculas(al.getMatriculas());
		alumnoservice.save(alum);
		
		return ResponseEntity.ok().body(new AlumnoDTO(alum));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id,
	@RequestBody AlumnoDTO alumnoDTO){
		Optional<Alumno> optM = alumnoservice.findById(id);

		if(optM.isPresent()) {
			Alumno alum = optM.get();
			
			alum.setDni(alumnoDTO.getDni());
			alum.setNombre(alumnoDTO.getNombre());
			alum.setApellidos(alumnoDTO.getApellidos());
			alum.setFechanacimiento(alumnoDTO.getFechanacimiento());
			alum.setMatriculas(alumnoDTO.getMatriculas());
			
			return ResponseEntity.ok(alumnoservice.save(alum));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}
	
	 
}
