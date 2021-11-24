package es.iespuertodelacruz.rl.servlets.AlumnosServlets;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.rl.dao.AlumnoDAO;
import es.iespuertodelacruz.rl.dao.AsignaturaDAO;
import es.iespuertodelacruz.rl.dao.BaseDeDatos;
import es.iespuertodelacruz.rl.dao.MatriculaDAO;
import es.iespuertodelacruz.rl.entities.Alumno;

/**
 * Servlet implementation class GestorAlumnosEditar
 */
@WebServlet("/editaralumno")
public class GestorAlumnosEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestorAlumnosEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BaseDeDatos gc =  (BaseDeDatos)request.getServletContext().getAttribute("gc");
		AlumnoDAO alumnoDAO = new AlumnoDAO(gc);
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);
		MatriculaDAO matriculaDAO = new MatriculaDAO(gc);
		
		String nombre = request.getParameter("nombreEditar");
		String apellidos = request.getParameter("apellidosEditar");
		String fechaNacimiento = request.getParameter("nacimientoEditar");
		
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Date nacimiento = (Date) formatoFecha.parse(fechaNacimiento);
		
		String dni = request.getParameter("dniEditar");
		
		if(alumnoDAO.findbyID(dni)!=null) {
			Alumno alumno = new Alumno(dni, nombre, apellidos, (java.sql.Date) nacimiento);
			
			alumnoDAO.update(alumno);
		} else {
			String mensaje = "No existe el alumno";
		
		}
		
		
		
	}

}
