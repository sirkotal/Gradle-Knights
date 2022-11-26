package pt.up.fe.ldts.gd.model.wild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.model.Player;

public class WildTest {
    @Test
    public void fightTest() {
        Player player = new Player();
        Wild wild = new Wild(player);

        int gold_loot = 0;
        int remaining_hp = player.getHp();
        for(Enemy enemy: wild.getEnemies()) {
            gold_loot += enemy.getGold();
            remaining_hp -= enemy.getDamage() * (enemy.getHp() / player.getAtk());
        }

        while(!wild.getEnemies().isEmpty())
            wild.fight(player);

        Assertions.assertEquals(10 + gold_loot, player.getGold());
        Assertions.assertEquals(remaining_hp, player.getHp());
    }
}
