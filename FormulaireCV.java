package intergiciels.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import intergiciels.beans.InfosCV;
import intergiciels.forms.FormulaireCVForm;

/**
 * @author Jade BOUMAZA
 *
 */
public class FormulaireCV extends HttpServlet {
	public static final String VUE = "/WEB-INF/formulairecv.jsp";
	public static final String ATTRIBUT_INFOSCV = "infosCV";
	public static final String ATTRIBUT_FORM = "form";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page de formulaire du CV */
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Préparation de l'objet formulaire */
		FormulaireCVForm form = new FormulaireCVForm();
		
		/* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
		InfosCV infosCV = form.remplirInfosCV(request);
		
		/* Stockage du formulaire et du bean dans l'objet request */
		request.setAttribute(ATTRIBUT_FORM, form);
		request.setAttribute(ATTRIBUT_INFOSCV, infosCV);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}

}

	


