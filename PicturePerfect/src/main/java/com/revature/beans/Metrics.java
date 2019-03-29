package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Metrics {
	@Id
	private Integer m_id;
	@OneToOne
	private User user;
	private Integer points;
	private Integer gamesPlayed;
	private Integer wins;
	
	public Metrics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Metrics(Integer m_id, User user, Integer points, Integer gamesPlayed, Integer wins) {
		super();
		this.m_id = m_id;
		this.user = user;
		this.points = points;
		this.gamesPlayed = gamesPlayed;
		this.wins = wins;
	}

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return "Metrics [m_id=" + m_id + ", user=" + user + ", points=" + points + ", gamesPlayed=" + gamesPlayed
				+ ", wins=" + wins + "]";
	}
	
	
}
