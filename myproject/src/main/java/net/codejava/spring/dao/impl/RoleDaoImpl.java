package net.codejava.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.codejava.spring.dao.RoleDao;
import net.codejava.spring.model.Role;

public class RoleDaoImpl extends GenericDaoImpl implements RoleDao {

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
	public Session getCurrentSesion(){
    return getSessionFactory().getCurrentSession();
    }
	   @Override
	    public void add(Role role) {
	      getCurrentSesion().save(role);
	    }

	    @Override
	    public void edit(Role role) {
	    	getCurrentSesion().update(role);
	    }

	    @Override
	    public void delete(long roleId) {
	    	getCurrentSesion().delete(getRole(roleId));
	    }

	    @Override
	    public Role getRole(long roleId) {
	        return (Role) getCurrentSesion().get(Role.class,roleId);
	    }

	    @SuppressWarnings("unchecked")
		@Override
	    public List<Role> getAllRoles() {
	        return getCurrentSesion().createQuery("from Role").list();
	    }
	 
}
