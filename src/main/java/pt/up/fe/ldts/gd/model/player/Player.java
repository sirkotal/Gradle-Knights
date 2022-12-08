package pt.up.fe.ldts.gd.model.player;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int gold;
    private String name;
    private int hp;
    private int damage;
    private final List<Item> inventory;

    public Player(String name) {
        this.name = name;
        this.hp = 100;
        this.damage = 15;
        this.gold = 15;
        this.inventory = new ArrayList<>();
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

    public Item getItem(String name) {
        for (Item item: inventory) {
            if (item.getName() == name) {
                return item;
            }
        }
        return null;
    }

    public void showItem(String name) {
        for (Item item: inventory) {
            if (item.getName() == name) {
                System.out.println("Name: " + item.getName());
                System.out.printf("Value: %d", item.getValue());
                System.out.println();
                System.out.printf("Price: %d", item.getPrice());
                return;
            }
        }
        System.out.println("No such item was found on your inventory!");
    }


    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void addHP(int points) {
        this.hp += points;
    }

    public void loseHP(int points) {
        this.hp -= points;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isAlive() {
        if (this.hp == 0) {
            return false;
        }
        return true;
    }
}