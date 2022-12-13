package pt.up.fe.ldts.gd.model.player;

public class CombatItem extends Item {
    public CombatItem(String name, int value, int price) {
        super(name, value, price);
    }

    public void equip() {
        this.used = true;
    }

    public void unequip() {
        this.used = false;
    }

    public boolean isEquipped() {
        return this.used;
    }
}
