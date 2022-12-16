package pt.up.fe.ldts.gd.model.player;

public class PotionItem extends Item {
    public PotionItem(String name, int value, int price) {
        super(name, value, price);
    }

    public void refill() {
        if (isUsed()) {
            setUsed(false);
        }
    }
}
