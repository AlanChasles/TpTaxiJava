package mainV5;

import java.util.List;
import java.util.Scanner;

public class Calcul {
	

	
	/**
	 * 
	 * @param liste
	 * Correspond à la liste des tarifs en fonction des départements.
	 * @param dept
	 * Correspond au département saisi par l'utilisateur.
	 * @param jour
	 * Correspond au jour de la semaine.
	 * @param km
	 * Correspond au nombre de kilomètres saisi par l'utilisateur.
	 * @param duree
	 * Correspond à la durée du voyage saisie par l'utilisateur.
	 * @return
	 * Retourne le prix que le client devra payer.
	 */
	public static double calcul(List<Tarifs> liste,Saisie var){
		double res=0;
		for(int i=0;i<liste.size();i++){

			if(liste.get(i).getDept() == var.getDept()){

				if(var.getJour().equals("semaine")){

					res = liste.get(i).getPriseEnCharge() + (var.getKm()*liste.get(i).getTarifKmSemaine());

					if(var.getDurée() > 0){
						res += (var.getDurée() * liste.get(i).getTarifHoraireSemaine());
					}

				}
				else {
					res = liste.get(i).getPriseEnCharge() + (var.getKm()*liste.get(i).getTarifKmDimanche());
					
					if(var.getDurée() > 0){
						res += (var.getDurée()*liste.get(i).getTarifHoraireDimanche());
					}

				}

				break;	
			}

		}
		return res;

	}
	
}
