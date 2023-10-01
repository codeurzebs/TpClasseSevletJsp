package packTp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String pseudo = request.getParameter("pseudo");
        String motDePasse = request.getParameter("motDePasse");
        if ("utilisateur".equals(pseudo) && "motdepasse123".equals(motDePasse)) {
            HttpSession session = request.getSession();
            session.setAttribute("pseudo", pseudo);
            response.sendRedirect("Accueil.jsp");
        } else {
            response.sendRedirect("login.jsp?erreur=Identifiants incorrects");
        }
	}

}
