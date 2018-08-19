
package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Balade;
import Beans.Membre;
import Beans.Vehicule;

public class VehiculeDao extends DAO<Vehicule>{

	public VehiculeDao(Connection conn) {
		super(conn);
	}
	
	/*FINI*/
	@Override
	public boolean create(Vehicule v) {
		boolean res=false;
		try {
			Statement stmt = connect.createStatement();
			String req = "insert into Vehicule(numero_veh,nombre_place_veh,nombre_velo_veh, id_mem_sec,id_bal_sec) "
					+ "values('"+v.getNumero()+"',"+v.getNombreDePlace()+","+v.getNombreDeVelo()+","+v.getProprietaireVehicule().getId()+","+v.getBalade().getId()+");";
			
			stmt.executeUpdate(req);
			res=true;
		} catch (SQLException ex){
			System.out.println(ex.toString());
		}
		return res;
	}

	@Override
	public boolean delete(Vehicule obj) {
		return false;
	}

	@Override
	public boolean update(Vehicule obj) {
		boolean res =false;
		try {
			Statement stmt = connect.createStatement();
			String req ="UPDATE Vehicule SET payer_veh = 'oui' where id_veh = "+obj.getId();
			stmt.executeUpdate(req);
			res=true;
		} catch (SQLException ex){
			System.out.println(ex.toString());
		}
		return res;
	}

	/*FINI*/
	@Override
	public Vehicule find(int id) {
		 Vehicule v = null;
		 try {
		    	String req="SELECT * FROM Vehicule WHERE id_veh = '" + id+"'";
		    	ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		    	if(result.first()) {
		    		 v = new Vehicule();
		    	 	 v.setId(result.getInt("id_veh"));
		    	 	 v.setNumero(result.getString("numero_veh"));
		    	 	 v.setNombreDePlace(result.getInt("nombre_place_veh"));
		    	 	 v.setNombreDeVelo(result.getInt("nombre_velo_veh"));			
		    	}
		      } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return v;
	}

	@Override
	public List<Vehicule> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Vehicule findVehiculeMember(Membre mem) {
		Vehicule v = null;
		 try {
		    	String req="SELECT * FROM Vehicule inner join Membre on id_mem = id_mem_sec WHERE id_mem_sec = '" + mem.getId()+"'";
		    	ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		    	if(result.first()) {
		    		 v = new Vehicule();
		    	 	 v.setId(result.getInt("id_veh"));
		    	 	 v.setNumero(result.getString("numero_veh"));
		    	 	 v.setNombreDePlace(result.getInt("nombre_place_veh"));
		    	 	 v.setNombreDeVelo(result.getInt("nombre_velo_veh"));			
		    	}
		      } catch (SQLException e) {
		      e.printStackTrace();
		    }
		return v;
	}

	/************************************************************************************************/
	public List<Vehicule> findVehiculeBalade(Balade bal) {
		 ArrayList<Vehicule> liste = new ArrayList<Vehicule>();    
		    try {
		    	String s ="SELECT * FROM Vehicule where id_bal_sec = "+bal.getId(); 
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
		      while(result.next()){
		    	  Vehicule v = new Vehicule();
		    	  v.setId(result.getInt("id_veh"));
		    	  v.setNumero(result.getString("numero_veh"));
		    	  v.setNombreDePlace(result.getInt("nombre_place_veh"));
		    	  v.setNombreDeVelo(result.getInt("nombre_velo_veh"));	
		    	  v.setPayer(result.getString("payer_veh"));
		    	 liste.add(v);
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return liste;
	}
	/***************************************************************************************/
	public int nombreReservationParVehicule(Vehicule veh) {
		 int res = -1;   
		    try {
		    	String s ="SELECT count(*) FROM ligne_detail_membre_vehicule where id_veh_sec = "+veh.getId(); 
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(s);
		      if(result.first())
		    	res = result.getInt(1);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return res;
	}
	
	/***********************************************************************************************/
	public boolean testReservatoin(Vehicule veh, Membre mem) {
		 boolean res = false;   
		    try {
				String req = "select * from ligne_detail_membre_vehicule where id_mem_sec = "+mem.getId()+" and id_veh_sec = "+veh.getId()+";";
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(req);
		      if(result.first())
		    	res=true;
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return res;
	}
	
	public int InsertReservation(Vehicule veh, Membre mem) {
		int res = -1;// erreur dans l'enrg
		if(!testReservatoin(veh, mem)) {//test si le membre a deja fais une reservation
			try {
				Statement stmt = connect.createStatement();
				String req = "insert into ligne_detail_membre_vehicule(id_mem_sec,id_veh_sec) "
						+ "values("+mem.getId()+", "+veh.getId()+");";
				
				stmt.executeUpdate(req);
				res=0;//la reservation a bien été enregistrée
			} catch (SQLException ex){
				System.out.println(ex.toString());
			}
		}
		else
			res=2; // le membre a deja fais une reservation
		return res;
	}
	/*************************************************************************************************************/
}
