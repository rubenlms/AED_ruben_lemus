package es.iespuertodelacruz.rl.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import es.iespuertodelacruz.rl.dao.BaseDeDatos;

/**
 * Application Lifecycle Listener implementation class Pool
 *
 */
@WebListener
public class Pool implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Pool() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	
         BaseDeDatos gc = new BaseDeDatos("instituto", "admin", "1q2w3e4r");
         sce.getServletContext().setAttribute("gc", gc);
    }
	
}
