package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Role;

public interface RoleDao extends GenericDao  {
	  public void add(Role role);
	    public void edit(Role role);
	    public void delete(long roleId);
	    public Role getRole(long roleId);
	    public List getAllRoles();
}
