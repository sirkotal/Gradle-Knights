package pt.up.fe.ldts.gd;

import pt.up.fe.ldts.gd.gui.LanternaGUI;
import pt.up.fe.ldts.gd.state.State;

import java.io.IOException;

public class Game {
    private State state;

    private final LanternaGUI gui;

    public Game() throws IOException {
        System.out.println("Welcome to Gradle Knights!");
        this.gui = new LanternaGUI(125, 50);
    }


    public void setState(State state) {
        this.state = state;
    }

    public static void main(String[] args) throws IOException {
        new Game();
    }
}
