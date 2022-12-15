package pt.up.fe.ldts.gd.model.town;

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
    private Player player;
    private Shop shop;
    private List<String> lines;
    private List<String> options;

    public Town(Player player) throws IOException {
        this.player = player;
        this.player.setHP(75);
        this.shop = createShop();
        this.lines = readAscii();

        this.options = Arrays.asList("1: Shop", "2: Wild", "0: Menu");
    }
    public Town(Player player, Shop shop) throws IOException{
        this.player = player;
        this.player.setHP(75);
        this.shop = shop;
        this.lines = readAscii();

        this.options = Arrays.asList("1: Shop", "2: Wild", "0: Menu");
    }

    public List<String> getLines() {
        return this.lines;
    }
    public List<String> getOptions() {
        return this.options;
    }

    // to be implemented
    private Shop createShop() throws IOException {
        List<Item> items = new ArrayList<>();

        List<String> combat_items = Arrays.asList("Sword", "Axe");
        for(String item_name: combat_items) {
            int value, price;

            URL resource = Town.class.getResource("/items/combat/" + item_name + ".txt");
            assert resource != null;

            BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
            String str = br.readLine();
            value = Integer.parseInt(str);
            str = br.readLine();
            price = Integer.parseInt(str);

            items.add(new CombatItem(item_name, value, price));
        }

        List<String> potion_items = Arrays.asList("HealthPotion");
        for(String item_name: potion_items) {
            int value, price;

            URL resource = Town.class.getResource("/items/potion/" + item_name + ".txt");
            assert resource != null;

            BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
            String str = br.readLine();
            value = Integer.parseInt(str);
            str = br.readLine();
            price = Integer.parseInt(str);

            items.add(new PotionItem(item_name, value, price));
        }

        return new Shop(items, player);
    }

    private List<String> readAscii() throws IOException {
        List<String> lines = new ArrayList<>();
        URL resource = Town.class.getResource("/ascii/town/town.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        for(String line; (line = br.readLine()) != null;)
            lines.add(line);

        return lines;
    }
    public Player getPlayer() {
        return this.player;
    }

    public Shop getShop() {
        return shop;
    }
}
