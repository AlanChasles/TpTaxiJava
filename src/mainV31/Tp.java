package mainV31;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Tp {


	public static void retour(){
		System.out.print("\n");

	}

	public static void main(String[] args) {
		
		
		
		String ligne;
		
		double res;
		List<Tarifs> maListe = new ArrayList<Tarifs>();
		
		try{
			FileReader flux = new FileReader("P:/SLAM4 TP 04092015/tpTaxi/src/mainV31/tarifs.txt");
			BufferedReader reader = new BufferedReader(flux);
			while((ligne=reader.readLine()) != null){
				
				
				String tab[]=ligne.split(",");
				
				maListe.add(new Tarifs(Double.parseDouble(tab[0]),Double.parseDouble(tab[1]),Double.parseDouble(tab[2]),Double.parseDouble(tab[3]),Double.parseDouble(tab[4]),Double.parseDouble(tab[5])));
				
				if(ligne.equals(null))
					reader.close();
				
			}
			
			}
		
		catch(IOException e){
			
			System.out.println(e.getMessage());
			
		}
		
		
		
		
		Saisie var = new Saisie(Calcul.saisieDept(maListe),Calcul.saisieNbKm(),Calcul.saisieJour(),Calcul.saisiehoraire());
		
		

		res = Calcul.calcul(maListe, var);
		System.out.print("Le prix à payer est : ");
		System.out.printf("%.2f",res);
		

	}

}
