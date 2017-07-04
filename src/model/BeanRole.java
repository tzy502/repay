package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class BeanRole {
	private int roleId;
	private String roleName;
	private String rolePermissions;
	private String roleDescription;
	
	@Id
	@Column(name = "roleId")
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Column(name = "roleName")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Column(name = "rolePermissions")
	public String getRolePermissions() {
		return rolePermissions;
	}
	public void setRolePermissions(String rolePermissions) {
		this.rolePermissions = rolePermissions;
	}
	
	@Column(name = "roleDescription")
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
}
