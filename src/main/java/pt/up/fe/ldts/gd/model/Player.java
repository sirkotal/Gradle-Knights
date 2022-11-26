package pt.up.fe.ldts.gd.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;

    private int hp;

    private int damage;

    private int gold;

    private final List<Item> inventory;

    public Player(String name, int damage) {
        this.name = name;
        this.damage = damage;
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


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
