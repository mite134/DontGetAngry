package model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Interpreter {
	private Game game;
	private String command;
	private boolean running;
	private LinkedList<String> currentRoll=new LinkedList<String>();
	public Interpreter() {
	}
        

	public String[] getCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--Reading input in Interpeter.\nPlease insert input\n");
        String input = sc.nextLine();
		String[] command = input.split(" ");
		return command;
	}

	public void cmdInterpret() {
		String[] cmd = getCommand();
                System.out.println("cmd in cmdInterpreter is " + Arrays.toString(cmd));
		
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
                        System.out.println("cmd[1] is " + cmd[1]);
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
				System.out.println("game is not running");
			}
			break;
		case "print":
			if (running) {
				game.print();
			}else{
				System.out.println("game is not running");
			}
			break;
		case "abort":
			if (running) {
				this.running = false;
			}else{
				System.out.println("game is not running");
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
