package es.iespuertodelacruz.rl.servlets.AlumnosServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.iespuertodelacruz.rl.dao.AlumnoDAO;
import es.iespuertodelacruz.rl.dao.AsignaturaDAO;
import es.iespuertodelacruz.rl.dao.BaseDeDatos;
import es.iespuertodelacruz.rl.dao.MatriculaDAO;

/**
 * Servlet implementation class GestorAlumnosBorrar
 */
@WebServlet("/borraralumno")
public class GestorAlumnosBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestorAlumnosBorrar() {
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
		
		String dni = request.getParameter("dniAgregar");
		
		alumnoDAO.delete(dni);
	}

}
