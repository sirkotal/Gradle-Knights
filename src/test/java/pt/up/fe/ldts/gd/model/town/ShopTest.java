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
        shop.setStrategy(new CheapStrategy());
        Assertions.assertTrue(player.getInventory().isEmpty());
        Assertions.assertEquals(50, player.getGold());

        shop.buyItem(items.get(0));

        Assertions.assertEquals(40, player.getGold());
        Assertions.assertEquals(1, player.getInventory().size());
        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().getItem(0));

        shop.buyItem(items.get(1));

        Assertions.assertEquals(2, player.getInventory().size());
        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().getItem(0));
        Assertions.assertEquals(new CombatItem("item2", 20, 20), player.getInventory().getItem(1));
        Assertions.assertEquals(20, player.getGold());
    }

    @Test
    public void buyDupTest() {
        shop.setStrategy(new ExpensiveStrategy());
        Assertions.assertTrue(player.getInventory().isEmpty());
        Assertions.assertEquals(50, player.getGold());

        shop.buyItem(items.get(0));

        Assertions.assertEquals(1, player.getInventory().size());

        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().getItem(0));
        Assertions.assertEquals(30, player.getGold());

        shop.buyItem(items.get(1));

        Assertions.assertEquals(1, player.getInventory().size());

        Assertions.assertEquals(new CombatItem("item1", 10, 10), player.getInventory().getItem(0));
        Assertions.assertEquals(30, player.getGold());
    }

    @Test
    public void levelUpTest() {
        shop.setMessage("Welcome to the Shop!");
        Assertions.assertEquals("Welcome to the Shop!", shop.getMessage());
        Player p2 = shop.getPlayer();
        Assertions.assertEquals("Saul", p2.getName());
        shop.levelUp();
        Assertions.assertEquals(16, player.getDamage());
    }
}
