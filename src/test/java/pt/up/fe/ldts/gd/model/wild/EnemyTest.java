package pt.up.fe.ldts.gd.model.wild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.player.Player;

public class EnemyTest {

    @Test
    public void lootTest() {
        Enemy enemy = new Enemy(10, 10, 10, 10);
        Player player = new Player("Saul", 10);

        int initial_gold = player.getGold();
        Assertions.assertEquals(15, initial_gold);

        enemy.loot(player);

        Assertions.assertEquals(player.getGold(), initial_gold + enemy.getGold());
    }
}
