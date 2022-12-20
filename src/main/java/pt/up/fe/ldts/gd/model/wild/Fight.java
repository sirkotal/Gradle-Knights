package pt.up.fe.ldts.gd.model.wild;

import pt.up.fe.ldts.gd.model.player.Player;

import java.util.Arrays;
import java.util.List;

public class Fight {
    private final Player player;
    private Enemy enemy;
    private final List<String> options;

    public Fight(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        this.options= Arrays.asList("1: Run Away", "2: Fight", "0: Menu");
    }

    public int resultFight() {
        while (player.isAlive() && enemy.isAlive()) {
            player.setHP(player.getHP() - enemy.getDamage());
            enemy.setHP(enemy.getHP() - player.getDamage());
        }

        int loot = 0;
        if (player.isAlive()) {
            loot = enemy.getGold();
            enemy.loot(player);
        }

        return loot;
    }

    public Player getPlayer() {
        return player;
    }

    public List<String> getOptions() {
        return options;
    }
}
