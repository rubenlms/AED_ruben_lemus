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
 * Servlet implementation class GestorAlumnosAñadir
 */
@WebServlet({"/agregaralumno", "/Agregaralumno"})
//poner aqui el action del form al que hace referencia!
public class GestorAlumnosAñadir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestorAlumnosAñadir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//AlumnoDAO alumnoDAO = new AlumnoDAO();
		
		
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
		
		String dni = request.getParameter("dniAgregar");
		String nombre = request.getParameter("nombreAgregar");
		String apellidos = request.getParameter("apellidosAgregar");
		String fechaNacimiento = request.getParameter("nacimientoAgregar");
		
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Date nacimiento = (Date) formatoFecha.parse(fechaNacimiento);
		
		Alumno alumno = new Alumno(dni, nombre, apellidos, (java.sql.Date) nacimiento); //tratar la fecha?
		alumnoDAO.save(alumno);
	}

}
