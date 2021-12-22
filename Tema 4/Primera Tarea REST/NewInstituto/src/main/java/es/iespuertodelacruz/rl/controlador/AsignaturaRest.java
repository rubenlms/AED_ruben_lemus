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
import es.iespuertodelacruz.rl.dto.AsignaturaDTO;
import es.iespuertodelacruz.rl.entities.Asignatura;
import es.iespuertodelacruz.rl.service.AsignaturaService;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaRest {
	
	private Logger logger =
			(Logger) LoggerFactory.getLogger(AsignaturaRest.class);
	
	@Autowired
	AsignaturaService asignaturaservice;
	
	@GetMapping
	public ResponseEntity<List<AsignaturaDTO>> getAll(){
		
		ArrayList<AsignaturaDTO> asignaturas = new ArrayList<AsignaturaDTO>();
	
		asignaturaservice.findAll().forEach(asig -> {
			Asignatura a = new Asignatura();
			AsignaturaDTO aDTO = new AsignaturaDTO(a);
			asignaturas.add(aDTO);
		});

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(asignaturas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getbyID(@PathVariable int id){	
		
		Optional<Asignatura> optAsignatura = asignaturaservice.findById(id);
		
		if(optAsignatura.isPresent()) {
			AsignaturaDTO aDTO = new AsignaturaDTO(optAsignatura.get());
			return ResponseEntity.ok().body(aDTO);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		Optional<Asignatura> optAsignatura = asignaturaservice.findById(id);
		if(optAsignatura.isPresent()) {
			asignaturaservice.deleteById(id);
			return ResponseEntity.ok("Asignatura con id:" + id + " borrada");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Asignatura a){
		Asignatura asig=new Asignatura();
		asig.setIdasignatura(a.getIdasignatura());
		asig.setNombre(a.getNombre());
		asig.setCurso(a.getCurso());
		
		asignaturaservice.save(asig);
		
		return ResponseEntity.ok().body(new AsignaturaDTO(asig));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id,
	@RequestBody Asignatura asignaturaDTO){
		Optional<Asignatura> optAsignatura = asignaturaservice.findById(id);

		if(optAsignatura.isPresent()) {
			Asignatura asig = null;
			asig.setIdasignatura(asignaturaDTO.getIdasignatura());
			asig.setNombre(asignaturaDTO.getNombre());
			asig.setCurso(asignaturaDTO.getCurso());
			
			
			return ResponseEntity.ok(asignaturaservice.save(asig));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}


}
