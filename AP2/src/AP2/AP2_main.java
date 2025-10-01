package AP2;

import java.sql.*;
import java.util.ArrayList;

public class AP2_main {

	private static ArrayList<LIVRE> LesLivres = new ArrayList<LIVRE>();
	private static ArrayList<AUTEUR> LesAuteurs = new ArrayList<AUTEUR>();
	private static ArrayList<ADHERENT> LesAdherents = new ArrayList<ADHERENT>();
	private static ArrayList<AUTEUR> AuteursBDD = new ArrayList<AUTEUR>();
	private static ArrayList<ADHERENT> AdherentsBDD = new ArrayList<ADHERENT>();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String BDD = "ap2_sql_2025";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "root";


		ADHERENT Ethan = new ADHERENT("1", "Lalienne", "Ethan", "ethanlalienne92@gmail.com", null );
		LesAdherents.add(Ethan);

		AUTEUR Benjamin = new AUTEUR("1", "Oukil", "Benjamin", "benjamin.oukil@gmail.com", "Il était étudiant en BTS SIO à Paul Lapie");
		LesAuteurs.add(Benjamin);

		LIVRE lePetitPrince = new LIVRE("11111", "Le petit Prince", 40, Ethan, Benjamin);
		LesLivres.add(lePetitPrince);

		ArrayList<LIVRE> LivreCédric = new ArrayList<>();
		LivreCédric.add(LesLivres.get(0));

		ADHERENT Cédric = new ADHERENT ("2", "Lin", "Cédric", "cédriclin@gmail.com", LivreCédric);
		LesAdherents.add(Cédric);





		System.out.println(findAdherent("2")); // Je suis le premier adhérent et ça affiche bien mes infos !
		System.out.println();
		System.out.println(findAuteur("1"));
		System.out.println();
		System.out.println(findLivre("11111"));


		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion à la BDD réussie !");


		// ResultSet résultats;


		// String requete = "INSERT INTO LIVRE VALUES (111111,'MonLivre', 40, null, null)";
		String requete;
		Statement stmt = conn.createStatement();

		/*
		stmt.executeUpdate(requete);
		System.out.println("Livre ajouté !");

		ResultSet afficherLivres;
		requete = "SELECT * FROM LIVRE";
		afficherLivres= stmt.executeQuery(requete);

		while (afficherLivres.next()) {
			System.out.println(afficherLivres.getLong(1) + " : " + afficherLivres.getString(2) + " - " + afficherLivres.getFloat(3));
		}
		 */

		ResultSet auteurToList;
		requete = "SELECT * FROM AUTEUR";
		auteurToList = stmt.executeQuery(requete);

		while (auteurToList.next()) {
			String num = auteurToList.getString("num");
			String nom = auteurToList.getString("nom");
			String prenom = auteurToList.getString("prenom");
			String date_naissance = auteurToList.getString("date_naissance");
			String description =auteurToList.getString("description");


			AUTEUR auteur = new AUTEUR(num, nom, prenom, date_naissance, description);
			AuteursBDD.add(auteur);

		}

		ResultSet adherentToList;
		requete = "SELECT * FROM ADHERENT";
		adherentToList = stmt.executeQuery(requete);

		while (adherentToList.next()) {
			String num = adherentToList.getString("num");
			String nom = adherentToList.getString("nom");
			String prenom = adherentToList.getString("prenom");
			String email = adherentToList.getString("email");

			ADHERENT adherent = new ADHERENT(num, nom, prenom, email, null);
			AdherentsBDD.add(adherent);

		}
	}

	public static ADHERENT findAdherent(String num) {
		for (int i = 0; i < LesAdherents.size(); i++) {
			if (num.equals(LesAdherents.get(i).getNum())) {
				return LesAdherents.get(i);
			}
		}
		return null; // Je mets null si y'a rien
	}

	public static AUTEUR findAuteur (String num) {
		for (int i = 0; i < LesAuteurs.size(); i++) {
			if (num.equals(LesAuteurs.get(i).getNum())) {
				return LesAuteurs.get(i);
			}
		}
		return null; // Je mets null si y'a rien
	}

	public static LIVRE findLivre (String ISBN) {
		for (int i = 0; i < LesLivres.size(); i++) {
			if (ISBN.equals(LesLivres.get(i).getISBN())) {
				return LesLivres.get(i);
			}
		}
		return null; // Je mets null si y'a rien
	}
}
