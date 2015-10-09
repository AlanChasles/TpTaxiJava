package mainV32;

public class Tarifs {
	/** 
	 *@attributs Ces attributs correspondent aux informations de la grille de tarifs
	 * Ils permettront de calculer le prix d'un voyage en France.
	 */
	private double dept,priseEnCharge,tarifKmSemaine,tarifHoraireSemaine,tarifKmDimanche,tarifHoraireDimanche;
	
	public double getDept(){
		return dept;
		
	}
	
	public void setDept(double dept){
		this.dept = dept;
		
	}
	public double getPriseEnCharge(){
		return priseEnCharge;
		
	}
	
	public void setPriseEnCharge(double pec){
		this.priseEnCharge = pec;
		
	}
	public double getTarifKmSemaine(){
		return tarifKmSemaine;
		
	}
	
	public void setTarifKmSemaine(double t){
		this.tarifKmSemaine = t;
		
	}
	public double getTarifHoraireSemaine(){
		return tarifHoraireSemaine;
		
	}
	
	public void setTarifHoraireSemaine(double t){
		this.tarifHoraireSemaine = t;
		
	}
	public double getTarifHoraireDimanche(){
		return tarifHoraireDimanche;
		
	}
	
	public void setTarifHoraireDimanche(double t){
		this.tarifHoraireDimanche = t;
		
	}
	public double getTarifKmDimanche(){
		return tarifKmDimanche;
		
	}
	
	public void setTarifKmDimanche(double t){
		this.tarifKmDimanche = t;
		
	}
	
	
	public Tarifs(){}
	
	public Tarifs(double dept,double priseEnCharge, double tarifKmSemaine, double tarifHoraireSemaine, double tarifKmDimanche, double tarifHoraireDimanche){
		this.dept = dept;
		this.priseEnCharge = priseEnCharge;
		this.tarifKmSemaine =tarifKmSemaine;
		this.tarifHoraireSemaine = tarifHoraireSemaine;
		this.tarifKmDimanche = tarifKmDimanche;
		this.tarifHoraireDimanche = tarifHoraireDimanche;
		
	}

	
	
}
