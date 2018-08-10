
package Beans;

import java.util.List;

public class Balade {
	public static String adresseClub = "adresse du club";
	private int id;
	private String lieuDepart ;
	private String dateDepart;
	private double forfait;
	private String descriptif;
	
	private Responsable reponsable; 
	private List<Vehicule> listVehicule;
	
	public String getLieuDepart() {
		return lieuDepart;
	}
	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}
	public String getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "lieu depart : "+this.getLieuDepart() +System.getProperty("line.separator")+"; date de depart : "+this.dateDepart+System.getProperty("line.separator")+"; forfait : "+this.forfait;
	}
	public double getForfait() {
		return forfait;
	}
	public void setForfait(double forfait) {
		this.forfait = forfait;
	}

	public Responsable getReponsable() {
		return reponsable;
	}
	public void setReponsable(Responsable reponsable) {
		this.reponsable = reponsable;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public static String getAdresseClub() {
		return adresseClub;
	}
	public static void setAdresseClub(String adresseClub) {
		Balade.adresseClub = adresseClub;
	}
	public List<Vehicule> getListVehicule() {
		return listVehicule;
	}
	public void setListVehicule(List<Vehicule> listVehicule) {
		this.listVehicule = listVehicule;
	}
}
