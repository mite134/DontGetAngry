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

	public int goIn() {
		

		for (int i = 0; i < 4; i++) {
			if (pawns[i].getPosition().startsWith("S")) {
				for (int b = 0; b < 4; b++) {
					if (pawns[b].getPosition().equals((pawns[b].getEndNum() + 1) % 40 + "")) {
						for (int c = 0; c < 4; c++) {
							if (pawns[c].getPosition().equals((pawns[c].getEndNum() + 7) % 40 + "")) {
								for (int d = 0; d < 4; d++) {
									if (pawns[d].getPosition().equals((pawns[d].getEndNum() + 13) % 40 + "")) {
										pawns[d].setPosition((pawns[d].getEndNum() + 19) % 40 + "");
										return (pawns[b].getEndNum() + 19) % 40;
									}
								}
								pawns[c].setPosition((pawns[c].getEndNum() + 13) % 40 + "");
								return (pawns[c].getEndNum() + 13) % 40;
							}
						}
						pawns[b].setPosition((pawns[b].getEndNum() + 7) % 40 + "");
						return (pawns[b].getEndNum() + 7) % 40;
					}
				}
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