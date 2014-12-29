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



/**
 * @author Jade BOUMAZA
 *
 */
public class Signup extends HttpServlet{
	public static final String VUE = "/WEB-INF/signup.jsp";
	public static final String CHAMP_MAIL = "mail";
	public static final String CHAMP_PASSWORD = "password";
	public static final String CHAMP_CONFIRMATION = "confirmation";
	public static final String ATTRIBUT_ERREURS = "erreurs";
	public static final String ATTRIBUT_RESULTAT = "resultat";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat;
		Map<String,String> erreurs = new HashMap<String,String>();
		
		/* Récupération des champs du formulaire d'inscription */
		String mail = request.getParameter(CHAMP_MAIL);
		String password = request.getParameter(CHAMP_PASSWORD);
		String confirmation = request.getParameter(CHAMP_CONFIRMATION);
		
		/* Validation du champ mail */
		try {
			validationMail(mail);
		} catch (Exception e) {
			erreurs.put(CHAMP_MAIL, e.getMessage());
		}
		
		/* Validation du champ mot de passe */
		try {
			validationPassword(password,confirmation);
		} catch (Exception e) {
			erreurs.put(CHAMP_PASSWORD, e.getMessage());
		}
		
		if (erreurs.isEmpty()) {
			resultat = "Succès";
		} 
		else {
			resultat = "Echec";
		}
		
		/* Stockage du résultat et des messages d'erreur dans request */
		request.setAttribute(ATTRIBUT_ERREURS, erreurs);
		request.setAttribute(ATTRIBUT_RESULTAT, resultat);
		
		/* Transmission à la JSP signup.jsp */
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}
	
	
	/**
	 * Vérifier que l'adresse mail entrée dans le champ email est non vide
	 * et disponible (n'est pas déjà utilisée par un autre utilisateur)
	 * @param mail
	 * @throws Exception
	 */
	private void validationMail(String mail) throws Exception {
		if (mail == null | mail.length() == 0) {
			throw new Exception("Merci de saisir une adresse mail.");
		}
	}
	
	/**
	 * Vérifier que le mot de passe entré dans le champ password est non vide,
	 * fait plus de 5 caractères et identique à la chaîne de confirmation
	 * @param password
	 * @param confirmation
	 */
	private void validationPassword(String password, String confirmation) throws Exception {
		if (password != null && password.length() >= 5) {
			if (!password.equals(confirmation)) {
				throw new Exception("Attention : les mots de passe entrés sont différents.");
			}
			else {
				throw new Exception("Votre mot de passe doit contenir au moins 5 caractères.");
		
				
			}
		}
	}
	

}
