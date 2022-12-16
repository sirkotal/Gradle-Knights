package pt.up.fe.ldts.gd.model.wild;

import pt.up.fe.ldts.gd.model.player.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Wild {
    private Player player;
    private List<Enemy> enemies;
    private List<String> lines;
    private List<String> options;
    private String message;

    public Wild(Player player) throws IOException {
        this.player = player;
        this.enemies = createEnemies();
        this.lines = readAscii();
        this.options = Arrays.asList("1: Continue", "2: Inventory", "0: Menu");
        this.message=("Be careful! There are monsters in here!");
    }

    public Player getPlayer() {
        return this.player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
    
    public void fight() {
        Random rand = new Random();
        int num_enemy;

        if (enemies.size() == 1) {
            num_enemy = 0;
        }
        else {
            num_enemy = rand.nextInt(enemies.size() - 1);
        }

        while (player.isAlive() && enemies.get(num_enemy).isAlive()) {
            player.setHP(player.getHP() - enemies.get(num_enemy).getDamage());
            enemies.get(num_enemy).setHP(enemies.get(num_enemy).getHP() - player.getDamage());
        }

        if (player.isAlive()) {
            message=("You fought an enemy and you won! You won "+enemies.get(num_enemy).getGold()+" gold!");
            enemies.get(num_enemy).loot(player);
            enemies.remove(num_enemy);
        }
    }

    public List<String> getLines() {
        return this.lines;
    }

    public List<String> getOptions() {
        return options;
    }

    private List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        Random rand = new Random();
        int num_enemies = rand.nextInt(2) + 1;
        for(int i = 0; i < num_enemies; i++) {
            enemies.add(new Enemy(10,10,30,40));
        }
        return enemies;
    }

    private List<String> readAscii() throws IOException {
        List<String> lines = new ArrayList<>();
        URL resource = Wild.class.getResource("/ascii/wild/wild.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        for(String line; (line = br.readLine()) != null;)
            lines.add(line);

        return lines;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
