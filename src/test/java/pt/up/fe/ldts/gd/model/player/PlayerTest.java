package pt.up.fe.ldts.gd.model.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PlayerTest {
    Player p1;
    @BeforeEach
    public void setup() throws IOException {
        p1 = new Player("Saul");
    }
    @Test
    public void InventoryTest() throws IOException {
        CombatItem sword = new CombatItem("Excalibur", 100, 5000);
        CombatItem axe = new CombatItem("Skullcracker", 80, 3500);
        PotionItem potion = new PotionItem("Tap Water", 100, 100000);
        p1.setGold(p1.getGold() + 10);
        Assertions.assertEquals(25, p1.getGold());
        Assertions.assertEquals(75, p1.getHP());
        p1.addItem(sword);
        p1.addItem(axe);
        p1.addItem(potion);
        Assertions.assertEquals(3, p1.getInventory().size());
        p1.removeItem(potion);
        Assertions.assertEquals(2, p1.getInventory().size());
    }

    @Test
    public void PotionTest() throws IOException {
        PotionItem potion = new PotionItem("Tap Water", 100, 100000);
        Assertions.assertEquals(75, p1.getHP());
        p1.addItem(potion);
        Assertions.assertEquals(1, p1.getInventory().size());
        p1.use(potion);
        Assertions.assertEquals(175, p1.getHP());
        Assertions.assertEquals(0, p1.getInventory().size());
    }

    @Test
    public void WeaponTest() throws IOException {
        Assertions.assertEquals("Saul", p1.getName());
        Assertions.assertEquals(true, p1.isAlive());
        CombatItem sword = new CombatItem("Excalibur", 100, 5000);
        CombatItem axe = new CombatItem("Skullcracker", 90, 3500);
        Assertions.assertEquals(15, p1.getDamage());
        p1.addItem(sword);
        p1.addItem(axe);
        Assertions.assertEquals(2, p1.getInventory().size());
        p1.use(sword);
        Assertions.assertEquals(115, p1.getDamage());
        p1.use(axe);
        Assertions.assertEquals(105, p1.getDamage());
        Assertions.assertEquals(2, p1.getInventory().size());
    }
}

