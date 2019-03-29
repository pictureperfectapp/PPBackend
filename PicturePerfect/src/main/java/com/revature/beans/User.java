package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	private Integer u_id;
	private String username;
	private String password;
	private String email;
	private String admin;
	
	public User() {
		super();
	}
	
	public User(Integer id, String username, String password, String email, String admin) {
		super();
		this.u_id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.admin = admin;
	}

	public User(Integer id) {
		super();
		this.u_id = id;
	}

	public User(String username) {
		super();
		this.username = username;
	}

	public Integer getId() {
		return u_id;
	}

	public void setId(Integer id) {
		this.u_id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [id=" + u_id + ", username=" + username + ", password=" + password + ", email=" + email + ", admin="
				+ admin + "]";
	}
	
	
}
