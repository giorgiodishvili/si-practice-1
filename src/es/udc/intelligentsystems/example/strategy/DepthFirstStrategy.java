package es.udc.intelligentsystems.example.strategy;

import es.udc.intelligentsystems.Action;
import es.udc.intelligentsystems.SearchProblem;
import es.udc.intelligentsystems.SearchStrategy;
import es.udc.intelligentsystems.State;
import es.udc.intelligentsystems.example.entity.Node;

import java.util.*;

import static es.udc.intelligentsystems.example.utils.SearchStrategyHelper.reconstruct_sol;
import static es.udc.intelligentsystems.example.utils.SearchStrategyHelper.successors;

public class DepthFirstStrategy implements SearchStrategy {

    @Override
    public Node[] solve(SearchProblem p) throws Exception {
        Node initialNode = new Node(p.getInitialState());

        // empty explored list
        ArrayList<State> explored = new ArrayList<>();

        // frontier stack with first node
        Stack<Node> f = new Stack<>();
        f.push(initialNode);

        int i = 1;
        // check if frontier is empty
        while (!f.isEmpty()) {
            // last element of frontier
            Node node = f.peek();
            // last elements state
            State state = node.getState();
            // goal check
            if (p.isGoal(node.getState())) {
                return reconstruct_sol(node);
            }
            // add this state to explored list
            explored.add(state);
            // get all available checks
            List<Node> availableActions = successors(node,p);

            for (Node n : availableActions){
                // state not already explored
                if (!explored.contains(n.getState())) {
                    // state not already in frontire
                    boolean b = f.stream().noneMatch(c -> c.getState() == n.getState());
                    if (b) {
                        //if it is not there add
                        f.push(n);
                    }
                    System.out.println((i++) + " - " + n.getState() + " NOT explored");
                    System.out.println((i++) + " - Current state changed to " + n.getState());
                } else {
                    System.out.println((i++) + " - " + n.getState() + " already explored");
                }
            }
        }
        // if frontier is empty throw solution exception
        throw new IllegalStateException("No solution found");
    }

}