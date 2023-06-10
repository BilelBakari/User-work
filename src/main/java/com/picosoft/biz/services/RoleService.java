package com.picosoft.biz.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picosoft.biz.entities.Role;
import com.picosoft.biz.repository.RoleDao;

@Service
public class RoleService {
	private static final Logger l = LogManager.getLogger(RoleService.class);
    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
	public void updateRole(Role role, String id) {
		Role role2 = roleDao.findById(id).get();
		role2.setRoleName(role.getRoleName());
		role2.setRoleDescription(role.getRoleDescription());
		roleDao.save(role2);
		
	}

	public void Deleterole(String id) {
		roleDao.deleteById(id);
		
		
	}

	public List<Role> retreiveAllrole() {
		List<Role> listrole = (List<Role>) roleDao.findAll() ;
		for(Role role : listrole) {
			l.info("piece : "+role);
		}
		return listrole;
	}
}