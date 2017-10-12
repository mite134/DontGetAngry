import java.util.LinkedList;

public class Game {
	private Player[] players;
	private Board board;
	private int active;
	private int rules;

	public Game(int rules) {
		this.players = new Player[4];
		this.players[0] = new Player("red");
		this.players[1] = new Player("blue");
		this.players[2] = new Player("green");
		this.players[3] = new Player("yellow");
		this.board = new Board();
		this.active = 0;
		this.rules = rules;
	}

	public void goIn() {
		this.players[this.active].GoIn();
	}

	public void print() {
		for (int i = 0; i < 4; i++) {
			for (int b = 0; b < 4; b++) {
				System.out.println(this.players[i].getPawns()[b].getPosition());
			}
		}
	}

	public void NextPlayer() {
		this.active = (this.active + 1) % 4;
	}

	public void onBoard() {
		for (int i = 0; i < 4; i++) {
			for (int b = 0; b < 4; b++) {
				this.board.occupy(this.players[i].getPawns()[b]);
			}
		}
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

	public LinkedList<String> CalculateMoves(int dice) {
		LinkedList<String> options = new LinkedList<String>();
		for (int i = 0; i < 4; i++) {
			if (!(this.players[this.active].getPawns()[i].getPosition()
					.endsWith(this.players[this.active].getPawns()[i].getColor().substring(0, 1).toUpperCase()))) {
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
		return CheckRules(options, dice);
	}

	public LinkedList<String> CheckRules(LinkedList<String> options, int dice) {
		LinkedList<String> valid = options;
		for (int i = 0; i < valid.size(); i++) {
			String[] positions = valid.get(i).split("-");
			String tryingPos = positions[1];
			String startingPos = positions[0];
			if ((rules >> 1) % 2 == 1) { // barrier
				// if
				// (this.board.checkField(tryingPos).equalsIgnoreCase(this.players[this.active].getColor()))
				// {
				// this.board.occupy(tryingPos, "double " +
				// this.players[this.active].getColor());
				// }
			} else if (this.board.checkField(tryingPos).equalsIgnoreCase(this.players[this.active].getColor())) {
				System.out.println("test");
				valid.remove(i);
			}
			if (rules % 2 == 1) { // backward
				if (!startingPos.endsWith(this.players[this.active].getColor().substring(0, 1).toUpperCase())) {
					if (((Integer.parseInt(startingPos) + 40) - dice)
							% 40 > this.players[this.active].getPawns()[0].getEndNum() + 1
							|| (this.players[this.active].getColor() == "red"
									&& ((Integer.parseInt(startingPos) + 40) - dice) % 40 > 0
									&& (Integer.parseInt(startingPos)
											- (((Integer.parseInt(startingPos) + 40) - dice) % 40) < 7))) {
						if (!(this.board.checkField((((Integer.parseInt(startingPos) + 40) - dice) % 40) + "")
								.equals("noone")
								|| this.board.checkField((((Integer.parseInt(startingPos) + 40) - dice) % 40) + "")
										.equals(this.players[this.active].getColor()))) {
							valid.add(startingPos + "-" + ((Integer.parseInt(startingPos) + 40) - dice) % 40);

						}
					}
				}
			}
			if ((rules >> 2) % 2 == 1) { // nojump

				String placeholder = tryingPos;
				while (!placeholder.equalsIgnoreCase(startingPos)) {

					if (!this.board.checkField(placeholder).equalsIgnoreCase("noone")) {
						valid.remove(i);
					}
					placeholder = prev(placeholder);
				}

			}

		}
		return valid;
	}

	public String prev(String current) { // Did it far too late
		String previous = null;
		if (!(current.endsWith("R") || current.endsWith("B") || current.endsWith("G") || current.endsWith("Y"))) {
			previous = ((Integer.parseInt(current) + 40) - 1) % 40 + "";
		}
		if (current.startsWith("B")) {
			previous = "A" + current.substring(1);
		}
		if (current.startsWith("C")) {
			previous = "B" + current.substring(1);
		}
		if (current.startsWith("D")) {
			previous = "C" + current.substring(1);
		}

		if (current.startsWith("A")) {
			switch (current.substring(1)) {
			case "R":
				previous = 39 + "";
				break;
			case "B":
				previous = 9 + "";
				break;
			case "G":
				previous = 19 + "";
				break;
			case "Y":
				previous = 29 + "";
			}
		}
		return previous;
	}

	public void MovePawn(LinkedList<String> options, String current, String pos) {

		if (!options.contains(current + "-" + pos)) {
			Terminal.printError("Error, Invalid move");
		} else {
			for (int i = 0; i < 4; i++) {
				if (this.players[this.active].getPawns()[i].getPosition().equalsIgnoreCase(current)) {
					this.players[this.active].setPawnPosition(pos, i);
					break;
				}
			}
		}
		if (this.players[this.active].Win()) {
			System.out.println(players[active].getColor() + " winner");
		}
	}

	public LinkedList<String> throwDice(int dice) {
		LinkedList<String> moves = CalculateMoves(dice);
		if(moves.size()==0&&(rules >> 3) % 2 == 0){
			NextPlayer();
		}else if(moves.size()==0&&(rules >> 3) % 2 == 1){
			System.out.println("You may roll again");
			Interpreter.roll();
		}else{
			for(int i=0;i<moves.size();i++){
				System.out.println(moves.get(i));
			}
		}
		return moves;
	}

}
