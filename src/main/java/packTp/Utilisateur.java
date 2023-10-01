package packTp;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String pseudo;
    private String email;
    private String motDePasse;

    public Utilisateur(String nom, String prenom, String pseudo, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.email = email;
        this.motDePasse = motDePasse;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getPseudo() {
        return pseudo;
    }
    public String getEmail() {
        return email;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
}

