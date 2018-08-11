package Models;

import Beans.Tresorier;
import Dao.AbstractDAOFactory;
import Dao.TresorierDao;

public class TresorierModel {
	private  AbstractDAOFactory fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private TresorierDao tre = fact.getTresorierDao();
	
	public Tresorier findLogin(String login, String password) {
		return tre.findLogin(login, password);
	}
}
