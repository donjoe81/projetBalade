package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Beans.Tresorier;

public class TresorierDao extends DAO<Tresorier> {

	public TresorierDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Tresorier obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Tresorier obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Tresorier obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tresorier find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tresorier> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//FINI
	/****************************************************************************/
	public Tresorier findLogin(String login, String password) {
		Tresorier t = null;
		 try {
		    	String req="SELECT * FROM Tresorier WHERE log_tre = '" + login + "' AND pas_tre = '" +password+"'";
		    	ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		    	if(result.first()) {
		    		 t = new Tresorier();
			    	 t.setId(result.getInt("id_tre"));
			    	 t.setNom(result.getString("nom_tre"));
			    	 t.setPrenom(result.getString("prenom_tre")); 
			    	 t.setTel(result.getString("tel_tre"));
			    	 t.setAdresse(result.getString("adresse_tre"));
			    	 t.setLogin(result.getString("log_tre"));
			    	 t.setPass(result.getString("pas_tre"));
		    	}
		      } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return t;
	}

}
