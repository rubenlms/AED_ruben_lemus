package es.iespuertodelacruz.rl.controlador;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import es.iespuertodelacruz.rl.service.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoRest {
	
	private Logger logger =
			(Logger) LoggerFactory.getLogger(AlumnoRest.class);
	
	@Autowired
	AlumnoService alumnoservice;
	
	//Implementar métodos (leer pags 39 y ss.)
}
