package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.player.Item;
import pt.up.fe.ldts.gd.model.player.Player;

public class CheapStrategy implements ShopStrategy {
    public CheapStrategy() {}

    @Override
    public boolean buyItem(Item item, Player player) {
        if(player.getGold() >= item.getValue()) {
            player.addItem(item);
            int spent = item.getValue();
            player.setGold(player.getGold() - spent);
            return true;
        }
        return false;
    }
}
