package pt.up.fe.ldts.gd;

public class CombatItem extends Item {
    String type = "combat";
    public CombatItem(String name, int value, int price) {
        super(name, value, price);
    }

    public String getType() {
        return this.type;
    }

    public void setUsed() {
        this.used = true;
    }

    public void setUnused() {
        this.used = false;
    }
}
