package pt.up.fe.ldts.gd.model;


import java.util.ArrayList;
import java.util.List;

public abstract class Item {
    private String name;
    private int price;
    private int value;  // dmg + value, se for Abstract
    boolean used = false;

    public Item(String name, int value, int price) {
        this.name = name;
        this.value = value;
        this.price = price;
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

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;

        if(!(obj instanceof Item))
            return false;

        Item i = (Item) obj;

        return name.equals(i.getName());
    }

    public abstract void setUsed();
}
