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

@Entity
@Table(name = "GAMES")
public class Game {
	@Id
	private Integer g_id;
	private String word;
	private String picture;
	private String guess;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "USERS_GAMES",
			joinColumns = {@JoinColumn(name ="g_id")},
			inverseJoinColumns = {@JoinColumn(name = "u_id")})
	private List<User> users = new ArrayList<>();

	public Game() {
		super();
	}

	public Game(Integer g_id, String word, String picture, String guess, List<User> users) {
		super();
		this.g_id = g_id;
		this.word = word;
		this.picture = picture;
		this.guess = guess;
		this.users = users;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Game [g_id=" + g_id + ", word=" + word + ", picture=" + picture + ", guess=" + guess + ", users="
				+ users + "]";
	}
	
	
	
}
