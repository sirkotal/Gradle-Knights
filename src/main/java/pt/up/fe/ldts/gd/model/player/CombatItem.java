package pt.up.fe.ldts.gd.model.player;

public class CombatItem extends Item {
    public CombatItem(String name, int value, int price) {
        super(name, value, price);
    }

    public boolean isEquipped() {
        return isUsed();
    }
}
