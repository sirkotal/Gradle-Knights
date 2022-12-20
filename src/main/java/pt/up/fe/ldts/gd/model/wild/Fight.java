package pt.up.fe.ldts.gd.model.wild;

import pt.up.fe.ldts.gd.model.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Fight {
    private final Player player;
    private final List<Enemy> enemies;
    private final List<String> options;
    public Fight(Player player,List<Enemy> enemies){
        this.player=player;
        this.enemies=enemies;
        options= Arrays.asList("1: Run Away", "2: Fight", "0: Menu");
    }
    public int resultFight() {
        Random rand = new Random();
        int num_enemy;

        if (enemies.size() == 1) {
            num_enemy = 0;
        } else {
            num_enemy = rand.nextInt(enemies.size() - 1);
        }

        while (player.isAlive() && enemies.get(num_enemy).isAlive()) {
            player.setHP(player.getHP() - enemies.get(num_enemy).getDamage());
            enemies.get(num_enemy).setHP(enemies.get(num_enemy).getHP() - player.getDamage());
        }

        int loot = 0;
        if (player.isAlive()) {
            loot = enemies.get(num_enemy).getGold();
            enemies.get(num_enemy).loot(player);
            enemies.remove(num_enemy);
        }

        return loot;
    }

    public Player getPlayer() {
        return player;
    }

    public List<String> getOptions() {
        return options;
    }
    public List<Enemy> getEnemies(){
        return enemies;
    }
}
