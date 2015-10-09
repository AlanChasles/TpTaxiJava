package mainV2;

import java.util.List;
import java.util.ArrayList;


public class Tp {

	

	public static void main(String[] args) {
		double res;
		double tab[][] = {
		{21,2,1.72,21.93,1.29,21.93},
		{25,2.1,1.66,22.5,1.2,22.5},
		{39,2.1,1.66,22.5,1.23,25},
		{44,2.2,1.58,24.19,1.19,24.19},
		{72,2.15,1.58,22.86,1.19,22.86},
		{73,2.4,1.68,25.4,1.26,25.4},
		{74,3.15,1.84,17.3,1.38,17.3},
		{75,2.5,1.24,0,1.5,0},
		{85,2.3,1.6,22.2,1.2,22.2},
		{90,2.2,1.66,21,1.15,21}
		
		};
		
		
		List<Tarifs> maListe = new ArrayList<Tarifs>();
		for(int i=0;i<10;i++){
		maListe.add(new Tarifs(tab[i][0],tab[i][1],tab[i][2],tab[i][3],tab[i][4],tab[i][5]));
		}
		
		Saisie var = new Saisie(Calcul.saisieDept(maListe),Calcul.saisieNbKm(),Calcul.saisieJour(),Calcul.saisiehoraire());
		
		res = Calcul.calcul(maListe, var);
		System.out.print("Le prix à payer est : ");
		System.out.printf("%.2f",res);
		

	}

}
