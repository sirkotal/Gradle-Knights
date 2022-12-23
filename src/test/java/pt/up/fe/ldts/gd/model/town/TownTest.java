package pt.up.fe.ldts.gd.model.town;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.player.Player;

import java.io.IOException;

public class TownTest {
    @Test
    public void townTest() throws IOException {
        Player player = new Player("Courier");

        // Assuming the player came from wild with low hp
        player.setHP(10);

        Town town = new Town(player);

        Assertions.assertEquals(3, town.getOptions().size());
        Assertions.assertEquals("Courier", town.getPlayer().getName());
        Assertions.assertEquals(75, town.getPlayer().getHP());
        Assertions.assertEquals(3, town.getShop().getItems().size());
    }
}
