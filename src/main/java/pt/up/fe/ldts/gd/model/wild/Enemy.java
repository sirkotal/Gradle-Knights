package pt.up.fe.ldts.gd.model.wild;

import pt.up.fe.ldts.gd.model.player.Player;

import java.util.Random;

public class Enemy {
    private int hp;
    private int damage;
    private final int gold;

    public Enemy(int hp, int gold, int base_damage, int max_damage) {
        this.hp = hp;
        Random rand = new Random();
        this.damage = base_damage;
        if(base_damage < max_damage)
            this.damage += rand.nextInt(max_damage - base_damage);

        this.gold = gold + rand.nextInt(10);
    }

    public void loot(Player player) {
        player.setGold(player.getGold() + gold);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getGold() {
        return gold;
    }
}
