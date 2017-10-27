package model;

public class Field {


	private String takenBy = "noone";
	private String name;

	public Field(String name) {
		this.name=name;
	}

	public String getTakenBy() {
		return takenBy;
	}

	public void setTakenBy(String takenBy) {
		this.takenBy = takenBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}