import java.util.LinkedList;

public class Interpreter {
	private Game game;
	private String command;
	private boolean running;
	private LinkedList<String> currentRoll=new LinkedList<String>();
	public Interpreter() {
	}

	public String[] getCommand() {
		String input=Terminal.readLine();
		String[] command = input.split(" ");
		return command;
	}

	public void cmdInterpret() {
		String[] cmd = getCommand();
		
		switch (cmd[0]) {
		case "start":
			this.running = true;
			int rules = 0;
			boolean triply = false;
			boolean nojump = false;
			boolean barrier = false;
			boolean backward = false;
			for (int i = 1; i < cmd.length; i++) {
				switch (cmd[i].toLowerCase()) {
				case "backward":
					backward = true;
					break;
				case "nojump":
					nojump = true;
					break;
				case "triply":
					triply = true;
					break;
				case "barrier":
					barrier = true;
					break;
				}
			}
			if (triply) {
				rules += 8;
			}
			if (nojump) {
				rules += 4;
			}
			if (barrier) {
				rules += 2;
			}
			if (backward) {
				rules += 1;
			}
			this.game = new Game(rules);
			break;
		case "roll":
			if (running) {
				switch (cmd[1]) {
				case "6":
					game.goIn();
					break;
				default:
					currentRoll=game.throwDice(Integer.parseInt(cmd[1]));
					for(int a=0;a<currentRoll.size();a++){
						System.out.println(currentRoll.get(a));
					}
					break;
				}
			}else{
				Terminal.printError("game is not running");
			}
			break;
		case "print":
			if (running) {
				game.print();
			}else{
				Terminal.printError("game is not running");
			}
			break;
		case "abort":
			if (running) {
				this.running = false;
			}else{
				Terminal.printError("game is not running");
			}
			break;
		case "move":	
			for(int a=0;a<currentRoll.size();a++){
				System.out.println(currentRoll.get(a));
			}
			game.MovePawn(currentRoll, cmd[1], cmd[2]);
			break;
		}
	}

	public void start(int rules) {

	}

	public void move(String start, String goal) {

	}

	public static void roll() {

	}

	public void print() {

	}

	public void abort() {

	}
}
