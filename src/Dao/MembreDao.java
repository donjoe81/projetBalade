package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Membre;
import Beans.Vehicule;

public class MembreDao  extends DAO<Membre> {
	
	public MembreDao(Connection connect){
 		super(connect);
 	}
	//FINI
	/*********************************************************************************/
	@Override
	public boolean create(Membre m) {
		boolean res=false;
		if(this.findLogin(m.getLogin(), m.getPass())==null) {
			try {
				Statement stmt = connect.createStatement();
				String req = "insert into Membre(nom_mem,prenom_mem,tel_mem,adresse_mem,log_mem,pas_mem) "
				+ "values('"+m.getNom()+"','"+m.getPrenom() +"','"+m.getTel()+"','"+m.getAdresse()+"','"+m.getLogin()+"','"+m.getPass()+"')";
				
				stmt.executeUpdate(req);
				res=true;
			} catch (SQLException ex){
				System.out.println(ex.toString());
			}
		}
		return res;
	}
	//FINI
	/*********************************************************************************/
	@Override
	public boolean delete(Membre m) {
		  boolean res = false;
				try {
					Statement stmt = connect.createStatement();
					String req = "delete from Membre where id_mem =  "+m.getId();
					stmt.executeUpdate(req);
					res=true;
				} catch (SQLException ex){
					System.out.println(ex.toString());
				}
			  return res;
	}

	@Override
	public boolean update(Membre obj) {
		boolean res =false;
		try {
			Statement stmt = connect.createStatement();
			String req ="UPDATE Membre SET payer = 'true' where id_mem = "+obj.getId();
			stmt.executeUpdate(req);
			res=true;
		} catch (SQLException ex){
			System.out.println(ex.toString());
		}
		return res;
	}
	//FINI
/**********************************************************************************/
	@Override
	public Membre find(int id) {
		 Membre m = null;
		 try {
		    	String req="SELECT * FROM Membre WHERE id_mem = '" + id+"'";
		    	ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		    	if(result.first()) {
		    		 m = new Membre();
		    	 	 m.setId(result.getInt("id_mem"));
			    	 m.setNom(result.getString("nom_mem"));
			    	 m.setPrenom(result.getString("prenom_mem")); 
			    	 m.setTel(result.getString("tel_mem"));
			    	 m.setAdresse(result.getString("adresse_mem"));
			    	 m.setLogin(result.getString("log_mem"));
			    	 m.setPass(result.getString("pas_mem"));
			    	 m.setPayer(result.getString("payer"));
		    	}
		      } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return m;
	}
	
	//FINI
	/*********************************************************************************/
	 public Membre findLogin(String login,String password){
		 Membre m = null;
		 try {
		    	String req="SELECT * FROM Membre WHERE log_mem = '" + login + "' AND pas_mem = '" +password+"'";
		    	ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		    	if(result.first()) {
		    		 m = new Membre();
			    	 m.setId(result.getInt("id_mem"));
			    	 m.setNom(result.getString("nom_mem"));
			    	 m.setPrenom(result.getString("prenom_mem")); 
			    	 m.setTel(result.getString("tel_mem"));
			    	 m.setAdresse(result.getString("adresse_mem"));
			    	 m.setLogin(result.getString("log_mem"));
			    	 m.setPass(result.getString("pas_mem"));
			    	 m.setPayer(result.getString("payer"));
		    	}
		      } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return m;
	  }
	 //FINI
	/*********************************************************************************/
	@Override
	public List<Membre> findAll() {
		 ArrayList<Membre> liste = new ArrayList<Membre>();    
		    try {
		    	String s ="SELECT * FROM Membre"; 
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
		      while(result.next()){
		    	 Membre m = new Membre();
		    	 m.setId(result.getInt("id_mem"));
		    	 m.setNom(result.getString("nom_mem"));
		    	 m.setPrenom(result.getString("prenom_mem"));
		    	 liste.add(m);
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return liste;
	}
	/*************************************************************************************/
	
	public List<Membre> findNewMem() {
		 ArrayList<Membre> liste = new ArrayList<Membre>();    
		    try {
		    	String s ="SELECT * FROM Membre where payer = 'false'"; 
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
		      while(result.next()){
		    	 Membre m = new Membre();
		    	 m.setId(result.getInt("id_mem"));
		    	 m.setNom(result.getString("nom_mem"));
		    	 m.setPrenom(result.getString("prenom_mem"));
		    	 liste.add(m);
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return liste;
	}
	
	/************************************************************************************/
	public List<Membre> findMemVeh(Vehicule vehicule) {
		 ArrayList<Membre> liste = new ArrayList<Membre>();    
		    try {
		    	String s ="SELECT * FROM Membre inner join ligne_detail_membre_vehicule on id_mem_sec = id_mem where"
		    			+ " id_veh_sec = "+vehicule.getId()+";"; 
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
		      while(result.next()){
		    	 Membre m = new Membre();
		    	 m.setId(result.getInt("id_mem"));
		    	 m.setNom(result.getString("nom_mem"));
		    	 m.setPrenom(result.getString("prenom_mem"));
		    	 liste.add(m);
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return liste;
	}
	/************************************************************************************/
	public Membre findProprioVeh(Vehicule vehicule) {
		 	Membre mem = null;    
		    try {
		    	String s ="SELECT * FROM Membre inner join Vehicule on id_mem_sec = id_mem where"
		    			+ " id_veh = "+vehicule.getId()+";"; 
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
		      if(result.first()){
		    	 mem = new Membre();
		    	 mem.setId(result.getInt("id_mem"));
		    	 mem.setNom(result.getString("nom_mem"));
		    	 mem.setPrenom(result.getString("prenom_mem"));
		    	 mem.setAdresse(result.getString("adresse_mem"));
		    	 
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return mem;
	}
	
}
