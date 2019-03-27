package com.revature.beans;

public class Game {
	private Integer g_id;
	private String word;
	private Object picture;
	private String guess;
	private Integer turn_id;
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Game(Integer g_id, String word, Object picture, String guess, Integer turn_id) {
		super();
		this.g_id = g_id;
		this.word = word;
		this.picture = picture;
		this.guess = guess;
		this.turn_id = turn_id;
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
	public Object getPicture() {
		return picture;
	}
	public void setPicture(Object picture) {
		this.picture = picture;
	}
	public String getGuess() {
		return guess;
	}
	public void setGuess(String guess) {
		this.guess = guess;
	}
	public Integer getTurn_id() {
		return turn_id;
	}
	public void setTurn_id(Integer turn_id) {
		this.turn_id = turn_id;
	}
	@Override
	public String toString() {
		return "Game [g_id=" + g_id + ", word=" + word + ", picture=" + picture + ", guess=" + guess + ", turn_id="
				+ turn_id + "]";
	}
	
	
}
