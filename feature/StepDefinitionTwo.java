package cucumber.features;

import java.awt.EventQueue;

import controller.Interpreter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.GameScreen;

public class StepDefinitionTwo {

	
	
	@Given("^Start a new game and everytime you can exit the game from the menu$")
	public void start_a_new_game_and_everytime_you_can_exit_the_game_from_the_menu() throws Exception {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final view.GameScreen window = new view.GameScreen();
					window.getFrmDontGetAngry().setVisible(true);
					Thread t = new Thread(new Runnable() {
				        @Override
				        public void run() {
				        	Interpreter i = new Interpreter(window,1);
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

	@When("^You have to click the menu button$")
	public void you_have_to_click_the_menu_button() throws Exception {
		

		final GameScreen window = new GameScreen();
		
		System.out.println(window.isMenu());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final view.GameScreen window = new view.GameScreen();
					window.getFrmDontGetAngry().setVisible(true);
					Thread t = new Thread(new Runnable() {
				        @Override
				        public void run() {
				        	Interpreter i = new Interpreter(window,1);
							i.rollPhase();
				        }     
				    });
				    t.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			Thread.sleep(10000);
		} catch(Exception e) {
		}
		System.out.println(window.isMenu());


	}

	@Then("^You can exit the game$")
	public void you_can_exit_the_game() throws Exception {
		
		
		
		
	}
}
