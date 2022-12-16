package pt.up.fe.ldts.gd.model.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CombatItemTest {
    @Test
    public void swordTest() {
        CombatItem sword = new CombatItem("Excalibur", 100, 5000);
        Assertions.assertEquals("Excalibur", sword.getName());
        Assertions.assertEquals(5000, sword.getPrice());
        Assertions.assertEquals(100, sword.getValue());
        sword.setUsed(true);
        Assertions.assertTrue(sword.isEquipped());
    }
}

