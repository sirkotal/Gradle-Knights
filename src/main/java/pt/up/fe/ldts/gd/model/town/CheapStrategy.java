package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.player.Player;

public class CheapStrategy implements TownStrategy {
    public CheapStrategy() {}

    @Override
    public boolean buyItem(Shop shop, Player player, String itemName) {
        int spent = shop.buyItem(player, itemName, false);
        return spent != -1;
    }
}
