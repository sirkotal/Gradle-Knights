package pt.up.fe.ldts.gd.model.player;

public class Player {
    private int gold;
    private String name;
    private int hp;
    private int damage;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.hp = 75;
        this.damage = 15;
        this.gold = 15;
        this.inventory = new Inventory(this);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addItem(Item item) {
        inventory.addItem(item);
    }

    public void removeItem(Item item) {
        inventory.removeItem(item);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
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
        return this.hp > 0;
    }
}
