package org.example;

public class Board {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY_SLOT = '.';
    private char[][] board;

    public Board() {
        board = new char[ROWS][COLUMNS];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY_SLOT;
            }
        }
    }

    public boolean dropDisc(char disc, int column) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == EMPTY_SLOT) {
                board[i][column] = disc;
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(char disc) {
        return checkHorizontalWin(disc) || checkVerticalWin(disc) || checkDiagonalWin(disc);
    }

    private boolean checkHorizontalWin(char disc) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == disc && board[i][j + 1] == disc && board[i][j + 2] == disc && board[i][j + 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVerticalWin(char disc) {
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == disc && board[i + 1][j] == disc && board[i + 2][j] == disc && board[i + 3][j] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalWin(char disc) {
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == disc && board[i + 1][j + 1] == disc && board[i + 2][j + 2] == disc && board[i + 3][j + 3] == disc) {
                    return true;
                }
            }
            for (int j = 3; j < COLUMNS; j++) {
                if (board[i][j] == disc && board[i + 1][j - 1] == disc && board[i + 2][j - 2] == disc && board[i + 3][j - 3] == disc) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < COLUMNS; i++) {
            if (board[0][i] == EMPTY_SLOT) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

