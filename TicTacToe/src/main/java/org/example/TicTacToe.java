import java.util.Scanner;
public class TicTacToe {
    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };
    static char currentPlayer = 'X';
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }
    public static void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }
    public static boolean checkWin() {
        // Rows & Columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                    board[i][1] == currentPlayer &&
                    board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer &&
                    board[1][i] == currentPlayer &&
                    board[2][i] == currentPlayer) return true;
        }
        // Diagonals
        if (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer) return true;
        return false;
    }
    public static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }
    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    public static int[] getRowCol(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        printBoard();
        while (!gameOver) {
            System.out.print("Player " + currentPlayer + ", enter slot (1-9): ");
            int slot = scanner.nextInt();
            int[] pos = getRowCol(slot);
            int row = pos[0];
            int col = pos[1];
            if (isValidMove(row, col)) {
                makeMove(row, col);
                printBoard();
                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isDraw()) {
                    System.out.println("Game is a draw!");
                    gameOver = true;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }
}