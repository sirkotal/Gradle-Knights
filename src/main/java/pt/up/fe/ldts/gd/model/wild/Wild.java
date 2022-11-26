package pt.up.fe.ldts.gd.model.wild;

import pt.up.fe.ldts.gd.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wild {
    private Player player;
    private List<Enemy> enemies;
    public Wild(Player player){
        this.player=player;
        Random rand = new Random();
        this.enemies = new ArrayList<>();
        int num_enemies = rand.nextInt(3);
        for (int i=0; i<num_enemies;i++){
            enemies.add(new Enemy(10,10,10,20));
        }
    }
    
    public void fight (Player player){
        Random rand = new Random();
        int num_enemies = rand.nextInt(3);
        if (enemies.get(num_enemies).getHp()/player.getAtk() > player.getHp()/enemies.get(num_enemies).getDamage()){
            //GAMEOVER;
        }
        else {
            enemies.get(num_enemies).loot(player);
            enemies.remove(num_enemies);
        }
    }
}
