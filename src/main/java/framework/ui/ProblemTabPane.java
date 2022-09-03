package framework.ui;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * This class allows multiple problems to be displayed in
 * one tabbed pane.
 * @author tcolburn
 */
public class ProblemTabPane extends TabPane {
    
    public void addTab(ProblemGUI gui) {
        Tab tab = new Tab();
        tab.setText(gui.getProblem().getName());
        tab.setContent(gui);
        getTabs().add(tab);
    }
    
}