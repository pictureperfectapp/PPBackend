package com.revature.models;

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
	private Integer points;
	private Integer gamesPlayed;
	private Integer wins;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer u_id, String username, String password, String email, String admin, Integer points,
			Integer gamesPlayed, Integer wins) {
		super();
		this.u_id = u_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.admin = admin;
		this.points = points;
		this.gamesPlayed = gamesPlayed;
		this.wins = wins;
	}

	public User(Integer u_id) {
		super();
		this.u_id = u_id;
	}

	public User(String username) {
		super();
		this.username = username;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
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

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", admin=" + admin + ", points=" + points + ", gamesPlayed=" + gamesPlayed + ", wins=" + wins + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gamesPlayed == null) ? 0 : gamesPlayed.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		result = prime * result + ((u_id == null) ? 0 : u_id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((wins == null) ? 0 : wins.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gamesPlayed == null) {
			if (other.gamesPlayed != null)
				return false;
		} else if (!gamesPlayed.equals(other.gamesPlayed))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		if (u_id == null) {
			if (other.u_id != null)
				return false;
		} else if (!u_id.equals(other.u_id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (wins == null) {
			if (other.wins != null)
				return false;
		} else if (!wins.equals(other.wins))
			return false;
		return true;
	}
	
	
	
	
	
	
}
