package mainV5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mainV5.Tarifs;

public class BDD {
	static List<Tarifs> maListe = new ArrayList<Tarifs>();
	public static List<Tarifs> coBdd(){
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
	return maListe;
}}
