package com.revature.beans;

public class Metrics {
	private Integer m_id;
	private Integer u_id;
	private Integer points;
	private Integer gamesPlayed;
	private Integer wins;
	
	public Metrics() {
		super();
	}

	public Metrics(Integer m_id, Integer u_id, Integer points, Integer gamesPlayed, Integer wins) {
		super();
		this.m_id = m_id;
		this.u_id = u_id;
		this.points = points;
		this.gamesPlayed = gamesPlayed;
		this.wins = wins;
	}

	public Metrics(Integer u_id) {
		super();
		this.u_id = u_id;
	}

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public Integer getPoints() {
		return points;
	}

	@Override
	public String toString() {
		return "Metrics [m_id=" + m_id + ", u_id=" + u_id + ", points=" + points + ", gamesPlayed=" + gamesPlayed
				+ ", wins=" + wins + "]";
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
	
	
}
