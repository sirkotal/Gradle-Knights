package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.player.Item;
import pt.up.fe.ldts.gd.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<Item> items;

    public Shop(List<Item> items) {
        this.items = new ArrayList<>(items);
    }

    public int buyItem(Player player, String itemName, boolean dup) {
        for(Item item: items) {
            if(item.getName().equals(itemName) &&
                    ((player.getGold() >= item.getValue() && !dup) ||
                            (player.getGold() >= item.getValue()*2 && dup))) {
                player.addItem(item);
                int spent = -1;
                if(dup) {
                    spent = item.getValue() * 2;
                    player.setGold(player.getGold() - spent);
                }
                else {
                    spent = item.getValue();
                    player.setGold(player.getGold() - spent);
                }
                items.remove(item);
                return spent;
            }
        }
        return -1;
    }

    public List<Item> getItems(){
        return items;
    }
}
