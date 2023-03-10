package pt.up.fe.ldts.gd.model.player;

import pt.up.fe.ldts.gd.AsciiReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {
    private final Player player;
    private final List<Item> items;
    private List<String> options;
    private final List<String> lines;

    public Inventory(Player player) throws IOException {
        this.player = player;
        this.items = new ArrayList<>();
        this.options = new ArrayList<>(Arrays.asList("9: Exit", "0: Menu"));
        this.lines = AsciiReader.readAscii("/ascii/inventory/inventory.txt");
    }

    public List<Item> getItems(){
        return items;
    }

    public List<String> getOptions() {
        return this.options;
    }

    public List<String> getLines() {
        return lines;
    }

    public Player getPlayer() {
        return player;
    }

    public void addItem(Item item) {
        boolean found = false;
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).equals(item)) {
                found = true;
                items.get(i).setCount(item.getCount() + 1);
            }
        }

        if(!found)
            items.add(item);

        refreshOptions();
    }

    public void removeItem(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).equals(item) && items.get(i).getCount() != 1) {
                items.get(i).setCount(item.getCount() - 1);
                refreshOptions();
                return;
            }
        }

        items.remove(item);
        refreshOptions();
    }

    public Item getItem(int pos) {
        return items.get(pos);
    }

    public int size() {
        return this.items.size();
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public void refreshOptions() {
        this.options = new ArrayList<>();
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).isUsed())
                this.options.add((i+1) + ": " + items.get(i).getNameEquipped() + " (" + items.get(i).getValue() + "/" + items.get(i).getCount() + ")");
            else
                this.options.add((i+1) + ": " + items.get(i).getName() + " (" + items.get(i).getValue() + "/" + items.get(i).getCount() + ")");
        }
        this.options.add("9: Exit");
        this.options.add("0: Menu");
    }
}
