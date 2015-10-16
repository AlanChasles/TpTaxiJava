package mainV5;

import java.util.List;
import java.util.Scanner;

public class Calcul {
	

	
	/**
	 * 
	 * @param liste
	 * Correspond � la liste des tarifs en fonction des d�partements.
	 * @param dept
	 * Correspond au d�partement saisi par l'utilisateur.
	 * @param jour
	 * Correspond au jour de la semaine.
	 * @param km
	 * Correspond au nombre de kilom�tres saisi par l'utilisateur.
	 * @param duree
	 * Correspond � la dur�e du voyage saisie par l'utilisateur.
	 * @return
	 * Retourne le prix que le client devra payer.
	 */
	public static double calcul(List<Tarifs> liste,Saisie var){
		double res=0;
		for(int i=0;i<liste.size();i++){

			if(liste.get(i).getDept() == var.getDept()){

				if(var.getJour().equals("semaine")){

					res = liste.get(i).getPriseEnCharge() + (var.getKm()*liste.get(i).getTarifKmSemaine());

					if(var.getDur�e() > 0){
						res += (var.getDur�e() * liste.get(i).getTarifHoraireSemaine());
					}

				}
				else {
					res = liste.get(i).getPriseEnCharge() + (var.getKm()*liste.get(i).getTarifKmDimanche());
					
					if(var.getDur�e() > 0){
						res += (var.getDur�e()*liste.get(i).getTarifHoraireDimanche());
					}

				}

				break;	
			}

		}
		return res;

	}
	
}
