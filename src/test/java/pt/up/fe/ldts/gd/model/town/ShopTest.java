package pt.up.fe.ldts.gd.model.town;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.up.fe.ldts.gd.model.player.CombatItem;
import pt.up.fe.ldts.gd.model.player.Item;
import pt.up.fe.ldts.gd.model.player.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopTest {
    List<Item> items;
    Shop shop;
    Player player;

    @BeforeEach
    public void setup() throws IOException {
        items = new ArrayList<>();
        items.add(new CombatItem("item1", 10, 10));
        items.add(new CombatItem("item2", 20, 20));
        player = new Player("Saul");
        player.setGold(50);
        shop = new Shop(items, player);
    }

    @Test
    public void buyNoDupTest() {
        Assertions.assertTrue(player.getInventory().isEmpty());
        Assertions.assertEquals(50, player.getGold());

        int spent = shop.buyItem("item1", false);

        Assertions.assertEquals(10, spent);

        Assertions.assertEquals(1, player.getInventory().size());
        Assertions.assertEquals(1, shop.getItems().size());

        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().get(0));
        Assertions.assertEquals(new CombatItem("item2", 20, 20), shop.getItems().get(0));
        Assertions.assertEquals(40, player.getGold());

        spent = shop.buyItem("item2", false);

        Assertions.assertEquals(20, spent);

        Assertions.assertEquals(2, player.getInventory().size());
        Assertions.assertEquals(0, shop.getItems().size());

        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().get(0));
        Assertions.assertEquals(new CombatItem("item2", 20, 20), player.getInventory().get(1));
        Assertions.assertEquals(20, player.getGold());
    }

    @Test
    public void buyDupTest() {
        Assertions.assertTrue(player.getInventory().isEmpty());
        Assertions.assertEquals(50, player.getGold());

        int spent = shop.buyItem("item1", true);

        Assertions.assertEquals(20, spent);

        Assertions.assertEquals(1, player.getInventory().size());
        Assertions.assertEquals(1, shop.getItems().size());

        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().get(0));
        Assertions.assertEquals(new CombatItem("item2", 20, 20), shop.getItems().get(0));
        Assertions.assertEquals(30, player.getGold());

        spent = shop.buyItem("item2", true);

        Assertions.assertEquals(-1, spent);

        Assertions.assertEquals(1, player.getInventory().size());
        Assertions.assertEquals(1, shop.getItems().size());

        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().get(0));
        Assertions.assertEquals(new CombatItem("item2", 20, 20), shop.getItems().get(0));
        Assertions.assertEquals(30, player.getGold());
    }
}
