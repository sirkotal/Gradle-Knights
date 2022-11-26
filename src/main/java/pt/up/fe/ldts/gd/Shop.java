package pt.up.fe.ldts.gd;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Shop {
    private final List<Item> items;

    public Shop(List<Item> items) {
        this.items = new ArrayList<>(items);
    }

    public boolean buyItem(Player player, String item_name) {
        for(Item item: items) {
            if(item.getName().equals(item_name) && player.getGold() >= item.getValue()) {
                player.addItem(item);
                player.setGold(player.getGold() - item.getValue());
                items.remove(item);
                return true;
            }
        }
        return false;
    }

    public List<Item> getItems(){
        return items;
    }
}
