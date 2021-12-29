package es.iespuertodelacruz.rl.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.iespuertodelacruz.rl.dao.BaseDeDatos;
import es.iespuertodelacruz.rl.dao.OperadorDAO;
import es.iespuertodelacruz.rl.entities.Operador;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		BaseDeDatos bd =  (BaseDeDatos) request.getServletContext().getAttribute("gc");
		
		OperadorDAO operadorDAO = new OperadorDAO(bd);
		Operador operador = null;
		
		HttpSession session = request.getSession();
		
		String paramID = request.getParameter("operador");
		String paramPassword = request.getParameter("password");
		
		boolean check = operadorDAO.checkOperador(paramID, paramPassword);
		
		if(check==true) {
			response.sendRedirect("user/operador.jsp");
		} else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
