import java.util.Random;

public class TicTacToe {

    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    public static int[] getRowCol(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    public static void makeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void computerMove(char[][] board, char symbol) {
        Random random = new Random();
        int slot;
        int[] position;

        do {
            slot = random.nextInt(9) + 1; // 1–9
            position = getRowCol(slot);
        } while (!isValidMove(board, position[0], position[1]));

        makeMove(board, position[0], position[1], symbol);
        System.out.println("Computer chose slot: " + slot);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        computerMove(board, 'O');
        printBoard(board);
    }
}