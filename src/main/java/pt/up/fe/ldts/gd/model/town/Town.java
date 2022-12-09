package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.player.Player;

import java.util.ArrayList;
import java.util.Random;

public class Town {
    private Player player;
    private Shop shop;
    private TownStrategy strategy;

    public Town(Player player) {
        this.player = player;
        this.shop = createShop();
        Random rand = new Random();
        int random = rand.nextInt(10);
        if(random > 7)
            this.strategy = new ExpensiveStrategy();
        else
            this.strategy = new CheapStrategy();
    }

    // to be implemented
    private Shop createShop() {
        return new Shop(new ArrayList<>());
    }

    public boolean buyItem(String itemName) {
        return strategy.buyItem(shop, player, itemName);
    }
}
