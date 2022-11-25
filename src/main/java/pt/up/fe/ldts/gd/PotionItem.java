package pt.up.fe.ldts.gd;

public class PotionItem extends Item {
    String type = "potion";
    public PotionItem(String name, int value, int price) {
        super(name, value, price);
    }

    public String getType() {
        return this.type;
    }

    public void setUsed() {
        this.used = true;
    }
}
