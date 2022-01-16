package es.iespuertodelacruz.rl.NewInstituto.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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
import es.iespuertodelacruz.rl.NewInstituto.dto.AlumnoDTO;
import es.iespuertodelacruz.rl.NewInstituto.dto.AsignaturaDTO;
import es.iespuertodelacruz.rl.NewInstituto.entities.Asignatura;
import es.iespuertodelacruz.rl.NewInstituto.service.AsignaturaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaRest {
	
	private Logger logger =
			(Logger) LoggerFactory.getLogger(AsignaturaRest.class);
	
	
	AsignaturaService asignaturaservice;
	
	@ApiOperation(value = "Busqueda de todas las asignaturas", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La búsqueda funciona correctamente", response = AsignaturaDTO.class),
			@ApiResponse(code = 400, message = "Bad Request.Algo no ha ido bien", response = String.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request"),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe"),
			@ApiResponse(code = 500, message = "Error inesperado del sistema") })
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
	
	@ApiOperation(value = "Busqueda de asignatura mediante id", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La búsqueda funciona correctamente", response = AsignaturaDTO.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request", response = String.class),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
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
	
	@ApiOperation(value = "Eliminar asignatura mediante id", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se ha eliminado correctamente", response = AsignaturaDTO.class),
			@ApiResponse(code = 204, message = "El alumno no ha sido borrado correctamente", response = String.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request"),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
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
	
	@ApiOperation(value = "Guarda una asignatura", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La búsqueda funciona correctamente", response = AsignaturaDTO.class),
			@ApiResponse(code = 201, message = "Se ha guardado correctamente", response = String.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request"),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Asignatura a){
		Asignatura asig=new Asignatura();
		asig.setIdasignatura(a.getIdasignatura());
		asig.setNombre(a.getNombre());
		asig.setCurso(a.getCurso());
		
		asignaturaservice.save(asig);
		
		return ResponseEntity.ok().body(new AsignaturaDTO(asig));
	}
	
	@ApiOperation(value = "Actualizar asignaturas mediante id", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se ha actualizado correctamente", response = AlumnoDTO.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request", response = String.class),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
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
