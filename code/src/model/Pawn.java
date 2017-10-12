package model;


public class Pawn {
	private String color;
	private String position;
	private int endNum;
	public Pawn(String color){
		this.color=color;
		this.position="S"+this.color.substring(0, 1).toUpperCase();
		if(color.equalsIgnoreCase("red")){
			endNum=39;
		}
		if(color.equalsIgnoreCase("blue")){
			endNum=9;
		}
		if(color.equalsIgnoreCase("green")){
			endNum=19;
		}
		if(color.equalsIgnoreCase("yellow")){
			endNum=29;
		}
	}
	public Pawn (String color, String position){
		this.color=color;
		this.position=position;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getEndNum() {
		return endNum;
	}

}
