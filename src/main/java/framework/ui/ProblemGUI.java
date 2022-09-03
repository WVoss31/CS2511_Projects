/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package framework.ui;

import domains.farmer.FarmerProblem;
import framework.problem.Problem;
import framework.problem.State;
import framework.solution.SolvingAssistant;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import javafx.scene.text.Text;



/**
 *
 * @author walker
 */
public class ProblemGUI extends VBox {
    public ProblemGUI(Problem problem, double width, double height) {
        problemthing = problem;
        solver = new SolvingAssistant(problemthing);
        //sets VBox size to the width and height
        super.setPrefSize(width, height);
        super.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        super.setPadding(new Insets(10));
        super.setSpacing(10);
        super.setAlignment(Pos.CENTER);
        //creating a label and setting font for welcome msg
        Label Welcome = new Label(new FarmerProblem().getName());
        Welcome.setWrapText(true);
        Welcome.setFont(Font.font("JetBrainsMono Nerd Font Mono",FontWeight.BOLD, 24));
        //creating a label for intro
        Label IntroLabel = new Label(new FarmerProblem().getIntroduction());
        IntroLabel.setWrapText(true);
        IntroLabel.setFont(Font.font("JetBrainsMono Nerd Font Mono", 12));
        //making new HBox
        HBox displayHBox = new HBox(30);
        displayHBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        displayHBox.setAlignment(Pos.CENTER);
        
        displayButtons(displayHBox, "Moves (" + solver.getMoveCount() + " so far):");
        displayState(solver.getProblem().getFinalState(), displayHBox, "Goal State:");
        displayState(solver.getProblem().getInitialState(), displayHBox, "Current State:");
        createProblemStatus();
        
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> {solver.reset(); 
                                nodeLabel.setText(problemthing.getCurrentState().toString());
                                updateProblemStatus();});
        

        //adding to display
        super.getChildren().addAll(Welcome, IntroLabel, displayHBox, status, resetButton);
    }
    
    public ProblemGUI(Problem problem) {
        this(problem, 600, 600);
    }
    
    
    /**
     * 
     * @param state
     * @param box
     * @param labelString 
     */
    private void displayState(State state, HBox box, String labelString) {
        VBox verticalBox = new VBox();
        HBox hb = new HBox();
        //creating title label
        Label titLabel = new Label(labelString);
        titLabel.setFont(Font.font("JetBrainsMono Nerd Font Mono",FontWeight.BOLD, 20));
        //creating state diagram
        nodeLabel = new Label(state.toString());
        nodeLabel.setBorder(new Border(new BorderStroke(Paint.valueOf("Black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        nodeLabel.setFont(Font.font("JetBrainsMono Nerd Font Mono",FontWeight.BOLD, 20));
        //setting padding stuff
        verticalBox.setSpacing(10);
        titLabel.setAlignment(Pos.CENTER);
        //I know what you are wondering: "did you really create an HBox 
        //and add nodeLabel to it just so it is horizonally center?"
        //and the answer is yes, yes I did, yes, I know I could probably use
        //a GridPane, but I am sick of trying to get it to work and display,
        //so this is how I will do this -_-
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(nodeLabel);
        //adding to display
        verticalBox.getChildren().addAll(titLabel, hb);
        box.getChildren().addAll(verticalBox);
    }
    
    /**
     * 
     * @param box
     * @param labelString 
     */
    private void displayButtons(HBox box, String labelString) {
        //creating boxes
        VBox verticalBox = new VBox();
        verticalBox.setSpacing(10);
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        //setting up label
        movesLabel = new Label(labelString);
        movesLabel.setFont(Font.font("JetBrainsMono Nerd Font Mono",FontWeight.BOLD, 20));
        //adding title to center
        hb.getChildren().add(movesLabel);
        //adding center title to vbox
        verticalBox.getChildren().addAll(hb);
        //adding buttons to vbox
        for (String moveString : problemthing.getMover().getMoveNames()) {
            Button move = new Button(moveString);
            move.setPrefSize(250, 15);
            //trying to make the buttons do stuff
            move.setOnAction(e -> {movesLabel.setText("Moves (" + solver.getMoveCount() + " so far):");
                                    solver.tryMove(moveString);
                                    nodeLabel.setText(problemthing.getCurrentState().toString());
        updateProblemStatus();});
            
            verticalBox.getChildren().addAll(move);
        }   
        //adding buttons to display
        box.getChildren().addAll(verticalBox);
    }
    

    
     private Text createProblemStatus()
    {
        status = new Text("");
        status.setFont(Font.font("JetBrainsMono Nerd Font Mono"));
        return status;
    }
    
    private void updateProblemStatus() {
        if (!this.solver.isMoveLegal()) {
            status.setText("Illegal move. Try again!");
            status.setFill(Paint.valueOf("#ff0a12"));
        }
        else if (this.solver.isProblemSolved()) {
            status.setText("You win! Congratulations!");
            status.setFill(Paint.valueOf("#4bbb5b"));
        }
        else { 
            status.setText("");
            status.setFill(Paint.valueOf("#000000"));
        }
    }
    
    public Problem getProblem() {
        return problemthing;
    }
    

    private Problem problemthing;
    private SolvingAssistant solver;
    private Label movesLabel;
    private Label nodeLabel;
    private Text status;
    
}
