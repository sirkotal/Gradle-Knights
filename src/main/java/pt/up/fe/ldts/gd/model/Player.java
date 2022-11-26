package pt.up.fe.ldts.gd.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int gold;
    private final List<Item> inventory;

    public Player(int gold) {
        this.gold = gold;
        this.inventory = new ArrayList<>();
    }

    public Player(List<Item> inventory) {
        this.gold = 10;
        this.inventory = inventory;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }
}
