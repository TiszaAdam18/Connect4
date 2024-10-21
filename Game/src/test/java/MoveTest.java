import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Move;
import org.junit.jupiter.api.Test;

public class MoveTest {
    @Test
    public void testMoveCreation() {
        Move move = new Move(2, 3);
        assertEquals(2, move.getRow());
        assertEquals(3, move.getColumn());
    }
}
