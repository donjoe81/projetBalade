package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Balade;
import Beans.Membre;
import Beans.Responsable;

public class BaladeDao extends DAO<Balade> {

	public BaladeDao(Connection conn) {
		super(conn);
	}
	// FINI
/**************************************************************************************/
	@Override
	public boolean create(Balade b) {
		boolean res=false;
		try {
			Statement stmt = connect.createStatement();
			String req = "insert into Balade(lieu_bal,date_bal,forfait_bal,descriptif_bal,id_res_se)"
			+ "values('"+b.getLieuDepart()+"','"+b.getDateDepart() +"',"+b.getForfait()+", '"+b.getDescriptif()+"', "+b.getReponsable().getId()+" )";
			stmt.executeUpdate(req);
			res=true;
		} catch (SQLException ex){
			System.out.println(ex.toString());
		}
		return res;
	}
/***************************************************************************************/
	@Override
	public boolean delete(Balade obj) {
		return false;
	}

	@Override
	public boolean update(Balade obj) {
		return false;
	}
	// FINI
/*******************************************************************************************/
	@Override
	public Balade find(int id) {
		Balade b = null;
		 try {
		    	String req="SELECT * FROM Balade WHERE id_bal = '" + id+"'";
		    	ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		    	if(result.first()) {
		    		 b = new Balade();
		    	 	 b.setId(id);
			    	 b.setLieuDepart(result.getString("lieu_bal"));
			    	 b.setDateDepart(result.getString("date_bal"));
			    	 b.setDateDepart(result.getString("forfait_bal"));	
			    	 b.setDescriptif(result.getString("descriptif_bal"));
		    	}
		      } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return b;
	}
	// FINI
/************************************************************************************************/
	@Override
	public List<Balade> findAll() {
		List<Balade> list = new ArrayList<Balade>();
		 try {
		    	String req="SELECT * FROM Balade ;";
		    	ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		    	while(result.next()) {
		    		 Balade b = new Balade();
		    	 	 b.setId(result.getInt("id_bal"));
			    	 b.setLieuDepart(result.getString("lieu_bal"));
			    	 b.setDateDepart(result.getString("date_bal"));
			    	 b.setForfait(result.getDouble("forfait_bal"));			    	 
			    	 b.setDescriptif(result.getString("descriptif_bal"));
			    	 list.add(b);
		    	}
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }
		return list;
	}
/****************************************************************************************************/
 
	public List<Balade> findBaladeMembre(Membre membre){
		List<Balade> list = new ArrayList<Balade>();
		 try {
		    	String req="SELECT * FROM Balade inner join Responsable on Balade.id_res_se = Responsable.id_res "
		    			+ "inner join Cathegorie on Responsable.id_res = Cathegorie.id_res_sec "
		    			+ "inner join liste_detail_cath_mem on Cathegorie.id_cat=liste_detail_cath_mem.id_cath_sec "
		    			+ "inner join Membre on liste_detail_cath_mem.id_mem_sec =Membre.id_mem"
		    			+ " where Membre.id_mem = "+membre.getId()+";";
		    	ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		    	while(result.next()) {
		    		 Balade b = new Balade();
		    	 	 b.setId(result.getInt("id_bal"));
			    	 b.setLieuDepart(result.getString("lieu_bal"));
			    	 b.setDateDepart(result.getString("date_bal"));
			    	 b.setForfait(result.getDouble("forfait_bal"));	
			    	 b.setDescriptif(result.getString("descriptif_bal"));
			    	 list.add(b);
		    	}
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }
		return list;
	}
	/*******************************************************************************/
	public List<Balade> findBaladeResponsable(Responsable responsable){
		List<Balade> list = new ArrayList<Balade>();
		 try {
		    	String req="SELECT * FROM Balade where id_res_se = "+responsable.getId()+";";
		    	ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		    	while(result.next()) {
		    		 Balade b = new Balade();
		    	 	 b.setId(result.getInt("id_bal"));
			    	 b.setLieuDepart(result.getString("lieu_bal"));
			    	 b.setDateDepart(result.getString("date_bal"));
			    	 b.setForfait(result.getDouble("forfait_bal"));	
			    	 b.setDescriptif(result.getString("descriptif_bal"));
			    	 list.add(b);
		    	}
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }
		return list;
	}
}
