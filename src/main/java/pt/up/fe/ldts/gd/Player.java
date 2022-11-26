package pt.up.fe.ldts.gd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;

    private int hp = 100;

    private int atk;

    private int gold = 50;

    private List<Item> inventory = new ArrayList<>();

    public Player(String name, int atk) {
        this.name = name;
        this.atk = atk;
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