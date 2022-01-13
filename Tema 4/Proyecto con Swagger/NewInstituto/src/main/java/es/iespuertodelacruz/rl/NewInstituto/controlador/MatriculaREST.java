package es.iespuertodelacruz.rl.NewInstituto.controlador;

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
import es.iespuertodelacruz.rl.NewInstituto.dto.AlumnoDTO;
import es.iespuertodelacruz.rl.NewInstituto.dto.MatriculaDTO;
import es.iespuertodelacruz.rl.NewInstituto.entities.Matricula;
import es.iespuertodelacruz.rl.service.NewInstituto.service.AlumnoService;
import es.iespuertodelacruz.rl.service.NewInstituto.service.MatriculaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaREST {
	
	private Logger logger =
			(Logger) LoggerFactory.getLogger(MatriculaREST.class);
	
	
	MatriculaService matriculaservice;
	AlumnoService alumnoservice;
	
	@ApiOperation(value = "Busqueda de todas las matriculas", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La búsqueda funciona correctamente", response = MatriculaDTO.class),
			@ApiResponse(code = 400, message = "Bad Request.Algo no ha ido bien", response = String.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request"),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe"),
			@ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@GetMapping
	public ResponseEntity<List<MatriculaDTO>> getAll(){

		logger.info("llega a consultar todas las matrículas");
		ArrayList<MatriculaDTO> matriculas = new ArrayList<MatriculaDTO>();
	
		matriculaservice.findAll().forEach(mat -> {
			Matricula m = new Matricula();
			MatriculaDTO mDTO = new MatriculaDTO(m);
			matriculas.add((MatriculaDTO)mDTO);
		});
			
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(matriculas);
	}
	
	@ApiOperation(value = "Busqueda de matricula mediante id", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La búsqueda funciona correctamente", response = MatriculaDTO.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request", response = String.class),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
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
	
	@ApiOperation(value = "Eliminar matricula mediante id", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se ha eliminado correctamente", response = MatriculaDTO.class),
			@ApiResponse(code = 204, message = "El alumno no ha sido borrado correctamente", response = String.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request"),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
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
	
	@ApiOperation(value = "Guarda una matricula", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La búsqueda funciona correctamente", response = MatriculaDTO.class),
			@ApiResponse(code = 201, message = "Se ha guardado correctamente", response = String.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request"),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Matricula matricula){
		Matricula mat = new Matricula();
		
		mat.setIdmatricula(matricula.getIdmatricula());
		mat.setYear(matricula.getYear());
		mat.setAlumno(matricula.getAlumno());
	 
		matriculaservice.save(mat);
		
		return ResponseEntity.ok().body(new MatriculaDTO(mat));
	}
	
	@ApiOperation(value = "Actualizar matriculas mediante id", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se ha actualizado correctamente", response = MatriculaDTO.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request", response = String.class),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
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
