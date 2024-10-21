import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Player;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void testPlayerCreation() {
        Player player = new Player("Test Player", 'T');
        assertEquals("Test Player", player.getName());
        assertEquals('T', player.getSymbol());
    }
}
