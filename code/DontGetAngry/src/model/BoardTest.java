package model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    @Before
    public void setUp(){
        board = new Board();
    }


    @Test
    public void constructorTest(){
        board = new Board();
    }

    @Test
    public void occupyTest(){
        //%TODO:
    }

    @After
    public void tearDown(){
        board = null;
    }
}
