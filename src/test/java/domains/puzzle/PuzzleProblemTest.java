package domains.puzzle;

import framework.problem.Mover;
import framework.problem.Problem;
import framework.problem.State;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import framework.ui.ProblemConsole;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class tests the PuzzleProblem class.
 * @author Jonathan Wong Section 004
 */
public class PuzzleProblemTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ProblemConsole(new PuzzleProblem(), 600, 800));
        primaryStage.setTitle("Testing 8-Puzzle Console");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Test
    public void testConsole() {   // for the user to manually solve
        launch();
    }
    
    public PuzzleProblemTest() {  // for automated tests
        problem = new PuzzleProblem();
        mover = problem.getMover();
        moveNames = mover.getMoveNames();
        
        slide1 = moveNames.get(0);
        slide2 = moveNames.get(1);
        slide3 = moveNames.get(2);
        slide4 = moveNames.get(3);
        slide5 = moveNames.get(4);
        slide6 = moveNames.get(5);
        slide7 = moveNames.get(6);
        slide8 = moveNames.get(7);
    }

    @Test
    public void testSolution() {  // You must provide
       display("Welcome to the " + problem.getName() + " problem");
       display(problem.getIntroduction());
       display(problem.getCurrentState());
       assertFalse(problem.success());
       
       tryMove(slide6);
       assertFalse(problem.success());
       
       tryMove(slide8);
       assertFalse(problem.success());
       
       tryMove(slide2);
       assertFalse(problem.success());
       
       tryMove(slide1);
       assertFalse(problem.success());
       
       tryMove(slide8);
       assertTrue(problem.success());
    }
    
    private final Problem problem;
    private final Mover mover;
    private final List<String> moveNames;
    private final String slide1, slide2, slide3, slide4,   // move names
                         slide5, slide6, slide7, slide8;
    
    
    /**
       You can reuse these private methods from the farmer problem test.
     */
    private void tryMove(String move) {
        State next = mover.doMove(move, problem.getCurrentState());
        assertTrue(next != null);
        problem.setCurrentState(next);
        display(problem.getCurrentState());
    }
    
    private void display(Object o) {
        System.out.println(o + "\n");
    }
}