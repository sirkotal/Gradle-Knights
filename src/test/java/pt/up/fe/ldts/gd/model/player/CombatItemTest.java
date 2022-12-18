package pt.up.fe.ldts.gd.model.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CombatItemTest {
    @Test
    public void swordTest() throws IOException {
        Player p1 = new Player("Gus");
        CombatItem sword = new CombatItem("Excalibur", 100, 5000);
        Assertions.assertEquals("Excalibur", sword.getName());
        Assertions.assertEquals(5000, sword.getPrice());
        Assertions.assertEquals(100, sword.getValue());
        Assertions.assertEquals(1, sword.getCount());
        Assertions.assertFalse(sword.isEquipped());

        Assertions.assertEquals("Excalibur [Equipped]", sword.getNameEquipped());
        p1.use(sword);
        Assertions.assertTrue(sword.isEquipped());
        sword.setUsed(false);
        Assertions.assertFalse(sword.isEquipped());
    }
}

