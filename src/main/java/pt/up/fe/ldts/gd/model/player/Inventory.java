package pt.up.fe.ldts.gd.model.player;

import pt.up.fe.ldts.gd.model.town.Town;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory {
    private Player player;
    private List<Item> items;
    private List<String> options;
    private List<String> lines;

    public Inventory(Player player) throws IOException {
        this.player = player;
        this.items = new ArrayList<>();
        this.options = new ArrayList<>(Arrays.asList("9: Exit", "0: Menu"));
        this.lines = readAscii();
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

    private List<String> readAscii() throws IOException {
        List<String> lines = new ArrayList<>();
        URL resource = Town.class.getResource("/ascii/inventory/inventory.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        for(String line; (line = br.readLine()) != null;)
            lines.add(line);

        return lines;
    }
}
