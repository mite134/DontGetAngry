package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	private int active;
	private int die;
	private Player[] player;
	
	@Before
    public void setUp(){
        game = new Game();
        active = game.getActive();
        die = game.getDie();
        player = game.getPlayers();
    }

	
    @Test
    public void nextPlayerTest() {
      game.nextPlayer();
      assertEquals(game.getActive(), 1);
  	assertEquals(game.getColor(), "blue");
      game.nextPlayer();
      assertEquals(game.getActive(), 2);
    	assertEquals(game.getColor(), "green");

      game.nextPlayer();
      assertEquals(game.getActive(), 3);
    	assertEquals(game.getColor(), "yellow");

      game.nextPlayer();
      assertEquals(game.getActive(), 0);
    	assertEquals(game.getColor(), "red");

    }
  
    
    @Test
    public void isInHouseTest() {
    	for(int i = 0; i < 4; i ++) {
    	assertTrue(game.isInHouse(i));
    	}
    }
    
    @Test
    public void diceTest() {
    	LinkedList<String> str = new LinkedList();
    	assertEquals(game.throwDice().size(),0);
    }
    
    @Test
    public void calculateTest1() {
    	game.goIn();
    	LinkedList<String> options = new LinkedList();
    	options.add("0-5");
    	
    	assertEquals(game.CalculateMoves(5), options);
    	
    }
    
    @Test
    public void moveTest1() {
    	game.goIn();
    	LinkedList<String> options = new LinkedList();
    	options.add("0-5");
    	
    	assertFalse(game.movePawn(options, "red", "0"));
    	
    }
    
    @Test
    public void moveTest2() {
    	game.goIn();
    	LinkedList<String> options = new LinkedList();
    	options.add("0-5");
    	
    	assertTrue(game.movePawn(options, "0", "5"));
    	
    	
    }
    
    @Test
    public void moveTest3() {
    	game.goIn();
    	LinkedList<String> options = new LinkedList();
    	options.add("0-5");
    	
    	game.throwDice();
    	System.out.println(game.getDie());
    	game.throwDice();
    	game.throwDice();
    	game.throwDice();
    	
    	game.goIn();
    	options.add("0-3");
    	options.add("5-8");
    	
    	assertTrue(game.movePawn(options, "0", "3"));
    	
    	
    }
    
    @Test
    public void calculateTest2() {
    	game.throwDice();

    	game.goIn();
    	LinkedList<String> options = new LinkedList();
    	options.add("13-18");
    	
    	game.movePawn(options, "13", "18");
    	
    	game.throwDice();
    	game.throwDice();
    	game.throwDice();
    	game.throwDice();


    	options.add("18-23");
    	game.movePawn(options, "18", "23");
    	
    	
    	game.throwDice();
    	game.throwDice();
    	game.throwDice();
    	game.throwDice();
    	
    	options.add("23-28");
    	game.movePawn(options, "23", "28");
    	
    	game.throwDice();
    	game.throwDice();
    	game.throwDice();
    	game.throwDice();
    	options.add("28-33");
    	game.movePawn(options, "28", "33");
    	
    	game.throwDice();
    	game.throwDice();
    	game.throwDice();
    	game.throwDice();
    	options.add("33-36");
    	game.movePawn(options, "33", "36");
    	
    	game.throwDice();
    	game.throwDice();
    	game.throwDice();
    	game.throwDice();
    	
    	
    	options.add("36-1");

    	assertEquals(game.CalculateMoves(5).toString(), "[10-15]");
    }
    
    @Test
    public void rgbTest() {
    	game.getRGB();
    }

    @Test
    public void printTest() {
    	game.print();
    }
    
    @Test
    public void collisionTest() {
    	game.goIn();
    	game.setDie(5);
    	game.checkCollision("5");
    }
    
    @After
    public void tearDown(){
    	game = null;
        die = 0;
        player = null;
    }

}
