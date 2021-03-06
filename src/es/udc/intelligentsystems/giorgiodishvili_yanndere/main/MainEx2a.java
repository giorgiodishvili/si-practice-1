package es.udc.intelligentsystems.giorgiodishvili_yanndere.main;

import es.udc.intelligentsystems.SearchProblem;
import es.udc.intelligentsystems.SearchStrategy;
import es.udc.intelligentsystems.giorgiodishvili_yanndere.entity.Board;
import es.udc.intelligentsystems.giorgiodishvili_yanndere.problems.MagicSquareProblem;
import es.udc.intelligentsystems.giorgiodishvili_yanndere.strategy.BreadthFirstStrategy;

import java.util.Arrays;

public class MainEx2a {
    public static void main(String[] args) throws Exception {
//        VacuumCleanerProblem.VacuumCleanerState initialState = new VacuumCleanerProblem.VacuumCleanerState(VacuumCleanerProblem.VacuumCleanerState.RobotPosition.LEFT,
//                                                                                                    VacuumCleanerProblem.VacuumCleanerState.DirtPosition.BOTH);
//        SearchProblem aspiradora = new VacuumCleanerProblem(initialState);

        int[][] ints = {{4, 9, 2}, {3, 5, 0}, {0, 1, 0}};
//        int[][] ints = {{4, 9, 2}, {3, 5, 6}, {0, 1, 0}};
//        int[][] ints = {{4, 9, 2}, {3, 5, 7}, {0, 1, 0}};
//        int[][] ints = {{4, 9, 2}, {3, 5, 8}, {0, 1, 0}};
//        int[][] ints = {{2, 0, 0}, {0, 0, 0}, {0, 0, 0}};
//        int[][] ints = {{2, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        MagicSquareProblem.MagicSquareState initialState = new MagicSquareProblem.MagicSquareState(
                new Board(ints)
        );
        SearchProblem aspiradora = new MagicSquareProblem(initialState);

        SearchStrategy buscador = new BreadthFirstStrategy();
        System.out.println(Arrays.toString(buscador.solve(aspiradora)));
    }
}
