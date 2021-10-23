package es.iespuertodelacruz.rl.ForoServlets;

import java.io.IOException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class inicializadorAplicacion
 *
 */
public class inicializadorAplicacion implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public inicializadorAplicacion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	 ManejarFichero mf = new ManejarFichero("mensajes.txt");
    	 sce.getServletContext().getAttribute("mensajes");
    	 try {
			mf.agregarTexto(sce.getServletContext().getAttribute("mensajes").toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	ManejarFichero mf = new ManejarFichero("mensajes.txt");
    	sce.getServletContext().setAttribute("ManejarFichero", mf);
    }
	
}
