package pt.up.fe.ldts.gd.model.town;

import pt.up.fe.ldts.gd.model.player.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Town {
    private Player player;
    private Shop shop;
    private TownStrategy strategy;
    private List<String> lines;
    private List<String> options;

    public Town(Player player) throws IOException {
        this.player = player;
        this.shop = createShop();
        this.lines = readAscii();

        this.options = Arrays.asList("1: Shop", "2: Wild", "3: Menu");

        Random rand = new Random();
        int random = rand.nextInt(10);
        if(random > 7)
            this.strategy = new ExpensiveStrategy();
        else
            this.strategy = new CheapStrategy();
    }

    public List<String> getLines() {
        return this.lines;
    }
    public List<String> getOptions() {
        return this.options;
    }

    // to be implemented
    private Shop createShop() {
        return new Shop(new ArrayList<>());
    }

    private List<String> readAscii() throws IOException {
        List<String> lines = new ArrayList<>();
        URL resource = Town.class.getResource("/ascii/town/town.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        for(String line; (line = br.readLine()) != null;)
            lines.add(line);

        return lines;
    }

    public boolean buyItem(String itemName) {
        return strategy.buyItem(shop, player, itemName);
    }
}
