package mainV4;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import mainV42.prepare;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Tp {


	public static void retour(){
		System.out.print("\n");

	}

	public static void main(String[] args) throws ClassNotFoundException{
		List<Tarifs> maListe = new ArrayList<Tarifs>();
		List<Tarifs> liste2 = new ArrayList<Tarifs>();
		Scanner saisie = new Scanner(System.in);
		String rep;
		rep = prepare.choix();
		
		if(rep.equals("calculer")){

		try{
			Class.forName("org.postgresql.Driver");
			Connection maConnexion = DriverManager.getConnection("jdbc:postgresql://172.16.99.2:5432/achasles","useralan","passe");
			Statement requete = maConnexion.createStatement();

			String texteRequete= "select * from slam4taxi.departement";

			ResultSet curseurResultat = requete.executeQuery(texteRequete);

			ResultSetMetaData data = curseurResultat.getMetaData();

			
			for(int i = 0;i<=data.getColumnCount();i++){

				while(curseurResultat.next()){
					maListe.add(new Tarifs(Double.parseDouble(curseurResultat.getString("dept")),Double.parseDouble(curseurResultat.getString("pec")),Double.parseDouble(curseurResultat.getString("tarifKmSemaine")),Double.parseDouble(curseurResultat.getString("tarifHoraireSemaine")),Double.parseDouble(curseurResultat.getString("tarifKmDimanche")),Double.parseDouble(curseurResultat.getString("tarifHoraireDimanche"))));
				}

			}

			curseurResultat.close();
			requete.close();
		}

		catch(Exception e){

			System.out.println(e.getMessage());
		}



		//maListe.add(new Tarifs(Double.parseDouble(dept.getTextContent()),Double.parseDouble(pec.getTextContent()),Double.parseDouble(tarifKmSemaine.getTextContent()),Double.parseDouble(tarifHoraireSemaine.getTextContent()),Double.parseDouble(tarifKmDimanche.getTextContent()),Double.parseDouble(tarifHoraireDimanche.getTextContent())));






		Saisie var = new Saisie(Calcul.saisieDept(maListe),Calcul.saisieNbKm(),Calcul.saisieJour(),Calcul.saisiehoraire());

		double res;

		res = Calcul.calcul(maListe, var);
		System.out.print("Le prix à payer est : ");
		System.out.printf("%.2f",res);

		}
		
		else{
			
			try{
				Class.forName("org.postgresql.Driver");
				Connection maConnexion = DriverManager.getConnection("jdbc:postgresql://172.16.99.2:5432/achasles","useralan","passe");
				Statement requete = maConnexion.createStatement();

				String texteRequete= "select * from slam4taxi.departement";

				ResultSet curseurResultat = requete.executeQuery(texteRequete);

				ResultSetMetaData data = curseurResultat.getMetaData();

				
				for(int i = 0;i<=data.getColumnCount();i++){

					while(curseurResultat.next()){
						maListe.add(new Tarifs(Double.parseDouble(curseurResultat.getString("dept")),Double.parseDouble(curseurResultat.getString("pec")),Double.parseDouble(curseurResultat.getString("tarifKmSemaine")),Double.parseDouble(curseurResultat.getString("tarifHoraireSemaine")),Double.parseDouble(curseurResultat.getString("tarifKmDimanche")),Double.parseDouble(curseurResultat.getString("tarifHoraireDimanche"))));
					}

				}

				curseurResultat.close();
				requete.close();
			}

			catch(Exception e){

				System.out.println(e.getMessage());
			}
			
		}
	}

}
