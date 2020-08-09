package com.coreJava.assignment;

public abstract class Sports {
	private String nameOfSport;
	private int numberOfPlayers;
	private String typeOfSport;
	String getNameOfSport() {
		return nameOfSport;
	}
	void setNameOfSport(String nameOfSport) {
		this.nameOfSport = nameOfSport;
	}
	int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	String getTypeOfSport() {
		return typeOfSport;
	}
	void setTypeOfSport(String typeOfSport) {
		this.typeOfSport = typeOfSport;
	}
	
	abstract void area();
	abstract void perimeter();
}
