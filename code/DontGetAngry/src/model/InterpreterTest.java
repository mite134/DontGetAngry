package model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import controller.Interpreter;

public class InterpreterTest {

    private controller.Interpreter interpreter;

    @Before
    public void setUp(){

        System.out.println("setup");
        interpreter = new controller.Interpreter(null, 0);
    }


    @Test
    public void constructorTest(){
        interpreter = new Interpreter(null, 0);
    }





    @After
    public void tearDown(){
        System.out.println("tearDown");
        interpreter = null;
    }
}

