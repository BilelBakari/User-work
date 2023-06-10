package com.picosoft.biz.entities;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity

@SuppressWarnings("unused")
public class Role {

    @Id
    private String roleName;
    private String roleDescription;
	

	

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}
	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Role(String roleName, String roleDescription) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	public Role() {
		super();
	}
	
    
	
}