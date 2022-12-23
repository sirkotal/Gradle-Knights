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
    public void buyCheapTest() {
        shop.setStrategy(new CheapStrategy());
        Assertions.assertTrue(player.getInventory().isEmpty());
        Assertions.assertEquals(50, player.getGold());

        Assertions.assertEquals(shop.getOptions().get(0), "1: item1(10/10)");
        Assertions.assertEquals(shop.getOptions().get(1), "2: item2(20/20)");

        Assertions.assertTrue(shop.buyItem(items.get(0)));

        Assertions.assertEquals(40, player.getGold());
        Assertions.assertEquals(1, player.getInventory().size());
        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().getItem(0));

        Assertions.assertTrue(shop.buyItem(items.get(1)));

        Assertions.assertEquals(2, player.getInventory().size());
        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().getItem(0));
        Assertions.assertEquals(new CombatItem("item2", 20, 20), player.getInventory().getItem(1));
        Assertions.assertEquals(20, player.getGold());

        player.setGold(10);
        player.removeItem(shop.getItems().get(1));

        Assertions.assertFalse(shop.buyItem(items.get(1)));

        Assertions.assertEquals(1, player.getInventory().size());
        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().getItem(0));
        Assertions.assertEquals(10, player.getGold());
    }

    @Test
    public void buyExpensiveTest() {
        shop.setStrategy(new ExpensiveStrategy());
        Assertions.assertTrue(player.getInventory().isEmpty());
        Assertions.assertEquals(50, player.getGold());

        Assertions.assertEquals(shop.getOptions().get(0), "1: item1(10/20)");
        Assertions.assertEquals(shop.getOptions().get(1), "2: item2(20/40)");

        Assertions.assertTrue(shop.buyItem(items.get(0)));

        Assertions.assertEquals(1, player.getInventory().size());

        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().getItem(0));
        Assertions.assertEquals(30, player.getGold());

        Assertions.assertFalse(shop.buyItem(items.get(1)));

        Assertions.assertEquals(1, player.getInventory().size());

        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().getItem(0));
        Assertions.assertEquals(30, player.getGold());
    }

    @Test
    public void spendAllGold() {
        shop.setStrategy(new ExpensiveStrategy());

        player.setGold(20);
        Assertions.assertTrue(shop.buyItem(items.get(0)));
        Assertions.assertEquals(0, player.getGold());

        player.setGold(40);
        Assertions.assertTrue(shop.buyItem(items.get(1)));
        Assertions.assertEquals(0, player.getGold());

        player.removeItem(shop.getItems().get(0));
        player.removeItem(shop.getItems().get(1));

        shop.setStrategy(new CheapStrategy());

        player.setGold(10);
        Assertions.assertTrue(shop.buyItem(items.get(0)));
        Assertions.assertEquals(0, player.getGold());

        player.setGold(20);
        Assertions.assertTrue(shop.buyItem(items.get(1)));
        Assertions.assertEquals(0, player.getGold());
    }
}
