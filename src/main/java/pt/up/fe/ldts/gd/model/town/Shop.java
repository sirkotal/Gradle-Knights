package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.menu.Menu;
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
    private ShopStrategy strategy;// we can have an item to change from expensive to cheap
    private String message = "";
    public Shop(Shop shop) throws IOException {
        this.items = shop.getItems();
        this.lines = readAscii();
        this.player = shop.getPlayer();
        this.strategy = shop.getStrategy();
        this.options = shop.getOptions();
    }

    public Shop(List<Item> items, Player player) throws IOException {
        this.items = new ArrayList<>(items);
        this.lines = readAscii();
        this.player = player;

        Random rand = new Random();
        int random = rand.nextInt(10);
        boolean isExpensive; // used for options only
        if(random > 7) {
            this.strategy = new ExpensiveStrategy();
            isExpensive = true;
        }
        else {
            this.strategy = new CheapStrategy();
            isExpensive = false;
        }

        this.options = new ArrayList<>();
        // use with less than 5 items (needs to have another implementation to support more)
        for(int i = 1; i <= items.size(); i++) {
            Item item = items.get(i-1);
            if(isExpensive)
                options.add(i + ": " + item.getName() + "(" + item.getValue() + "/" + item.getPrice() * 2 + ")");
            else
                options.add(i + ": " + item.getName() + "(" + item.getValue() + "/" + item.getPrice() + ")");
        }
        options.add("9: Town");
        options.add("0: Menu");
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

    public void levelUp() {
        player.setDamage(player.getDamage()+1);
    }

    public Player getPlayer() {
        return player;
    }

    public List<String> getOptions() {
        return options;
    }

    public ShopStrategy getStrategy() {
        return strategy;
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
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
