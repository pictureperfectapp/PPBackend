package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "GAMES")
public class Game {
	@Id
	private Integer g_id;
	private String word;
	private String picture;
	private String guess;
	private int turn;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "USERS_GAMES",
			joinColumns = {@JoinColumn(name ="g_id")},
			inverseJoinColumns = {@JoinColumn(name = "u_id")})
	private List<User> users = new ArrayList<>();

	public Game() {
		super();
	}

	public Game(Integer g_id, String word, String picture, String guess, int turn, List<User> users) {
		super();
		this.g_id = g_id;
		this.word = word;
		this.picture = picture;
		this.guess = guess;
		this.turn = turn;
		this.users = users;
	}

	public Game(Integer g_id) {
		super();
		this.g_id = g_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getGuess() {
		return guess;
	}

	public void setGuess(String guess) {
		this.guess = guess;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Game [g_id=" + g_id + ", word=" + word + ", picture=" + picture + ", guess=" + guess + ", turn=" + turn
				+ ", users=" + users + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((g_id == null) ? 0 : g_id.hashCode());
		result = prime * result + ((guess == null) ? 0 : guess.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + turn;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		Game other = (Game) obj;
		if (g_id == null) {
			if (other.g_id != null)
				return false;
		} else if (!g_id.equals(other.g_id))
			return false;
		if (guess == null) {
			if (other.guess != null)
				return false;
		} else if (!guess.equals(other.guess))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (turn != other.turn)
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
}
