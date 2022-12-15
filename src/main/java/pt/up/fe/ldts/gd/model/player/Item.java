package pt.up.fe.ldts.gd.model.player;


public abstract class Item {
    private String name;
    private int price;
    private int value;  // functional value of the item
    protected boolean used = false;
    private int count;

    protected int type; // 0 for potions, 1 for combat

    public Item(String name, int value, int price) {
        this.name = name;
        this.value = value;
        this.price = price;
        this.count = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void incCount() {
        this.count += 1;
    }

    public abstract void setUsed();
    
}
