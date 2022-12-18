package pt.up.fe.ldts.gd.model.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.town.CheapStrategy;
import pt.up.fe.ldts.gd.model.town.ExpensiveStrategy;
import pt.up.fe.ldts.gd.model.town.Shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AmuletItemTest {
    @Test
    public void amuletTest() throws IOException {
        List<Item> list = new ArrayList<>();
        Player p1 = new Player("Saul");
        CombatItem sword = new CombatItem("Excalibur", 100, 5000);
        CombatItem axe = new CombatItem("Skullcracker", 90, 3500);
        list.add(sword);
        list.add(axe);

        Shop shop = new Shop(list, p1);
        shop.setStrategy(new ExpensiveStrategy());
        Assertions.assertTrue(shop.getStrategy() instanceof ExpensiveStrategy);

        AmuletItem amulet = new AmuletItem("Eye of Agamotto", 0, 1000000);
        Assertions.assertEquals("Eye of Agamotto", amulet.getName());
        Assertions.assertEquals(1000000, amulet.getPrice());
        Assertions.assertEquals(0, amulet.getValue());

        amulet.setUsed(true);
        amulet.changeStrategy(shop);
        Assertions.assertTrue(shop.getStrategy() instanceof CheapStrategy);
    }
}
