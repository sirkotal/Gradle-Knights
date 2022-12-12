package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.player.CombatItem;
import pt.up.fe.ldts.gd.model.player.Item;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.player.PotionItem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Town {
    private Player player;
    private Shop shop;
    private TownStrategy strategy;

    public Town(Player player) throws IOException {
        this.player = player;
        this.shop = createShop();
        Random rand = new Random();
        int random = rand.nextInt(10);
        if(random > 7)
            this.strategy = new ExpensiveStrategy();
        else
            this.strategy = new CheapStrategy();
    }

    // to be implemented
    private Shop createShop() throws IOException {
        List<Item> items = new ArrayList<>();

        List<String> combat_items = Arrays.asList("sword", "axe");
        for(String item_name: combat_items) {
            int value, price;

            URL resource = Town.class.getResource("/items/" + item_name + ".txt");
            assert resource != null;

            BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
            String str = br.readLine();
            value = Integer.parseInt(str);
            str = br.readLine();
            price = Integer.parseInt(str);

            items.add(new CombatItem(item_name, value, price));
        }

        /*
        List<String> potion_items = new ArrayList<>();
        for(String item_name: potion_items) {
            int value, price;

            URL resource = Town.class.getResource("/items/" + item_name + ".txt");
            assert resource != null;

            BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
            String str = br.readLine();
            value = Integer.parseInt(str);
            str = br.readLine();
            price = Integer.parseInt(str);

            items.add(new PotionItem(item_name, value, price));
        }
         */

        return new Shop(items);
    }

    public boolean buyItem(String itemName) {
        return strategy.buyItem(shop, player, itemName);
    }
}
