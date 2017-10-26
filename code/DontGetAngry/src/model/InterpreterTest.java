package model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import controller.Interpreter;

public class InterpreterTest {

    private controller.Interpreter interpreter;
    private view.GameScreen screen;

    @Before
    public void setUp(){

        System.out.println("setup");
        interpreter = new controller.Interpreter(null);
        screen = new view.GameScreen();
    }


    @Test
    public void constructorTest(){
        interpreter = new Interpreter(null);
    }
    
    /**
     * @Test
     
	public void validDice() {
    	int dice = ;
		assertNotNull(dice);
	}
	*/
    
    @Test
    public void moveTest() {
    	 LinkedList<String> currentRoll = new LinkedList<String>();
    	 currentRoll.add("6");
    	 currentRoll.add("5");

    	 Game game = new Game();
    	 view.GameScreen screen = new view.GameScreen() ;
    	 screen.addClicked("0");
    	 screen.addClicked("5");

    	 assertEquals(screen.getClicked().size(), 2);
    //	 interpreter.movePhase();
    	 
    }





    @After
    public void tearDown(){
        System.out.println("tearDown");
        interpreter = null;
    }
}

