package test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Pawn;
import model.Player;

import static org.junit.Assert.assertEquals;

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


    @Test
    public void goInTest(){
        player.goIn();
    }

    @Test
    public void winTest(){
        player.Win();
    }


    @Test
    public void setPawnPositionTest(){
        player.setPawnPosition("SW", 2);
    }

    @Test
    public void setPawnsTest(){
        player.setPawns(new Pawn[2]);

        assertEquals(player.getPawns(), new Pawn[2]);
    }




    @After
    public void tearDown(){
        player = null;
    }
}
