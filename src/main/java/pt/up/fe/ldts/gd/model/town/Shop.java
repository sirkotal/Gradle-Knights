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

public class Shop {
    private final List<Item> items;
    private List<String> lines;
    private Player player;
    private List<String> options;

    public Shop(Shop shop) throws IOException {
        this.items = shop.getItems();
        this.lines = readAscii();
        this.player = shop.getPlayer();
        this.options = new ArrayList<>();
        // use with less than 5 items (needs to have another implementation to support more)
        for(int i = 1; i <= items.size(); i++) {
            options.add(i + ": " + items.get(i-1).getName());
        }
        options.add("9: Town");
        options.add("0: Menu");

        System.out.println(items.size());
    }

    public Shop(List<Item> items, Player player) throws IOException {
        this.items = new ArrayList<>(items);
        this.lines = readAscii();
        this.player = player;
    }

    public int buyItem(String itemName, boolean dup) {
        for(Item item: items) {
            if(item.getName().equals(itemName) &&
                    ((player.getGold() >= item.getValue() && !dup) ||
                            (player.getGold() >= item.getValue()*2 && dup))) {
                player.addItem(item);
                int spent = -1;
                if(dup) {
                    spent = item.getValue() * 2;
                    player.setGold(player.getGold() - spent);
                }
                else {
                    spent = item.getValue();
                    player.setGold(player.getGold() - spent);
                }
                items.remove(item);
                return spent;
            }
        }
        return -1;
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
