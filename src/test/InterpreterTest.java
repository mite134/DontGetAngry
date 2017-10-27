package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import controller.Interpreter;

public class InterpreterTest {

	private Interpreter interpreter;
	private view.GameScreen screen;

	@Before
	public void setUp() {

		System.out.println("setup");
		screen = new view.GameScreen();
		interpreter = new Interpreter(screen);

	}

	@Test
	public void constructorTest() {
		interpreter = new Interpreter(null);
		assertNotNull(interpreter);
	}

	@Test

	public void validDice() {
		screen.setRolled(true);
		Random r = new Random();
		int dice = r.nextInt(6) + 1;
		assertNotNull(dice);
	}

	@Test
	public void rollTest() {
		LinkedList<String> currentRoll = new LinkedList<String>();
		currentRoll.add("6");
		currentRoll.add("5");
		
		screen.addClicked("0");
		screen.addClicked("5");

		assertEquals(screen.getClicked().size(), 2);
		screen.cleanClicked();
		
	}
	
	
	@Test
	public void goInFunction() {
		screen.changeLabel(null);
		screen.disableButton(null);
		screen.enableButton(null);
		screen.setFrmDontGetAngry(null);
		screen.isToBeRestrted();
		screen.getClicked();
		screen.win();
		screen.wrongMove();
		screen.failToPaint();
		
	}

	@After
	public void tearDown() {
		System.out.println("tearDown");
		interpreter = null;
	}
}
