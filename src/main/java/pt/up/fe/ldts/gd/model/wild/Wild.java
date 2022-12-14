package pt.up.fe.ldts.gd.model.wild;

import pt.up.fe.ldts.gd.model.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wild {
    private Player player;
    private List<Enemy> enemies;

    private Random rand = new Random();
    public Wild(Player player) {
        this.player = player;
        this.enemies = new ArrayList<>();
    }

    public void createEnemies() {
        int num_enemies = rand.nextInt(2) + 1;
        for(int i = 0; i < num_enemies; i++) {
            enemies.add(new Enemy(10,10,10,20));
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
    
    public void fight(Player player) {
        Random rand = new Random();
        boolean flag = true;
        int num_enemy;

        while (flag) {
            if(enemies.size() == 1)
                num_enemy = 0;
            else
                num_enemy = rand.nextInt(enemies.size() - 1);

            int player_atk = enemies.get(num_enemy).getHP() / player.getDamage();
            int enemy_atk = player.getHP() / enemies.get(num_enemy).getDamage();

            for (int i = 0; i < enemies.size(); i++) {
                player.setHP(player.getHP() - player_atk * enemies.get(i).getDamage());
            }
            enemies.get(num_enemy).setHP(enemies.get(num_enemy).getHP() - enemy_atk * player.getDamage());

            if (!player.isAlive()) {
                flag = false;
                /* YOU DEAD, BOI */
            }

            if(!enemies.get(num_enemy).isAlive()) {
                flag = false;
                enemies.get(num_enemy).loot(player);
                enemies.remove(num_enemy);
            }
        }
    }
}
