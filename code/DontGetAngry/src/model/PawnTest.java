package model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Pawn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PawnTest {

    Pawn pawn;

    @Before
    public void setUp(){
        pawn = new Pawn("red");
    }



    @Test
    public void constructorTest() {
        pawn = new Pawn("red");
        assertEquals(pawn.getColor(), "red");
        pawn = new Pawn("blue");
        assertEquals(pawn.getColor(), "blue");
        pawn = new Pawn("yellow");
        assertEquals(pawn.getColor(), "yellow");
        pawn = new Pawn("green");
        assertEquals(pawn.getColor(), "green");
        pawn = new Pawn("red", "S");

    }


    @Test
    public void getColorTest(){
        assertEquals(pawn.getColor(), "red");
    }

    @Test
    public void getPositionTest(){
        assertNotNull(pawn.getPosition());
    }


    @Test
    public void getEndNum(){
        assertNotNull(pawn.getEndNum());
    }

    @Test
    public void setColorTest(){
        pawn.setColor("red");
        assertEquals(pawn.getColor(), "red");
    }


}
