package pt.up.fe.ldts.gd.model.player;

public class PotionItem extends Item {
    public PotionItem(String name, int value, int price) {
        super(name, value, price);
        type = 0;
    }

    public void setUsed() {
        this.used = true;
    }

    public void refill() {
        if (this.used == true) {
            this.used = false;
        }
    }
}
