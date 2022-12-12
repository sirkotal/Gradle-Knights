package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.player.CombatItem;
import pt.up.fe.ldts.gd.model.player.Item;
import pt.up.fe.ldts.gd.model.player.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop {
    private final List<Item> items;
    private List<String> lines;
    private Player player;
    private List<String> options;
    private ShopStrategy strategy;

    public Shop(Shop shop) throws IOException {
        this.items = shop.getItems();
        this.lines = readAscii();
        this.player = shop.getPlayer();
        this.options = new ArrayList<>();
        // use with less than 5 items (needs to have another implementation to support more)
        for(int i = 1; i <= items.size(); i++) {
            Item item = items.get(i-1);
            options.add(i + ": " + item.getName() + "(" + item.getValue() + "/" + item.getPrice() + ")");
        }
        options.add("9: Town");
        options.add("0: Menu");

        Random rand = new Random();
        int random = rand.nextInt(10);
        if(random > 7)
            this.strategy = new ExpensiveStrategy();
        else
            this.strategy = new CheapStrategy();
    }

    public Shop(List<Item> items, Player player) throws IOException {
        this.items = new ArrayList<>(items);
        this.lines = readAscii();
        this.player = player;
    }

    public void buyItem(Item item) {
        boolean flag = strategy.buyItem(item, player);
        // use the flag to set some message like town
    }

    public List<Item> getItems(){
        return items;
    }

    public List<String> getLines() {
        return lines;
    }

    public Player getPlayer() {
        return player;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setStrategy(ShopStrategy strategy) {
        this.strategy = strategy;
    }

    private List<String> readAscii() throws IOException {
        List<String> lines = new ArrayList<>();
        URL resource = Menu.class.getResource("/ascii/town/shop.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        for(String line; (line = br.readLine()) != null;)
            lines.add(line);

        return lines;
    }
}
