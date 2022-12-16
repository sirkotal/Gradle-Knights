package pt.up.fe.ldts.gd.model.player;

import pt.up.fe.ldts.gd.model.wild.Enemy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Fight {
    private final Player player;
    private List<Enemy> enemies;
    private List<String> options;
    public Fight(Player player,List<Enemy> enemies){
        this.player=player;
        this.enemies=enemies;
        options= Arrays.asList("1: Run Away", "2: Fight", "0: Menu");
    }
    public void resultFight() {
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

        if (player.isAlive()) {
            //message = ("You fought an enemy and you won! You won " + enemies.get(num_enemy).getGold() + " gold!");
            enemies.get(num_enemy).loot(player);
            enemies.remove(num_enemy);
        }
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
