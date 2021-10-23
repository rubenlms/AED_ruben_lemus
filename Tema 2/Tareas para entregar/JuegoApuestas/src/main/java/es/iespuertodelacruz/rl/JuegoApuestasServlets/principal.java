package es.iespuertodelacruz.rl.JuegoApuestasServlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

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
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ArrayList<Usuario>listaUsuarios = (ArrayList<Usuario>) request.getServletContext().getAttribute("listaUsuarios");
		
		if(listaUsuarios == null) {
			listaUsuarios = new ArrayList();
			request.getServletContext().getAttribute("listaUsuarios");
		}
		
		String userName = request.getParameter("usuario");
		
		if(request.getSession().getAttribute("usuario")==null) { //si el usuario no tiene una sesión crea una
			
			request.getSession().setAttribute("usuario", userName);
			//Usuario us = new Usuario(userName,apuesta); falta el arraylist con las apuestas ¿como hacerlo?
			//listaUsuarios.add(us);
		}
		
		//a partir de aqui ir llenando el arraylist/treemap con las distintas apuestas
	}
	
}
