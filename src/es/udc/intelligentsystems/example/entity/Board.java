package es.udc.intelligentsystems.example.entity;

import java.util.Stack;

public class Board {
    private final int[][] board;
    private final int boardLastNumber;
    private final Stack<Integer> possibleValues = new Stack<>();


    public Board(int[][] board) {
        this.board = board;
        this.boardLastNumber = board.length * board.length;
        for (int i = 1; i <= boardLastNumber; i++) {
            possibleValues.add(i);
        }
        recalculatePossibleValues();
    }

    public int[][] getBoard() {
        return this.board;
    }

    public Stack<Integer> getPossibleValues() {
        return possibleValues;
    }

    public Stack<Integer> recalculatePossibleValues() {
        possibleValues.clear();
        for (int i = 1; i <= boardLastNumber; i++) {
            possibleValues.add(i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    possibleValues.remove(new Integer(board[i][j]));
                }
            }
        }
        return possibleValues;
    }
}
