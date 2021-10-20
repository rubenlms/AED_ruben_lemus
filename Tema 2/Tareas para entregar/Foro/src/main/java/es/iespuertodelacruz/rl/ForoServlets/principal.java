package es.iespuertodelacruz.rl.ForoServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class principal
 */
public class principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public principal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    ArrayList<String> mensajes = new ArrayList<>();
	    
		String mensaje = request.getParameter("nombre")+":"+request.getParameter("mensaje");
		
		mensajes.add(mensaje);
		
		request.getServletContext().setAttribute(mensaje, mensajes);
		request.getRequestDispatcher("Vista.jsp").forward(request, response);
	}

}
