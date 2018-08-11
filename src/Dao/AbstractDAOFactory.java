package Dao;

public abstract class AbstractDAOFactory {
	  public static final int DAO_FACTORY = 0;
	  public static final int XML_DAO_FACTORY = 1;


	  public abstract MembreDao getMembreDao();
	  public abstract ResponsableDao getResponsableDao();
	  public abstract TresorierDao getTresorierDao();
	  public abstract BaladeDao getBaladeDao();
	  public abstract VehiculeDao getVehiculeDao();
	  public abstract CathegorieDao getCathegorieDao();
	   
	   
	  //Méthode permettant de récupérer les Factory
	  public static AbstractDAOFactory getFactory(int type){
	    switch(type){
	      case DAO_FACTORY:
	        return new DAOFactory();
	      case XML_DAO_FACTORY: 
	        return null;// new XMLDAOFactory();
	      default:
	        return null;
	    }
	  }
	}
