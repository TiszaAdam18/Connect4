import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.example.Board;
import org.example.Move;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    public void testMakeMove() {
        Board board = new Board(6, 7);
        Move move = new Move(0, 0);
        assertTrue(board.makeMove(move, 'Y'));

        // Try to place another move in the same column
        Move move2 = new Move(0, 0);
        assertTrue(board.makeMove(move2, 'R'));

        // Fill the column and try to place another move
        for (int i = 0; i < 5; i++) {
            board.makeMove(move, 'Y');
        }
        assertFalse(board.makeMove(move, 'R'));
    }

    @Test
    public void testDisplayBoard() {
        Board board = new Board(6, 7);
        board.display();  // This just checks if the method runs without errors
    }
}
