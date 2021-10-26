package es.iespuertodelacruz.rl.JuegoApuestasServlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession sesion = request.getSession();
		String nick = (String) request.getSession().getAttribute("usuario");
		
		if (nick==null) {
			request.getRequestDispatcher("inicio.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("jugar.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//generarSecretoSInoexiste(request,response) metodo aparte que crea un usuario si no existe
		//se hace asi para ambos pq es para get y para post
		
		//ArrayList<Usuario>listaUsuarios = (ArrayList<Usuario>) request.getServletContext().getAttribute("listaUsuarios");
		HashSet<String> nickUsados = (HashSet<String>) request.getServletContext().getAttribute("listaUsuarios");; //aqui para guaradar los nic, mejor que un AL
		ArrayList<Integer>apuestas = new ArrayList<Integer>();//arraylist de apuestas con un long para las fechas
		
		HttpSession sesion = request.getSession();
		Integer secreto = (int) (Math.random()*1000);
		Integer apuesta = 0; //(usar Integer en lugar de int para evitar que use negativos) hacer un condicional antes de meter la apuesta en el AList.
		long fechaSecreto;
		
		
		if(nickUsados == null) {
			nickUsados = new HashSet<>();
			request.getServletContext().getAttribute("listaUsuarios");
		}
		
		String userName = request.getParameter("usuario");
		
		if(request.getSession().getAttribute("usuario")!=null && request.getParameter("usuario")!=null) {
			//hay nick y hay sesión, hay que recoger las apuestas
		}
		
		if(request.getSession().getAttribute("usuario")!=null && request.getParameter("usuario")==null) { //si el usuario no tiene una sesiï¿½n crea una
			
			//hay sesión pero no hay parámetro, por lo que se añade a la sesión el nick
			request.getSession().setAttribute("usuario", userName);
			nickUsados.add(userName);
			//System.currentTimeMillis();
		}
		
		if(request.getSession().getAttribute("usuario")==null && request.getParameter("usuario")!=null) {
			
			//ha puesto el nick pero no hay sesion, hay que crear una
			sesion = request.getSession();//comprobar si se crea
		}
		
		if(request.getSession().getAttribute("usuario")==null && request.getParameter("usuario")==null) {
			
			//no hay nick ni sesion creada
			sesion = request.getSession();
			request.getSession().setAttribute("usuario", userName);
			nickUsados.add(userName);
		}
		
		//a partir de aqui ir completando el código con el arraylist/treemap con las distintas apuestas
	}
	
}
