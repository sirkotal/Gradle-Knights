package pt.up.fe.ldts.gd.model.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pt.up.fe.ldts.gd.model.town.CheapStrategy;
import pt.up.fe.ldts.gd.model.town.ExpensiveStrategy;
import pt.up.fe.ldts.gd.model.town.Shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AmuletItemTest {
    @Test
    public void amuletTest() throws IOException {
        Player player = Mockito.mock(Player.class);

        Shop shop = new Shop(new ArrayList<>(), player);
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
