package pt.up.fe.ldts.gd.model.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {
    private List<Item> items;
    private Player player;
    private List<String> stats;
    private List<String> options;

    public Inventory(Player player) {
        this.items = new ArrayList<>();
        this.player = player;
        this.stats = new ArrayList<>();
        this.options = Arrays.asList("0: Menu", "1: Equip", "2: Unequip", "3: Use", "4: Discard", "5: Exit");
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
        boolean found = false;
        for (Item value : items) {
            if (value.equals(item)) {
                found = true;
                value.incCount();
            }
        }

        if(!found) {
            items.add(item);
            stats.add(items.size() + ": " + item.getName() + "(" + item.getValue() + ")");
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
}
