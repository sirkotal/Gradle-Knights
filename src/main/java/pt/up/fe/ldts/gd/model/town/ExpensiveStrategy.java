package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.player.Player;

public class ExpensiveStrategy implements TownStrategy {
    public ExpensiveStrategy() {}

    @Override
    public boolean buyItem(Shop shop, Player player, String itemName) {
        int spent = shop.buyItem(player, itemName, true);
        return spent != -1;
    }
}
