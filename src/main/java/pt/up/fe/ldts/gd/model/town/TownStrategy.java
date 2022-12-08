package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.player.Player;

public interface TownStrategy {
    boolean buyItem(Shop shop, Player player, String itemName);
}
