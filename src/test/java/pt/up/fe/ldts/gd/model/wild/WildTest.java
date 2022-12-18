package pt.up.fe.ldts.gd.model.wild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.player.Player;

import java.io.IOException;

public class WildTest {
    @Test
    public void wildTest() throws IOException {
        Player player = new Player("Saul");
        Wild wild = new Wild(player);
        Assertions.assertEquals("Saul", wild.getPlayer().getName());
        Assertions.assertEquals(3, wild.getOptions().size());
        wild.setMessage("Howdy, partner!");
        Assertions.assertEquals("Howdy, partner!", wild.getMessage());
    }
}
