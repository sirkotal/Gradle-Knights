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
        wild.createEnemies();
        int initial_gold = player.getGold();

        int gold_loot = 0;
        int remaining_hp = player.getHP();
        for(Enemy enemy: wild.getEnemies()) {
            gold_loot += enemy.getGold();
            remaining_hp -= enemy.getDamage() * (enemy.getHp() / player.getDamage());
        }

        while(!wild.getEnemies().isEmpty())
            wild.fight(player);

        Assertions.assertEquals(initial_gold + gold_loot, player.getGold());
        Assertions.assertEquals(remaining_hp, player.getHP());
    }
}
