package framework.ui;

import domains.arithmetic.ArithmeticProblem;
import domains.dummy.DummyProblem;
import domains.farmer.FarmerProblem;
import domains.puzzle.PuzzleProblem;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

/**
 * Tests the ProblemTabPane class.
 * @author Your name
 */
public class ProblemTabPaneTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ProblemGUI dummyGUI = new ProblemGUI(new DummyProblem());     // create a problem GUI for the dummy problem
        ProblemGUI arithmeticGUI = new ProblemGUI(new ArithmeticProblem()); // create a problem GUI for the arithmetic problem
        ProblemGUI farmerGUI = new ProblemGUI(new FarmerProblem());    // etc.
        ProblemGUI puzzleGUI =  new ProblemGUI(new PuzzleProblem());   //
        
        ProblemTabPane pane = new ProblemTabPane();
        
        pane.addTab(dummyGUI);
        pane.addTab(arithmeticGUI);
        pane.addTab(farmerGUI);
        pane.addTab(puzzleGUI);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Testing Problem Tab Pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Test
    public void testTabPane() {
        launch();
    }
    
}