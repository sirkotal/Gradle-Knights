package pt.up.fe.ldts.gd;

import pt.up.fe.ldts.gd.gui.LanternaGUI;

import java.io.IOException;

public class Game {
    private final LanternaGUI gui;

    public Game() throws IOException {
        System.out.println("Welcome to Gradle Knights!");
        this.gui = new LanternaGUI(125, 50);
    }

    public static void main(String[] args) throws IOException {
        new Game();
    }
}
