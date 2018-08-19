package Models;

import java.util.List;

import Beans.Balade;
import Beans.Membre;
import Beans.Responsable;
import Dao.AbstractDAOFactory;
import Dao.BaladeDao;

public class BaladeModel {
	private  AbstractDAOFactory fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private BaladeDao bal = fact.getBaladeDao();
	
	public int create (String lieu, String date,double forfait, String descriptif, Responsable responsable) {
		int res;
		if(date.equals(""))
			res=1;
		else {
			Balade b = new Balade();
			b.setLieuDepart(lieu);
			b.setDateDepart(date);
			b.setForfait(forfait);
			b.setDescriptif(descriptif);
			b.setReponsable(responsable);
			if(bal.create(b))
				res=0;
			else
				res=-1;
		}
		return res;
	}
	public Balade findId(int id) {return bal.find(id);}
	public List<Balade> findAll(){return bal.findAll();}
	public List<Balade> findBaladeMembre(Membre membre){return bal.findBaladeMembre(membre);}
	public List<Balade> findBaladeResponsable(Responsable responsable){return bal.findBaladeResponsable(responsable);}
}
