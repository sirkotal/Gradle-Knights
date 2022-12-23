package pt.up.fe.ldts.gd.model.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PlayerTest {
    Player player;
    @BeforeEach
    public void setup() throws IOException {
        player = new Player("Saul");
    }
    @Test
    public void InventoryTest() {
        CombatItem sword = new CombatItem("Excalibur", 100, 5000);
        CombatItem axe = new CombatItem("Skullcracker", 80, 3500);
        PotionItem potion = new PotionItem("Tap Water", 100, 100000);
        player.setGold(player.getGold() + 10);
        Assertions.assertEquals(25, player.getGold());
        Assertions.assertEquals(75, player.getHP());
        player.addItem(sword);
        player.addItem(axe);
        player.addItem(potion);
        Assertions.assertEquals(3, player.getInventory().size());
        player.removeItem(potion);
        Assertions.assertEquals(2, player.getInventory().size());
    }

    @Test
    public void PotionTest() {
        PotionItem potion = new PotionItem("Tap Water", 100, 100000);
        Assertions.assertEquals(75, player.getHP());
        player.addItem(potion);
        Assertions.assertEquals(1, player.getInventory().size());
        player.use(potion);
        Assertions.assertEquals(175, player.getHP());
        Assertions.assertEquals(0, player.getInventory().size());
    }

    @Test
    public void WeaponTest() {
        Assertions.assertEquals("Saul", player.getName());
        Assertions.assertTrue(player.isAlive());
        Assertions.assertEquals(15, player.getDamage());

        CombatItem sword = new CombatItem("Excalibur", 100, 5000);
        CombatItem axe = new CombatItem("Skullcracker", 90, 3500);
        player.addItem(sword);
        player.addItem(axe);
        Assertions.assertEquals(2, player.getInventory().size());
        Assertions.assertEquals(2, player.getInventory().size());
        Assertions.assertFalse(player.getInventory().getItem(0).isUsed());
        Assertions.assertFalse(player.getInventory().getItem(1).isUsed());

        player.use(sword);
        Assertions.assertTrue(player.getInventory().getItem(0).isUsed());
        Assertions.assertFalse(player.getInventory().getItem(1).isUsed());
        Assertions.assertEquals(115, player.getDamage());

        player.use(axe);
        Assertions.assertFalse(player.getInventory().getItem(0).isUsed());
        Assertions.assertTrue(player.getInventory().getItem(1).isUsed());
        Assertions.assertEquals(105, player.getDamage());

        String before = player.getInventory().getOptions().get(1); // axe

        player.use(axe);
        Assertions.assertFalse(player.getInventory().getItem(0).isUsed());
        Assertions.assertFalse(player.getInventory().getItem(1).isUsed());
        Assertions.assertEquals(15, player.getDamage());
        Assertions.assertNotEquals(player.getInventory().getOptions().get(1), before);
    }

    @Test
    public void itemDoesNotExist() {
        CombatItem item = new CombatItem("item", 10, 10);

        Assertions.assertEquals(15, player.getDamage());
        Assertions.assertEquals(0, player.getInventory().size());

        player.use(item);

        Assertions.assertEquals(15, player.getDamage());
        Assertions.assertEquals(0, player.getInventory().size());
    }
}

