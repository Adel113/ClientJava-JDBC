package com.example.client;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // URL de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/bbibliothèque"; // Remplace par ta base de données
        String username = "root";  // Remplace par ton nom d'utilisateur
        String password = ""; // Remplace par ton mot de passe
        try {
            // Charger le driver MySQL JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion à la base de données
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion réussie !");

            // Créer une déclaration pour exécuter une requête
            Statement statement = connection.createStatement();

            //récupération de données
            String selectQuery = "SELECT * FROM livre";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Affichage des résultats
            while (resultSet.next()) {


                // Récupère les données selon le type des colonnes
                int id = resultSet.getInt("id"); 
                String titre = resultSet.getString("titre"); 
                String auteur = resultSet.getString("auteur"); 
                double prix = resultSet.getDouble("prix"); 

                // Affiche les résultats
                System.out.println("ID: " + id);
                System.out.println("Titre: " + titre);
                System.out.println("Auteur: " + auteur);
                System.out.println("Prix: " + prix);
            }

            // Fermer les ressources
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Connexion fermée.");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC non trouvé : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }
}
