package pt.up.fe.ldts.gd.model.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class InventoryTest {
    @Test
    public void inventoryTest() throws IOException {
        Player p1 = new Player("Walter White");
        Inventory inv = new Inventory(p1);
        CombatItem katana = new CombatItem("Uchigatana", 100, 5000);
        PotionItem potion = new PotionItem("Blood God's Offering", 200, 3500);
        inv.addItem(katana);
        inv.addItem(potion);
        Assertions.assertEquals(2, inv.size());
        Assertions.assertEquals("Blood God's Offering", inv.getItem(1).getName());
        Assertions.assertFalse(inv.isEmpty());
        inv.removeItem(potion);
        Assertions.assertEquals(1, inv.size());
    }
}
