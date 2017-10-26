package model;


public class Player {
	private Pawn[] pawns;
	private String color;

	public Player(String color) {
		this.color = color;
		pawns = new Pawn[4];
		for (int i = 0; i < 4; i++) {
			pawns[i] = new Pawn(color);
		}
	}

	public int GoIn() {
		for (int i = 0; i < 4; i++) {
			if (pawns[i].getPosition().equals((pawns[i].getEndNum() + 1) % 40 + "")) {
				pawns[i].setPosition((pawns[i].getEndNum() + 7) % 40 + "");
				return (pawns[i].getEndNum() + 7) % 40;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (pawns[i].getPosition().startsWith("S")) {
				pawns[i].setPosition((pawns[i].getEndNum() + 1) % 40 + "");
				return (pawns[i].getEndNum() + 1) % 40;
			}
		}
		return -1;
	}

	public boolean Win() {
		int pawnsIn = 0;
		for (int i = 0; i < 4; i++) {
			if (pawns[i].getPosition().startsWith("A") || pawns[i].getPosition().startsWith("B")
					|| pawns[i].getPosition().startsWith("C") || pawns[i].getPosition().startsWith("D")) {
				pawnsIn++;
			}
		}
		if (pawnsIn == 4) {
			return true;
		} else {
			return false;
		}
	}

	

	public Pawn[] getPawns() {
		return pawns;
	}
	public void setPawnPosition(String pos, int index){
		this.pawns[index].setPosition(pos);
	}
	public void setPawns(Pawn[] pawns) {
		this.pawns = pawns;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}