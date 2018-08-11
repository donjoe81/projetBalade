package Dao;

import java.sql.Connection;

import Dbs.ConnectionBd;

public class DAOFactory extends AbstractDAOFactory{
protected static final Connection conn =ConnectionBd.getInstance();   
	
	@Override
	public MembreDao getMembreDao(){return new MembreDao(conn);} 
	
	public ResponsableDao getResponsableDao() { return new ResponsableDao(conn);}

	@Override
	public TresorierDao getTresorierDao() { return new TresorierDao(conn);}

	@Override
	public BaladeDao getBaladeDao() {return new BaladeDao(conn);}

	@Override
	public VehiculeDao getVehiculeDao() {return new VehiculeDao(conn);}

	@Override
	public CathegorieDao getCathegorieDao() {return new CathegorieDao(conn);}



	
}
