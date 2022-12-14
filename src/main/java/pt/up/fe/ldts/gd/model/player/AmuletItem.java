package pt.up.fe.ldts.gd.model.player;

import pt.up.fe.ldts.gd.model.town.CheapStrategy;
import pt.up.fe.ldts.gd.model.town.ExpensiveStrategy;
import pt.up.fe.ldts.gd.model.town.Shop;

public class AmuletItem extends Item {
    public AmuletItem(String name, int value, int price) {
        super(name, value, price);
    }

    public void changeStrategy(Shop shop) {
        if (this.used)
            shop.setStrategy(new CheapStrategy());
    }

    public void setUsed() {
        this.used = true;
    }
}
