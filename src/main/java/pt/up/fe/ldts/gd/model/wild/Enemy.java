package pt.up.fe.ldts.gd.model.wild;

import pt.up.fe.ldts.gd.model.Player;

import java.util.Random;

public class Enemy {
    private int hp;
    private int damage;

    public Enemy(int hp, int base_damage, int max_damage) {
        this.hp = hp;
        Random rand = new Random();
        this.damage = base_damage;
        this.damage += rand.nextInt(max_damage - base_damage);
    }

    public void loot(Player player) {
        Random rand = new Random();
        int gold_base = 5;
        int gold = rand.nextInt(10) + gold_base;

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
}
