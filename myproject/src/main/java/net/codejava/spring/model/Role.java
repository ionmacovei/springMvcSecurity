package net.codejava.spring.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role implements Serializable {
    @Id
    @Column(name = "User_Role_Id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long roleId;
    @Column(name = "authority")
    private String authority;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    @JoinColumn(name= "user_role_id")
    private Set<User> usersList = new HashSet<User>();


    public Role(){}

    public Role(String authority, Set<User> usersList) {
        this.authority = authority;
        this.usersList = usersList;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(Set<User> usersList) {
        this.usersList = usersList;
    }
}
