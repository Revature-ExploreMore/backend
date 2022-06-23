package com.exploremore.pojo;

public class RolePojo {

	private int id;
	private String roleName;

	public RolePojo() {
	}

	public RolePojo(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RolePojo [id=" + id + ", roleName=" + roleName + "]";
	}

}
