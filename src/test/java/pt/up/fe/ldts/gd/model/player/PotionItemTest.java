package pt.up.fe.ldts.gd.model.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PotionItemTest {
    @Test
    public void potionTest() throws IOException {
        Player p1 = new Player("Amogus");
        PotionItem potion = new PotionItem("Holy Orange Juice", 100, 10000);
        Assertions.assertEquals("Holy Orange Juice", potion.getName());
        Assertions.assertEquals(10000, potion.getPrice());
        Assertions.assertEquals(100, potion.getValue());
        Assertions.assertFalse(potion.isUsed());

        p1.addItem(potion);
        p1.use(potion);
        Assertions.assertEquals(0, p1.getInventory().size());
        Assertions.assertEquals(175, p1.getHP());
    }
}