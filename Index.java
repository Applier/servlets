/**
 * 
 */
package intergiciels.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jade BOUMAZA
 *
 */
public class Index extends HttpServlet {
	
	public static final String VUE = "/WEB-INF/index.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'index */
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'index */				
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}

}
