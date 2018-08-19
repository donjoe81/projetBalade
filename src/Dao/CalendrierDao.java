package Dao;

import java.sql.Connection;
import java.util.List;

import Beans.Calendrier;

public class CalendrierDao extends DAO<Calendrier> {

	public CalendrierDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Calendrier obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Calendrier obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Calendrier obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Calendrier find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Calendrier> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
