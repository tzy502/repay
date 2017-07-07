package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.RoleDao;
import model.BeanRole;
import serviceI.IRoleService;
import util.BaseException;
@Service
public class RoleService implements IRoleService {
	@Resource
	RoleDao rd=new RoleDao();
	@Override
	public void addRole(String roleName, String rolePermissions, String roleDescription) throws BaseException {
		// TODO Auto-generated method stub
		BeanRole br=new BeanRole();
		br.setRoleName(roleName);
		br.setRolePermissions(rolePermissions);
		br.setRoleDescription(roleDescription);
		rd.addRole(br);
	}

	@Override
	public BeanRole SearchRole(int roleId) throws BaseException {
		// TODO Auto-generated method stub
		BeanRole br=new BeanRole();
		br=null;
		rd.SearchRole(roleId);
		if(br==null){
			throw new BaseException("查无数据");
		}
			
		return br;
	}

	@Override
	public List<BeanRole> loadAllRole() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanRole> result =new ArrayList<BeanRole>();
		result=rd.loadAllRole();
		return result;
	}

	@Override
	public void modifryRole(int roleId, String roleName, String rolePermissions, String roleDescription)
			throws BaseException {
		// TODO Auto-generated method stub
		BeanRole br=new BeanRole();
		br.setRoleName(roleName);
		br.setRolePermissions(rolePermissions);
		br.setRoleDescription(roleDescription);
		br.setRoleId(roleId);
		rd.modifryRole(br);
	}

	@Override
	public void DelRole(int roleId) throws BaseException {
		// TODO Auto-generated method stub
		rd.DelRole(SearchRole(roleId));
	}

}
