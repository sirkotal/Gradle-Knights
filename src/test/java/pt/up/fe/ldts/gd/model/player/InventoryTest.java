package pt.up.fe.ldts.gd.model.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    public void setup() throws IOException {
        Player player = Mockito.mock(Player.class);
        inventory = new Inventory(player);
    }

    @Test
    public void addAndRemoveItems() {
        CombatItem katana = new CombatItem("Uchigatana", 100, 5000);
        PotionItem potion = new PotionItem("Blood God's Offering", 200, 3500);
        inventory.addItem(katana);
        inventory.addItem(potion);
        Assertions.assertEquals(2, inventory.size());
        Assertions.assertEquals("Blood God's Offering", inventory.getItem(1).getName());
        Assertions.assertFalse(inventory.isEmpty());
        inventory.removeItem(potion);
        Assertions.assertEquals(1, inventory.size());
    }

    @Test
    public void addSameItem() {
        CombatItem item = new CombatItem("Degree", 1000, 1000000000);
        Assertions.assertEquals(2, inventory.getOptions().size());

        inventory.addItem(item);

        Assertions.assertEquals(1, inventory.size());
        Assertions.assertEquals(1, inventory.getItem(0).getCount());
        Assertions.assertEquals(3, inventory.getOptions().size());

        inventory.addItem(item);

        Assertions.assertEquals(1, inventory.size());
        Assertions.assertEquals(2, inventory.getItem(0).getCount());
        Assertions.assertEquals(3, inventory.getOptions().size());
    }

    @Test
    public void removeSameItem() {
        CombatItem item = new CombatItem("Degree", 1000, 1000000000);
        inventory.addItem(item);
        inventory.addItem(item);

        Assertions.assertEquals(1, inventory.size());
        Assertions.assertEquals(2, inventory.getItem(0).getCount());
        Assertions.assertEquals(3, inventory.getOptions().size());


        inventory.removeItem(item);

        Assertions.assertEquals(1, inventory.size());
        Assertions.assertEquals(1, inventory.getItem(0).getCount());
        Assertions.assertEquals(3, inventory.getOptions().size());

        inventory.removeItem(item);

        Assertions.assertEquals(0, inventory.size());
        Assertions.assertEquals(2, inventory.getOptions().size());
    }
}
