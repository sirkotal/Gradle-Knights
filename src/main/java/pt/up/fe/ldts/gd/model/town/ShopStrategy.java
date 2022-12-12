package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.player.Item;
import pt.up.fe.ldts.gd.model.player.Player;

public interface ShopStrategy {
    boolean buyItem(Item item, Player player);
}
