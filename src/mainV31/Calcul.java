package mainV31;

import java.util.List;
import java.util.Scanner;

public class Calcul {
	
	static private Scanner saisie = new Scanner(System.in);
	
	/**
	 * 
	 * @param liste
	 * Une liste d'objets contenant toute la grille de tarifs.
	 * @return
	 * Retourne un entier que l'utilisateur saisie.
	 * 
	 * La fonction saisieDept() permet la saisie d'un num�ro de d�partement tout en s'assurant qu'il fait bien partie de la liste.
	 * 
	 */
	public static double saisieDept(List<Tarifs> liste){
		boolean bool = false;
		int i = 0;


		while(bool == false){
			System.out.print("Dans quel d�partement le d�placement a-t-il eu lieu ? ( saisir le num�ro ) : ");
			try{
				i = saisie.nextInt();
				
				for(int j=0; j<=liste.size(); j++){
					
					if(i == liste.get(j).getDept()){
						bool = true;
						break;

					}
					
				}

			}
			catch(Exception e){
				String s = saisie.next();
				System.out.println("Le type de donn�es saisie n'est pas celui attendu ou ne figure pas dans la liste de d�partements");

			}	
		}
		return i;
		
	}
	
	/**
	 * @return
	 * Retourne une cha�ne de caract�res que l'utilisateur saisie.
	 * 
	 * La fonction saisiejour() permet de savoir si le client a voyag� en semaine ou un dimanche.
	 * 
	 */
	public static String saisieJour(){
		String s= "";
		do{
			System.out.print("Le voyage s'est-il d�roul� en semaine ou un dimanche ? ( saisir 'semaine' ou 'dimanche') :");
			try{
			s = saisie.next();
			}
			catch(Exception e){
				String S = saisie.next();
				System.out.println("Le type de donn�es saisie n'est pas celui attendu");
				
			}
			}while(s.equalsIgnoreCase("semaine") && s.equalsIgnoreCase("dimanche"));
		return s;
		
	}
	
	/**
	 * 
	 * 
	 * @return 
	 * Retourne un d�cimal long que l'utilisateur saisie.
	 * 
	 * Cette fonction permet la saisie du nombre de kilmom�tres parcourus durant le voyage.
	 */
	public static double saisieNbKm(){
		double d=0;
		do{
			System.out.print("Combien de km ont �t� parcourus ? :");
			d = saisie.nextInt();
		}while(d==0);
		return d;
	}
	
	
	/**
	 * 
	 * 
	 * @return 
	 * Retourne un entier que l'utilisateur saisie.
	 * 
	 * Cette fonction permet la saisie de la dur�e du voyage en minutes.
	 */
	public static int saisiehoraire(){
		int d = 0;

		System.out.print("Combien de temps a dur� le trajet ? (minutes):");
		d = saisie.nextInt()/60;

		return d;
	}
	
	
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
