public class TicTacToe {

    public static boolean isDraw(char[][] board) {
        // Check for any empty cell
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        };

        if (isDraw(board)) {
            System.out.println("The game is a draw!");
        } else {
            System.out.println("Moves still remain.");
        }
    }
}