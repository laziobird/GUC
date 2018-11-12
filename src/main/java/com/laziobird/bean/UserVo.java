package com.laziobird.bean;
/**
* @author 蒋志伟
* @version 创建时间：2018年11月12日 下午3:14:28
*/
public class UserVo extends User{
	String roleId;
	String roleName;
	String roleDesc;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	
	
}
