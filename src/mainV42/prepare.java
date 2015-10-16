package mainV42;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class prepare {
	static private Scanner saisie = new Scanner(System.in);
	public static String choix(){
		String s= "";
		do{
			System.out.print("Voulez-vous modifier ou calculer un tarif ? ( répondre par 'modifier' ou 'calculer') :");
			try{
				s = saisie.next();
			}
			catch(Exception e){
				String S = saisie.next();
				System.out.println("Le type de données saisie n'est pas celui attendu");

			}
		}while(s.equalsIgnoreCase("modifier") && s.equalsIgnoreCase("calculer"));
		return s;

	}
	
	public static int dept(List<Tarifs> liste){
		
		boolean bool = false;
		int i = 0;


		while(bool == false){
			
			System.out.print("Les tarifs de quel département voulez vous modifier ? ( saisir le numéro ) : ");
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
				System.out.println("Le type de données saisie n'est pas celui attendu ou ne figure pas dans la liste de départements");

			}	
			
		}
		return i;
	}
	public static String[] champs(){
		String tab[] = new String[5];
		
		System.out.print("Voulez-vous modifier le tarif de la prise en charge ? ( 'oui' ou 'non' )");
		tab[0]=saisie.next();
		if(tab[0] == "oui")
			tab[0]="pec";
		
		
		System.out.print("Voulez-vous modifier le tarif du km en semaine ? ( 'oui' ou 'non' )");
		tab[1]=saisie.next();
		if(tab[1] == "oui")
			tab[1]="tarifkmsemaine";
		
		
		System.out.print("Voulez-vous modifier le tarif horaire semaine ? ( 'oui' ou 'non' )");
		tab[2]=saisie.next();
		if(tab[2] == "oui")
			tab[2]="tarifhorairesemaine";
		
		
		System.out.print("Voulez-vous modifier le tarif du km le dimanche ? ( 'oui' ou 'non' )");
		tab[3]=saisie.next();
		if(tab[3] == "oui")
			tab[3]="tarifkmdimanche";
		
		
		System.out.print("Voulez-vous modifier le tarif horaire du dimanche ? ( 'oui' ou 'non' )");
		tab[4]=saisie.next();
		if(tab[4] == "oui")
			tab[4]="tarifhorairedimanche";
		
		return tab;
		
	}
	
	
	


	public static String requeteUpdate(int dept,String tab[]){
		String req="UPDATE departement SET ";

		for(int i = 0; i<tab.length; i++){
			
			if(tab[i].equalsIgnoreCase("non")){
				
				if(tab[i+1]!=null && tab[i].equalsIgnoreCase("non"))
					req+=tab[i]+"=?,";
				
				else req+=tab[i]+"=?" + "WHERE dept="+dept+";";
			}


		}

		return req;

	}
	
	public static List<Double> newValeurs(String tab[]){
		List<Double> liste = new ArrayList(){};
		double a = 0;
		for(int i=0;i<tab.length;i++){
			if(tab[i].equalsIgnoreCase("non")){
				try{
				System.out.print("Quelle valeur voulez vous mettre pour le champs "+tab[i]+" ? :");
				a = saisie.nextDouble();
				liste.add(a);
				}
				
				catch(Exception e){
				String S = saisie.next();
				System.out.println(e.getMessage());
					
				}
				
			}
			
		}
		return liste;
	}

}
