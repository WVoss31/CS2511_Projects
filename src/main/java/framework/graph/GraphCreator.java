package framework.graph;

import framework.problem.Problem;
import framework.problem.State;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author Your name here
 */
public class GraphCreator {
    
    public Graph createGraphFor(Problem problem) {
        graph = new Graph();
        Stack<Vertex> nodeStack = new Stack<>();
        Vertex node = new Vertex(problem.getInitialState());
        nodeStack.push(node);
        List<String> movesList = problem.getMover().getMoveNames();
        while (!nodeStack.isEmpty()) {
            Vertex u = nodeStack.pop();
            for (String m : movesList) {
                State nexState = problem.getMover().doMove(m, (State) u.getData());
                if (nexState != null) {
                    Vertex v = new Vertex(nexState);
                    if (graph.getVertices().containsKey(v)) {
                        v = graph.getVertices().get(v);
                    }
                    else {nodeStack.push(v);}
                    graph.addEdge(u, v);
                }
            }
        }
        return graph;
    }
    

    private Graph graph = null;
}