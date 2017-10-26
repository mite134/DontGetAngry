package model;

import java.util.LinkedList;

public class Game {
	private Player[] players;

	private int die;
	private int active;
	public Player[] getPlayers() {
		return players;
	}

	public int getActive() {
		return active;
	}


	public Game() {
		this.players = new Player[4];
		this.players[0] = new Player("red");
		this.players[1] = new Player("blue");
		this.players[2] = new Player("green");
		this.players[3] = new Player("yellow");
		this.active = 0;
		
	}

	public boolean goIn() {
		return this.players[this.active].GoIn();
	}

	public void print() {
		for (int i = 0; i < 4; i++) {
			for (int b = 0; b < 4; b++) {
				System.out.println(this.players[i].getPawns()[b].getPosition());
			}
		}
	}

	public void nextPlayer() {
		this.active = (this.active + 1) % 4;
	}


	public void checkCollision(String pos) {
		for (int i = 0; i < 4; i++) {
			if (this.active != i) {
				for (int b = 0; b < 4; b++) {
					if (this.players[i].getPawns()[b].getPosition().equalsIgnoreCase(pos)) {
						this.players[i].getPawns()[b].setPosition(
								"S" + this.players[i].getPawns()[b].getColor().substring(0, 1).toUpperCase());
					}
				}
			}
		}
	}
	public boolean isInHouse(int i){
		return (this.players[this.active].getPawns()[i].getPosition()
				.endsWith(this.players[this.active].getPawns()[i].getColor().substring(0, 1).toUpperCase()));
	}
	public LinkedList<String> CalculateMoves(int dice) {
		LinkedList<String> options = new LinkedList<String>();
		for (int i = 0; i < 4; i++) {
			if (!isInHouse(i)) {
				int num = (Integer.parseInt(this.players[this.active].getPawns()[i].getPosition()) + dice) % 40;
				if (num <= this.players[this.active].getPawns()[i].getEndNum() || Integer
						.parseInt(this.players[this.active].getPawns()[i]
								.getPosition()) > this.players[this.active].getPawns()[i].getEndNum()
						&& !(this.players[this.active].getPawns()[i].getColor().equalsIgnoreCase("red")
								&& Integer.parseInt(this.players[this.active].getPawns()[i].getPosition()) - num > 0)) {

					options.add(this.players[this.active].getPawns()[i].getPosition() + "-" + num);
				} else {
					int newNum = num - this.players[this.active].getPawns()[i].getEndNum();
					switch (newNum) {
					case 1:
						options.add(this.players[this.active].getPawns()[i].getPosition() + "-" + "A"
								+ this.players[this.active].getPawns()[i].getColor().substring(0, 1));
						break;
					case 2:
						options.add(this.players[this.active].getPawns()[i].getPosition() + "-" + "B"
								+ this.players[this.active].getPawns()[i].getColor().substring(0, 1));
						break;
					case 3:
						options.add(this.players[this.active].getPawns()[i].getPosition() + "-" + "C"
								+ this.players[this.active].getPawns()[i].getColor().substring(0, 1));
						break;
					case 4:
						options.add(this.players[this.active].getPawns()[i].getPosition() + "-" + "D"
								+ this.players[this.active].getPawns()[i].getColor().substring(0, 1));
						break;
					default:
						break;
					}
				}

			} else {
				if (this.players[this.active].getPawns()[i].getPosition().startsWith("A") && dice == 3) {
					options.add(this.players[this.active].getPawns()[i].getPosition() + "-" + "D"
							+ this.players[this.active].getPawns()[i].getColor().substring(0, 1));
				} else if (this.players[this.active].getPawns()[i].getPosition().startsWith("A") && dice == 2) {
					options.add(this.players[this.active].getPawns()[i].getPosition() + "-" + "C"
							+ this.players[this.active].getPawns()[i].getColor().substring(0, 1));
				} else if (this.players[this.active].getPawns()[i].getPosition().startsWith("A") && dice == 1) {
					options.add(this.players[this.active].getPawns()[i].getPosition() + "-" + "B"
							+ this.players[this.active].getPawns()[i].getColor().substring(0, 1));
				} else if (this.players[this.active].getPawns()[i].getPosition().startsWith("B") && dice == 1) {
					options.add(this.players[this.active].getPawns()[i].getPosition() + "-" + "C"
							+ this.players[this.active].getPawns()[i].getColor().substring(0, 1));
				} else if (this.players[this.active].getPawns()[i].getPosition().startsWith("B") && dice == 2) {
					options.add(this.players[this.active].getPawns()[i].getPosition() + "-" + "D"
							+ this.players[this.active].getPawns()[i].getColor().substring(0, 1));
				} else if (this.players[this.active].getPawns()[i].getPosition().startsWith("C") && dice == 1) {
					options.add(this.players[this.active].getPawns()[i].getPosition() + "-" + "D"
							+ this.players[this.active].getPawns()[i].getColor().substring(0, 1));
				}
			}
		}
		for(String s:options){
			String going = s.split("-")[1];
			for(String b:options){
				String starting= b.split("-")[0];
				if(going.equalsIgnoreCase(starting)){
					options.remove(s);
				}
			}
		}
		return options;
	}


	public boolean movePawn(LinkedList<String> options, String current, String pos) {

		if (!options.contains(current + "-" + pos)) {
			System.out.println("Error, Invalid move");
			return false;
		} else {
			System.out.println(current + "-" + pos);
			for (int i = 0; i < 4; i++) {
				if (this.players[this.active].getPawns()[i].getPosition().equalsIgnoreCase(current)) {
					this.players[this.active].setPawnPosition(pos, i);
					checkCollision(pos);
					if (this.players[this.active].Win()) {
						System.out.println(players[active].getColor() + " winner");
					}
					nextPlayer();
					return true;
				}
			}
		}
		return false;
	}

	public int getDie() {
		return die;
	}
	public String getColor(){
		return this.players[this.active].getColor();
	}
	public int[] getRGB(){
		int[] rgb = new int[3];
		rgb[0]=this.players[this.active].getPawns()[0].getR();
		rgb[1]=this.players[this.active].getPawns()[0].getG();
		rgb[2]=this.players[this.active].getPawns()[0].getB();
		return rgb;
	}
	public void setDie(int die) {
		this.die = die;
	}

	public LinkedList<String> throwDice() {
		LinkedList<String> moves = CalculateMoves(this.die);
		if(moves.size()==0){
			System.out.println("next");
			nextPlayer();
		}else{
			for(int i=0;i<moves.size();i++){
				System.out.println(moves.get(i));
			}
		}
		return moves;
	}

}