package pt.up.fe.ldts.gd.model;

public class PotionItem extends Item {
    public PotionItem(String name, int value, int price) {
        super(name, value, price);
    }

    public void setUsed() {
        this.used = true;
    }
}