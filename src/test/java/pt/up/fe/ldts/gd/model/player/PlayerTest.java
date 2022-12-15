package pt.up.fe.ldts.gd.model.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    public void potionTest() {
        Player p1 = new Player("Saul");
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
}

