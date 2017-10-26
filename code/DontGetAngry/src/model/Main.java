package model;

import java.awt.EventQueue;

import controller.Interpreter;
import view.GameScreen;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final GameScreen window = new GameScreen();
					window.getFrmDontGetAngry().setVisible(true);
					Thread t = new Thread(new Runnable() {
				        @Override
				        public void run() {
				        	Interpreter i = new Interpreter(window);
							i.rollPhase();
				        }     
				    });
				    t.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}

}