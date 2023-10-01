package packTp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/MonServlet")
public class MonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MonServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String pseudo = request.getParameter("pseudo");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");
        boolean recupererMotDePasse = "on".equals(request.getParameter("recupererMotDePasse"));
        if (estChaineVide(nom) || estChaineVide(prenom) || estChaineVide(pseudo) || estChaineVide(email) || estChaineVide(motDePasse)) {
            response.sendRedirect("Inscription.jsp?erreur=Champs obligatoires non remplis");
            return;
        }
        Utilisateur nouvelUtilisateur = new Utilisateur(nom, prenom, pseudo, email, motDePasse);
        HttpSession session = request.getSession();
        session.setAttribute("nomUtilisateur", request.getParameter("nom"));
        List<Utilisateur> utilisateurs = (List<Utilisateur>) session.getAttribute("utilisateurs");
        if (utilisateurs == null) {
            utilisateurs = new ArrayList<>();
        }
        utilisateurs.add(nouvelUtilisateur);
        session.setAttribute("utilisateurs", utilisateurs);
        session.setAttribute("nomUtilisateur", nouvelUtilisateur.getNom());
        response.sendRedirect("Accueil.jsp");
	}
	private boolean estChaineVide(String chaine) {
	    return chaine == null || chaine.trim().isEmpty();
	}


}
