package pt.up.fe.ldts.gd.controller;

import pt.up.fe.ldts.gd.Game;
import pt.up.fe.ldts.gd.gui.GUI;
import pt.up.fe.ldts.gd.model.wild.Wild;
import pt.up.fe.ldts.gd.state.MenuState;
import pt.up.fe.ldts.gd.model.menu.Menu;
import java.io.IOException;


public class WildController extends Controller<Wild> {
    public WildController(Wild wild) {
        super(wild);
    }

    public void step(Game game, GUI.ACTION action) throws IOException {
        if (action == GUI.ACTION.QUIT || !getModel().getPlayer().isAlive()) {
                game.setState(new MenuState(new Menu()));
        }
        else {

        }
    }
}
