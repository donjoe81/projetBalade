package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Beans.Responsable;

public class ResponsableDao extends DAO<Responsable> {

	public ResponsableDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Responsable obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Responsable r) {
	  boolean res = false;
		try {
			Statement stmt = connect.createStatement();
			String req = "delete from Responsable where id_res =  "+r.getId();
			stmt.executeUpdate(req);
			res=true;
		} catch (SQLException ex){
			System.out.println(ex.toString());
		}
	  return res;
	}

	@Override
	public boolean update(Responsable obj) {
		// TODO Auto-generated method stub
		return false;
	}
	/********************************************************************************/
	@Override
	public Responsable find(int id) {
		Responsable r = null;
		 try {
		    	String req="SELECT * FROM Resposanble WHERE id_res = '" + id+"'";
		    	ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		    	if(result.first()) {
		    		 r = new Responsable();
		    	 	 r.setId(result.getInt("id_res"));
			    	 r.setNom(result.getString("nom_res"));
			    	 r.setPrenom(result.getString("prenom_res")); 
			    	 r.setTel(result.getString("tel_res"));
			    	 r.setAdresse(result.getString("adresse_res"));
			    	 r.setLogin(result.getString("log_res"));
			    	 r.setPass(result.getString("pas_res"));
		    	}
		      } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return r;
	}
	/********************************************************************************************/
	@Override
	public List<Responsable> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	/***************************************************************************************/
	 public Responsable findLogin(String login,String password){
		 Responsable r = null;
		 try {
		    	String req="SELECT * FROM Responsable WHERE log_res = '" + login + "' AND pas_res = '" +password+"'";
		    	ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		    	if(result.first()) {
		    		 r = new Responsable();
		    		 r.setId(result.getInt("id_res"));
			    	 r.setNom(result.getString("nom_res"));
			    	 r.setPrenom(result.getString("prenom_res")); 
			    	 r.setTel(result.getString("tel_res"));
			    	 r.setAdresse(result.getString("adresse_res"));
			    	 r.setLogin(result.getString("log_res"));
			    	 r.setPass(result.getString("pas_res"));
		    	}
		      } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return r;
	  }

}
