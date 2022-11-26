import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.Item;
import pt.up.fe.ldts.gd.Player;
import pt.up.fe.ldts.gd.Shop;


import java.util.Arrays;
import java.util.List;

public class ShopTest {
    @Test
    public void shopTesting() {
        List<Item> items = Arrays.asList(new Item("item1", 10), new Item("item2", 20));
        Shop shop = new Shop(items);
        Player player = new Player(50);

        Assertions.assertTrue(player.getInventory().isEmpty());
        Assertions.assertEquals(50, player.getGold());

        shop.buyItem(player, "item1");

        Assertions.assertEquals(1, player.getInventory().size());
        Assertions.assertEquals(1, shop.getItems().size());
    }
}
