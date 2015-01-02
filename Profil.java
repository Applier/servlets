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
import intergiciels.beans.InfosCV;
import intergiciels.forms.ProfilForm;

/**
 * @author Jade BOUMAZA
 *
 */
public class Profil extends HttpServlet {
	public static final String VUE = "/WEB-INF/profil.jsp";
	public static final String ATTRIBUT_USER = "user";
    public static final String ATTRIBUT_FORM = "form";
    public static final String ATTRIBUT_SESSIONUSER = "sessionUser";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de profil */
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Préparation de l'objet formulaire */
		ProfilForm form = new ProfilForm();
		
		/* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
		InfosCV infos = form.remplirInfosCV(request);
		
		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		
		/* Récupération du bean User de la session en cours */
		User user = (User) session.getAttribute(ATTRIBUT_SESSIONUSER);
		
		/* Ajout des données du profil aux infos de l'user */
		user.setInfos(infos);
		
		/* Ajout du bean User à la session */
		session.setAttribute(ATTRIBUT_SESSIONUSER, user);
		
		/* Stockage du formulaire et du bean dans l'objet request */
		request.setAttribute(ATTRIBUT_FORM, form);
		request.setAttribute(ATTRIBUT_USER, user);
		
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}

}

	


