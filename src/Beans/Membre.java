package Beans;

public class Membre extends Personne {
	private String payer; 
	public Membre() { super();}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}

}
