package Models;

import java.util.List;

import Beans.Membre;
import Beans.Vehicule;
import Dao.AbstractDAOFactory;
import Dao.CathegorieDao;
import Dao.MembreDao;

public class MembreModel {
	private  AbstractDAOFactory fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private  MembreDao d = fact.getMembreDao();
	private CathegorieDao cat = fact.getCathegorieDao();
	
	public int create(String nom,String prenom,String tel,String adresse,String login,String pass,List<String> listChoixCath) {
		int res=-1;
		if(nom.equals("") || login.equals("") || pass.equals(""))
			res= 1;
		else {
			Membre m = new Membre();
			m.setNom(nom);
			m.setPrenom(prenom);
			m.setTel(tel);
			m.setAdresse(adresse);
			m.setLogin(login);
			m.setPass(pass);
			if(d.create(m)) {
				m=findLogin(login, pass);// recuperation de l'id
				if(cat.inserCath(m, listChoixCath))
					res=0;
				else {
					// suppression du memebre crée
				}
			}
			else 
				res=-1;
		}
		return res;
			
	}
	public boolean delete(Membre m) {return d.delete(m);}
	public List<Membre> getList(){ return  d.findAll();}
	public List<Membre> getListNewMem(){ return  d.findNewMem();}
	public Membre findLogin(String login, String password) {return d.findLogin(login, password);	}
	public Membre findId(int id) {return d.find(id);}
	public boolean update(Membre mem) {return d.update(mem);}
	public List<Membre> findMemVeh(Vehicule veh){return d.findMemVeh(veh);}
	public Membre findProprioVeh(Vehicule vehicule) {return d.findProprioVeh(vehicule);}

}
