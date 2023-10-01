<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="packTp.Utilisateur" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil</title>
</head>
<body>
    <h2>Bienvenue <%= session.getAttribute("nomUtilisateur") %></h2>
    
    <p>Liste des utilisateurs inscrits :</p>
    <ul>
        <% 
        List<Utilisateur> utilisateurs = (List<Utilisateur>) session.getAttribute("utilisateurs");
        if (utilisateurs != null && !utilisateurs.isEmpty()) {
            for (Utilisateur utilisateur : utilisateurs) {
        %>
            <li><%= utilisateur.getNom() %> <%= utilisateur.getPrenom() %> (<%= utilisateur.getPseudo() %>)</li>
        <%
            }
        } else {
        %>
            <li>Aucun utilisateur inscrit.</li>
        <%
        }
        %>
    </ul>
    
    <form action="MonServlet2" method="post">
        <input type="submit" value="Déconnecter">
    </form>
</body>
</html>
