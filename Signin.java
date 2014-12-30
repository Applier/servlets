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
import javax.servlet.http.HttpSession;

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
    public static final String ATTRIBUT_SESSIONUSER = "sessionUser";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de connexion */
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Préparation de l'objet formulaire */
        SigninForm form = new SigninForm();
        
        /* Traitement de la requête et récupération du bean en résultant */
        User user = form.connecterUser(request);
        
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
        /* Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * User à la session, sinon suppression du bean de la session */
        if (form.getErreurs().isEmpty() ) {
            session.setAttribute(ATTRIBUT_SESSIONUSER, user);
        } else {
            session.setAttribute(ATTRIBUT_SESSIONUSER, null);
        }
        
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATTRIBUT_FORM, form);
        request.setAttribute(ATTRIBUT_USER, user);
        
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}		

}
