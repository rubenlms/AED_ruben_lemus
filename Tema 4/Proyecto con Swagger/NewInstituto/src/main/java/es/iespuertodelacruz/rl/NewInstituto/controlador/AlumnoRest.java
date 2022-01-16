
package es.iespuertodelacruz.rl.NewInstituto.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
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
import es.iespuertodelacruz.rl.NewInstituto.entities.Alumno;
import es.iespuertodelacruz.rl.NewInstituto.service.AlumnoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/alumnos")

public class AlumnoRest {

	private Logger logger = (Logger) LoggerFactory.getLogger(AlumnoRest.class);

	AlumnoService alumnoservice;

	@ApiOperation(value = "Busqueda de todos los alumnos", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La búsqueda funciona correctamente", response = AlumnoDTO.class),
			@ApiResponse(code = 400, message = "Bad Request.Algo no ha ido bien", response = String.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request"),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe"),
			@ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@GetMapping
	public ResponseEntity<List<AlumnoDTO>> getAll() {

		ArrayList<AlumnoDTO> alumnos = new ArrayList<AlumnoDTO>();

		alumnoservice.findAll().forEach(alum -> {
			Alumno a = (Alumno) alum;
			AlumnoDTO aDTO = new AlumnoDTO(a);
			alumnos.add((AlumnoDTO) aDTO);
		});

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(alumnos);
	}

	@ApiOperation(value = "Busqueda de alumno mediante id", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La búsqueda funciona correctamente", response = AlumnoDTO.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request", response = String.class),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
	@GetMapping("/{id}")
	public ResponseEntity<?> getbyID(@PathVariable String id) {

		Optional<Alumno> optAlumno = alumnoservice.findById(id);

		if (optAlumno.isPresent()) {
			AlumnoDTO aDTO = new AlumnoDTO(optAlumno.get());
			return ResponseEntity.ok().body(aDTO);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}

	@ApiOperation(value = "Eliminar alumno mediante id", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se ha eliminado correctamente", response = AlumnoDTO.class),
			@ApiResponse(code = 204, message = "El alumno no ha sido borrado correctamente", response = String.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request"),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		Optional<Alumno> optAlumno = alumnoservice.findById(id);
		if (optAlumno.isPresent()) {
			alumnoservice.deleteById(id);
			return ResponseEntity.ok("alumno con id:" + id + " borrado");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}

	@ApiOperation(value = "Guarda un alumno", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La búsqueda funciona correctamente", response = AlumnoDTO.class),
			@ApiResponse(code = 201, message = "Se ha guardado correctamente", response = String.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request"),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Alumno al) {
		Alumno alum = new Alumno();

		alum.setDni(al.getDni());
		alum.setNombre(al.getNombre());
		alum.setApellidos(al.getApellidos());
		alum.setFechanacimiento(al.getFechanacimiento());
		alum.setMatriculas(al.getMatriculas());
		alumnoservice.save(alum);

		return ResponseEntity.ok().body(new AlumnoDTO(alum));
	}

	@ApiOperation(value = "Actualizar alumnos mediante id", notes = "")

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Se ha actualizado correctamente", response = AlumnoDTO.class),
			@ApiResponse(code = 401, message = "No ha sido posible realizar la request", response = String.class),
			@ApiResponse(code = 403, message = "No tienes permisos para acceder a este apartado de la API"),
			@ApiResponse(code = 404, message = "La API a la que intenta acceder no existe") })
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody AlumnoDTO alumnoDTO) {
		Optional<Alumno> optAlumno = alumnoservice.findById(id);

		if (optAlumno.isPresent()) {
			Alumno alum = optAlumno.get();

			alum.setDni(alumnoDTO.getDni());
			alum.setNombre(alumnoDTO.getNombre());
			alum.setApellidos(alumnoDTO.getApellidos());
			alum.setFechanacimiento(alumnoDTO.getFechanacimiento());
			alum.setMatriculas(alumnoDTO.getMatriculas());

			return ResponseEntity.ok(alumnoservice.save(alum));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}

}
