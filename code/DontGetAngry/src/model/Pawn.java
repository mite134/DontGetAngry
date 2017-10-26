package model;


public class Pawn {
	private String color;
	private String position;
	private int endNum;

	private int g;
	private int b;
	private int r;
	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}

	public Pawn(String color){
		this.color=color;
		this.position="S"+this.color.substring(0, 1).toUpperCase();


		if(color.equalsIgnoreCase("red")){
			endNum=39;
			this.r=255;
			this.g=0;
			this.b=0;
		}
		if(color.equalsIgnoreCase("blue")){
			endNum=9;
			this.r=0;
			this.g=0;
			this.b=255;
		}
		if(color.equalsIgnoreCase("green")){
			endNum=19;
			this.r=0;
			this.g=255;
			this.b=0;
		}
		if(color.equalsIgnoreCase("yellow")){
			endNum=29;
			this.r=255;
			this.g=255;
			this.b=0;
		}
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