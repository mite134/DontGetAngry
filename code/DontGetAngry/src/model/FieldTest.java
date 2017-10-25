package model;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Pawn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FieldTest {

    private Field field;

    @Before
    public void setUp(){
        field = new Field("mitko");
    }


    @Test
    public void constructorAndGetTest(){
        field = new Field("testName");

        assertEquals(field.getName(), "testName");
    }

    @Test
    public void getTakenBy(){
        assertEquals(field.getTakenBy(), "noone");
    }

    @Test
    public void setTakenByTest(){
        field.setTakenBy("test");
        assertEquals(field.getTakenBy(), "test");
    }

    @Test
    public void setNameTest(){
        field.setName("test");
        assertEquals(field.getName(), "test");
    }


    @After
    public void tearDown(){
        field = null;
    }

}
