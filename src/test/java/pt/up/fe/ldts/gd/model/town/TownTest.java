package pt.up.fe.ldts.gd.model.town;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.player.Player;

import java.io.IOException;

public class TownTest {
    @Test
    public void townTest() throws IOException {
        Player p1 = new Player("Courier");
        Town vegas = new Town(p1);

        Assertions.assertEquals(3, vegas.getOptions().size());
        Assertions.assertEquals("Courier", vegas.getPlayer().getName());
        Assertions.assertEquals(3, vegas.getShop().getItems().size());
    }
}
