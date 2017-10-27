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

	public void rollPhase() throws InterruptedException {
		while (true) {
			if (this.screen.isRolled()) {
				this.screen.changeLabel("It's the " + game.getColor() + " Player's turn!");
				Random r = new Random();
				int result = r.nextInt(6) + 1;
				this.game.setDie(result);
				int dice = this.game.getDie();
				this.screen.changeDiceLabel(dice+"");
				switch (dice) {
				case 6:
					int temp=game.goIn();
					if (temp>=0) {
						
						this.screen.placeIcon((temp + ""),game.getRGB());
						this.screen.setRolled(false);
						if(temp!=0&&temp!=10&&temp!=20&&temp!=30){
							int[] empty = { 240, 240, 240 };
							this.screen.placeIcon(((temp+34)%40 + ""),empty);
						}
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

	public void movePhase() throws InterruptedException {
		while (true) {

			System.out.println(this.currentRoll.size());

			if (this.screen.getClicked().size() == 2) {
				if (currentRoll.contains(this.screen.getClicked().get(0) + "-" + this.screen.getClicked().get(1))) {
					// try {
					int[] empty = { 240, 240, 240 };
					this.screen.placeIcon(this.screen.getClicked().get(0), empty);
					this.screen.placeIcon(this.screen.getClicked().get(1), game.getRGB());
					if (game.movePawn(currentRoll, this.screen.getClicked().get(0), this.screen.getClicked().get(1))) {
						if(game.isWinner()){
							this.screen.win();
							break;
						}
						for (String pos : this.enabledButtons) {
							this.screen.disableButton(pos);
						}
						this.enabledButtons = new LinkedList<String>();
						game.print();
						this.screen.cleanClicked();
						rollPhase();
					}
				}else{
					this.screen.wrongMove();
					this.screen.cleanClicked();
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