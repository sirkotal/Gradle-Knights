package pt.up.fe.ldts.gd;

import pt.up.fe.ldts.gd.gui.LanternaGUI;
import pt.up.fe.ldts.gd.model.menu.Menu;
import pt.up.fe.ldts.gd.state.State;
import pt.up.fe.ldts.gd.state.menu.MenuState;

import java.io.IOException;

public class Game {
    private State state;
    private State previousState;

    private final LanternaGUI gui;

    public Game() throws IOException {
        System.out.println("Welcome to Gradle Knights!");
        this.gui = new LanternaGUI(125, 50);
        this.state = new MenuState(new Menu());
    }

    public void setState(State state) {
        this.previousState = this.state;
        this.state = state;
    }

    public State getPreviousState() {
        return previousState;
    }

    public static void main(String[] args) throws IOException {
        new Game().start();
    }

    private void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while(this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if(sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gui.close();
    }
}
