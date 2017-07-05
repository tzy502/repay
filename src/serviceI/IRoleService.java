package serviceI;

import java.util.List;

import model.BeanRole;

public interface IRoleService {
	public void addRole( int roleId,String roleName,String rolePermissions,String roleDescription);
	public BeanRole SearchRole(int RoleId);
	public List<BeanRole> loadAllRole();
	public void modifryRole(int roleId,String roleName,String rolePermissions,String roleDescription);
	public void DelRole(BeanRole Role);
}
