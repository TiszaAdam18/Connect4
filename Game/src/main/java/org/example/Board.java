package org.example;

import java.util.Arrays;

public class Board {
    private final char[][] board;
    private final int rows;
    private final int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new char[rows][columns];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
    }

    public boolean makeMove(Move move, char symbol) {
        for (int i = rows - 1; i >= 0; i--) {
            if (board[i][move.getColumn()] == '.') {
                board[i][move.getColumn()] = symbol;
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public boolean checkWin(char symbol) {
        // Check horizontal, vertical, and diagonal win conditions
        // This part needs to be implemented
        return false;
    }
}


