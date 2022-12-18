package pt.up.fe.ldts.gd.model.player;


public abstract class Item {
    private String name;
    private String nameEquipped;
    private int price;
    private int value;  // functional value of the item
    private boolean used = false;
    private int count;

    public Item(String name, int value, int price) {
        this.name = name;
        this.nameEquipped = name + " [Equipped]";
        this.value = value;
        this.price = price;
        this.count = 1;
    }

    public String getName() {
        return this.name;
    }

    public String getNameEquipped() {
        return nameEquipped;
    }

    public void setName(String name) {
        this.name = name;
        this.nameEquipped = name + " [Equipped]";
    }

    public int getPrice() {
        return this.price;
    }

    public int getValue() {
        return this.value;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
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
}
