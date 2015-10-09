package mainV1;

import java.util.Scanner;



public class Tp {
	static private Scanner saisie = new Scanner(System.in);
	
	public static double saisieDept(double tab[][]){
		boolean bool = false;
		double i = 0;


			while(bool == false){
				System.out.print("Dans quel département le déplacement a-t-il eu lieu ? ( saisir le numéro ) : ");
				i=saisie.nextDouble();
				for(int j=0;j<10;j++){
					if(i==tab[j][0]){
						bool = true;
						break;
					
					}
				
			}
			}
			return i;
		}
	
	public static String saisieJour(){
		String s= "";
		do{
			System.out.print("Le voyage s'est-il déroulé en semaine ou un dimanche ? ( saisir 'semaine' ou 'dimanche') :");
			s = saisie.next();
			
			}while(s.equalsIgnoreCase("semaine") && s.equalsIgnoreCase("dimanche"));
		return s;
		
	}
	
	public static double saisieNbKm(){
		double d=0;
		do{
			System.out.print("Combien de km ont été parcourus ? :");
			d = saisie.nextInt();
		}while(d==0);
		return d;
	}
	
	public static int saisiehoraire(){
		int d = 0;

		System.out.print("Combien de temps a duré le trajet ? (minutes):");
		d = saisie.nextInt()/60;

		return d;
	}
	
	public static double calcul(double tab[][],double dept,String jour,double km, double duree){
		double res=0;
		for(int i=0;i<10;i++){

			if(tab[i][0] == dept){

				if(jour.equals("semaine")){

					res = tab[i][1] + (km*tab[i][2]);

					if(duree > 0){
						res += (duree * tab[i][3]);
					}

				}
				else {
					res = tab[i][1] + (km*tab[i][4]);
					
					if(duree > 0){
						res += (duree*tab[i][5]);
					}

				}

				break;	
			}

		}
		return res;

	}
		
		
	

	public static void retour(){
		System.out.print("\n");

	}

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
		
		
		double dept=saisieDept(tab);
		String jour = saisieJour();
		double km = saisieNbKm();
		double duree = saisiehoraire();
		
		res = calcul(tab,dept,jour,km,duree);
		System.out.print("Le prix à payer est : ");
		System.out.printf("%.2f",res);
		

	}

}
