public class TicTacToe {


    public int[] slotToIndices(int slot) {
        if (slot < 1 || slot > 9) {
            throw new IllegalArgumentException("Slot must be between 1 and 9.");
        }

        slot -= 1;
        int row = slot / 3;
        int col = slot % 3;

        return new int[] { row, col };
    }


    public static void main(String[] args) {
        TicTacToe conv = new TicTacToe();
        int slot = 4;
        int[] indices = conv.slotToIndices(slot);
        System.out.println("Slot " + slot + " → row = " + indices[0] + ", col = " + indices[1]);
    }
}