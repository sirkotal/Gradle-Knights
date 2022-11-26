package pt.up.fe.ldts.gd;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Item> items;
    public Shop(){
        items = new ArrayList<>();
    }
    public void removeItem(Item i){
        int pos = items.indexOf(i);
        items.remove(pos);
    }
    public void addItem(Item i){
        items.add(i);
    }
    public List<Item> getItems(){
        return items;
    }
}
