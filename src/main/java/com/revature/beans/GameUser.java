package com.revature.beans;

public class GameUser {
	private Integer gu_id;
	private Integer u_id;
	private Integer g_id;
	
	public GameUser() {
		super();
	}

	public GameUser(Integer gu_id, Integer u_id, Integer g_id) {
		super();
		this.gu_id = gu_id;
		this.u_id = u_id;
		this.g_id = g_id;
	}

	public Integer getGu_id() {
		return gu_id;
	}

	public void setGu_id(Integer gu_id) {
		this.gu_id = gu_id;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	@Override
	public String toString() {
		return "GameUser [gu_id=" + gu_id + ", u_id=" + u_id + ", g_id=" + g_id + "]";
	}
	
	
	
}
