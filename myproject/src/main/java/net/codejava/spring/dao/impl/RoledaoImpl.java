package net.codejava.spring.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.codejava.spring.dao.RoleDao;

public class RoledaoImpl extends GenericDaoImpl implements RoleDao {

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
	public Session getCurrentSesion(){
    return getSessionFactory().getCurrentSession();
    }
	 
}
