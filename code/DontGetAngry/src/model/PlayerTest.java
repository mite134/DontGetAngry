package model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Pawn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp(){
        player = new Player("red");
    }


    @Test
    public void constructorTest(){
        player = new Player("red");
        assertEquals(player.getColor(), "red");
    }

    @Test
    public void setColorTest(){
        player.setColor("blue");
        assertEquals(player.getColor(), "blue");
    }

    @Test
    public void getColorTest(){
        assertEquals(player.getColor(), "red");
    }


    @Test
    public void setAndGetPawnsTest(){
        Pawn [] pawns = new Pawn[4];
        player.setPawns(pawns);
        assertEquals(  player.getPawns() ,  pawns );
    }




    @After
    public void tearDown(){
        player = null;
    }
}
