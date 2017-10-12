package model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.Interpreter;

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
        interpreter.cmdInterpret(new String [] {"print"});
    }

    @Test
    public void cmdInterpeterTestPrintAfterStart(){
        interpreter.cmdInterpret(new String [] {"start"});
        interpreter.cmdInterpret(new String [] {"print"});
    }


    @Test
    public void cmdInterpeterTestStart(){
        interpreter.cmdInterpret(new String [] {"start"});
    }

    @Test
    public void cmdInterpeterTest6(){
        interpreter.cmdInterpret(new String [] {"start"});
        interpreter.cmdInterpret(new String [] {"roll", "6"});
    }

    @Test
    public void cmdInterpeterTestRollDefaut(){
        interpreter.cmdInterpret(new String [] {"start"});
        interpreter.cmdInterpret(new String [] {"roll", "1"});
    }


    @Test
    public void cmdTestDefaultNoStart(){
        interpreter.cmdInterpret(new String [] {"roll", "1"});
    }
    @Test
    public void cmdTestRoll6NoStart(){
        interpreter.cmdInterpret(new String [] {"roll", "6"});
    }


    @Test
    public void cmdTestMove(){
        //%TODO: move parameters

        interpreter.cmdInterpret(new String [] { "start" } );
        interpreter.cmdInterpret(new String [] { "roll", "6" } );
        interpreter.cmdInterpret(new String [] { "roll", "3" } );
        interpreter.cmdInterpret(new String [] { "move", "0", "3"  } );


    }

    @Test
    public void cmdTestMoveWrongMove(){


        interpreter.cmdInterpret(new String [] { "start" } );
        interpreter.cmdInterpret(new String [] { "roll", "6" } );
        interpreter.cmdInterpret(new String [] { "roll", "3" } );
        interpreter.cmdInterpret(new String [] { "move", "0", "2"  } );


    }


    @Test
    public void cmdTestStart1(){

        interpreter.cmdInterpret(new String [] {"start", "backward"} );



    }

    @Test
    public void cmdTestStart2() {
        interpreter.cmdInterpret(new String [] {"start", "nojump"} );
    }

    @Test
    public void cmdTestStart3() {
        interpreter.cmdInterpret(new String [] {"start", "triply"} );
    }

    @Test
    public void cmdTestStart4() {
        interpreter.cmdInterpret(new String [] {"start", "barrier"} );
    }


    @Test
    public void cmdTestAbort(){
        interpreter.cmdInterpret(new String [] {"start", "barrier"} );
        interpreter.cmdInterpret(new String [] {"abort"});
    }


    @Test
    public void cmdTestAbortNotRunning(){
        interpreter.cmdInterpret(new String [] {"abort"});
    }



    @After
    public void tearDown(){
        System.out.println("tearDown");
        interpreter = null;
    }

}
