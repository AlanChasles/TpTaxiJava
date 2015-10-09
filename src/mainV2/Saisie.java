package mainV2;

public class Saisie {
	private double dept,km;
	private String jour;
	private int durée;
	
	public double getDept(){
		return dept;		
	}
	
	public double getKm(){
		return km;		
	}
	
	public String getJour(){
		return jour;		
	}
	
	public double getDurée(){
		return durée;		
	}
	
	public void setDept(double dept){
		this.dept=dept;
	}
	
	public void setKm(double km){
		this.km=km;
	}
	
	public void setJour(String jour){
		this.jour= jour;
	}
	
	public void setDept(int durée){
		this.durée=durée;
	}
	
	public Saisie(){}
	
	public Saisie(double dept, double km, String jour, int durée){
		this.dept=dept;
		this.km = km;
		this.jour = jour;
		this.durée=durée;
		
	}
}
