package pt.up.fe.ldts.gd.model.wild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.Player;

public class EnemyTest {

    @Test
    public void lootTest() {
        Enemy enemy = new Enemy(10, 10, 10, 10);
        Player player = new Player();

        int initial_gold = player.getGold();
        Assertions.assertEquals(10, initial_gold);

        enemy.loot(player);

        Assertions.assertEquals(player.getGold(), initial_gold + enemy.getGold());
    }
}
