package pt.up.fe.ldts.gd.model.wild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.player.Player;

import java.io.IOException;

public class EnemyTest {

    @Test
    public void lootTest() throws IOException {
        Enemy enemy = new Enemy(10, 10, 10, 10);
        Player player = new Player("Saul");

        int initial_gold = player.getGold();
        Assertions.assertEquals(15, initial_gold);

        enemy.loot(player);

        Assertions.assertEquals(player.getGold(), initial_gold + enemy.getGold());
    }
}
