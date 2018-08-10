package Beans;

public class Vehicule {

	private int id;
	private String numero;
	private int nombreDePlace;
	private int nombreDeVelo;
	private String payer;
	
	private Membre proprietaireVehicule;
	private Balade balade;
	
	//private List<Membre> listeMembre = null;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getNombreDePlace() {
		return nombreDePlace;
	}
	public void setNombreDePlace(int nombreDePlace) {
		this.nombreDePlace = nombreDePlace;
	}
	public int getNombreDeVelo() {
		return nombreDeVelo;
	}
	public void setNombreDeVelo(int nombreDeVelo) {
		this.nombreDeVelo = nombreDeVelo;
	}
	public Membre getProprietaireVehicule() {
		return proprietaireVehicule;
	}
	public void setProprietaireVehicule(Membre proprietaireVehicule) {
		this.proprietaireVehicule = proprietaireVehicule;
	}
	public Balade getBalade() {
		return balade;
	}
	public void setBalade(Balade balade) {
		this.balade = balade;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	
	public String toString() {return "numero : "+this.numero + "; nombre de place : "+this.nombreDePlace; }
}
