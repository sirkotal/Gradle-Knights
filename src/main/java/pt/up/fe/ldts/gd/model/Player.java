package pt.up.fe.ldts.gd.model;

// Stub class to develop Enemy
public class Player {
    private int gold;
    private int atk;
    private int hp;

    public Player() {
        this.gold = 10;
        this.atk = 10;
        this.hp = 100;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
