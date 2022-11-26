package pt.up.fe.ldts.gd;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;

    private int hp;

    private int damage;

    private int gold;

    private List<Item> inventory;

    public Player(String name) {
        this.name = name;
        this.hp = 100;
        this.damage = 15;
        this.gold = 10;
        this.inventory = new ArrayList<>();
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getHP() {
        return hp;
    }

    public String getName() {
        return name;
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