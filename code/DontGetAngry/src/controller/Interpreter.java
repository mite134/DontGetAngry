package controller;

import java.util.LinkedList;
import java.util.Random;

import model.Game;

public class Interpreter {
	private Game game;
	private view.GameScreen screen;

	private LinkedList<String> currentRoll = new LinkedList<String>();
	private LinkedList<String> enabledButtons = new LinkedList<String>();

	public Interpreter(view.GameScreen screen) {
		this.game = new Game();
		this.screen = screen;
	}

	public void rollPhase() {
		while (true) {
			if (this.screen.isRolled()) {
				this.screen.changeLabel("It's the " + game.getColor() + " Player's turn!");
				Random r = new Random();
				int result = r.nextInt(6) + 1;
				this.game.setDie(result);
				int dice = this.game.getDie();
				switch (dice) {
				case 6:
					if (game.goIn()) {
						this.screen.placeIcon(
								(game.getPlayers()[game.getActive()].getPawns()[0].getEndNum() + 1) % 40 + "",
								game.getRGB());
						this.screen.setRolled(false);
						break;
					}else{
						currentRoll = game.throwDice();
						for (int a = 0; a < currentRoll.size(); a++) {
							String[] positions = currentRoll.get(a).split("-");
							this.screen.enableButton(positions[0]);
							this.enabledButtons.add(positions[0]);
							this.screen.enableButton(positions[1]);
							this.enabledButtons.add(positions[1]);
						}
						this.screen.setRolled(false);
						movePhase();
						break;
					}
				default:
					currentRoll = game.throwDice();
					for (int a = 0; a < currentRoll.size(); a++) {
						String[] positions = currentRoll.get(a).split("-");
						this.screen.enableButton(positions[0]);
						this.enabledButtons.add(positions[0]);
						this.screen.enableButton(positions[1]);
						this.enabledButtons.add(positions[1]);
					}
					this.screen.setRolled(false);
					movePhase();
					break;
				}
			} else {
				this.screen.changeLabel("It's the " + game.getColor() + " Player's turn!");
			}
			if (this.screen.isToBeRestrted()) {
				this.game = new Game();

			}
		}
	}

	public void movePhase() {
		while (true) {

			System.out.println(this.currentRoll.size());

			if (this.screen.getClicked().size() == 2) {
				if (currentRoll.contains(this.screen.getClicked().get(0) + "-" + this.screen.getClicked().get(1))) {
					// try {
					int[] empty = { 240, 240, 240 };
					this.screen.placeIcon(this.screen.getClicked().get(0), empty);
					this.screen.placeIcon(this.screen.getClicked().get(1), game.getRGB());
					if (game.movePawn(currentRoll, this.screen.getClicked().get(0), this.screen.getClicked().get(1))) {

						for (String pos : this.enabledButtons) {
							this.screen.disableButton(pos);
						}
						this.enabledButtons = new LinkedList<String>();
						game.print();
						this.screen.cleanClicked();
						rollPhase();
					}
				}
				// } catch (Exception e) {
				// System.out.println(e.getClass());
				// }
			} else if (this.currentRoll.size() == 0) {
				game.print();
				rollPhase();
			}
		}
	}

}