package pt.up.fe.ldts.gd.model.wild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.player.Player;

import java.io.IOException;

public class FightTest {
    @Test
    public void fightTest() throws IOException {
        Player player = new Player("Saul");
        Wild wild = new Wild(player);
        Fight fight = new Fight(wild.getPlayer(), wild.getEnemies());
        Assertions.assertEquals("Saul", fight.getPlayer().getName());
        Assertions.assertEquals(3, fight.getOptions().size());

        int initial_gold = wild.getPlayer().getGold();

        int gold_loot = 0;
        for(Enemy enemy: wild.getEnemies()) {
            gold_loot += enemy.getGold();
        }

        while(!wild.getEnemies().isEmpty() && wild.getPlayer().isAlive()) {
            fight.resultFight();
        }

        Assertions.assertTrue(wild.getPlayer().getGold() <= initial_gold + gold_loot);
    }
}
