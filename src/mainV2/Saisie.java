package mainV2;

public class Saisie {
	private double dept,km;
	private String jour;
	private int dur�e;
	
	public double getDept(){
		return dept;		
	}
	
	public double getKm(){
		return km;		
	}
	
	public String getJour(){
		return jour;		
	}
	
	public double getDur�e(){
		return dur�e;		
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
	
	public void setDept(int dur�e){
		this.dur�e=dur�e;
	}
	
	public Saisie(){}
	
	public Saisie(double dept, double km, String jour, int dur�e){
		this.dept=dept;
		this.km = km;
		this.jour = jour;
		this.dur�e=dur�e;
		
	}
}
