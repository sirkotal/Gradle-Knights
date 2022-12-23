package pt.up.fe.ldts.gd.model.wild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.player.Player;

import java.io.IOException;

public class EnemyTest {

    @Test
    public void enemyTest() throws IOException {
        Enemy enemy = new Enemy(10, 10, 10, 10);
        Player player = new Player("Saul");

        Assertions.assertTrue(enemy.isAlive());

        int initial_gold = player.getGold();
        Assertions.assertEquals(15, initial_gold);

        Assertions.assertEquals(10, enemy.getHP());
        enemy.setDamage(12);
        Assertions.assertEquals(12, enemy.getDamage());

        enemy.setHP(0);
        Assertions.assertFalse(enemy.isAlive());

        enemy.loot(player);

        Assertions.assertEquals(player.getGold(), initial_gold + enemy.getGold());
    }
}
