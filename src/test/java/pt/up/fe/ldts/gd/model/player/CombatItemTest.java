package pt.up.fe.ldts.gd.model.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CombatItemTest {
    @Test
    public void combatItemsTest() throws IOException {
        Player player = new Player("Gus");
        CombatItem sword = new CombatItem("Excalibur", 100, 5000);
        CombatItem mace = new CombatItem("Mace of Molag Bal", 120, 7500);
        mace.setName("Horksbane");
        Assertions.assertEquals("Horksbane", mace.getName());
        Assertions.assertEquals("Excalibur", sword.getName());
        Assertions.assertEquals(5000, sword.getPrice());
        Assertions.assertEquals(100, sword.getValue());
        Assertions.assertEquals(1, sword.getCount());
        Assertions.assertFalse(sword.isEquipped());

        Assertions.assertEquals(sword.getName() + " [Equipped]", sword.getNameEquipped());

        player.addItem(sword);
        player.use(sword);
        Assertions.assertTrue(sword.isEquipped());

        sword.setUsed(false);
        Assertions.assertFalse(sword.isEquipped());
    }
}

