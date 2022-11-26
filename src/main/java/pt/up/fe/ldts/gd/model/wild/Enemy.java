package pt.up.fe.ldts.gd.model.wild;

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
