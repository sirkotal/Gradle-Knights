package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.player.Item;
import pt.up.fe.ldts.gd.model.player.Player;

public class ExpensiveStrategy implements ShopStrategy {
    public ExpensiveStrategy() {}

    @Override
    public boolean buyItem(Item item, Player player) {
        if(player.getGold() >= item.getPrice()*2) {
            player.addItem(item);
            int spent = item.getPrice() * 2;
            player.setGold(player.getGold() - spent);
            return true;
        }
        return false;
    }
}
