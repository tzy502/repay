package service;

import java.util.ArrayList;
import java.util.List;

import dao.RoleDao;
import model.BeanRole;
import serviceI.IRoleService;

public class RoleService implements IRoleService {
	RoleDao rd=new RoleDao();
	@Override
	public void addRole(int roleId, String roleName, String rolePermissions, String roleDescription) {
		// TODO Auto-generated method stub
		BeanRole role=new BeanRole();
		role.setRoleId(roleId);
		role.setRoleName(roleName);
		role.setRolePermissions(rolePermissions);
		role.setRoleDescription(roleDescription);
		rd.addRole(role);
		
	}

	@Override
	public BeanRole SearchRole(int RoleId) {
		BeanRole role=new BeanRole();
		role=rd.SearchRole(RoleId);
		return role;
	}

	@Override
	public List<BeanRole> loadAllRole() {
		// TODO Auto-generated method stub
		List<BeanRole> result=new ArrayList<BeanRole>();
		result=rd.loadAllRole();
		return result;
	}

	@Override
	public void modifryRole(int roleId, String roleName, String rolePermissions, String roleDescription) {
		// TODO Auto-generated method stub
		BeanRole role=new BeanRole();
		role.setRoleId(roleId);
		role.setRoleName(roleName);
		role.setRolePermissions(rolePermissions);
		role.setRoleDescription(roleDescription);
		rd.modifryRole(role);
	}

	@Override
	public void DelRole(BeanRole Role) {
		// TODO Auto-generated method stub
		rd.DelRole(Role);
		
		
	}



}
