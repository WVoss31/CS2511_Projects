/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.arithmetic;

import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import framework.ui.ProblemConsole;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author tcolburn
 */
public class ArithmeticProblemTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ProblemConsole(new ArithmeticProblem()));
        primaryStage.setTitle("Testing Arithmetic Console");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Test
    public void testArithmetic() {
        launch();
    }

    @Test
    public void testIntro() {
        assertTrue(new ArithmeticProblem().getIntroduction().equals(
             "The starting value is zero. " +
             "Your options are to add 3, subtract 5, " +
             "divide by 2, or multiply by 2. " +
             "Find a sequence of operations that results in the value 17."));
    }

    @Test
    public void testInit() {
        problem = new ArithmeticProblem();
        assertTrue(problem.getInitialState().equals(new ArithmeticState(0)));
        assertTrue(problem.getCurrentState().equals(new ArithmeticState(0)));
        assertTrue(problem.getFinalState().equals(new ArithmeticState(17)));
    }

    @Test
    public void testSolve() {
        problem = new ArithmeticProblem();
        mover = problem.getMover();
        assertFalse(problem.success());
        
        tryMove("Add 3");
        assertFalse(problem.success());
        
        tryMove("Add 3");
        assertFalse(problem.success());
        
        tryMove("Multiply by 2");
        assertFalse(problem.success());
        
        tryMove("Subtract 5");
        assertFalse(problem.success());
        
        tryMove("Multiply by 2");
        assertFalse(problem.success());
        
        tryMove("Multiply by 2");
        assertFalse(problem.success());
        
        tryMove("Add 3");
        assertFalse(problem.success());
        
        tryMove("Add 3");
        assertFalse(problem.success());
        
        tryMove("Divide by 2");
        assertTrue(problem.success());
    }
    
    private void tryMove(String move) {
        State next = mover.doMove(move, problem.getCurrentState());
        assertTrue(next != null);
        problem.setCurrentState(next);
        display(problem.getCurrentState());
    }
    
    private void display(Object o) {
        System.out.println(o + "\n");
    }
    
    private Problem problem;
    private Mover mover;
    
}
