package pt.up.fe.ldts.gd;

public abstract class Item {
    private String name;
    private int price;
    private int value;  // dmg + value, se for Abstract
    boolean used = false;

    private String type;

    private int hp;
    private int atk;
    private int def;

    public Item(String name, int value, int price) {
        this.name = name;
        this.value = value;
        this.price = price;
    }

    public boolean isEquipped() {
        return this.used;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getValue() {
        return this.value;
    }

    public abstract void setUsed();

}
