package es.iespuertodelacruz.rl.servlets;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class IniciarEntityManagerFactory
 *
 */
public class IniciarEntityManagerFactory implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public IniciarEntityManagerFactory() {
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
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sakila");
        sce.getServletContext().setAttribute("emf", emf);
    }
	
}
