package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.AsciiReader;
import pt.up.fe.ldts.gd.model.player.CombatItem;
import pt.up.fe.ldts.gd.model.player.Item;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.player.PotionItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Town {
    private final Player player;
    private final Shop shop;
    private final List<String> lines;
    private final List<String> options;

    public Town(Player player) throws IOException {
        this.player = player;
        this.player.setHP(75);
        this.shop = createShop();
        this.lines = AsciiReader.readAscii("/ascii/town/town.txt");
        this.options = Arrays.asList("1: Shop", "2: Wild", "0: Menu");
    }

    public List<String> getLines() {
        return this.lines;
    }
    public List<String> getOptions() {
        return this.options;
    }

    private Shop createShop() throws IOException {
        List<Item> items = new ArrayList<>();

        List<String> combat_items = Arrays.asList("Sword", "Axe");
        for(String item_name: combat_items) {
            items.add(readItem(item_name, "combat"));
        }

        List<String> potion_items = Arrays.asList("HealthPotion");
        for(String item_name: potion_items) {
            items.add(readItem(item_name, "potion"));
        }

        return new Shop(items, player);
    }

    private Item readItem(String item_name, String type) throws IOException {
        int value, price;

        if(!type.equals("potion") && !type.equals("combat"))
            throw new Error("type not found [available types are: \"combat\", \"potion\"]");

        URL resource = Town.class.getResource("/items/" + type + "/" + item_name + ".txt");
        assert resource != null;

        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        String str = br.readLine();
        value = Integer.parseInt(str);
        str = br.readLine();
        price = Integer.parseInt(str);

        if(type.equals("combat"))
            return new CombatItem(item_name, value, price);
        else
            return new PotionItem(item_name, value, price);
    }

    public Player getPlayer() {
        return this.player;
    }

    public Shop getShop() {
        return shop;
    }
}
