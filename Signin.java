/**
 * 
 */
package intergiciels.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import intergiciels.beans.User;
import intergiciels.forms.SigninForm;

/**
 * @author Jade BOUMAZA
 *
 */
public class Signin extends HttpServlet {
	public static final String VUE = "/WEB-INF/signin.jsp";
	public static final String ATTRIBUT_USER = "user";
    public static final String ATTRIBUT_FORM = "form";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de connexion */
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 /* Préparation de l'objet formulaire */
        SigninForm form = new SigninForm();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        User user = form.connecterUser(request);
		
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATTRIBUT_FORM, form);
        request.setAttribute(ATTRIBUT_USER, user);
        
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}		

}
