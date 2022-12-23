package pt.up.fe.ldts.gd.model.wild;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.player.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FightTest {
    private Player player;
    private Fight fight;
    private List<Enemy> enemies;

    @BeforeEach
    public void setup() throws IOException {
        player = new Player("Saul");
    }

    @Test
    public void playerWinAll() {
        enemies = new ArrayList<>(Arrays.asList(
                new Enemy(2, 10, 2, 2),
                new Enemy(2, 10, 2, 2),
                new Enemy(2, 10, 2, 2)
        ));

        fight = new Fight(player, enemies.get(0));

        Assertions.assertEquals(75, player.getHP());
        Assertions.assertEquals(15, player.getGold());
        Assertions.assertEquals(15, player.getDamage());

        fight.resultFight();

        Assertions.assertEquals(73, fight.getPlayer().getHP());
        Assertions.assertTrue(fight.getPlayer().getGold() >= 25 && fight.getPlayer().getGold() <= 35);
        Assertions.assertTrue(fight.getPlayer().isAlive());

        enemies.remove(0);
        Assertions.assertEquals(2, enemies.size());

        fight = new Fight(player, enemies.get(0));

        fight.getPlayer().setHP(75);
        fight.getPlayer().setGold(15);

        fight.resultFight();

        Assertions.assertEquals(73, fight.getPlayer().getHP());
        Assertions.assertTrue(fight.getPlayer().getGold() >= 25 && fight.getPlayer().getGold() <= 35);
        Assertions.assertTrue(fight.getPlayer().isAlive());

        enemies.remove(0);
        Assertions.assertEquals(1, enemies.size());

        fight = new Fight(player, enemies.get(0));

        fight.getPlayer().setHP(75);
        fight.getPlayer().setGold(15);

        int loot = fight.resultFight();

        Assertions.assertTrue(loot >= 10 && loot <= 20);

        Assertions.assertEquals(73, fight.getPlayer().getHP());
        Assertions.assertTrue(fight.getPlayer().getGold() >= 25 && fight.getPlayer().getGold() <= 35);
        Assertions.assertTrue(fight.getPlayer().isAlive());

        enemies.remove(0);
        Assertions.assertEquals(0, enemies.size());
    }

    @Test
    public void playerLose() {
        enemies = new ArrayList<>(Arrays.asList(
                new Enemy(2, 10, 50, 50),
                new Enemy(2, 10, 50, 50),
                new Enemy(2, 10, 50, 50)
        ));

        fight = new Fight(player, enemies.get(0));

        Assertions.assertEquals(75, player.getHP());
        Assertions.assertEquals(15, player.getGold());
        Assertions.assertEquals(15, player.getDamage());

        fight.resultFight();

        Assertions.assertEquals(25, fight.getPlayer().getHP());
        Assertions.assertTrue(fight.getPlayer().getGold() >= 25 && fight.getPlayer().getGold() <= 35);
        Assertions.assertTrue(fight.getPlayer().isAlive());

        enemies.remove(0);
        Assertions.assertEquals(2, enemies.size());

        fight = new Fight(player, enemies.get(0));

        fight.getPlayer().setGold(15);

        fight.resultFight();

        Assertions.assertEquals(15, fight.getPlayer().getGold());
        Assertions.assertFalse(fight.getPlayer().isAlive());

        Assertions.assertEquals(2, enemies.size());
    }
}
