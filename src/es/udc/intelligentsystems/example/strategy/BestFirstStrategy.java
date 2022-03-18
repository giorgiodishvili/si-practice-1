package es.udc.intelligentsystems.example.strategy;

import es.udc.intelligentsystems.Heuristic;
import es.udc.intelligentsystems.InformedSearchStrategy;
import es.udc.intelligentsystems.SearchProblem;
import es.udc.intelligentsystems.State;
import es.udc.intelligentsystems.example.entity.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

import static es.udc.intelligentsystems.example.utils.SearchStrategyHelper.successors;

public class BestFirstStrategy implements InformedSearchStrategy {

    @Override
    public State solve(SearchProblem p, Heuristic h) throws Exception {

        int created = 1;
        int expanded = 0;

        ArrayList<State> explored = new ArrayList<>();
        PriorityQueue<Node> frontier = new PriorityQueue<>();
        State currentState = p.getInitialState();
        Node searching = new Node(currentState);
        frontier.add(searching);

        System.out.println(" - Starting search...");

        while (!frontier.isEmpty()) {
            searching = frontier.poll();
            currentState = searching.getState();
            expanded++;
            System.out.println(" - Current state changed to " + currentState);

            if (p.isGoal(currentState)) {
                System.out.println(" - END - " + currentState);
                System.out.println("\nNumber of nodes created: " + created);
                System.out.println("\nNumber of nodes expanded: " + expanded);
                return currentState;
            }

            System.out.println(" - " + currentState + " is not a goal");
            explored.add(currentState);
            List<Node> sons = successors(searching, p, h);
            created += sons.size();
            for (Node n : sons) {
                State sc = n.getState();
                System.out.println(" - RESULT(" + currentState + "," + n.getAction() + ")=" + sc);
                if (explored.contains(sc)) {
                    System.out.println(" - " + sc + " already explored");
                    continue;
                }
                System.out.println(" - " + sc + " NOT explored");
                if (!frontier.contains(n)) frontier.add(n);
            }
        }

        throw new Exception("No solution could be found");
    }

}