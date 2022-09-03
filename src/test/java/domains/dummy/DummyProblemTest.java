/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.dummy;

import framework.ui.ProblemConsole;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tcolburn
 */
public class DummyProblemTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ProblemConsole(new DummyProblem(), 450, 550));
        primaryStage.setTitle("Testing Dummy Console");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Test
    public void testDummy() {
        launch();
    }
    
}
