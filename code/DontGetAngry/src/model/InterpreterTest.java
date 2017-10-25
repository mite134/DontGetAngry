package model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.Interpreter;

public class InterpreterTest {

    Interpreter interpreter;

    @Before
    public void setUp(){

        System.out.println("setup");
        interpreter = new Interpreter();
    }

    @Test
    public void getCommandTest(){
//        String[] command = interpreter.getCommand();
    }


    @Test
    public void cmdInterpeterTestPrint(){
        interpreter.rollPhase(new String [] {"print"});
    }

    @Test
    public void cmdInterpeterTestPrintAfterStart(){
        interpreter.rollPhase(new String [] {"start"});
        interpreter.rollPhase(new String [] {"print"});
    }


    @Test
    public void cmdInterpeterTestStart(){
        interpreter.rollPhase(new String [] {"start"});
    }

    @Test
    public void cmdInterpeterTest6(){
        interpreter.rollPhase(new String [] {"start"});
        interpreter.rollPhase(new String [] {"roll", "6"});
    }

    @Test
    public void cmdInterpeterTestRollDefaut(){
        interpreter.rollPhase(new String [] {"start"});
        interpreter.rollPhase(new String [] {"roll", "1"});
    }


    @Test
    public void cmdTestDefaultNoStart(){
        interpreter.rollPhase(new String [] {"roll", "1"});
    }
    @Test
    public void cmdTestRoll6NoStart(){
        interpreter.rollPhase(new String [] {"roll", "6"});
    }


    @Test
    public void cmdTestMove(){
        //%TODO: move parameters

        interpreter.rollPhase(new String [] { "start" } );
        interpreter.rollPhase(new String [] { "roll", "6" } );
        interpreter.rollPhase(new String [] { "roll", "3" } );
        interpreter.rollPhase(new String [] { "move", "0", "3"  } );


    }

    @Test
    public void cmdTestMoveWrongMove(){


        interpreter.rollPhase(new String [] { "start" } );
        interpreter.rollPhase(new String [] { "roll", "6" } );
        interpreter.rollPhase(new String [] { "roll", "3" } );
        interpreter.rollPhase(new String [] { "move", "0", "2"  } );


    }


    @Test
    public void cmdTestStart1(){

        interpreter.rollPhase(new String [] {"start", "backward"} );



    }

    @Test
    public void cmdTestStart2() {
        interpreter.rollPhase(new String [] {"start", "nojump"} );
    }

    @Test
    public void cmdTestStart3() {
        interpreter.rollPhase(new String [] {"start", "triply"} );
    }

    @Test
    public void cmdTestStart4() {
        interpreter.rollPhase(new String [] {"start", "barrier"} );
    }


    @Test
    public void cmdTestAbort(){
        interpreter.rollPhase(new String [] {"start", "barrier"} );
        interpreter.rollPhase(new String [] {"abort"});
    }


    @Test
    public void cmdTestAbortNotRunning(){
        interpreter.rollPhase(new String [] {"abort"});
    }



    @After
    public void tearDown(){
        System.out.println("tearDown");
        interpreter = null;
    }

}
