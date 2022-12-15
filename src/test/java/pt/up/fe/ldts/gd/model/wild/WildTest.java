package pt.up.fe.ldts.gd.model.wild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.player.Player;

import java.io.IOException;

public class WildTest {

    @Test
    public void fightTest() throws IOException {
        Player player = new Player("Saul");
        Wild wild = new Wild(player);

        int initial_gold = wild.getPlayer().getGold();

        int gold_loot = 0;
        for(Enemy enemy: wild.getEnemies()) {
            gold_loot += enemy.getGold();
        }

        while(!wild.getEnemies().isEmpty() && wild.getPlayer().isAlive()) {
            wild.fight();
        }

        Assertions.assertTrue(wild.getPlayer().getGold() <= initial_gold + gold_loot);
    }
}
