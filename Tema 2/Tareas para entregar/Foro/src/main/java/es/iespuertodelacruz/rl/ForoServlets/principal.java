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
		request.setCharacterEncoding("UTF-8");
		
	    ArrayList<String>mensajes= (ArrayList<String>) request.getServletContext().getAttribute("mensajes");
	    
	    if (mensajes==null) {
	    	mensajes = new ArrayList<>();
	    	request.getServletContext().setAttribute("mensajes",mensajes);
	    }
	    
	    request.getRequestDispatcher("Vista.jsp").forward(request, response);
	    
		String mensaje = request.getParameter("nombre")+":"+request.getParameter("mensaje");
		
		mensajes.add(mensaje);
		
		request.getServletContext().setAttribute("mensajes", mensajes);
		//request.getRequestDispatcher("Vista.jsp").forward(request, response);
		request.getRequestDispatcher("vista.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String user = request.getParameter("nombre");
		String mensaje = request.getParameter("mensaje");
		
		if(request.getSession().getAttribute("nombre")==null) {
			request.getSession().setAttribute("nombre", user);
		}
		
		ArrayList<String>mensajes = (ArrayList<String>) request.getServletContext().getAttribute("mensajes");
		mensajes.add(user+": "+mensaje);
		
		request.getServletContext().setAttribute("mensajes", mensajes);
		response.sendRedirect("Vista.jsp");
	}
}
