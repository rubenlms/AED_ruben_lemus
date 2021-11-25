package es.iespuertodelacruz.rl.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import es.iespuertodelacruz.rl.entities.Staff;
import es.iespuertodelacruz.rl.repositories.StaffRepository;

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

		HttpSession session = request.getSession();
		Staff staff = (Staff)session.getAttribute("staff");
		String redirect = "login.jsp";
		if(staff != null)
			redirect="staff/staff.jsp";
		else {
			String paramUserName = request.getParameter("username");
			String paramPassword = request.getParameter("password");
			EntityManagerFactory emf =(EntityManagerFactory)request.getServletContext().getAttribute("emf");
			StaffRepository staffRep = new StaffRepository(emf);
			
			Staff staffFind = staffRep.findbyName(paramUserName);
			
			if(staffFind != null) {
											
				boolean okLogin = BCrypt.checkpw(paramPassword,staffFind.getPassword());

				if(okLogin) {
					request.getSession().setAttribute("staff", staff);
					/*
					 * Desarrollar aqui para que muestre en staff.jsp una lista con
					 * las películas disponibles.
					 */
					redirect="staff/staff.jsp";
				}
				
			}
		}
		
		response.sendRedirect(redirect);
	
	}

}
