package Models;

import java.util.List;

import Beans.Balade;
import Beans.Responsable;
import Dao.AbstractDAOFactory;
import Dao.ResponsableDao;

public class ResponsableModel {
	private  AbstractDAOFactory fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private ResponsableDao res = fact.getResponsableDao();
	private List<Balade> listBalade = null;
	
	public Responsable findLogin(String login, String password) {
		return res.findLogin(login, password);
	}

	public List<Balade> getListBalade() {
		return listBalade;
	}

	public void setListBalade(List<Balade> listBalade) {
		this.listBalade = listBalade;
	}

}
