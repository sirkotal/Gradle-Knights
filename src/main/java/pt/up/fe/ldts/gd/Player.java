package pt.up.fe.ldts.gd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;

    private int hp = 100;

    private int atk;

    private int def;

    private int gold = 50;

    private List<Item> inventory = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }


}