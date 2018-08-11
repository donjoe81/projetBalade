package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Cathegorie;
import Beans.Membre;

public class CathegorieDao extends DAO<Cathegorie> {

	public CathegorieDao(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Cathegorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Cathegorie obj) {
		return false;
	}

	@Override
	public boolean update(Cathegorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cathegorie find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
/****************************************************************************************************************/
	@Override
	public List<Cathegorie> findAll() {
		 ArrayList<Cathegorie> liste = new ArrayList<Cathegorie>();    
		    try {
		    	String s ="SELECT * FROM Cathegorie"; 
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
		      while(result.next()){
		    	  Cathegorie c = new Cathegorie();
		    	  c.setId(result.getInt("id_cat"));
		    	  c.setLibelle(result.getString("libelle_cat"));
		    	 liste.add(c);
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return liste;
	}
	/*********************************************************************************************************************/
	public boolean inserCath(Membre mem, List<String> list) {
		boolean res=false;
		try {
			Statement stmt = connect.createStatement();
			List<Cathegorie> liste = findCath(list);
			for(Cathegorie cat : liste) {
				String req = "insert into liste_detail_cath_mem(id_cath_sec, id_mem_sec) "
					+ "values("+cat.getId()+",+"+mem.getId()+")";
				stmt.executeUpdate(req);
			}
			res=true;
		} catch (SQLException ex){
			System.out.println(ex.toString());
		}
		return res;
	}
	
	private List<Cathegorie> findCath(List<String> list){
		List<Cathegorie> liste = new ArrayList<Cathegorie>();
		List<Cathegorie> L = findAll();
		for(String s : list) {
			for(Cathegorie cat : L) {
				if(cat.getLibelle().equals(s))
						liste.add(cat);
			}
		}
		return liste;
	}
	/*****************************************************************************************************************************/
}
