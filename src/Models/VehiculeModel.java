package Models;


import java.util.List;

import Beans.Balade;
import Beans.Membre;
import Beans.Vehicule;
import Dao.AbstractDAOFactory;
import Dao.VehiculeDao;

public class VehiculeModel {

	
	private  AbstractDAOFactory fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private VehiculeDao d = fact.getVehiculeDao();
	
	
	public int create(String numero, int nombreDePlace, int nombreDeVelo,Balade bal, Membre mem) {
		int res;
		Vehicule v = new Vehicule();
		v.setNumero(numero);
		v.setNombreDePlace(nombreDePlace);
		v.setNombreDeVelo(nombreDeVelo);
		v.setBalade(bal);
		v.setProprietaireVehicule(mem);
		
		if(d.create(v))
			res=0;
		else
			res=-1;
		return res;
	}
	public boolean update(Vehicule vehicule) {return d.update(vehicule);}
	
	public List<Vehicule> findVehiculeBalade(Balade bal){return d.findVehiculeBalade(bal);}
	
	private boolean testReservationVehicule(Vehicule veh, Membre mem) {return d.testReservatoin(veh, mem);}
	
	public boolean testReservationBalade(Balade bal, Membre membre) {
		boolean res = false;
		List<Vehicule> listVeh = findVehiculeBalade(bal);
		int n = listVeh.size();
		int i=0;
		while(!res && i<n) {
			res=this.testReservationVehicule(listVeh.get(i), membre);
			i++;
		}
		return res;
	}
	
	public Vehicule vehiculeBalade(Balade bal) {
		Vehicule veh = null;
		List<Vehicule> list = findVehiculeBalade(bal);
		int test = 1000000;
		if(list.size()>0)
			for(Vehicule v : list) {
				int nbr = d.nombreReservationParVehicule(v);
				if(nbr<test && nbr <v.getNombreDePlace()) {
					veh=v;
					test=nbr;
				}
			}
		return veh;
	}

	public int InsertReservation(Vehicule veh, Membre mem) {return d.InsertReservation(veh, mem);}
}
