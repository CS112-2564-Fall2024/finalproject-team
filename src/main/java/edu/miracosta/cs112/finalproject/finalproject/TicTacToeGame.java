package edu.miracosta.cs112.finalproject.finalproject;

public class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;
    private char winner;

    // Inner class InvalidMoveException
    public static class InvalidMoveException extends Exception {
        public InvalidMoveException(String message) {
            super(message);
        }
    }

    public TicTacToeGame() {
        restartGame();
    }
    // start the game without a winner
    public void restartGame() {
        board = new char[3][3];
        currentPlayer = 'X';
        winner = ' ';
    }

    // checking if the space is already occupied
    public void makeMove(int row, int col) throws InvalidMoveException {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '\u0000') {
            throw new InvalidMoveException("Space occupied");
        }

        board[row][col] = currentPlayer;
        if (checkWinner()) {
            winner = currentPlayer;
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    //check all the rolls and colluns
    public boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    public char getWinner() {
        return winner;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }
}

