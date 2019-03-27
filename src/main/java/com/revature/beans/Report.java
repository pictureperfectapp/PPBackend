package com.revature.beans;

public class Report {
	private Integer r_id;
	private Integer u_id;
	private Integer g_id;
	private String status;
	private String description;
	
	public Report() {
		super();
	}

	public Report(Integer r_id, Integer u_id, Integer g_id, String status, String description) {
		super();
		this.r_id = r_id;
		this.u_id = u_id;
		this.g_id = g_id;
		this.status = status;
		this.description = description;
	}

	public Report(Integer r_id) {
		super();
		this.r_id = r_id;
	}

	public Report(String status) {
		super();
		this.status = status;
	}

	public Integer getR_id() {
		return r_id;
	}

	public void setR_id(Integer r_id) {
		this.r_id = r_id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Report [r_id=" + r_id + ", u_id=" + u_id + ", g_id=" + g_id + ", status=" + status + ", description="
				+ description + "]";
	}
	
	
}
