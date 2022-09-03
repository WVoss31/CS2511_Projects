package framework;

import domains.dummy.DummyProblem;
import framework.ui.ProblemConsole;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ProblemConsole(new DummyProblem(), 450, 550));
        primaryStage.setTitle("Testing Dummy Console");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    @Override
//    public void start(Stage stage) {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
//        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        var scene = new Scene(new StackPane(label), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//
//    }

    public static void main(String[] args) {
        launch();
    }

}