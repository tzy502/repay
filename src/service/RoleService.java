package service;

import java.util.ArrayList;
import java.util.List;

import dao.RoleDao;
import model.BeanRole;
import serviceI.IRoleService;
import util.BaseException;

public class RoleService implements IRoleService {
	RoleDao rd=new RoleDao();
	@Override
	public void addRole( String roleName, String rolePermissions, String roleDescription)throws BaseException {
		// TODO Auto-generated method stub
		BeanRole role=new BeanRole();
		role.setRoleName(roleName);
		role.setRolePermissions(rolePermissions);
		role.setRoleDescription(roleDescription);
		rd.addRole(role);
		
	}

	@Override
	public BeanRole SearchRole(int RoleId)throws BaseException {
		BeanRole role=new BeanRole();
		role =null;
		role=rd.SearchRole(RoleId);
		if(role==null){
			throw new BaseException("查无数据");
		}
			
		return role;
	}

	@Override
	public List<BeanRole> loadAllRole()throws BaseException {
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
