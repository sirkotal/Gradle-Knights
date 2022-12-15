package pt.up.fe.ldts.gd.model.player;

import pt.up.fe.ldts.gd.model.town.Town;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {
    private Player player;
    private List<Item> items;
    private List<String> options;
    private List<String> lines;

    public Inventory(Player player) throws IOException {
        this.player = player;
        this.items = new ArrayList<>();
        this.options = Arrays.asList("1: Equip", "2: Unequip", "3: Use", "4: Discard", "9: Exit", "0: Menu");
        this.lines = readAscii();
    }

    public List<Item> getItems(){
        return items;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public List<String> getLines() {
        return lines;
    }

    public Player getPlayer() {
        return player;
    }

    public void addItem(Item item) {
        boolean found = false;
        for (Item value : items) {
            if (value.equals(item)) {
                found = true;
                value.incCount();
            }
        }

        if(!found) {
            items.add(item);
            options.add(options.size() - 2, items.size() + ": " + item.getName() + "(" + item.getValue() + ")");
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item getItem(String name) {
        for (Item item: items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public Item getItem(int pos) {
        return items.get(pos);
    }

    public int size() {
        return this.items.size();
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public void showItem(String item_name) {
        for (Item item: items) {
            if (item.getName().equals(item_name)) {
                System.out.println("Name: " + item.getName());
                System.out.printf("Value: %d", item.getValue());
                return;
            }
        }
        System.out.println("No such item was found on your inventory!");
    }

    private List<String> readAscii() throws IOException {
        List<String> lines = new ArrayList<>();
        URL resource = Town.class.getResource("/ascii/inventory/inventory.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        for(String line; (line = br.readLine()) != null;)
            lines.add(line);

        return lines;
    }
}
