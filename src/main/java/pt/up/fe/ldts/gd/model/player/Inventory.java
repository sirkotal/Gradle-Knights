package pt.up.fe.ldts.gd.model.player;

import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.model.player.Player;
import pt.up.fe.ldts.gd.model.player.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;
    private Player player;

    private List<String> stats;

    private List<String> options;

    public Inventory(List<Item> items, Player player) throws IOException {
        this.items = new ArrayList<>(items);
        this.player = player;
        this.stats = new ArrayList<>();
        this.options = new ArrayList<>();

        for(int i = 0; i <= items.size() - 1; i++) {
            Item item = items.get(i);
            stats.add(i + ": " + item.getName() + "(" + item.getValue() + "/" + item.getPrice() + ")");
        }

        options.add("0: Menu");
        options.add("1: Equip");
        options.add("2. Unequip");
        options.add("3. Use");
        options.add("4. Discard");
        options.add("5. Exit");
    }

    public List<Item> getItems(){
        return items;
    }

    public Player getPlayer() {
        return player;
    }

    public List<String> getStats() {
        return this.stats;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public void addItem(Item item) {
        items.add(item);
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

    public void showItem(String item_name) {
        for (Item item: items) {
            if (item.getName().equals(item_name)) {
                System.out.println("Name: " + item.getName());
                System.out.printf("Value: %d", item.getValue());
                System.out.println();
                System.out.printf("Price: %d", item.getPrice());
                return;
            }
        }
        System.out.println("No such item was found on your inventory!");
    }
}
